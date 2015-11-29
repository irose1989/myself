package test.encode_decode;

import com.sun.javafx.css.converters.EnumConverter;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.AbstractConverter;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.junit.Assert;
import org.junit.Test;
import test.BaseTest;

/**
 * Created by Administrator on 2015/11/28.
 */
public class EncodeDecodeTest extends BaseTest{
    @Test
    public void testBase64(){
        String str ="liu";
        String encode = Base64.encodeToString(str.getBytes());
        System.out.println("encode:" + encode);
        String decode = Base64.decodeToString(encode);
        System.out.println("decode:"+decode);
        Assert.assertEquals(str,decode);
    }
    @Test
    public void testHex16(){
        String str = "liu";
        String encode = Hex.encodeToString(str.getBytes());
        System.out.println("encode:" + encode);
        String decode = new String(Hex.decode(encode));
        System.out.println("decode:" + decode);
    }
    @Test
    public void testMd5(){
        String str = "liu";
        String salt ="123";
        String md5Str = new Md5Hash(str,salt,2).toHex();
        System.out.println("md5:"+md5Str);
        String md5Str2 = new Md5Hash(str,salt,2).toString();
        System.out.println("md52:"+md5Str2);
    }
    @Test
    public void testPasswordService(){
        login("classpath:test/encode_decode/shiro-passwordService.ini", "liu", "123");
    }
    @Test
    public void testPasswordJdbcService(){
        login("classpath:test/encode_decode/shiro-jdbc-passwordService.ini","wu","123");
    }
    @Test
    public void testGeneratePassword(){
        String username="liu";
        String password="123";
        String salt1=username;
        String salt2=new SecureRandomNumberGenerator().nextBytes().toHex();
        String algorithmName="MD5";
        int hashIterators=2;
        String encode = new SimpleHash(algorithmName,password,salt1+salt2,hashIterators).toHex();
        System.out.println(salt2);
        System.out.println(encode);
    }
    @Test
    public void testHashedCredentialsMatcherWithMyrealm2() {
        login("classpath:test/encode_decode/shiro-hashedCredentialsMatcher.ini","liu","123");
    }
    @Test
    public void testHashedCredentialsMatcherWithJdbcRealm(){
        BeanUtilsBean.getInstance().getConvertUtils().register(new EnumConverter(),JdbcRealm.SaltStyle.class);
        login("classpath:test/encode_decode/shiro-jdbc-hashedCredentialsMatcher.ini","liu","123");
    }
    private class EnumConverter extends AbstractConverter {
        @Override
        protected String convertToString(final Object value) throws Throwable {
            return ((Enum) value).name();
        }
        @Override
        protected Object convertToType(final Class type, final Object value) throws Throwable {
            return Enum.valueOf(type, value.toString());
        }

        @Override
        protected Class getDefaultType() {
            return null;
        }

    }
}
