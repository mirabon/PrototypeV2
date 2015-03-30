/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.output.impl;

import com.artech.prototype2.vreshetnyak.output.AbstractOutput;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 * Класс-шаблонизатор, обеспечивает вывод информации через перегруженные методы
 * (будут пополняться).
 *
 * @author Василий
 */
public class InitOutputFormImpl extends AbstractOutput {

    protected JTextArea DataJTextArea;
    protected JMenuBar menuBar;
    protected JMenu cMenu;
    

    /**
     * Метод принимает на вход текст.
     *
     * @param text
     */
    @Override
    public void OutputForm(String text) {
        JFrame OutputForm = new JFrame("Вывод");
        OutputForm.setSize(600, 400);
        OutputForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OutputForm.setLocationRelativeTo(null);
        OutputForm.setResizable(false);
        OutputForm.setLayout(new BorderLayout());
        /**
         * Добавляем главное меню на JMenuBar
         */
        menuBar = new JMenuBar();
        cMenu = new JMenu("Меню...");
        /**
         * Устанавливаем сформированное меню на сцену.
         */
        menuBar.add(cMenu);
        OutputForm.setJMenuBar(menuBar);

        /**
         * Помещаем на сцену JTextArea, в который и будут вводиться данные.
         */
        DataJTextArea = new JTextArea(text);
        DataJTextArea.setLineWrap(true);
        DataJTextArea.setWrapStyleWord(true);
        DataJTextArea.setEditable(false);
        /**
         * Полоса прокруточки
         */
        JScrollPane scrollPane = new JScrollPane(DataJTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        OutputForm.add(scrollPane, BorderLayout.CENTER);

        OutputForm.setVisible(true);
    }

    @Override
    public void FormReportInit() {
    }

    @Override
    public void DrawGraphWord(Object[][] t) {
        
        
    }
}
