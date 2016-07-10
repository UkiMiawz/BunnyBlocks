package com.dis2.cards2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Card extends JPanel implements Cloneable{

    private int type = 0;
    private Color borderColor = Color.BLACK;
    private Color defaultColor = Color.BLACK;
    private Color overColor = Color.BLACK;
    private Color dragColor = Color.BLACK;
    private Color dropColor = Color.BLACK;
    private Color selectedColor = Color.BLACK;

    private int Ntimes = 0;

    public int getNtimes() {
        return Ntimes;
    }

    public void setNtimes(int ntimes) {
        Ntimes = ntimes;
    }

    private Dimension defaultSize;

    public Card(int x, int y, int width, int height) {
        this.defaultSize = new Dimension(width, height);
        this.setLayout(null);
        this.setBounds(new Rectangle(x, y, width, height));
    }
    
     @Override public Card clone() {
        try {
            final Card result = (Card) super.clone();
            return result;
        } catch (final CloneNotSupportedException ex) {
            throw new AssertionError();
        }
     }
    
    public Card(Rectangle bouce){
        this.setLayout(null);
        this.setBounds(bouce);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<Card> getChildren() {
        ArrayList<Card> children = new ArrayList<Card>();
        for (Component c : this.getComponents()) {
            if (c.getClass().getSuperclass().getSimpleName().equals("Card")) {
                children.add((Card) c);
            }
        }
        return children;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public Color getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(Color defaultColor) {
        this.defaultColor = defaultColor;
    }

    public Color getOverColor() {
        return overColor;
    }

    public void setOverColor(Color overColor) {
        this.overColor = overColor;
    }

    public Color getDragColor() {
        return dragColor;
    }

    public void setDragColor(Color dragColor) {
        this.dragColor = dragColor;
    }

    public Color getDropColor() {
        return dropColor;
    }

    public void setDropColor(Color dropColor) {
        this.dropColor = dropColor;
    }

    public Color getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(Color selectedColor) {
        this.selectedColor = selectedColor;
    }

    public boolean isChild(Card parent) {
        for (Component c : getComponents()) { 
            if (c instanceof Card) {
                if (parent.equals((Card) c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getDefaultHeight() {
        return defaultSize.height;
    }

    public int getDefaultWidth() {
        return defaultSize.width;
    }

    public Dimension getDefaultSize() {
        return defaultSize;
    }

    public void setDefaultSize(Dimension defaultSize) {
        this.defaultSize = defaultSize;
    }

    public void setDefaultState() {
        this.setBackground(defaultColor);
    }

    public void setDragState() {
        this.setBackground(dragColor);
    }

    public void setDropState() {
        this.setBackground(dropColor);
    }

    public void setOverState() {
        this.setBackground(overColor);
    }

    public void setSelectedState() {
        this.setBackground(selectedColor);
    }

    public Card getCard() {
        return this;
    }

    public void setDefaultBounds() {
        this.setBounds(this.getX(), this.getY(), this.getDefaultWidth(), this.getDefaultHeight());
    }

    public Point getMidPoint() {
        return new Point(this.getX() + this.getWidth() / 2, this.getY() + this.getHeight() / 2);
    }

    public boolean hasChildren() {
        return getChildren().size() == 0 ? false : true;
    }

    public void setBounds(int width, int height) {
        this.setBounds(this.getX(), this.getY(), width, height);
    }

    public void addChild(Card child) {
        this.add(child); 
        int w = this.getWidth() <= child.getWidth() ? child.getWidth()+20 : this.getWidth();
        int h =0; 
        if(this.getChildren().size()==1){
            h=child.getHeight()+40;
            child.setLocation(10, 20);
        }else{
            h=this.getHeight()+child.getHeight()+20;
            child.setLocation(10, this.getHeight());
        } 
        this.setBounds(w, h); 
    }

}
