import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * Created by asifmayilli on 6/27/16.
 */
public class CardPanel extends JLayeredPane  {
    //fields
    private int  x;
    private int y;
    private int width;
    private int height;
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
        this.addMouseListener(new MyAppMouseListener());

        setSize(this.width,this.height);

        if (cardlist.size() != 0) {

               for (simpleCard card : cardlist) {

                CardItem item = new CardItem(0,0,180,280, card);
                item.setBounds(i*10, i*10, 180, 280);
                this.add(item, new Integer(0),0);
                this.carditemlist.add(item);
                i=i+2;

            }
        }
        setVisible(true);

    }

    //setters

    public void setX(int value){this.x = value;}
    public void setY(int value){this.y = value;}
    public void setWidth(int value){this.width = value;}
    public void setHeight(int value){this.height = value;}

    //getters
    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public int getWidth(){return this.width;}
    public int getHeight(){return this.height;}
    public ArrayList<CardItem> getCardItemList(){return this.carditemlist;}






    //Listener

    public class MyAppMouseListener implements MouseListener, MouseMotionListener {

        private int clicks = 0;
        @Override
        public void mouseClicked(MouseEvent e) {

            ArrayList<CardItem> list = carditemlist;
            System.out.println(e.getX());
            if(list.size()!= 0) {

                for (int i = list.size()-1; i>=0; i--) {



                    if( list.get(i).getXcoord() <= e.getX() && e.getX() <= list.get(i).getXcoord()+180 &&
                            list.get(i).getYcoord() <= e.getX() && e.getY() <= list.get(i).getYcoord()+280){
                                    System.out.println(list.get(i).getXcoord());
                                    System.out.println("You clicked elemnt with ID"+ list.get(i).getId());
                                    break;}




                }

            }
            else {System.out.println("No elems");}



        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }










}
