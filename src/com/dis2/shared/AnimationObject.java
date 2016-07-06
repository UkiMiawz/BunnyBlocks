/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis2.shared;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.*;
import java.net.URL;

/**
 *
 * @author idontgiveashit
 */
public class AnimationObject extends JLabel {

    private ImageIcon image;
    public void setImage(String value) {
        URL url = AnimationObject.class.getResource(value);
        ImageIcon icon = new ImageIcon(url);
        this.image = icon;
        setComponent(image);
    }

    public void setImage(ImageIcon value){
        this.image = value;
        setComponent(image);
    }

    private ImageIcon moveImage;
    public void setMoveImage(String value){
        URL url = AnimationObject.class.getResource(value);
        ImageIcon icon = new ImageIcon(url);
        this.moveImage = icon;
    }

    public void setMoveImage(ImageIcon value){
        this.moveImage = value;
    }

    private int xPosition;
    public int getX() { return xPosition; }
    public void setX(int value) { xPosition = value; }

    private int yPosition;
    public int getY() { return yPosition; }
    public void setY(int value) { yPosition = value; }

    public AnimationObject(String img) {
        this(new ImageIcon(img));
    }

    public AnimationObject(ImageIcon image) {
        this.image = image;
        setComponent(image);
    }

    public AnimationObject(int xPosition, int yPosition, ImageIcon imgIcon) {
        setX(xPosition);
        setY(yPosition);
        image = imgIcon;
        setComponent(image);
    }

    public AnimationObject(int xPosition, int yPosition, ImageIcon imgIcon, ImageIcon imgMove) {
        setX(xPosition);
        setY(yPosition);
        image = imgIcon;
        moveImage = imgMove;
        setComponent(image);
    }

    public void moveObject(int xDifference, int yDifference){
        setX(getX() + xDifference);
        setY(getY() + yDifference);
    }

    public void move(){
        if(moveImage != null)
            setComponent(moveImage);
    }

    public void stand(){
        setComponent(image);
    }

    private void setComponent(ImageIcon imageIcon){
        try {
            setIcon(imageIcon);
            setIconTextGap(0);
            setBorder(null);
            setText(null);
            setSize(image.getImage().getWidth(null), image.getImage().getHeight(null));
            setLocation(getX(), getY());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
