package guiPackage;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import customEventsPackage.CustomEvent;
import application.StateMachine;
import checker.CheckerBoard;

public class MainScreenGUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7064806528132220998L;
	private static JPanel mainScreenPanel;
	private static CheckerBoard gameScreenPanel;
	private static Box verticalBox;
	private static JLabel lblChecker;
	private static JButton launchGameButton;
	private static JButton optionsButton;
	private static JButton leaveButton;
	private static List<CustomEvent> listeners = new ArrayList<CustomEvent>();
	
	private MainScreenGUI () {
		mainScreenPanel = new JPanel();
	}
	
	public static JPanel getInstance(){
		if( mainScreenPanel == null ){
			new MainScreenGUI();
			System.out.println("MainScreen Get Instance");
		}
		
		return mainScreenPanel;   
	}   
	
	public static void addListener(CustomEvent toAdd) {
		listeners.add(toAdd);
	}
	    
	public static void initiateStateChange(JFrame frame) {
	    StateMachine.getInstance();
	    for (CustomEvent customEventsList : listeners)
	    	customEventsList.stateChanged(frame);
	}
	
	public static void mainScreenDisable(Boolean changeState) {
		if ( changeState == true ) {
			mainScreenPanel.setVisible(false);
			launchGameButton.setVisible(false);
			optionsButton.setVisible(false);
			leaveButton.setVisible(false);
			verticalBox.setVisible(false);
			lblChecker.setVisible(false);
		} else {
			mainScreenPanel.setVisible(true);
			launchGameButton.setVisible(true);
			optionsButton.setVisible(true);
			leaveButton.setVisible(true);
			verticalBox.setVisible(true);
			lblChecker.setVisible(true);
		}
	}
	
	// TODO - Would be interesting to actually create an Interface for each JPanel
	// TODO - Wonder if it is better to actually put all the components as this class attribute ? Might be easier to access these same components ?
	public static void drawPanelElements(final JFrame mainWindowFrame ) {
		verticalBox = Box.createVerticalBox();
		mainScreenPanel.add(verticalBox);
		
		lblChecker = new JLabel("Checker");
		verticalBox.add(lblChecker);
		lblChecker.setFont(new Font("Tahoma", Font.PLAIN, 72));
		
		launchGameButton = new JButton("Lancer une partie");
		verticalBox.add(launchGameButton);
		
		optionsButton = new JButton("Options");
		verticalBox.add(optionsButton);
		
		leaveButton = new JButton("Quitter");
		verticalBox.add(leaveButton);
		
		
		
		launchGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameScreenPanel = new CheckerBoard("Checker", mainWindowFrame);
				addListener(gameScreenPanel);
				mainScreenDisable(true);
				gameScreenPanel.gameScreenDisable(false);
				initiateStateChange(mainWindowFrame);  // "Hello!" and "Hello there!"
				System.out.println(StateMachine.getInstance().toString());
			}
		});
		mainScreenPanel.setVisible(true);
	}
}