package com.artech.prototype2.saver.entity;

/**
 * Created by User on 14.12.2014.
 */
public class ThreegramEnVarOne implements java.io.Serializable, Entity {
    private Integer enid;
    private String wordOne;
    private String wordTwo;
    private String wordThree;
    private int count;

    public ThreegramEnVarOne(){}

    public ThreegramEnVarOne(String wordOne, String wordTwo, String wordThree, int count){
        this.wordOne = wordOne;
        this.wordTwo = wordTwo;
        this.wordThree = wordThree;
        this.count = count;
    }

    public Integer getEnid() {
        return enid;
    }

    public void setEnid(Integer enid) {
        this.enid = enid;
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

    public String getWordThree() {
        return wordThree;
    }

    public void setWordThree(String wordThree) {
        this.wordThree = wordThree;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
