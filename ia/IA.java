package ia;

import java.util.Observable;
import java.util.Observer;

public class IA implements Observer {

	protected int number = 0;
	
	public IA(int number){
		this.number = number;
	}
	
	@Override
	public void update(Observable o, Object arg) {


	}
	


}
