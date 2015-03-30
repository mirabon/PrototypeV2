package com.artech.prototype2.saver.entity;

/**
 * Created by User on 14.12.2014.
 */
public class BigramRuVarOne implements java.io.Serializable, Entity {

    private Integer ruid;
    private String wordOne;
    private String wordTwo;
    private int count;

    public BigramRuVarOne(){}

    public BigramRuVarOne(String wordOne, String wordTwo, int count){
        this.wordOne = wordOne;
        this.wordTwo = wordTwo;
        this.count = count;
    }

    public Integer getRuid() {
        return ruid;
    }

    public void setRuid(Integer ruid) {
        this.ruid = ruid;
    }

    public String getWordOne() {
        return wordOne;
    }

    public void setWordOne(String wordOne) {
        this.wordOne = wordOne;
    }

    public String getWordTwo() {
        return wordTwo;
    }

    public void setWordTwo(String wordTwo) {
        this.wordTwo = wordTwo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
