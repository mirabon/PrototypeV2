package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.tsaplin.statistics.IndexesSaverToDB;
import com.artech.prototype2.tsaplin.statistics.indexes.impl.IndexesListEnImpl;
import com.artech.prototype2.tsaplin.statistics.indexes.impl.IndexesListRuImpl;

import java.util.Set;

/**
 * Created by User on 22.12.2014.
 */
public class IndexesSaverToDBImpl implements IndexesSaverToDB {
    @Override
    public void reCountRuIdf(AbstractSUBD db) {

    }

    @Override
    public void reCountEnIdf(AbstractSUBD db) {

    }

    @Override
    public void addWordsToIdfRu(Set<String> words, AbstractSUBD db) {

    }

    @Override
    public void addWordsToIdfEn(Set<String> words, AbstractSUBD db) {

    }

    @Override
    public void saveIndexesRu(IndexesListRuImpl indexList, AbstractSUBD db) {

    }

    @Override
    public void saveIndexesEn(IndexesListEnImpl indexList, AbstractSUBD db) {

    }
}
