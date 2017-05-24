package view.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Model;

public class GGrid extends JPanel implements Observer {

	Square[][] grid;
	int[][] modelGrid;
	
	public GGrid(int r, int c, Model model) {
		super();
		grid = new Square[new Integer(r)][c];
		GridLayout gl = new GridLayout(new Integer(r), c);
		this.setLayout(gl);
		for (int i = 0; i < new Integer(r); i++) {
			for (int j = 0; j < c; j++) {

				Square square = new Square(model,i,j);
				//right.setPreferredSize(new Dimension(5, 10));
				grid[i][j] = square;
				this.add(grid[i][j]);
				grid[i][j].repaint();
				square.updateUI();
				grid[i][j].updateUI();
				grid[i][j].paintImmediately(0, 0, grid[i][j].getWidth(), grid[i][j].getHeight());
				
				

			}
		}

		applyLink();
		this.paintImmediately(0, 0, this.getWidth(), this.getHeight());
	}

	
	private void applyLink() {
		for(int i = 0 ; i < grid.length; i++){
			for(int j = 0; j < grid[i].length;j++){
				if(i > 0){
					grid[i][j].linkTop(grid[i-1][j]);
				}
				if(j > 0){
					grid[i][j].linkLeft(grid[i][j-1]);
				}
				if(i < grid.length  -1){
					grid[i][j].linkBot(grid[i+1][j]);
				}
				if(j < grid[i].length -1 ){
					grid[i][j].linkRight(grid[i][j+1]);
				}
			}
		}
		
	}


	@Override
	public void update(Observable o, Object arg) {
		HashMap hm = (HashMap) arg;
		
		if(hm.containsKey("init")){
			modelGrid = (int[][]) hm.get("init");
			//applyGridToPanel();
		}
		
		
	}
	
	
	/**
	 * Permet d'apply la grid qui vient du model à la Panel
	 */
	private void applyGridToPanel(){
		
		for(int i = 0; i < grid.length;i++){
			for(int j = 0; j < grid[i].length; j++){
				
				if(i == 0){

					JPanel pan = new JPanel();
					
					if(modelGrid[i][j] == 1){
						pan.setBackground(Color.BLUE);
					}else if(modelGrid[i][j] == 2){
						pan.setBackground(Color.RED);
					}else{
						pan.setBackground(Color.WHITE);

					}

					grid[i][j].add(pan,BorderLayout.NORTH);
					grid[i][j].revalidate();
				}
				
			}
		}
	}


	public Square[][] getGrid() {
		return grid;
	}


	public boolean isCompleted() {
		for(int i = 0; i < grid.length;i++){
			for(int j =0; j < grid[i].length;j++){
				if(grid[i][j].isComplete() == false){
					return false;
				}
			}
		}
		return true;
	}
}
