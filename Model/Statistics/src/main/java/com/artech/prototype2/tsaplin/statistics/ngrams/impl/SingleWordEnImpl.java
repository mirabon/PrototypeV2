package com.artech.prototype2.tsaplin.statistics.ngrams.impl;

import com.artech.prototype2.saver.entity.DictionaryEn;
import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.tsaplin.statistics.ngrams.AbstractSingleWord;

/**
 * Англоязычные монослова.
 * Created by User on 13.12.2014.
 */
public class SingleWordEnImpl extends AbstractSingleWord {
    /**
     * Конструктор для класса.
     *
     * @param word - строка, на основании которой создается слово.
     */
    public SingleWordEnImpl(String word){
        this.word = word;
    }
    public SingleWordEnImpl(DictionaryEn dictionaryEn){
        this.setWord(dictionaryEn.getWord());
    }

    @Override
    public DictionaryEn makeDictionary(int count) {
        return new DictionaryEn(this.getWord(), count);
    }
}
