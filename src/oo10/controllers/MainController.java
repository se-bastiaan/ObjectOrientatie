package oo10.controllers;

import oo10.models.BuienradarAPI;
import oo10.models.Weerstation;
import oo10.models.WeerstationComboBoxModel;
import oo10.views.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * The Main Application Controller
 */
public class MainController {

    private MainWindow window;
    private BuienradarAPI api;
    private WeerstationComboBoxModel weerstationComboBoxModel;
    private Boolean refreshing = false;

    /**
     * Main Constructor
     * @param window {@link oo10.views.MainWindow}
     * @param api {@link oo10.models.BuienradarAPI}
     */
    public MainController(MainWindow window, BuienradarAPI api) {
        this.api = api;
        this.window = window;

        window.addButtonListener(buttonActionListener);
        window.addComboBoxListener(selectActionListener);

        weerstationComboBoxModel = new WeerstationComboBoxModel();
        window.setComboBoxModel(weerstationComboBoxModel);

        refresh();
    }

    /**
     * Refresh items
     */
    private void refresh() {
        api.refresh();

        if(weerstationComboBoxModel.getSize() == 0) {
            weerstationComboBoxModel.addAll(api.getWeerstations());
        }
    }

    /**
     * Action on button press
     */
    private ActionListener buttonActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            refreshing = true;
            api.refresh();
            Weerstation weerstation = (Weerstation) weerstationComboBoxModel.getSelectedItem();
            weerstationComboBoxModel.removeAllElements();
            weerstationComboBoxModel.addAll(api.getWeerstations());
            weerstationComboBoxModel.setSelectedItem(weerstation);
            selectActionListener.actionPerformed(null);
            refreshing = false;
        }
    };

    /**
     * Action on combobox change
     */
    private ActionListener selectActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e == null || e.getActionCommand().equals("comboBoxChanged") && !refreshing) {
                Weerstation weerstation = (Weerstation) weerstationComboBoxModel.getSelectedItem();
                try {
                    window.setImageURL(new URL(weerstation.getIcon()));
                    window.setTempText("Temperature: " + weerstation.getTemperatuur());
                    window.setWindText("Wind: " + weerstation.getWindrichting());
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    };



}
