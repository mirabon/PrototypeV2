package com.artech.prototype2.saver.entity;

import java.io.Serializable;

/**
 * Created by User on 22.12.2014.
 */
public class IdfRu implements Serializable, Entity {
    private Integer ruid;
    private Integer docsCount;
    private float idf;

    public IdfRu(){}

    public Integer getRuid() {
        return ruid;
    }

    public void setRuid(Integer ruid) {
        this.ruid = ruid;
    }

    public Integer getDocsCount() {
        return docsCount;
    }

    public void setDocsCount(Integer docsCount) {
        this.docsCount = docsCount;
    }

    public float getIdf() {
        return idf;
    }

    public void setIdf(float idf) {
        this.idf = idf;
    }
}
