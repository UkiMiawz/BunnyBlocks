/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis2.canvas;
import com.dis2.shared.Actions;
import com.dis2.shared.AnimationAction;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author 42
 */
public class TestCanvas {

    public static void main(String args[]){
        try {
            System.out.println("Running testing canvas");

            URL url = TestCanvas.class.getResource(
                    "/resources/mockMap.png");
            System.out.println(url.getPath());
            ImageIcon icon = new ImageIcon(url);

            System.out.println("Testing add bunny character");
            URL urlChar = TestCanvas.class.getResource(
                    "/resources/bunny1_stand.png");
            System.out.println(urlChar.getPath());
            ImageIcon iconChar = new ImageIcon(urlChar);

            System.out.println("Testing add bunny walk");
            URL urlWalk = TestCanvas.class.getResource(
                    "/resources/bunny_walk.gif");
            System.out.println(urlWalk.getPath());
            ImageIcon iconWalk = new ImageIcon(urlWalk);

            System.out.println("Testing add coin");
            URL urlCoin = TestCanvas.class.getResource(
                    "/resources/coin.gif");
            System.out.println(urlCoin.getPath());
            ImageIcon iconCoin = new ImageIcon(urlCoin);

            CanvasWidget panel = new CanvasWidget(icon.getImage(), iconChar, iconWalk, iconCoin, 80, 30, 340, 275);
            JFrame frame = new JFrame("Test Canvas");
            frame.setSize(800,800);
            frame.getContentPane().setLayout(new BorderLayout());
            frame.getContentPane().add(panel);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            ArrayList<AnimationAction> testActions = new ArrayList<AnimationAction>();
            System.out.println("Adding test movements");

            testActions.add(new AnimationAction(Actions.MOVEDOWN));
            testActions.add(new AnimationAction(Actions.MOVEUP));
            testActions.add(new AnimationAction(Actions.MOVEDOWN));
            panel.addAnimations(testActions);

            Thread.sleep(1000);
            System.out.println("Start animating");
            panel.animateCanvas();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
