package shrio.encode_decode;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Assert;
import org.junit.Test;
import shrio.BaseLogin;

/**
 * Created by wb-chenchaobin on 2015/11/27.
 */
public class DecodeEncodeTest extends BaseLogin{
    /**base64*/
    @Test
    public void test1(){
        String str = "hello";
        String encode = Base64.encodeToString(str.getBytes());
        String decode = Base64.decodeToString(encode);
        Assert.assertEquals(str,decode);
    }
    /**16进制*/
    @Test
    public void test2(){
        String str = "hello";
        String encode = Hex.encodeToString(str.getBytes());
        String decode = new String(Hex.decode(encode));
        Assert.assertEquals(str,decode);
    }
    /**MD5*/
    @Test
    public void test3(){
        String str = "liu";
        String password ="123";
        String salt= "123";
        String md5 = new Md5Hash(password,null,2).toHex();
        System.out.println(md5);
//        System.out.println(md5);
//        md5 = new Md5Hash(str,salt).toString();
//        System.out.println(md5);
//
//        md5 = new Md5Hash(str,salt,2).toString();
//        System.out.println(md5);
    }
    /**SHA256*/
    @Test
    public void test4(){
        String str = "liu";
        String salt = "123";
        String shaStr = new Sha256Hash(str,salt).toString();
        System.out.println(shaStr);
    }
    @Test
    public void testPasswordService() {
        login("classpath:shiro/encode-decode/shiro-passwordService.ini", "wu", "123");
    }
    @Test
    public  void testJdbcPasswordService(){
        login("classpath:shiro/encode-decode/shiro-jdbc-passwordService.ini","wu","123");
    }
    @Test
    public void testGeneratePassword(){
        String algorithmName="MD5";
        String userName = "liu";
        String password = "123";
        String salt1=userName;
        String salt2=new SecureRandomNumberGenerator().nextBytes().toHex();
        int hashIterators =2 ;
        SimpleHash hash = new SimpleHash(algorithmName,password,salt1+salt2,hashIterators);
        String encodePwd = hash.toHex();
        System.out.println(salt2);
        System.out.println(encodePwd);
    }
    @Test
    public void testHashedCredentialsMatcher(){
        login("classpath:shiro/encode-decode/shiro-hashedCredentialsMatcher.ini","liu","123");
    }
    @Test
    public void testHashedCredentialsJdbcMatcher(){

    }
}
