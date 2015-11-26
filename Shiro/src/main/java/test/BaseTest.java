package test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Created by wb-chenchaobin on 2015/11/26.
 */
public class BaseTest {

    public void login(String config,String username,String password){
        Factory<org.apache.shiro.mgt.SecurityManager>factory = new IniSecurityManagerFactory(config);
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
        }catch (AuthenticationException e){
            System.out.println("登入失败");
        }
        //subject.login(token);

    }


    public Subject getSubject(){
        return SecurityUtils.getSubject();
    }
}
