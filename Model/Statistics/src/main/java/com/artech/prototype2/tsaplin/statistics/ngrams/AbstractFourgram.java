package com.artech.prototype2.tsaplin.statistics.ngrams;

/**
 * Абстрактный класс фограмм.
 *
 * Created by atsaplin on 09.12.2014.
 */
public abstract class AbstractFourgram extends AbstractNgram {
    protected String first;
    protected String second;
    protected String third;
    protected String fourth;





    /**
     * Геттер для н-ного слова.
     * @param n - номер слова.
     * @return - слово в виде строки, null при ошибочном n.
     */
    @Override
    public String getNthWord(int n) {
        switch(n){
            case 1: return first;
            case 2: return second;
            case 3: return third;
            case 4: return fourth;
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
            case 1: first = word;
                break;
            case 2: second = word;
                break;
            case 3: third = word;
                break;
            case 4: fourth = word;
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractFourgram fourgram = (AbstractFourgram) o;

        if (!first.equals(fourgram.first)) return false;
        if (!fourth.equals(fourgram.fourth)) return false;
        if (!second.equals(fourgram.second)) return false;
        if (!third.equals(fourgram.third)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + second.hashCode();
        result = 31 * result + third.hashCode();
        result = 31 * result + fourth.hashCode();
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

    public String getFourth() {
        return fourth;
    }

    public void setFourth(String fourth) {
        this.fourth = fourth;
    }
}

