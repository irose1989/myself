package chapter1;

import chapter1.bean.Singleton;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wb-chenchaobin on 2015/12/15.
 * TODO 两个classloader加载的单例 是同一个？？？
 */
public class SingletonTest {
    @Test
    public void test1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException {
//        ClassLoader loader1 = Thread.currentThread().getContextClassLoader();
        ClassLoader loader1 = new SingletonClassloader();
        Class clazz = loader1.loadClass("chapter1.bean.Singleton");
        Method getSingleton = clazz.getDeclaredMethod("getSingleton");
        Singleton singleton = (Singleton) getSingleton.invoke(clazz);
        Field countField = clazz.getDeclaredField("count");
        countField.setAccessible(true);
        Integer count = (Integer) countField.get(singleton);
        System.out.println(count);
        countField.set(singleton,count+1);
        System.out.println(countField.get(singleton));
        Assert.assertEquals(1,countField.get(singleton));

        ClassLoader loader2 = new SingletonClassloader();
//        ClassLoader loader2 =  Thread.currentThread().getContextClassLoader();
        Class clazz2 = loader2.loadClass("chapter1.bean.Singleton");
        Method getSingleton2 =clazz2.getMethod("getSingleton");
        Singleton singleton2 = (Singleton) getSingleton2.invoke(clazz2);
        Field countField2 = clazz2.getDeclaredField("count");
        countField2.setAccessible(true);
        Integer count2 = (Integer) countField2.get(singleton2);
        System.out.println(count2);
        countField2.set(singleton2,count2+1);
        System.out.println(countField2.get(singleton2));
        Assert.assertEquals(2,countField2.get(singleton2));
        System.out.println(loader1==loader2);
        System.out.println(singleton==singleton2);

    }
    @Test
    public void test2() throws Exception {

    }
}
