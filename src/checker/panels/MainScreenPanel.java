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
import checker.gui.GTParameters;
import application.StateMachine;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	
	public MainScreenPanel () {
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
		launchGameButton.addActionListener(new PlayAction());
	}
	
	private class PlayAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			System.out.println("fzefzefezf");
			PanelsContainer.getInstance().getCardLayout().next(PanelsContainer.getInstance());
		}
	}
	
	public void initLayout () {
		verticalBox = (Box) ClassFactory.createNoTextContainingComponent("VerticalBox");
		this.add(verticalBox);
		
		lblChecker = (JLabel) ClassFactory.createTextContainingComponent("JLabel", "Checker");
		verticalBox.add(lblChecker);
		lblChecker.setFont(new Font("Tahoma", Font.PLAIN, 72));
		
		launchGameButton = (JButton) ClassFactory.createTextContainingComponent("JButton", "Lancer une partie");
		launchGameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		verticalBox.add(launchGameButton);
		
		optionsButton = (JButton) ClassFactory.createTextContainingComponent("JButton", "Options");
		verticalBox.add(optionsButton);
		
		leaveButton = (JButton) ClassFactory.createTextContainingComponent("JButton", "Quitter");
		verticalBox.add(leaveButton);
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