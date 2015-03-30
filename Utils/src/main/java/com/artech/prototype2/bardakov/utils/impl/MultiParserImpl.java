/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.bardakov.utils.impl;

import com.artech.prototype2.tsaplin.utils.FileParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 * Класс предназначен для чтения файлов в разных форматах и парсинга текста в
 * файлах
 *
 * @author CANDY
 */
public class MultiParserImpl implements FileParser, AutoCloseable {

    /**
     * Метод определения кодировки файла
     *
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public String getEncoding(String fileName) throws FileNotFoundException {
        File fileToProceed = new File(fileName);
        FileReader fileInput = new FileReader(fileToProceed);
        return fileInput.getEncoding();
    }

    /**
     * Получить слова из файла указанного формата
     *
     * @param fileName имя файла
     * @param format формат файла
     * @return список слов
     * @throws IOException
     */
    public ArrayList<String> getListOfWordsFromFile(String fileName, String format) throws IOException {
        if ("txt".equals(format.toLowerCase())) {
            return getListOfWordsFromTxt(fileName);
        } else if ("pdf".equals(format.toLowerCase())) {
            return getListOfWordsFromPDF(fileName);
        } else if ("doc".equals(format.toLowerCase())) {
            return getListOfWordsFromDoc(fileName);
        } else {
            return getListOfWordsFromFB2(fileName);
        }
    }

    /**
     * Получение корректных данных из файла FB2
     * @param fileName
     * @return
     * @throws IOException 
     */
    private ArrayList<String> getListOfWordsFromFB2(String fileName) throws IOException {
        if (fileName == null) {
            return null;
        }
        File fileForImport = new File(fileName);
        List<String> result = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileForImport)));
        String text;
        while ((text = reader.readLine()) != null) {
            String[] textFragments = text.toLowerCase().split("<[^<>]*.>");
            String[] tmp = null;
            for (String t : textFragments) {
                tmp = t.split(" ");
                for (String fragment : tmp) {
                    result.add(fragment);
                }
            }
        }
        reader.close();
        return (ArrayList<String>) result;
    }

    /**
     * Метод получения слов из pdf
     *
     * @param fileName имя файла
     * @return список слов из pdf
     * @throws IOException
     */
    private ArrayList<String> getListOfWordsFromPDF(String fileName) throws IOException {
        List<String> result = new ArrayList<String>();
        PDDocument pdf = PDDocument.load(fileName);
        PDFTextStripper reader = new PDFTextStripper();
        StringBuilder builder = new StringBuilder();
        builder.append(reader.getText(pdf));
        String[] words = builder.toString().split(" ");
        for (String s : words) {
            result.add(s);
        }
        return (ArrayList<String>) result;
    }

    /**
     * Метод получения слов из pdf
     *
     * @param fileName имя файла
     * @return список слов из pdf
     * @throws IOException
     */
    private ArrayList<String> getListOfWordsFromTxt(String fileName) throws IOException {
        List<String> result = new ArrayList<String>();
        PDDocument pdf = PDDocument.load(fileName);
        PDFTextStripper reader = new PDFTextStripper();
        StringBuilder builder = new StringBuilder();
        builder.append(reader.getText(pdf));
        String[] words = builder.toString().split(" ");
        for (String s : words) {
            result.add(s);
        }
        return (ArrayList<String>) result;
    }

    public void close() throws Exception {

    }

    /**
     * Получение корректных данных из файла doc/docx
     * @param FilePath - путь к файлу
     * @return список слов
     */
    private ArrayList<String> getListOfWordsFromDoc(String FilePath) {
        FileInputStream fis;
        List<String> result = new ArrayList<String>();
        if (FilePath.substring(FilePath.length() - 1).equals("x")) { //is a docx
            try {
                fis = new FileInputStream(new File(FilePath));
                XWPFDocument doc = new XWPFDocument(fis);
                XWPFWordExtractor extract = new XWPFWordExtractor(doc);
                // System.out.println(extract.getText());
                StringBuilder builder = new StringBuilder();
                builder.append(extract.getText());
                String[] words = builder.toString().split(" ");
                for (String s : words) {
                    result.add(s);
                }
            } catch (IOException e) {

                e.printStackTrace();
            }
        } else { //is not a docx
            try {
                fis = new FileInputStream(new File(FilePath));
                HWPFDocument doc = new HWPFDocument(fis);
                WordExtractor extractor = new WordExtractor(doc);
                StringBuilder builder = new StringBuilder();
                builder.append(extractor.getText());
                String[] words = builder.toString().split(" ");
                for (String s : words) {
                    result.add(s);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return (ArrayList<String>) result;
    }

}
