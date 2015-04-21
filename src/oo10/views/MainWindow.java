package oo10.views;

import oo10.models.BuienradarAPI;
import oo10.models.Weerstation;
import oo10.models.WeerstationComboBoxModel;
import oo10.panels.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MainWindow extends JFrame {

    private static Integer HEIGHT = 300;
    private static Integer WIDTH = 200;

    private ImagePanel imagePanel;
    private BuienradarAPI api;
    private WeerstationComboBoxModel weerstationComboBoxModel;
    private Boolean refreshing = false;
    private JLabel tempLabel;

    public MainWindow(BuienradarAPI api) {
        this.api = api;
        initUI();
    }

    private void initUI() {
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        List<Weerstation> weerstationList = api.getWeerstations();
        weerstationComboBoxModel = new WeerstationComboBoxModel();
        weerstationComboBoxModel.addAll(weerstationList);
        JComboBox<Weerstation> comboBox = new JComboBox<>();
        comboBox.setModel(weerstationComboBoxModel);
        comboBox.addActionListener(selectActionListener);
        add(comboBox, BorderLayout.SOUTH);

        imagePanel = new ImagePanel();
        add(imagePanel, BorderLayout.CENTER);
        tempLabel = new JLabel();

        JButton button = new JButton("Refresh");
        button.addActionListener(menuActionListener);

        add(button, BorderLayout.NORTH);

        setVisible(true);
    }

    private ActionListener menuActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            refreshing = true;
            api.refresh();
            weerstationComboBoxModel.removeAllElements();
            weerstationComboBoxModel.addAll(api.getWeerstations());
            imagePanel.setImageURL(null);
            refreshing = false;
        }
    };

    private ActionListener selectActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("comboBoxChanged") && !refreshing) {
                Weerstation weerstation = (Weerstation) weerstationComboBoxModel.getSelectedItem();
                try {
                    imagePanel.setImageURL(new URL(weerstation.getIcon()));
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    };
}
