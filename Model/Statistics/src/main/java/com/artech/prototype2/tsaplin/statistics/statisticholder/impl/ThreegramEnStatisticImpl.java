package com.artech.prototype2.tsaplin.statistics.statisticholder.impl;

import com.artech.prototype2.saver.entity.ThreegramEnVarOne;
import com.artech.prototype2.saver.entity.ThreegramRuVarOne;
import com.artech.prototype2.tsaplin.statistics.ngrams.impl.ThreegramEnImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.AbstractNgramStatistic;

import java.util.HashMap;
import java.util.List;

/**
 * Класс для хранения статистики англоязычных триграмм.
 * Created by User on 14.12.2014.
 */
public class ThreegramEnStatisticImpl extends AbstractNgramStatistic<ThreegramEnImpl> {

    public ThreegramEnStatisticImpl(){this.setMap(new HashMap<ThreegramEnImpl, Integer>());}

    public ThreegramEnStatisticImpl(List<ThreegramEnVarOne> list){
        this.setMap(new HashMap<ThreegramEnImpl, Integer>());
        for(ThreegramEnVarOne dict: list){
            this.put(new ThreegramEnImpl(dict), dict.getCount());
        }
    }
}
