package checker.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import customEventsPackage.CustomEvent;
import checker.data.ClipPlayer;
import checker.gui.GTParameters;
import java.io.IOException;

public class MainScreenPanel extends JPanel {
	
	private static final long serialVersionUID = 7064806528132220998L;
	private JLabel lblChecker;
	private JButton launchGameButton;
	private JButton optionsButton;
	private JButton leaveButton;
	private List<CustomEvent> listeners = new ArrayList<CustomEvent>();
	private ClipPlayer musicPlayer;
	
	public MainScreenPanel () throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		int windowWidth = GTParameters.WINDOW_WIDTH;
		if (windowWidth < 1024 || (windowWidth % 1024 != 0)) {
			throw new IllegalArgumentException("Non supported window size : " + windowWidth);
		}

		setPreferredSize(new Dimension(windowWidth, GTParameters.WINDOW_HEIGHT));
		setBackground(Color.LIGHT_GRAY.darker());
		
		
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
			PanelsContainer.getInstance().getCardLayout().last((PanelsContainer.getInstance()));
			PanelsContainer.getInstance().getCardLayout().previous((PanelsContainer.getInstance()));
		}
	}
	
	private class LeaveButtonAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	public void initLayout () throws IOException {
		setLayout(null);
		
		lblChecker = new JLabel("Checker");
		lblChecker.setBounds(417, 0, 254, 87);
		add(lblChecker);
		lblChecker.setFont(new Font("Tahoma", Font.PLAIN, 72));
		
		launchGameButton = new JButton("Play");
		launchGameButton.setBounds(445, 116, 192, 50);
		add(launchGameButton);
		
		optionsButton = new JButton("Options");
		optionsButton.setBounds(445, 189, 192, 50);
		add(optionsButton);
		
		leaveButton = new JButton("Quit");
		leaveButton.setBounds(445, 268, 192, 50);
		add(leaveButton);
	}
	
	public void addListener(CustomEvent toAdd) {
		listeners.add(toAdd);
	}
}