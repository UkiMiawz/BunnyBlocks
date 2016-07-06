package com.dis2.shared;

import java.awt.Color;

/*Palette class 
 * Define colors to be used by components and attributes of the desktop and windows
 * */

public class Palette {
    
    //Colors with specified RGB values in the range (0 - 255)
    private Color white = new Color(255,255,255);
    private Color black = new Color(0,0,0);
    private Color green = new Color(0,127,7);
    private Color red = new Color(204,25,43);
    private Color purple = new Color(102, 0, 255);
    private Color violet = new Color(153, 0, 51);

    private Color brown = new Color(182, 123, 63);
    private Color blue = new Color(40, 89, 182); 
    private Color lila = new Color(182, 54, 167); 
    private Color yellow = new Color(237, 204, 0);

    
    private Color brightGreen = new Color(0, 204, 0);
    private Color brightRed = new Color(255, 0, 0);
    private Color brightPurple = new Color(163, 102, 255);
    private Color brightViolet = new Color(255, 0, 85);
   
    
    //Methods to call the value of a color from the other classes
    
    public Color black(){  return black; }
    public Color white(){  return white; }
    public Color green(){  return green; }
    public Color red(){  return red; }
    public Color purple(){  return purple; }
    public Color violet(){ return violet;}
    public Color lila(){return lila;}
    public Color brown(){return brown;}
    public Color blue(){return blue;}
    public Color yellow(){return yellow;}

    
    public Color brightGreen(){  return brightGreen; }
    public Color brightRed(){  return brightRed; }
    public Color brightPurple(){  return brightPurple; }
    public Color brightViolet(){ return brightViolet; }

}