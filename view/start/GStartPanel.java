package view.start;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.StartListener;
import model.Model;

public class GStartPanel extends JPanel {
	
	int niveauJ1;
	int niveauJ2;

	private final String[] difficulties = {"Easy","Medium","Hard","Human"};
	private final String[] difficultiesJ2 = {"Easy","Medium","Hard"};
	private JComboBox<String> uiDifficultiesComboJ1;
	private JComboBox<String> uiDifficultiesComboJ2;

	private final Integer[] xy = {2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	private JComboBox<Integer> uiXCombo;
	private JComboBox<Integer> uiYCombo;
	private JButton uiStartBtn;
	
	public GStartPanel(Model m){
		super();
		
		
		setLayout(new BorderLayout());
		
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(5,5));
		pan.add(new JLabel("Joueur 1 : "));
		
		uiDifficultiesComboJ1 = new JComboBox<String>(difficulties);
		uiDifficultiesComboJ1.setSelectedItem(0);
		uiDifficultiesComboJ1.setPreferredSize(new Dimension(100, 30));

		uiDifficultiesComboJ2 = new JComboBox<String>(difficultiesJ2);
		uiDifficultiesComboJ2.setSelectedItem(0);
		uiDifficultiesComboJ2.setPreferredSize(new Dimension(100, 30));
		uiXCombo = new JComboBox<Integer>(xy);
		uiXCombo.setSelectedItem(0);
		uiXCombo.setPreferredSize(new Dimension(100, 30));
		uiYCombo = new JComboBox<Integer>(xy);
		uiYCombo.setSelectedItem(0);
		uiYCombo.setPreferredSize(new Dimension(100, 30));
		
		pan.add(uiDifficultiesComboJ1);
		
		pan.add(new JLabel("Joueur 2 :"));
		
		pan.add(uiDifficultiesComboJ2);

		pan.add(new JLabel("x:"));
		
		pan.add(uiXCombo);
		
		
		pan.add(new JLabel("y:"));
		pan.add(uiYCombo);
		
		uiStartBtn = new JButton("Start");
		pan.add(uiStartBtn);
		
		StartListener btnListener = new StartListener(m,uiDifficultiesComboJ1,uiDifficultiesComboJ2,uiXCombo,uiYCombo);
		
		uiStartBtn.addActionListener(btnListener);
		
		this.add(pan,BorderLayout.CENTER);
	}

}
