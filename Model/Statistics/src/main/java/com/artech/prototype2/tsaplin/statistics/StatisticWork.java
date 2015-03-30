package com.artech.prototype2.tsaplin.statistics;

import java.io.IOException;

/**
 * Интерфейс работы со статистикой.
 *
 * Created by atsaplin on 03.12.2014.
 */

public interface StatisticWork {
    /**
     * Метод для получения статистики из файла и загрузки ее в БД.
     *
     * @param fileName - имя файла с текстом
     * @param format - формат данных в файле ("txt", "pdf", "doc" ...)
     * @throws IOException
     */
    public void getFullStatisticFromFileToDB(String fileName, String format) throws IOException;


}
