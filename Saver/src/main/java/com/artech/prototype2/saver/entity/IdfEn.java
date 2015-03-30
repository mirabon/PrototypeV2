package com.artech.prototype2.saver.entity;

import org.hibernate.annotations.Table;

import java.io.Serializable;


import javax.persistence.*;

/**
 * Created by User on 22.12.2014.
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "idf_en")
public class IdfEn implements Serializable, Entity {

    @Id
    @Column(name = "enid")
    @OneToOne(targetEntity = DictionaryEn.class)
    @JoinColumn(name = "enid")
    private Integer enid;

    @Column(name = "docs_count")
    private Integer docsCount;

    @Column(name  = "idf")
    private float idf;

    public IdfEn(){}

    public Integer getEnid() {
        return enid;
    }

    public void setEnid(Integer enid) {
        this.enid = enid;
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
