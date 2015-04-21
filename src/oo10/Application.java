package oo10;

import oo10.models.BuienradarAPI;
import oo10.views.MainWindow;

public class Application {

    public static void main(String[] args) {
        BuienradarAPI buienradarAPI = new BuienradarAPI();

        MainWindow mainWindow = new MainWindow(buienradarAPI);
    }

}