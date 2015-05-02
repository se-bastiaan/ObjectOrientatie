package oo10.views;

import oo10.models.Weerstation;
import oo10.panels.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * MainWindow
 */
public class MainWindow extends JFrame {

    private static Integer HEIGHT = 300;
    private static Integer WIDTH = 600;

    private JButton button;
    private ImagePanel imagePanel;
    private JLabel tempLabel;
    private JLabel windLabel;
    private JComboBox<Weerstation> comboBox;

    public MainWindow() {
        initUI();
    }

    /**
     * Initialise UI
     */
    private void initUI() {
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        comboBox = new JComboBox<>();
        add(comboBox, BorderLayout.SOUTH);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());
        panel.setSize(150, 150);
        imagePanel = new ImagePanel();
        panel.add(imagePanel);
        tempLabel = new JLabel();
        windLabel = new JLabel();

        panel.add(tempLabel);
        panel.add(windLabel);

        add(panel);

        button = new JButton("Refresh");

        add(button, BorderLayout.NORTH);

        setVisible(true);
    }

    /**
     * Add listener to combobox
     * @param actionListener {@link java.awt.event.ActionListener}
     */
    public void addComboBoxListener(ActionListener actionListener) {
        comboBox.addActionListener(actionListener);
        invalidate();
    }

    /**
     * Add listener to button
     * @param actionListener {@link java.awt.event.ActionListener}
     */
    public void addButtonListener(ActionListener actionListener) {
        button.addActionListener(actionListener);
        invalidate();
    }

    /**
     * Set model on combobox
     * @param model {@link javax.swing.DefaultComboBoxModel}
     */
    public void setComboBoxModel(DefaultComboBoxModel model) {
        comboBox.setModel(model);
        invalidate();
    }

    /**
     * Change image of imagepanel
     * @param url {@link java.net.URL}
     */
    public void setImageURL(URL url) {
        imagePanel.setImageURL(url);
        invalidate();
    }

    /**
     * Set temp text
     * @param text {@link java.lang.String}
     */
    public void setTempText(String text) {
        tempLabel.setText(text);
    }

    /**
     * Set wind text
     * @param text {@link java.lang.String}
     */
    public void setWindText(String text) {
        windLabel.setText(text);
    }
}
