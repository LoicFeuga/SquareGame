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
		this.playerNumber = number;

	}

	public int alea(int Min, int Max) {
		return Min + (int) (Math.random() * ((Max - Min) + 1));
	}

	@Override
	public void update(Observable o, Object arg) {
		HashMap hm = (HashMap) arg;

		if (hm.containsKey("turn")) {
			if ((int) hm.get("turn") == this.playerNumber) {
				int x;
				int y, position;
				Square[][] squares = grid.getGrid();

				do {
					// 1,2,3,4 = N,E,S,O
					position = alea(1, 4);

					x = alea(0, squares.length - 1);
					y = alea(0, squares[x].length - 1);
				} while (!squares[x][y].positionFree(position));

				think();

				squares[x][y].playerTake(model.playerTurn, position, false);
				model.endTurn();

			}
		}

	}

	/**
	 * Permet de simuler un temps de réflexion
	 */
	private void think() {

		try {
			Thread.sleep(speedThink);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
