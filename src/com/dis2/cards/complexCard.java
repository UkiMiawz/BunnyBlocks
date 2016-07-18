package com.dis2.cards;

import com.dis2.app.app;
import com.dis2.shared.CustomCursor;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.dis2.shared.Palette;
import com.dis2.shared.Util;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class complexCard extends JPanel implements Cloneable {

    private static final long serialVersionUID = 2L;

    JPanel animate = new JPanel();
    JTextField forN;  //Use only with snake card
    cardWidget c;
    Util util = new Util();

    boolean flagAnim = false;

    public complexCard() {
    }

    public complexCard getSelf() {
        return this;
    }

    public complexCard(cardWidget c) {
        this.c = c;
        forN = new JTextField("1", 2);
        this.setBounds(new Rectangle(c.getX(), c.getY(), c.getRectWidth(), c.getRectHeight()));
        this.setLayout(null);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                getSelf().setCursor(CustomCursor.hand());
                flagAnim = true; //this starts the animation of the gif
        		
                String currentDescText = c.getText();
        		Font currentDescFont = new Font("Arial Black", Font.ITALIC, 14);
        		Color currentDescColor = c.getFillColor();
        		//menuWidget.descGlobalLabel.setPreferredSize(new Dimension(menuWidget.getWidth(), 100));
        		app.menuWidget.descriptionPanel.ChangeText(currentDescText, currentDescColor, currentDescFont);		

                revalidate();
                repaint();
            }

            public void mousePressed(MouseEvent e) {
                getSelf().setCursor(CustomCursor.grab());
            }

            public void mouseReleased(MouseEvent e) {
                getSelf().setCursor(CustomCursor.hand());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                flagAnim = false; //this ends the animation of the gif and repaint regular img
                //stateBack(c); // //test for highlight color in cards
        		
                revalidate();
                repaint();

            }
        });

        this.setOpaque(true);
        this.setBackground(new Color(0, 0, 0, 0));
        if (!c.isSimpleCard() && c.getCardType() == 1) {
            forN.setBounds(0, 0, 20, 25);
            forN.setDragEnabled(false);
            forN.getDocument().addDocumentListener(new DocumentListener() {
                public void changedUpdate(DocumentEvent e) {
                    checkInput();
                }

                public void removeUpdate(DocumentEvent e) {
                    checkInput();
                }

                public void insertUpdate(DocumentEvent e) {
                    checkInput();
                }

                public void checkInput() {
                    String textInput = forN.getText();
                    try {
                        ((snakeCard) c).setNtimes(Integer.valueOf(forN.getText()));
                        System.out.println(Integer.valueOf(forN.getText()));
                    } catch (Exception e) {
                        ((snakeCard) c).setNtimes(1);
                    } 
                }
            }); 
        }

    }

    public cardWidget getCardWidget() {
        return this.c;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (c.isSimpleCard()) {
            this.setBounds(this.getX(), this.getY(), c.getRectWidth(), c.getRectHeight());

        }
      //draw border
        g.setColor(c.getBorderColor());
        g.drawRoundRect(0, 0, this.getWidth(), this.getHeight(), c.getArcWidth(), c.getArcHeight());
        g.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), c.getArcWidth(), c.getArcHeight());
        //draw card background
        g.setColor(c.getFillColor());
        g.drawRoundRect(2, 2, this.getWidth() - 4, this.getHeight() - 4, c.getArcWidth() - 1, c.getArcHeight() - 1);
        g.fillRoundRect(2, 2, this.getWidth() - 4, this.getHeight() - 4, c.getArcWidth() - 1, c.getArcHeight() - 1);

        //draw card with alles
        setImageDraw(g, c.getImg());

    }

    public void setImageDraw(Graphics g, Image i) {
    	
        g.setColor(c.getFontColor());
        g.setFont(new Font("Courier", Font.BOLD, c.getFontSize()));

        if (c.isSimpleCard()) {
            double w = c.getImageScale() * c.getImageWidth();
            double h = c.getImageScale() * c.getImageHeight();

            // explicitly specify width (w) and height (h) to scale Image
            if (!flagAnim) {
                g.drawImage(c.getImg(), util.getImagenCenterX(this, (int) w), c.getyMargin(), (int) w, (int) h, this);
            } else {
                g.drawImage(c.getGif(), util.getImagenCenterX(this, (int) w), c.getyMargin(), (int) w, (int) h, this);
            }
            g.drawString(c.getLabel(), util.getStringCenterX(this, g.getFontMetrics().stringWidth(c.getLabel())), c.getyTextMargin());

        } else if ((!c.isSimpleCard()) && (!c.isInStack())) {

            double w = c.getImageScale() * c.getImageWidth();
            double h = c.getImageScale() * c.getImageHeight();

            switch (c.getCardType()) {
            	case 0: // main Card
            		g.drawImage(c.getImg(), util.getImagenCenterX(this, (int) w), c.getyMargin(), (int) w, (int) h, this);
            		g.drawString(c.getLabel(), util.getStringCenterX(this, g.getFontMetrics().stringWidth(c.getLabel())), c.getyTextMargin());
            		break;
               	case 1: // for
                    g.drawImage(c.getImg(), util.getImagenCenterX(this, (int) w), c.getyMargin()-10, (int) w, (int) h, this);
                    g.drawString(c.getLabel(), util.getStringCenterX(this, g.getFontMetrics().stringWidth(c.getLabel())), c.getyTextMargin()-20);
                    g.drawString("times", c.getRectWidth()-65, c.getyTextMargin());
                    forN.setBounds(util.getStringCenterX(this, g.getFontMetrics().stringWidth(c.getLabel()))-10, c.getyTextMargin()-15, 25, 25);
                    this.add(forN);
                    break;
                case 2: // moveUp 
                case 3: // moveDown 
                case 4: // moveLeft 
                case 5: //moveRight
                    g.drawImage(c.getImg(), util.getImagenCenterX(this, (int) w), c.getyMargin(), (int) w, (int) h, this);
                    g.drawString(c.getLabel(), util.getStringCenterX(this, g.getFontMetrics().stringWidth(c.getLabel())), c.getyTextMargin() - 10);
                    break;                
            }

        } else if (c.isInStack()) {        	
        		double w = 30;
        		double h = 30;
        		g.drawImage(c.getImg(), 3, 3, (int) w, (int) h, this);
        		g.setColor(c.getFontColor());
        		g.setFont(new Font("Courier", Font.BOLD, 16));
        		if (c.getCardType() == 1)
        		{
        			g.drawString(c.getLabel(), (c.getRectWidth() - g.getFontMetrics().stringWidth(c.getLabel()))-10, 18);
        			g.drawString("times", c.getRectWidth()-40, 45);
        			forN.setBounds(c.getRectWidth()-70, 25, 30, 25);	
        		}
        		else if(c.getCardType() == 0)
        		{
        			g.drawString(c.getLabel(), (c.getRectWidth() - 10 - g.getFontMetrics().stringWidth(c.getLabel())), 28);        			
        		}
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

        }else if(c.getCardType()==0){
        	c.setFillColor(Palette.brightBlue());
            repaint();
        }else {
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
        } else if(c.getCardType()==0){
        	c.setFillColor(Palette.blue());
            repaint();
        }else {
            c.setFillColor(Palette.violet());
            repaint();
        }
    }

    /*
	 * Recalculate card's size based on its children.
     */
    public void recalculateSize() {
        if (this.hasChildren()) {
            // Set a card to its default value first.
            this.setBounds(c.getDefaultWidth(), c.getDefaultHeight());

            // Get the default width based on first child.
            int w = 0;
            int h = 0;

            for (int i = 0; i < this.getChildren().size(); i++) {
                if (i == 0) {
                    // Do this only on the first child.
                	complexCard firstChild = this.getChildren().get(0);
                   	w = firstChild.getWidth() + 20;
                	h = firstChild.getHeight() + 80;
                    firstChild.setLocation(10, 60);
                    this.setBounds(w, h);
                } else {
                    complexCard currentChild = this.getChildren().get(i);
                    int currentChildWidth = currentChild.getWidth() + 20;
                    if (currentChildWidth > w)
                    {
                    	w = currentChildWidth;
                    }
                    h = this.getHeight() + currentChild.getHeight() + 10;
                    currentChild.setLocation(10, this.getHeight());
                    this.setBounds(w, h);
                }
            }
        } else {
            // If the card has no child, then set all of its properties to default.
            this.c.setInStack(false);
            this.setBounds(c.getDefaultWidth(), c.getDefaultHeight());
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
