/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.saver.dbo.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс предназначен для работы с ресурсами модуля Saver
 *
 * @author artem
 */
public class Resources {

    /**
     * Метод получает все файлы из указанной папки, которая находится в
     * resources
     *
     * @param folderScripts
     * @return массив файлов в папке
     */
    public String[] getScriptsForDB(String folderScripts) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(folderScripts).getPath());
        String[] files = file.list();
        return files;
    }

    /**
     * Метод получает файл из указанной папки, которая находится в
     * resources
     *
     * @param folderScripts
     * @return массив файлов в папке
     */
    public String getScriptForDB(String folderFile) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(folderFile).getPath());
        String fileRes = file.getName();
        return fileRes;
    }
    
    /**
     * Метод возвращает содержимое файла,
     *
     * @param fileName - путь к файлу
     * @return контент
     * @throws IOException
     */
    public StringBuilder getContentFile(String fileName) {
        InputStream in = null;
        StringBuilder out = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(fileName).getPath());
            in = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            out = new StringBuilder("");
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
                out.append("\n");
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Resources.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Resources.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(Resources.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return out;
    }

    /**
     * Метод возвращает содержимое файла,
     * в виде массив, расположив каждую строку в отдельном элементе
     * @param fileName - путь к файлу
     * @return контент
     * @throws IOException
     */
    public List<String> getParseFileInLine(String fileName) {
        InputStream in = null;
        List<String> out = new ArrayList<String>();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(fileName).getPath());
            in = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                out.add(line);
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Resources.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Resources.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(Resources.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return out;
    }
    
    
    /**
     * Получение значение свойства по ключу
     * @param nameFile имя файла
     * @param nameProperty название свойства
     * @return значение свойства
     * @throws IOException 
     */
    public String getPropValue(String nameFile, String nameProperty) throws IOException {
        Properties prop = new Properties();
        String propFileName = nameFile;
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
        return prop.getProperty(nameProperty);
    }
}
