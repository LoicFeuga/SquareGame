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

		this.add(new JPanel(), BorderLayout.SOUTH);
		this.add(new JPanel(), BorderLayout.EAST);
		this.add(new JPanel(), BorderLayout.WEST);
	}
	
	public GGrid getGrid(){
		return panCenter;
	}

}
