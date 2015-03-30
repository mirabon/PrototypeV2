/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.saver.api;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.saver.entity.Entity;
import java.util.List;

/**
 * API модуля Saver функционал, который может предоствить модуль
 *
 * @author CANDY
 */
public interface API {

    /**
     * Создание БД Создание таблиц в указанной СУБД
     *
     * @param db СУБД
     */
    void createDB(String label, AbstractSUBD db);

    /**
     * Сохранение сущности в БД
     *
     * @param db выбранная бд
     * @param entity сущность для сохранения
     */
    void save(String label, AbstractSUBD db, Entity entity);

    /**
     * Удалить сущность из БД
     *
     * @param label метка функционала
     * @param db выбранная база данных
     * @param entity удаляемая сущность
     */
    void delete(String label, AbstractSUBD db, Entity entity);

    /**
     * Получить сущность по индексу
     *
     * @param label метка функционала
     * @param db выбранная база данных
     * @param id идентификатор сущности в бд
     * @return найденная сущность или null, если сущность отсутствует
     */
    Entity getById(String label, AbstractSUBD db, Integer id);

//    /**
//     * Получить все данные из бд
//     *
//     * @param label метка функционала
//     * @param db выбранная база данных
//     * @return Список сущностей
//     */
//    List<Entity> getAll(String label, AbstractSUBD db);
//    
    
     /**
     * Получить все данные из бд
     *
     * @param label метка функционала
     * @param db выбранная база данных
     * @return Список сущностей
     */
    List<Entity> getAll(String label, AbstractSUBD db, Class name);

    /**
     * Обновление данных в бд
     *
     * @param label метка функционала
     * @param db выбранная база данных
     * @param entity сущность обновления
     */
    void update(String label, AbstractSUBD db, Entity entity);
    
    /**
     * Сохранение или обновление сущности в бд
     * @param label метка функционала
     * @param db выбранная база данных
     * @param entity сущность обновления
     */
    void saveOrUpdate(String label, AbstractSUBD db, Entity entity);

}
