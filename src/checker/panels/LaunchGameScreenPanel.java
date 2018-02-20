package checker.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import checker.core.VariableRepository;
import checker.data.ClassFactory;
import checker.data.Player;
import checker.gui.GTParameters;

import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

public class LaunchGameScreenPanel extends JPanel {
	private JTextField textFieldFirstPlayerName;
	private JTextField textFieldSecondPlayerName;
	private JTextField textFieldThirdPlayerName;
	
	JLabel labelGameConfigurationTitle;
	JLabel labelFirstPlayerInfo;
	JLabel labelSecondPlayerInfo;
	JLabel labelThirdPlayerInfo;
	
	JComboBox comboBoxFirstPlayerChoice;
	JComboBox comboBoxSecondPlayerChoice;
	JComboBox comboBoxThirdPlayerChoice;
	
	JLabel labelFirstPlayerName;
	JLabel labelSecondPlayerName; 
	JLabel labelThirdPlayerName;
	
	JLabel labelFirstPlayerType;
	JLabel labelSecondPlayerType;
	JLabel labelThirdPlayerType;
	
	JLabel labelFirstPlayerPowers;
	JLabel labelSecondPlayerPowers;
	JLabel labelThirdPlayerPowers;
	
	JList listFirstPlayerPower;
	JList listSecondPlayerPower;
	JList listThirdPlayerPower;
	
	JButton buttonLaunchGame;
	JButton buttonPrevious;
	/**
	 * Create the panel.
	 */
	public LaunchGameScreenPanel() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		int windowWidth = GTParameters.WINDOW_WIDTH;
		if (windowWidth < 1024 || (windowWidth % 1024 != 0)) {
			throw new IllegalArgumentException("Non supported window size : " + windowWidth);
		}

		setPreferredSize(new Dimension(1024, 769));
		
		initLayout();
		initActions();
	}
	
	protected void initActions() {
		buttonLaunchGame.addActionListener(new PlayAction());
		buttonPrevious.addActionListener(new PreviousAction());
	}
	
	private class PlayAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			Player player1;
			Player player2;
			Player player3;
			// True si AI, Faux si joueur Humain
			if ( returnComboBoxValue(comboBoxFirstPlayerChoice) == true ) {
				if ( textFieldFirstPlayerName.getText().length() > 0 ) {
					player1 = ClassFactory.createPlayer(textFieldFirstPlayerName.getText() + " ( AI )", returnComboBoxValue(comboBoxFirstPlayerChoice));
				} else {
					player1 = ClassFactory.createPlayer("Player 1" + " ( AI )", returnComboBoxValue(comboBoxFirstPlayerChoice));
				} 
			} else {
				if ( textFieldFirstPlayerName.getText().length() > 0 ) {
					player1 = ClassFactory.createPlayer(textFieldFirstPlayerName.getText(), returnComboBoxValue(comboBoxFirstPlayerChoice));
				} else {
					player1 = ClassFactory.createPlayer("Player 1", returnComboBoxValue(comboBoxFirstPlayerChoice));
				} 
			}
			
			if ( returnComboBoxValue(comboBoxSecondPlayerChoice) == true ) {
				if ( textFieldSecondPlayerName.getText().length() > 0 ) {
					player2 = ClassFactory.createPlayer(textFieldSecondPlayerName.getText() + " ( AI )", returnComboBoxValue(comboBoxSecondPlayerChoice));
				} else {
					player2 = ClassFactory.createPlayer("Player 2" + " ( AI )", returnComboBoxValue(comboBoxSecondPlayerChoice));
				} 
			} else {
				if ( textFieldSecondPlayerName.getText().length() > 0 ) {
					player2 = ClassFactory.createPlayer(textFieldSecondPlayerName.getText(), returnComboBoxValue(comboBoxSecondPlayerChoice));
				} else {
					player2 = ClassFactory.createPlayer("Player 2", returnComboBoxValue(comboBoxSecondPlayerChoice));
				} 
			}
			
			if ( returnComboBoxValue(comboBoxThirdPlayerChoice) == true ) {
				if ( textFieldThirdPlayerName.getText().length() > 0 ) {
					player3 = ClassFactory.createPlayer(textFieldThirdPlayerName.getText() + " ( AI )", returnComboBoxValue(comboBoxThirdPlayerChoice));
				} else {
					player3 = ClassFactory.createPlayer("Player 3" + " ( AI )", returnComboBoxValue(comboBoxThirdPlayerChoice));
				} 
			} else {
				if ( textFieldThirdPlayerName.getText().length() > 0 ) {
					player3 = ClassFactory.createPlayer(textFieldThirdPlayerName.getText(), returnComboBoxValue(comboBoxThirdPlayerChoice));
				} else {
					player3 = ClassFactory.createPlayer("Player 3", returnComboBoxValue(comboBoxThirdPlayerChoice));
				} 
			}
			/*
			if ( textFieldSecondPlayerName.getText().length() > 0 ) {
				player2 = ClassFactory.createPlayer(textFieldSecondPlayerName.getText(), returnComboBoxValue(comboBoxSecondPlayerChoice));
			} else {
				player2 = ClassFactory.createPlayer("Player 2", returnComboBoxValue(comboBoxFirstPlayerChoice));
			}
			
			if ( textFieldThirdPlayerName.getText().length() > 0 ) {
				player3 = ClassFactory.createPlayer(textFieldThirdPlayerName.getText(), returnComboBoxValue(comboBoxThirdPlayerChoice));
			} else {
				player3 = ClassFactory.createPlayer("Player 3", returnComboBoxValue(comboBoxFirstPlayerChoice));
			}
			*/
			VariableRepository.getInstance().registerPlayer( "Player 1", player1 );
			VariableRepository.getInstance().registerPlayer( "Player 2", player2 );
			VariableRepository.getInstance().registerPlayer( "Player 3", player3 );
			// PanelsContainer.getInstance().add(comp);
			PanelsContainer.getInstance().getCardLayout().next(PanelsContainer.getInstance());
			Board.startTime();
		}
	}
	
	private class PreviousAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			PanelsContainer.getInstance().getCardLayout().previous(PanelsContainer.getInstance());
		}
	}
	
	public Boolean returnComboBoxValue(JComboBox comboBox) {
		Boolean ifIsAI = false;
		if ( comboBox.getSelectedItem() == "AI" ) {
			ifIsAI = true;
		}
		return ifIsAI;
	}
	
	public void initLayout () {
		labelGameConfigurationTitle = new JLabel("Game Configuration");
		labelGameConfigurationTitle.setFont(new Font("Tahoma", Font.PLAIN, 38));
		labelGameConfigurationTitle.setBounds(338, 22, 335, 76);
		add(labelGameConfigurationTitle);
		
		labelFirstPlayerInfo = new JLabel("Informations Joueur 1 :");
		labelFirstPlayerInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelFirstPlayerInfo.setBounds(71, 131, 162, 14);
		add(labelFirstPlayerInfo);
		
		labelSecondPlayerInfo = new JLabel("Informations Joueur 2 :");
		labelSecondPlayerInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelSecondPlayerInfo.setBounds(400, 131, 168, 14);
		add(labelSecondPlayerInfo);
		
		labelThirdPlayerInfo = new JLabel("Informations Joueur 3 :");
		labelThirdPlayerInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelThirdPlayerInfo.setBounds(710, 131, 192, 14);
		add(labelThirdPlayerInfo);
		
		textFieldFirstPlayerName = new JTextField();
		textFieldFirstPlayerName.setBounds(180, 156, 135, 20);
		add(textFieldFirstPlayerName);
		textFieldFirstPlayerName.setColumns(10);
		
		textFieldSecondPlayerName = new JTextField();
		textFieldSecondPlayerName.setColumns(10);
		textFieldSecondPlayerName.setBounds(514, 156, 135, 20);
		add(textFieldSecondPlayerName);
		
		textFieldThirdPlayerName = new JTextField();
		textFieldThirdPlayerName.setColumns(10);
		textFieldThirdPlayerName.setBounds(829, 156, 135, 20);
		add(textFieldThirdPlayerName);
		
		comboBoxFirstPlayerChoice = new JComboBox();
		comboBoxFirstPlayerChoice.setModel(new DefaultComboBoxModel(new String[] {"Humain", "AI"}));
		comboBoxFirstPlayerChoice.setBounds(180, 187, 135, 20);
		add(comboBoxFirstPlayerChoice);
		
		comboBoxSecondPlayerChoice = new JComboBox();
		comboBoxSecondPlayerChoice.setModel(new DefaultComboBoxModel(new String[] {"Humain", "AI"}));
		comboBoxSecondPlayerChoice.setBounds(514, 187, 135, 20);
		add(comboBoxSecondPlayerChoice);
		
		comboBoxThirdPlayerChoice = new JComboBox();
		comboBoxThirdPlayerChoice.setModel(new DefaultComboBoxModel(new String[] {"Humain", "AI"}));
		comboBoxThirdPlayerChoice.setBounds(829, 187, 135, 20);
		add(comboBoxThirdPlayerChoice);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(350, 112, 2, 340);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(681, 112, 2, 340);
		add(separator_1);
		
		labelFirstPlayerName = new JLabel("Player Name :");
		labelFirstPlayerName.setBounds(71, 159, 78, 14);
		add(labelFirstPlayerName);
		
		labelSecondPlayerName = new JLabel("Player Name :");
		labelSecondPlayerName.setBounds(400, 159, 78, 14);
		add(labelSecondPlayerName);
		
		labelThirdPlayerName = new JLabel("Player Name :");
		labelThirdPlayerName.setBounds(710, 159, 78, 14);
		add(labelThirdPlayerName);
		
		labelFirstPlayerType = new JLabel("Player type :");
		labelFirstPlayerType.setBounds(71, 190, 78, 14);
		add(labelFirstPlayerType);
		
		labelSecondPlayerType = new JLabel("Player type :");
		labelSecondPlayerType.setBounds(400, 190, 78, 14);
		add(labelSecondPlayerType);
		
		labelThirdPlayerType = new JLabel("Player type :");
		labelThirdPlayerType.setBounds(710, 190, 78, 14);
		add(labelThirdPlayerType);
		
		labelFirstPlayerPowers = new JLabel("Select two powers :");
		labelFirstPlayerPowers.setBounds(71, 215, 95, 14);
		add(labelFirstPlayerPowers);
		
		labelSecondPlayerPowers = new JLabel("Select two powers :");
		labelSecondPlayerPowers.setBounds(400, 215, 104, 14);
		add(labelSecondPlayerPowers);
		
		labelThirdPlayerPowers = new JLabel("Select two powers :");
		labelThirdPlayerPowers.setBounds(710, 215, 104, 14);
		add(labelThirdPlayerPowers);
		
		listFirstPlayerPower = new JList();
		listFirstPlayerPower.setBounds(180, 218, 135, 121);
		add(listFirstPlayerPower);
		
		listSecondPlayerPower = new JList();
		listSecondPlayerPower.setBounds(514, 218, 135, 121);
		add(listSecondPlayerPower);
		
		listThirdPlayerPower = new JList();
		listThirdPlayerPower.setBounds(829, 218, 135, 121);
		add(listThirdPlayerPower);
		
		buttonLaunchGame = new JButton("Launch Game");
		buttonLaunchGame.setBounds(400, 522, 104, 23);
		add(buttonLaunchGame);
		
		buttonPrevious = new JButton("Previous");
		buttonPrevious.setBounds(514, 522, 104, 23);
		add(buttonPrevious);
	}
}
