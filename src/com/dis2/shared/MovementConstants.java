package com.dis2.shared;

public class MovementConstants {

    //initiate common value
    private int xBlockVertical = 55;
    private int yBlockVertical = 33;
    private int xBlockHorizontal = 55;
    private int yBlockHorizontal = -33;

    public int getWidth() {return xBlockVertical;}
    public int getHeight() {return yBlockVertical;}

    public MovementConstants(int xBlockSize, int yBlockSize){
        xBlockVertical = xBlockSize;
        yBlockVertical = yBlockSize;
        xBlockHorizontal = xBlockSize;
        yBlockHorizontal = -yBlockSize;
    }

    public MovementConstants(){}

    public static class MovementValue {
        private int xValue;
        public int getX() { return xValue; }

        private int yValue;
        public int getY() { return yValue; }

        public MovementValue(int xValue, int yValue){
            this.xValue = xValue;
            this.yValue = yValue;
        }
    }

    public MovementValue getMovement(Actions movementAction) {
        switch (movementAction){
            case MOVEDOWN:
                return new MovementValue(xBlockVertical, yBlockVertical);
            case MOVEUP:
                return new MovementValue(-xBlockVertical, -yBlockVertical);
            case MOVELEFT:
                return new MovementValue(-xBlockHorizontal, -yBlockHorizontal);
            case MOVERIGHT:
                return new MovementValue(xBlockHorizontal, yBlockHorizontal);
            default:
                return new MovementValue(0, 0);
        }
    }
}
