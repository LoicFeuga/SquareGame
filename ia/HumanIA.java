package ia;

import java.util.HashMap;
import java.util.Observable;

public class HumanIA extends IA  {

	public HumanIA(int number) {
		super(number);

	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		super.update(o, arg);
		
		HashMap hm = (HashMap) arg;

		if(hm.containsKey("turn")){
			if((int)hm.get("turn") == this.playerNumber){
				
			}
		}

		
	}
}
