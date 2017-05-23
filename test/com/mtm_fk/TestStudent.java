package com.mtm_fk;

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
        Teachers t1 = new Teachers("T001", "李芳");
        Teachers t2 = new Teachers("T002", "张芳");
        Teachers t3 = new Teachers("T003", "叶芳");
        Teachers t4 = new Teachers("T004", "高芳");

        Student s1 = new Student("张三","男", new Date(),"计算机");
        Student s2 = new Student("赵四","男", new Date(),"计算机");
        Student s3 = new Student("王五","男", new Date(),"计算机");
        Student s4 = new Student("六六","男", new Date(),"计算机");

        Set<Teachers> set1 = new HashSet<Teachers>();
        set1.add(t1);
        set1.add(t2);

        Set<Teachers> set2 = new HashSet<Teachers>();
        set2.add(t3);
        set2.add(t2);

        Set<Teachers> set3 = new HashSet<Teachers>();
        set3.add(t2);
        set3.add(t3);
        set3.add(t4);

        Set<Teachers> set4 = new HashSet<Teachers>();
        set4.add(t1);
        set4.add(t3);

        s1.setTeachers(set1);
        s2.setTeachers(set2);
        s3.setTeachers(set3);
        s4.setTeachers(set4);

        session.save(t1);
        session.save(t2);
        session.save(t3);
        session.save(t4);
        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(s4);
        tx.commit();
    }
}
