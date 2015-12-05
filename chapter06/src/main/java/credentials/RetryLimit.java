package credentials;

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
 * Created by wb-chenchaobin on 2015/12/2.
 */
public class RetryLimit extends HashedCredentialsMatcher {
    @Autowired
    private EhCacheFactoryBean simpleCache;
    private Ehcache ehcache ;

    public RetryLimit() {}

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        ehcache =simpleCache.getObject();
        String username = (String) token.getPrincipal();
        Element element = ehcache.get(username);
        if(element==null){
            element = new Element(username,new AtomicInteger(0));
            ehcache.put(element);
        }
        AtomicInteger count = (AtomicInteger) element.getObjectValue();
        if(count.incrementAndGet()>5){
            throw new ExcessiveAttemptsException("尝试次数过多，请稍后重试");
        }
        boolean match = super.doCredentialsMatch(token, info);
        if(match){
            ehcache.remove(username);
        }
        return match;
    }
}
