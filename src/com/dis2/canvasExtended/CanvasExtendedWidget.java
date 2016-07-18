package com.dis2.canvasExtended;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import com.dis2.cardCompiler.CardCompiler;
import com.dis2.codeBlocks.CodeBlocks;
import com.dis2.canvas.CanvasWidget;
import com.dis2.progress.StepsBar;
import com.dis2.shared.AnimationAction;
import com.dis2.shared.MovementConstants;

import java.awt.*;
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

    //Buttons
    private JButton okButton = new JButton();
    private JButton nextButton = new JButton();
    private JButton prevButton = new JButton();

    public JButton getPrevButton(){return prevButton;}
    public JButton getNextButton(){return nextButton;}
    public JButton getOkButton(){return okButton;}

    //custom widgets
    private CanvasWidget canvasWidget;
    private StepsBar progressBar;

    private static CodeBlocks codeBlocks;
    public void setCodeBlocks(CodeBlocks value){
        codeBlocks = value;
    }
    
    public static CodeBlocks getCodeBlocks(){
        return codeBlocks;
    }

    public void setCurrentStep(int value){
        System.out.println(logger + "Set current step " + value);
        progressBar.setCurrentStep(value);
    }

    private int totalSteps;

    private String logger = "Canvas Extended Widget: ";

    public CanvasExtendedWidget(Image backgroundImage, ImageIcon charImage, ImageIcon walkImage, ImageIcon targetImage,
                                int startingX, int startingY, int targetX, int targetY) {
        this(backgroundImage, charImage, walkImage, targetImage, startingX, startingY, targetX, targetY, new MovementConstants());
    }

    public CanvasExtendedWidget(Image backgroundImage, ImageIcon charImage, ImageIcon walkImage, ImageIcon targetImage,
                                int startingX, int startingY, int targetX, int targetY, MovementConstants movementConstants) {
        System.out.println(logger + "Initiating extended canvas");

        System.out.println(logger + "Setting up upper panel");
        canvasWidget = new CanvasWidget(backgroundImage, charImage, walkImage, targetImage, startingX, startingY, targetX, targetY, movementConstants);
        canvasWidget.setParentPanel(this);
        upperPanel.setLayout(new BorderLayout());
        upperPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        //add widget and button
        upperPanel.add(canvasWidget, BorderLayout.CENTER);
        upperPanel.add(okButton, BorderLayout.SOUTH);

        System.out.println(logger + "Setting up bottom panel");
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        //add buttons
        bottomPanel.add(nextButton, BorderLayout.NORTH);
        bottomPanel.add(prevButton, BorderLayout.SOUTH);

        //calculate the panel height 
        progressBar = new StepsBar(30, 600);
        progressBar.setBaseBackgroundColor(new Color(203,138,72)); 
        progressBar.setProgressColor(new Color(46,204,113));
        progressBar.setStepNumbers(1);
        progressBar.setCurrentStep(1); 
        progressBar.setMaxBarWidth(36);
        
        URL url = CanvasExtendedWidget.class.getResource("/resources/bunnyStep.gif");
        progressBar.setProgressImage(new ImageIcon(url).getImage());
        url = CanvasExtendedWidget.class.getResource("/resources/coin_gold.png");
        progressBar.setGoalImage(new ImageIcon(url).getImage());

        bottomPanel.add(progressBar, BorderLayout.CENTER);

        //add action listeners
        okButton.addActionListener(new ActionAnimate());

        //add action listeners for prev and next
        prevButton.setActionCommand("prev");
        prevButton.setEnabled(false);
        nextButton.setActionCommand("next");
        nextButton.setEnabled(false);

        prevButton.addActionListener(new ActionSteps());
        nextButton.addActionListener(new ActionSteps());

        //set button icons
        URL urlNext = CanvasExtendedWidget.class.getResource(
                "/resources/next.png");
        System.out.println(urlNext.getPath());
        ImageIcon iconNext = new ImageIcon(urlNext);
        nextButton.setIcon(iconNext);

        URL urlPlay = CanvasExtendedWidget.class.getResource(
                "/resources/play.png");
        System.out.println(urlPlay.getPath());
        ImageIcon iconPlay = new ImageIcon(urlPlay);
        okButton.setIcon(iconPlay);

        URL urlPrev = CanvasExtendedWidget.class.getResource(
                "/resources/prev.png");
        System.out.println(urlPrev.getPath());
        ImageIcon iconPrev = new ImageIcon(urlPrev);
        prevButton.setIcon(iconPrev);

        /*nextButton.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), nextButton.getBorder()));
        prevButton.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), prevButton.getBorder()));
        okButton.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), okButton.getBorder()));

        okButton.setContentAreaFilled(false);
        okButton.setOpaque(false);*/

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

    public void resetCanvas(){
        prevButton.setEnabled(false);
        nextButton.setEnabled(false);
        okButton.setEnabled(true);
        canvasWidget.resetCanvas();
        totalSteps = 1;
        progressBar.setStepNumbers(totalSteps);
    }

    private ArrayList<AnimationAction> getCalculatedAnimations(){
        ArrayList<AnimationAction> result = new ArrayList<>();
        if(codeBlocks != null){
            result.addAll(CardCompiler.compileCards(codeBlocks.getCards())); 
        }
        
        return result;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private class ActionAnimate implements ActionListener{
        public void actionPerformed(ActionEvent e) {

            if(codeBlocks != null && codeBlocks.ValidateCodeBlocks()){
                ArrayList animations = getCalculatedAnimations();
                if(animations.size() > 0)
                {
                    canvasWidget.setAnimations(animations);
                    totalSteps = animations.size();
                    recalculateSteps();
                    canvasWidget.animateCanvas();
                }
            }
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
