package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.tsaplin.statistics.IndexesListMaker;
import com.artech.prototype2.tsaplin.statistics.indexes.impl.IndexesListEnImpl;
import com.artech.prototype2.tsaplin.statistics.indexes.impl.IndexesListRuImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.SingleWordEnStatisticImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.SingleWordRuStatisticImpl;

import java.util.ArrayList;

/**
 * Created by User on 23.12.2014.
 */
public class IndexesListMakerImpl implements IndexesListMaker {
    @Override
    public IndexesListRuImpl makeIndexesListRu(String fileName, ArrayList<String> wordsInDoc, SingleWordRuStatisticImpl statistic) {
        return null;
    }

    @Override
    public IndexesListEnImpl makeIndexesListEn(String fileName, ArrayList<String> wordsInDoc, SingleWordEnStatisticImpl statistic) {
        return null;
    }
}
