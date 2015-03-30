/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.saver.dao;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.saver.manager.CommonDB;
import java.io.Serializable;
import java.util.List;

/**
 * Data Access Object
 * Интерфейс предоставляет 
 * CRUD функционал для работы с сущностью Entity
 * и сервера Базы данных
 * @author CANDY
 */
public interface Dao<ID extends Serializable, Type extends Entity> extends CommonDB {

    void save(AbstractSUBD db, Type entity);

    void delete(AbstractSUBD db, Type entity);

    Type getById(AbstractSUBD db, ID id);

//    List<Type> getAll(AbstractSUBD db);
    
    List<Type> getAll(AbstractSUBD db, Class name);

    void update(AbstractSUBD db, Type entity);
    
    void saveOrUpdate(AbstractSUBD db, Type entity);
}
