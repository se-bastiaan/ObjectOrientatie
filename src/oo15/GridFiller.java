/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oo15;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Sjaak
 */
public class GridFiller implements Stopper {

    private JProgressBar progressBar;
    private Area area;
    private Grid grid;
    private int iterations = 1;
    private boolean stop = false;
    public static final int MAX_ITERATIONS = 400;
    private static final RGBColors rgbColors = new RGBColors(MAX_ITERATIONS);

    public GridFiller(Grid grid, Area area, JProgressBar progressBar) {
        this.grid = grid;
        this.area = area;
        this.progressBar = progressBar;

        progressBar.setMaximum(MAX_ITERATIONS);
    }

    public Area getArea() {
        return area;
    }

    public void fill() {
        progressBar.setValue(0);
        listener.done();
    }

    private GridWorker.Listener listener = new GridWorker.Listener() {
        @Override
        public void done() {
            if(iterations < MAX_ITERATIONS && !stop) {
                GridWorker worker = new GridWorker(grid, area, iterations, rgbColors);
                worker.setListener(listener);
                worker.execute();

                iterations++;
                progressBar.setValue(iterations);
            }
        }

        @Override
        public void process(List<Pixel> pixels) {
            if(!stop) {
                for(Pixel pixel : pixels)
                    grid.setPixel(pixel.getX(), pixel.getY(), pixel.getColor());
            }
        }
    };

    @Override
    public void tryToStop() {
        stop = true;
    }
}
