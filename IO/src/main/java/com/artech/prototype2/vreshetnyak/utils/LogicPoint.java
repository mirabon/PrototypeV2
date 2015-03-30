/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.utils;

import com.artech.prototype2.vreshetnyak.utils.graph.shape.Edge;



/**
 * Класс для рандомного определения значений координаты Х или У
 *
 * @author Василий
 */
public class LogicPoint {

    protected static int XY = 0;
    protected static Edge edge;
    protected static int g[] = new int[2];

    public static int LP() {
        XY = (int) (Math.random() * (100 - 50));
        return XY;
    }

    public static int[] PointWeight(Edge edge) {
        int x1 = (int) edge.getX1();
        int y1 = (int) edge.getY1();

        int x2 = (int) edge.getX2();
        int y2 = (int) edge.getY2();
        /**
         * Ищем координату Х
         */
        if (x1 > x2) {
            g[0] = x2 + (x1 - x2) / 2;
        } else if (x1 < x2) {
            g[0] = x1 + (x2 - x1) / 2;
        } else {
            g[0] = x1 = x2;
        }
        /**
         * Ищем координату У
         */
        if (y1 > y2) {
            g[1] = y2 + (y1 - y2) / 2;
        } else if (y1 < y2) {
            g[1] = y1 + (y2 - y1) / 2;
        } else {
            g[1] = y1 = y2;
        }
        return g;
    }
}
