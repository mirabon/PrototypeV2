package com.artech.prototype2.saver.entity;

import java.io.Serializable;

/**
 * Created by User on 22.12.2014.
 */
public class IndexesRu implements Serializable, Entity {
    private Integer indexId;
    private Integer ruid;
    private Integer docid;
    private Integer posit;
    private float tf;
    private float tfIdf;

    public IndexesRu(){}

    public Integer getIndexId() {
        return indexId;
    }

    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    public Integer getRuid() {
        return ruid;
    }

    public void setRuid(Integer ruid) {
        this.ruid = ruid;
    }

    public Integer getDocid() {
        return docid;
    }

    public void setDocid(Integer docid) {
        this.docid = docid;
    }

    public Integer getPosit() {
        return posit;
    }

    public void setPosit(Integer posit) {
        this.posit = posit;
    }

    public float getTf() {
        return tf;
    }

    public void setTf(float tf) {
        this.tf = tf;
    }

    public float getTfIdf() {
        return tfIdf;
    }

    public void setTfIdf(float tfIdf) {
        this.tfIdf = tfIdf;
    }
}
