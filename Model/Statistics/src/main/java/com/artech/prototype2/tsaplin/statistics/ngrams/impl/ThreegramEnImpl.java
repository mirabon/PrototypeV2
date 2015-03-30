package com.artech.prototype2.tsaplin.statistics.ngrams.impl;

import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.saver.entity.ThreegramEnVarOne;
import com.artech.prototype2.tsaplin.statistics.ngrams.AbstractThreegram;

/**
 * Англоязычные триграммы.
 * Created by User on 13.12.2014.
 */
public class ThreegramEnImpl extends AbstractThreegram {


    /**
     * Конструктор для класса.
     *
     * @param first - первое слово.
     * @param second - второе слово.
     * @param third - третье слово.
     */
    public ThreegramEnImpl(String first, String second, String third){
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public ThreegramEnImpl(ThreegramEnVarOne threegramEnVarOne){
        this.setFirst(threegramEnVarOne.getWordOne());
        this.setSecond(threegramEnVarOne.getWordTwo());
        this.setThird(threegramEnVarOne.getWordThree());
    }

    @Override
    public ThreegramEnVarOne makeDictionary(int count) {
        return new ThreegramEnVarOne(this.getFirst(), this.getSecond(), this.getThird(), count);
    }
}
