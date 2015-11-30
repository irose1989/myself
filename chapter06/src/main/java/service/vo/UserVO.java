package service.vo;

import dao.entity.permission.Permission;
import dao.entity.role.Role;
import dao.entity.user.User;

import java.util.List;

/**
 * Created by wb-chenchaobin on 2015/11/30.
 */
public class UserVO {
    private User user;
    private List<RoleVO> roleList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<RoleVO> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleVO> roleList) {
        this.roleList = roleList;
    }
}
