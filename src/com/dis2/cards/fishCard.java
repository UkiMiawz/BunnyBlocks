package com.dis2.cards;

import com.dis2.shared.Actions;
import com.dis2.shared.Palette;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class fishCard extends cardWidget{
	
	Actions action;
	URL imageUrl;
	Image img;
	URL gifUrl = fishCard.class.getResource(
		"/resources/fish_hd.gif");
	Image gif = Toolkit.getDefaultToolkit().createImage(gifUrl);
	BufferedImage bimg;
	String text;
	int iw;
	int ih;
	
	public fishCard(int x, int y, int w, int h, int arcW, int arcH, double s, int fs, int type){
		super(x,y,w,h,arcW,arcH);
		setImage(type);
		try{
			BufferedImage bimg = ImageIO.read(imageUrl);
			iw = bimg.getWidth();
			ih = bimg.getHeight(); 
		}catch (IOException e) {
				    e.printStackTrace();
		}
		this.setImg(img);
		this.setFillColor(Palette.violet());
		this.setImageHeight(ih);
		this.setImageWidth(iw);
		this.setxMargin(x+ w/24);
		this.setyMargin(y + h/7);
		this.setImageScale(s);
		this.setFontColor(Palette.white());
		this.setFontSize(fs);
		this.setTypeFace(1);
		this.setLabel(text);
		this.setxTextMargin(x + w/3);
		this.setyTextMargin(h - h/10);
		this.setText("The Fish card helps your character to move one position in a straight line");
		this.setGif(gif);
		this.setGifScale(s);
		this.setCardType(type);
		
	}
	
	public void setImage(int type){
		String file="fish_right.png";
		switch(type){
		case 2:
			file = "fish_up.png";
			text = "Move Up";
			break;
		case 3:
			file = "fish_down.png";
			text = "Move Down";
			break;
		case 4:
			file = "fish_left.png";
			text = "Move Left";
			break;
		case 5:
			file = "fish_right.png";
			text = "Move Right";
			break;
		}
		
		imageUrl = fishCard.class.getResource(
				"/resources/"+file);
		img = Toolkit.getDefaultToolkit().getImage(imageUrl);
	}

	public Actions getAction() {
		return action;
	}

	public void setAction(Actions action) {
		this.action = action;
	}
	
	
		

}
