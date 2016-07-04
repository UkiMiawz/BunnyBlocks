package com.dis2.codeblocks;
import com.dis2.cards.simpleCard;

import javax.swing.*;
import java.util.UUID;



/**
 * Created by asifmayilli on 6/27/16.
 */
public class CardItem extends JPanel{
    private int x;
    private int y;
    private int width;
    private int height;
    private simpleCard card;
    private UUID id ;

<<<<<<< HEAD
=======
    private int index;

>>>>>>> AsifBranch

    private CardItem parent = null;
    private CardItem child = null;
    private CardPanel.MyAppMouseListener listener ;

<<<<<<< HEAD
    public CardItem(int x, int y, int width, int height, simpleCard card, CardPanel panel){
=======
    public CardItem(int x, int y, int width, int height, simpleCard card, CardPanel panel,int index){
>>>>>>> AsifBranch
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.card = card;
        this.setBounds(x,y,width,height);
        panel.add(this, new Integer(0),0);
        panel.getCardItemList().add(this);
        this.add(this.card);
        this.id= UUID.randomUUID();
<<<<<<< HEAD
=======
        this.index = index;
>>>>>>> AsifBranch

        setSize(this.width,this.height);
        //listener =  panel.new MyAppMouseListener();
        //this.addMouseListener(listener);
        //this.addMouseMotionListener(listener);
        setVisible(true);


    }

    //getters
<<<<<<< HEAD

=======
    public int getIndex(){return this.index;}
>>>>>>> AsifBranch
    public int getXcoord(){return this.x;}
    public int getYcoord(){return this.y;}

    public int getWidt(){return this.width;}
    public int getHeigt(){return this.height;}
    public simpleCard getCard(){return this.card;}
    public UUID getId(){return this.id;}
    public CardItem getAnc(){return this.parent;}
    public CardItem getChild(){return this.child;}

    //setters
    public void setX(int value){this.x = value;}
    public void setY(int value){this.y = value;}
    public void setWidth(int value){this.width = value;}
    public void setHeight(int value){this.height = value;}
    public void setCard(simpleCard value){this.card = value;}
    public void setAnc(CardItem value){this.parent = value;}
    public void setChild(CardItem value){this.child = value;}


    //motion
    public void moveCard(int x, int y){
        return;
    }









}
