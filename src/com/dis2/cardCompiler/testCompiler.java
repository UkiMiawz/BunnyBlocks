package com.dis2.cardCompiler;

import com.dis2.cards.complexCard;
import com.dis2.cards.snakeCard;
import com.dis2.cards.fishCard;
import com.dis2.shared.AnimationAction;

import java.util.ArrayList;

/**
 * Created by Beeblebrox
 */
public class testCompiler {

    public static void main(String args[]){
        ArrayList<AnimationAction> result = new ArrayList<>();
        ArrayList<complexCard> cards = new ArrayList<>();

        //add for testing
        snakeCard cardWidgetFor = new snakeCard(0,0,0,0,0,0,0,0);
        cardWidgetFor.setCardType(1);
        cardWidgetFor.setNtimes(2);
        complexCard testFor = new complexCard(cardWidgetFor);

        fishCard cardWidgetMoveUp = new fishCard(0,0,0,0,0,0,0,0,2);
        complexCard testMoveUp = new complexCard(cardWidgetMoveUp);
        testFor.addChild(testMoveUp);

        fishCard cardWidgetMoveDown = new fishCard(0,0,0,0,0,0,0,0,3);
        complexCard testMoveDown = new complexCard(cardWidgetMoveDown);
        testFor.addChild(testMoveDown);

        cards.add(testFor);

        result = CardCompiler.compileCards(cards);
        System.out.println("Result total : " + result.size());
        for(AnimationAction action: result){
            System.out.println(action.getAction().name());
        }
    }
}