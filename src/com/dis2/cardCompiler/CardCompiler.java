package com.dis2.cardCompiler;

import com.dis2.cards2.Card;
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
    public static ArrayList<AnimationAction> compileCards(ArrayList<Card> inputCards){
        ArrayList<AnimationAction> result = new ArrayList<>();
        System.out.println(logger + "number of cards " + inputCards.size());

        for(Card inputCard: inputCards){
            if(inputCard.getType() != 1){
                //not for
                switch (inputCard.getType()){
                    case 2:
                        result.add(new AnimationAction(Actions.MOVEUP)); break;
                    case 3:
                        result.add(new AnimationAction(Actions.MOVEDOWN)); break;
                    case 4:
                        result.add(new AnimationAction(Actions.MOVELEFT)); break;
                    case 5:
                        result.add(new AnimationAction(Actions.MOVERIGHT)); break;
                    default:
                        break;
                }
            } else {
                //a for
                //recursive
                System.out.println(logger + "loop number " + inputCard.getNtimes());
                for(int i = 0; i < inputCard.getNtimes(); i++){
                    int test = inputCard.getChildren().size();
                    System.out.println(logger + "number of children " + test);
                    result.addAll(compileCards(inputCard.getChildren()));
                }
            }
        }

        return result;
    }
}
