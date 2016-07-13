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
import java.net.URL;
import javax.swing.*;

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

    /**
     * Save checking string to integer
     * @param s string input
     * @return integer or not
     */
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    /**
     * Check if a rectangle inside another rectangle
     * @param sx first rect x
     * @param sy first rect y
     * @param sw first rect width
     * @param sh first rect height
     * @param rx second rect x
     * @param ry second rect y
     * @param rw second rect width
     * @param rh second rect height
     * @return
     */
    public static boolean overlaps(int sx, int sy, int sw, int sh, int rx, int ry, int rw, int rh) {
        return sx < rx + rw && sx + sw > rx && sy < ry + rh && sy + sh > ry;
    }

    public static void showMessage(String message){
        URL urlWalk = Util.class.getResource(
                "/resources/bunnyStep.gif");
        System.out.println(urlWalk.getPath());
        ImageIcon iconWalk = new ImageIcon(urlWalk);
        JOptionPane.showMessageDialog(null,
                message, "Hello there", JOptionPane.INFORMATION_MESSAGE, iconWalk);
    }
}
