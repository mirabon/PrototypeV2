package com.artech.prototype2.tsaplin.statistics;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.tsaplin.statistics.statisticholder.AbstractNgramStatistic;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.*;

/**
 * Интерфейс сохранения статистики в базу данных.
 *
 * Created by User on 13.12.2014.
 */
public interface StatisticSaverToDB {
    /**
     * Сохранение русскоязычных одиночных слов в БД.
     * @param statistic
     * @param db
     */
    public void saveStatisticToDB(SingleWordRuStatisticImpl statistic, AbstractSUBD db);

    /**
     * Сохранение англоязычных одиночных слов в БД.
     * @param statistic
     * @param db
     */
    public void saveStatisticToDB(SingleWordEnStatisticImpl statistic, AbstractSUBD db);

    /**
     * Сохранение русскоязычных биграмм в БД.
     * @param statistic
     * @param db
     */
    public void saveStatisticToDB(BigramRuStatisticImpl statistic, AbstractSUBD db);

    /**
     * Сохранение англоязычных биграмм в БД.
     * @param statistic
     * @param db
     */
    public void saveStatisticToDB(BigramEnStatisticImpl statistic, AbstractSUBD db);

    /**
     * Сохранение русскоязычных триграмм в БД.
     * @param statistic
     * @param db
     */
    public void saveStatisticToDB(ThreegramRuStatisticImpl statistic, AbstractSUBD db);

    /**
     * Сохранение англоязычныых триграмм в БД.
     * @param statistic
     * @param db
     */
    public void saveStatisticToDB(ThreegramEnStatisticImpl statistic, AbstractSUBD db);

    /**
     * Сохранение русскоязычных форграмм в БД.
     * @param statistic
     * @param db
     */
    public void saveStatisticToDB(FourgramRuStatisticImpl statistic, AbstractSUBD db);

    /**
     * Сохранение англоязычных форграммв БД.
     * @param statistic
     * @param db
     */
    public void saveStatisticToDB(FourgramEnStatisticImpl statistic, AbstractSUBD db);
}
