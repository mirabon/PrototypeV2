package com.artech.prototype2.tsaplin.statistics.statisticholder;

import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.tsaplin.statistics.ngrams.Ngram;

import java.util.*;


/**
 * Абстрактных класс, хранящий статистику.
 * Хранит статистику в ХэшКарте map, где ключом является нграмма, значением - количество раз, которые она встречалась.
 *
 * Created by atsaplin on 09.12.2014.
 */
public abstract class AbstractNgramStatistic<Type extends Ngram> implements NgramStatistic<Type> {

    private HashMap<Type, Integer> map;



    /**
     * Метод увеличивает статистику для одной н-граммы.
     * Если н-грамма уже есть в статистике, то увеличивает значение для нее на 1.
     * Если нет - то добавляет нграмму со значением, равным 1
     * @param ngram
     */
    @Override
    public void plusOneNgram(Type ngram) {
        if(map.containsKey(ngram)) map.put(ngram, map.get(ngram) + 1);
        else map.put(ngram, 1);
    }

    /**
     * Метод обновляет статистику для данной нграммы.
     * @param ngram - нграмма
     * @param count - новое значение.
     */
    @Override
    public void updateStatisticForNgram(Type ngram, Integer count) {
        map.put(ngram, count);
    }

    /**
     * Метод возвращает HashMap со статистикой для нграмм.
     * @return
     */
    public HashMap<Type, Integer> getMap(){
        return this.map;
    }

    /**
     * Метод устанавливает HashMap со статистикой для нграмм.
     * @param map
     */
    public void setMap(HashMap<Type, Integer> map) {
        this.map = map;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public Integer get(Object key) {
        return map.get(key);
    }

    @Override
    public Integer put(Type key, Integer value) {
        return map.put(key, value);
    }

    @Override
    public Integer remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(Map<? extends Type, ? extends Integer> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<Type> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<Integer> values() {
        return map.values();
    }

    @Override
    public Set<Entry<Type, Integer>> entrySet() {
        return map.entrySet();
    }
}
