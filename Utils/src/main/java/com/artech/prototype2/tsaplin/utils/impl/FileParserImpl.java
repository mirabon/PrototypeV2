package com.artech.prototype2.tsaplin.utils.impl;

import com.artech.prototype2.tsaplin.utils.FileParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.xml.transform.OutputKeys;

/**
 * Класс вытягивает из файлов текст в удобном для обработки виде.
 *
 *
 * Created by atsaplin on 03.12.2014.
 */
public class FileParserImpl implements FileParser{


    /**
     *  Метод возвращает список слов для данного файла данного формата.
     *  В работе вызывает метод для соответствующего формата файла.
     * @param fileName - имя файла
     * @param format - формат данных файла (txt, doc, ...)
     * @return ArrayList со списком слов файла
     * @throws IOException
     */
    public ArrayList<String> getListOfWordsFromFile(String fileName, String format) throws IOException{

        if ("txt".equals(format.toLowerCase())) return  getListOfWordsFromTxt(fileName);
        else  return  getListOfWordsFromTxt(fileName);

    }

    /**
     * Метод обрабатывает txt-файл, достает из него слова, возвращает их в виде списка.
     * Под словами сейчас подразумеваются группы символов, разделенные пробелами.
     *
     * @param fileName - имя файла
     * @return ArrayList со списком слов файла, слова идут в том порядке, в котором они были в файле
     * @throws IOException
     */
    private ArrayList<String> getListOfWordsFromTxt(String fileName) throws IOException{
//        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "windows-1251"));
        ArrayList<String> words = new ArrayList<String>();
        String s;
        while ((s = reader.readLine())!=null){
            String[] arrayOfWords = s.split(" ");
            for (int i = 0; i < arrayOfWords.length; i++) {
                String word = arrayOfWords[i];
                words.add(word);
            }
        }

        return words;
    }
    
    /**
     * Метод определения кодировки файла
     * @param fileName
     * @return
     * @throws FileNotFoundException 
     */
    public String getEncoding(String fileName) throws FileNotFoundException{
         File fileToProceed = new File(fileName);
         FileReader fileInput = new FileReader(fileToProceed);
         return fileInput.getEncoding();
    }
    
     /**
     * Метод обрабатывает txt-файл, достает из него слова, возвращает их в виде списка.
     * Под словами сейчас подразумеваются группы символов, разделенные пробелами.
     *
     * @param fileName - имя файла
     * @param code - кодировка, в которой считывается текст
     * @return ArrayList со списком слов файла, слова идут в том порядке, в котором они были в файле
     * @throws IOException
     */
    public ArrayList<String> getListOfWordsFromTxt(String fileName, String code) throws IOException{
//        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), code));
        ArrayList<String> words = new ArrayList<String>();
        String s;
        String kode = getEncoding(fileName);
        System.out.println(kode);

        while ((s = reader.readLine())!=null){
            String[] arrayOfWords = s.split(" ");
            for (int i = 0; i < arrayOfWords.length; i++) {
                String word = new String(arrayOfWords[i].getBytes(kode), "UTF-8");
                words.add(word);
            }
        }
        
        return words;
    }
}
