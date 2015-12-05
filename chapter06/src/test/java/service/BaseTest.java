package service;

import dao.entity.permission.Permission;
import dao.entity.role.Role;
import dao.entity.user.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring_mybatis.xml"})
public class BaseTest {

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private DefaultSecurityManager securityManager;

    protected String password = "123";

    protected Permission p1;
    protected Permission p2;
    protected Permission p3;
    protected Role r1;
    protected Role r2;
    protected User u1;
    protected User u2;
    protected User u3;
    protected User u4;

//    @Test
    public void setUp() {

        //1、新增权限
        p1 = new Permission("user:create", "用户模块新增", 1);
        p2 = new Permission("user:update", "用户模块修改", 1);
        p3 = new Permission("menu:create", "菜单模块新增", 1);
        permissionService.createPermission(p1);
        permissionService.createPermission(p2);
        permissionService.createPermission(p3);
        //2、新增角色
        r1 = new Role("admin", "管理员", 1);
        r2 = new Role("user", "用户管理员", 1);
        roleService.createRole(r1);
        roleService.createRole(r2);
        //3、关联角色-权限
        r1 = roleService.getRole(r1.getRole());
        r2 = roleService.getRole(r2.getRole());
        p1 = permissionService.getPermission(p1.getPermission());
        p2 = permissionService.getPermission(p2.getPermission());
        p3 = permissionService.getPermission(p3.getPermission());


        roleService.correlationPermissions(r1.getId(), p1.getId());
        roleService.correlationPermissions(r1.getId(), p2.getId());
        roleService.correlationPermissions(r1.getId(), p3.getId());

        roleService.correlationPermissions(r2.getId(), p1.getId());
        roleService.correlationPermissions(r2.getId(), p2.getId());

        //4、新增用户
        u1 = new User("zhang", password);
        u2 = new User("li", password);
        u3 = new User("wu", password);
        u4 = new User("wang", password);
        u4.setLocked(1);
        userService.createUser(u1);
        userService.createUser(u2);
        userService.createUser(u3);
        userService.createUser(u4);
        //5、关联用户-角色
        u1 = userService.findByUsername(u1.getUsername());
        userService.correlationRole(u1.getId(), r1.getId());
    }
    @Test
    public void findRole(){
        String role="admin";
        Role role1  = roleService.getRole(role);
        System.out.println(role1);
    }

    /**
     * mybatis 报错：invalid types () or values (). Cause: java.lang.NoSuchMethodException:
     1） Bean函数中的get/set方法与成员变量不一。
     2） 构造函数被重载过，但是没有空的构造函数。
     3） 最好不要使用简单类型，如int, long等，改用对象模式Integer, Long等。在写条件查询时会用到判断<if xxx != null > … </if>的
     */
//    @Test
    public void findRoleById(){
        long id = 1;
        Role role = roleService.getRole(id);
        System.out.println(role);
    }


    @After
    public void tearDown() throws Exception {
        System.out.println("unbindSubject...");
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }

    protected void login(String configFile, String username, String password) {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory(configFile);
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        }catch (AuthenticationException e){
            System.out.println("登入失败:"+e.getMessage());
        }
    }
    protected void loginWithSpringConfig(String username, String password){
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        }catch (AuthenticationException e){
            System.out.println("登入失败:"+e.getMessage());
        }
    }

    public Subject subject() {
        return SecurityUtils.getSubject();
    }

}
