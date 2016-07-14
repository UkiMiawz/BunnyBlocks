package com.dis2.cardCompiler;

import com.dis2.cards.complexCard;
import com.dis2.cards.snakeCard;

import com.dis2.shared.Actions;
import com.dis2.shared.AnimationAction;

import java.util.ArrayList;

/**
 * Created by Slartirbarfast.
 */
public class CardCompiler {

    private static final String logger = "Card Compiler : ";
    /*
    1 FOR, 2 MOVEUP, 3 MOVEDOWN, 4 MOVELEFT, 5 MOVERIGHT
    */
    public static ArrayList<AnimationAction> compileCards(ArrayList<complexCard> inputCards){
        ArrayList<AnimationAction> result = new ArrayList<>();
        System.out.println(logger + "number of cards " + inputCards.size());

        for(complexCard inputCard: inputCards){
            if(inputCard.getCardWidget().getCardType() != 1){
                //not for
                switch (inputCard.getCardWidget().getCardType()){
                    case 2:
                        result.add(new AnimationAction(Actions.MOVEUP ,inputCard)); break;
                    case 3:
                        result.add(new AnimationAction(Actions.MOVEDOWN, inputCard)); break;
                    case 4:
                        result.add(new AnimationAction(Actions.MOVELEFT, inputCard)); break;
                    case 5:
                        result.add(new AnimationAction(Actions.MOVERIGHT,inputCard)); break;
                    default:
                        break;
                }
            } else {
                //cast card to for
                snakeCard currentCard = (snakeCard) inputCard.getCardWidget();
                int loopNumber = currentCard.getNtimes();
                //recursive
                System.out.println(logger + "loop number " + loopNumber);
                for(int i = 0; i < loopNumber; i++){
                    int test = inputCard.getChildren().size();
                    System.out.println(logger + "number of children " + test);
                    result.addAll(compileCards(inputCard.getChildren()));
                }
            }
        }

        return result;
    }
}