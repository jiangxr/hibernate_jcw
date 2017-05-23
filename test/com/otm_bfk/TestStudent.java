package com.otm_bfk;

import com.otm_bfk.ClassRoom;
import com.otm_bfk.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jiangchangwei on 2017/5/23.
 */
public class TestStudent {

    @Test
    public void addStudents() {
        Configuration config = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(config.getProperties());
        SessionFactory sessionFactory = config.buildSessionFactory(builder.build());
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        ClassRoom c1 = new ClassRoom("C001", "软件工程");
        ClassRoom c2 = new ClassRoom("C002", "通信");
        Student s1 = new Student("张三", "男", new Date(), "计算机");
        Student s2 = new Student("李四", "男", new Date(), "计算机");
        Student s3 = new Student("王五", "男", new Date(), "计算机");
        Student s4 = new Student("赵六", "男", new Date(), "计算机");
//        Set<Student> set1 = new HashSet<Student>();
//        Set<Student> set2 = new HashSet<Student>();
//        set1.add(s1);
//        set1.add(s2);
//        set2.add(s3);
//        set2.add(s4);
//        c1.setStus(set1);
//        c2.setStus(set2);
        session.save(c1);
        session.save(c2);
        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(s4);
        session.save(c1);
        session.save(c2);
        tx.commit();
    }
}
