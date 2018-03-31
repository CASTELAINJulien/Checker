package checker.panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import checker.data.ClassFactory;

public class Rules extends JPanel {
	
	private Box verticalBox;
	private JLabel rulesLabel;
	private JButton previousButton;
	
	private static final Font TITLE_FONT = new Font(Font.SANS_SERIF, Font.BOLD,30);

	public Rules() {
		super();
		initLayout();
		initAction();
	}
	
	
	private void initLayout() {
		
		verticalBox = Box.createVerticalBox();
		add(verticalBox);
		
		rulesLabel = new JLabel("<html><center>RULES <br /> <br />First step: <br /> Enter your player's name. If you're a player, then select human, else choose AI to play against the game and then select two powers.<br />" 
			+ " These powers can help you to win. <br /> Second step: <br /> Choose your piece's color. Click on one piece to move it. You can move it on all empty location around the selected piece.<br />"
			+ " You can also jump over one of your piece or one of your oponnent piece.<br/>"
			+ "The aim of the game consists to put all your piece in the location of the departure zone opposite of yours. <br /><br />" 
			+ " Have Fun ! :)</center></html>");
		rulesLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		verticalBox.add(rulesLabel);
		
		previousButton = (JButton) ClassFactory.createTextContainingComponent("JButton","previous");
		verticalBox.add(previousButton);
		
	}
	
	public void initAction() {
		previousButton.addActionListener(new PreviousAction());
	}
	
	private class PreviousAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			PanelsContainer.getInstance().getCardLayout().first(PanelsContainer.getInstance());
			
		}
	}
}

