package com.dis2.cards;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.dis2.shared.Palette;
import com.dis2.shared.Util;
import java.awt.Color;

public class complexCard extends JPanel implements Cloneable {

    private static final long serialVersionUID = 2L;

    JPanel animate = new JPanel();
    JTextField forN;  //Use only with snake card
    cardWidget c;
    Util util = new Util();
    boolean flagAnim = false;

    public complexCard() {
    }

    public complexCard(cardWidget c) { 
        this.c = c; 
        forN = new JTextField("0", 2);
        
        this.setBounds(new Rectangle(c.getX(), c.getY(), c.getRectWidth(), c.getRectHeight()));
        this.setLayout(null);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                flagAnim = true; //this starts the animation of the gif
                //stateChanged(c); //test for highlight color in cards
                revalidate();
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                flagAnim = false; //this ends the animation of the gif and repaint regular img
                //stateBack(c); // //test for highlight color in cards
                revalidate();
                repaint();

            }
        });
        
        this.setBackground(Color.red);
        
        if(!c.isSimpleCard()){ 
            forN.setBounds(0, 0, 30, 30);
            this.add(forN);
            forN.repaint();
            forN.requestFocus();
            forN.revalidate();
        }
        
        
        

    }

    public cardWidget getCardWidget() {
        return this.c;
    }

//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        if (c.isSimpleCard()) {
//            this.setBounds(this.getX(), this.getY(), c.getRectWidth(), c.getRectHeight());
//
//        }
//        //draw border
//        g.setColor(c.getBorderColor());
//        g.drawRoundRect(0, 0, this.getWidth(), this.getHeight(), c.getArcWidth(), c.getArcHeight());
//        g.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), c.getArcWidth(), c.getArcHeight());
//        //draw card background
//        g.setColor(c.getFillColor());
//        g.drawRoundRect(2, 2, this.getWidth() - 4, this.getHeight() - 4, c.getArcWidth() - 1, c.getArcHeight() - 1);
//        g.fillRoundRect(2, 2, this.getWidth() - 4, this.getHeight() - 4, c.getArcWidth() - 1, c.getArcHeight() - 1);
//        //draw card with alles
//        setImageDraw(g, c.getImg());
//
//    }

    public void setImageDraw(Graphics g, Image i) {

        if (c.isSimpleCard()) {
            double w = c.getImageScale() * c.getImageWidth();
            double h = c.getImageScale() * c.getImageHeight();

            // explicitly specify width (w) and height (h) to scale Image
            if (!flagAnim) {
                g.drawImage(c.getImg(), util.getImagenCenterX(this, (int) w), c.getyMargin(), (int) w, (int) h, this);

            } else {
                g.drawImage(c.getGif(), util.getImagenCenterX(this, (int) w), c.getyMargin(), (int) w, (int) h, this);
            }
            g.setColor(c.getFontColor());
            g.setFont(new Font("Courier", Font.BOLD, c.getFontSize()));
            g.drawString(c.getLabel(), util.getStringCenterX(this, g.getFontMetrics().stringWidth(c.getLabel())), c.getyTextMargin());

        } else if ((!c.isSimpleCard()) && (!c.isInStack())) {

            double w = c.getImageScale() * c.getImageWidth();
            double h = c.getImageScale() * c.getImageHeight();

            switch (c.getCardType()) {

                case 1: // for
                    g.drawImage(c.getImg(), util.getImagenCenterX(this, (int) w), c.getyMargin(), (int) w, (int) h, this);
                    g.setColor(c.getFontColor());
                    g.setFont(new Font("Courier", Font.BOLD, c.getFontSize()));
                    g.drawString(c.getLabel(), util.getStringCenterX(this, g.getFontMetrics().stringWidth(c.getLabel())) - 15, c.getyTextMargin());
                    forN.setBounds(util.getStringCenterX(this, g.getFontMetrics().stringWidth(c.getLabel())) + 15, c.getyTextMargin() - 18, 40, 25);
                    this.add(forN);
                    break;
                ////
                case 2: // moveUp

                    g.drawImage(c.getImg(), util.getImagenCenterX(this, (int) w), c.getyMargin(), (int) w, (int) h, this);
                    g.setColor(c.getFontColor());
                    g.setFont(new Font("Courier", Font.BOLD, c.getFontSize()));
                    g.drawString(c.getLabel(), util.getStringCenterX(this, g.getFontMetrics().stringWidth(c.getLabel())), c.getyTextMargin());
                    break;
                case 3: // moveDown

                    g.drawImage(c.getImg(), util.getImagenCenterX(this, (int) w), c.getyMargin(), (int) w, (int) h, this);
                    g.setColor(c.getFontColor());
                    g.setFont(new Font("Courier", Font.BOLD, c.getFontSize()));
                    g.drawString(c.getLabel(), util.getStringCenterX(this, g.getFontMetrics().stringWidth(c.getLabel())), c.getyTextMargin());
                    break;
                case 4: // moveLeft

                    g.drawImage(c.getImg(), util.getImagenCenterX(this, (int) w), c.getyMargin(), (int) w, (int) h, this);
                    g.setColor(c.getFontColor());
                    g.setFont(new Font("Courier", Font.BOLD, c.getFontSize()));
                    g.drawString(c.getLabel(), util.getStringCenterX(this, g.getFontMetrics().stringWidth(c.getLabel())), c.getyTextMargin() - 10);
                    break;
                case 5: //moveRight
                    g.drawImage(c.getImg(), util.getImagenCenterX(this, (int) w), c.getyMargin(), (int) w, (int) h, this);
                    g.setColor(c.getFontColor());
                    g.setFont(new Font("Courier", Font.BOLD, c.getFontSize()));
                    g.drawString(c.getLabel(), util.getStringCenterX(this, g.getFontMetrics().stringWidth(c.getLabel())), c.getyTextMargin() - 10);
                    break;
            }

        } else if (c.isInStack()) {
            double w = 40;
            double h = 40;
            g.drawImage(c.getImg(), 3, 3, (int) w, (int) h, this);
            g.setColor(c.getFontColor());
            g.setFont(new Font("Courier", Font.BOLD, 16));
            g.drawString(c.getLabel(), (c.getRectWidth() - 35 - g.getFontMetrics().stringWidth(c.getLabel())), 28);
            forN.setBounds(c.getRectWidth() - 35, 10, 40, 25);
            forN.requestFocus();
            this.add(forN);

            /**
             * Action event for Snake card Take number input by user and set it
             * in snakeCard
             */
            forN.addActionListener(new ActionListener() { //Use only with snake card
                public void actionPerformed(ActionEvent e) {

                    System.out.println("N For=" + forN.getText());
                    ((snakeCard) c).setNtimes(Integer.valueOf(forN.getText()));
                }
            });

        }

    }

    public void setBounds(int width, int height) {
        this.setBounds(this.getX(), this.getY(), width, height);
    }

    public void addChild(complexCard child) {
        this.add(child);
        int w = this.getWidth() <= child.getWidth() ? child.getWidth() + 20 : this.getWidth();
        int h = 0;
        if (this.getChildren().size() == 1) {
            h = child.getHeight() + 80;
            child.setLocation(10, 60);
        } else {
            h = this.getHeight() + child.getHeight() + 10;
            child.setLocation(10, this.getHeight());
        }
        this.setBounds(w, h);
    }

    public ArrayList<complexCard> getChildren() {
        ArrayList<complexCard> children = new ArrayList<complexCard>();
        for (Component c : this.getComponents()) {
            if (c.getClass().getSimpleName().equals("complexCard")) {
                children.add((complexCard) c);
            }
        }
        return children;
    }

    public boolean hasChildren() {
        return getChildren().size() == 0 ? false : true;
    }

    public Point getMidPoint() {
        return new Point(this.getX() + this.getWidth() / 2, this.getY() + this.getHeight() / 2);
    }

    /**
     * Change color of card when the code is running
     */
    public void setHighlight() {

        if (c.getCardType() == 1) {
            c.setFillColor(Palette.brightGreen());
            repaint();

        } else {
            c.setFillColor(Palette.brightViolet());
            repaint();
        }

    }

    /**
     * Get back original color of card
     */
    public void setDefaultState() {

        if (c.getCardType() == 1) {
            c.setFillColor(Palette.green());
            repaint();

        } else {
            c.setFillColor(Palette.violet());
            repaint();
        }

    }

    public void setDefaultBounds() {
        this.setBounds(c.getX(), c.getY(), c.getDefaultWidth(), c.getDefaultHeight());
    }

    @Override
    public complexCard clone() {
        try {
            final complexCard result = (complexCard) super.clone();
            return result;
        } catch (final CloneNotSupportedException ex) {
            throw new AssertionError();
        }
    }

}
