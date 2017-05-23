package com.entity;

import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import java.util.Date;

/**
 * Created by jiangchangwei on 2017/5/23.
 */
public class TestStudent {

    @Test
    public void testSchemaExport() {
        Configuration config = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(config.getProperties());
        SessionFactory sessionFactory = config.buildSessionFactory(builder.build());
        SchemaExport export = new SchemaExport(config);
        export.create(true, true);
    }

    @Test
    public void addStudent() {
        Configuration config = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(config.getProperties());
        SessionFactory sessionFactory = config.buildSessionFactory(builder.build());
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Address address = new Address("11111", "2222", "3333");
        Student student = new Student(1, "李明", "男", new Date(), "太极拳", address);
        session.save(student);
        tx.commit();
    }

}
