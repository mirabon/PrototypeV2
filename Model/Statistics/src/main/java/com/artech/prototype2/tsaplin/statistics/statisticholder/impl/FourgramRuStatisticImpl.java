package com.artech.prototype2.tsaplin.statistics.statisticholder.impl;

import com.artech.prototype2.saver.entity.FourgramRuVarOne;
import com.artech.prototype2.tsaplin.statistics.ngrams.impl.FourgramRuImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.AbstractNgramStatistic;

import java.util.HashMap;
import java.util.List;

/**
 * Класс для хранения статистики русскоязычных фограмм.
 * Created by User on 14.12.2014.
 */
public class FourgramRuStatisticImpl extends AbstractNgramStatistic<FourgramRuImpl> {

    public FourgramRuStatisticImpl(){this.setMap(new HashMap<FourgramRuImpl, Integer>());}

    public FourgramRuStatisticImpl(List<FourgramRuVarOne> list){
        this.setMap(new HashMap<FourgramRuImpl, Integer>());
        for(FourgramRuVarOne dict: list){
            this.put(new FourgramRuImpl(dict), dict.getCount());
        }
    }
}
