package com.artech.prototype2.tsaplin.statistics.ngrams.impl;

import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.saver.entity.FourgramRuVarOne;
import com.artech.prototype2.tsaplin.statistics.ngrams.AbstractFourgram;

/**
 * Русскоязычные фограммы.
 * Created by User on 13.12.2014.
 */
public class FourgramRuImpl extends AbstractFourgram {
    /**
     * Конструктор для класса.
     *
     * @param first
     * @param second
     * @param third
     * @param fourth
     */
    public FourgramRuImpl(String first, String second, String third, String fourth){
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }
    public FourgramRuImpl(FourgramRuVarOne fourgramRuVarOne){
        this.setFirst(fourgramRuVarOne.getWordOne());
        this.setSecond(fourgramRuVarOne.getWordTwo());
        this.setThird(fourgramRuVarOne.getWordThree());
        this.setFourth(fourgramRuVarOne.getWordFour());
    }

    @Override
    public FourgramRuVarOne makeDictionary(int count) {
        return new FourgramRuVarOne(this.getFirst(), this.getSecond(), this.getThird(), this.getFourth(), count);
    }
}
