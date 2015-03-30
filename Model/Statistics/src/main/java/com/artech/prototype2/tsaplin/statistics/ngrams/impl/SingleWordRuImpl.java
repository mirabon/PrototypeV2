package com.artech.prototype2.tsaplin.statistics.ngrams.impl;

import com.artech.prototype2.saver.entity.DictionaryRu;
import com.artech.prototype2.tsaplin.statistics.ngrams.AbstractSingleWord;

/**
 * Русскоязычные монослова.
 * Created by User on 13.12.2014.
 */
public class SingleWordRuImpl extends AbstractSingleWord {

    /**
     * Конструктор для класса.
     *
     * @param word - строка, на основании которой создается слово.
     */
    public SingleWordRuImpl(String word){
        this.word = word;
    }

    public SingleWordRuImpl(DictionaryRu dictionaryRu){
        this.setWord(dictionaryRu.getWord());
    }

    public DictionaryRu makeDictionary(int count){
        return new DictionaryRu(this.getWord(), count);
    }



}
