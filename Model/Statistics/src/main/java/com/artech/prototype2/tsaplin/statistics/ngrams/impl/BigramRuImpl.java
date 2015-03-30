package com.artech.prototype2.tsaplin.statistics.ngrams.impl;

import com.artech.prototype2.saver.entity.BigramRuVarOne;
import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.tsaplin.statistics.ngrams.AbstractBigram;

/**
 * Русскоязычные биграммы.
 * Created by User on 13.12.2014.
 */
public class BigramRuImpl extends AbstractBigram {
    /**
     * Конструктор для класса.
     *
     * @param first - первое слово.
     * @param second - второе слово.
     */
    public BigramRuImpl(String first, String second){
        this.first = first;
        this.second = second;
    }

    public BigramRuImpl(BigramRuVarOne bigramRuVarOne){
        this.setFirst(bigramRuVarOne.getWordOne());
        this.setSecond(bigramRuVarOne.getWordTwo());
    }

    @Override
    public BigramRuVarOne makeDictionary(int count) {
        return new BigramRuVarOne(this.getFirst(), this.getSecond(), count);
    }
}
