/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.utils;

import com.artech.prototype2.vreshetnyak.utils.graph.shape.Circle;
import com.artech.prototype2.vreshetnyak.utils.graph.shape.Edge;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Василий
 */
public class GraphicsPanel extends JPanel {

    private double WIDTH = 10;
    private double HEIGHT = 10;
    private int X = 0;
    private int Y = 0;
    private Edge edge;
    private Circle circle;
    private Object[][] t;
    private Map<String, Circle> gr;
    private Map<String, Boolean> using;

    /**
     * Конструктор класса GraphicsPanel
     *
     * @param t двумерный массив, имеющий конструкцию типа {"я", 1, "сказал"}<br>
     * где имеется ввиду, что слово "сказал" употребляется после слова "я" 1 раз.
     */
    public GraphicsPanel(Object[][] t) {
        this.t = t;
        this.circle = new Circle();
        this.edge = new Edge();
        gr = new HashMap<String, Circle>();
        using = new HashMap<String, Boolean>();

    }

    /**
     * Метод предназначен для рисования вершин, линий-связей, значений вершин и
     * весов
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        /**
         * Если карта еще не заполнена, то выполняем построение и заполнение
         */
        if (gr.isEmpty()) {
            /**
             * Перебираем каждую пару вершин для построения карты уникальности
             * Ключ - слово (вершина), значение - круг (объект) со всеми
             * default-параметрами
             */
            int length = t.length;
            while (length > 0) {
                if (gr.containsKey((String) t[length - 1][0]) == false) {
                    gr.put(t[length - 1][0].toString(), new Circle(X, Y, WIDTH, HEIGHT, t[length - 1][0].toString()));
                    //using.put(t[length - 1][0].toString(), false);

                } else if (gr.containsKey((String) t[length - 1][2]) == false) {
                    gr.put(t[length - 1][2].toString(), new Circle(X, Y, WIDTH, HEIGHT, t[length - 1][2].toString()));
                    //using.put(t[length - 1][2].toString(), false);

                }
                length--;
            }
            {
                /**
                 * Проходимся по карте уникальных вершин, присваиваем координаты
                 * и выводим на панель
                 */
                int sh = 0;
                int collumn = (int) Math.sqrt(gr.size()); //потенциальная ширина
                for (Circle circle : gr.values()) {
                    int LPX = LogicPoint.LP();
                    int LPY = LogicPoint.LP();
                    circle.setPoint(X + ((int) (sh % collumn)) * 100 + LPX, Y + (int) (sh / collumn) * 100 + LPY);
                    g2.draw(circle);
                    sh++;
                    //System.out.println(LPX + " " + LPY);
                }
            }
            /**
             * Формируем и рисуем линии-связи между вершинами
             */
            drawEdge(g2);
            /**
             * Иначе - выводим вершины на панель (рисуем).
             */
        } else {
            for (Circle circle : gr.values()) {
                g2.draw(circle);
            }
            /**
             * Выводим линии-связи между вершинами
             */
            drawEdge(g2);
        }
    }

    /**
     * Метод формирует и рисует линии-связи между вершинами графа
     *
     * @param g2
     */
    public void drawEdge(Graphics2D g2) {
        for (int i = t.length; i > 0; i--) {
            String str = (String) t[i - 1][0];
            String str2 = (String) t[i - 1][2];
            String wg = (String) t[i - 1][1].toString();

            Circle m;
            Circle m2;
            m = gr.get(str);
            m2 = gr.get(str2);
            g2.draw(m);
            g2.draw(m2);
            using.put(str, Boolean.TRUE);
            using.put(str2, Boolean.TRUE);
            edge = new Edge(m.getCenterX(), m.getCenterY(), m2.getCenterX(), m2.getCenterY());
            g2.draw(edge);

            g2.drawString(m.getWord(), (float) m.getCenterX(), (float) m.getCenterY() - 5);
            g2.drawString(m2.getWord(), (float) m2.getCenterX(), (float) m2.getCenterY() - 5);

            int xI = LogicPoint.PointWeight(edge)[0];
            int yI = LogicPoint.PointWeight(edge)[1];
            g2.drawString(wg, xI, yI);
            //System.out.println(wg);

        }
    }
}
