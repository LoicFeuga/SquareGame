package view.game;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GStatPlayer extends JPanel implements Observer{
	
	private String namePlayer;
	private int lineTook;
	private int squareTook;
	private int gameWon;
	private int gameLoose;
	
	
	public GStatPlayer(String name){
		super();
		this.namePlayer = name;
		this.lineTook = 0;
		this.squareTook = 0;
		this.gameLoose = 0;
		this.gameWon = 0;
		
		add(new JLabel(namePlayer));
	}


	@Override
	public void update(Observable o, Object arg) {
		//Quand le model enverra les stats

		this.paintImmediately(0, 0, this.getWidth(), this.getHeight());
		this.updateUI();
	}
}
