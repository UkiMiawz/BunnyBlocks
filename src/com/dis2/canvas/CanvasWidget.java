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

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.lang.Thread;

/**
 *
 * @author whothefuckcare
 * Canvas widget for drawing level
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

    public CanvasWidget(String imgPath) {
        this(new ImageIcon(imgPath).getImage());
    }

    public CanvasWidget(Image backgroundImage) {
        try{
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
            AnimationObject target = new AnimationObject(startingX + 4*xBlock, startingY+7*yBlock, carrotIcon);

            System.out.println(logger + "Add objects");
            character = bunny;
            animationObjects.add(target);
            redrawCanvas();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void animateCanvas(ArrayList<AnimationAction> steps) {
        try {
            character.setImage("/resources/bunny_walk.gif");
            for(AnimationAction action: steps) {
                System.out.println(logger + "Executing step " + action.toString());
                //get movement value
                MovementValue movementValue = MovementConstants.getMovement(action.getAction());
                //animate per x & y
                int xMovement = movementValue.getX();
                int yMovement = movementValue.getY();

                while(xMovement != 0 || yMovement != 0){

                    int xDifference = 0;
                    int yDifference = 0;

                    if(xMovement > 0)
                        xDifference = 1;
                    else if(xMovement < 0)
                        xDifference = -1;

                    if(yMovement > 0)
                        yDifference = 1;
                    else if(yMovement < 0)
                        yDifference = -1;

                    character.moveObject(xDifference, yDifference);

                    xMovement += -xDifference;
                    yMovement += -yDifference;
                    redrawCanvas();

                    //wait before set the next movement
                    Thread.sleep(1000/framePerSecond);
                }
            }
            character.setImage("/resources/bunny1_stand.png");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void redrawCanvas(){
        System.out.println(logger + "Redraw canvas");
        this.removeAll();
        this.add(character);
        for(AnimationObject animationObject: animationObjects) {
            this.add(animationObject);
        }
        this.validate();
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);
    }
}
