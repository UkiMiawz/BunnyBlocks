package com.dis2.cards;

import java.awt.Image;
import java.awt.Point;
import java.awt.Color;

public class cardWidget implements Cloneable{

	private int x;
	private int y;
	private int rectWidth;
	private int rectHeight;
	private int arcWidth;
	private int arcHeight;
	private double imageScale;
	private double gifScale;
	private int imageWidth;
	private int imageHeight;
	private Color fillColor;
	private Color fontColor;
	private Color borderColor = Color.black;
	private int typeFace = 0;
    private int fontSize = 12;
    private int xMargin;
    private int yMargin;
    private int xTextMargin;
    private int yTextMargin;
    private String text = "";
    private String label = "";
    private Image img;
    private Image gif;
    private String[] options;
    private boolean simpleCard = true;
    private boolean flagAnim = false;
    private boolean inStack = false;
    private int cardType;
 

    //constructor
    public cardWidget() {
    }

    public cardWidget(int x, int y, int w, int h, int arcW, int arcH) {
        this.x = x;
        this.y = y;
        this.rectWidth = w;
        this.rectHeight = h;
        this.arcWidth = arcW;
        this.arcHeight = arcH;
       
    }

    /*
     * Set and get for all attributes and components
     */
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRectWidth() {
		return rectWidth;
	}

	public void setRectWidth(int rectWidth) {
		this.rectWidth = rectWidth;
	}

	public int getRectHeight() {
		return rectHeight;
	}

	public void setRectHeight(int rectHeight) {
		this.rectHeight = rectHeight;
	}

	public int getArcWidth() {
		return arcWidth;
	}

	public void setArcWidth(int arcWidth) {
		this.arcWidth = arcWidth;
	}

	public int getArcHeight() {
		return arcHeight;
	}

	public void setArcHeight(int arcHeight) {
		this.arcHeight = arcHeight;
	}
	
	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public Color getFontColor() {
		return fontColor;
	}

	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}

	public int getTypeFace() {
		return typeFace; //0= PLAIN, 1 = BOLD;
	}

	public void setTypeFace(int typeFace) {
		this.typeFace = typeFace;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public double getImageScale() {
		return imageScale;
	}

	public void setImageScale(double imageScale) {
		this.imageScale = imageScale;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public Image getGif() {
		return gif;
	}

	public void setGif(Image gif) {
		this.gif = gif;
	}

	public double getGifScale() {
		return gifScale;
	}

	public void setGifScale(double gifScale) {
		this.gifScale = gifScale;
	}

	public int getxMargin() {
		return xMargin;
	}

	public void setxMargin(int xMargin) {
		this.xMargin = xMargin;
	}

	public int getyMargin() {
		return yMargin;
	}

	public void setyMargin(int yMargin) {
		this.yMargin = yMargin;
	}

	public int getxTextMargin() {
		return xTextMargin;
	}

	public void setxTextMargin(int xTextMargin) {
		this.xTextMargin = xTextMargin;
	}

	public int getyTextMargin() {
		return yTextMargin;
	}

	public void setyTextMargin(int yTextMargin) {
		this.yTextMargin = yTextMargin;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}
	
	public int getDefaultHeight() {
        return rectHeight;
    }

    public int getDefaultWidth() {
        return rectWidth;
    }
    
    public void setLocation(Point p){
    	setX(p.x);
    	setY(p.y);
    }
    
    public int getCardType() {
		return cardType;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
	}

	public void setSimpleCard(boolean val){
		this.simpleCard = val;
	}
	
	public boolean isSimpleCard(){
		return simpleCard;
	}
	
	public void setAnimation(boolean val){
		this.flagAnim = val;
	}
	
	public boolean isAnimated(){
		return flagAnim;
	}
    
    public boolean isInStack() {
		return inStack;
	}

	public void setInStack(boolean inStack) {
		this.inStack = inStack;
	}

	@Override public cardWidget clone() {
        try {
            final cardWidget result = (cardWidget) super.clone();
            return result;
        } catch (final CloneNotSupportedException ex) {
            throw new AssertionError();
        }
     }

}
