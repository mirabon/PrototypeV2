package com.artech.prototype2.saver.entity;

import java.io.Serializable;

/**
 * Created by User on 13.12.2014.
 */
public class DictionaryEn implements Serializable, Entity {
    private Integer enid;
    private String word;
    private int count;

    public DictionaryEn(){
    }

    public DictionaryEn(String word, int count){
        this.word = word;
        this.count = count;
    }

    public Integer getEnid() {
        return enid;
    }

    public void setEnid(Integer enid) {
        this.enid = enid;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
