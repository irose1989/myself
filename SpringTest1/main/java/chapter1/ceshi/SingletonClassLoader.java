package chapter1.ceshi;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class SingletonClassLoader extends ClassLoader {
    
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        //�������з�cn.javass���µ���ʹ�ø������
        if(!name.startsWith("cn.javass")) {
            return super.loadClass(name);
        }
        try {
            //��ȡclass�ļ���Դ
            InputStream is = new ClassPathResource(name.replace(".", "/") + ".class").getInputStream();
            int avaliable = is.available();
            byte[] bytes = new byte[avaliable];
            is.read(bytes, 0, avaliable);
            //������
            return defineClass(name, bytes, 0, avaliable);
        } catch (IOException e) {
            System.out.println(e);
            return super.loadClass(name);
        }
    }
}
