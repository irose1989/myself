import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;


/**
 * Created by wb-chenchaobin on 2015/12/11.
 */
public class StudentTest {
    @Test
    public void createTable(){
        Configuration configuration = new Configuration().configure();
        SchemaExport export = new SchemaExport(configuration);
        export.create(true,true);
    }
    @Test
    public void insert(){
        Configuration cg = new Configuration().configure();
        SessionFactory factory = cg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Student s = new Student("chen",12);
//        s.setAge(20);
//        s.setName("chenchaobin");
        try {
            session.save(s);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            session.close();
        }
    }
    @Test
    public void get(){
        Configuration cfg = new Configuration().configure();
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        ServiceRegistry service = ssrb.build();
        SessionFactory factory = cfg.buildSessionFactory(service);
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Student s = (Student)session.get(Student.class, 1);
            tx.commit();
            System.out.println(s);
        }catch (Exception e){
            tx.rollback();
        }finally {
            session.close();
        }
    }

}
