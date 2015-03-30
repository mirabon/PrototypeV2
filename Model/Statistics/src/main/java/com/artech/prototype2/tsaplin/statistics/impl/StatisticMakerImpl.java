
package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.tsaplin.statistics.StatisticMaker;
import com.artech.prototype2.tsaplin.statistics.ngrams.impl.*;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.*;

import java.util.ArrayList;


/**
 * Класс для получения статистики на основе списка слов.
 *
 *
 * Created by atsaplin on 03.12.2014.
 */
public class StatisticMakerImpl implements StatisticMaker{


    /**
     * Создание статистики для одиночных слов.
     * @param words - список слов.
     * @return
     */
    @Override
    public SingleWordRuStatisticImpl makeSingleWordRuStatistic(ArrayList<String> words) {
        SingleWordRuStatisticImpl singleWordStatistic = new SingleWordRuStatisticImpl();

        for (int i = 0; i < words.size(); i++) {
             SingleWordRuImpl word = new SingleWordRuImpl(words.get(i));
             singleWordStatistic.plusOneNgram(word);
        }

        return singleWordStatistic;
    }

    @Override
    public SingleWordEnStatisticImpl makeSingleWordEnStatistic(ArrayList<String> words) {
        SingleWordEnStatisticImpl singleWordStatistic = new SingleWordEnStatisticImpl();

        for (int i = 0; i < words.size(); i++) {
            SingleWordEnImpl word = new SingleWordEnImpl(words.get(i));
            singleWordStatistic.plusOneNgram(word);
        }

        return singleWordStatistic;
    }

    /**
     * Создание статистики для биграмм на основе списка слов.
     * @param words - список слов.
     * @return
     */
    @Override
    public BigramRuStatisticImpl makeBigramRuStatistic(ArrayList<String> words) {
        BigramRuStatisticImpl bigramStatistic = new BigramRuStatisticImpl();

        for (int i = 1; i < words.size(); i++) {
            BigramRuImpl bigram = new BigramRuImpl(words.get(i - 1), words.get(i));
            bigramStatistic.plusOneNgram(bigram);
        }

        return bigramStatistic;
    }

    @Override
    public BigramEnStatisticImpl makeBigramEnStatistic(ArrayList<String> words) {
        BigramEnStatisticImpl bigramStatistic = new BigramEnStatisticImpl();

        for (int i = 1; i < words.size(); i++) {
            BigramEnImpl bigram = new BigramEnImpl(words.get(i - 1), words.get(i));
            bigramStatistic.plusOneNgram(bigram);
        }

        return bigramStatistic;
    }

    /**
     * Создание статистики для триграмм на основе списка слов.
     * @param words - список слов.
     * @return
     */
    @Override
    public ThreegramRuStatisticImpl makeThreegramRuStatistic(ArrayList<String> words) {
        ThreegramRuStatisticImpl threegramStatistic = new ThreegramRuStatisticImpl();

        for (int i = 2; i < words.size(); i++) {

            ThreegramRuImpl threegram;
            threegram = new ThreegramRuImpl(words.get(i - 2), words.get(i - 1), words.get(i));

            threegramStatistic.plusOneNgram(threegram);
        }

        return threegramStatistic;
    }

    @Override
    public ThreegramEnStatisticImpl makeThreegramEnStatistic(ArrayList<String> words) {
        ThreegramEnStatisticImpl threegramStatistic = new ThreegramEnStatisticImpl();

        for (int i = 2; i < words.size(); i++) {

            ThreegramEnImpl threegram;
            threegram = new ThreegramEnImpl(words.get(i - 2), words.get(i - 1), words.get(i));

            threegramStatistic.plusOneNgram(threegram);
        }

        return threegramStatistic;
    }

    /**
     * Создание статистики для фограмм на основе списка слов.
     * @param words - список слов.
     * @return
     */
    @Override
    public FourgramRuStatisticImpl makeFourgramRuStatistic(ArrayList<String> words) {
        FourgramRuStatisticImpl fourgramStatistic = new FourgramRuStatisticImpl();

        for (int i = 3; i < words.size(); i++) {

            FourgramRuImpl fourgram;
            fourgram = new FourgramRuImpl(words.get(i - 3), words.get(i - 2), words.get(i - 1), words.get(i));

            fourgramStatistic.plusOneNgram(fourgram);
        }

        return fourgramStatistic;
    }

    @Override
    public FourgramEnStatisticImpl makeFourgramEnStatistic(ArrayList<String> words) {
        FourgramEnStatisticImpl fourgramStatistic = new FourgramEnStatisticImpl();

        for (int i = 3; i < words.size(); i++) {

            FourgramEnImpl fourgram;
            fourgram = new FourgramEnImpl(words.get(i - 3), words.get(i - 2), words.get(i - 1), words.get(i));

            fourgramStatistic.plusOneNgram(fourgram);
        }

        return fourgramStatistic;
    }
}
