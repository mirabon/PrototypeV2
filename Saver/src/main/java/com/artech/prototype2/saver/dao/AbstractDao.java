/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.saver.dao;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.saver.hiber.util.HibernateUtil;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Реализация функционала Дао интерфейса
 *
 * @author CANDY
 */
public class AbstractDao<ID extends Serializable, Type extends Entity> implements Dao<ID, Type> {

    public void save(AbstractSUBD db, Type entity) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory(db).openSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void delete(AbstractSUBD db, Type entity) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory(db).openSession();
            session.beginTransaction();
            session.delete(entity);
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

//    public <T> List<T> getAll(final Class<T> type) {
//      final Session session = sessionFactory.getCurrentSession();
//      final Criteria crit = session.createCriteria(type);
//  return crit.list();
//    }
    
//    public List<Type> getAll(AbstractSUBD db) {
//        Session session = null;
//        List<Type> entities = new ArrayList<Type>();
//        try {
//            session = HibernateUtil.getSessionFactory(db).openSession();
//            session.beginTransaction();
//            entities = session.createCriteria(Entity.class).list();
//            session.flush();
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//        return entities;
//    }

    public void update(AbstractSUBD db, Type entity) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory(db).openSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Type getById(AbstractSUBD db, ID id) {
        Session session = null;
        Type entity = null;
        try {
            session = HibernateUtil.getSessionFactory(db).openSession();
            entity = (Type) session.load(Entity.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return entity;
    }

    public void saveOrUpdate(AbstractSUBD db, Type entity) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory(db).openSession();
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Type> getAll(AbstractSUBD db, Class name) {
        Session session = null;
        List<Type> entities = new ArrayList<Type>();
        try {
            session = HibernateUtil.getSessionFactory(db).openSession();
            session.beginTransaction();
            entities = session.createCriteria(name).list();
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return entities;
    }

}
