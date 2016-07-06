/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis2.canvas;

import com.dis2.canvasExtended.CanvasExtendedWidget;
import com.dis2.shared.AnimationAction;
import com.dis2.canvas.MovementConstants.MovementValue;
import com.dis2.shared.AnimationObject;
import com.dis2.shared.Util;

import java.net.URL;
import java.util.ArrayList;

import java.awt.Image;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import javax.swing.Timer;

/**
 * @author whothefuckcare
 *         Canvas widget for drawing level
 */
public class CanvasWidget extends JPanel {

    private String logger = "Canvas Widget: ";

    private Image backgroundImage;
    private AnimationObject character;
    private ArrayList<AnimationObject> animationObjects = new ArrayList<AnimationObject>();

    private static final int xBlock = 65;
    private static final int yBlock = 35;

    private int startingX = 0;
    private int startingY = 0;

    private int targetX = 0;
    private int targetY = 0;

    private static final int framePerSecond = 50;

    private ArrayList<AnimationAction> actions = new ArrayList<>();

    public void setAnimations(ArrayList<AnimationAction> value) {
        actions = value;
    }

    public void addAnimations(ArrayList<AnimationAction> value) {
        actions.addAll(value);
    }

    public void addAnimation(AnimationAction value) {
        actions.add(value);
    }

    private CanvasExtendedWidget parentPanel;
    public void setParentPanel(CanvasExtendedWidget value) {
        parentPanel = value;
    }

    public CanvasWidget(String imgPath, String imgCharacter, String targetCharacter,
                        int startingX, int startingY, int targetX, int targetY) {
        this(new ImageIcon(imgPath).getImage(),
                new ImageIcon(CanvasWidget.class.getResource(imgCharacter)),
                new ImageIcon(CanvasWidget.class.getResource(targetCharacter)),
                startingX, startingY, targetX, targetY);
    }

    public CanvasWidget(Image backgroundImage, ImageIcon characterImage, ImageIcon targetImage,
                        int startingX, int startingY, int targetX, int targetY) {
        try {

            System.out.println(logger + "Initiating canvas widget with image");
            this.backgroundImage = backgroundImage;
            this.startingX = startingX;
            this.startingY = startingY;
            this.targetX = targetX;
            this.targetY = targetY;

            Dimension size = new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            setLayout(null);

            AnimationObject bunny = new AnimationObject(startingX, startingY, characterImage);

            System.out.println(logger + "Testing add target object");
            AnimationObject target = new AnimationObject(targetX, targetY, targetImage);

            System.out.println(logger + "Add objects");
            character = bunny;
            animationObjects.add(target);

            this.add(character);
            animationObjects.forEach(this::add);
            redrawCanvas();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //animation only properties
    private MovementValue movementValue;
    private Timer timer;
    private int xMovement;
    private int yMovement;
    private ArrayList<AnimationAction> currentQueue = new ArrayList<AnimationAction>();
    private boolean needNewAnimation = true;
    AnimationAction currentAction;
    private int currentStep = 1;

    private void moveCharacterToStartPosition(){
        character.setX(startingX);
        character.setY(startingY);
    }

    private void animateCanvas(ArrayList<AnimationAction> steps) {
        try {
            character.setImage("/resources/bunny_walk.gif");
            timer = new Timer(1000 / framePerSecond, new TimerListener());
            //add queue start from last step
            for(int i = currentStep - 1; i < steps.size(); i++){
                currentQueue.add(steps.get(i));
            }
            timer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playOneStepBefore() {
        try {
            currentStep -= 1;
            character.setImage("/resources/bunny_walk.gif");
            timer = new Timer(1000 / framePerSecond, new TimerListener());
            //add queue start from last step
            AnimationAction step = actions.get(currentStep - 1);
            AnimationAction prevStep = new AnimationAction(Util.getBackward(step.getAction()));
            currentQueue.add(prevStep);
            System.out.println(logger + "Playing step number " + currentStep);
            currentStep -= 1;
            timer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playOneStepAfter() {
        try {
            character.setImage("/resources/bunny_walk.gif");
            timer = new Timer(1000 / framePerSecond, new TimerListener());
            AnimationAction step = actions.get(currentStep - 1);
            currentQueue.add(step);
            System.out.println(logger + "Playing step number " + currentStep);
            timer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {

            if(currentQueue.isEmpty() && xMovement == 0 && yMovement == 0){
                System.out.println(logger + "Animation queue finished");
                System.out.println(logger + "Animation finished - Current step now " + currentStep);
                character.setImage("/resources/bunny1_stand.png");
                timer.stop();
                return;
            }

            //get next action
            if(needNewAnimation){
                System.out.println(logger + "Need new animation - Current step " + currentStep);
                if(parentPanel != null)
                    parentPanel.setCurrentStep(currentStep);
                currentStep += 1;
                currentAction = currentQueue.remove(0);
                needNewAnimation = false;
                movementValue = MovementConstants.getMovement(currentAction.getAction());
                xMovement = movementValue.getX();
                yMovement = movementValue.getY();
                System.out.println(logger + "X : " + xMovement + " Y : " + yMovement + currentQueue.size());
                System.out.println(logger + "Need new animation - Current step now " + currentStep);
                //inform parent current step number
            }

            if (xMovement == 0 && yMovement == 0) {
                needNewAnimation = true;
            }

            int xDifference = 0;
            int yDifference = 0;

            if (xMovement > 0)
                xDifference = 1;
            else if (xMovement < 0)
                xDifference = -1;

            if (yMovement > 0)
                yDifference = 1;
            else if (yMovement < 0)
                yDifference = -1;

            character.moveObject(xDifference, yDifference);

            xMovement += -xDifference;
            yMovement += -yDifference;
            redrawCanvas();
        }
    }

    public void animateCanvas() {
        this.animateCanvas(actions);
    }

    private void redrawCanvas() {
        validate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);
    }
}
