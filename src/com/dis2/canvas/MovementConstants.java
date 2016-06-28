package com.dis2.canvas;

import static com.dis2.shared.Actions.*;

import com.dis2.shared.Actions;
import com.dis2.shared.AnimationAction;

public class MovementConstants {

    private static final int xBlockVertical = 65;
    private static final int yBlockVertical = 35;
    private static final int xBlockHorizontal = 35;
    private static final int yBlockHorizontal = 65;

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

    public static MovementValue getMovement(Actions movementAction) {
        switch (movementAction){
            case MOVEDOWN:
                return new MovementValue(xBlockVertical, yBlockVertical);
            case MOVEUP:
                return new MovementValue(xBlockVertical, -yBlockVertical);
            case MOVELEFT:
                return new MovementValue(-xBlockHorizontal, yBlockHorizontal);
            case MOVERIGHT:
                return new MovementValue(xBlockHorizontal, yBlockHorizontal);
            default:
                return new MovementValue(0, 0);
        }
    }
}
