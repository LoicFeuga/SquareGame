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
		if(square.positionFree(position)){

			this.square.playerTake(model.playerTurn, position, false);
			this.model.endTurn(); 
		}
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
