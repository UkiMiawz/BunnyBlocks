/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis2.progress;

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
public class TestProgress extends JPanel {

    public TestProgress() {
        try {
            this.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            StepsBar progress = new StepsBar(30, 600);
            progress.setPreferredSize(new Dimension(100, 100));
            progress.setBaseBackgroundColor(new Color(203,138,72));
            progress.setBorderColor(new Color(173,119,65));
            progress.setProgressColor(new Color(46,204,113));
            progress.setStepNumbers(8);
            progress.setCurrentStep(4);
            progress.setResizable(false);
            URL url = TestProgress.class.getResource("/resources/bunnyStep.gif");
            progress.setProgressImage(new ImageIcon(url).getImage());
            url = TestProgress.class.getResource("/resources/coin_gold.png");
            progress.setGoalImage(new ImageIcon(url).getImage());
            c.fill = GridBagConstraints.VERTICAL;
            c.weightx = 0.5;
            c.gridx = 0;
            c.gridy = 0;
            this.add(progress, c);

            JSlider steps = new JSlider(JSlider.VERTICAL, 0, 8,5);
            steps.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    progress.setCurrentStep(steps.getValue());
                }
            });
            c.fill = GridBagConstraints.VERTICAL;
            c.gridx = 0;
            c.gridy = 1;
            this.add(steps, c);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[]) {
        try {
            JFrame frame = new JFrame("Test Progress");
            frame.setSize(400, 800);
            frame.getContentPane().add(new TestProgress());

            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
