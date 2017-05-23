package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import model.Model;
import view.game.Square;

public class PanelListener implements MouseListener{

	
	Square square;
	private int position;
	Model model;
	int x; 
	int y;
	/**
	 * 
	 * @param j 
	 * @param i 
	 * @param pan
	 * @param r
	 * @param c
	 * @param grid
	 * @param i = NESO 1234
	 */
	public PanelListener(Square square, Model model, int position, int i, int j) {
		this.square = square;
		this.model = model;
		this.x = i;
		this.y = j;
		this.position = position;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		int xM = getXInModel();
		int yM = getYInModel();

		this.square.playerTake(model.playerTurn, position, false);
		this.model.playerTurn(xM, yM);
		
	}
	
	private int getXInModel(){
		int ret = 0;
		switch(this.position){
		case 1	:
			ret = this.x + this.x;
			break;
		case 2:
			ret = this.x + this.x + 1;
			break;
		case 3:
			ret = this.x + this.x + 2;
			break;
		case 4: 
			ret = this.x + this.x +1;
		}
		return ret;
	}
	
	private int getYInModel(){
		int ret = 0;
		
		switch(this.position){
		case 1:
			ret = this.y;
			break;			
		case 2:
			ret = this.y +1;
			break;
		case 3:
			ret = this.y;
			break;
		case 4 :
			ret = this.y;
			break;
		}
		
		return ret;
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
