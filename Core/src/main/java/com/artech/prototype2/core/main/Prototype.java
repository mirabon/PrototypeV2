/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.core.main;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.saver.dbo.impl.CreateDataBaseImpl;
import com.artech.prototype2.saver.dbo.impl.MySQL;
import com.artech.prototype2.saver.manager.ManagerAPISaver;
import com.artech.prototype2.vreshetnyak.input.Input;
import com.artech.prototype2.vreshetnyak.input.impl.InputFormImpl;
import com.artech.prototype2.vreshetnyak.output.Output;
import com.artech.prototype2.vreshetnyak.output.impl.InitOutputFormImpl;

/**
 * Основоной класс всей системы В нем осуществляется взаимодействие всех
 * компонентов системы
 *
 * @author CANDY
 */
public class Prototype {

    /**
     * Инициализация компонентов системы Предобработка
     */
    public Prototype() {
        createForms();
        initDataBase();
    }

    /**
     * Метод создает 2 формы одна форма ввода другая форма вывода
     */
    protected void createForms() {
        createInput();
        createOutput();
    }

    /**
     * Метод создает форму ввода
     */
    protected void createInput() {
        Input input = new InputFormImpl();
        input.InputGUIForm();
    }

    /**
     * Метод создает формы вывода
     */
    protected void createOutput() {
        Output form = new InitOutputFormImpl(); //создаем
        form.OutputForm("Test"); //вызываем
    }

    /**
     * Основной метод жизненного цикла всей системы Запускает систему
     */
    public void lifecycle() {

    }

    /**
     * Создание и проверка на существование всех бд и таблиц
     */
    protected void initDataBase() {
        AbstractSUBD db = new MySQL("dbconnect/dbconnect.properties");
        String label = "create_db";
        ManagerAPISaver.getInstance().registry(label, db, new CreateDataBaseImpl());
        ManagerAPISaver.getInstance().createDB(label, db);
    }
}
