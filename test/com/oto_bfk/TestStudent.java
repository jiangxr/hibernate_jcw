package com.oto_bfk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import java.util.Date;

/**
 * Created by jiangchangwei on 2017/5/23.
 */
public class TestStudent {
    public void testSchemaExport1() {
        Configuration config = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(config.getProperties());
        SessionFactory sessionFactory = config.buildSessionFactory(builder.build());
        SchemaExport export = new SchemaExport(config);


    }

    @Test
    public void addStudents() {
        Configuration config = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(config.getProperties());
        SessionFactory sessionFactory = config.buildSessionFactory(builder.build());
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        IdCard card = new IdCard("411526199111085115","姜昌伟");
        Student s = new Student(card,"男", new Date(), "计算机");
        session.save(card);
        session.save(s);
        tx.commit();
    }
}
