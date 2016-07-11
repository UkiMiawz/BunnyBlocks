package com.dis2.cards;

import com.dis2.shared.Palette;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class pandaCard extends cardWidget{
	
	Conditions condition;
	URL imageUrl = fishCard.class.getResource(
			"/resources/panda.png");
	Image img = Toolkit.getDefaultToolkit().getImage(imageUrl);
	BufferedImage bimg;
	int iw;
	int ih;
	
	public pandaCard(int x, int y, int w, int h, int arcW, int arcH, double s, int fs){
		super(x,y,w,h,arcW,arcH);
		
		try{
			BufferedImage bimg = ImageIO.read(imageUrl);
			iw = bimg.getWidth();
			ih = bimg.getHeight(); 
		}catch (IOException e) {
				    e.printStackTrace();
		}
		
		this.setFillColor(Palette.purple());
		this.setImg(img);
		this.setImageHeight(ih);
		this.setImageWidth(iw);
		this.setImageScale(s);
		this.setxMargin(x+ w/18);
		this.setyMargin(y + h/7);
		this.setFontColor(Palette.white());
		this.setFontSize(fs);
		this.setTypeFace(1);
		this.setLabel(" If");
		this.setxTextMargin(x + w/3);
		this.setyTextMargin(h - h/5);
		this.setText("The Panda card helps your character decide between options");
	}

	public Conditions getCondition() {
		return condition;
	}

	public void setCondition(Conditions condition) {
		this.condition = condition;
	}	

}
