import javax.smartcardio.Card;
import javax.swing.*;
import java.util.UUID;

/**
 * Created by asifmayilli on 6/27/16.
 */
public class CardItem extends JPanel{
    private int  x;
    private int y;
    private int width;
    private int height;
    private simpleCard card;
    private UUID id ;
    private CardItem parent = null;
    private CardItem child = null;

    public CardItem(int x, int y, int width, int height, simpleCard card){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.card = card;
        this.add(this.card);
        this.id= UUID.randomUUID();

        setSize(this.width,this.height);

        setVisible(true);


    }

    //getters

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
    public void setHeigt(int value){this.height = value;}
    public void setCard(simpleCard value){this.card = value;}
    public void setAnc(CardItem value){this.parent = value;}
    public void setChild(CardItem value){this.child = value;}




}
