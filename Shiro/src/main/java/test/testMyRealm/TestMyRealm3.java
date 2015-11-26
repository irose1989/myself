package test.testMyRealm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by wb-chenchaobin on 2015/11/26.
 */
public class TestMyRealm3 implements Realm {
    public String getName() {
        return "TestMyRealm3";
    }

    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[])authenticationToken.getCredentials());
        if(!"zhang".equals(username)){
            throw new UnknownAccountException();
        }
        if(!"123".equals(password)){
            throw new IncorrectCredentialsException();
        }
        System.out.println("登入成功:"+getName());
        return new SimpleAuthenticationInfo(username+"163.com",password,getName());
    }
}
