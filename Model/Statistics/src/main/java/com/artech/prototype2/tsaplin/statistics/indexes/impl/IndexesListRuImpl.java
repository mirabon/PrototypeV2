package com.artech.prototype2.tsaplin.statistics.indexes.impl;

import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.saver.entity.IndexesRu;
import com.artech.prototype2.tsaplin.statistics.indexes.IndexesList;

import java.util.ArrayList;

/**
 * Created by User on 23.12.2014.
 */
public class IndexesListRuImpl implements IndexesList {
    private ArrayList<Integer> ruids;
    private ArrayList<Integer> docids;
    private ArrayList<Integer> positions;
    private ArrayList<Float> tfs;
    private ArrayList<Float> tfidfs;

    @Override
    public IndexesRu makeNthIndex(int n) {
        IndexesRu indexesRu = new IndexesRu();
        indexesRu.setRuid(ruids.get(n));
        indexesRu.setDocid(docids.get(n));
        indexesRu.setPosit(positions.get(n));
        indexesRu.setTf(tfs.get(n));
        indexesRu.setTfIdf(tfidfs.get(n));

        return indexesRu;
    }

    @Override
    public void addIndex(Integer id, Integer docid, Integer position, Float tf, Float tfidf) {
        ruids.add(id);
        docids.add(docid);
        positions.add(position);
        tfs.add(tf);
        tfidfs.add(tfidf);
    }

    @Override
    public int size() {
        return ruids.size();
    }
}
