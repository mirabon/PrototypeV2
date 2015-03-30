package com.artech.prototype2.tsaplin.statistics;

import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.*;

import java.util.ArrayList;


/**
 * Интерфейс для создания статистик.
 *
 * Created by atsaplin on 03.12.2014.
 */
public interface StatisticMaker {

    /**
     * Создание статистики для русскоязычных одиночных слов.
     *
     * @param words - список слов.
     * @return - статистика одиночных слов.
     */
    public SingleWordRuStatisticImpl makeSingleWordRuStatistic(ArrayList<String> words);

    /**
     * Создание статистики для англоязычных одиночных слов.
     *
     * @param words - список слов.
     * @return - статистика одиночных слов.
     */
    public SingleWordEnStatisticImpl makeSingleWordEnStatistic(ArrayList<String> words);

    /**
     * Создание статистики для русскоязычных биграмм на основе списка слов.
     *
     * @param words - список слов.
     * @return - статистика биграмм.
     */
    public BigramRuStatisticImpl makeBigramRuStatistic(ArrayList<String> words);

    /**
     * Создание статистики для англоязычных биграмм на основе списка слов.
     *
     * @param words - список слов.
     * @return - статистика биграмм.
     */
    public BigramEnStatisticImpl makeBigramEnStatistic(ArrayList<String> words);

    /**
     * Создание статистики для русскоязысных триграмм на основе списка слов.
     *
     * @param words - список слов.
     * @return - статистика для триграмм.
     */
    public ThreegramRuStatisticImpl makeThreegramRuStatistic(ArrayList<String> words);

    /**
     * Создание статистики для англоязычных триграмм на основе списка слов.
     *
     * @param words - список слов.
     * @return - статистика для триграмм.
     */
    public ThreegramEnStatisticImpl makeThreegramEnStatistic(ArrayList<String> words);

    /**
     * Создание статистики для русскоязычных фограмм на основе списка слов.
     *
     * @param words - список слов.
     * @return - статистика для фограмм.
     */
    public FourgramRuStatisticImpl makeFourgramRuStatistic(ArrayList<String> words);

    /**
     * Создание статистики для англоязычных фограмм на основе списка слов.
     *
     * @param words - список слов.
     * @return - статистика для фограмм.
     */
    public FourgramEnStatisticImpl makeFourgramEnStatistic(ArrayList<String> words);


}
