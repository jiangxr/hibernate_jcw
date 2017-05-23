package com.util;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by jiangchangwei on 2017/5/23.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public static Session getSession() {
        if(sessionFactory == null)
            sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }
}
