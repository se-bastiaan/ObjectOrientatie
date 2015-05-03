package oo11;

import oo11.controllers.MainController;
import oo11.views.MainWindow;

/**
 * Application class
 */
public class Application {

    public static void main(String[] args) {
        MainWindow fractal_win = new MainWindow();
        MainController controller = new MainController(fractal_win);
    }

}