package test.encode_decode.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * Created by Administrator on 2015/11/28.
 */
public class MyRealm2 extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username="liu";
        String password="6e80f2ccdc1e367acf44af493aa5804f";
        String salt="d8da12d0f94eea9014571380357677b3";
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,password, ByteSource.Util.bytes(username + salt),getName());
        return info;
    }
}
