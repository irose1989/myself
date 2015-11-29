package service.impl;

import dao.permission.PermissionMapper;
import entity.permission.Permission;
import entity.permission.PermissionExample;
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
}
