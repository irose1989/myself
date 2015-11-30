package service.impl;

import dao.permission.PermissionMapper;
import dao.entity.permission.Permission;
import dao.entity.permission.PermissionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.PermissionService;

import java.util.List;

/**
 * Created by Administrator on 2015/11/29.
 */
@Component
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper mapper;
    public void createPermission(Permission permission) {
        mapper.insertSelective(permission);
    }

    public void deletePermission(Long permissionId) {
        mapper.deleteByPrimaryKey(permissionId);
    }

    public Permission getPermission(String permission) {
        PermissionExample example = new PermissionExample();
        example.createCriteria().andPermissionEqualTo(permission);
        List<Permission> list = mapper.selectByExample(example);
        return list.get(0);
    }

    public Permission getPsermission(long permissionId) {
        Permission permission = mapper.selectByPrimaryKey(permissionId);
        return permission;
    }
}
