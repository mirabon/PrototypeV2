/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artech.prototype2.tsaplin.statistics.statisticholder.impl;

import com.artech.prototype2.saver.entity.ThreegramRuVarOne;
import com.artech.prototype2.tsaplin.statistics.ngrams.impl.ThreegramRuImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.AbstractNgramStatistic;

import java.util.HashMap;
import java.util.List;

/**
 *Класс для хранения статистики русскоязычных триграмм.
 * @author CANDY
 */
public class ThreegramRuStatisticImpl extends AbstractNgramStatistic<ThreegramRuImpl> {

    public ThreegramRuStatisticImpl(){this.setMap(new HashMap<ThreegramRuImpl, Integer>());}

    public ThreegramRuStatisticImpl(List<ThreegramRuVarOne> list){
        this.setMap(new HashMap<ThreegramRuImpl, Integer>());
        for(ThreegramRuVarOne dict: list){
            this.put(new ThreegramRuImpl(dict), dict.getCount());
        }
    }
}
