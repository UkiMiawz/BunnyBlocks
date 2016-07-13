/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis2.shared;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.net.URL;

public class CustomCursor {
 
    public static Cursor hand() {
        java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
        URL url = CustomCursor.class.getResource("/resources/cursor/hand.png");
        Image image = toolkit.getImage(url);
        return toolkit.createCustomCursor(image.getScaledInstance(30, 30, 1), new Point(15, 15), ""); 
    }
    
    public static Cursor grab() {
        java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
        URL url = CustomCursor.class.getResource("/resources/cursor/grab.png");
        Image image = toolkit.getImage(url);
        return toolkit.createCustomCursor(image.getScaledInstance(30, 30, 1), new Point(15, 15), ""); 
    }
}
