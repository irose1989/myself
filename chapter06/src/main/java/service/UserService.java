package service;

import entity.user.User;

import java.util.Set;

/**
 * Created by Administrator on 2015/11/29.
 */
public interface UserService {
    /**
     * 创建用户
     * @param user
     * @return
     */
    public void createUser(User user);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId,String newPassword);

    /**
     * 添加用户角色关系
     * @param userId
     * @param roleId
     */
    public void correlationRole(long userId,long roleId);

    /**
     * 移除用户-角色关系
     * @param userId
     * @param roleIds
     */
    public void uncorrelationRoles(Long userId, Long... roleIds);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username);

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username);

}
