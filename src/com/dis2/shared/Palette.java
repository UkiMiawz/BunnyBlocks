package com.dis2.shared;

import java.awt.Color;

/*Palette class 
 * Define colors to be used by components and attributes of the desktop and windows
 * */
public class Palette {

    //Colors with specified RGB values in the range (0 - 255)
    private static Color white = new Color(255, 255, 255);
    private static Color black = new Color(0, 0, 0);
    private static Color green = new Color(0, 127, 7);
    private static Color red = new Color(204, 25, 43);
    private static Color purple = new Color(109, 25, 204);

    private static Color brown = new Color(182, 123, 63);
    private static Color blue = new Color(40, 89, 182);
    private static Color lila = new Color(182, 54, 167);
    private static Color yellow = new Color(237, 204, 0);

    //Methods to call the value of a color from the other classes
    public static Color black(){return black;}
    public static Color white(){return white;}
    public static Color green(){return green;}
    public static Color red(){return red;}
    public static Color purple(){return purple;}
    public static Color lila(){return lila;}
    public static Color brown(){return brown;}
    public static Color blue(){return blue;}
    public static Color yellow(){return yellow;}

}
