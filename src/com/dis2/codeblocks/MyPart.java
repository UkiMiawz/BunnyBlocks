package com.dis2.codeblocks;
import com.dis2.cards.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by asifmayilli on 6/27/16.
 */
public class MyPart {


    public static void main(String[] args) {
        JFrame window = new JFrame("Cards");

        fishCard fish;
        snakeCard snake;
        pandaCard panda;

        snake = new snakeCard(0,0,180, 280, 10, 10, 0.5, 20);
        fish = new fishCard(0,0,180, 280, 10, 10, 0.5, 20);
        panda = new pandaCard(0,0,180, 280, 10, 10, 0.5, 20);

        simpleCard card1= new simpleCard(snake);
        simpleCard card2= new simpleCard(fish);
        simpleCard card3= new simpleCard(panda);
        ArrayList<simpleCard> cardlist = new ArrayList<simpleCard>();
        cardlist.add(card1);
        cardlist.add(card2);
        cardlist.add(card3);

        CardPanel content = new CardPanel(0,0,1000,1000,cardlist,window);
        content.setBackground(Color.blue);




        window.setBounds(0, 0, 1000, 1000);
        window.setPreferredSize(new Dimension(1000, 1000));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(content, BorderLayout.CENTER);
        content.setBounds(0, 0, 1000, 1000);








        window.pack();
        window.setVisible(true);



    }
}