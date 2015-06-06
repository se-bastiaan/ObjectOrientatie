package oo15;

import javax.swing.*;
import java.util.List;

public class GridWorker extends SwingWorker<Void, Pixel> {

    private Area area;
    private Grid grid;
    private int grid_w, grid_h;
    private double area_h, area_w, dx, dy;
    private ColorChooser colorChooser;
    private RGBColors rgbColors;
    private Listener listener;

    public GridWorker(Grid grid, Area area, int index, RGBColors rgbColors) {
        this.area = area;
        this.grid = grid;
        grid_w = grid.getWidth();
        grid_h = grid.getHeight();
        area_w = area.getWidth();
        area_h = area.getHeight();
        dx = area_w / grid_w;
        dy = area_h / grid_h;
        colorChooser = new ColorChooser();
        colorChooser.setMaxIndex(index);
        this.rgbColors = rgbColors;
    }

    @Override
    protected Void doInBackground() throws Exception {
        double x = area.getX();
        for (int i = 0; i < grid_w; i++) {
            double y = area.getY();
            for (int j = 0; j < grid_h; j++) {
                int color = colorChooser.getColorIndex(x, y);
                Pixel pixel = new Pixel(i, j, color == -1 ? RGBColors.BLACK : rgbColors.getColor(color));
                publish(pixel);
                y -= dy;
            }
            x += dx;
        }
        return null;
    }

    @Override
    protected void process(List<Pixel> chunks) {
        super.process(chunks);
        if(listener != null)
            listener.process(chunks);
    }

    @Override
    protected void done() {
        super.done();
        if(listener != null)
            listener.done();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public interface Listener {
        void done();
        void process(List<Pixel> pixels);
    }

}