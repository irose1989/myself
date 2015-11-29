package service;

import entity.permission.Permission;

/**
 * Created by Administrator on 2015/11/29.
 */
public interface PermissionService {
    public void createPermission(Permission permission);
    public void deletePermission(Long permissionId);
    public Permission getPermission(String permission);
}
