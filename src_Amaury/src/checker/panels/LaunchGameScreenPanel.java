

package checker.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import checker.core.CheckerBuilder;
import checker.core.GameVariableRepository;
import checker.core.VariableRepository;
import checker.data.ClassFactory;
import checker.data.Player;
import checker.gui.GTParameters;

import customEventsPackage.Power;
import customEventsPackage.PowerControl;
import customEventsPackage.PowerFreeze;
import customEventsPackage.PowerJump;
import customEventsPackage.PowerTeleport;
import customEventsPackage.PowerTwoMoves;

import javax.swing.JList;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
	
	private Power jump=new PowerJump();
	private	Power freeze=new PowerFreeze();
	private Power control=new PowerControl();
	private Power teleport=new PowerTeleport();
	private Power twoMoves=new PowerTwoMoves();
	
	private JButton btnPower1Player1;
	private JButton btnPower2Player1;
	private JButton btnPower3Player1;
	private JButton btnPower4Player1;
	private JButton btnPower5Player1;
	
	private JButton btnPower1Player2;
	private JButton btnPower2Player2;
	private JButton btnPower3Player2;
	private JButton btnPower4Player2;
	private JButton btnPower5Player2;
	
	private JButton btnPower1Player3;
	private JButton btnPower2Player3;
	private JButton btnPower3Player3;
	private JButton btnPower4Player3;
	private JButton btnPower5Player3;
	
	private int nbPowerChoosenJ1=0;
	private int nbPowerChoosenJ2=0;
	private int nbPowerChoosenJ3=0;
	
	private ArrayList<Power> al1=new ArrayList<Power>();
	private ArrayList<Power> al2=new ArrayList<Power>();
	private ArrayList<Power> al3=new ArrayList<Power>();
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
	
	private class PlayAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			Player player1;
			Player player2;
			Player player3;
			// True si AI, Faux si joueur Human
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
		
			VariableRepository.getInstance().registerPlayer( "Player 1", player1 );
			VariableRepository.getInstance().registerPlayer( "Player 2", player2 );
			VariableRepository.getInstance().registerPlayer( "Player 3", player3 );
			
			
			//random selection of the power(s)
			Power[] randomPower=new Power[5];
				randomPower[0]=control;
				randomPower[1]=freeze;
				randomPower[2]=jump;
				randomPower[3]=teleport;
				randomPower[4]=twoMoves;
				Random r = new Random();
				
			if(nbPowerChoosenJ1<2){
				if(nbPowerChoosenJ1==0) {
					Power powerRandomlySelected = randomPower[r.nextInt(5)];			
					al1.add(powerRandomlySelected);
					al1.add(powerRandomlySelected);
					while(al1.get(0).equals(al1.get(1))) {
						al1.remove(1);
						powerRandomlySelected = randomPower[r.nextInt(5)];			
						al1.add(powerRandomlySelected);
					}
				}
				if(nbPowerChoosenJ1==1) {
					Power powerRandomlySelected = randomPower[r.nextInt(5)];
					while(powerRandomlySelected.equals(al1.get(0))) {
						powerRandomlySelected = randomPower[r.nextInt(5)];
					}
					al1.add(powerRandomlySelected);
				}
			}
			if(nbPowerChoosenJ2<2){
				if(nbPowerChoosenJ2==0) {
					Power powerRandomlySelected = randomPower[r.nextInt(5)];			
					al2.add(powerRandomlySelected);
					al2.add(powerRandomlySelected);
					while(al2.get(0).equals(al2.get(1))) {
						al2.remove(1);
						powerRandomlySelected = randomPower[r.nextInt(5)];			
						al2.add(powerRandomlySelected);
					}
				}
				if(nbPowerChoosenJ2==1) {
					Power powerRandomlySelected = randomPower[r.nextInt(5)];
					while(powerRandomlySelected.equals(al2.get(0))) {
						powerRandomlySelected = randomPower[r.nextInt(5)];
					}
					al2.add(powerRandomlySelected);
				}
			}
			if(nbPowerChoosenJ3<2){
				if(nbPowerChoosenJ3==0) {
					Power powerRandomlySelected = randomPower[r.nextInt(5)];			
					al3.add(powerRandomlySelected);
					al3.add(powerRandomlySelected);
					while(al3.get(0).equals(al3.get(1))) {
						al3.remove(1);
						powerRandomlySelected = randomPower[r.nextInt(5)];			
						al3.add(powerRandomlySelected);
					}
				}
				if(nbPowerChoosenJ3==1) {
					Power powerRandomlySelected = randomPower[r.nextInt(5)];
					while(powerRandomlySelected.equals(al3.get(0))) {
						powerRandomlySelected = randomPower[r.nextInt(5)];
					}
					al3.add(powerRandomlySelected);
				}
			}
			
			player1.addPower(al1.get(0));
			player1.addPower(al1.get(1));
			
			player2.addPower(al2.get(0));
			player2.addPower(al2.get(1));
			
			player3.addPower(al3.get(0));
			player3.addPower(al3.get(1));
			
			CheckerBuilder.getInstance().initializeEmplacements();
			
			// GameVariableRepository.getInstance().setGameStarted(true);
			PanelsContainer.getInstance().getCardLayout().next(PanelsContainer.getInstance());
		}
	}
	
	public void initLayout () {
		labelGameConfigurationTitle = new JLabel("Game Configuration");
		labelGameConfigurationTitle.setFont(new Font("Tahoma", Font.PLAIN, 38));
		labelGameConfigurationTitle.setBounds(338, 22, 335, 76);
		add(labelGameConfigurationTitle);
		
		labelFirstPlayerInfo = new JLabel("Informations Player 1 :");
		labelFirstPlayerInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelFirstPlayerInfo.setBounds(71, 131, 162, 14);
		add(labelFirstPlayerInfo);
		
		labelSecondPlayerInfo = new JLabel("Informations Player 2 :");
		labelSecondPlayerInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelSecondPlayerInfo.setBounds(400, 131, 168, 14);
		add(labelSecondPlayerInfo);
		
		labelThirdPlayerInfo = new JLabel("Informations Player 3 :");
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
		comboBoxFirstPlayerChoice.setModel(new DefaultComboBoxModel(new String[] {"Human", "AI"}));
		comboBoxFirstPlayerChoice.setBounds(180, 187, 135, 20);
		add(comboBoxFirstPlayerChoice);
		
		comboBoxSecondPlayerChoice = new JComboBox();
		comboBoxSecondPlayerChoice.setModel(new DefaultComboBoxModel(new String[] {"Human", "AI"}));
		comboBoxSecondPlayerChoice.setBounds(514, 187, 135, 20);
		add(comboBoxSecondPlayerChoice);
		
		comboBoxThirdPlayerChoice = new JComboBox();
		comboBoxThirdPlayerChoice.setModel(new DefaultComboBoxModel(new String[] {"Human", "AI"}));
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
		
		buttonLaunchGame = new JButton("Launch Game");
		buttonLaunchGame.setBounds(400, 522, 104, 23);
		add(buttonLaunchGame);
		
		buttonPrevious = new JButton("Previous");
		buttonPrevious.setBounds(514, 522, 104, 23);
		add(buttonPrevious);
		
		
		
		listFirstPlayerPower = new JList();
		listFirstPlayerPower.setBounds(180, 218, 150, 100);
		
		ImageIcon icon1=new ImageIcon(new ImageIcon("power_jump.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
		ImageIcon icon2=new ImageIcon(new ImageIcon("power_freeze.jpg").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
		ImageIcon icon3=new ImageIcon(new ImageIcon("power_control.jpg").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
		ImageIcon icon4=new ImageIcon(new ImageIcon("power_teleport.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
		ImageIcon icon5=new ImageIcon(new ImageIcon("power_twomoves.jpg").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
		
		
		btnPower1Player1= new JButton("Power 1");
		btnPower1Player1.setBackground(Color.white);
		btnPower1Player1.setIcon(icon1);
		btnPower1Player1.setBounds(180, 218, 50, 50);
		btnPower1Player1.setToolTipText("<html><center>Jump power:<br>"+PowerJump.getDescription()+"<br>cost:"+PowerJump.getCost()+"</center></html>");
		add(btnPower1Player1);
		
		btnPower2Player1 = new JButton("Power 2");
		btnPower2Player1.setBackground(Color.white);
		btnPower2Player1.setIcon(icon2);
		btnPower2Player1.setBounds(230, 218, 50, 50);
		btnPower2Player1.setToolTipText("<html><center>Freeze power:<br>"+PowerFreeze.getDescription()+"<br>cost:"+PowerFreeze.getCost()+"</center></html>");
		add(btnPower2Player1);
		
		btnPower3Player1 = new JButton("Power 3");
		btnPower3Player1.setBackground(Color.white);
		btnPower3Player1.setIcon(icon3);
		btnPower3Player1.setBounds(280, 218, 50, 50);
		btnPower3Player1.setToolTipText("<html><center>Control power:<br>"+PowerControl.getDescription()+"<br>cost:"+PowerControl.getCost()+"</center></html>");
		add(btnPower3Player1);
		
		btnPower4Player1 = new JButton("Power 4");
		btnPower4Player1.setBackground(Color.white);
		btnPower4Player1.setIcon(icon4);
		btnPower4Player1.setBounds(180, 268, 50, 50);
		btnPower4Player1.setToolTipText("<html><center>Teleport power:<br>"+PowerTeleport.getDescription()+"<br>cost:"+PowerTeleport.getCost()+"</center></html>");
		add(btnPower4Player1);
		
		btnPower5Player1 = new JButton("Power 5");
		btnPower5Player1.setBackground(Color.white);
		btnPower5Player1.setIcon(icon5);
		btnPower5Player1.setBounds(230, 268, 50, 50);
		btnPower5Player1.setToolTipText("<html><center>Two moves power:<br>"+PowerTwoMoves.getDescription()+"<br>cost:"+PowerTwoMoves.getCost()+"</center></html>");
		add(btnPower5Player1);
		
		add(listFirstPlayerPower);
		
	
		listSecondPlayerPower = new JList();
		listSecondPlayerPower.setBounds(514, 218, 150, 100);
		
		btnPower1Player2 = new JButton("Power 1");
		btnPower1Player2.setBackground(Color.white);
		btnPower1Player2.setIcon(icon1);
		btnPower1Player2.setBounds(514, 218, 50, 50);
		btnPower1Player2.setToolTipText("<html><center>Jump power:<br>"+PowerJump.getDescription()+"<br>cost:"+PowerJump.getCost()+"</center></html>");
		add(btnPower1Player2);
		
		btnPower2Player2 = new JButton("Power 2");
		btnPower2Player2.setBackground(Color.white);
		btnPower2Player2.setIcon(icon2);
		btnPower2Player2.setBounds(564, 218, 50, 50);
		btnPower2Player2.setToolTipText("<html><center>Freeze power:<br>"+PowerFreeze.getDescription()+"<br>cost:"+PowerFreeze.getCost()+"</center></html>");
		add(btnPower2Player2);
		
		btnPower3Player2 = new JButton("Power 3");
		btnPower3Player2.setBackground(Color.white);
		btnPower3Player2.setIcon(icon3);
		btnPower3Player2.setBounds(614, 218, 50, 50);
		btnPower3Player2.setToolTipText("<html><center>Control power:<br>"+PowerControl.getDescription()+"<br>cost:"+PowerControl.getCost()+"</center></html>");
		add(btnPower3Player2);
		
		btnPower4Player2 = new JButton("Power 4");
		btnPower4Player2.setBackground(Color.white);
		btnPower4Player2.setIcon(icon4);
		btnPower4Player2.setBounds(514, 268, 50, 50);
		btnPower4Player2.setToolTipText("<html><center>Teleport power:<br>"+PowerTeleport.getDescription()+"<br>cost:"+PowerTeleport.getCost()+"</center></html>");
		add(btnPower4Player2);
		
		btnPower5Player2 = new JButton("Power 5");
		btnPower5Player2.setBackground(Color.white);
		btnPower5Player2.setIcon(icon5);
		btnPower5Player2.setBounds(564, 268, 50, 50);
		btnPower5Player2.setToolTipText("<html><center>Two moves power:<br>"+PowerTwoMoves.getDescription()+"<br>cost:"+PowerTwoMoves.getCost()+"</center></html>");
		add(btnPower5Player2);
		
		add(listSecondPlayerPower);
		
		
		
		listThirdPlayerPower = new JList();
		listThirdPlayerPower.setBounds(829, 218, 150, 100);
		
		btnPower1Player3 = new JButton("Power 1");
		btnPower1Player3.setBackground(Color.white);
		btnPower1Player3.setIcon(icon1);
		btnPower1Player3.setBounds(829, 218, 50, 50);
		btnPower1Player3.setToolTipText("<html><center>Jump power:<br>"+PowerJump.getDescription()+"<br>cost:"+PowerJump.getCost()+"</center></html>");
		add(btnPower1Player3);
		
		btnPower2Player3 = new JButton("Power 2");
		btnPower2Player3.setBackground(Color.white);
		btnPower2Player3.setIcon(icon2);
		btnPower2Player3.setBounds(879, 218, 50, 50);
		btnPower2Player3.setToolTipText("<html><center>Freeze power:<br>"+PowerFreeze.getDescription()+"<br>cost:"+PowerFreeze.getCost()+"</center></html>");
		add(btnPower2Player3);
		
		btnPower3Player3 = new JButton("Power 3");
		btnPower3Player3.setBackground(Color.white);
		btnPower3Player3.setIcon(icon3);
		btnPower3Player3.setBounds(929, 218, 50, 50);
		btnPower3Player3.setToolTipText("<html><center>Control power:<br>"+PowerControl.getDescription()+"<br>cost:"+PowerControl.getCost()+"</center></html>");
		add(btnPower3Player3);
		
		btnPower4Player3 = new JButton("Power 4");
		btnPower4Player3.setBackground(Color.white);
		btnPower4Player3.setIcon(icon4);
		btnPower4Player3.setBounds(829, 268, 50, 50);
		btnPower4Player3.setToolTipText("<html><center>Teleport power:<br>"+PowerTeleport.getDescription()+"<br>cost:"+PowerTeleport.getCost()+"</center></html>");
		add(btnPower4Player3);
		
		btnPower5Player3 = new JButton("Power 5");
		btnPower5Player3.setBackground(Color.white);
		btnPower5Player3.setIcon(icon5);
		btnPower5Player3.setBounds(879, 268, 50, 50);
		btnPower5Player3.setToolTipText("<html><center>Two moves power:<br>"+PowerTwoMoves.getDescription()+"<br>cost:"+PowerTwoMoves.getCost()+"</center></html>");
		add(btnPower5Player3);
		
		add(listThirdPlayerPower);
		btnPower1Player1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbPowerChoosenJ1<2 && al1.contains(jump)==false) {
					al1.add(jump);
					nbPowerChoosenJ1++;
					btnPower1Player1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					//System.out.println(al1.get(nbPowerChoosenJ1).getDescription2());

				}
		 		else if((al1.get(0).getName().equals("Jump")||al1.get(1).getName().equals("Jump")) ) {
					al1.remove(jump);
					nbPowerChoosenJ1--;
					btnPower1Player1.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
					//System.out.println(nbPowerChoosenJ1+1);
					
					
				}
			}
		});
		btnPower2Player1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbPowerChoosenJ1<2 && al1.contains(freeze)==false) {
					al1.add(freeze);
					nbPowerChoosenJ1++;
					btnPower2Player1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					//System.out.println(al1.get(nbPowerChoosenJ1).getDescription2());
					//System.out.println(al1.contains(freeze));
					//System.out.println(nbPowerChoosenJ1+1);
				}
				else if((al1.get(0).getName().equals("Freeze")||al1.get(1).getName().equals("Freeze")) ) {
					al1.remove(freeze);
					nbPowerChoosenJ1--;
					btnPower2Player1.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
					//System.out.println(nbPowerChoosenJ1+1);
				//	System.out.println(al1.contains(freeze));
				}
			}
		});
		btnPower3Player1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbPowerChoosenJ1<2 && al1.contains(control)==false) {
					al1.add(control);
					nbPowerChoosenJ1++;
					btnPower3Player1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					//System.out.println(al1.get(nbPowerChoosenJ1).getDescription2());
				//	System.out.println(nbPowerChoosenJ1+1);
				}
				else if((al1.get(0).getName().equals("Control")||al1.get(1).getName().equals("Control")) ) {
					al1.remove(control);
					nbPowerChoosenJ1--;
					btnPower3Player1.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
					//System.out.println(nbPowerChoosenJ1+1);
				}
			}
		});
		btnPower4Player1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbPowerChoosenJ1<2 && al1.contains(teleport)==false)  {
					al1.add(teleport);
					nbPowerChoosenJ1++;
					btnPower4Player1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					//System.out.println(al1.get(nbPowerChoosenJ1).getDescription2());
					//System.out.println(nbPowerChoosenJ1+1);
				}
				else if((al1.get(0).getName().equals("Teleport")||al1.get(1).getName().equals("Teleport")) ) {
					al1.remove(teleport);
					nbPowerChoosenJ1--;
					btnPower4Player1.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
					//System.out.println(nbPowerChoosenJ1+1);
				}
			}	
		});
		btnPower5Player1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbPowerChoosenJ1<2 && al1.contains(twoMoves)==false)  {
					al1.add(twoMoves);
					nbPowerChoosenJ1++;
					btnPower5Player1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					//System.out.println(al1.get(nbPowerChoosenJ1).getDescription2());
					//System.out.println(nbPowerChoosenJ1+1);
				}
				else if((al1.get(0).getName().equals("Two moves")||al1.get(1).getName().equals("Two moves")) ) {
					al1.remove(twoMoves);
					nbPowerChoosenJ1--;
					btnPower5Player1.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
					//System.out.println(nbPowerChoosenJ1+1);
				}
			}
		});
		
		
		
		btnPower1Player2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbPowerChoosenJ2<2 && al2.contains(jump)==false) {
					al2.add(jump);
					nbPowerChoosenJ2++;
					btnPower1Player2.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					//System.out.println(al2.get(nbPowerChoosenJ2).getDescription2());
				}
				else if((al2.get(0).getName().equals("Jump")||al2.get(1).getName().equals("Jump")) ) {
					al2.remove(jump);
					nbPowerChoosenJ2--;
					btnPower1Player2.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
					//System.out.println(nbPowerChoosenJ2+1);
				}
			}
		});
		btnPower2Player2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbPowerChoosenJ2<2 && al2.contains(freeze)==false) {
					al2.add(freeze);
					nbPowerChoosenJ2++;
					btnPower2Player2.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					//System.out.println(al2.get(nbPowerChoosenJ2).getDescription2());
				}
				else if((al2.get(0).getName().equals("Freeze")||al2.get(1).getName().equals("Freeze")) ) {
					al2.remove(freeze);
					nbPowerChoosenJ2--;
					btnPower2Player2.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
					//System.out.println(nbPowerChoosenJ2+1);
				}
			}
		});
		btnPower3Player2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbPowerChoosenJ2<2 && al2.contains(control)==false) {
					al2.add(control);
					nbPowerChoosenJ2++;
					btnPower3Player2.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					//System.out.println(al2.get(nbPowerChoosenJ2).getDescription2());
				}
				else if((al2.get(0).getName().equals("Control")||al2.get(1).getName().equals("Control")) ) {
					al2.remove(control);
					nbPowerChoosenJ2--;
					btnPower3Player2.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
					//System.out.println(nbPowerChoosenJ2+1);
				}
			}
		});
		btnPower4Player2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbPowerChoosenJ2<2 && al2.contains(teleport)==false) {
					al2.add(teleport);
					nbPowerChoosenJ2++;
					btnPower4Player2.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					//System.out.println(al2.get(nbPowerChoosenJ2).getDescription2());
				}
				else if((al2.get(0).getName().equals("Teleport")||al2.get(1).getName().equals("Teleport")) ) {
					al2.remove(teleport);
					nbPowerChoosenJ2--;
					btnPower4Player2.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
					//System.out.println(nbPowerChoosenJ2+1);
				}
			}	
		});
		btnPower5Player2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbPowerChoosenJ2<2 && al2.contains(twoMoves)==false) {
					al2.add(twoMoves);
					nbPowerChoosenJ2++;
					btnPower5Player2.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					//System.out.println(al2.get(nbPowerChoosenJ2).getDescription2());
				}
				else if((al2.get(0).getName().equals("Two moves")||al2.get(1).getName().equals("Two moves")) ) {
					al2.remove(twoMoves);
					nbPowerChoosenJ2--;
					btnPower5Player2.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
					//System.out.println(nbPowerChoosenJ2+1);
				}
			}
		});
				
		
		btnPower1Player3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbPowerChoosenJ3<2 && al3.contains(jump)==false) {
					al3.add(jump);
					nbPowerChoosenJ3++;
					btnPower1Player3.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					//System.out.println(al3.get(nbPowerChoosenJ3).getDescription2());
				}
				else if((al3.get(0).getName().equals("Jump")||al3.get(1).getName().equals("Jump")) ) {
					al3.remove(jump);
					nbPowerChoosenJ3--;
					btnPower1Player3.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
					//System.out.println(nbPowerChoosenJ3+1);
				}
			}
		});
		btnPower2Player3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbPowerChoosenJ3<2 && al3.contains(freeze)==false) {
					al3.add(freeze);
					nbPowerChoosenJ3++;
					btnPower2Player3.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					//System.out.println(al3.get(nbPowerChoosenJ3).getDescription2());
				}
				else if((al3.get(0).getName().equals("Freeze")||al3.get(1).getName().equals("Freeze")) ) {
					al3.remove(freeze);
					nbPowerChoosenJ3--;
					btnPower2Player3.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
					//System.out.println(nbPowerChoosenJ3+1);
				}
			}
		});
		btnPower3Player3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbPowerChoosenJ3<2 && al3.contains(control)==false) {
					al3.add(control);
					nbPowerChoosenJ3++;
					btnPower3Player3.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					//System.out.println(al3.get(nbPowerChoosenJ3).getDescription2());
				}
				else if((al3.get(0).getName().equals("Control")||al3.get(1).getName().equals("Control")) ) {
					al3.remove(control);
					nbPowerChoosenJ3--;
					btnPower3Player3.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
					//System.out.println(nbPowerChoosenJ3+1);
				}
			}
		});
		btnPower4Player3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbPowerChoosenJ3<2 && al3.contains(teleport)==false) {
					al3.add(teleport);
					nbPowerChoosenJ3++;
					btnPower4Player3.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					//System.out.println(al3.get(nbPowerChoosenJ3).getDescription2());
				}
				else if((al3.get(0).getName().equals("Teleport")||al3.get(1).getName().equals("Teleport")) ) {
					al3.remove(teleport);
					nbPowerChoosenJ3--;
					btnPower4Player3.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
					//System.out.println(nbPowerChoosenJ3+1);
				}
			}	
		});
		btnPower5Player3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbPowerChoosenJ3<2 && al3.contains(twoMoves)==false) {
					al3.add(twoMoves);
					nbPowerChoosenJ3++;
					btnPower5Player3.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					//System.out.println(al3.get(nbPowerChoosenJ3).getDescription2());
				}
				else if((al3.get(0).getName().equals("Two moves")||al3.get(1).getName().equals("Two moves")) ) {
					al3.remove(twoMoves);
					nbPowerChoosenJ3--;
					btnPower5Player3.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
					//System.out.println(nbPowerChoosenJ3+1);
				}
			}
		});
	}
	
}
