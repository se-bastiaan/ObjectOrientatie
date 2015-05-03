package oo11.views;

import javax.swing.*;
/**
 * MainWindow frame
 */
public class MainWindow extends JFrame {

    public static final int WIDTH = 650, HEIGHT = 650;
    private JTextField xText;

    private JTextField yText;
    private JTextField iterationsText;
    private JTextField zoomText;
    private JButton button;
    private MandelbrotView mandelbrotView;

    /**
     * Constructor
     */
    public MainWindow () {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mandelbrotView = new MandelbrotView(100, 500, 0, 0);
        mandelbrotView.setSize(WIDTH, HEIGHT - 100);

        JPanel panel = new JPanel();
        xText = new JTextField(5);
        yText = new JTextField(5);
        iterationsText = new JTextField(5);
        zoomText = new JTextField(5);

        JLabel label1 = new JLabel("X:");
        JLabel label2 = new JLabel("Y:");
        JLabel label3 = new JLabel("Iterations:");
        JLabel label4 = new JLabel("Zoom:");
        button = new JButton("Paint");

        panel.add(label1);
        panel.add(xText);
        panel.add(label2);
        panel.add(yText);
        panel.add(label3);
        panel.add(iterationsText);
        panel.add(label4);
        panel.add(zoomText);
        panel.add(button);

        // Default values
        xText.setText("0");
        yText.setText("0");
        iterationsText.setText("500");
        zoomText.setText("100");

        add(mandelbrotView);
        add(panel);

        setVisible(true);
    }

    /**
     * Getters below, do what they say they do
     */

    public MandelbrotView getMandelView() {
        return mandelbrotView;
    }

    public JTextField getxText() {
        return xText;
    }

    public JTextField getyText() {
        return yText;
    }

    public JTextField getIterationsText() {
        return iterationsText;
    }

    public JTextField getZoomText() {
        return zoomText;
    }

    public JButton getButton() {
        return button;
    }

}
