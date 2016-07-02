/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis2.canvas;

import com.dis2.shared.AnimationAction;
import com.dis2.canvas.MovementConstants.MovementValue;
import com.dis2.shared.AnimationObject;

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

    private static final int startingX = 80;
    private static final int startingY = 30;

    private static final int framePerSecond = 50;

    private ArrayList<AnimationAction> actions = new ArrayList<AnimationAction>();

    public void setAnimations(ArrayList<AnimationAction> value) {
        actions = value;
    }

    public void addAnimations(ArrayList<AnimationAction> value) {
        actions.addAll(value);
    }

    public void addAnimation(AnimationAction value) {
        actions.add(value);
    }

    private JPanel parentPanel;

    public void setParentPanel(JPanel value) {
        parentPanel = value;
    }

    public CanvasWidget(String imgPath) {
        this(new ImageIcon(imgPath).getImage());
    }

    public CanvasWidget(Image backgroundImage) {
        try {
            System.out.println(logger + "Initiating canvas widget with image");
            this.backgroundImage = backgroundImage;
            Dimension size = new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            setLayout(null);

            System.out.println(logger + "Testing add bunny character");
            URL url = TestCanvas.class.getResource(
                    "/resources/bunny1_stand.png");
            System.out.println(url.getPath());
            ImageIcon icon = new ImageIcon(url);
            AnimationObject bunny = new AnimationObject(startingX, startingY, icon);

            System.out.println(logger + "Testing add coin");
            URL carrotUrl = TestCanvas.class.getResource(
                    "/resources/coin.gif");
            System.out.println(carrotUrl.getPath());
            ImageIcon carrotIcon = new ImageIcon(carrotUrl);

            System.out.println(logger + "Testing add target object");
            AnimationObject target = new AnimationObject(startingX + 4 * xBlock, startingY + 7 * yBlock, carrotIcon);

            System.out.println(logger + "Add objects");
            character = bunny;
            //animationObjects.add(target);

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


    public void animateCanvas(ArrayList<AnimationAction> steps) {
        try {
            character.setImage("/resources/bunny_walk.gif");
            timer = new Timer(1000 / framePerSecond, new TimerListener());
            currentQueue.addAll(steps);
            System.out.println(logger + "Current Queue set " + currentQueue.size());
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
                character.setImage("/resources/bunny1_stand.png");
                timer.stop();
                return;
            }

            //get next action
            if(needNewAnimation){
                currentAction = currentQueue.remove(0);
                needNewAnimation = false;
                movementValue = MovementConstants.getMovement(currentAction.getAction());
                xMovement = movementValue.getX();
                yMovement = movementValue.getY();
                System.out.println(logger + "X : " + xMovement + " Y : " + yMovement + currentQueue.size());
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
