/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis2.progress;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.net.URL;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author David
 */
public class TestProgress extends JFrame {

    public TestProgress() {
        try {
            //set layout
             
            

            //setting up progress bar
            StepsBar progress = new StepsBar(30, 600); 
            progress.setBaseBackgroundColor(new Color(203,138,72)); 
            progress.setProgressColor(new Color(46,204,113));
            progress.setStepNumbers(8);
            progress.setCurrentStep(2);
            progress.setResizable(false);
            progress.setMaxBarWidth(36);

            //set up pictures
            URL url = TestProgress.class.getResource("/resources/bunnyStep.gif");
            progress.setProgressImage(new ImageIcon(url).getImage());
            url = TestProgress.class.getResource("/resources/coin_gold.png");
            progress.setGoalImage(new ImageIcon(url).getImage());

            this.add(progress);
            

            JSlider steps = new JSlider(JSlider.VERTICAL, 0, 8,5);
            steps.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    progress.setCurrentStep(steps.getValue());
                }
            });
            
            //this.add(steps,BorderLayout.LINE_END);
            
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.pack();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[]) {
        try {
             new TestProgress(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
