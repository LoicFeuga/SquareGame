package model;

import java.util.HashMap;
import java.util.Observable;

import controller.Game;
import view.game.GGrid;

public class Model extends Observable {

	/**
	 * Ref vers la grille des Squares
	 */
	GGrid grid;
	/**
	 * Niveau du joueur 1
	 * Ex : 1,2,3,4
	 */
	int niveauJ1;
	/**
	 * Niveau du joueur 2
	 * Ex : 1,2,3,4
	 */
	int niveauJ2;
	/**
	 * Nombre de carré en ligne
	 */
	int x;
	/**
	 * Nombre  carré en colonne
	 */
	int y;
	/**
	 * Réf game
	 */
	Game game;
	// 1 = j1
	// 2 = j2
	public int playerTurn = 1;

	public Model(Game game) {
		this.game = game;
	}

	public void initGrid(int x, int y) {
		this.x = x;
		this.y = y;

		setChanged();
		notifyObservers();
		game.startGame();

	}

	public int getTurn() {
		return playerTurn;
	}

	public void endTurn() {
		playerTurn = playerTurn == 1 ? 2 : 1;

		if (!this.grid.isCompleted()) {

			HashMap hm = new HashMap();
			hm.put("turn", playerTurn);
			setChanged();
			notifyObservers(hm);
		}else{
			System.out.println("end");
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

	/*
	 * Permet de lancer le premier tour en envoyant un event aux observer
	 */
	public void firstTurn() {
		printAllPanel();
		HashMap hm = new HashMap();
		hm.put("turn", playerTurn);
		setChanged();
		notifyObservers(hm);
	}

	private void printAllPanel() {
		for (int i = 0; i < grid.getGrid().length; i++) {
			for (int j = 0; j < grid.getGrid()[i].length; j++) {
				grid.getGrid()[i][j].updateU();
			}
		}
	}

	public void setGrid(GGrid grid2) {
		// TODO Auto-generated method stub
		this.grid = grid2;
	}

}
