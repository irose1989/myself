package service;

import dao.entity.role.Role;
import dao.entity.rolePermission.RolePermissionKey;
import service.vo.RoleVO;

import java.util.List;

/**
 * Created by Administrator on 2015/11/29.
 */
public interface RoleService {

    public void createRole(Role role);
    public void deleteRole(Long roleId);
    public Role getRole(String role);
    public Role getRole(Long id);

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

    public List<RolePermissionKey> getPermissionByRoleId(Long roleId);

    public RoleVO getPermissions(Long roleId);

}
