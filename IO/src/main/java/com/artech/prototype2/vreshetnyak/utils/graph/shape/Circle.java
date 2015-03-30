/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.utils.graph.shape;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Василий
 */
public class Circle extends Ellipse2D {

    private Point point;
    private double width;
    private double height;
    private String word;

    public Circle() {
        point = new Point();
    }

    public Circle(double x, double y, double width, double height, String word) {
        point = new Point();
        point.setLocation(x, y);
        this.width = width;
        this.height = height;
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setPoint(double x, double y) {
        this.point.setPoint(x, y);
    }

    @Override
    public double getX() {
        return point.getX();
    }

    @Override
    public double getY() {
        return point.getY();
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void setFrame(double x, double y, double width, double height) {
        point.setLocation(x, y);
        this.width = width;
        this.height = height;

    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }
}
