package test;

import entity.permission.Permission;
import entity.role.Role;
import entity.user.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.PermissionService;
import service.RoleService;
import service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring_mybatis.xml"})
public class BaseTest {

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
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

    @Test
    public void setUp() {
//        ApplicationContext factory=new ClassPathXmlApplicationContext("classpath:spring_mybatis.xml");
//        PermissionServiceImpl permissionService =factory.getBean("permissionService", PermissionServiceImpl.class);
        //1������Ȩ��
        p1 = new Permission("user:create", "�û�ģ������", Boolean.TRUE);
        p2 = new Permission("user:update", "�û�ģ���޸�", Boolean.TRUE);
        p3 = new Permission("menu:create", "�˵�ģ������", Boolean.TRUE);
        permissionService.createPermission(p1);
        permissionService.createPermission(p2);
        permissionService.createPermission(p3);
        //2��������ɫ
        r1 = new Role("admin", "����Ա", 1);
        r2 = new Role("user", "�û�����Ա", 1);
        roleService.createRole(r1);
        roleService.createRole(r2);
        //3��������ɫ-Ȩ��
        r1 = roleService.getRole(r1.getRole());
        r2 = roleService.getRole(r1.getRole());
        p1 = permissionService.getPermission(p1.getPermission());
        p2 = permissionService.getPermission(p2.getPermission());
        p3 = permissionService.getPermission(p3.getPermission());


        roleService.correlationPermissions(r1.getId(), p1.getId());
        roleService.correlationPermissions(r1.getId(), p2.getId());
        roleService.correlationPermissions(r1.getId(), p3.getId());

        roleService.correlationPermissions(r2.getId(), p1.getId());
        roleService.correlationPermissions(r2.getId(), p2.getId());

        //4�������û�
        u1 = new User("zhang", password);
        u2 = new User("li", password);
        u3 = new User("wu", password);
        u4 = new User("wang", password);
        u4.setLocked(Boolean.TRUE);
        userService.createUser(u1);
        userService.createUser(u2);
        userService.createUser(u3);
        userService.createUser(u4);
        //5�������û�-��ɫ
        u1 = userService.findByUsername(u1.getUsername());
        userService.correlationRole(u1.getId(), r1.getId());
    }


//    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//�˳�ʱ������Subject���߳� ������´β������Ӱ��
    }

    protected void login(String configFile, String username, String password) {
        //1����ȡSecurityManager�������˴�ʹ��Ini�����ļ���ʼ��SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory(configFile);

        //2���õ�SecurityManagerʵ�� ���󶨸�SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3���õ�Subject�������û���/���������֤Token�����û����/ƾ֤��
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        subject.login(token);
    }

    public Subject subject() {
        return SecurityUtils.getSubject();
    }

}
