package service.vo;

import dao.entity.permission.Permission;
import dao.entity.role.Role;

import java.util.List;

/**
 * Created by wb-chenchaobin on 2015/11/30.
 */
public class RoleVO {
    private Role role;
    private List<Permission> permissionList;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
