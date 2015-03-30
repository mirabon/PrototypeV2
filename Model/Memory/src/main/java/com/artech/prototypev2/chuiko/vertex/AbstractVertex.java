package com.artech.prototypev2.chuiko.vertex;

import java.util.HashMap;
import java.util.Map;

/**
 * Vertex - вершина графа.
 * Хранит информацию о своем значении и связях с другими вершинами.
 * Реализует интерфейс Comparable для возможности хранить в отсортированных коллекциях.
 */
public abstract class AbstractVertex implements Comparable {
    /**
     * Вес связи по умолчанию
     */
    protected static final int DEFAULTWEIGHT = 1;

    /**
     * Значение вершины
     */
    protected String value;

    /**
     * множество исходящих ребер с весами - key = куда(вершина), value = значение весов ребра
     */
    protected Map<AbstractVertex, Integer> outGoingEdges = new HashMap<AbstractVertex, Integer>();

    /**
     * возвращает курту(Map) исходящих ребер с весами, где key = вершина(vertex) в которую направлено ребро, value = значение весов ребра
     */
    public Map<AbstractVertex, Integer> getOutGoingEdges() {
        return outGoingEdges;
    }

    /**
     * Создается вершина со значением = value и самоассоциацией = 1
     */
    protected AbstractVertex(String value) {
        this.value = value;
        outGoingEdges.put(this, DEFAULTWEIGHT);
    }

    /**
     * Добавить исходящее ребро до вершины into
     */
    public void addEdgeInto(AbstractVertex into) {
        if (this == into) {
            return;
        } else if (!outGoingEdges.containsKey(into)) {
            outGoingEdges.put(into, DEFAULTWEIGHT);
        } else {
            incWeightOfTheOutgoingEdge(into);
        }
    }

    /**
     * Увеличить вес самоассоциации
     */
    public void incSelfAssociation() {
        incWeightOfTheOutgoingEdge(this);
    }

    /**
     * Увеличить вес ребра от данной вершины до вершины into
     */
    protected void incWeightOfTheOutgoingEdge(AbstractVertex into) {
        int weight = outGoingEdges.get(into) + 1;
        outGoingEdges.put(into, weight);
    }

    /**
     * вернусть значение вершины
     */
    public String getValue() {
        return value;
    }

    /**
     * вернусть значение вершины
     */
    @Override
    public String toString() {
        return value;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.parseInt(o.toString());
    }
}