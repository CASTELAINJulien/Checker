
package checker.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
	private JLabel lblChecker;
	private JButton launchGameButton;
	private JButton optionsButton;
	private JButton leaveButton;
	private List<CustomEvent> listeners = new ArrayList<CustomEvent>();
	private ClipPlayer musicPlayer;
	
	// Faire attention aux throws, on devrait mettre un try & catch quelque part
	public MainScreenPanel () throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		int windowWidth = GTParameters.WINDOW_WIDTH;
		if (windowWidth < 1024 || (windowWidth % 1024 != 0)) {
			throw new IllegalArgumentException("Non supported window size : " + windowWidth);
		}

		setPreferredSize(new Dimension(windowWidth, GTParameters.WINDOW_HEIGHT));
		setBackground(Color.WHITE);
		
		this.initLayout();
		
		this.initActions();
		
		//musicPlayer = new ClipPlayer();
		//musicPlayer.playClip();
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
			// musicPlayer.closeClip();
			PanelsContainer.getInstance().getCardLayout().last((PanelsContainer.getInstance()));
		}
	}
	
	private class LeaveButtonAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	public void initLayout () throws IOException {
		setLayout(null);
		
		// lblChecker = (JLabel) ClassFactory.createTextContainingComponent("JLabel", "Checker");
		lblChecker = new JLabel("Checker");
		lblChecker.setBounds(417, 0, 254, 87);
		add(lblChecker);
		lblChecker.setFont(new Font("Tahoma", Font.PLAIN, 72));
		
		// launchGameButton = (JButton) ClassFactory.createTextContainingComponent("JButton", "Lancer une partie");
		launchGameButton = new JButton("Play");
		launchGameButton.setBounds(445, 116, 192, 50);
		add(launchGameButton);
		
		// optionsButton = (JButton) ClassFactory.createTextContainingComponent("JButton", "Options");
		optionsButton = new JButton("Options");
		optionsButton.setBounds(445, 189, 192, 50);
		add(optionsButton);
		
		// leaveButton = (JButton) ClassFactory.createTextContainingComponent("JButton", "Quitter");
		leaveButton = new JButton("Quit");
		leaveButton.setBounds(445, 268, 192, 50);
		add(leaveButton);
	
	}
	/*
	private static MainScreenPanel instance = new MainScreenPanel();
	
	public static MainScreenPanel getInstance() {
		return instance;
	}
	*/
	/*
	public Component[] getComponentsOnPanel () {
		return this.verticalBox.getComponents();
	}
	*/
	public void addListener(CustomEvent toAdd) {
		listeners.add(toAdd);
	}
	/*
	public void initiateStateChange(JFrame frame) {
	    StateMachine.getInstance();
	    for (CustomEvent customEventsList : listeners)
	    	customEventsList.stateChanged(frame);
	}
	*/
}
