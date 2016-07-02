package com.dis2.canvasExtended;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;

import com.dis2.canvas.CanvasWidget;
import com.dis2.progress.StepsBar;
import com.dis2.shared.Palette;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Dimension;

import java.net.URL;

/**
 * Created by woooowowowo.
 */
public class CanvasExtendedWidget extends JPanel {

    private JPanel upperPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();

    //Buttons
    private JButton okButton = new JButton("OK");
    private JButton nextButton = new JButton("Next");
    private JButton prevButton = new JButton("Prev");

    //custom widgets
    private CanvasWidget canvasWidget;
    private StepsBar progressBar;

    private String logger = "Canvas Extended Widget: ";

    public CanvasExtendedWidget(Image backgroundImage) {
        System.out.println(logger + "Initiating extended canvas");

        System.out.println(logger + "Setting up upper panel");
        canvasWidget = new CanvasWidget(backgroundImage);
        upperPanel.setLayout(new BorderLayout());
        upperPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        upperPanel.add(canvasWidget, BorderLayout.CENTER);
        upperPanel.add(okButton, BorderLayout.SOUTH);

        System.out.println(logger + "Setting up bottom panel");
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        progressBar = new StepsBar(600, 10);
        progressBar.setPreferredSize(new Dimension(100, 100));
        progressBar.setBaseBackgroundColor(Palette.brown());
        progressBar.setProgressColor(Palette.green());
        progressBar.setResizable(true);
        progressBar.setStepNumbers(10);
        progressBar.setCurrentStep(5);
        URL url = CanvasExtendedWidget.class.getResource("/resources/bunnyStep.gif");
        progressBar.setProgressImage(new ImageIcon(url).getImage());
        url = CanvasExtendedWidget.class.getResource("/resources/coin_gold.png");
        progressBar.setGoalImage(new ImageIcon(url).getImage());

        //add prev next button
        bottomPanel.add(nextButton, BorderLayout.EAST);
        bottomPanel.add(prevButton, BorderLayout.WEST);
        bottomPanel.add(progressBar, BorderLayout.CENTER);

        //add both panel to widget
        this.setLayout(new BorderLayout());
        this.add(upperPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
