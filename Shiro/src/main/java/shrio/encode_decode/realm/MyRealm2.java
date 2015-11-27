package shrio.encode_decode.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * Created by wb-chenchaobin on 2015/11/27.
 */
public class MyRealm2 extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username="liu";
        String password="a9a114054aa6758184314fbb959fbda4";
        String salt2 = "24520ee264eab73ec09451d0e9ea6aac";
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,password,getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(username+salt2));
        return info;
    }
}
