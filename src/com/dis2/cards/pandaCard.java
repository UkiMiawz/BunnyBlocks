import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class pandaCard extends cardWidget{
	
	Conditions condition;
	Image img = Toolkit.getDefaultToolkit().getImage("/Users/tania13/Desktop/Images/panda.png");
	BufferedImage bimg;
	int iw;
	int ih;
	
	public pandaCard(int x, int y, int w, int h, int arcW, int arcH, double s, int fs){
		super(x,y,w,h,arcW,arcH);
		
		try{
			BufferedImage bimg = ImageIO.read(new File("/Users/tania13/Desktop/Images/snake.png"));
			iw = bimg.getWidth();
			ih = bimg.getHeight(); 
		}catch (IOException e) {
				    e.printStackTrace();
		}
		
		this.setFillColor(palette.purple());
		this.setImg(img);
		this.setImageHeight(ih);
		this.setImageWidth(iw);
		this.setImageScale(s);
		this.setFontColor(palette.white());
		this.setFontSize(fs);
		this.setTypeFace(1);
		this.setLabel("If");
		this.setText("The Panda card helps your character decide between options");
	}

	public Conditions getCondition() {
		return condition;
	}

	public void setCondition(Conditions condition) {
		this.condition = condition;
	}

	
	

}
