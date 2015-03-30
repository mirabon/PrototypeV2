package com.artech.prototype2.tsaplin.statistics.indexes.impl;

import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.saver.entity.IndexesEn;
import com.artech.prototype2.tsaplin.statistics.indexes.IndexesList;

import java.util.ArrayList;

/**
 * Created by User on 23.12.2014.
 */
public class IndexesListEnImpl implements IndexesList {
    private ArrayList<Integer> enids;
    private ArrayList<Integer> docids;
    private ArrayList<Integer> positions;
    private ArrayList<Float> tfs;
    private ArrayList<Float> tfidfs;

    @Override
    public IndexesEn makeNthIndex(int n) {
        IndexesEn indexesEn = new IndexesEn();
        indexesEn.setEnid(enids.get(n));
        indexesEn.setDocid(docids.get(n));
        indexesEn.setPosit(positions.get(n));
        indexesEn.setTf(tfs.get(n));
        indexesEn.setTfIdf(tfidfs.get(n));

        return indexesEn;
    }

    @Override
    public void addIndex(Integer id, Integer docid, Integer position, Float tf, Float tfidf) {
        enids.add(id);
        docids.add(docid);
        positions.add(position);
        tfs.add(tf);
        tfidfs.add(tfidf);
    }

    @Override
    public int size() {
        return enids.size();
    }
}
