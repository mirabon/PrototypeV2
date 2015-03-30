package com.artech.prototype2.tsaplin.statistics;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.tsaplin.statistics.indexes.impl.IndexesListEnImpl;
import com.artech.prototype2.tsaplin.statistics.indexes.impl.IndexesListRuImpl;

import java.util.Set;

/**
 * Created by User on 22.12.2014.
 */
public interface IndexesSaverToDB {
    public void reCountRuIdf(AbstractSUBD db);

    public void reCountEnIdf(AbstractSUBD db);

    public void addWordsToIdfRu(Set<String> words, AbstractSUBD db);

    public void addWordsToIdfEn(Set<String> words, AbstractSUBD db);

    public void saveIndexesRu(IndexesListRuImpl indexList, AbstractSUBD db);

    public void saveIndexesEn(IndexesListEnImpl indexList, AbstractSUBD db);
}
