package com.artech.prototype2.saver.entity;

import java.io.Serializable;

/**
 * Created by User on 22.12.2014.
 */
public class DocumentRu implements Entity, Serializable {
    private Integer docid;
    private String name;
    private String format;

    public DocumentRu(){}

    public Integer getDocid() {
        return docid;
    }

    public void setDocid(Integer docid) {
        this.docid = docid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
