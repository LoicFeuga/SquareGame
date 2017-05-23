package model;

import java.util.HashMap;
import java.util.Observable;

import controller.Game;

public class Model extends Observable{
	
	Grid grid;
	int niveauJ1;

	int niveauJ2;
	int x;
	int y;
	Game game;
	//1 = j1
	//2 = j2
	public int playerTurn = 1;
	
	
	public Model(Game game){
		this.game = game;
	}
	
	public void initGrid(int x, int y){
		this.x = x;
		this.y =y;
		this.grid = new Grid(x, y);
		game.startGame();
		HashMap hm = new HashMap<String,Object>();
		hm.put("init", grid.getGrid());
		setChanged();
		
		notifyObservers(hm);
	}
	
	public void playerTurn(int x, int y){
		grid.setXY(x, y, playerTurn);
		playerTurn = playerTurn == 1 ? 2 : 1;
		grid.print();

		
		try {
			Thread.sleep(1000);

			setChanged();
			HashMap m = new HashMap();
			m.put("ia", true);
			notifyObservers(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public int getNiveauJ1() {
		return niveauJ1;
	}

	public int getNiveauJ2() {
		return niveauJ2;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setNiveauJ1(int niveauJ1) {
		this.niveauJ1 = niveauJ1;
	}

	public void setNiveauJ2(int niveauJ2) {
		this.niveauJ2 = niveauJ2;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

}
