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

    private JButton button;
    private ImagePanel imagePanel;
    private JComboBox<Weerstation> comboBox;

    public MainWindow() {
        initUI();
    }

    private void initUI() {
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        comboBox = new JComboBox<>();
        add(comboBox, BorderLayout.SOUTH);

        imagePanel = new ImagePanel();
        add(imagePanel, BorderLayout.CENTER);

        button = new JButton("Refresh");

        add(button, BorderLayout.NORTH);

        setVisible(true);
    }

    public void addComboBoxListener(ActionListener actionListener) {
        comboBox.addActionListener(actionListener);
        invalidate();
    }

    public void addButtonListener(ActionListener actionListener) {
        button.addActionListener(actionListener);
        invalidate();
    }

    public void setComboBoxModel(DefaultComboBoxModel model) {
        comboBox.setModel(model);
        invalidate();
    }

    public void setImageURL(URL url) {
        imagePanel.setImageURL(url);
        invalidate();
    }
}
