
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class snakeCard extends cardWidget{
	
	private int Ntimes;
	Image img = Toolkit.getDefaultToolkit().getImage("/Users/asifmayilli/Desktop/Images/snake.png");
	BufferedImage bimg;
	int iw;
	int ih;

	public snakeCard(int x, int y, int w, int h, int arcW, int arcH, double s, int fs){
		super(x,y,w,h,arcW,arcH);
		
		try{
			BufferedImage bimg = ImageIO.read(new File("/Users/asifmayilli/Desktop/Images/snake.png"));
			iw = bimg.getWidth();
			ih = bimg.getHeight(); 
		}catch (IOException e) {
				    e.printStackTrace();
		}
		
		this.setFillColor(palette.green());
		this.setImg(img);
		this.setImageHeight(ih);
		this.setImageWidth(iw);
		this.setImageScale(s);
		this.setxMargin(x+ w/10);
		this.setyMargin(y + h/8);
		this.setFontColor(palette.white());
		this.setFontSize(fs);
		this.setTypeFace(1);
		this.setLabel("For");
		this.setxTextMargin(x + w/5);
		this.setyTextMargin(h - h/10);
		this.setText("The Snake card helps your character repeat an instruction N times");
		this.setTextBox(1);
	}

	public int getNtimes() {
		return Ntimes;
	}

	public void setNtimes(int ntimes) {
		this.Ntimes = ntimes;
	}

}
