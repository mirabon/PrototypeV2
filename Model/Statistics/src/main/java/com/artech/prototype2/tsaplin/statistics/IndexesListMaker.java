package com.artech.prototype2.tsaplin.statistics;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.tsaplin.statistics.indexes.impl.IndexesListEnImpl;
import com.artech.prototype2.tsaplin.statistics.indexes.impl.IndexesListRuImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.SingleWordEnStatisticImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.SingleWordRuStatisticImpl;

import java.util.ArrayList;

/**
 * Created by User on 23.12.2014.
 */
public interface IndexesListMaker {
    public IndexesListRuImpl makeIndexesListRu(String fileName, ArrayList<String> wordsInDoc, SingleWordRuStatisticImpl statistic);

    public IndexesListEnImpl makeIndexesListEn(String fileName, ArrayList<String> wordsInDoc, SingleWordEnStatisticImpl statistic);

}
