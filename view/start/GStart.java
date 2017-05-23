package view.start;

import javax.swing.JFrame;

import model.Model;

public class GStart extends JFrame{
	private GStartPanel panel;
	public GStart(Model m){
		super();
				
		setTitle("Square Game");
		setSize(500,500);
		setLocationRelativeTo(null);
		
		this.panel = new GStartPanel(m);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		this.setContentPane(this.panel);
		
		setVisible(true);
		
	}
	

}
