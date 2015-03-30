/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.saver.hiber.util;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author CANDY
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Configuration configure;

    static {

    }

    /**
     * получить сессию хибернейт
     *
     * @param db - выбранная база данных
     * @return
     */
    public static SessionFactory getSessionFactory(AbstractSUBD db) {
        if (sessionFactory == null) {
            try {
                // Create the SessionFactory from standard (hibernate.cfg.xml) 
                // config file.
                configure = new Configuration().configure("hibernate/hibernate-mysql.cfg.xml");
                configure.setProperty("hibernate.connection.username", db.getLogin());
                configure.setProperty("hibernate.connection.password", db.getPassword());
                sessionFactory = configure.buildSessionFactory();

            } catch (Throwable ex) {
                // Log the exception. 
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }

        return sessionFactory;
    }
}
