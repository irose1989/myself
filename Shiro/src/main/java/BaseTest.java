import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;

/**
 * Created by wb-chenchaobin on 2015/11/25.
 */
public class BaseTest {
    public void login(String config,String userName,String password){
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory(config);
        org.apache.shiro.mgt.SecurityManager manager = factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        subject.login(token);
    }
    public Subject getSubject(){
        return SecurityUtils.getSubject();
    }
}
