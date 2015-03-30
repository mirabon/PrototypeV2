package com.artech.prototype2.tsaplin.statistics.ngrams.impl;

import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.saver.entity.FourgramEnVarOne;
import com.artech.prototype2.tsaplin.statistics.ngrams.AbstractFourgram;

/**
 * Англоязычные фограммы.
 * Created by User on 13.12.2014.
 */
public class FourgramEnImpl extends AbstractFourgram {
    /**
     * Конструктор для класса.
     *
     * @param first
     * @param second
     * @param third
     * @param fourth
     */
    public FourgramEnImpl(String first, String second, String third, String fourth){
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }
    public FourgramEnImpl(FourgramEnVarOne fourgramEnVarOne){
        this.setFirst(fourgramEnVarOne.getWordOne());
        this.setSecond(fourgramEnVarOne.getWordTwo());
        this.setThird(fourgramEnVarOne.getWordThree());
        this.setFourth(fourgramEnVarOne.getWordFour());
    }

    @Override
    public FourgramEnVarOne makeDictionary(int count) {
        return new FourgramEnVarOne(this.getFirst(), this.getSecond(), this.getThird(), this.getFourth(), count);
    }
}
