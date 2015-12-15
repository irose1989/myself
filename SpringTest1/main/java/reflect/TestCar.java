package reflect;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wb-chenchaobin on 2015/12/14.
 */
public class TestCar {
    @Test
    public void testCar(){
        Car car = new Car();
        car.setBrand("奥迪");
        car.setColor("black");
        car.setSpeed(100);
        System.out.println(car);
    }
    @Test
    public void testReflectCar(){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            Class clazz = loader.loadClass("reflect.Car");
            Constructor constructor = clazz.getDeclaredConstructor(null);
            try {
                 Car car = (Car)constructor.newInstance();
                Method setBrand = clazz.getMethod("setBrand", String.class);
                setBrand.invoke(car,"奥迪");
                Method setColor = clazz.getMethod("setColor",String.class);
                setColor.invoke(car,"black");
                Method setSpeed = clazz.getMethod("setSpeed",int.class);
                setSpeed.invoke(car,100);
                System.out.println(car);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void  testClassLoader(){
        ClassLoader loader  = Thread.currentThread().getContextClassLoader();
        System.out.println("loader:"+loader);
        System.out.println("loader parent:"+loader.getParent());
        System.out.println("loader parent parent:"+loader.getParent().getParent());
    }
    @Test
    public void testPrivate() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("reflect.PrivateCar");
        Constructor constructor = clazz.getDeclaredConstructor(null);
        PrivateCar car = (PrivateCar) constructor.newInstance();
//        Method setColor = clazz.getMethod("setColor",String.class);
//        setColor.invoke(car,"black");
        Field color = clazz.getDeclaredField("color");
//        Field color = clazz.getField("color");
        color.setAccessible(true);
        color.set(car,"black");
        System.out.println(car);
        Method show = clazz.getDeclaredMethod("show");
        show.setAccessible(true);
        show.invoke(car);
    }
    @Test
    public void testSpringXml() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:spring_aop.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        System.out.println("init factory");
        Car car = factory.getBean("car", Car.class);
        System.out.println(car);
    }
    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(reflect.Beans.class);
        Car car = (Car) context.getBean("car");
        System.out.println(car);
    }

}
