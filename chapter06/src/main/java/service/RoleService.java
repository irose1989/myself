package service;

import entity.role.Role;

/**
 * Created by Administrator on 2015/11/29.
 */
public interface RoleService {

    public void createRole(Role role);
    public void deleteRole(Long roleId);
    public Role getRole(String role);

    /**
     * 添加角色-权限之间关系
     * @param roleId
     * @param permissionId
     */
    public void correlationPermissions(Long roleId, Long permissionId);

    /**
     * 移除角色-权限之间关系
     * @param roleId
     * @param permissionId
     */
    public void uncorrelationPermissions(Long roleId, Long permissionId);

}
