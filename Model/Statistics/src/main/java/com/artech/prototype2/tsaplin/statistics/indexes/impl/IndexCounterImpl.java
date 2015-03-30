package com.artech.prototype2.tsaplin.statistics.indexes.impl;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.tsaplin.statistics.indexes.IndexCounter;
import com.artech.prototype2.tsaplin.statistics.ngrams.impl.SingleWordEnImpl;
import com.artech.prototype2.tsaplin.statistics.ngrams.impl.SingleWordRuImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.SingleWordEnStatisticImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.SingleWordRuStatisticImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by User on 23.12.2014.
 */
public class IndexCounterImpl implements IndexCounter {


    @Override
    public Integer findWordId(String word, AbstractSUBD db, String lang) {
        return null;
    }

    @Override
    public Integer findDocid(String fileName, AbstractSUBD db, String lang) {
        return null;
    }



    @Override
    public Integer countPosition(ArrayList<String> wordsInDoc, String word) {

        return wordsInDoc.indexOf(word);
    }

    @Override
    public Map<String, Integer> makeMapOfPositions(ArrayList<String> wordsInDoc, Set<String> words) {
        Map<String, Integer> mapOfPositions = new HashMap<String, Integer>();
        for(String w: words){
            mapOfPositions.put(w, this.countPosition(wordsInDoc, w));
        }

        return mapOfPositions;
    }

    @Override
    public Float countTf(Integer docSize, Integer countOfWordOccurrences) {
        return countOfWordOccurrences/ ((float)docSize);
    }




    @Override
    public Map<String, Float> makeMapOfTfs(ArrayList<String> listOfWords, SingleWordEnStatisticImpl statistic) {
        Map<String, Float> mapOfTfs = new HashMap<String, Float>();
        Integer docSize = listOfWords.size();
        for(Map.Entry<SingleWordEnImpl, Integer> entry: statistic.entrySet()){
            Float tf = countTf(docSize, entry.getValue());
            mapOfTfs.put(entry.getKey().getWord(), tf);
        }

        return mapOfTfs;
    }

    @Override
    public Map<String, Float> makeMapOfTfs(ArrayList<String> listOfWords, SingleWordRuStatisticImpl statistic) {
        Map<String, Float> mapOfTfs = new HashMap<String, Float>();
        Integer docSize = listOfWords.size();
        for(Map.Entry<SingleWordRuImpl, Integer> entry: statistic.entrySet()){
            Float tf = countTf(docSize, entry.getValue());
            mapOfTfs.put(entry.getKey().getWord(), tf);
        }

        return mapOfTfs;
    }


    @Override
    public Map<String, Float> makeMapOfIdfs(AbstractSUBD db, String lang, Set<String> words) {
        return null;
    }

    @Override
    public Float countIdf(Integer countOfDocsHavingThisWord, Integer countOfDocs) {
        return (float)Math.log((countOfDocs/(float)countOfDocsHavingThisWord));
    }

    @Override
    public Float countTfIdf(Float tf, Float idf) {
        return tf*idf;
    }
}
