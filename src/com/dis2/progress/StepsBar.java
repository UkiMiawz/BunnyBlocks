package com.dis2.progress;

import com.dis2.shared.Palette;
import com.dis2.shared.Util;
import java.awt.BorderLayout;

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
 
    private int arcWidth = 10;
    private int arcHeight = 10;
    private int stepNumbers = 0;
    private int currentStep = 0;
    private Color baseBackgroundColor = Color.BLACK;
    private Color borderColor = Color.BLACK;
    private Color progressColor = Color.BLUE;
    private int maxBarWidth = 0; 
    private Image goalImage = null;
    private Image progressImage = null; 
    private boolean resizable = false; 
     
    public StepsBar(){ 
         
    }
    
    public  StepsBar(int widthContainer, int heightContainer) {  
        this.setBounds(0, 0, widthContainer, heightContainer); 
        this.setPreferredSize(new Dimension(widthContainer, heightContainer));
    }

    public int getMaxBarWidth() {
        return maxBarWidth;
    }

    public void setMaxBarWidth(int maxBarWidth) {
        this.maxBarWidth = maxBarWidth;
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
        return currentStep * this.getHeight() / this.stepNumbers;
    }
    
    public int getProgressImagePosition(){
        return getProgressInPixels()-(this.progressImage.getHeight(this));
    }
    
    public int getPositionBarX(){
        if(progressImage != null){
            return this.progressImage.getWidth(this);
        }
        return 0;
    }

    @Override
    protected void paintComponent(Graphics g) { 
        super.paintComponent(g); 
        
        int w = 0;
        int x = 0;
        int y = 0;
        
        if (this.isResizable()) {
            w = this.getWidth();
        } else {
            w = maxBarWidth;
            x = (this.getWidth() / 2)-(maxBarWidth/2);
        } 
        
        //Progress container
        g.setColor(this.getBaseBackgroundColor());
        g.fillRoundRect(x, y, w, this.getHeight(), this.arcWidth, this.arcHeight);
       
        //Current progress
        g.setColor(this.getProgressColor());
        g.fillRoundRect(x, y, w, getProgressInPixels(), this.arcWidth, this.arcHeight);

        //Progress background
        g.setColor(this.getBorderColor());
        g.drawRoundRect(x, y, w, this.getHeight(), this.arcWidth, this.arcHeight);

        //calculate width per steps
        int heightPerStep = this.getHeight()/ stepNumbers;
        int currentPosition = 0;
       
        for (int i=0; i<stepNumbers + 1; i++){
            //add pointers
            g.fillRect(x, currentPosition, w, 1);
            currentPosition += heightPerStep;
        }
        
        

        g.drawImage(goalImage, 0, this.getHeight()+40, this);
        g.drawImage(progressImage, Util.getImagenCenterX(this, progressImage), getProgressImagePosition(), this); 
        repaint();
    }

     
}
