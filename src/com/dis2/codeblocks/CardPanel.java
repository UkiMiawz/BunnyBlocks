package com.dis2.codeblocks;
import com.dis2.cards.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.function.Supplier;


/**
 * Created by asifmayilli on 6/27/16.
 */
public class CardPanel extends JLayeredPane  {
    //fields
    private int  x;
    private int y;
    private int width;
    private int height;
    private CardItem activecard = null;


    private ArrayList<simpleCard> cardlist = new ArrayList<simpleCard>();
    private ArrayList<CardItem> carditemlist = new ArrayList<CardItem>();


    public void addCard(simpleCard card){cardlist.add(card);}

    public ArrayList<simpleCard> getCardlist(){return this.cardlist;}
    private int i = 0;

    //constructor
    public CardPanel(int x, int y, int width, int height, ArrayList<simpleCard> cardlist, JFrame window){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.cardlist = cardlist;
        MyAppMouseListener listener =  new MyAppMouseListener();
        this.addMouseListener(listener);
        this.addMouseMotionListener(listener);


        setSize(this.width,this.height);

        if (cardlist.size() != 0) {

               for (simpleCard card : cardlist) {
                CardItem item = new CardItem(i*100,i*100,180,280, card,this);
                i=i+1;
            }
        }
        setVisible(true);

    }

    //setters

    public void setX(int value){this.x = value;}
    public void setY(int value){this.y = value;}
    public void setWidth(int value){this.width = value;}
    public void setHeight(int value){this.height = value;}

    public void setActivecard(int x, int y){

            ArrayList<CardItem> list = carditemlist;


            for (int i = list.size()-1; i>=0; i--) {

                int posX = list.get(i).getXcoord();
                int posY = list.get(i).getYcoord();

                int a = posX + 180;
                int b = posY + 280;



                if (posX < x && x< posX + 180 && posY < y && y < (posY + 280) ){
                    System.out.println(posX +  " " + x + " " + a);
                    System.out.println(posY + " " + y + " " + b);
                    activecard = list.get(i);
                    break;}



            }





    }

    //getters
    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public int getWidth(){return this.width;}
    public int getHeight(){return this.height;}
    public ArrayList<CardItem> getCardItemList(){return this.carditemlist;}
    public CardItem getActivecard(){return this.activecard;}








    //Listener

    public class MyAppMouseListener implements MouseListener, MouseMotionListener {


        private int oldX;
        private int oldY;

        @Override
        public void mouseClicked(MouseEvent e) {


            setActivecard(e.getX(),e.getY());









        }

        @Override
        public void mousePressed(MouseEvent e) {
            oldX = e.getX();
            oldY = e.getY();

            System.out.println("pressed");
            if (activecard == null)  {setActivecard(e.getX(),e.getY());}



        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("released");
            if (activecard != null){
                remove(activecard);
                add(activecard);
                activecard = null;}





        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {


        }

        @Override
        public void mouseDragged(MouseEvent e) {




            if (activecard!=null){
                int dx = e.getX()-oldX ;
                int dy = e.getY()-oldY ;
                int newX = activecard.getX()+dx;
                int newY = activecard.getY()+dy;
                oldX = e.getX();
                oldY = e.getY();



                activecard.setX(newX);
                activecard.setY(newY);
               activecard.setLocation(newX,newY);}
            else return;





        }





        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }










}
