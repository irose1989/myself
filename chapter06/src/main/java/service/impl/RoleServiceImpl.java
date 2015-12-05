package service.impl;

import dao.entity.permission.Permission;
import dao.entity.rolePermission.RolePermissionExample;
import dao.role.RoleMapper;
import dao.rolePermission.RolePermissionMapper;
import dao.entity.role.Role;
import dao.entity.role.RoleExample;
import dao.entity.rolePermission.RolePermissionKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.PermissionService;
import service.RoleService;
import service.vo.RoleVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/29.
 */
@Component
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper mapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private PermissionService permissionService;
    public void createRole(Role role) {
        mapper.insert(role);
    }

    public void deleteRole(Long roleId) {
        mapper.deleteByPrimaryKey(roleId);
    }

    public Role getRole(String role) {
        RoleExample example = new RoleExample();
        example.createCriteria().andRoleEqualTo(role);
        List<Role> list = mapper.selectByExample(example);
        return list.get(0);
    }
    public Role getRole(Long id){
        Role role = mapper.selectByPrimaryKey(id);
        return role;
    }

    public void correlationPermissions(Long roleId, Long permissionId) {
        RolePermissionKey key = new RolePermissionKey();
        key.setPermissionId(permissionId);
        key.setRoleId(roleId);
        rolePermissionMapper.insertSelective(key);
    }

    public void uncorrelationPermissions(Long roleId, Long permissionId) {

    }

    public List<RolePermissionKey> getPermissionByRoleId(Long roleId) {
        RolePermissionExample example = new RolePermissionExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<RolePermissionKey> list = rolePermissionMapper.selectByExample(example);
        return list;
    }

    public RoleVO getPermissions(Long roleId) {
        RoleVO roleVO = new RoleVO();
        List<Permission>permissionList = new ArrayList<Permission>();
        List<RolePermissionKey> keys = getPermissionByRoleId(roleId);
        for(RolePermissionKey key:keys){
            long permissionId = key.getPermissionId();
            Permission permission = permissionService.getPsermission(permissionId);
            permissionList.add(permission);
        }
        roleVO.setPermissionList(permissionList);
        return roleVO;
    }
}
