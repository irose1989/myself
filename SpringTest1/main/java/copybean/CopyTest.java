package copybean;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * Created by wb-chenchaobin on 2015/12/18.
 */
public class CopyTest {
    private UserDo userDo;
    private UserVo vo;
    @Before
    public void before(){
        userDo = new UserDo();
        vo = new UserVo();
    }
    @Test
    public void test1(){
        userDo.setName("chen");
        userDo.setAge(123);
        userDo.setBirthday(new Date());
        BeanUtils.copyProperties(userDo,vo);
        System.out.println(vo);
    }
    @Test
    public void test2(){
        vo.setName("chen");
        vo.setAge(123l);
        BeanUtils.copyProperties(vo,userDo);
        System.out.println(userDo);
    }
    @Test
    public void test3(){
        userDo.setName("chen");
        userDo.setAge(123);
        userDo.setBirthday(new Date());
        GirlFriend gf  =new GirlFriend();
        gf.setName("zhao");
        userDo.setGf(gf);
        BeanUtils.copyProperties(userDo,vo);
        System.out.println(vo);
    }
    @Test
    public void test4(){
        userDo.setName("chen");
        userDo.setId(1);
        userDo.setAge(123);
        userDo.setBirthday(new Date());
        GirlFriend gf  =new GirlFriend();
        gf.setName("zhao");
        gf.setId(1);
        userDo.setGf(gf);
        BeanUtils.copyProperties(userDo,vo);
        System.out.println(vo);
    }
}
