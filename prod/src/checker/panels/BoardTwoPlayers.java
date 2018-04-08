package checker.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.JProgressBar;
import javax.swing.JDesktopPane;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ListSelectionModel;

import checker.core.BoardUpdater;
import checker.core.GameVariableRepository;
import checker.core.VariableRepository;
import checker.data.Ai;
import checker.data.Emplacement;
import checker.data.Piece;
import checker.data.Player;
import checker.gui.GTParameters;
import customEventsPackage.Power;
import customEventsPackage.PowerControl;
import customEventsPackage.PowerFreeze;
import customEventsPackage.PowerTwoMoves;
import customEventsPackage.PowerJump;
import customEventsPackage.PowerTeleport;

import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class BoardTwoPlayers extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
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
	private static JLabel labelPlayerActualTurn;
	private JButton btnPower1;
	private JButton btnAskMoveCorrection;
	private JButton btnPower2;
	private JButton playAi;
	private JPanel panel;
	JButton launchGameButton;
	private static JLabel powerActivated;
	
	private Piece pieceFrozen=null;
	private Piece pieceFrozen2=null;
	private int roundFreeze;
	private int turnPlayerFreezer;
	private int roundFreeze2;
	private int turnPlayerFreezer2;

	private Emplacement randomEmplacementToGo;
	//for correction asked
	private Emplacement initialEmplacement;
	private Emplacement finalEmplacement;
	private Piece movedPiece;
	private String typeOfLastMove;
	private boolean specialMoveDone=false;
		
	private Graphics graphicContext;
	
	DefaultListModel<String> model = new DefaultListModel<>();
	JList<String> historicList;
	
	ExecutorService service = Executors.newSingleThreadExecutor();
	
	public BoardTwoPlayers() throws InterruptedException {
		super();

		setLayout(null);
		
		initLayout();
		
		initActions();
	}
	
	public void modifyPlayerNamesGUI() {
		String firstPlayerName = VariableRepository.getInstance().searchPlayer("Player 1").getPlayerName();
		String secondPlayerName = VariableRepository.getInstance().searchPlayer("Player 2").getPlayerName();
		if ( firstPlayerName.length() > 0 ) {
			this.firstPlayerName.setText(VariableRepository.getInstance().searchPlayer("Player 1").getPlayerName());
		}
		if ( secondPlayerName.length() > 0 ) {
			this.secondPlayerName.setText(VariableRepository.getInstance().searchPlayer("Player 2").getPlayerName());
		}
	}
	
	public void initLayout () {
		
		playersInternalPanel = new JPanel();
		playersInternalPanel.setBorder(new TitledBorder(null, "Players", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		playersInternalPanel.setBounds(861, 26, 138, 123);
		add(playersInternalPanel);
		playersInternalPanel.setLayout(null);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(6, 16, 126, 100);
		playersInternalPanel.add(desktopPane);
		desktopPane.setBackground(Color.red);
		desktopPane.setBorder(null);
		desktopPane.setOpaque(false);
		
		verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(0, 0, 125, 100);
		verticalBox.setOpaque(false);
		verticalBox.setBorder(null);
		desktopPane.add(verticalBox);
			
		horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(0, 0, 135, 200);
		horizontalBox.setOpaque(false);
		horizontalBox.setBorder(null);

		verticalBox.add(horizontalBox);
		
		firstPlayerName = new JLabel("Player 1 : ");
		firstPlayerName.setForeground(Color.red);
		horizontalBox.add(firstPlayerName);
		
		textField = new JTextField();
		firstPlayerName.setLabelFor(textField);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBorder(null);

		horizontalBox.add(textField);
		textField.setColumns(10);
		
		horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		// JLabel lblNewLabel_1 = new JLabel( VariableRepository.getInstance().searchPlayer("Player 2").getPlayerName() );
		secondPlayerName = new JLabel("Player 2 : ");
		secondPlayerName.setForeground(Color.orange);

		horizontalBox_1.add(secondPlayerName);
		
		textField_1 = new JTextField();
		secondPlayerName.setLabelFor(textField_1);
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setBorder(null);
		horizontalBox_1.add(textField_1);
		textField_1.setColumns(10);
		
		horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
			
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
		
		playAi = new JButton("Play for AI");
		playAi.setBounds(35, 405, 204, 23);
		playAi.setEnabled(false);
		add(playAi);
				
		btnAskMoveCorrection = new JButton("Ask correction");
		btnAskMoveCorrection.setBounds(35, 370, 204, 23);
		add(btnAskMoveCorrection);
		
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
		labelProgressBarValue.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelProgressBarValue.setBounds(938, 587, 39, 28);
		labelProgressBarValue.setComponentOrientation(getComponentOrientation());
		add(labelProgressBarValue);
		
		progressBar = new JProgressBar(SwingConstants.VERTICAL);
		labelProgressBarValue.setLabelFor(progressBar);
		progressBar.setForeground(new Color(0, 153, 255));
		progressBar.setBackground(Color.LIGHT_GRAY);
		progressBar.setBounds(928, 292, 36, 285);
		add(progressBar);
		
		launchGameButton = new JButton("Start Game !");
		launchGameButton.setBounds(500, 325, 159, 58);
		add(launchGameButton);
	}
	
	
	public void updatePlayerMana (int playerTurn, double manaAmount) {
		String playerManaToUpdate = null;
		
		if ( playerTurn == 0 ) {
			playerManaToUpdate = "Player 1";
		} else {
			playerManaToUpdate = "Player 2";
		} 
		
		Player playerToUpdate = VariableRepository.getInstance().searchPlayer(playerManaToUpdate);
		playerToUpdate.addPlayerMana(manaAmount);
		playerToUpdate.getPlayerMana();
	}
	
	public void updateManaBarUI(int playerTurn) {
		String playerManaToUpdate = null;
		
		if ( playerTurn == 0 ) {
			playerManaToUpdate = "Player 1";
		} else {
			playerManaToUpdate = "Player 2";
		}
		
		Player playerToUpdate = VariableRepository.getInstance().searchPlayer(playerManaToUpdate);
		progressBar.setValue( ( int ) playerToUpdate.getPlayerMana() );
	}
	
	//remove the first half of the historic list when it's full
	public void manageHistoricList() {
		if(model.getSize()>=12) {
			for(int i=0;i<6;i++) {
				model.removeElementAt(i);
			}
		}
	}
	
	public void aiMove() {
		Ai ai=new Ai();
		randomEmplacementToGo=ai.randomSelection();
		playAi.setEnabled(false);
		model.addElement(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPlayerName() + " AI moved");
    	VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getStats().addTotalNumberOfMove();
		endTurn(randomEmplacementToGo);
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
		
		playAi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getIsAI()==true && GameVariableRepository.getInstance().getGameStarted()==true) {
					playAi.setEnabled(true);
					aiMove();
				}
			}
		});
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				GameVariableRepository.getInstance().stringSecondVictory();
				GameVariableRepository.getInstance().stringThirdVictory();
				
				//if the player is not an AI
				if(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getIsAI()==false && GameVariableRepository.getInstance().getGameStarted()==true) {
					boolean isOnEmplacementTemp = false;
					boolean isOccupiedTemp = false;
					boolean aPieceIsSelectedTemp = GameVariableRepository.getInstance().getAPieceIsSelected();

					manageHistoricList();
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
			          
			            if ( isOnEmplacementTemp == true && isOccupiedTemp == true&& currentPiece != null) {
			            	
			            	//check if the power control is activated
		            		if(PowerControl.testControl(GameVariableRepository.getInstance().getActualPlayerName())==true) { 
		            			Power activated=VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPower(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPowerActivated());
		            			activated.effect(currentPiece);
		            			VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).setPowerActivated(9);
			            		model.addElement(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPlayerName() + " : " + "Control Power Used");

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
			            		model.addElement(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPlayerName() + " : " + "Freeze Power Used");
		            		}	            	
			            	
			            	if( currentPiece.getIsClickeable() == true ) {
			            		
			            		//check if the power 2moves is activated
			            		if(PowerTwoMoves.testTwoMoves(GameVariableRepository.getInstance().getActualPlayerName())==true) {
			            			Power activated=VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPower(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPowerActivated());
				            		activated.effect(currentPiece);
				            		VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).setPowerActivated(9);
				            		model.addElement(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPlayerName() + " : " + "Two Moves Power Used");
			            		}
			            		            		
				            	GameVariableRepository.getInstance().setPreviousTurnEmplacementsArrayList( GameVariableRepository.getInstance().getEmplacementsArrayList() );
				            	Piece pieceToBeSelected = currentEmplacement.getOccupyingPiece();
				            	
				            	BoardUpdater.getInstance().updatePieceSelectionState(pieceToBeSelected, currentEmplacement);
								
				            	
				            	initialEmplacement=currentEmplacement;
								movedPiece=pieceToBeSelected;
								
								validate();
								repaint();
					            
			            	}
			            } else if ( isOnEmplacementTemp == true && isOccupiedTemp == false && aPieceIsSelectedTemp == true) {// && currentEmplacement.ifIsEligibleForMove() == true ) {
			            	
			            	//check if the power jump is activated
			            		if(PowerJump.testJump(GameVariableRepository.getInstance().getActualPlayerName())==true) {
			            			if(currentEmplacement.ifIsEligibleForJump()) {
			            				model.addElement(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPlayerName() + " : " + "Jump Power Used");
			            		    	model.addElement( VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPlayerName() + " : " + "Special Move");
			            		    	VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getStats().addSpecialMove();	
			            		    	VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getStats().addTotalNumberOfMove();
			            				endTurn(currentEmplacement);
			            			}
			            		}
			            		
			            	//check if the power teleport is activated
			            		else if(PowerTeleport.testTeleport(GameVariableRepository.getInstance().getActualPlayerName())==true) { 
			            			model.addElement(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPlayerName() + " : " + "Teleport Power Used"); 
			            	    	model.addElement(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPlayerName() + " : " + "Special Move");
			            	    	VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getStats().addSpecialMove();	
			            	    	VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getStats().addTotalNumberOfMove();
			            			endTurn(currentEmplacement);
			            		}				            		
			            		else if( isOnEmplacementTemp == true && isOccupiedTemp == false && aPieceIsSelectedTemp == true && currentEmplacement.ifIsEligibleForMove() == true ) {
			            			if( ( currentEmplacement.isSpecialMove(currentEmplacement) && GameVariableRepository.getInstance().getLastSpecialMoveEmplacement() != null && currentEmplacement.getPositionX() != GameVariableRepository.getInstance().getLastSpecialMoveEmplacement().getPositionX() && currentEmplacement.getPositionY() != GameVariableRepository.getInstance().getLastSpecialMoveEmplacement().getPositionY() ) || currentEmplacement.isSpecialMove(currentEmplacement) ) {
			            				
			            	    		model.addElement(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPlayerName() + " : " + "Special Move");
			            	    		VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getStats().addSpecialMove();	
			            				typeOfLastMove="special";
			            				Piece currentSelectedPiece = GameVariableRepository.getInstance().getSelectedPiece();
			            				BoardUpdater.getInstance().updateAfterMovePieceState(currentSelectedPiece, currentEmplacement);
			            				repaint();
			            				VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getStats().addTotalNumberOfMove();
			            				BoardUpdater.getInstance().animateSelectedPiece(graphicContext);
			            				specialMoveDone=true;
			            				GameVariableRepository.getInstance().setLastSpecialMoveEmplacement(initialEmplacement);
			            			} else if (!currentEmplacement.isSpecialMove(currentEmplacement) && specialMoveDone == false ) {
			            				model.addElement(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPlayerName() + " : " + "Classic Move");
			            	    		VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getStats().addSimpleMove();
			            				typeOfLastMove="classic";
			            				specialMoveDone=false;
			            				VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getStats().addTotalNumberOfMove();
			            				updatePlayerMana(GameVariableRepository.getInstance().getPlayerTurn(), 5);
			            				endTurn(currentEmplacement);
			            			} else {
			            				GameVariableRepository.getInstance().setAPieceIsSelected(false);
			            				GameVariableRepository.getInstance().setSelectedPiece(null);
			            				specialMoveDone=false;
			            				updatePlayerMana(GameVariableRepository.getInstance().getPlayerTurn(), 10);
			            				repaint();
			            				endTurnAfterSpecialMove(currentEmplacement);
			            			}
									finalEmplacement=currentEmplacement;
			            		}
			            }
				 }
			}
			}
		});
		
		progressBar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				labelProgressBarValue.setText(Integer.valueOf(progressBar.getValue()).toString());
			}
		});
		
				
		btnAskMoveCorrection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getPreviousPlayerName()).getIsBeginner()==true) {
					GameVariableRepository.getInstance().decrementPlayerTurnForCorrection();
					BoardUpdater.getInstance().updatePieceSelectionState(movedPiece, finalEmplacement);
					BoardUpdater.getInstance().updateAfterMovePieceState(movedPiece, initialEmplacement);
				
					labelPlayerActualTurn.setText(GameVariableRepository.getInstance().getActualPlayerName());
					labelPlayerActualTurn.setForeground(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getColor());
				
					//for stats
					if(typeOfLastMove=="classic") {
						VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getStats().substractSimpleMove();
						updatePlayerMana(GameVariableRepository.getInstance().getPlayerTurn(), -5);
						updateManaBarUI(GameVariableRepository.getInstance().getPlayerTurn());

					}
					else {
						VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getStats().substractSpecialMove();
						updatePlayerMana(GameVariableRepository.getInstance().getPlayerTurn(), -10);
						updateManaBarUI(GameVariableRepository.getInstance().getPlayerTurn());

					}
					VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getStats().substractTotalNumberOfMove();		
            		model.addElement(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPlayerName() + " : " + "Correction Asked");

					repaint();
				}
				else {
					setEnabled(false);
				}
			}		
		});
		
		btnPower1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
					if(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPlayerMana()>=VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPower(0).getCost2()) {					
						updatePlayerMana(GameVariableRepository.getInstance().getPlayerTurn(), -VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPower(0).getCost2());
						updateManaBarUI(GameVariableRepository.getInstance().getPlayerTurn());
						VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).setPowerActivated(0);
						VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getStats().addPowerUsed();

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
		
		Image background = Toolkit.getDefaultToolkit().createImage("./background1.jpeg");
		g.drawImage(background, 0, 0, GTParameters.WINDOW_WIDTH, GTParameters.WINDOW_HEIGHT,null);
		
		graphicContext = this.getGraphics();
		
		
		this.modifyPlayerNamesGUI();
		
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

		
		labelPlayerActualTurn.setText(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPlayerName());
		if (GameVariableRepository.getInstance().checkIfVictoryState2Players()) {
			VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getStats().setRank("First");
			GameVariableRepository.getInstance().incrementPlayerTurn();
			VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getStats().setRank("Second");
			PanelsContainer.getInstance().getCardLayout().next(PanelsContainer.getInstance());
		}
	}
	
	public void endTurn(Emplacement currentEmplacement) {
		VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).setPowerActivated(9);
		Piece currentSelectedPiece = GameVariableRepository.getInstance().getSelectedPiece();
    		
		BoardUpdater.getInstance().updateAfterMovePieceState(currentSelectedPiece, currentEmplacement);
		
		new Thread(new Runnable(){
			public void run(){
				Thread t = new Thread(new Runnable(){
					public void run(){
						GameVariableRepository.getInstance().setIsUpdating(true);
						Timer t = new Timer(1000, new ActionListener() {
				            @Override
				            public void actionPerformed(ActionEvent e) {
								GameVariableRepository.getInstance().incrementPlayerTurn();
								if(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getIsAI()==true) {
									playAi.setEnabled(true);
								}
								GameVariableRepository.getInstance().updatePiecesState();
								updateManaBarUI(GameVariableRepository.getInstance().getPlayerTurn());
								labelPlayerActualTurn.setText(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPlayerName());
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
					labelPlayerActualTurn.setText(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPlayerName());
					updateManaBarUI(GameVariableRepository.getInstance().getPlayerTurn());
					SwingUtilities.invokeLater(t);
				}
			}
		}).start();      
		repaint();
	}
	public void endTurnAfterSpecialMove(Emplacement currentEmplacement) {
		VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).setPowerActivated(9);
		
		new Thread(new Runnable(){
			public void run(){
				Thread t = new Thread(new Runnable(){
					public void run(){
						GameVariableRepository.getInstance().setIsUpdating(true);
						Timer t = new Timer(1000, new ActionListener() {
				            @Override
				            public void actionPerformed(ActionEvent e) {
								GameVariableRepository.getInstance().incrementPlayerTurn();
								if(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getIsAI()==true) {
									playAi.setEnabled(true);
								}
								GameVariableRepository.getInstance().updatePiecesState();
								updateManaBarUI(GameVariableRepository.getInstance().getPlayerTurn());
								labelPlayerActualTurn.setText(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPlayerName());
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
					labelPlayerActualTurn.setText(VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPlayerName());
					updateManaBarUI(GameVariableRepository.getInstance().getPlayerTurn());
					SwingUtilities.invokeLater(t);
				}
			}
		}).start();      
		repaint();
	}
}

