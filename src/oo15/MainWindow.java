package oo15;



import java.awt.*;

import javax.swing.*;

/**
 * 
 * @author Sjaak Smetsers
 * @version 1.0, 14-03-2013
 */

/**
 * creates a window to which a GridView panel and progress bar are added
 * 
 */
public class MainWindow  {

    public MainWindow ( GridView grid, JProgressBar progressBar ) {
    	JFrame mainFrame = new JFrame ("Mandelbrot");
        
    	mainFrame.setLocationRelativeTo(null);
    	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	mainFrame.setResizable(false);
    	mainFrame.setVisible(true);

        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(grid, BorderLayout.NORTH);
        mainFrame.add(progressBar, BorderLayout.SOUTH);
        mainFrame.pack();
    }
        
}
