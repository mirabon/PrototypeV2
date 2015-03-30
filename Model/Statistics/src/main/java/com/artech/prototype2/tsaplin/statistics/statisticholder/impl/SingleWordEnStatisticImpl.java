package com.artech.prototype2.tsaplin.statistics.statisticholder.impl;

import com.artech.prototype2.saver.entity.DictionaryEn;
import com.artech.prototype2.tsaplin.statistics.ngrams.impl.SingleWordEnImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.AbstractNgramStatistic;

import java.util.HashMap;
import java.util.List;

/**
 * Класс для хранения статистики англоязычных одиночных слов.
 * Created by User on 14.12.2014.
 */
public class SingleWordEnStatisticImpl extends AbstractNgramStatistic<SingleWordEnImpl> {
    public SingleWordEnStatisticImpl(){this.setMap(new HashMap<SingleWordEnImpl, Integer>());}

    public SingleWordEnStatisticImpl(List<DictionaryEn> list){
        this.setMap(new HashMap<SingleWordEnImpl, Integer>());
        for (DictionaryEn dict: list) {
            this.put(new SingleWordEnImpl(dict), dict.getCount());

        }
    }
}
