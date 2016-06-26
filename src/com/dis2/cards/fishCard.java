
import java.awt.Image;
import java.awt.Toolkit;

public class fishCard extends cardWidget{
	
	Image img = Toolkit.getDefaultToolkit().getImage("/Resources/fishPink.png");
	double iw = img.getWidth(null);
	double ih= img.getHeight(null);
	
	public fishCard(int x, int y, int w, int h, int arcW, int arcH, double s, int fs){
		super(x,y,w,h,arcW,arcH);
		this.setFillColor(palette.red());
		this.setImg(img);
		this.setImageHeight(ih);
		this.setImageWidth(iw);
		this.setImageScale(s);
		this.setFontColor(palette.white());
		this.setFontSize(fs);
		this.setTypeFace(1);
		this.setLabel("Move");
		this.setText("The Fish card helps your character to move one position in a straight line");
		
	}
	
	public void move(){
		
	}
	
	public void turnLeft(){
		
	}
	
	public void turnRight(){
		
	}
	
	

}
