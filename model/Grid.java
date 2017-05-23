package model;

public class Grid {
	
	//model
	private int[][] grid;
	
	/**
	 * Initialisation de la matrice model du jeu en y passant le nombre de carré de l'on souhaite
	 * 	la décomposition en ligne se fera à l'intérieur de l'initialisation
	 * 
	 * @param r nombre de carré en ligne 
	 * @param c nombre de carré en colonne
	 */
	public Grid(int r, int c){
		r =( r *2 ) +1;
		c = c +1;
		//une barre verticale en plus = une colonne en plus 
		grid = new int[r][c];
		
		
		 // Boucle permettant d'initialiser le tableau grid
		for(int i = 0; i < r; i++){
			
			for(int j = 0; j < c; j++){
				
				//grid[i][j] = 0;
				
				//Je c'est le cas des barres verticale et que c'est le dernière boucle de j
				//Je rajoute un 0, car il y a toujours une barre vertical en plus que l'horizontale
				if( j >= ( c - 1) && i % 2 == 0){
					grid[i][j] = -1;
				}else{
					grid[i][j] = 0;
				}
			}
			
			
		}
		
		
		
	}
	
	public void print(){
		for(int i = 0; i < grid.length;i++){
			for(int j  = 0 ; j < grid[i].length;j++){
				System.out.print(grid[i][j]+" ");
			
			}
			System.out.println("");
		}

		System.out.println("");
	}
	
	public void setXY(int x, int y, int value){
		grid[x][y] = value;
	}
	public int[][] getGrid(){
		return grid;
	}
}
