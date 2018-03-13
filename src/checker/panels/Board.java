package checker.panels;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DebugGraphics;
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

import javax.swing.JProgressBar;
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
import javax.swing.JScrollPane;



public class Board extends JPanel {

	private Emplacement[][] emplacements;

	private int xTempValue =0;
	private int yTempValue =0;
	private boolean justPlayed = false;
	
	private static final int IDEAL_WIDTH=22;
	private static final int IDEAL_HEIGHT=22;
	
	private static JPanel control = new JPanel();
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JProgressBar progressBar;
	private JPanel playersInternalPanel;
	private JDesktopPane desktopPane;
	private Box verticalBox;
	private Box horizontalBox;
	private Box horizontalBox_1 ;
	private JLabel secondPlayerName;
	private JLabel firstPlayerName;
	private Box horizontalBox_2;
	private JLabel thirdPlayerName;
	private JButton btnPower1;
	private static JTextField textField_3;
	private JButton btnAskMoveCorrection;
	private JButton btnSimulateClassicMove;
	private JPanel panel;
	private JButton btnPower2;
	private JButton btnSimulateSpecialMove;
	private static JLabel labelPlayerActualTurn;
	private JLabel labelProgressBarValue;
	private Timer gameTimer;
	JButton launchGameButton;
	private static JLabel powerActivated;
	
	private Graphics graphicContext;
	
	DefaultListModel<String> model = new DefaultListModel<>();
	JList<String> historicList;
	
	ExecutorService service = Executors.newSingleThreadExecutor();
	private JScrollPane scrollPane;
	
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 192, 227);
		panel.add(scrollPane);
		historicList = new JList<String>( model );
		scrollPane.setViewportView(historicList);
		historicList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		historicList.setValueIsAdjusting(true);
		historicList.setEnabled(false);
		
		btnPower1 = new JButton();
		btnPower1.setBackground(Color.white);
		btnPower1.setBounds(98, 435, 100, 100);
		btnPower1.setEnabled(false);
		add(btnPower1);
				
		btnPower2 = new JButton();
		btnPower2.setBackground(Color.white);
		btnPower2.setEnabled(false);
		btnPower2.setBounds(98, 665, 100, 100);
		add(btnPower2);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 34));
		textField_3.setBackground(Color.WHITE);
		textField_3.setEditable(false);
		textField_3.setBounds(35, 36, 204, 58);
		add(textField_3);
		textField_3.setColumns(2);
		
		/*
		btnSimulateClassicMove = new JButton("Simulation coup classique");
		
		btnSimulateClassicMove.setBounds(69, 565, 170, 23);
		add(btnSimulateClassicMove);
		*/
		btnSimulateSpecialMove = new JButton("Simulation coup sp\u00E9cial");
		
		btnSimulateSpecialMove.setBounds(69, 602, 170, 23);
		add(btnSimulateSpecialMove);
		
		btnAskMoveCorrection = new JButton("Demander retour");
	
		btnAskMoveCorrection.setBounds(35, 370, 204, 23);
		add(btnAskMoveCorrection);
		
		labelPlayerActualTurn = new JLabel("New label");
		labelPlayerActualTurn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelPlayerActualTurn.setBounds(836, 160, 128, 39);
		add(labelPlayerActualTurn);
		
		powerActivated=new JLabel("power");
		powerActivated.setFont(new Font("Tahoma", Font.PLAIN, 34));
		powerActivated.setForeground(Color.red);
		powerActivated.setBounds(370, 270, 500, 39);
		
		labelProgressBarValue = new JLabel("0");
		labelProgressBarValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelProgressBarValue.setBounds(935, 409, 29, 28);
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
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				boolean isOnEmplacementTemp = false;
				boolean isOccupiedTemp = false;
				boolean aPieceIsSelectedTemp = GameVariableRepository.getInstance().getAPieceIsSelected();
				// xTempValue = 0;
			    // yTempValue = 0;
			    int i = 0;
			    int j = 0;
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
		            
		            if ( isOnEmplacementTemp == true && isOccupiedTemp == true && aPieceIsSelectedTemp == false && currentPiece != null && currentPiece.getIsClickeable() == true ) {
		            	GameVariableRepository.getInstance().setPreviousTurnEmplacementsArrayList( GameVariableRepository.getInstance().getEmplacementsArrayList() );
		            	Piece pieceToBeSelected = currentEmplacement.getOccupyingPiece();
		            	
		            	BoardUpdater.getInstance().updatePieceSelectionState(pieceToBeSelected, currentEmplacement);
						
						validate();
						repaint();
			            
		            } else if ( isOnEmplacementTemp == true && isOccupiedTemp == false && aPieceIsSelectedTemp == true && currentEmplacement.ifIsEligibleForMove() == true ) {
		            	Piece currentSelectedPiece = GameVariableRepository.getInstance().getSelectedPiece();
		            	
		            	BoardUpdater.getInstance().updateAfterMovePieceState(currentSelectedPiece, currentEmplacement);
		            	
						updatePlayerMana(GameVariableRepository.getInstance().getPlayerTurn(), 5);
						
						model.addElement( GameVariableRepository.getInstance().getActualPlayerName() + " : " + "Déplacement classique");
						
						new Thread(new Runnable(){
							public void run(){
								Thread t = new Thread(new Runnable(){
									public void run(){
										GameVariableRepository.getInstance().setIsUpdating(true);
										Timer t = new Timer(3000, new ActionListener() {
								            @Override
								            public void actionPerformed(ActionEvent e) {
												btnSimulateSpecialMove.setEnabled(true);
												// btnSimulateClassicMove.setEnabled(true);
												GameVariableRepository.getInstance().incrementPlayerTurn();
												GameVariableRepository.getInstance().updatePiecesState();
												updateManaBarUI(GameVariableRepository.getInstance().getPlayerTurn());
												labelPlayerActualTurn.setText(GameVariableRepository.getInstance().getActualPlayerName());
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
						
						validate();
						repaint();
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
		
		
		// ==== Attention, utilisation des threads ï¿½ cet endroit-lï¿½
		btnSimulateSpecialMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// On met a jour l'attribut Mana du joueur
				updatePlayerMana(GameVariableRepository.getInstance().getPlayerTurn(), 50);
				btnSimulateSpecialMove.setEnabled(false);
				btnSimulateClassicMove.setEnabled(false);
				new Thread(new Runnable(){
					public void run(){
						Thread t = new Thread(new Runnable(){
							public void run(){
								Timer t = new Timer(3000, new ActionListener() {
						            @Override
						            public void actionPerformed(ActionEvent e) {
										btnSimulateSpecialMove.setEnabled(true);
										btnSimulateClassicMove.setEnabled(true);
										GameVariableRepository.getInstance().incrementPlayerTurn();
										updateManaBarUI(GameVariableRepository.getInstance().getPlayerTurn());
						            }
						        });
								 t.setRepeats(false);
							     t.start();
							}
						});
						
						if(SwingUtilities.isEventDispatchThread()) {
							t.start();
						} else {
							updateManaBarUI(GameVariableRepository.getInstance().getPlayerTurn());
							SwingUtilities.invokeLater(t);
						}
					}
				}).start();      
			}
		});
		
		btnAskMoveCorrection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Emplacement> toRefresh = GameVariableRepository.getInstance().getPreviousTurnEmplacementsArrayList();
				GameVariableRepository.getInstance().setEmplacementsArrayList(toRefresh);
				repaint();
				
			}
		});
		
		btnPower1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				String actualPlayerName = GameVariableRepository.getInstance().getActualPlayerName();
				
				if(VariableRepository.getInstance().searchPlayer(actualPlayerName).getPlayerMana()>=VariableRepository.getInstance().searchPlayer(actualPlayerName).getPower(0).getCost2()) {					
					VariableRepository.getInstance().searchPlayer(actualPlayerName).addPlayerMana(-VariableRepository.getInstance().searchPlayer(actualPlayerName).getPower(0).getCost2());
					progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer(actualPlayerName).getPlayerMana() );
					
					//affiche nom du pouvoir pendant 2secondes au milieu de l'ï¿½cran
					powerActivated.setText("Power "+VariableRepository.getInstance().searchPlayer(actualPlayerName).getPower(0).getName()+" Activated");				
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
				*/
				
				if ( GameVariableRepository.getInstance().getPlayerTurn() == 0 ) {
					if(VariableRepository.getInstance().searchPlayer("Player 1").getPlayerMana()>=VariableRepository.getInstance().searchPlayer("Player 1").getPower(0).getCost2()) {					
						VariableRepository.getInstance().searchPlayer("Player 1").addPlayerMana(-VariableRepository.getInstance().searchPlayer("Player 1").getPower(0).getCost2());
						progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer("Player 1").getPlayerMana() );
						
						model.addElement( GameVariableRepository.getInstance().getActualPlayerName() + " : " + VariableRepository.getInstance().searchPlayer("Player 1").getPower(0).getName());
						
						//affiche nom du pouvoir pendant 2secondes au milieu de l'ï¿½cran
						powerActivated.setText("Power "+VariableRepository.getInstance().searchPlayer("Player 1").getPower(0).getName()+" Activated");				
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
				} else if ( GameVariableRepository.getInstance().getPlayerTurn() == 1 ) {
					if(VariableRepository.getInstance().searchPlayer("Player 2").getPlayerMana()>=VariableRepository.getInstance().searchPlayer("Player 2").getPower(0).getCost2()) {					
						VariableRepository.getInstance().searchPlayer("Player 2").addPlayerMana(-VariableRepository.getInstance().searchPlayer("Player 2").getPower(0).getCost2());
						progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer("Player 2").getPlayerMana() );
						
						model.addElement( GameVariableRepository.getInstance().getActualPlayerName() + " : " + VariableRepository.getInstance().searchPlayer("Player 2").getPower(0).getName());
						
						powerActivated.setText("Power "+VariableRepository.getInstance().searchPlayer("Player 2").getPower(0).getName()+" Activated");						
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
				} else {
					if(VariableRepository.getInstance().searchPlayer("Player 3").getPlayerMana()>=VariableRepository.getInstance().searchPlayer("Player 3").getPower(0).getCost2()) {					
						VariableRepository.getInstance().searchPlayer("Player 3").addPlayerMana(-VariableRepository.getInstance().searchPlayer("Player 3").getPower(0).getCost2());
						progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer("Player 3").getPlayerMana() );
						
						model.addElement( GameVariableRepository.getInstance().getActualPlayerName() + " : " + VariableRepository.getInstance().searchPlayer("Player 3").getPower(0).getName());
						
						powerActivated.setText("Power "+VariableRepository.getInstance().searchPlayer("Player 3").getPower(0).getName()+" Activated");						
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
				
			}
		});
		
		btnPower2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ( GameVariableRepository.getInstance().getPlayerTurn() == 0 ) {
					if(VariableRepository.getInstance().searchPlayer("Player 1").getPlayerMana()>=VariableRepository.getInstance().searchPlayer("Player 1").getPower(1).getCost2()) {					
						VariableRepository.getInstance().searchPlayer("Player 1").addPlayerMana(-VariableRepository.getInstance().searchPlayer("Player 1").getPower(1).getCost2());
						progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer("Player 1").getPlayerMana() );
						
						powerActivated.setText("Power "+VariableRepository.getInstance().searchPlayer("Player 1").getPower(1).getName()+" Activated");						
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
				} else if ( GameVariableRepository.getInstance().getPlayerTurn() == 1 ) {
					if(VariableRepository.getInstance().searchPlayer("Player 2").getPlayerMana()>=VariableRepository.getInstance().searchPlayer("Player 1").getPower(1).getCost2()) {					
						VariableRepository.getInstance().searchPlayer("Player 2").addPlayerMana(-VariableRepository.getInstance().searchPlayer("Player 2").getPower(1).getCost2());
						progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer("Player 2").getPlayerMana() );
						
						powerActivated.setText("Power "+VariableRepository.getInstance().searchPlayer("Player 2").getPower(1).getName()+" Activated");						
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
				} else {
					if(VariableRepository.getInstance().searchPlayer("Player 3").getPlayerMana()>=VariableRepository.getInstance().searchPlayer("Player 3").getPower(1).getCost2()) {					
						VariableRepository.getInstance().searchPlayer("Player 3").addPlayerMana(-VariableRepository.getInstance().searchPlayer("Player 3").getPower(1).getCost2());
						progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer("Player 3").getPlayerMana() );
						
						powerActivated.setText("Power "+VariableRepository.getInstance().searchPlayer("Player 3").getPower(1).getName()+" Activated");						
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
			}
		});
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		setOpaque(true);
		// g.setColor(getBackground());
		// g.fillRect(0, 0, GTParameters.WINDOW_WIDTH,GTParameters.WINDOW_HEIGHT);
		// g.setColor(getForeground());
		// setOptimizedDrawing(true);
		// this.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
		
		// g.clearRect(0, 0, GTParameters.WINDOW_WIDTH, GTParameters.WINDOW_HEIGHT);
		// g.fillRect(0, 0, GTParameters.WINDOW_WIDTH, GTParameters.WINDOW_HEIGHT);
		graphicContext = this.getGraphics();
		
		Player playerToUpdate = null;
		if (GameVariableRepository.getInstance().getPlayerTurn() == 0 ) {
			playerToUpdate = VariableRepository.getInstance().searchPlayer("Player 1");
			
			if(playerToUpdate.getPlayerMana()>=playerToUpdate.getPower(0).getCost2()){
				btnPower1.setBorder(BorderFactory.createLineBorder(Color.green, 4));
				btnPower1.setEnabled(true);
				
			} else {
				btnPower1.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				btnPower1.setEnabled(false);
			}
			
			if(playerToUpdate.getPlayerMana()>=playerToUpdate.getPower(1).getCost2()){
				btnPower2.setBorder(BorderFactory.createLineBorder(Color.green, 4));
				btnPower2.setEnabled(true);
			} else {				
				btnPower2.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				btnPower2.setEnabled(false);
			}
			
			btnPower1.setToolTipText("<html><center>"+playerToUpdate.getPower(0).getName()+
					" power:<br>"+playerToUpdate.getPower(0).getDescription2()+
					"<br>cost:"+playerToUpdate.getPower(0).getCost2()+"</center></html>");
			btnPower2.setToolTipText("<html><center>"+playerToUpdate.getPower(1).getName()+
					" power:<br>"+playerToUpdate.getPower(1).getDescription2()+
					"<br>cost:"+playerToUpdate.getPower(1).getCost2()+"</center></html>");
			
			
			btnPower1.setIcon(new ImageIcon(playerToUpdate.getPower(0).getImage()));
			btnPower2.setIcon(new ImageIcon(playerToUpdate.getPower(1).getImage()));
				
		} else if ( GameVariableRepository.getInstance().getPlayerTurn() == 1 ) {
			playerToUpdate = VariableRepository.getInstance().searchPlayer("Player 2");
			
			if(playerToUpdate.getPlayerMana()>=playerToUpdate.getPower(0).getCost2()) {
				btnPower1.setBorder(BorderFactory.createLineBorder(Color.red, 4));
				btnPower1.setEnabled(true);
			} else {
				btnPower1.setBorder(BorderFactory.createLineBorder(Color.gray, 1));		
				btnPower1.setEnabled(false);
			}
			
			if(playerToUpdate.getPlayerMana()>=playerToUpdate.getPower(1).getCost2()) {
				btnPower2.setBorder(BorderFactory.createLineBorder(Color.red, 4));
				btnPower2.setEnabled(true);
			} else {
				btnPower2.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				btnPower2.setEnabled(false);
			}
			btnPower1.setIcon(new ImageIcon(playerToUpdate.getPower(0).getImage()));
			btnPower2.setIcon(new ImageIcon(playerToUpdate.getPower(1).getImage()));
			
			btnPower1.setToolTipText("<html><center>"+playerToUpdate.getPower(0).getName()+
					" power:<br>"+playerToUpdate.getPower(0).getDescription2()+
					"<br>cost:"+playerToUpdate.getPower(0).getCost2()+"</center></html>");
			btnPower2.setToolTipText("<html><center>"+playerToUpdate.getPower(1).getName()+
					" power:<br>"+playerToUpdate.getPower(1).getDescription2()+
					"<br>cost:"+playerToUpdate.getPower(1).getCost2()+"</center></html>");
			
		} else {
			playerToUpdate = VariableRepository.getInstance().searchPlayer("Player 3");
			
			if(playerToUpdate.getPlayerMana()>=playerToUpdate.getPower(0).getCost2()) {
				btnPower1.setBorder(BorderFactory.createLineBorder(Color.yellow, 4));
				btnPower1.setEnabled(true);
			} else {
				btnPower1.setBorder(BorderFactory.createLineBorder(Color.gray, 1));		
				btnPower1.setEnabled(false);
			}
			
			if(playerToUpdate.getPlayerMana()>=playerToUpdate.getPower(1).getCost2()) {
				btnPower2.setBorder(BorderFactory.createLineBorder(Color.yellow, 4));
				btnPower2.setEnabled(true);
			} else {
				btnPower2.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				btnPower2.setEnabled(false);
			}
						
			btnPower1.setIcon(new ImageIcon(playerToUpdate.getPower(0).getImage()));
			btnPower2.setIcon(new ImageIcon(playerToUpdate.getPower(1).getImage()));			
			
			btnPower1.setToolTipText("<html><center>"+playerToUpdate.getPower(0).getName()+
					" power:<br>"+playerToUpdate.getPower(0).getDescription2()+
					"<br>cost:"+playerToUpdate.getPower(0).getCost2()+"</center></html>");
			btnPower2.setToolTipText("<html><center>"+playerToUpdate.getPower(1).getName()+
					" power:<br>"+playerToUpdate.getPower(1).getDescription2()+
					"<br>cost:"+playerToUpdate.getPower(1).getCost2()+"</center></html>");
		}
		
		this.modifyPlayerNamesGUI();
		// System.out.println("efzefze");
		//emplacements = new Emplacement[x][y];
		
		// Set up the checker board at first
		BoardUpdater.getInstance().drawCheckerBoardEmplacements(g);		
		
		// Set up the different pieces for all the players
		BoardUpdater.getInstance().drawPlayersPieces(g);
		
		// Update the Board with the right animations when a Piece is being selected or not
		BoardUpdater.getInstance().animateSelectedPiece(g);
		
		GameVariableRepository.getInstance().updatePiecesState();
		
		labelPlayerActualTurn.setText(GameVariableRepository.getInstance().getActualPlayerName());
		// repaint();
	}
}



