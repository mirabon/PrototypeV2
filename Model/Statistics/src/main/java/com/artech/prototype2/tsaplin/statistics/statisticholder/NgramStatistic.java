package com.artech.prototype2.tsaplin.statistics.statisticholder;

import com.artech.prototype2.tsaplin.statistics.ngrams.Ngram;

import java.util.HashMap;
import java.util.Map;

/**
 * Интерфейс для класса, хранящего в себе статистику.
 *
 * Created by atsaplin on 09.12.2014.
 */
public interface NgramStatistic<Type extends Ngram> extends Map<Type, Integer> {

    /**
     * Метод увеличивает статистику для одной н-граммы.
     * Если н-грамма уже есть в статистике, то увеличивает значение для нее на 1.
     * Если нет - то добавляет нграмму со значением, равным 1
     *
     * @param ngram
     */
    public void plusOneNgram(Type ngram);

    /**
     * Метод обновляет статистику для данной нграммы.
     *
     * @param ngram - нграмма
     * @param count - новое значение.
     */
    public void updateStatisticForNgram(Type ngram, Integer count);

}
