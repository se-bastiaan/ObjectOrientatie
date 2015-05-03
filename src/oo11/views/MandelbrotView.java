package oo11.views;

import oo11.ColorTable;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * View to draw Mandelbrot figure
 */
public class MandelbrotView extends JPanel {
 
    private int max_iterations;
    private double zoom;
    private BufferedImage I;
    private double zx, zy, cX, cY, tmp;
    private double cenX, cenY;
    private ColorTable colorTable;
 
    public MandelbrotView(int zoom, int max_iter, int centerX, int centerY) {
        this.zoom = zoom;
        this.max_iterations = max_iter;
        colorTable = new ColorTable(max_iter);
        cenX = centerX;
        cenY = centerY;
        setBounds(0, 100, 650, 550);
        createPaint();
    }

    /**
     * Create figure
     */
    public void createPaint() {
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                zx = cenX;
                zy = cenY;
                cX = ((x - 400) / zoom) + cenX;
                cY = ((y - 300) / zoom) + cenY;
                int iter = max_iterations;
                while (zx * zx + zy * zy < 4 && iter > 0) {
                    tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iter--;
                }

                int[] colors = colorTable.getColor(iter);

                I.setRGB(x, y,
                        new Color(colors[0], colors[1], colors[2]).getRGB());
            }
        }
        repaint();
    }

    /**
     * Paint figure
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        g.drawImage(I, 0, 0, this);
    }


    /**
     * Setters, do what they say they do
     */

    public void setCenter(double x, double y) {
        cenX = x;
        cenY = y;
    }

    public void setIterations(int it) {
        max_iterations = it;
        colorTable = new ColorTable(it);
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

}