package controller;

import ia.IA;
import ia.RandomIA;
import model.Model;
import view.game.GFrame;
import view.start.GStart;

public class Game {

	private GFrame frame;
	private GStart start;
	private Model model;
	private RandomIA ia;
	private IA player1;
	private IA player2;

	public Game() {

		model = new Model(this);
		start = new GStart(model);

	}

	public static void main(String[] args) {
		new Game();
	}

	public void startGame() {
		start.dispose();
		frame = new GFrame(model.getX(), model.getY(), model);

		setIA1();
		setIA2();

		ia = new RandomIA(frame.getPanel().getGrid(), model);
		RandomIA ia2 = new RandomIA(frame.getPanel().getGrid(), model);
		// model.addObserver(ia);
		// model.addObserver(ia2);
		model.addObserver(frame.getPanel().getGrid());
	}

	private void setIA1() {
		switch(model.getNiveauJ1()){
		//Easy
		case 0:
			break;
		//Medium
		case 1:
			break;
		//Hard
		case 2:
			break;
		//Humain
		case 3:
			break;
		}
	}

	private void setIA2() {

		switch(model.getNiveauJ2()){
		//Easy
		case 0:
			break;
		//Medium
		case 1:
			break;
		//Hard
		case 2:
			break;

		}
	}
}
