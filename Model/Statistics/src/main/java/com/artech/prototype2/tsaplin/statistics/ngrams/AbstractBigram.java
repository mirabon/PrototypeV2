package com.artech.prototype2.tsaplin.statistics.ngrams;

/**
 * Абстрактный класс биграмм.
 *
 * Created by atsaplin on 09.12.2014.
 */
public abstract class AbstractBigram extends AbstractNgram {

    protected String first;
    protected String second;




    /**
     * Геттер для н-ного слова.
     *
     * @param n - номер слова.
     * @return слово в виде строки, null при ошибочном n
     */
    @Override
    public String getNthWord(int n) {
        switch (n){
            case 1: return first;
            case 2: return second;
        }
        return null;
    }

    /**
     * Сеттер для н-ного слова.
     *
     * @param word - слово, которое требуется подставить.
     * @param n - позиция, в которую надо записать слово.
     */
    @Override
    public void setNthWord(String word, int n) {
        switch (n){
            case 1: this.first = word;
                break;
            case 2: this.second = word;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractBigram bigram = (AbstractBigram) o;

        if (!first.equals(bigram.first)) return false;
        if (!second.equals(bigram.second)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + second.hashCode();
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
}
