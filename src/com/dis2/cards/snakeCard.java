
import java.awt.Toolkit;

public class snakeCard extends cardWidget{
	
	private int Ntimes;

	public snakeCard(int x, int y, int w, int h, int arcW, int arcH, double s, int fs){
		super(x,y,w,h,arcW,arcH);
		this.setFillColor(palette.green());
		this.setImg(Toolkit.getDefaultToolkit().getImage("/Resources/snake.png"));
		this.setImageScale(s);
		this.setFontColor(palette.white());
		this.setFontSize(fs);
		this.setTypeFace(1);
		this.setLabel("For");
		this.setText("The Snake card helps your character repeat an instruction N times");
	}

	public int getNtimes() {
		return Ntimes;
	}

	public void setNtimes(int ntimes) {
		Ntimes = ntimes;
	}
	
	public void loop(){
		for(int n= Ntimes; n>0; n--){
			//perform character instruction
		}
	}

}
