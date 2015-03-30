/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.input.impl;

import com.artech.prototype2.io.api.ManagerIOAPI;
import javax.swing.*;
import com.artech.prototype2.vreshetnyak.input.AbstractInput;
import com.artech.prototype2.vreshetnyak.utils.GetDataFromInputForm;
import com.artech.prototype2.vreshetnyak.utils.ValidationPathAndUrl;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Класс является унаследованным от AbstractInput. Отвечает за формирование окна
 * для ввода данных с разным назначением: командами — {"Translate", "InMemory",
 * "Statistic", "Analytics"}.
 *
 * Каждой команде соответствует определенный набор аргументов: Translate - текст
 * для перевода InMemory - путь к папке, url Statistics - путь к папке, url
 * Analisys - текст для анализа
 *
 * @author Василий
 */
public class InputFormImpl extends AbstractInput {

    /**
     * Объявление полей protected
     */
    protected String command = null;
    protected int maskTypeData;
    protected String[] item = {"Translate", "InMemory", "Statistic", "Analytics"};
    protected JButton SendDataToSensorButton;
    protected JLabel labelCommand;
    public JTextArea DataJTextArea;
    protected JTextField commandJTextField;
    protected JMenuBar menuBar;
    protected JMenu commandMenu;
    protected JMenuItem translateItem;
    protected JMenuItem inMemoryItem;
    protected JMenuItem statisticItem;
    protected JMenuItem analyticsItem;
    protected ValidationPathAndUrl validator;

    /**
     * Унаследованный метод образует форму для ввода команд данных.
     *
     * На кнопку SendDataToSensoButton повешен слушатель SendDataToSensor()
     * Класс которого описан здесь же.
     */
    @Override
    public void InputGUIForm() {
        /**
         * Начинаем строить форму
         */
        JFrame InputFormFrame = new JFrame("Ввод данных для обработки");
        InputFormFrame.setSize(600, 400);
        InputFormFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InputFormFrame.setLocationRelativeTo(null);
        InputFormFrame.setResizable(false);
        InputFormFrame.setLayout(new BorderLayout());

        /**
         * Добавляем главное меню на JMenuBar
         */
        menuBar = new JMenuBar();
        commandMenu = new JMenu("Команды");
        /**
         * Добавляем подпункты меню
         */
        translateItem = new JMenuItem(item[0]);
        translateItem.addActionListener(new MenuActionListener());
        commandMenu.add(translateItem);

        inMemoryItem = new JMenuItem(item[1]);
        inMemoryItem.addActionListener(new MenuActionListener());
        commandMenu.add(inMemoryItem);

        statisticItem = new JMenuItem(item[2]);
        statisticItem.addActionListener(new MenuActionListener());
        commandMenu.add(statisticItem);

        analyticsItem = new JMenuItem(item[3]);
        analyticsItem.addActionListener(new MenuActionListener());
        commandMenu.add(analyticsItem);
        /**
         * Устанавливаем сформированное меню на сцену.
         */
        menuBar.add(commandMenu);
        InputFormFrame.setJMenuBar(menuBar);
        /**
         * Помещаем на сцену JTextArea, в который и будут вводиться данные.
         */
        DataJTextArea = new JTextArea();
        DataJTextArea.setLineWrap(true);
        DataJTextArea.setWrapStyleWord(true);
        /**
         * Полоса прокруточки
         */
        JScrollPane scrollPane = new JScrollPane(DataJTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        InputFormFrame.add(scrollPane, BorderLayout.CENTER);
        /**
         * JLabel с выводом выбранной команды
         */
        JPanel panelLabelCommand = new JPanel();
        labelCommand = new JLabel("Команда:");
        panelLabelCommand.setLayout(new GridLayout(2, 2));
        /**
         * Панелька для кнопочки
         */
        SendDataToSensorButton = new JButton("Send");
        SendDataToSensorButton.addActionListener(new SendActionListener());

        /**
         * Поле для ввода команды
         */
        commandJTextField = new JTextField("");// поле для ввода команды
        /**
         * ДОбавляем все на панельку
         */
        panelLabelCommand.add(commandJTextField);
        panelLabelCommand.add(SendDataToSensorButton);
        panelLabelCommand.add(labelCommand);

        InputFormFrame.add(panelLabelCommand, BorderLayout.SOUTH);

        /**
         * Отображаем нашу форму
         */
        InputFormFrame.setVisible(true);

    }

    class MenuActionListener implements ActionListener {

        /**
         * Отслеживаем выбранную команду
         *
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            command = e.getActionCommand();
            labelCommand.setText("Команда: " + command.toLowerCase());
        }
    }

    /**
     * Класс-слушатель на кнопку SendDataToSensorButton("Send")
     */
    class SendActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            /*
             * item = {"Translate", "InMemory", "Statistic", "Analytics"};
             */
            String s[] = DataJTextArea.getText().split("\n");
            File file = new File(s[0]);
            /**
             * Проверяем, выбрана ли команда.
             */
            if (command != null | !"".equals(commandJTextField.getText())) {
                /**
                 * Проверка на короткие тексты. Если короткий (=< 20 символов),
                 * то выводим JOptionPane
                 */
                if (DataJTextArea.getText().length() >= 20) {
                    /**
                     * В разбитом тексте по сплиту берем первый элемент и
                     * проверяем валидность пути к папке/файлу через exists(); и
                     * сравнимаем выбранную команду. Когда все удачно, полю
                     * @maskTypeData присваивается 0.
                     */
                    if (file.exists()
                            && (item[1].equals(command) | item[2].equals(command))) {
                        maskTypeData = 0; //маска типа данных
                        validator = new ValidationPathAndUrl(); //наш валидатор
                        /**
                         * перегруженный конструктор printArrayList(String
                         * args[], int type)
                         *
                         * @param args[] - массив строк
                         * @param type - значение маски типа данных
                         */
                        validator.printArrayList(validator.validation(s, maskTypeData));
                    } /**
                     * В разбитом тексте по сплиту берем первый элемент и
                     * проверяем валидность url-пути; и сравнимаем выбранную
                     * команду. Когда все удачно, полю @maskTypeData
                     * присваивается 1.
                     */
                    else if (s[0].startsWith("http")
                            && (item[1].equals(command) | item[2].equals(command))) {
                        maskTypeData = 1;
                        validator = new ValidationPathAndUrl();
                        validator.printArrayList(validator.validation(s, maskTypeData));
                    } /**
                     * При остальных условиях берется просто текст. Полю
                     * @maskTypeData присваивается -1.
                     */
                    else {
                        maskTypeData = -1;
                        /**
                         * Принимаем текст как есть из JTextArea.
                         */
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Введенный текст слишком короткий!",
                            "Внимание!",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Команда не выбрана!",
                        "Внимание!",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}