package test.authorizer.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * Created by wb-chenchaobin on 2015/11/27.
 */
public class BitAndWildPermissionResolver implements PermissionResolver {
    @Override
    public Permission resolvePermission(String s) {
        if(s.startsWith("+")){
            return  new BitPermission(s);
        }
        return new WildcardPermission(s);
    }
}
