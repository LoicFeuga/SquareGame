package view.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import controller.PanelListener;
import model.Model;

public class Square extends JPanel{

	Color colorPlayer1 = Color.BLUE;
	Color colorPlayer2 = Color.RED;
	Color colorDefault = Color.WHITE;
	Color colorEmpty = Color.GRAY;

	JPanel top;
	JPanel bot;
	JPanel left;
	JPanel right;
	JPanel center;

	Square squareTop;
	Square squareLeft;
	Square squareRight;
	Square squareBot;
	
	boolean linkTop = false;
	boolean linkBot = false;
	boolean linkLeft = false;
	boolean linkRight = false;

	int leftTook = 0;
	int rightTook = 0;
	int botTook = 0;
	int topTook = 0;
	
	Model model;
	

	public Square(Model model, int i, int j){
		super();

		this.model = model;
		setLayout(new BorderLayout());
		top = new JPanel();
		left = new JPanel();
		right = new JPanel();
		bot = new JPanel();
		center = new JPanel();

		top.setBackground(Color.white);
		left.setBackground(Color.white);
		right.setBackground(Color.white);
		bot.setBackground(Color.white);
		center.setBackground(Color.gray);
		

		top.addMouseListener((MouseListener) new PanelListener(this,model,1,i,j));
		bot.addMouseListener((MouseListener) new PanelListener(this,model,3,i,j));
		right.addMouseListener((MouseListener) new PanelListener(this,model,2,i,j));
		left.addMouseListener((MouseListener) new PanelListener(this,model,4,i,j));

		add(top,BorderLayout.NORTH);
		add(center,BorderLayout.CENTER);
		add(bot,BorderLayout.SOUTH);
		add(left,BorderLayout.WEST);
		add(right,BorderLayout.EAST);		
	}

	public void linkRight(Square square){
		linkRight = true;
		squareRight = square;
	}
	
	public void linkLeft(Square square){
		linkLeft = true;
		squareLeft = square;
	}
	public void linkTop(Square square){
		linkTop = true;
		squareTop = square;
	}
	public void linkBot(Square square){
		linkBot = true;
		squareBot = square;
	}
	/**
	 * 
	 * @param player 1 ou 2 
	 * @param position 1234 NESO
	 * @param cascase toujours false, le true est réserver pour dans la méthode
	 */
	public void playerTake(int player,int position,boolean cascade){
		Color colorApply = player == 1 ? colorPlayer1 : colorPlayer2;

		switch(position){
		case 1:
			top.setBackground(colorApply);
			topTook = player;
			if(!cascade && linkTop){
				squareTop.playerTake(player, 3, true);
			}
			top.revalidate();
			
			break;
		case 2:	
			right.setBackground(colorApply);
			rightTook = player;
			if(!cascade && linkRight){
				squareRight.playerTake(player, 4, true);
			}
			right.revalidate();
			
			break;
		case 3:
			bot.setBackground(colorApply);
			botTook = player;
			if(!cascade && linkBot){
				squareBot.playerTake(player, 1, true);
			}
			break;
		case 4:
			left.setBackground(colorApply);
			leftTook = player;
			if(!cascade && linkLeft){
				squareLeft.playerTake(player, 2, true);
			}
			break;
		default:
			break;
		}
		
		if(leftTook != 0 && topTook != 0 && botTook != 0 && rightTook != 0){
			center.setBackground(colorApply);
			top.setBackground(colorApply);
			bot.setBackground(colorApply);
			left.setBackground(colorApply);
			right.setBackground(colorApply);
			
		}
		
		//if(!cascade){
			model.turn();
		//}
		

	}

	public JPanel getTop() {
		return top;
	}

	public JPanel getBot() {
		return bot;
	}

	public JPanel getLeft() {
		return left;
	}

	public JPanel getRight() {
		return right;
	}

	public JPanel getCenter() {
		return center;
	}

	public Square getSquareTop() {
		return squareTop;
	}

	public Square getSquareLeft() {
		return squareLeft;
	}

	public Square getSquareRight() {
		return squareRight;
	}

	public Square getSquareBot() {
		return squareBot;
	}

	public void setTop(JPanel top) {
		this.top = top;
	}

	public void setBot(JPanel bot) {
		this.bot = bot;
	}

	public void setLeft(JPanel left) {
		this.left = left;
	}

	public void setRight(JPanel right) {
		this.right = right;
	}

	public void setCenter(JPanel center) {
		this.center = center;
	}

	public void setSquareTop(Square squareTop) {
		this.squareTop = squareTop;
	}

	public void setSquareLeft(Square squareLeft) {
		this.squareLeft = squareLeft;
	}

	public void setSquareRight(Square squareRight) {
		this.squareRight = squareRight;
	}

	public void setSquareBot(Square squareBot) {
		this.squareBot = squareBot;
	}

	public int getLeftValue() {
		return leftTook;
	}

	public int getRightValue() {
		return rightTook;
	}

	public int getBotValue() {
		return botTook;
	}

	public int getTopValue() {
		return topTook;
	}

}
