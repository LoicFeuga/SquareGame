package ia;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import model.Model;
import view.game.GGrid;
import view.game.Square;

public class RandomIA extends IA {
	GGrid grid;

	Model model;

	public RandomIA(GGrid gGrid, Model model, int number) {
		super(number);
		this.grid = gGrid;
		this.model = model;
		this.number = number;

	}

	public int alea(int Min, int Max) {
		return Min + (int) (Math.random() * ((Max - Min) + 1));
	}

	@Override
	public void update(Observable o, Object arg) {

		//

		HashMap hm = (HashMap) arg;

		if (hm.containsKey("turn")) {
			if ((int) hm.get("turn") == this.number) {
				int x; int y, position;
				Square[][] b = grid.getGrid();
				do{
				 position = alea(1, 4);

				 x = alea(0, b.length - 1);
				y = alea(0, b[x].length - 1);
				}while(b[x][y].isComplete());
				b[x][y].playerTake(model.playerTurn, position, false);
				model.playerTurn(model.getXInModel(x, position), model.getYInModel(y, position));

			}
		}

	}
}
