/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Класс-валидатор, отвечающий за проверку вводимых данных
 *
 * @author Василий
 */
public class ValidationPathAndUrl {

    protected ArrayList<String> list;
    protected File file;
    protected URL url;

    public void valid() {
    }

    /**
     * Конструктор принимает аргументы
     *
     * @param args
     * @param type первый - массив разбитых данных второй - тип данных (0,1,-1),
     * которые определяют: url, путь к папке/файлу, текст для анализа или
     * перевода
     */
    public ArrayList validation(String args[], int type) {
        switch (type) {
            case 0:
                list = new ArrayList<String>();
                for (String string : args) {
                    file = new File(string);
                    if (file.exists()) {
                        list.add(string);
                    } else {
                        System.out.println("Путь не найден!");
                    }
                }
                break;
            case 1:
                list = new ArrayList<String>();
                for (String urlString : args) {
                    try {
                        url = new URL(urlString);
                        list.add(urlString);
                    } catch (MalformedURLException ex) {
                        System.out.println("URL не валиден " + ex.getMessage());
                    }
                }
                break;
            default:
                break;
        }
        return list;
    }

    public void printArrayList(ArrayList list) {
        for (Object e : list) {
            System.out.println((String) e);
        }
    }
}
