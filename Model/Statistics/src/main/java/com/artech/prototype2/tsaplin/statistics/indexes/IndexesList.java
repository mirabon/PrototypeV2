package com.artech.prototype2.tsaplin.statistics.indexes;

import com.artech.prototype2.saver.entity.Entity;

/**
 * Created by User on 23.12.2014.
 */
public interface IndexesList {
    public Entity makeNthIndex(int n);

    public void addIndex(Integer id, Integer docid, Integer position, Float tf, Float tfidf);

    public int size();
}
