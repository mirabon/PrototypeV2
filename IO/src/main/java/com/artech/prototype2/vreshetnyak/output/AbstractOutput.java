/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.output;



/**
 *
 * @author Василий
 */
public abstract class AbstractOutput implements Output{
    /**
     * Метод возвращает базовую форму ввода данных
     * @param text 
     */
    public abstract void OutputForm(String text);
    /**
     * Метод возвращает форму с таблицей
     */
    public abstract void FormReportInit();
    /**
     * Рисует взвешенный граф связей слов
     */
    public abstract void DrawGraphWord(Object[][] t);
    
}
