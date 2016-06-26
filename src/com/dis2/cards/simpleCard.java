
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class simpleCard extends JPanel{
	
	public Palette palette = new Palette();
	cardWidget cw;
	
	public static JTextField forN;
	JTextField textField;
    JPanel panel;

/* 
   public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	
    	System.out.println(cw.getX() + cw.getY() + cw.getRectWidth() + cw.getRectHeight() + cw.getArcWidth() + cw.getArcHeight());
		
    	g.drawRoundRect(cw.getX(), cw.getY(), cw.getRectWidth(), cw.getRectHeight(), cw.getArcWidth(), cw.getArcHeight());
	    g.setColor(cw.getFillColor());
	    g.fillRoundRect(cw.getX(), cw.getY(), cw.getRectWidth(), cw.getRectHeight(), cw.getArcWidth(), cw.getArcHeight());
	    
	    double w = cw.getImageScale() * cw.getImageWidth();
	    double h = cw.getImageScale() * cw.getImageHeight();
	    // explicitly specify width (w) and height (h)
	    g.drawImage(cw.getImg(), 605, 25, (int) w, (int) h, this);
	    g.setColor(cw.getFontColor());
	    g.drawString(cw.getLabel(),(605+50), 220);   
	    
	}*/

    //just to test drawing, actual drawing should be done as above
    public void paintComponent(Graphics g) { 
		super.paintComponent(g);
	    g.drawRoundRect(10, 10, 160, 240, 10, 10);
	    g.setColor(palette.green());
	    g.fillRoundRect(10, 10, 160, 240, 10, 10);
	    
	    
	    Image img1 = Toolkit.getDefaultToolkit().getImage("/Resources/snake.png");
	    
	    int width = img1.getWidth(this);
	    int height = img1.getHeight(this);

	    double scale = 0.5;
	    double w = scale * width;
	    double h = scale * height;
	    // explicitly specify width (w) and height (h)
	    g.drawImage(img1, 25, 40, (int) w, (int) h, this);
	    g.setColor(palette.white());
	    g.setFont(new Font("Courier", Font.BOLD, 20));
	    g.drawString("For",40, 220);
	    
	    ///////////////////////////////////
	    
	    g.drawRoundRect(300, 10, 160, 240, 10, 10);
	    g.setColor(palette.purple());
	    g.fillRoundRect(300, 10, 160, 240, 10, 10);
	 
	    Image img2 = Toolkit.getDefaultToolkit().getImage("/Resources/panda.png");
	   
	    
	    width = img2.getWidth(this);
	    height = img2.getHeight(this);
	    
	    scale = 0.47;
	    w = scale * width;
	    h = scale * height;
	    // explicitly specify width (w) and height (h)
	    g.drawImage(img2, 308, 45, (int) w, (int) h, this);
	    g.setColor(palette.white());
	    g.drawString("If",300+70, 220);
 
	    ////////////////////////////////////////////////////
	    
	    g.drawRoundRect(600, 10, 160, 240, 10, 10);
	    g.setColor(palette.red());
	    g.fillRoundRect(600, 10, 160, 240, 10, 10);
	    
	    Image img3 = Toolkit.getDefaultToolkit().getImage("/Resources/fishPink.png");
	   
	    width = img3.getWidth(this);
	    height = img3.getHeight(this);
	    
	    scale = 1.2;
	    w = scale * width;
	    h = scale * height;
	    // explicitly specify width (w) and height (h)
	    g.drawImage(img3, 605, 25, (int) w, (int) h, this);
	    g.setColor(palette.white());
	    g.drawString("Move",(605+50), 220);

	}
	
	public Dimension getPreferredSize() {
	    return new Dimension(800, 400); // appropriate constants
	  }
	
}