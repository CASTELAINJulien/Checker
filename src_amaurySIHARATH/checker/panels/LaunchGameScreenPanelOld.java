package checker.panels;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

import checker.core.VariableRepository;
import checker.data.ClassFactory;
import checker.data.Player;
import checker.gui.GTParameters;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;

public class LaunchGameScreenPanelOld extends JPanel {
	private JTextField textFieldFirstPlayerName;
	private JTextField textFieldSecondPlayerName;
	private JTextField textFieldThirdPlayerName;
	private Box generalVerticalBox;
	private JLabel configurationGameLabel;
	private Box centerHorizontalBox;
	private Box firstColumnVerticalBox;
	private Box secondColumnVerticalBox;
	private Box thirdColumnVerticalBox;
	private JComboBox firstPlayerChoice;
	private JComboBox secondPlayerChoice;
	private JComboBox thirdPlayerChoice;
	private JButton launchGameButton;
	private JButton previousButton;
	private Box horizontalBox;
	private JLabel labelFirstPlayerName;
	private JLabel labelSecondPlayerName;
	private JLabel labelThirdPlayerName;
	/**
	 * Create the panel.
	 */
	public LaunchGameScreenPanelOld() {
		setLayout(new BorderLayout(0, 0));
		
		initLayout();
		
		int windowWidth = GTParameters.WINDOW_WIDTH;
		if (windowWidth < 1024 || (windowWidth % 1024 != 0)) {
			throw new IllegalArgumentException("Non supported window size : " + windowWidth);
		}

		setPreferredSize(new Dimension(windowWidth, GTParameters.WINDOW_HEIGHT));
		setBackground(Color.WHITE);
		
		this.initActions();

	}
	
	protected void initActions() {
		launchGameButton.addActionListener(new PlayAction());
		previousButton.addActionListener(new PreviousAction());
	}
	
	private class PlayAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			
			Player player1 = ClassFactory.createPlayer(textFieldFirstPlayerName.getText(), returnComboBoxValue(firstPlayerChoice));
			Player player2 = ClassFactory.createPlayer(textFieldSecondPlayerName.getText(), returnComboBoxValue(secondPlayerChoice));
			Player player3 = ClassFactory.createPlayer(textFieldThirdPlayerName.getText(), returnComboBoxValue(thirdPlayerChoice));
			VariableRepository.getInstance().registerPlayer( "Player 1", player1 );
			VariableRepository.getInstance().registerPlayer( "Player 2", player2 );
			VariableRepository.getInstance().registerPlayer( "Player 3", player3 );
			// PanelsContainer.getInstance().add(comp);
			PanelsContainer.getInstance().getCardLayout().next(PanelsContainer.getInstance());
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
	
	public void initLayout() {
		generalVerticalBox = (Box) ClassFactory.createNoTextContainingComponent("VerticalBox");
		add(generalVerticalBox);
		
		configurationGameLabel = (JLabel) ClassFactory.createTextContainingComponent("JLabel", "Configuration de la partie");
		generalVerticalBox.add(configurationGameLabel);
		configurationGameLabel.setVerticalAlignment(SwingConstants.TOP);
		configurationGameLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		
		centerHorizontalBox = (Box) ClassFactory.createNoTextContainingComponent("HorizontalBox");
		generalVerticalBox.add(centerHorizontalBox);
		
		firstColumnVerticalBox = (Box) ClassFactory.createNoTextContainingComponent("VerticalBox");
		centerHorizontalBox.add(firstColumnVerticalBox);
		
		labelFirstPlayerName = (JLabel) ClassFactory.createTextContainingComponent("JLabel", "Informations Joueur 1 :");
		firstColumnVerticalBox.add(labelFirstPlayerName);
		
		textFieldFirstPlayerName = (JTextField) ClassFactory.createNoTextContainingComponent("JTextField");
		firstColumnVerticalBox.add(textFieldFirstPlayerName);
		textFieldFirstPlayerName.setColumns(10);
		
		firstPlayerChoice= (JComboBox) ClassFactory.createNoTextContainingComponent("JComboBox");
		firstPlayerChoice.setModel(new DefaultComboBoxModel(new String[] {"Humain", "AI"}));
		firstColumnVerticalBox.add(firstPlayerChoice);
		
		JSeparator separator = (JSeparator) ClassFactory.createNoTextContainingComponent("JSeparator");
		separator.setOrientation(SwingConstants.VERTICAL);
		centerHorizontalBox.add(separator);
		
		secondColumnVerticalBox = (Box) ClassFactory.createNoTextContainingComponent("VerticalBox");
		centerHorizontalBox.add(secondColumnVerticalBox);
		
		labelSecondPlayerName = (JLabel) ClassFactory.createTextContainingComponent("JLabel", "Informations Joueur 2 :");
		secondColumnVerticalBox.add(labelSecondPlayerName);
		
		textFieldSecondPlayerName = (JTextField) ClassFactory.createNoTextContainingComponent("JTextField");
		secondColumnVerticalBox.add(textFieldSecondPlayerName);
		textFieldSecondPlayerName.setColumns(10);
		
		secondPlayerChoice = (JComboBox) ClassFactory.createNoTextContainingComponent("JComboBox");
		secondPlayerChoice.setModel(new DefaultComboBoxModel(new String[] {"Humain", "IA"}));
		secondColumnVerticalBox.add(secondPlayerChoice);
		
		JSeparator separator_1 = (JSeparator) ClassFactory.createNoTextContainingComponent("JSeparator");
		separator_1.setOrientation(SwingConstants.VERTICAL);
		centerHorizontalBox.add(separator_1);
		
		thirdColumnVerticalBox = (Box) ClassFactory.createNoTextContainingComponent("VerticalBox");
		centerHorizontalBox.add(thirdColumnVerticalBox);
		
		labelSecondPlayerName = (JLabel) ClassFactory.createTextContainingComponent("JLabel", "Informations Joueur 3 :");
		thirdColumnVerticalBox.add(labelSecondPlayerName);
		
		textFieldThirdPlayerName = (JTextField) ClassFactory.createNoTextContainingComponent("JTextField");
		thirdColumnVerticalBox.add(textFieldThirdPlayerName);
		textFieldThirdPlayerName.setColumns(10);
		
		thirdPlayerChoice = (JComboBox) ClassFactory.createNoTextContainingComponent("JComboBox");
		thirdPlayerChoice.setModel(new DefaultComboBoxModel(new String[] {"Humain", "IA"}));
		thirdColumnVerticalBox.add(thirdPlayerChoice);
		
		horizontalBox = (Box) ClassFactory.createNoTextContainingComponent("HorizontalBox");
		generalVerticalBox.add(horizontalBox);
		
		launchGameButton = (JButton) ClassFactory.createTextContainingComponent("JButton", "Lancer la partie !");
		horizontalBox.add(launchGameButton);
		
		previousButton = (JButton) ClassFactory.createTextContainingComponent("JButton", "Annuler");
		horizontalBox.add(previousButton);
	}

}
