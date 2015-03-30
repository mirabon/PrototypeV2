/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.output.impl;

import com.artech.prototype2.saver.dao.AbstractDao;
import com.artech.prototype2.saver.dao.Dao;
import com.artech.prototype2.saver.dao.impl.DictionaryRuDaoImpl;
import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.saver.dbo.impl.MySQL;
import com.artech.prototype2.saver.entity.DictionaryRu;
import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.vreshetnyak.output.AbstractOutput;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author Василий
 */
public class FormReportImpl extends AbstractOutput {

    protected String nameForm;
    protected String[] nameColumns;
    protected AbstractDao inTable;
    protected String nameTable;
    protected Object[][] data;

    public FormReportImpl(String nameForm, String[] nameColumns, AbstractDao inTable, String nameTable) {
        this.nameForm = nameForm;
        this.nameColumns = nameColumns;
        this.inTable = inTable;
        this.nameTable = nameTable;
    }

    public void OutputForm(String text) {
    }


    /**
     * FormReport(nameForm, countColum, название_колонки1, название_колонки2,
     * ... , название_колонкиN, Название_таблицы) и создается форма в которую
     * передаются данные из бд
     *
     */
    @Override
    public void FormReportInit() {
        AbstractSUBD db = new MySQL("dbconnect/dbconnect.properties");

        List<DictionaryRu> all = ((DictionaryRuDaoImpl) inTable).getAll(db, DictionaryRu.class);
        data = new Object[all.size()][nameColumns.length];

        for (int i = 0; i < all.size(); ++i) {
            String[] temp = new String[nameColumns.length];
            temp[0] = all.get(i).getRuid().toString();
            temp[1] = all.get(i).getWord();
            temp[2] = String.valueOf(all.get(i).getCount());


            data[i] = temp;
            //System.out.println(all.get(i).getRuid() + " : " + all.get(i).getWord() + " : " + all.get(i).getCount());
        }


        //ArrayList<String[][]> data = new ArrayList<String[][]>(); //сюда нужно помещать данные

        JFrame OutputForm = new JFrame(nameForm);
        OutputForm.setSize(800, 600);
        OutputForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OutputForm.setLocationRelativeTo(null);
        OutputForm.setResizable(false);
        OutputForm.setLayout(new BorderLayout());
        /**
         * Помещаем на сцену JTable, в который и будут заполняться данными.
         */
        JTable table = new JTable(data, nameColumns);
        /**
         * Полоса прокруточки
         */
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JPanel tablePanel = new JPanel(new GridLayout(1, 1));
        tablePanel.setBorder(BorderFactory.createTitledBorder(nameTable));
        tablePanel.add(scrollPane);

        OutputForm.add(tablePanel, BorderLayout.CENTER);

        OutputForm.setVisible(true);
    }

    @Override
    public void DrawGraphWord(Object[][] t) {
        
    }
}
