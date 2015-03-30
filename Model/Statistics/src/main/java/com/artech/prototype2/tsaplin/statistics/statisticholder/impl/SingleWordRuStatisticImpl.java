package com.artech.prototype2.tsaplin.statistics.statisticholder.impl;

import com.artech.prototype2.saver.entity.DictionaryRu;
import com.artech.prototype2.tsaplin.statistics.ngrams.impl.SingleWordRuImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.AbstractNgramStatistic;

import java.util.HashMap;
import java.util.List;

/**
 * Класс для хранения статистики русскоязычных биграмм.
 * Created by User on 13.12.2014.
 */
public class SingleWordRuStatisticImpl extends AbstractNgramStatistic<SingleWordRuImpl> {

    public SingleWordRuStatisticImpl(){this.setMap(new HashMap<SingleWordRuImpl, Integer>());}

    public SingleWordRuStatisticImpl(List<DictionaryRu> list){
        this.setMap(new HashMap<SingleWordRuImpl, Integer>());
        for(DictionaryRu dict: list){
            this.put(new SingleWordRuImpl(dict), dict.getCount());
        }
    }


}
