package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.saver.dbo.impl.MySQL;
import com.artech.prototype2.tsaplin.statistics.StatisticSaverToDB;
import com.artech.prototype2.tsaplin.statistics.StatisticWork;
import com.artech.prototype2.tsaplin.statistics.statisticholder.AbstractNgramStatistic;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.*;
import com.artech.prototype2.tsaplin.utils.impl.FileParserImpl;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * Класс для работы со статистикой.
 *
 * Created by atsaplin on 03.12.2014.
 */
public class StatisticWorkImpl implements StatisticWork{

    public static void main(String[] args) throws Throwable{
        String fileName = "E:/test.txt";
        StatisticWorkImpl statisticWork = new StatisticWorkImpl();
        statisticWork.getFullStatisticFromFileToDB(fileName, "txt");


    }

    /**
     * Метод для получения статистики из файла и загрузки ее в БД.
     * Использует метод fileParser.getListOfWordsFromFile, чтобы получить список слов из файла.
     * На основе списка слов составляются статистики для н-грамм (н от 1 до 4), с помощью методов класса StatisticMaker.
     * Статистика загружается в базу данных.
     *
     * @param fileName - имя файла с текстом
     * @param format - формат данных в файле ("txt", "pdf", "doc" ...)
     * @throws IOException
     */
    public void getFullStatisticFromFileToDB(String fileName, String format) throws IOException{
        FileParserImpl fileParser = new FileParserImpl();
        ArrayList<String> words = fileParser.getListOfWordsFromFile(fileName, format);

        //Здесь должен быть какой-то способ определения языка для файла
        String lang = "en";

        StatisticMakerImpl statisticMaker = new StatisticMakerImpl();
        StatisticSaverToDB dbSaver = new StatisticSaverToDBImpl();
        AbstractSUBD db = new MySQL("dbconnect/dbconnect.properties");
        if("ru".equals(lang)) {
            SingleWordRuStatisticImpl singleWordStatistic = statisticMaker.makeSingleWordRuStatistic(words);
            dbSaver.saveStatisticToDB(singleWordStatistic, db);

            BigramRuStatisticImpl bigramStatistic = statisticMaker.makeBigramRuStatistic(words);
            dbSaver.saveStatisticToDB(bigramStatistic, db);

            ThreegramRuStatisticImpl threegramStatistic = statisticMaker.makeThreegramRuStatistic(words);
            dbSaver.saveStatisticToDB(threegramStatistic, db);

            FourgramRuStatisticImpl fourgramStatistic = statisticMaker.makeFourgramRuStatistic(words);
            dbSaver.saveStatisticToDB(fourgramStatistic, db);

        }
        else if ("en".equals(lang)){
            SingleWordEnStatisticImpl singleWordStatistic = statisticMaker.makeSingleWordEnStatistic(words);
         dbSaver.saveStatisticToDB(singleWordStatistic, db);

            BigramEnStatisticImpl bigramStatistic = statisticMaker.makeBigramEnStatistic(words);
          dbSaver.saveStatisticToDB(bigramStatistic, db);

            ThreegramEnStatisticImpl threegramStatistic = statisticMaker.makeThreegramEnStatistic(words);
           dbSaver.saveStatisticToDB(threegramStatistic, db);

            FourgramEnStatisticImpl fourgramStatistic = statisticMaker.makeFourgramEnStatistic(words);
            dbSaver.saveStatisticToDB(fourgramStatistic, db);
        }




    }
}
