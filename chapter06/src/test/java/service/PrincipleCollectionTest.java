package service;

import dao.entity.user.User;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.Collection;

/**
 * Created by wb-chenchaobin on 2015/12/2.
 */
public class PrincipleCollectionTest extends BaseTest{
    @Test
    public void testPrinciples(){
        login("classpath:ini/shiro_principal.ini","zhang","123");
        Subject subject = subject();
        System.out.println(subject.getPrincipal());
        PrincipalCollection collection = subject.getPrincipals();
        System.out.println(collection.asList());
        System.out.println(collection.asSet());
        System.out.println("PrimaryPrincipal:"+collection.getPrimaryPrincipal());
        Collection<User>users = collection.fromRealm("c");
        System.out.println(users);
    }
}
