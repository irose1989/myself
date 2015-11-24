package MyRealm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by wb-chenchaobin on 2015/11/24.
 */
public class MyRealm1 implements Realm {
    public String getName() {
        return "myrealm1";
    }

    public boolean supports(AuthenticationToken authenticationToken) {

        return authenticationToken instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        String pwd =  new String((char[])authenticationToken.getCredentials());
        if(!"zhang".equals(userName)) {
            throw new UnknownAccountException(); //如果用户名错误
        }
        if(!"123".equals(pwd)) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(userName, pwd, getName());
    }
}
