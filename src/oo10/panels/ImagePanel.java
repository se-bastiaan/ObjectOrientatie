package oo10.panels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    private BufferedImage image;

    public ImagePanel() {

    }

    public ImagePanel(URL url) {
        this();
        try {
          image = ImageIO.read(url);
        } catch (IOException ex) {
            // handle exception...
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(image != null) {
            g.drawImage(image, 0, 0, null);
        }
    }

    public void setImageURL(URL url) {
        if(url == null) {
            image = null;
            repaint();
            return;
        }

        try {
            image = ImageIO.read(url);
            repaint();
        } catch (IOException ex) {
            // handle exception...
        }
    }

}