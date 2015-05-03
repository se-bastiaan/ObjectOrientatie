package oo11.controllers;

import oo11.views.MainWindow;

import javax.swing.*;
import java.awt.event.*;

/**
 * The Main Application Controller
 */
public class MainController {

    private MainWindow window;
    private boolean mousePressed = false, shiftDown = false;
    private int x = 0, y = 0;

    /**
     * Main Constructor
     * @param window {@link oo11.views.MainWindow}
     */
    public MainController(MainWindow window) {
        this.window = window;

        window.getMandelView().addMouseListener(mMouseListener);
        window.getMandelView().addMouseMotionListener(mMouseMotionListener);

        window.getButton().addActionListener(mButtonActionListener);

        window.getMandelView().addKeyListener(mKeyListener);
    }

    private MouseListener mMouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            mousePressed = true;
            y = e.getY();
            x = e.getX();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            int newX = e.getX();
            int newY = e.getY();

            if(Math.abs(newX) < Math.abs(x) + 5 && Math.abs(newY) < Math.abs(y) + 5) {
                window.getxText().setText(Double.toString(newX));
                window.getyText().setText(Double.toString(newY));
                double zoom = Double.parseDouble(window.getZoomText().getText());

                if(shiftDown) {
                    zoom = zoom / 2;
                } else {
                    zoom = zoom * 2;
                }

                window.getZoomText().setText(Double.toString(zoom));

                window.getMandelView().setCenter(newX, newY);
                window.getMandelView().setZoom((int)zoom);
                window.getMandelView().createPaint();
            }

            mousePressed = false;
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };

    private MouseMotionListener mMouseMotionListener = new MouseMotionListener() {
        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    };

    private KeyListener mKeyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            shiftDown = e.isShiftDown();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            shiftDown = e.isShiftDown();
        }
    };

    private ActionListener mButtonActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int iterations = Integer.parseInt(window.getIterationsText().getText());
            double x = Double.parseDouble(window.getxText().getText());
            double y = Double.parseDouble(window.getyText().getText());
            int zoom = Integer.parseInt(window.getZoomText().getText());

            window.getMandelView().setCenter(x, y);
            window.getMandelView().setZoom(zoom);
            window.getMandelView().setIterations(iterations);
            window.getMandelView().createPaint();
        }
    };


}
