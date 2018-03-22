
package checker.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import checker.core.BoardUpdater;
import checker.core.CheckerBuilder;
import checker.core.GameVariableRepository;
import checker.core.VariableRepository;
import checker.data.ClassFactory;
import checker.data.Emplacement;
import checker.data.Piece;
import checker.data.Player;
import checker.data.TurnTimer;
import checker.gui.BoardParameter;
import checker.gui.GTParameters;
import customEventsPackage.Power;
import customEventsPackage.PowerControl;
import customEventsPackage.PowerFreeze;
import customEventsPackage.PowerTwoMoves;
import customEventsPackage.PowerJump;
import customEventsPackage.PowerTeleport;

import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;



public class Board extends JPanel {

	private Emplacement[][] emplacements;

	//private int xTempValue =0;
	// private int yTempValue =0;
	private boolean justPlayed = false;
	
	private static final int IDEAL_WIDTH=22;
	private static final int IDEAL_HEIGHT=22;
	
	private static JPanel control = new JPanel();
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static JTextField textField_3;
	private JProgressBar progressBar;
	private JPanel playersInternalPanel;
	private JDesktopPane desktopPane;
	private Box verticalBox;
	private Box horizontalBox;
	private Box horizontalBox_1;
	private Box horizontalBox_2;
	private JLabel labelProgressBarValue;
	private JLabel secondPlayerName;
	private JLabel firstPlayerName;
	private JLabel thirdPlayerName;
	private static JLabel labelPlayerActualTurn;
	private JButton btnPower1;
	private JButton btnAskMoveCorrection;
	private JButton btnSimulateClassicMove;
	private JButton btnPower2;
	private JButton btnSimulateSpecialMove;
	private JButton btnEndGame;
	private JPanel panel;
	private Timer gameTimer;
	JButton launchGameButton;
	private static JLabel powerActivated;
	
	private Piece pieceFrozen=null;
	private Piece pieceFrozen2=null;
	private Piece pieceFrozen3=null;
	private int roundFreeze;
	private int turnPlayerFreezer;
	private int roundFreeze2;
	private int turnPlayerFreezer2;
	private int roundFreeze3;
	private int turnPlayerFreezer3;
	
	private Graphics graphicContext;
	
	DefaultListModel<String> model = new DefaultListModel<>();
	JList<String> historicList;
	
	ExecutorService service = Executors.newSingleThreadExecutor();
	
	public static void startTime () {
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				textField_3.setText( Integer.valueOf(TurnTimer.getInstance().getTimeValue()).toString() );
				TurnTimer.getInstance().decrement();
				if ( TurnTimer.getInstance().getTimeValue() == 0 ) {
					TurnTimer.getInstance().restartTimer();
					GameVariableRepository.getInstance().incrementPlayerTurn();
					
					if ( GameVariableRepository.getInstance().getPlayerTurn() == 0 ) {
						labelPlayerActualTurn.setText(VariableRepository.getInstance().searchPlayer("Player 1").getPlayerName());						
					} else if ( GameVariableRepository.getInstance().getPlayerTurn() == 1 ) {
						labelPlayerActualTurn.setText(VariableRepository.getInstance().searchPlayer("Player 2").getPlayerName());
					} else {
						labelPlayerActualTurn.setText(VariableRepository.getInstance().searchPlayer("Player 3").getPlayerName());
					}
				}
			}
		};
		// Thread.sleep(2000);
		new Timer(1000, taskPerformer).start();
	}
	
	public Board() throws InterruptedException {
		super();
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				repaint();
			}
		});

		setLayout(null);
		
		initLayout();
		
		initActions();
	}
	
	
	
	public void modifyPlayerNamesGUI() {
		String firstPlayerName = VariableRepository.getInstance().searchPlayer("Player 1").getPlayerName();
		String secondPlayerName = VariableRepository.getInstance().searchPlayer("Player 2").getPlayerName();
		String thirdPlayerName = VariableRepository.getInstance().searchPlayer("Player 3").getPlayerName();
		if ( firstPlayerName.length() > 0 ) {
			this.firstPlayerName.setText(VariableRepository.getInstance().searchPlayer("Player 1").getPlayerName());
		}
		if ( secondPlayerName.length() > 0 ) {
			this.secondPlayerName.setText(VariableRepository.getInstance().searchPlayer("Player 2").getPlayerName());
		}
		if ( thirdPlayerName.length() > 0 ) {
			this.thirdPlayerName.setText(VariableRepository.getInstance().searchPlayer("Player 3").getPlayerName());
		}
	}
	
	public void initLayout () {
		TurnTimer.getInstance();	
		
		playersInternalPanel = new JPanel();
		playersInternalPanel.setBorder(new TitledBorder(null, "Players", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		playersInternalPanel.setBounds(861, 26, 138, 123);
		add(playersInternalPanel);
		playersInternalPanel.setLayout(null);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(6, 16, 126, 100);
		playersInternalPanel.add(desktopPane);
		desktopPane.setBackground(Color.WHITE);
		
		verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(0, 0, 135, 60);
		desktopPane.add(verticalBox);
		
		horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		// JLabel firstPlayerName = new JLabel( VariableRepository.getInstance().searchPlayer("Player 1").getPlayerName() );
		firstPlayerName = new JLabel("Player 1 : ");
		horizontalBox.add(firstPlayerName);
		
		textField = new JTextField();
		firstPlayerName.setLabelFor(textField);
		textField.setEnabled(false);
		textField.setEditable(false);
		horizontalBox.add(textField);
		textField.setColumns(10);
		
		horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		// JLabel lblNewLabel_1 = new JLabel( VariableRepository.getInstance().searchPlayer("Player 2").getPlayerName() );
		secondPlayerName = new JLabel("Player 2 : ");
		horizontalBox_1.add(secondPlayerName);
		
		textField_1 = new JTextField();
		secondPlayerName.setLabelFor(textField_1);
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		horizontalBox_1.add(textField_1);
		textField_1.setColumns(10);
		
		horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		// JLabel lblNewLabel_2 = new JLabel( VariableRepository.getInstance().searchPlayer("Player 3").getPlayerName() );
		thirdPlayerName  = new JLabel("Player 3 : ");
		horizontalBox_2.add(thirdPlayerName );
		
		textField_2 = new JTextField();
		thirdPlayerName.setLabelFor(textField_2);
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		horizontalBox_2.add(textField_2);
		textField_2.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Historic", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(35, 105, 204, 254);
		add(panel);
		panel.setLayout(null);
		
		model = new DefaultListModel<>();
		historicList = new JList<String>( model );
		historicList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		historicList.setValueIsAdjusting(true);
		historicList.setEnabled(false);
		historicList.setBounds(6, 16, 192, 227);
		 
		panel.add(historicList);
		
		
		btnPower1 = new JButton();
		btnPower1.setBackground(Color.white);
		btnPower1.setBounds(98, 435, 100, 100);
		btnPower1.setEnabled(false);
		add(btnPower1);
				
		btnPower2 = new JButton();
		btnPower2.setBackground(Color.white);
		btnPower2.setEnabled(false);
		btnPower2.setBounds(98, 565, 100, 100);
		add(btnPower2);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 34));
		textField_3.setBackground(Color.WHITE);
		textField_3.setEditable(false);
		textField_3.setBounds(35, 36, 204, 58);
		add(textField_3);
		textField_3.setColumns(2);
				
		btnAskMoveCorrection = new JButton("Ask correction");
		btnAskMoveCorrection.setBounds(35, 370, 204, 23);
		add(btnAskMoveCorrection);
		
		btnEndGame = new JButton("End Game");
		btnEndGame.setBounds(35, 405, 204, 23);
		add(btnEndGame);
		
		labelPlayerActualTurn = new JLabel("New label");
		labelPlayerActualTurn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelPlayerActualTurn.setBounds(863, 160, 128, 39);
		labelPlayerActualTurn.setForeground(Color.red);
		add(labelPlayerActualTurn);
		
		powerActivated=new JLabel("power");
		powerActivated.setFont(new Font("Tahoma", Font.PLAIN, 34));
		powerActivated.setForeground(Color.red);
		powerActivated.setBounds(370, 270, 500, 39);
		
		labelProgressBarValue = new JLabel("0");
		labelProgressBarValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelProgressBarValue.setBounds(938, 417, 29, 28);
		labelProgressBarValue.setComponentOrientation(getComponentOrientation());
		add(labelProgressBarValue);
		
		progressBar = new JProgressBar(SwingConstants.VERTICAL);
		// progressBar.setOrientation(SwingConstants.VERTICAL);
		labelProgressBarValue.setLabelFor(progressBar);
		progressBar.setForeground(new Color(0, 153, 255));
		progressBar.setBackground(Color.LIGHT_GRAY);
		progressBar.setBounds(928, 292, 36, 285);
		add(progressBar);
		
		launchGameButton = new JButton("Start Game !");
		launchGameButton.setBounds(531, 454, 159, 58);
		add(launchGameButton);
	}
	
	private class KeyResponse implements KeyListener{	
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			System.out.println(key);
		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			int key = e.getKeyCode();
			System.out.println(key);
		}

		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			int key = e.getKeyCode();
			System.out.println(key);
		}
	}
	
	public void updatePlayerMana (int playerTurn, double manaAmount) {
		String playerManaToUpdate = null;
		
		if ( playerTurn == 0 ) {
			playerManaToUpdate = "Player 1";
		} else if ( playerTurn == 1 ) {
			playerManaToUpdate = "Player 2";
		} else {
			playerManaToUpdate = "Player 3";
		}
		
		Player playerToUpdate = VariableRepository.getInstance().searchPlayer(playerManaToUpdate);
		playerToUpdate.addPlayerMana(manaAmount);
		playerToUpdate.getPlayerMana();
	}
	
	public void updateManaBarUI(int playerTurn) {
		String playerManaToUpdate = null;
		
		if ( playerTurn == 0 ) {
			playerManaToUpdate = "Player 1";
		} else if ( playerTurn == 1 ) {
			playerManaToUpdate = "Player 2";
		} else {
			playerManaToUpdate = "Player 3";
		}
		
		Player playerToUpdate = VariableRepository.getInstance().searchPlayer(playerManaToUpdate);
		progressBar.setValue( ( int ) playerToUpdate.getPlayerMana() );
	}
	
	public void initActions() throws InterruptedException {
		launchGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameVariableRepository.getInstance().setGameStarted(true);
				launchGameButton.setEnabled(false);
				launchGameButton.setVisible(false);
				repaint();
			}
		});
		
		//TODO stats en fin de partie
		btnEndGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				//if the player is not an AI
				if(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getIsAI()==false && GameVariableRepository.getInstance().getGameStarted()==true) {
					boolean isOnEmplacementTemp = false;//curseur sur empla
					boolean isOccupiedTemp = false;//piece sur empla
					boolean aPieceIsSelectedTemp = GameVariableRepository.getInstance().getAPieceIsSelected();
				// xTempValue = 0;
			    // yTempValue = 0;
			    // System.out.println("testSouris");
					ListIterator<Emplacement> iter = GameVariableRepository.getInstance().getEmplacementsArrayList().listIterator();
					if (GameVariableRepository.getInstance().getIsUpdating() == true ) {
						return;
					}
					while (iter.hasNext() && isOnEmplacementTemp == false ) {
			            Emplacement currentEmplacement = iter.next();
			            Piece currentPiece = currentEmplacement.getOccupyingPiece();
			            isOnEmplacementTemp = currentEmplacement.isCursorOnEmplacement(arg0.getX(), arg0.getY());
			            isOccupiedTemp = currentEmplacement.getIsOccupied();          
			            
			            //if a piece is frozen
			            if(pieceFrozen!=null) {
			            	//if the piece has been frozen for a whole round
			            	if((GameVariableRepository.getInstance().getNbRound()==roundFreeze+1) && (GameVariableRepository.getInstance().getPlayerTurn()==turnPlayerFreezer)) {		            		
		            			PowerFreeze.effectUndo(pieceFrozen);	
		            			pieceFrozen=null;
			            	}	
			            	else {
			            		pieceFrozen.setIsClickeable(false);
			            		pieceFrozen.setColor(Color.blue);
			            		repaint();
			            	}
			            }
			            if(pieceFrozen2!=null) {
			            	//if the piece has been frozen for a whole round
			            	if((GameVariableRepository.getInstance().getNbRound()==roundFreeze2+1) && (GameVariableRepository.getInstance().getPlayerTurn()==turnPlayerFreezer2)) {		            		
		            			PowerFreeze.effectUndo(pieceFrozen2);	
		            			pieceFrozen2=null;

			            	}	
			            	else {
			            		pieceFrozen2.setIsClickeable(false);
			            		pieceFrozen2.setColor(Color.blue);
			            		repaint();
			            	}
			            }
			            if(pieceFrozen3!=null) {
			            	//if the piece has been frozen for a whole round
			            	if((GameVariableRepository.getInstance().getNbRound()==roundFreeze3+1) && (GameVariableRepository.getInstance().getPlayerTurn()==turnPlayerFreezer3)) {		            		
		            			PowerFreeze.effectUndo(pieceFrozen3);	
		            			pieceFrozen3=null;
			            	}	
			            	else {
			            		pieceFrozen3.setIsClickeable(false);
			            		pieceFrozen3.setColor(Color.blue);
			            		repaint();
			            	}
			            }	            
			          
			            if ( isOnEmplacementTemp == true && isOccupiedTemp == true && aPieceIsSelectedTemp == false && currentPiece != null) {// && currentPiece.getIsClickeable() == true ) {
			            	
			            	//check if the power control is activated
		            		if(PowerControl.testControl(GameVariableRepository.getInstance().getActualPlayerName())==true) { 
		            			Power activated=VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPower(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPowerActivated());
		            			activated.effect(currentPiece);
		            			VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).setPowerActivated(9);
			            		model.addElement( GameVariableRepository.getInstance().getActualPlayerName() + " : " + "Control Power Used");

		            		}	            		
		            		
		            		//check if the power freeze is activated
		            		if(PowerFreeze.testFreeze(GameVariableRepository.getInstance().getActualPlayerName())==true) { 
		            			if(pieceFrozen==null) {
		            				pieceFrozen=currentPiece;
		            				roundFreeze=GameVariableRepository.getInstance().getNbRound();
		            				turnPlayerFreezer=GameVariableRepository.getInstance().getPlayerTurn();
		            				VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).setPowerActivated(9);
		            			}
		            			//if a piece is already frozen
		            			else if(pieceFrozen!=null && pieceFrozen2==null) {
		            				pieceFrozen2=currentPiece;
		            				roundFreeze2=GameVariableRepository.getInstance().getNbRound();
		            				turnPlayerFreezer2=GameVariableRepository.getInstance().getPlayerTurn();
		            				VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).setPowerActivated(9);
		            			}
		            			//if 2 pieces are already frozen
		            			else if(pieceFrozen!=null && pieceFrozen2!=null && pieceFrozen3==null) {
		            				pieceFrozen3=currentPiece;
		            				roundFreeze3=GameVariableRepository.getInstance().getNbRound();
		            				turnPlayerFreezer3=GameVariableRepository.getInstance().getPlayerTurn();
		            				VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).setPowerActivated(9);
		            			}
			            		model.addElement( GameVariableRepository.getInstance().getActualPlayerName() + " : " + "Freeze Power Used");

		            		}	            	
			            	
			            	if( currentPiece.getIsClickeable() == true ) {
			            		
			            		//check if the power 2moves is activated
			            		if(PowerTwoMoves.testTwoMoves(GameVariableRepository.getInstance().getActualPlayerName())==true) {
			            			Power activated=VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPower(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPowerActivated());
				            		activated.effect(currentPiece);
				            		VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).setPowerActivated(9);
				            		model.addElement( GameVariableRepository.getInstance().getActualPlayerName() + " : " + "Two Moves Power Used");
			            		}
			            		
			            		
				            	GameVariableRepository.getInstance().setPreviousTurnEmplacementsArrayList( GameVariableRepository.getInstance().getEmplacementsArrayList() );
				            	Piece pieceToBeSelected = currentEmplacement.getOccupyingPiece();
				            	
				            	BoardUpdater.getInstance().updatePieceSelectionState(pieceToBeSelected, currentEmplacement);
								
								validate();
								repaint();
					            
			            	}
			            } else if ( isOnEmplacementTemp == true && isOccupiedTemp == false && aPieceIsSelectedTemp == true) {// && currentEmplacement.ifIsEligibleForMove() == true ) {
			            	
			            	//check if the power jump is activated
			            		if(PowerJump.testJump(GameVariableRepository.getInstance().getActualPlayerName())==true) {
			            			if(currentEmplacement.ifIsEligibleForJump()) {
			            				model.addElement( GameVariableRepository.getInstance().getActualPlayerName() + " : " + "Jump Power Used");
				            			endTurn(currentEmplacement);
			            			}
			            		}
			            		
			            	//check if the power teleport is activated
			            		else if(PowerTeleport.testTeleport(GameVariableRepository.getInstance().getActualPlayerName())==true) { 
			            			model.addElement( GameVariableRepository.getInstance().getActualPlayerName() + " : " + "Teleport Power Used");
			            			endTurn(currentEmplacement);
			            		}	
			            		
			            		else if( isOnEmplacementTemp == true && isOccupiedTemp == false && aPieceIsSelectedTemp == true && currentEmplacement.ifIsEligibleForMove() == true ) {
			            			model.addElement( GameVariableRepository.getInstance().getActualPlayerName() + " : " + "Classic Move");
			            			endTurn(currentEmplacement);
			            		}
		            
			            }
			            //permet de selectionner un autre pion 
			            else if( isOnEmplacementTemp == true &&  isOccupiedTemp==true && aPieceIsSelectedTemp==true && currentEmplacement.ifIsEligibleForMove() == true) {
			            	BoardUpdater.getInstance().updatePieceDeselectionState(); 
			            }
				 }
			}
			}
		});
		
		this.addKeyListener(new KeyResponse());
		
		progressBar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				labelProgressBarValue.setText(Integer.valueOf(progressBar.getValue()).toString());
			}
		});
		
		
		// ==== Attention, utilisation des threads � cet endroit-l�
		
		
		btnAskMoveCorrection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Emplacement> toRefresh = GameVariableRepository.getInstance().getPreviousTurnEmplacementsArrayList();
				GameVariableRepository.getInstance().setEmplacementsArrayList(toRefresh);
				repaint();
			}
		});
		
		btnPower1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
					if(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPlayerMana()>=VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPower(0).getCost2()) {					
						updatePlayerMana(GameVariableRepository.getInstance().getPlayerTurn(), -VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPower(0).getCost2());
						updateManaBarUI(GameVariableRepository.getInstance().getPlayerTurn());
						VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).setPowerActivated(0);
						VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getStats().addPowerUsed();

						//affiche nom du pouvoir pendant 2secondes au milieu de l'�cran
						powerActivated.setText("Power "+VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPower(0).getName()+" Activated");				
						add(powerActivated);
						Timer t = new Timer(2000, new ActionListener() {
				            @Override
				            public void actionPerformed(ActionEvent e) {
				                powerActivated.setText(null);
				            }
				        });
				        t.setRepeats(false);
				        t.start();	
					}
			}
		});
		
		btnPower2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					if(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPlayerMana()>=VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPower(1).getCost2()) {					
						updatePlayerMana(GameVariableRepository.getInstance().getPlayerTurn(), -VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPower(1).getCost2());
						updateManaBarUI(GameVariableRepository.getInstance().getPlayerTurn());
						VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).setPowerActivated(1);
						VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getStats().addPowerUsed();

						powerActivated.setText("Power "+VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPower(1).getName()+" Activated");						
						add(powerActivated);
						Timer t = new Timer(2000, new ActionListener() {
				            @Override
				            public void actionPerformed(ActionEvent e) {
				                powerActivated.setText(null);
				            }
				        });
				        t.setRepeats(false);
				        t.start();	
					}
			}
		});
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.setColor(getBackground());
		g.fillRect(0, 0, GTParameters.WINDOW_WIDTH,GTParameters.WINDOW_HEIGHT);
		
		// g.setColor(getForeground());
		Image background = Toolkit.getDefaultToolkit().createImage("./background1.jpeg");
		g.drawImage(background, 0, 0, GTParameters.WINDOW_WIDTH, GTParameters.WINDOW_HEIGHT,null);
		
		// g.clearRect(0, 0, GTParameters.WINDOW_WIDTH, GTParameters.WINDOW_HEIGHT);
		// g.fillRect(0, 0, GTParameters.WINDOW_WIDTH, GTParameters.WINDOW_HEIGHT);
		graphicContext = this.getGraphics();
		
		
		this.modifyPlayerNamesGUI();
		// System.out.println("efzefze");
		//emplacements = new Emplacement[x][y];
		
		// Set up the checker board at first
		BoardUpdater.getInstance().drawCheckerBoardEmplacements(g);		
		
		BoardUpdater.getInstance().drawCheckerBoardVictoryEmplacements(g);

		// Set up the different pieces for all the players
		BoardUpdater.getInstance().drawPlayersPieces(g);
		
		BoardUpdater.getInstance().updatePlayerPowerButtons(btnPower1,btnPower2,labelPlayerActualTurn);
		
		// Update the Board with the right animations when a Piece is being selected or not
		BoardUpdater.getInstance().animateSelectedPiece(g);
		BoardUpdater.getInstance().animateAvailableEmplacement(g);
		GameVariableRepository.getInstance().updatePiecesState();
		
		labelPlayerActualTurn.setText(GameVariableRepository.getInstance().getActualPlayerName());
		//repaint();
	}
	
	public void endTurn(Emplacement currentEmplacement) {
		VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).setPowerActivated(9);
		Piece currentSelectedPiece = GameVariableRepository.getInstance().getSelectedPiece();
    	
		BoardUpdater.getInstance().updateAfterMovePieceState(currentSelectedPiece, currentEmplacement);
		
		
		//stats
		VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getStats().addTotalNumberOfMove();
		//System.out.println(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getStats().getTotalNumberOfMove());
		
		
		updatePlayerMana(GameVariableRepository.getInstance().getPlayerTurn(), 100);
		
		//model.addElement( GameVariableRepository.getInstance().getActualPlayerName() + " : " + "D�placement classique");
		//GameVariableRepository.getInstance().incrementPlayerTurn();//deplacer pour pouvoir control
	
		new Thread(new Runnable(){
			public void run(){
				Thread t = new Thread(new Runnable(){
					public void run(){
						GameVariableRepository.getInstance().setIsUpdating(true);
						Timer t = new Timer(2000, new ActionListener() {
				            @Override
				            public void actionPerformed(ActionEvent e) {
								GameVariableRepository.getInstance().incrementPlayerTurn();//deplacer au dessus
								GameVariableRepository.getInstance().updatePiecesState();
								updateManaBarUI(GameVariableRepository.getInstance().getPlayerTurn());
								labelPlayerActualTurn.setText(GameVariableRepository.getInstance().getActualPlayerName());
								labelPlayerActualTurn.setForeground(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getColor());
								GameVariableRepository.getInstance().setIsUpdating(false);
				            }
				        });
						
						t.setRepeats(false);
						t.start();
					}
				});
			
				if(SwingUtilities.isEventDispatchThread()) {
					t.start();
				} else {
					labelPlayerActualTurn.setText(GameVariableRepository.getInstance().getActualPlayerName());
					updateManaBarUI(GameVariableRepository.getInstance().getPlayerTurn());
					SwingUtilities.invokeLater(t);
				}
			}
		}).start();      

		repaint();
	}
}

