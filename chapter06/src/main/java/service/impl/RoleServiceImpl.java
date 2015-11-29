package service.impl;

import dao.role.RoleMapper;
import dao.rolePermission.RolePermissionMapper;
import entity.role.Role;
import entity.role.RoleExample;
import entity.rolePermission.RolePermissionKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.RoleService;

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

    public void correlationPermissions(Long roleId, Long permissionId) {
        RolePermissionKey key = new RolePermissionKey();
        key.setPermissionId(permissionId);
        key.setRoleId(roleId);
        rolePermissionMapper.insertSelective(key);
    }

    public void uncorrelationPermissions(Long roleId, Long permissionId) {

    }
}
