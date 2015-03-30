package com.artech.prototype2.tsaplin.statistics.statisticholder.impl;

import com.artech.prototype2.saver.entity.FourgramEnVarOne;
import com.artech.prototype2.tsaplin.statistics.ngrams.impl.FourgramEnImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.AbstractNgramStatistic;

import java.util.HashMap;
import java.util.List;

/**
 * Класс для хранения статистики англооязычных фограмм.
 * Created by User on 14.12.2014.
 */
public class FourgramEnStatisticImpl extends AbstractNgramStatistic<FourgramEnImpl> {
    public FourgramEnStatisticImpl(){this.setMap(new HashMap<FourgramEnImpl, Integer>());}

    public FourgramEnStatisticImpl(List<FourgramEnVarOne> list){
        this.setMap(new HashMap<FourgramEnImpl, Integer>());
        for(FourgramEnVarOne dict: list){
            this.put(new FourgramEnImpl(dict), dict.getCount());
        }
    }
}
