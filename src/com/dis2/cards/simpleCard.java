
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

    public simpleCard(cardWidget cw){
    	this.cw = cw;
    }
    
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
		
    	g.drawRoundRect(cw.getX(), cw.getY(), cw.getRectWidth(), cw.getRectHeight(), cw.getArcWidth(), cw.getArcHeight());
	    g.setColor(cw.getFillColor());
	    g.fillRoundRect(cw.getX(), cw.getY(), cw.getRectWidth(), cw.getRectHeight(), cw.getArcWidth(), cw.getArcHeight());
	    
	    double w = cw.getImageScale() * cw.getImageWidth();
	    double h = cw.getImageScale() * cw.getImageHeight();
	    // explicitly specify width (w) and height (h)
	    g.drawImage(cw.getImg(), cw.getX()+((int)w/18), cw.getY()+25, (int) w, (int) h, this);
	    g.setColor(cw.getFontColor());
	    g.setFont(new Font("Courier", Font.BOLD, cw.getFontSize()));
	    g.drawString(cw.getLabel(),cw.getX()+((int)w/3), cw.getY()+210);   
	    
	}

	
	public Dimension getPreferredSize() {
	    return new Dimension(180, 280); // appropriate constants
	  }
	
}