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
    private Color purple = new Color(109,25,204);
   
    
    //Methods to call the value of a color from the other classes
    
    public Color black(){  return black; }
    public Color white(){  return white; }
    public Color green(){  return green; }
    public Color red(){  return red; }
    public Color purple(){  return purple; }

}