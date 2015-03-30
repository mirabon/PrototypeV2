package com.artech.prototype2.tsaplin.statistics.statisticholder.impl;

import com.artech.prototype2.saver.entity.BigramEnVarOne;
import com.artech.prototype2.tsaplin.statistics.ngrams.impl.BigramEnImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.AbstractNgramStatistic;
//import com.artech.prototype2.tsaplin.statistics.ngrams.impl.BigramEnImpl;
//import com.artech.prototype2.tsaplin.statistics.statisticholder.AbstractNgramStatistic;

import java.util.HashMap;
import java.util.List;

/**
 * Класс для хранения статистики англоязычных биграмм.
 * Created by User on 14.12.2014.
 */
public class BigramEnStatisticImpl extends AbstractNgramStatistic<BigramEnImpl> {
    public BigramEnStatisticImpl(){this.setMap(new HashMap<BigramEnImpl, Integer>());}

    public BigramEnStatisticImpl(List<BigramEnVarOne> list){
        this.setMap(new HashMap<BigramEnImpl, Integer>());
        for(BigramEnVarOne dict: list){
            this.put(new BigramEnImpl(dict), dict.getCount());
        }
    }
}
