/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.output.impl;

/**
 *
 * @author Василий
 */
import com.artech.prototype2.vreshetnyak.utils.GraphicsPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class DrawGraphImpl {

    public static JPanel lowPanel;
    public static int mouseX = 0, mouseY = 0;
    public static GraphicsPanel panel;

    public DrawGraphImpl(Object[][] t){
        JFrame inputFormFrame = new JFrame("Рисовалка графов");
        inputFormFrame.setSize(800, 800);
        inputFormFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputFormFrame.setLocationRelativeTo(null);
        inputFormFrame.setLayout(new BorderLayout());
        dragListener ol = new dragListener();

        panel = new GraphicsPanel(t);
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel.addMouseListener(ol);

        inputFormFrame.add(panel);
        inputFormFrame.setVisible(true);
    }    

    class dragListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            mouseX = e.getX() - panel.getX();
            mouseY = e.getY() - panel.getY();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            panel.setLocation(e.getX() - mouseX, e.getY() - mouseY);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}