package ia;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import model.Model;
import view.game.GGrid;
import view.game.Square;

public class RandomIA implements Observer {
	GGrid grid;
	Model model;
	
	public RandomIA(GGrid gGrid,Model model){
		this.grid = gGrid;
		this.model = model;
	}
	
	public int alea(int Min, int Max){
		return Min + (int)(Math.random() * ((Max - Min) + 1));
	}
	
	public int[] play(){
		int [] a = {alea(0,model.getX() - 1),alea(0,model.getY()- 1)};
		return a;
	}

	@Override
	public void update(Observable o, Object arg) {
		HashMap hm = (HashMap) arg;
		
		if(hm.containsKey("ia")){
			Square[][] b = grid.getGrid();
			int x = play()[0];
			int y = play()[1];
			int position = alea(1,4);
			b[x][y].playerTake(2, position, false);
		}
		
	}
}
