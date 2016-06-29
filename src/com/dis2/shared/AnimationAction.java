package com.dis2.shared;

public class AnimationAction {
    private Actions animationAction;
    public Actions getAction() { return animationAction; }
    public void setAction(Actions value) { this.animationAction = value; }

    public AnimationAction(Actions actionType){
        this.animationAction = actionType;
    }
}
