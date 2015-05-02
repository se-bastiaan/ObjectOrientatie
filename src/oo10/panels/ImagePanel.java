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

/**
 * Extended JPanel that draws image
 */
public class ImagePanel extends JPanel {

    private BufferedImage image;

    /**
     * Empty constructor
     */
    public ImagePanel() {

    }

    /**
     * URL constructor
     * @param url {@link java.net.URL}
     */
    public ImagePanel(URL url) {
        this();
        try {
          image = ImageIO.read(url);
        } catch (IOException ex) {
            // handle exception...
        }
    }

    /**
     * Paint override
     * @param g {@link java.awt.Graphics}
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(image != null) {
            g.drawImage(image, 0, 0, null);
        }
    }

    /**
     * Redraw image following new URL
     * @param url {@link java.net.URL}
     */
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