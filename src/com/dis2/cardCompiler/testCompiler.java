package com.dis2.cardCompiler;

import com.dis2.cards2.Card;
import com.dis2.shared.AnimationAction;

import java.util.ArrayList;

/**
 * Created by Beeblebrox
 */
public class testCompiler {

    public static void main(String args[]){
        ArrayList<AnimationAction> result = new ArrayList<>();
        ArrayList<Card> cards = new ArrayList<>();

        //add for testing
        Card testFor = new Card(0,0,0,0);
        testFor.setType(1);
        testFor.setNtimes(2);

        Card testMoveUp = new Card(0,0,0,0);
        testMoveUp.setType(2);
        testFor.addChild(testMoveUp);

        Card testMoveDown = new Card(0,0,0,0);
        testMoveUp.setType(3);
        testFor.addChild(testMoveDown);

        cards.add(testFor);

        result = CardCompiler.compileCards(cards);
        System.out.println("Result total : " + result.size());
        for(AnimationAction action: result){
            System.out.println(action.getAction().name());
        }

    }
}
