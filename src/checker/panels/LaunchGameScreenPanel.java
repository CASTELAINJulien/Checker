package checker.panels;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

import checker.data.ClassFactory;
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

public class LaunchGameScreenPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	/**
	 * Create the panel.
	 */
	public LaunchGameScreenPanel() {
		setLayout(new BorderLayout(0, 0));
		
		initLayout();
		
		int windowWidth = GTParameters.WINDOW_WIDTH;
		if (windowWidth < 800 || (windowWidth % 800 != 0)) {
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
			PanelsContainer.getInstance().getCardLayout().next(PanelsContainer.getInstance());
		}
	}
	
	private class PreviousAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			PanelsContainer.getInstance().getCardLayout().previous(PanelsContainer.getInstance());
		}
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
		
		lblNewLabel = (JLabel) ClassFactory.createTextContainingComponent("JLabel", "Informations Joueur 1 :");
		firstColumnVerticalBox.add(lblNewLabel);
		
		textField = (JTextField) ClassFactory.createNoTextContainingComponent("JTextField");
		firstColumnVerticalBox.add(textField);
		textField.setColumns(10);
		
		firstPlayerChoice= (JComboBox) ClassFactory.createNoTextContainingComponent("JComboBox");
		firstPlayerChoice.setModel(new DefaultComboBoxModel(new String[] {"Humain", "AI"}));
		firstColumnVerticalBox.add(firstPlayerChoice);
		
		JSeparator separator = (JSeparator) ClassFactory.createNoTextContainingComponent("JSeparator");
		separator.setOrientation(SwingConstants.VERTICAL);
		centerHorizontalBox.add(separator);
		
		secondColumnVerticalBox = (Box) ClassFactory.createNoTextContainingComponent("VerticalBox");
		centerHorizontalBox.add(secondColumnVerticalBox);
		
		lblNewLabel_1 = (JLabel) ClassFactory.createTextContainingComponent("JLabel", "Informations Joueur 2 :");
		secondColumnVerticalBox.add(lblNewLabel_1);
		
		textField_1 = (JTextField) ClassFactory.createNoTextContainingComponent("JTextField");
		secondColumnVerticalBox.add(textField_1);
		textField_1.setColumns(10);
		
		secondPlayerChoice = (JComboBox) ClassFactory.createNoTextContainingComponent("JComboBox");
		secondPlayerChoice.setModel(new DefaultComboBoxModel(new String[] {"Humain", "IA"}));
		secondColumnVerticalBox.add(secondPlayerChoice);
		
		JSeparator separator_1 = (JSeparator) ClassFactory.createNoTextContainingComponent("JSeparator");
		separator_1.setOrientation(SwingConstants.VERTICAL);
		centerHorizontalBox.add(separator_1);
		
		thirdColumnVerticalBox = (Box) ClassFactory.createNoTextContainingComponent("VerticalBox");
		centerHorizontalBox.add(thirdColumnVerticalBox);
		
		lblNewLabel_2 = (JLabel) ClassFactory.createTextContainingComponent("JLabel", "Informations Joueur 3 :");
		thirdColumnVerticalBox.add(lblNewLabel_2);
		
		textField_2 = (JTextField) ClassFactory.createNoTextContainingComponent("JTextField");
		thirdColumnVerticalBox.add(textField_2);
		textField_2.setColumns(10);
		
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
