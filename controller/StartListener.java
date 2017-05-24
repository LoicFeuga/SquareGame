package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.Model;

public class StartListener implements ActionListener{

	private Model m;
	private JComboBox<String> niveauJ1;
	private JComboBox<String> niveauJ2;
	private JComboBox<Integer> x;
	private JComboBox<Integer> y;

	public StartListener(Model m,JComboBox<String> niveauJ1, JComboBox<String> niveauJ2, JComboBox<Integer> x, JComboBox<Integer> y) {
		this.m = m;
		this.niveauJ1 = niveauJ1;
		this.niveauJ2 = niveauJ2;
		this.x = x;
		this.y = y;


	}

	@Override
	public void actionPerformed(ActionEvent e) {

		m.setNiveauJ1(convertLevelInInt((String) niveauJ1.getSelectedItem()));
		m.setNiveauJ2(convertLevelInInt((String) niveauJ2.getSelectedItem()));
		m.setX((int) this.x.getSelectedItem());
		m.setY((int) this.y.getSelectedItem());
		m.initGrid(m.getX(), m.getY());
	}

	private int convertLevelInInt(String level){
		int ret= 0;

		switch(level){
		case "Easy":
			ret = 0;
			break;
		case "Medium":
			ret = 1;
			break;
		case "Hard":
			ret = 2;
			break;
		case "Human":
			ret = 3;
			break;

		}

		return ret;
	}

}
