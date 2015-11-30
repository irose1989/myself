package service.util;

import dao.entity.user.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Created by Administrator on 2015/11/29.
 */
public class PasswordHelp{
    private String algorithmName ="MD5";
    private final int hashIterations=2;
    public User encryptPassword(User user) throws IllegalArgumentException {

        String username=user.getUsername();
        String password=user.getPassword();
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();

        String newPassword = new SimpleHash(algorithmName,password,username+salt,hashIterations).toHex();
        user.setPassword(newPassword);
        user.setSalt(salt);
        return user;
    }

}
