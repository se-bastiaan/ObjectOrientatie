/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oo15;

import java.awt.BorderLayout;
import java.awt.Insets;
import javax.swing.*;


/*
This class creates an applet for generating Mandelbrot sets. The applet is
meant to be embedded in an HTML page and has hooks to interact with the page.
Functions are provided to allow the user to zoom in and out and to move around
on the surface of the figure. The user can also select from a set of color
schemes.
*/

public class Mandelbrot 
{
    public static void main(String args[]) {
        
        GridView grid = new GridView();
        JProgressBar progressBar = new JProgressBar();
        MainWindow mandel = new MainWindow ( grid, progressBar );

        Area area = new Area ( -2.5, 2.5, 5, 5 );
        GridFiller filler = new GridFiller ( grid, area, progressBar );
        AreaController controller = new AreaController ( filler, grid, progressBar );
        AreaSelector selector = new AreaSelector ( grid, controller );
        filler.fill();
        selector.setStopper(filler);
    }

}