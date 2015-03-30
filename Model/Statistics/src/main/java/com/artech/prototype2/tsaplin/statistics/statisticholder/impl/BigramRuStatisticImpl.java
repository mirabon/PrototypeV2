package com.artech.prototype2.tsaplin.statistics.statisticholder.impl;

import com.artech.prototype2.saver.entity.BigramRuVarOne;
import com.artech.prototype2.tsaplin.statistics.ngrams.impl.BigramRuImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.AbstractNgramStatistic;

import java.util.HashMap;
import java.util.List;

/**
 * Класс для хранения статистики русскоязычных биграмм.
 * Created by User on 14.12.2014.
 */
public class BigramRuStatisticImpl extends AbstractNgramStatistic<BigramRuImpl> {
    public BigramRuStatisticImpl(){this.setMap(new HashMap<BigramRuImpl, Integer>());}

    public BigramRuStatisticImpl(List<BigramRuVarOne> list){
        this.setMap(new HashMap<BigramRuImpl, Integer>());
        for(BigramRuVarOne dict: list){
            this.put(new BigramRuImpl(dict), dict.getCount());
        }
    }
}
