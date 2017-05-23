import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.junit.Test;
import po.Students;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by jiangchangwei on 2017/5/22.
 */
public class SessionTest {

    @Test
    public void testOpenSession() {
        //获取服务注册对象
//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure() // configures settings from hibernate.cfg.back.xml
//                .build();
//        //获取sessionFactory工厂对象
//        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata()
//                .buildSessionFactory();
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        SessionFactory factory = configuration.buildSessionFactory(builder.build());
        //获取session对象
        Session session = factory.openSession();
        Session session2 = factory.openSession();
        System.out.println(session == session2);
        /*
        if(session != null) {
            System.out.println("session创建成功");
        }else
            System.out.println("session创建失败");
        */
    }

    @Test
    public void testGetCurrentSession() {
//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure() // configures settings from hibernate.cfg.back.xml
//                .build();
//        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata()
//                .buildSessionFactory();
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        SessionFactory factory = configuration.buildSessionFactory(builder.build());
        Session session = factory.getCurrentSession();
        Session session2 = factory.getCurrentSession();
        System.out.println(session == session2);
        /*
        if(session != null) {
            System.out.println("session创建成功");
        }else
            System.out.println("session创建失败");
       */
    }

    @Test
    public void testSaveStudentWithOpenSession() {
//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure() // configures settings from hibernate.cfg.back.xml
//                .build();
//        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata()
//                .buildSessionFactory();
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        SessionFactory factory = configuration.buildSessionFactory(builder.build());
        Session session1 = factory.openSession();
        Transaction transaction = session1.beginTransaction();
        Students s = new Students(1,"张三","男",new Date(), "北京");
        session1.doWork(new Work() {
            public void execute(Connection connection) throws SQLException {
                System.out.println("connection hashCode:" + connection.hashCode());
            }
        });
        session1.save(s);
        transaction.commit();
//        session1.close();

        Session session2 =  factory.openSession();
        transaction = session2.beginTransaction();
        s = new Students(2,"李四","男", new Date(), "上海");
        session2.doWork(new Work() {
            public void execute(Connection connection) throws SQLException {
                System.out.println("connection hashCode:" + connection.hashCode());
            }
        });
        session2.save(s);
        transaction.commit();
    }

    @Test
    public void testSaveStudentsWithGetCurrentSession() {

//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure() // configures settings from hibernate.cfg.back.xml
//                .build();
//        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata()
//                .buildSessionFactory();
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        SessionFactory factory = configuration.buildSessionFactory(builder.build());
        Session session1 = factory.getCurrentSession();
        Transaction transaction = session1.beginTransaction();
        Students s = new Students(1,"张三","男",new Date(), "北京");
        session1.doWork(new Work() {
            public void execute(Connection connection) throws SQLException {
                System.out.println("connection hashCode:" + connection.hashCode());
            }
        });
        session1.save(s);
        transaction.commit();
//        session1.close();

        Session session2 =  factory.getCurrentSession();
        transaction = session2.beginTransaction();
        s = new Students(2,"李四","男", new Date(), "上海");
        session2.doWork(new Work() {
            public void execute(Connection connection) throws SQLException {
                System.out.println("connection hashCode:" + connection.hashCode());
            }
        });
        session2.save(s);
        transaction.commit();

    }

}
