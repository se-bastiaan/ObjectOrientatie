/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oo15;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Sjaak
 */
public class GridView extends JPanel implements Grid
{
    private BufferedImage  gridImage;
    private WritableRaster gridRaster;


    public static final int GRID_WIDTH = 600, GRID_HEIGHT = 600;
    public static final int PIXELS_PER_REPAINT = (GRID_WIDTH * GRID_WIDTH) / 60;

    public GridView() {
        gridImage = new BufferedImage(GRID_WIDTH, GRID_WIDTH, BufferedImage.TYPE_INT_RGB);
        gridRaster = gridImage.getRaster();
        setPreferredSize(new Dimension(GRID_WIDTH, GRID_WIDTH));
    }
 
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(gridImage, 0, 0, null);
    }
    
    private int nrOfPixelsSet = 0;
    
    @Override
    public void setPixel(int x, int y, int[] rgb) {
        gridRaster.setPixel (x, y, rgb);
        nrOfPixelsSet++;
        if (nrOfPixelsSet == PIXELS_PER_REPAINT) {
            repaint();
            nrOfPixelsSet = 0;
        }
    }

    @Override
    public int getWidth() {
        return GRID_WIDTH;
    }

    @Override
    public int getHeight() {
        return GRID_HEIGHT;
    }
    
}
