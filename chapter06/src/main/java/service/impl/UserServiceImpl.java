package service.impl;

import dao.entity.role.Role;
import dao.entity.rolePermission.RolePermissionKey;
import dao.user.UserMapper;
import dao.userRole.UserRoleMapper;
import dao.entity.user.User;
import dao.entity.user.UserExample;
import dao.entity.userRole.UserRoleExample;
import dao.entity.userRole.UserRoleKey;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import service.RoleService;
import service.UserService;
import service.util.PasswordHelp;
import service.vo.RoleVO;
import service.vo.UserVO;

import java.util.ArrayList;
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
    @Autowired
    private PasswordHelp passwordHelp;
    @Autowired
    private RoleService roleService;

    public UserServiceImpl(){
        System.out.println("UserServiceImpl....");
    }


    public void createUser(User user) {
        user = passwordHelp.encryptPassword(user);
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
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    public UserVO findRoles(String userName) {
        User u = findByUsername(userName);
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andUserIdEqualTo(u.getId());
        List<UserRoleKey>result = userRoleMapper.selectByExample(example);
        UserVO vo = new UserVO();
        vo.setUser(u);
        List<RoleVO>roleList = new ArrayList<RoleVO>();
        for (int i = 0; i < result.size(); i++) {
            long roleId = result.get(i).getRoleId();
            Role role = roleService.getRole(roleId);
            RoleVO roleVO = new RoleVO();
            roleVO.setRole(role);
            roleList.add(roleVO);
        }
        return vo;
    }

    public UserVO findPermissions(String username) {
        UserVO vo = findRoles(username);
        List<RoleVO>roleList = vo.getRoleList();
        for(RoleVO roleVo:roleList){
            Role role = roleVo.getRole();
            long roleId = roleVo.getRole().getId();
            RoleVO newRowVO = roleService.getPermissions(roleId);
            newRowVO.setRole(role);
            roleList.add(newRowVO);
        }
        vo.setRoleList(roleList);
        return vo;
    }
}
