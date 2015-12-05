package credentials;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheFactoryBean;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wb-chenchaobin on 2015/12/1.
 */
public class RetryLimitMather extends HashedCredentialsMatcher {

    private Cache ehCache;
    @Autowired
    private EhCacheFactoryBean simpleCache;

    public RetryLimitMather() {
        System.out.println("RetryLimitMather is construct....");
//        ehCache = (Cache) simpleCache.getObject();----------------错误，注入是构造行数先
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        ehCache = (Cache) simpleCache.getObject();
        System.out.println("doCredentialsMatch......");
        String username = (String) token.getPrincipal();
        Element element = ehCache.get(username);
        if(element == null){
            element = new Element(username,new AtomicInteger(0));
            ehCache.put(element);
        }
        AtomicInteger count= (AtomicInteger) element.getObjectValue();
        if(count.incrementAndGet()>5){
            throw new ExcessiveAttemptsException("尝试次数过多，请稍后再试");
        }
        boolean match = super.doCredentialsMatch(token,info);
        if(match){
            ehCache.remove(username);
        }
        return match;
    }
}
