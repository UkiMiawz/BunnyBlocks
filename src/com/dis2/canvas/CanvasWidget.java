/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis2.canvas;
import com.dis2.shared.Actions;
import com.dis2.shared.AnimationAction;

import java.net.URL;
import java.util.ArrayList;

import java.awt.Image;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author whothefuckcare
 * Canvas widget for drawing level
 */
public class CanvasWidget extends JPanel {

    private Image backgroundImage;
    private AnimationObject character;
    private ArrayList<AnimationObject> animationObjects = new ArrayList<AnimationObject>();

    private static final int xBlock = 65;
    private static final int yBlock = 35;

    private static final int startingX = 80;
    private static final int startingY = 30;

    private ArrayList<AnimationAction> testActions = new ArrayList<AnimationAction>();

    public CanvasWidget(String imgPath) {
        this(new ImageIcon(imgPath).getImage());
    }

    public CanvasWidget(Image backgroundImage) {
        try{

            System.out.println("Adding test movements");
            testActions.add(new AnimationAction(Actions.MOVERIGHT));
            testActions.add(new AnimationAction(Actions.MOVEDOWN));
            testActions.add(new AnimationAction(Actions.MOVEUP));
            testActions.add(new AnimationAction(Actions.MOVELEFT));

            System.out.println("Initiating canvas widget with image");
            this.backgroundImage = backgroundImage;
            Dimension size = new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            setLayout(null);

            System.out.println("Testing add bunny character");
            URL url = TestCanvas.class.getResource(
                    "/resources/bunny1_stand.png");
            System.out.println(url.getPath());
            ImageIcon icon = new ImageIcon(url);
            AnimationObject bunny = new AnimationObject(startingX, startingY, icon);

            System.out.println("Testing add carrot");
            URL carrotUrl = TestCanvas.class.getResource(
                    "/resources/gold_2.png");
            System.out.println(carrotUrl.getPath());
            ImageIcon carrotIcon = new ImageIcon(carrotUrl);
            AnimationObject carrot = new AnimationObject(startingX + 2*xBlock, startingY + 5*yBlock, carrotIcon);

            System.out.println("Testing add carrot2");
            AnimationObject carrot2 = new AnimationObject(startingX + 3*xBlock, startingY + 6*yBlock, carrotIcon);

            System.out.println("Testing add carrot3");
            AnimationObject carrot3 = new AnimationObject(startingX + 4*xBlock, startingY+7*yBlock, carrotIcon);

            System.out.println("Add objects");
            character = bunny;
            animationObjects.add(carrot);
            animationObjects.add(carrot2);
            animationObjects.add(carrot3);
            redrawCanvas();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private void redrawCanvas() {
        System.out.println("Redraw canvas");
        this.removeAll();
        System.out.println("Add character");
        this.add(character);
        System.out.println("Add objects");
        for(AnimationObject animationObject: animationObjects) {
            this.add(animationObject);
        }
        this.revalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        System.out.println("Painting component");
        g.drawImage(backgroundImage, 0, 0, null);
    }
}
