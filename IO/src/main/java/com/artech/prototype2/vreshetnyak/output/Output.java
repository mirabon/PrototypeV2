/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.output;

//import com.artech.prototype2.saver.titov.dao.DAO;

/**
 *
 * @author Василий
 */
public interface Output {
    /**
     * Выводит форму с переданным текстом в аргументе. Поддержка многострочности
     * @param text
     */
    public void OutputForm(String text);
    
    /**
     * Выводит форму с таблицей
     * FormReport(nameForm, countColum, название_колонки1, название_колонки2, ... , название_колонкиN, 
     * Название_таблицы)
     * @param arg
     */
    public void FormReportInit();
    /**
     * Рисует взвешенный граф связей слов
     */
    public abstract void DrawGraphWord(Object[][] t);
}
