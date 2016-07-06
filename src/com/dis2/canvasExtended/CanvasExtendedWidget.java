package com.dis2.canvasExtended;

import javax.swing.*;

import com.dis2.canvas.CanvasWidget;
import com.dis2.progress.StepsBar;
import com.dis2.shared.AnimationAction;
import com.dis2.shared.Palette;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by woooowowowo.
 */
public class CanvasExtendedWidget extends JPanel {

    private JPanel upperPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JPanel progressPanel = new JPanel();

    //Buttons
    private JButton okButton = new JButton("Play");
    private JButton nextButton = new JButton("Next");
    private JButton prevButton = new JButton("Prev");

    //custom widgets
    private CanvasWidget canvasWidget;
    private StepsBar progressBar;

    public void setCurrentStep(int value){
        System.out.println(logger + "Set current step " + value);
        progressBar.setCurrentStep(value);
    }

    private int totalSteps;

    private String logger = "Canvas Extended Widget: ";

    public CanvasExtendedWidget(Image backgroundImage) {
        System.out.println(logger + "Initiating extended canvas");

        System.out.println(logger + "Setting up upper panel");
        canvasWidget = new CanvasWidget(backgroundImage);
        canvasWidget.setParentPanel(this);
        upperPanel.setLayout(new BorderLayout());
        upperPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        upperPanel.add(canvasWidget, BorderLayout.CENTER);
        upperPanel.add(okButton, BorderLayout.SOUTH);

        System.out.println(logger + "Setting up bottom panel");
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        progressBar = new StepsBar(10, 650);
        progressBar.setPreferredSize(new Dimension(100, 100));
        progressBar.setBaseBackgroundColor(Palette.brown());
        progressBar.setProgressColor(Palette.green());
        progressBar.setStepNumbers(1);
        progressBar.setCurrentStep(0);
        URL url = CanvasExtendedWidget.class.getResource("/resources/bunnyStep.gif");
        progressBar.setProgressImage(new ImageIcon(url).getImage());
        url = CanvasExtendedWidget.class.getResource("/resources/coin_gold.png");
        progressBar.setGoalImage(new ImageIcon(url).getImage());

        //add prev next button
        bottomPanel.add(nextButton, BorderLayout.NORTH);
        bottomPanel.add(prevButton, BorderLayout.SOUTH);

        progressPanel.setLayout(new BorderLayout());
        progressPanel.add(progressBar, BorderLayout.CENTER);
        bottomPanel.add(progressPanel, BorderLayout.CENTER);

        //add action listeners
        okButton.addActionListener(new ActionAnimate());

        //add action listeners for prev and next
        prevButton.setActionCommand("prev");
        nextButton.setActionCommand("next");

        prevButton.addActionListener(new ActionSteps());
        nextButton.addActionListener(new ActionSteps());

        //add both panel to widget
        this.setLayout(new BorderLayout());
        this.add(upperPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.WEST);
    }

    //animation steps related
    public void setAnimations(ArrayList<AnimationAction> value){
        canvasWidget.setAnimations(value);
        totalSteps = value.size();
        recalculateSteps();
    }

    public void addAnimations(ArrayList<AnimationAction> value){
        canvasWidget.addAnimations(value);
        recalculateSteps();
    }

    public void addAnimation(AnimationAction value) {
        canvasWidget.addAnimation(value);
        totalSteps += 1;
        recalculateSteps();
    }

    public void recalculateSteps(){
        progressBar.setStepNumbers(totalSteps);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private class ActionAnimate implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            canvasWidget.animateCanvas();
        }
    }

    private class ActionSteps implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if ("prev".equals(e.getActionCommand())) {
                canvasWidget.playOneStepBefore();
            } else if ("next".equals(e.getActionCommand())) {
                canvasWidget.playOneStepAfter();
            }
        }
    }
}
