package com.artech.prototype2.tsaplin.utils;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Интерфейс для обработки файлов.
 *
 *
 * Created by atsaplin on 03.12.2014.
 */
public interface FileParser {
    /**
     * Метод возвращает список слов для данного файла данного формата.
     *
     * @param fileName - имя файла
     * @param format - формат данных файла (txt, doc, ...)
     * @return ArrayList со списком слов файла
     * @throws IOException
     */
    public ArrayList<String> getListOfWordsFromFile(String fileName, String format) throws IOException;
}
