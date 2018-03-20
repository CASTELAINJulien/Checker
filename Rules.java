package checker.panels;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rules extends JFrame {
	
	private static final Font TITLE_FONT = new Font(Font.SANS_SERIF, Font.BOLD,30);

	public Rules() {
		super();
		initLayout();
		//initAction();
	}
	
	
	private void initLayout() {
		
		setTitle("Rules");
		setSize(1024,768);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(buildContentPane());
	
	}
	
	private JPanel buildContentPane() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("<html><center>RULES <br /> <br />First step: <br /> Enter your player's name. If you're a player, then select human, else choose AI to play aigainst the game and then select two powers.<br />" 
				+ " This powers can help you to win. <br /> Second step: <br /> Choose your piece's color. Click on one piece to move it. You can move it on all empty emplacement around the selectionned piece.<br />"
				+ " You can also jump over one of your piece or one of your oponnent piece. The aim of the game consists to put all your piece in the emplacements of the departure zone opposite of yours. <br /><br />" 
				+ " Have Fun ! :)</center></html>");
		panel.add(label);
		
		return panel;
	}
	
	/*public void initAction() {
		previousButton.addActionListener(new PreviousAction());
	}*/
	
	private class PreviousAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
		PanelsContainer.getInstance().getCardLayout().first(PanelsContainer.getInstance());
		}
	}
}