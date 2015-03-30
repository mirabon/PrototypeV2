/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.utils;

import com.artech.prototype2.io.common.Common;
import com.artech.prototype2.vreshetnyak.input.Input;
import com.artech.prototype2.vreshetnyak.input.impl.InputFormImpl;

/**
 * Класс реализует шаманский метод, который возвращает данные с JTextArea
 *
 * @author Василий
 */
public class GetDataFromInputForm extends InputFormImpl{

    /**
     * Частное поле типа InputFormImpl
     */
    private InputFormImpl frame;

    /**
     * Конструктор принимающий на вход объект созданной нами формы
     *
     * @param someFrame
     */
    public GetDataFromInputForm(Input someFrame) {
        this.frame = (InputFormImpl) someFrame;
    }

    public GetDataFromInputForm(Common common) {
        this.frame = (InputFormImpl) common;
    }

    /**
     * Возвращает данные из JTextArea
     * @return
     */
    public StringBuilder getData() {
        StringBuilder s = new StringBuilder(frame.DataJTextArea.getText());
        return s;
    }
}
