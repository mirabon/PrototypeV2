package com.artech.prototype2.tsaplin.statistics.ngrams.impl;

import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.saver.entity.ThreegramRuVarOne;
import com.artech.prototype2.tsaplin.statistics.ngrams.AbstractThreegram;

/**
 * Русскоязычные триграммы.
 * Created by User on 13.12.2014.
 */
public class ThreegramRuImpl extends AbstractThreegram {
    /**
     * Конструктор для класса.
     *
     * @param first - первое слово.
     * @param second - второе слово.
     * @param third - третье слово.
     */
    public ThreegramRuImpl(String first, String second, String third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
    public ThreegramRuImpl(ThreegramRuVarOne threegramRuVarOne){
        this.setFirst(threegramRuVarOne.getWordOne());
        this.setSecond(threegramRuVarOne.getWordTwo());
        this.setThird(threegramRuVarOne.getWordThree());
    }

    @Override
    public ThreegramRuVarOne makeDictionary(int count) {
        return new ThreegramRuVarOne(this.getFirst(), this.getSecond(), this.getThird(), count);
    }
}
