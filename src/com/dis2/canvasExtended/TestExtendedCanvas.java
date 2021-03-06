/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis2.canvasExtended;

import com.dis2.shared.Actions;
import com.dis2.shared.AnimationAction;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author zaphod
 */
public class TestExtendedCanvas {

    public static void main(String args[]){
        try {
            System.out.println("Running testing extended canvas");

            URL url = TestExtendedCanvas.class.getResource(
                    "/resources/mockMap.png");
            System.out.println(url.getPath());
            ImageIcon icon = new ImageIcon(url);

            System.out.println("Testing add bunny character");
            URL urlChar = TestExtendedCanvas.class.getResource(
                    "/resources/bunny1_stand.png");
            System.out.println(urlChar.getPath());
            ImageIcon iconChar = new ImageIcon(urlChar);

            System.out.println("Testing add coin");
            URL urlCoin = TestExtendedCanvas.class.getResource(
                    "/resources/coin.gif");
            System.out.println(urlCoin.getPath());
            ImageIcon iconCoin = new ImageIcon(urlCoin);

            System.out.println("Testing add bunny walk");
            URL urlWalk = TestExtendedCanvas.class.getResource(
                    "/resources/bunny_walk.gif");
            System.out.println(urlWalk.getPath());
            ImageIcon iconWalk = new ImageIcon(urlWalk);

            CanvasExtendedWidget panel = new CanvasExtendedWidget(icon.getImage(), iconChar, iconWalk, iconCoin, 80, 30, 340, 275);

            JFrame frame = new JFrame("Test Extended Canvas");
            frame.setSize(800,800);
            frame.getContentPane().setLayout(new BorderLayout());
            frame.getContentPane().add(panel);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            ArrayList<AnimationAction> testActions = new ArrayList<AnimationAction>();
            System.out.println("Adding test movements");

            testActions.add(new AnimationAction(Actions.MOVEDOWN));
            testActions.add(new AnimationAction(Actions.MOVEDOWN));
            testActions.add(new AnimationAction(Actions.MOVEDOWN));
            testActions.add(new AnimationAction(Actions.MOVEDOWN));
            testActions.add(new AnimationAction(Actions.MOVEUP));
            testActions.add(new AnimationAction(Actions.MOVEUP));
            testActions.add(new AnimationAction(Actions.MOVEUP));
            testActions.add(new AnimationAction(Actions.MOVEUP));

            panel.setAnimations(testActions);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
