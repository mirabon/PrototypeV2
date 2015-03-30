/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artech.prototype2.tsaplin.statistics.ngrams.impl;


import com.artech.prototype2.saver.entity.BigramEnVarOne;
import com.artech.prototype2.saver.entity.BigramRuVarOne;
import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.tsaplin.statistics.ngrams.AbstractBigram;

/**
 *Англоязычные биграммы.
 * @author CANDY
 */
public class BigramEnImpl extends AbstractBigram {
    /**
     * Конструктор для класса.
     *
     * @param first - первое слово.
     * @param second - второе слово.
     */
    public BigramEnImpl(String first, String second){
        this.first = first;
        this.second = second;
    }
    public BigramEnImpl(BigramEnVarOne bigramEnVarOne){
        this.setFirst(bigramEnVarOne.getWordOne());
        this.setSecond(bigramEnVarOne.getWordTwo());
    }

    @Override
    public BigramEnVarOne makeDictionary(int count) {
        return new BigramEnVarOne(this.getFirst(), this.getSecond(), count);
    }
}
