package ia;

import java.util.Observable;
import java.util.Observer;

public class IA implements Observer {

	protected int playerNumber = 0;
	protected int speedThink = 10;
	
	public IA(int number){
		this.playerNumber = number;
	}
	
	@Override
	public void update(Observable o, Object arg) {


	}
	


}
