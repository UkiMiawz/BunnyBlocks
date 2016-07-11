/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis2.shared;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import static com.dis2.shared.Actions.MOVEDOWN;

/**
 *
 * @author David
 */
public class Util {

    public static int getImagenCenterX(JPanel panel, Image character) {
        return (panel.getWidth() / 2) - (character.getWidth(panel) / 2);
    }
    
    public static int getImagenCenterX(JPanel panel, int w) {
        return (panel.getWidth() / 2) - (w / 2);
    }

    public static int getImagenCenterY(JPanel panel, Image character) {
        return (panel.getHeight() / 2) - (character.getHeight(panel) / 2);
    }
    
    public static int getStringCenterX(JPanel panel, int label){
    	return (panel.getWidth() / 2) - (label/2);
    }

    public static boolean isPixelTransparent(Image img, Point p) {
        try {
            int pixel = toBufferedImage(img).getRGB(p.x, p.y);
            if ((pixel >> 24) == 0x00) {
                return true;
            }
        } catch (Exception e) { 
        }

        return false;
    }

    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        // Return the buffered image
        return bimage;
    }

    public static Actions getBackward(Actions action){
        switch (action){
            case MOVEDOWN:
                return Actions.MOVEUP;
            case MOVEUP:
                return Actions.MOVEDOWN;
            case MOVELEFT:
                return Actions.MOVERIGHT;
            case MOVERIGHT:
                return Actions.MOVELEFT;
            default:
                return Actions.MOVEUP;
        }
    }
}
