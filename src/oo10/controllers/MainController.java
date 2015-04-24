package oo10.controllers;

import oo10.models.BuienradarAPI;
import oo10.models.Weerstation;
import oo10.models.WeerstationComboBoxModel;
import oo10.views.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class MainController {

    private MainWindow window;
    private BuienradarAPI api;
    private WeerstationComboBoxModel weerstationComboBoxModel;
    private Boolean refreshing = false;

    public MainController(MainWindow window, BuienradarAPI api) {
        this.api = api;
        this.window = window;

        window.addButtonListener(buttonActionListener);
        window.addComboBoxListener(selectActionListener);

        weerstationComboBoxModel = new WeerstationComboBoxModel();
        window.setComboBoxModel(weerstationComboBoxModel);

        refresh();
    }

    private void refresh() {
        api.refresh();

        if(weerstationComboBoxModel.getSize() == 0) {
            weerstationComboBoxModel.addAll(api.getWeerstations());
        }
    }

    private ActionListener buttonActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            refreshing = true;
            api.refresh();
            weerstationComboBoxModel.removeAllElements();
            weerstationComboBoxModel.addAll(api.getWeerstations());
            window.setImageURL(null);
            refreshing = false;
        }
    };

    private ActionListener selectActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("comboBoxChanged") && !refreshing) {
                Weerstation weerstation = (Weerstation) weerstationComboBoxModel.getSelectedItem();
                try {
                    window.setImageURL(new URL(weerstation.getIcon()));
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    };



}
