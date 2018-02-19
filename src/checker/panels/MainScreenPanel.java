package checker.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import checker.data.ClassFactory;
import checker.data.ClipPlayer;
import checker.gui.GTParameters;
import application.StateMachine;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MainScreenPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7064806528132220998L;
	private Box verticalBox;
	private JLabel lblChecker;
	private JButton launchGameButton;
	private JButton optionsButton;
	private JButton leaveButton;
	private List<CustomEvent> listeners = new ArrayList<CustomEvent>();
	private ClipPlayer musicPlayer;
	
	public MainScreenPanel () throws IOException {
		int windowWidth = GTParameters.WINDOW_WIDTH;
		if (windowWidth < 800 || (windowWidth % 800 != 0)) {
			throw new IllegalArgumentException("Non supported window size : " + windowWidth);
		}

		setPreferredSize(new Dimension(windowWidth, GTParameters.WINDOW_HEIGHT));
		setBackground(Color.WHITE);
		
		this.initLayout();
		
		this.initActions();
	}
	
	protected void initActions() {
		launchGameButton.addActionListener(new PlayButtonAction());
		optionsButton.addActionListener(new OptionsButtonAction());
		leaveButton.addActionListener(new LeaveButtonAction() );
	}
	
	private class PlayButtonAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			PanelsContainer.getInstance().getCardLayout().next(PanelsContainer.getInstance());
		}
	}
	
	private class OptionsButtonAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			musicPlayer.closeClip();
			PanelsContainer.getInstance().getCardLayout().last((PanelsContainer.getInstance()));
		}
	}
	
	private class LeaveButtonAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	public void initLayout () throws IOException {
		verticalBox = (Box) ClassFactory.createNoTextContainingComponent("VerticalBox");
		this.add(verticalBox);
		
		lblChecker = (JLabel) ClassFactory.createTextContainingComponent("JLabel", "Checker");
		verticalBox.add(lblChecker);
		lblChecker.setFont(new Font("Tahoma", Font.PLAIN, 72));
		
		launchGameButton = (JButton) ClassFactory.createTextContainingComponent("JButton", "Lancer une partie");
		verticalBox.add(launchGameButton);
		
		optionsButton = (JButton) ClassFactory.createTextContainingComponent("JButton", "Options");
		verticalBox.add(optionsButton);
		
		leaveButton = (JButton) ClassFactory.createTextContainingComponent("JButton", "Quitter");
		verticalBox.add(leaveButton);
		musicPlayer = new ClipPlayer();
		musicPlayer.playClip();
	}
	/*
	private static MainScreenPanel instance = new MainScreenPanel();
	
	public static MainScreenPanel getInstance() {
		return instance;
	}
	*/
	public Component[] getComponentsOnPanel () {
		return this.verticalBox.getComponents();
	}
	
	public void addListener(CustomEvent toAdd) {
		listeners.add(toAdd);
	}
	    
	public void initiateStateChange(JFrame frame) {
	    StateMachine.getInstance();
	    for (CustomEvent customEventsList : listeners)
	    	customEventsList.stateChanged(frame);
	}
}