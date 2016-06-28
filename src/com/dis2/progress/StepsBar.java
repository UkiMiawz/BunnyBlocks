package com.dis2.progress;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 *
 * @author David
 */
public class StepsBar extends JPanel {

    private int fixedWidth = 0;
    private int fixedHeight = 0;
    private int arcWidth = 10;
    private int arcHeight = 10;
    private int stepNumbers = 0;
    private int currentStep = 0;
    private Color baseBackgroundColor = Color.BLACK;
    private Color borderColor = Color.BLACK;
    private Color progressColor = Color.BLUE;

    private Image goalImage = null;
    private Image progressImage = null;

    private boolean resizable = false;

    public StepsBar(int width, int height) {
        this.fixedWidth = width;
        this.fixedHeight = height;
    }

    public int getFixedWidth() {
        return fixedWidth;
    }

    public void setFixedWidth(int fixedWidth) {
        this.fixedWidth = fixedWidth;
    }

    public int getFixedHeight() {
        return fixedHeight;
    }

    public void setFixedHeight(int fixedHeight) {
        this.fixedHeight = fixedHeight;
    }

    public int getArcWidth() {
        return arcWidth;
    }

    public void setArcWidth(int arcWidth) {
        this.arcWidth = arcWidth;
    }

    public int getArcHeight() {
        return arcHeight;
    }

    public void setArcHeight(int arcHeight) {
        this.arcHeight = arcHeight;
    }

    public int getStepNumbers() {
        return stepNumbers;
    }

    public void setStepNumbers(int stepNumbers) {
        this.stepNumbers = stepNumbers;
    }

    public int getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(int currentStep) {
        this.currentStep = currentStep;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public Color getProgressColor() {
        return progressColor;
    }

    public Color getBaseBackgroundColor() {
        return baseBackgroundColor;
    }

    public void setBaseBackgroundColor(Color baseBackgroundColor) {
        this.baseBackgroundColor = baseBackgroundColor;
    } 

    public void setProgressColor(Color progressColor) {
        this.progressColor = progressColor;
    }

    public Image getGoalImage() {
        return goalImage;
    }

    public void setGoalImage(Image goalImage) {
        this.goalImage = goalImage;
    }
    
    public void setGoalImage(String imgPath) {
       this.goalImage = new ImageIcon(imgPath).getImage();
    }
    
    public Image getProgressImage() {
        return progressImage;
    }

    public void setProgressImage(Image progressImage) {
        this.progressImage = progressImage;
    }
    
    public void setProgressImage(String imgPath) {
       progressImage = new ImageIcon(imgPath).getImage();
    }

    public boolean isResizable() {
        return resizable;
    }

    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }
    
    public int getProgressInPixels(){ 
        return currentStep * this.getWidth() / this.stepNumbers;   
    }
    
    public int getProgressImagePosition(){
        return getProgressInPixels()-(this.progressImage.getWidth(this));
    }
    
    public int getPositionBarY(){
        if(progressImage != null){
            return this.progressImage.getHeight(this);
        }
        return 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
       
        if (this.isResizable()) {
            this.setSize(new Dimension(this.getWidth(), this.progressImage.getHeight(this)+this.fixedHeight));
        } else {
            this.setSize(new Dimension(this.fixedWidth, this.progressImage.getHeight(this)+this.fixedHeight));
        }
        
        //Progress container
        g.setColor(this.getBaseBackgroundColor());
        g.fillRoundRect(0, getPositionBarY(), this.getWidth(), this.fixedHeight, this.arcWidth, this.arcHeight);
       
        //Current progress
        g.setColor(this.getProgressColor());
        g.fillRoundRect(0, getPositionBarY(), getProgressInPixels(), this.fixedHeight, this.arcWidth, this.arcHeight);
        
        //Progress background
        g.setColor(this.getBorderColor());
        g.drawRoundRect(0, getPositionBarY(), this.getWidth(), this.fixedHeight, this.arcWidth, this.arcHeight);
        
        g.drawImage(goalImage, this.getWidth()-40, 0, this);
        g.drawImage(progressImage, getProgressImagePosition(), 0, this);
    }
}
