import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.IMP_LIMIT;
import po.Address;
import po.Students;

import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by jiangchangwei on 2017/5/22.
 */
public class StudentsTest {

    private SessionFactory sessionFactory;
    private Session  session;
    private Transaction transaction;

    @Before
    public void init() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
//        //会话对象
//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure() // configures settings from hibernate.cfg.back.xml
//                .build();
//        sessionFactory = new MetadataSources(registry).buildMetadata()
//                .buildSessionFactory();
        session = sessionFactory.openSession();
        //开启事务
        transaction = session.beginTransaction();
        System.out.println("i am init method");
    }

    @Test
    public void testSaveStudents(){
        //生成学生对象
//        Students s = new Students(1,"张三丰", "男",new Date(), "武当山");
        Students s = new Students();
        s.setSid(100);
        s.setSname("张五丰");
        Address address = new Address("1111", "2222", "33333");
//        s.setAddress("信阳");
        s.setBirthday(new Date());
        s.setGender("男");
        s.setAddress(address);
        session.save(s); //保存对象进入数据库
//        session.flush();

    }
//
//    @Test
//    public void testWriteBlob() throws Exception {
//        Students s = new Students(1,"张三丰", "男",new Date(), "武当山");
//        //先获得照片文件
//        File f = new File("/Users/jiangchangwei/Pictures/jcw.png");
//        //获得文件输入流
//        InputStream input = new FileInputStream(f);
//        //创建Blob对象
//        Blob image = Hibernate.getLobCreator(session).createBlob(input, input.available());
//        session.save(s);

//    }

//    @Test
//    public void testReadBlob() throws Exception {
//        Students s = (Students) session.get(Students.class, 1);
//        //获得Blob对象
//        Blob image = s.getPictures();
//        //获得输入流
//        InputStream inputStream = image.getBinaryStream();
//        //创建输出流
//        File f = new File("/Users/jiangchangwei/Pictures/dest.png");
//        OutputStream outputStream = new FileOutputStream(f);
//        byte[] buff = new byte[inputStream.available()];
//        inputStream.read(buff);
//        outputStream.write(buff);
//        outputStream.close();
//        inputStream.close();
//    }


    @Test
    public void testGetStudents() {
        Students s = (Students) session.get(Students.class, 2);
        System.out.println(s);
//        Query query = session.createQuery("from Students");
//        List<Students> list = query.list();
//        for(Students ss : list) {
//            System.out.println(ss.getSname());
//        }
//        session.clear();
        Session session2 = sessionFactory.openSession();
        Students s2 = (Students)session2.get(Students.class, 2);
        System.out.println(s2);
    }

    @Test
    public void testLoadStudents() {
        Students s = (Students) session.load(Students.class, 1);
        System.out.println(s);
    }

    @Test
    public void testUpdateStudents() {
        Students s = (Students) session.get(Students.class, 1);
        s.setGender("nv");
        session.update(s);
    }

    @Test
    public void testDeleteStudents() {
        Students s = (Students) session.get(Students.class, 1);
        session.delete(s);
    }



    @After
    public void destroy() {
        transaction.commit();
//        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        System.out.println("i am destroy method");
    }


}
