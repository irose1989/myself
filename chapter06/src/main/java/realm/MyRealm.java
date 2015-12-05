package realm;

import dao.entity.permission.Permission;
import dao.entity.user.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;
import service.vo.RoleVO;
import service.vo.UserVO;

import java.util.List;

/**
 * Created by Administrator on 2015/11/29.
 */
public class MyRealm extends AuthorizingRealm{
    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权中");
        String username = (String) principalCollection.getPrimaryPrincipal();
        UserVO vo = userService.findPermissions(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<RoleVO> roleVOs = vo.getRoleList();
        for (RoleVO roleVO:roleVOs){
            info.addRole(roleVO.getRole().getRole());
            List<Permission> permissionList = roleVO.getPermissionList();
            for(Permission p:permissionList){
                info.addStringPermission(p.getPermission());
            }
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("身份验证中");
        String username = (String) token.getPrincipal();
        User user = userService.findByUsername(username);
        if(user==null){
            System.out.println("没有该账户");
            throw new UnknownAccountException("没有该账号");
        }
        if(user.getLocked()==1){
            System.out.println("该账户被锁定");
            throw new LockedAccountException("该账户被锁定");
        }
        String passwrod = user.getPassword();
        String salt = user.getSalt();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,passwrod,getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(username+salt));
        return info;
    }
}
