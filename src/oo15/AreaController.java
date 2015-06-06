package oo15;

import javax.swing.*;

/**
 *
 * @author Sjaak Smetsers
 */
public class AreaController  {
    GridFiller filler; 
    Grid grid;
    JProgressBar progressBar;
    
    public AreaController ( GridFiller filler, Grid grid, JProgressBar progressBar) {
        this.filler = filler;
        this.grid = grid;
        this.progressBar = progressBar;
    }

    public void setArea(AreaSelector selector, int x, int y, int w, int h ) {
        Area area = filler.getArea().zoom(x, y, w, h, grid.getWidth(), grid.getHeight());
        filler = new GridFiller(grid, area, progressBar);
        filler.fill();
        selector.setStopper(filler);
    }

}
