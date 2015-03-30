package com.artech.prototype2.tsaplin.statistics.ngrams;


import com.artech.prototype2.saver.entity.Entity;

import java.io.Serializable;

/**
 * Интерфейс для N-грамм.
 *
 * Created by atsaplin on 09.12.2014.
 */
public interface Ngram {



    /**
     * Геттер для n-ного слова в n-грамме.
     *
     * @param n - номер слова.
     * @return - слово в виде строки, null при ошибочном n
     */
    public String getNthWord(int n);

    /**
     * Сеттер для n-го слова в n-грамме.
     *
     * @param word - слово, которое требуется подставить.
     * @param n - позиция, в которую надо записать слово.
     */
    public void setNthWord(String word, int n);

    /**
     * Метод, создающий сущность для работы с БД, соответствующий нграмме.
     * @param count
     * @return
     */
    public Entity makeDictionary(int count);

}
