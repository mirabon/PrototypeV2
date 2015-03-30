package com.artech.prototypev2.chuiko.graph;

import com.artech.prototypev2.chuiko.vertex.AbstractVertex;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * graph хранит элементы класса Vertex в Map. key - значение Vertex(toString), value - Vertex.
 * Управляется через объект manager.
 * Модификатор abstract для возможности управления только через manager, который содержит graph exdents graph.
 * <p/>
 * Возможности:
 * вернуть множество значений вершин,
 * вернусть вершину по значению,
 * добавить вершину по значению,
 * добавить ориентированное взвешанное ребро между двумя вершинами,
 * вывести граф в строковом представлении.
 * <p/>
 * Особенности:
 * значения вершин(key или vertex.valume) сохраняется в LowerCase.
 */
public abstract class AbstractGraph {
    /**
     * Создаем реальный класс из vertex
     */
    protected class Vertex extends AbstractVertex {
        protected Vertex(String value) {
            super(value);
        }
    }

    /**
     * Множество всех вершин
     */
    protected Map<String, AbstractVertex> vertices = new TreeMap<String, AbstractVertex>();

    /**
     * Возвращает множество всех ключей - значений вершин(Vortex)
     */
    public Set<String> getVertices() {
        return vertices.keySet();
    }

    /**
     * Возвращает карту вершин
     */
    public Map<String, AbstractVertex> getMapVertices() {
        return vertices;
    }

    /**
     * @param value
     * @return Возвращает вершину по значению
     */
    public AbstractVertex getVertex(String value) {
        value = formatValue(value);
        try {
            checkValue(value);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return vertices.get(value);
    }

    /**
     * @param value
     * @return Добавляет вершину по значению
     */
    public void addVertex(String value) {
        value = formatValue(value);
        AbstractVertex newVertex = getVertex(value);

        if (newVertex == null) {
            newVertex = new Vertex(value);
            vertices.put(newVertex.toString(), newVertex);
        } else {
            newVertex.incSelfAssociation();
        }
    }

    /**
     * @param from
     * @param into
     * @return Добавление ребра по значениям(key) вершин - из какой вершины в какую
     */
    public void addEdge(String from, String into) {
        from = formatValue(from);
        into = formatValue(into);
        AbstractVertex fromVertex = getVertex(from);
        AbstractVertex intoVertex = getVertex(into);

        fromVertex.addEdgeInto(intoVertex);
//        intoVertex.incSelfAssociation();
    }

    /**
     * @return возвращает строку содержащую список вершин и исходящих из них ребер.
     * ребро выходит из vortex - [вершина куда идет ребро, вес ребра]:
     * "vortex1 - [вершина1, вес];[вершина2, вес];..
     * vortex2 - [вершина1, вес];[вершина2, вес];..
     * ..."
     */
    public String toString() {
        StringBuilder rezultString = new StringBuilder();
        for (Map.Entry<String, AbstractVertex> entry : vertices.entrySet()) {
            rezultString.append(entry.getValue().toString()).append(" - ");
            for (Map.Entry<AbstractVertex, Integer> entryElement : entry.getValue().getOutGoingEdges().entrySet()) {
                rezultString.append("[").append(entryElement.getKey().toString()).append(", ").append(entryElement.getValue()).append("];");
            }
            rezultString.append("\n");
        }
        return rezultString.toString();
    }

    /**
     * проверка корректности значения вершины
     */
    protected void checkValue(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Неверный параметр");
        }
    }

    /**
     * Приводит строку в нужный вид для храниения в графе:
     * Переводит в нижний регистр.
     */
    protected String formatValue(String value) {
        return value.toLowerCase();
    }

}