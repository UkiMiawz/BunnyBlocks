/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis2.colorPicker;

import com.dis2.progress.TestProgress;
import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class TestWheelSlider extends JFrame {

    public TestWheelSlider() {
        try {
            WheelColor wc = new WheelColor(300, 300);
            wc.setBackground(Color.black);

            URL url = TestWheelSlider.class.getResource("/resources/bunny_brown.png");
            wc.addCharacter(new Character(new Color(182, 123, 63), new ImageIcon(url).getImage()));

            url = TestWheelSlider.class.getResource("/resources/bunny_blue.png");
            wc.addCharacter(new Character(new Color(40, 89, 182), new ImageIcon(url).getImage()));

            url = TestWheelSlider.class.getResource("/resources/bunny_green.png");
            wc.addCharacter(new Character(new Color(64, 182, 55), new ImageIcon(url).getImage()));

            url = TestWheelSlider.class.getResource("/resources/bunny_purple.png");
            wc.addCharacter(new Character(new Color(182, 54, 167), new ImageIcon(url).getImage()));

            url = TestWheelSlider.class.getResource("/resources/bunny_red.png");
            wc.addCharacter(new Character(new Color(182, 56, 46), new ImageIcon(url).getImage()));

            url = TestWheelSlider.class.getResource("/resources/bunny_yellow.png");
            wc.addCharacter(new Character(new Color(237, 204, 0), new ImageIcon(url).getImage()));
            this.setSize(600, 400);
            this.add(wc); 
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[]) {
        try {
           new TestWheelSlider();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
