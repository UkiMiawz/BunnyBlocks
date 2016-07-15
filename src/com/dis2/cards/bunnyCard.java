package com.dis2.cards;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.dis2.shared.Palette;

public class bunnyCard extends cardWidget{
	URL imageUrl = fishCard.class.getResource(
			"/resources/bunny_brown.png");
	Image img = Toolkit.getDefaultToolkit().getImage(imageUrl);
	URL gifUrl = fishCard.class.getResource(
		"/resources/coin.gif");
	Image gif = Toolkit.getDefaultToolkit().createImage(gifUrl);
	BufferedImage bimg;
	int iw;
	int ih;

	public bunnyCard(int x, int y, int w, int h, int arcW, int arcH, double s, int fs){
		super(x,y,w,h,arcW,arcH); 
		try{
			BufferedImage bimg = ImageIO.read(imageUrl);
			iw = bimg.getWidth();
			ih = bimg.getHeight(); 
		}catch (IOException e) {
				    e.printStackTrace();
		}
		
		this.setFillColor(Palette.blue());
		this.setImg(img);
		this.setImageHeight(ih);
		this.setImageWidth(iw);
		this.setImageScale(s);
		this.setxMargin(x+ w/10);
		this.setyMargin(y + h/8);
		this.setFontColor(Palette.white());
		this.setFontSize(fs);
		this.setTypeFace(1);
		this.setLabel("Bunny");
		this.setxTextMargin(x + w/5);
		this.setyTextMargin(h - h/10);
		this.setText("The bunny card will decide the sequence of cards.");
		this.setCardType(0);
		this.setGif(gif);
		this.setGifScale(s);
	}
}
