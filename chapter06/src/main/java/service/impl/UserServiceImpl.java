package service.impl;

import dao.user.UserMapper;
import dao.userRole.UserRoleMapper;
import entity.user.User;
import entity.user.UserExample;
import entity.userRole.UserRoleKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.UserService;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2015/11/29.
 */
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    public void createUser(User user) {
        mapper.insertSelective(user);
    }

    public void changePassword(Long userId, String newPassword) {

    }

    public void correlationRole(long userId, long roleId) {
        UserRoleKey key = new UserRoleKey();
        key.setRoleId(roleId);
        key.setUserId(userId);
        userRoleMapper.insertSelective(key);
    }

    public void uncorrelationRoles(Long userId, Long... roleIds) {

    }

    public User findByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> list = mapper.selectByExample(example);
        return list.get(0);
    }

    public Set<String> findRoles(String username) {
        return null;
    }

    public Set<String> findPermissions(String username) {
        return null;
    }
}
