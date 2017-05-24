package view.game;

import javax.swing.JFrame;

import model.Model;

public class GFrame extends JFrame{
	
	private GPanel panel;
	
	public GFrame(int r, int c, Model model){
		super();
		
		setTitle("Square Game");
		setSize(500,500);
		setLocationRelativeTo(null);
		
		this.panel = new GPanel(r, c, model);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		this.setContentPane(this.panel);

		setVisible(true);


		
		
	}

	public GPanel getPanel(){
		return panel;
	}
}
