
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class fishCard extends cardWidget{
	
	Actions action;
	Image img = Toolkit.getDefaultToolkit().getImage("/Users/tania13/Desktop/Images/fishPink.png");
	BufferedImage bimg;
	int iw;
	int ih; 
	
	
	public fishCard(int x, int y, int w, int h, int arcW, int arcH, double s, int fs){
		super(x,y,w,h,arcW,arcH);
		
		try{
			BufferedImage bimg = ImageIO.read(new File("/Users/tania13/Desktop/Images/fishPink.png"));
			iw = bimg.getWidth();
			ih = bimg.getHeight(); 
		}catch (IOException e) {
				    e.printStackTrace();
		}
		
		this.setFillColor(palette.red());
		this.setImg(img);
		this.setImageHeight(ih);
		this.setImageWidth(iw);
		this.setxMargin(x+ w/24);
		this.setyMargin(y + h/10);
		this.setImageScale(s);
		this.setFontColor(palette.white());
		this.setFontSize(fs);
		this.setTypeFace(1);
		this.setLabel("Move");
		this.setxTextMargin(x + w/3);
		this.setyTextMargin(h - h/10);
		this.setText("The Fish card helps your character to move one position in a straight line");
		
	}


	public Actions getAction() {
		return action;
	}


	public void setAction(Actions action) {
		this.action = action;
	}
	
	
		

}
