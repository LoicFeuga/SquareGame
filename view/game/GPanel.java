package view.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Model;

public class GPanel extends JPanel{
	
	private BorderLayout layout;
	private JComboBox<String> uiDifficultiesBtn;
	private final String[] difficulties = {"Easy","Medium","Hard"};
	private JButton uiStartBtn;
	private GGrid panCenter;
	GStatPlayer player1 ;
	GStatPlayer player2;
	
	/**
	 * Créé le panel entier du jeu avec row et colum
	 * @param r le nombre de ligne
	 * @param c le nombre de colonne
	 */
	public GPanel(int r, int c,Model model){
		super();
		
		layout = new BorderLayout();

		setLayout(layout);
		
		uiDifficultiesBtn = new JComboBox<String>(difficulties);
		uiDifficultiesBtn.setSelectedItem(0);
		uiDifficultiesBtn.setPreferredSize(new Dimension(100, 30));
		
		JLabel diff = new JLabel("Difficultés");
		uiStartBtn = new JButton("Start");
		
		//PANEL TOP
		JPanel panTop = new JPanel();
		
		
		panTop.setBackground(Color.white);		
		
		this.add(panTop,BorderLayout.NORTH);
		//END PANEL TOP
		
		//PANEL CENTER
		panCenter = new GGrid(r, c,model);
		
		this.add(panCenter,BorderLayout.CENTER);
		
		
		//END PANEL CENTER
		
		//PANEL LEFT
		player1 = new GStatPlayer(model.getNameJ1());
		add(player1,BorderLayout.WEST);

		//END PANEL LEFT
		
		//PANEL RIGHT

		player2 = new GStatPlayer(model.getNameJ2());
		add(player2,BorderLayout.EAST);
		//END PANEL RIGHT

		this.add(new JPanel(), BorderLayout.SOUTH);
	}
	
	void updateU(){
		player1.repaint();
		player2.repaint();
	}
	public GGrid getGrid(){
		return panCenter;
	}

	public GStatPlayer getPlayer1() {
		return player1;
	}

	public GStatPlayer getPlayer2() {
		return player2;
	}

}
