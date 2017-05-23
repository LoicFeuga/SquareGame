package controller;

import ia.RandomIA;
import model.Model;
import view.game.GFrame;
import view.start.GStart;

public class Game {
	
	private GFrame frame;
	private GStart start;
	private Model model;
	private RandomIA ia;
	
	public Game(){
		
		model = new Model(this);
		start = new GStart(model);
		
	}
	
	public static void main(String[] args) {
		new Game();
	}

	public void startGame() {
		start.dispose();
		frame = new GFrame(model.getX(),model.getY(),model);

		ia = new RandomIA(frame.getPanel().getGrid(),model);
		RandomIA ia2 = new RandomIA(frame.getPanel().getGrid(),model);
		//model.addObserver(ia);
		//model.addObserver(ia2);
		model.addObserver(frame.getPanel().getGrid());
	}
}
