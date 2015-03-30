package com.artech.prototype2.tsaplin.statistics.indexes;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.SingleWordEnStatisticImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.SingleWordRuStatisticImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by User on 23.12.2014.
 */
public interface IndexCounter {

    public Integer findDocid(String fileName, AbstractSUBD db, String lang);

    public Integer findWordId(String word, AbstractSUBD db, String lang);


    public Integer countPosition(ArrayList<String> wordsInDoc, String word);

    public Map<String, Integer> makeMapOfPositions(ArrayList<String> wordsInDoc, Set<String> words);

    public Float countTf(Integer docSize, Integer countOfWordOccurrences);

    public Map<String, Float> makeMapOfTfs(ArrayList<String> listOfWords, SingleWordEnStatisticImpl statistic);

    public Map<String, Float> makeMapOfTfs(ArrayList<String> listOfWords, SingleWordRuStatisticImpl statistic);

    public Map<String, Float> makeMapOfIdfs(AbstractSUBD db, String lang, Set<String> words);

    public Float countIdf(Integer countOfDocsHavingThisWord, Integer countOfDocs);

    public Float countTfIdf(Float tf, Float idf);
}
