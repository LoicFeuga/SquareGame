package model;

import java.util.HashMap;
import java.util.Observable;

import controller.Game;
import view.game.GGrid;

public class Model extends Observable{
	
	Grid grid;
	GGrid ggrid;
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
	
	public int getXInModel(int x,int position){
		int ret = 0;
		switch(position){
		case 1	:
			ret = x + x;
			break;
		case 2:
			ret = x + x + 1;
			break;
		case 3:
			ret = x +  + 2;
			break;
		case 4: 
			ret = x + x +1;
		}
		return ret;
	}
	
	public int getYInModel(int y, int position){
		int ret = 0;
		
		switch(position){
		case 1:
			ret = y;
			break;			
		case 2:
			ret = y +1;
			break;
		case 3:
			ret = y;
			break;
		case 4 :
			ret = y;
			break;
		}
		
		return ret;
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
	
	public int getTurn(){
		return playerTurn;
	}
	public void playerTurn(int x, int y){
		grid.setXY(x, y, playerTurn);
		playerTurn = playerTurn == 1 ? 2 : 1;
		//grid.print();

		if(this.ggrid.isCompleted()){
		try {
			Thread.sleep(500);
		HashMap hm = new HashMap();

		hm.put("turn", playerTurn);
		setChanged();
		notifyObservers(hm);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	public int getXMax(){
		return grid.getXMax();
	}
	
	public int getYMax(){
		return grid.getYMax();
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

	public void turn() {

		HashMap hm = new HashMap();

		hm.put("turn", playerTurn);
		setChanged();
		notifyObservers(hm);
	}

	public void setGGrid(GGrid grid2) {
		// TODO Auto-generated method stub
		this.ggrid = grid2;
	}

}
