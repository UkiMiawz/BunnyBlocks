/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis2.colorPicker;
 
import com.dis2.shared.Palette;  
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
 
/**
 *
 * @author David
 */
public class TestWheelSlider extends JFrame {
    Palette pallete = new Palette();
    public TestWheelSlider() {
        try {
            WheelColor wc = new WheelColor(300, 300);
            wc.setBackground(pallete.black());
            wc.setWheelRadius(30);
            URL url = TestWheelSlider.class.getResource("/resources/bunny_brown.png");
            wc.addCharacter(new Character(pallete.brown(), new ImageIcon(url).getImage()));

            url = TestWheelSlider.class.getResource("/resources/bunny_blue.png");
            wc.addCharacter(new Character(pallete.blue(), new ImageIcon(url).getImage()));

            url = TestWheelSlider.class.getResource("/resources/bunny_green.png");
            wc.addCharacter(new Character(pallete.green(), new ImageIcon(url).getImage()));

            url = TestWheelSlider.class.getResource("/resources/bunny_purple.png");
            wc.addCharacter(new Character(pallete.lila(), new ImageIcon(url).getImage()));

            url = TestWheelSlider.class.getResource("/resources/bunny_red.png");
            wc.addCharacter(new Character(pallete.red(), new ImageIcon(url).getImage()));

            url = TestWheelSlider.class.getResource("/resources/bunny_yellow.png");
            wc.addCharacter(new Character(pallete.yellow(), new ImageIcon(url).getImage()));
            
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
