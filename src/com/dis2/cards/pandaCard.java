import java.awt.Toolkit;

public class pandaCard extends cardWidget{
	
	private boolean flag;
	
	public pandaCard(int x, int y, int w, int h, int arcW, int arcH, double s, int fs){
		super(x,y,w,h,arcW,arcH);
		this.setFillColor(palette.purple());
		this.setImg(Toolkit.getDefaultToolkit().getImage("/Resources/panda.png"));
		this.setImageScale(s);
		this.setFontColor(palette.white());
		this.setFontSize(fs);
		this.setTypeFace(1);
		this.setLabel("If");
		this.setText("The Panda card helps your character decide between options");
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public void decide(){
		
		if(flag){
			//Perform task
		}
	}

}
