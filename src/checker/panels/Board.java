package checker.panels;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import checker.core.GameVariableRepository;
import checker.core.VariableRepository;
import checker.data.ClassFactory;
import checker.data.Player;
import checker.data.TurnTimer;
import checker.panels.Emplacement;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class Board extends JPanel {

	private Emplacement[][] emplacements;
	
	private final int x=30;
	private final int y=34;
	
	private int xTempValue =0;
	private int yTempValue =0;
	
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
	
	private static JLabel powerActivated;
	
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

		setLayout(null);
		
		initLayout();
		initActions();
		
		GameVariableRepository.getInstance();
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
		btnPower1.setBounds(414, 552, 100, 100);
		btnPower1.setEnabled(false);
		add(btnPower1);
				
		btnPower2 = new JButton();
		btnPower2.setBackground(Color.white);
		btnPower2.setEnabled(false);
		btnPower2.setBounds(549, 552, 100, 100);
		add(btnPower2);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 34));
		textField_3.setBackground(Color.WHITE);
		textField_3.setEditable(false);
		textField_3.setBounds(35, 36, 204, 58);
		add(textField_3);
		textField_3.setColumns(2);
		
		btnSimulateClassicMove = new JButton("Simulation coup classique");
		
		btnSimulateClassicMove.setBounds(69, 565, 170, 23);
		add(btnSimulateClassicMove);
		
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
		labelProgressBarValue.setBounds(519, 602, 29, 28);
		add(labelProgressBarValue);
		
		progressBar = new JProgressBar();
		labelProgressBarValue.setLabelFor(progressBar);
		progressBar.setForeground(new Color(0, 153, 255));
		progressBar.setBackground(Color.LIGHT_GRAY);
		progressBar.setBounds(373, 602, 300, 39);
		add(progressBar);
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
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				boolean isOnEmplacementTemp = false;
				xTempValue = arg0.getX();
			    yTempValue = arg0.getY();
			    int i = 0;
			    int j = 0;
			    /*
			    for ( i =0; i < emplacements.length; i++ ) {
			    	for ( j=0; j<emplacements.length; j++ ) {
			    		isOnEmplacementTemp = emplacements[i][j].isCursorOnEmplacement(xTempValue, yTempValue);
			    		if ( isOnEmplacementTemp == true ) {
			    			break;
			    		}
			    	} 
			    	if ( isOnEmplacementTemp == true ) {
		    			break;
		    		}
			    }
			    */
			    if ( isOnEmplacementTemp == true ) {
			    	System.out.println(" X : " + arg0.getX() + "\n" + "Y : " + arg0.getY() + "\n");
			    	System.out.println(" Emplacement [" + i + "][" + j + "]");
	    		}
			}
		});
		
		this.addKeyListener(new KeyResponse());
		
		progressBar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				labelProgressBarValue.setText(Integer.valueOf(progressBar.getValue()).toString());
			}
		});
		
		
		// ==== Attention, utilisation des threads à cet endroit-là
		btnSimulateSpecialMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// On met à jour l'attribut Mana du joueur
				updatePlayerMana(GameVariableRepository.getInstance().getPlayerTurn(), 50);
				
				new Thread(new Runnable(){
					public void run(){
						Thread t = new Thread(new Runnable(){
							public void run(){
								try {
									Thread.sleep(3000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								GameVariableRepository.getInstance().incrementPlayerTurn();
								updateManaBarUI(GameVariableRepository.getInstance().getPlayerTurn());
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
		
		btnSimulateClassicMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePlayerMana(GameVariableRepository.getInstance().getPlayerTurn(), 5);
				model.addElement("toucmymy");
				
				new Thread(new Runnable(){
					public void run(){
						Thread t = new Thread(new Runnable(){
							public void run(){
								try {
									Thread.sleep(3000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}	
								GameVariableRepository.getInstance().incrementPlayerTurn();
								updateManaBarUI(GameVariableRepository.getInstance().getPlayerTurn());
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
			}
		});
		
		btnPower1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ( GameVariableRepository.getInstance().getPlayerTurn() == 0 ) {
					if(VariableRepository.getInstance().searchPlayer("Player 1").getPlayerMana()>=VariableRepository.getInstance().searchPlayer("Player 1").getPower(0).getCost2()) {					
						VariableRepository.getInstance().searchPlayer("Player 1").addPlayerMana(-VariableRepository.getInstance().searchPlayer("Player 1").getPower(0).getCost2());
						progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer("Player 1").getPlayerMana() );
						
						//affiche nom du pouvoir pendant 2secondes au milieu de l'écran
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
					if(VariableRepository.getInstance().searchPlayer("Player 2").getPlayerMana()>=VariableRepository.getInstance().searchPlayer("Player 1").getPower(0).getCost2()) {					
						VariableRepository.getInstance().searchPlayer("Player 2").addPlayerMana(-VariableRepository.getInstance().searchPlayer("Player 2").getPower(0).getCost2());
						progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer("Player 2").getPlayerMana() );
						
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
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		graphicContext = g;
		
		graphicContext.drawOval( xTempValue, yTempValue, IDEAL_WIDTH, IDEAL_HEIGHT);
		
		repaint();
		
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		
		graphicContext = g;
		
		Player playerToUpdate = null;
		if (GameVariableRepository.getInstance().getPlayerTurn() == 0 ) {
			playerToUpdate = VariableRepository.getInstance().searchPlayer("Player 1");
			
			if(playerToUpdate.getPlayerMana()>=playerToUpdate.getPower(0).getCost2()){
				btnPower1.setBorder(BorderFactory.createLineBorder(Color.green, 4));
				btnPower1.setEnabled(true);
				
			}
			else {
				btnPower1.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				btnPower1.setEnabled(false);
			}
			if(playerToUpdate.getPlayerMana()>=playerToUpdate.getPower(1).getCost2()){
				btnPower2.setBorder(BorderFactory.createLineBorder(Color.green, 4));
				btnPower2.setEnabled(true);
			}
			else {				
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
				
			labelPlayerActualTurn.setText(playerToUpdate.getPlayerName());
		} 
			
			
			
		 else if ( GameVariableRepository.getInstance().getPlayerTurn() == 1 ) {
			playerToUpdate = VariableRepository.getInstance().searchPlayer("Player 2");
			
			
			if(playerToUpdate.getPlayerMana()>=playerToUpdate.getPower(0).getCost2()) {
				btnPower1.setBorder(BorderFactory.createLineBorder(Color.red, 4));
				btnPower1.setEnabled(true);
			}
			else {
				btnPower1.setBorder(BorderFactory.createLineBorder(Color.gray, 1));		
				btnPower1.setEnabled(false);
			}
			if(playerToUpdate.getPlayerMana()>=playerToUpdate.getPower(1).getCost2()) {
				btnPower2.setBorder(BorderFactory.createLineBorder(Color.red, 4));
				btnPower2.setEnabled(true);
			}
			else {
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
			
			labelPlayerActualTurn.setText(playerToUpdate.getPlayerName());
		} 
			
			
		 else {
			playerToUpdate = VariableRepository.getInstance().searchPlayer("Player 3");
			if(playerToUpdate.getPlayerMana()>=playerToUpdate.getPower(0).getCost2()) {
				btnPower1.setBorder(BorderFactory.createLineBorder(Color.yellow, 4));
				btnPower1.setEnabled(true);
			}
			else {
				btnPower1.setBorder(BorderFactory.createLineBorder(Color.gray, 1));		
				btnPower1.setEnabled(false);
			}
			if(playerToUpdate.getPlayerMana()>=playerToUpdate.getPower(1).getCost2()) {
				btnPower2.setBorder(BorderFactory.createLineBorder(Color.yellow, 4));
				btnPower2.setEnabled(true);
			}
			else {
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
			
			labelPlayerActualTurn.setText(playerToUpdate.getPlayerName());

		}
		
		/*if ( playerToUpdate != null ) {
			if ( playerToUpdate.getPlayerMana() < 50 ) {
				btnPower1.setEnabled(false);
			} else {
				btnPower1.setEnabled(true);
			}
			
			if ( playerToUpdate.getPlayerMana() < 80 ) {
				btnPower2.setEnabled(false);
			} else {
				btnPower2.setEnabled(true);
			}
		}*/
		
		this.modifyPlayerNamesGUI();
		emplacements = new Emplacement[x][y];
		
		/*if ( GameVariableRepository.getInstance().getPlayerTurn() == 0 ) {
			// System.out.println("test 1");
			labelPlayerActualTurn.setText(VariableRepository.getInstance().searchPlayer("Player 1").getPlayerName());
		} else if ( GameVariableRepository.getInstance().getPlayerTurn() == 1 ) {
			// System.out.println("test 2");
			labelPlayerActualTurn.setText(VariableRepository.getInstance().searchPlayer("Player 2").getPlayerName());
		} else {
			// System.out.println("test 3");
			labelPlayerActualTurn.setText(VariableRepository.getInstance().searchPlayer("Player 3").getPlayerName());
		}*/
		
		for(int indexX = 0; indexX <= x; indexX++ ) {
			
			for(int indexY = 0; indexY <= y; indexY++ ) {
				
				if( indexY%2 != 0) {
					
					//line 1 & 17
				
					if( ( (indexY == 1) || (indexY == 33) ) && ( (indexX == 10) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) ) ) {
						
						if(indexY ==  1) {
						
							emplacements[11][indexY] = new Emplacement( 11, indexY );
							g.drawOval(440 ,560 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(480 ,560 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY );
							g.drawOval(520 ,560, IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(560 ,560 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[19][indexY] = new Emplacement( 19, indexY );
							g.drawOval(600 ,560 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						}
						
						if(indexY == 33) {
							
							emplacements[11][indexY] = new Emplacement( 11, indexY );
							g.drawOval(440 ,0 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(480 ,0 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
							emplacements[13][indexY] = new Emplacement( 15, indexY );
							g.drawOval(520 ,0 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
							emplacements[15][indexY] = new Emplacement( 17, indexY );
							g.drawOval(560 ,0 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
							emplacements[17][indexY] = new Emplacement( 19, indexY );
							g.drawOval(600 ,0 , IDEAL_WIDTH, IDEAL_HEIGHT);
						}
					}
					
					//line 2 & 16
				
					if( ( (indexY == 3) || (indexY == 31) ) && ( (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) ) ) {	
						
						if(indexY == 3) {
						
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(460 ,525 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(500 ,525 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(540 ,525 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(580 ,525 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
						
						if(indexY == 31) {
							
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(460 ,35 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(500 ,35 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(540 ,35 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(580 ,35 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
						
					}
					
					//line 3 & 15
				
					if( ( (indexY == 5) || (indexY == 29) ) && ( (indexX == 4) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 23) ) ) {	
						
						if(indexY == 5) {
						
							emplacements[5][indexY] = new Emplacement( 5, indexY );
							g.drawOval(520 ,490 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(480 ,490 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY  );
							g.drawOval(560 ,490 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(320 ,490 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[24][indexY] = new Emplacement( 24, indexY );
							g.drawOval(720 ,490 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						}
						
						if(indexY == 29) {
							
							emplacements[5][indexY] = new Emplacement( 5, indexY );
							g.drawOval(520 ,70 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(480 ,70 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY  );
							g.drawOval(560 ,70 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(320 ,70 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[24][indexY] = new Emplacement( 24, indexY );
							g.drawOval(720 ,70 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
					}
					
					//line 4 & 14
						
					if( ( (indexY == 7) || (indexY == 27) ) && ( (indexX == 4) || (indexX == 6) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) || (indexX == 23) || (indexX == 25) ) ) {	
						
						if(indexY == 7) {
						
							emplacements[4][indexY] = new Emplacement( 4, indexY );
							g.drawOval(460 ,455 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[6][indexY] = new Emplacement( 6, indexY );
							g.drawOval(500 ,455 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(540 ,455 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(580 ,455 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(300 ,455 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(340 ,455 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[23][indexY] = new Emplacement( 23, indexY );
							g.drawOval(700 ,455 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[25][indexY] = new Emplacement( 25, indexY );
							g.drawOval(740 ,455 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						}
						
						if(indexY == 27) {
							
							emplacements[4][indexY] = new Emplacement( 4, indexY );
							g.drawOval(460 ,105 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[6][indexY] = new Emplacement( 6, indexY );
							g.drawOval(500 ,105 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(540 ,105 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(580 ,105 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(300 ,105 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(340 ,105 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[23][indexY] = new Emplacement( 23, indexY );
							g.drawOval(700 ,105 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[25][indexY] = new Emplacement( 25, indexY );
							g.drawOval(740 ,105 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
						
					}
					
					//line 5 & 13
					
					if( ( (indexY == 9) || (indexY == 25) ) && ( (indexX == 3) || (indexX == 5) || (indexX == 7) || (indexX == 9) || (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) || (indexX == 19) || (indexX ==  21) || (indexX == 23) || (indexX  == 25) || (indexX == 27) ) ) {	
						
						if(indexY == 9) {
													
							emplacements[3][indexY] = new Emplacement( 3, indexY );
							g.drawOval(280 ,420 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[5][indexY] = new Emplacement( 5, indexY );
							g.drawOval(320 ,420 , IDEAL_WIDTH, IDEAL_HEIGHT);
					
							emplacements[7][indexY] = new Emplacement( 7, indexY );
							g.drawOval(360 ,420 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[9][indexY] = new Emplacement( 9, indexY );
							g.drawOval(400 ,420 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[11][indexY] = new Emplacement( 11, indexY );
							g.drawOval(440 ,420 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(480 ,420 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY );
							g.drawOval(520 ,420 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(560 ,420 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[19][indexY] = new Emplacement( 19, indexY );
							g.drawOval(600 ,420 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[21][indexY] = new Emplacement( 21, indexY );
							g.drawOval(640 ,420 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[23][indexY] = new Emplacement( 23, indexY );
							g.drawOval(680 ,420 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[25][indexY] = new Emplacement( 25, indexY );
							g.drawOval(720 ,420 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[27][indexY] = new Emplacement( 27, indexY );
							g.drawOval(760 ,420 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
						
						if(indexY == 25) {
							
							emplacements[3][indexY] = new Emplacement( 3, indexY );
							g.drawOval(280 ,140 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[5][indexY] = new Emplacement( 5, indexY );
							g.drawOval(320 ,140 , IDEAL_WIDTH, IDEAL_HEIGHT);
					
							emplacements[7][indexY] = new Emplacement( 7, indexY );
							g.drawOval(360 ,140 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[9][indexY] = new Emplacement( 9, indexY );
							g.drawOval(400 ,140 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[11][indexY] = new Emplacement( 11, indexY );
							g.drawOval(440 ,140 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(480 ,140 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY );
							g.drawOval(520 ,140 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(560 ,140 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[19][indexY] = new Emplacement( 19, indexY );
							g.drawOval(600 ,140 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[21][indexY] = new Emplacement( 21, indexY );
							g.drawOval(640 ,140 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[23][indexY] = new Emplacement( 23, indexY );
							g.drawOval(680 ,140 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[25][indexY] = new Emplacement( 25, indexY );
							g.drawOval(720 ,140 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[27][indexY] = new Emplacement( 27, indexY );
							g.drawOval(760 ,140 , IDEAL_WIDTH, IDEAL_HEIGHT);
						}
						
					}
					
					//line 6 & 12
					
					if( ( (indexY == 11) || (indexY == 23) ) && ( (indexX == 2) || (indexX == 4) || (indexX == 6) || (indexX == 8) || (indexX == 10) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) || (indexX == 20) || (indexX  == 22) || (indexX == 24) || (indexX == 26) || (indexX == 28) ) ) {	
						
						if(indexY == 11) {
						
							emplacements[2][indexY] = new Emplacement( 2, indexY );
							g.drawOval(260 ,385 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[4][indexY] = new Emplacement( 4, indexY );
							g.drawOval(300 ,385 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[6][indexY] = new Emplacement( 6, indexY );
							g.drawOval(340 ,385 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[8][indexY] = new Emplacement( 8, indexY );
							g.drawOval(380 ,385 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[10][indexY] = new Emplacement( 10, indexY );
							g.drawOval(420 ,385 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(460 ,385 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(500 ,385 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(540 ,385 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(580 ,385 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[20][indexY] = new Emplacement( 20, indexY );
							g.drawOval(620 ,385 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[22][indexY] = new Emplacement( 22, indexY );
							g.drawOval(660 ,385 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[24][indexY] = new Emplacement( 24, indexY );
							g.drawOval(700 ,385 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[26][indexY] = new Emplacement( 26, indexY );
							g.drawOval(740 ,385 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[28][indexY] = new Emplacement( 28, indexY );
							g.drawOval(780 ,385 , IDEAL_WIDTH, IDEAL_HEIGHT);
						}
						
						if(indexY == 23) {
							
							emplacements[2][indexY] = new Emplacement( 2, indexY );
							g.drawOval(260 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[4][indexY] = new Emplacement( 4, indexY );
							g.drawOval(300 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[6][indexY] = new Emplacement( 6, indexY );
							g.drawOval(340 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[8][indexY] = new Emplacement( 8, indexY );
							g.drawOval(380 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[10][indexY] = new Emplacement( 10, indexY );
							g.drawOval(420 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(460 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(500 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(540 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(580 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[20][indexY] = new Emplacement( 20, indexY );
							g.drawOval(620 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[22][indexY] = new Emplacement( 22, indexY );
							g.drawOval(660 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[24][indexY] = new Emplacement( 24, indexY );
							g.drawOval(700 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[26][indexY] = new Emplacement( 26, indexY );
							g.drawOval(740 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[28][indexY] = new Emplacement( 28, indexY );
							g.drawOval(780 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
					}
					
					//line 7 & 11
					
					if( ( (indexY == 13) || (indexY == 21) ) && ( (indexX == 1) || (indexX == 3) || (indexX == 5) || (indexX == 7) || (indexX == 9) || (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) || (indexX == 19) || (indexX == 21) || (indexX == 23) || (indexX == 25) || (indexX == 27) || (indexX == 29) ) ) {	
						
						if(indexY == 13) {
						
							emplacements[1][indexY] = new Emplacement( 1, indexY );
							g.drawOval(240 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[3][indexY] = new Emplacement( 3, indexY );
							g.drawOval(280 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[5][indexY] = new Emplacement( 5, indexY );
							g.drawOval(320 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[7][indexY] = new Emplacement( 7, indexY );
							g.drawOval(360 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[9][indexY] = new Emplacement( 9, indexY );
							g.drawOval(400 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[11][indexY] = new Emplacement( 11, indexY );
							g.drawOval(440 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(480 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY );
							g.drawOval(520 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(560 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[19][indexY] = new Emplacement( 19, indexY );
							g.drawOval(600 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[21][indexY] = new Emplacement( 21, indexY );
							g.drawOval(640 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[23][indexY] = new Emplacement( 23, indexY );
							g.drawOval(680 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[25][indexY] = new Emplacement( 25, indexY );
							g.drawOval(720 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[27][indexY] = new Emplacement( 27, indexY );
							g.drawOval(760 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[29][indexY] = new Emplacement( 29, indexY );
							g.drawOval(800 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						}
						
						if(indexY == 21) {
						
							emplacements[1][indexY] = new Emplacement( 1, indexY );
							g.drawOval(240 ,210 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[3][indexY] = new Emplacement( 3, indexY );
							g.drawOval(280 ,210 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[5][indexY] = new Emplacement( 5, indexY );
							g.drawOval(320 ,210 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[7][indexY] = new Emplacement( 7, indexY );
							g.drawOval(360 ,210 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[9][indexY] = new Emplacement( 9, indexY );
							g.drawOval(400 ,210 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[11][indexY] = new Emplacement( 11, indexY );
							g.drawOval(440 ,210 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(480 ,210 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY );
							g.drawOval(520 ,210 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(560 ,210 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[19][indexY] = new Emplacement( 19, indexY );
							g.drawOval(600 ,210 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[21][indexY] = new Emplacement( 21, indexY );
							g.drawOval(640 ,210 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[23][indexY] = new Emplacement( 23, indexY );
							g.drawOval(680 ,210 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[25][indexY] = new Emplacement( 25, indexY );
							g.drawOval(720 ,210 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[27][indexY] = new Emplacement( 27, indexY );
							g.drawOval(760 ,210 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[29][indexY] = new Emplacement( 29, indexY );
							g.drawOval(800 ,210 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
					}
					
					//line 8 & 10
					
					if( ( (indexY == 15) || (indexY == 19) ) && ( (indexX == 6) || (indexX == 8) || (indexX == 10) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) || (indexX == 20) || (indexX == 22) || (indexX == 24) ) ) {
						
						if(indexY == 15) {
						
							emplacements[6][indexY] = new Emplacement( 6, indexY );
							g.drawOval(340 ,315 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[8][indexY] = new Emplacement( 8, indexY );
							g.drawOval(380 ,315 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[10][indexY] = new Emplacement( 10, indexY );
							g.drawOval(420 ,315 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(460 ,315 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(500 ,315 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(540 ,315 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(580 ,315 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[20][indexY] = new Emplacement( 20, indexY );
							g.drawOval(620 ,315 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[22][indexY] = new Emplacement( 22, indexY );
							g.drawOval(660 ,315 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[24][indexY] = new Emplacement( 24, indexY );
							g.drawOval(700 ,315 , IDEAL_WIDTH, IDEAL_HEIGHT);
						}
						
						if(indexY == 19) {
							
							emplacements[6][indexY] = new Emplacement( 6, indexY );
							g.drawOval(340 ,245 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[8][indexY] = new Emplacement( 8, indexY );
							g.drawOval(380 ,245 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[10][indexY] = new Emplacement( 10, indexY );
							g.drawOval(420 ,245 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(460 ,245 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(500 ,245 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(540 ,245 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(580 ,245 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[20][indexY] = new Emplacement( 20, indexY );
							g.drawOval(620 ,245 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[22][indexY] = new Emplacement( 22, indexY );
							g.drawOval(660 ,245 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[24][indexY] = new Emplacement( 24, indexY );
							g.drawOval(700 ,245 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
					}
					
					//line 9
					
					if( (indexY == 17) && ( (indexX == 7) || (indexX == 9) || (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) || (indexX == 19) || (indexX == 21) || (indexX == 23) ) ) {
						
						emplacements[7][indexY] = new Emplacement( 7, indexY );
						g.drawOval(360 ,280 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[9][indexY] = new Emplacement( 9, indexY );
						g.drawOval(400 ,280 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[11][indexY] = new Emplacement( 11, indexY );
						g.drawOval(440 ,280 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[13][indexY] = new Emplacement( 13, indexY );
						g.drawOval(480 ,280 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[15][indexY] = new Emplacement( 15, indexY );
						g.drawOval(520 ,280 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[17][indexY] = new Emplacement( 17, indexY );
						g.drawOval(560 ,280 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[19][indexY] = new Emplacement( 19, indexY );
						g.drawOval(600 ,280 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[21][indexY] = new Emplacement( 21, indexY );
						g.drawOval(640 ,280 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[23][indexY] = new Emplacement( 23, indexY );
						g.drawOval(680 ,280 , IDEAL_WIDTH, IDEAL_HEIGHT);
					}
				}
			}
		}
		 repaint();
	}
}



