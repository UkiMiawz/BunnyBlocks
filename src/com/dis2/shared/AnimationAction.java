package com.dis2.shared;

import com.dis2.cards.complexCard;

public class AnimationAction {
    private Actions animationAction;
    private complexCard card = null;
    
    public Actions getAction() { return animationAction; }
    public void setAction(Actions value) { this.animationAction = value; }
    
    public complexCard getCard(){ return card; }
    public boolean hasCard(){ return card != null? true:false; }
    
    public AnimationAction(Actions actionType){
        this.animationAction = actionType;
    }
    
    public AnimationAction(Actions actionType , complexCard card){
        this.animationAction = actionType;
        this.card = card; 
    }
}
