package com.artech.prototype2.tsaplin.statistics.ngrams;

/**
 * Абстрактный класс триграмм.
 *
 * Created by atsaplin on 09.12.2014.
 */
public abstract class AbstractThreegram extends AbstractNgram {
    protected String first;
    protected String second;
    protected String third;



    /**
     * Геттер для класса.
     *
     * @param n - номер слова.
     * @return слово в виде строки, null при ошибочном n.
     */
    @Override
    public String getNthWord(int n) {
        switch(n){
            case 1: return first;
            case 2: return second;
            case 3: return third;
        }
        return null;
    }

    /**
     * Сеттер для класса.
     * @param word - слово, которое требуется подставить.
     * @param n - позиция, в которую надо записать слово.
     */
    @Override
    public void setNthWord(String word, int n) {
        switch(n){
            case 1: this.first = word;
                break;
            case 2: this.second = word;
                break;
            case 3: this.third = word;
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractThreegram threegram = (AbstractThreegram) o;

        if (!first.equals(threegram.first)) return false;
        if (!second.equals(threegram.second)) return false;
        if (!third.equals(threegram.third)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + second.hashCode();
        result = 31 * result + third.hashCode();
        return result;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }
}
