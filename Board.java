package checker.panels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;



public class Board extends JPanel {

	private Emplacement[][] emplacements;
	
	private final int x=30;
	private final int y=34;
	
	private static final int IDEAL_WIDTH=37;
	private static final int IDEAL_HEIGHT=37;
	
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
	public void paint(Graphics g) {
		
		super.paint(g);
		this.modifyPlayerNamesGUI();
		emplacements = new Emplacement[x][y];
		
		System.out.println("test paint");
		
		if ( GameVariableRepository.getInstance().getPlayerTurn() == 0 ) {
			// System.out.println("test 1");
			labelPlayerActualTurn.setText(VariableRepository.getInstance().searchPlayer("Player 1").getPlayerName());
		} else if ( GameVariableRepository.getInstance().getPlayerTurn() == 1 ) {
			// System.out.println("test 2");
			labelPlayerActualTurn.setText(VariableRepository.getInstance().searchPlayer("Player 2").getPlayerName());
		} else {
			// System.out.println("test 3");
			labelPlayerActualTurn.setText(VariableRepository.getInstance().searchPlayer("Player 3").getPlayerName());
		}
		
		for(int indexX = 0; indexX <= x; indexX++ ) {
			
			for(int indexY = 0; indexY <= y; indexY++ ) {
				
				if( indexY%2 != 0) {
					
					//line 1 & 17
				
					if( ( (indexY == 1) || (indexY == 33) ) && ( (indexX == 10) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) ) ) {
						
						if(indexY ==  1) {
						
							emplacements[11][indexY] = new Emplacement( 11, indexY );
							g.drawOval(440 ,450 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(480 ,450 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY );
							g.drawOval(520 ,450, IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(560 ,450 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[19][indexY] = new Emplacement( 19, indexY );
							g.drawOval(600 ,450 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						}
						
						if(indexY == 33) {
							
							emplacements[11][indexY] = new Emplacement( 11, indexY );
							g.drawOval(440 ,50 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(480 ,50 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
							emplacements[13][indexY] = new Emplacement( 15, indexY );
							g.drawOval(520 ,50 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
							emplacements[15][indexY] = new Emplacement( 17, indexY );
							g.drawOval(560 ,50 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
							emplacements[17][indexY] = new Emplacement( 19, indexY );
							g.drawOval(600 ,50 , IDEAL_WIDTH, IDEAL_HEIGHT);
						}
					}
					
					//line 2 & 16
				
					if( ( (indexY == 3) || (indexY == 31) ) && ( (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) ) ) {	
						
						if(indexY == 3) {
						
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(455 ,425 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(485 ,425 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(515 ,425 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(545 ,425 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
						
						if(indexY == 31) {
							
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(460 ,75 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(500 ,75 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(540 ,75 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(580 ,75 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
						
					}
					
					//line 3 & 15
				
					if( ( (indexY == 5) || (indexY == 29) ) && ( (indexX == 4) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 23) ) ) {	
						
						if(indexY == 5) {
						
							emplacements[5][indexY] = new Emplacement( 5, indexY );
							g.drawOval(500 ,400 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(470 ,400 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY  );
							g.drawOval(530 ,400 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(350 ,400 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[24][indexY] = new Emplacement( 24, indexY );
							g.drawOval(650 ,400 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						}
						
						if(indexY == 29) {
							
							emplacements[5][indexY] = new Emplacement( 5, indexY );
							g.drawOval(520 ,100 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(480 ,100 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY  );
							g.drawOval(560 ,100 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(320 ,100 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[24][indexY] = new Emplacement( 24, indexY );
							g.drawOval(720 ,100 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
					}
					
					//line 4 & 14
						
					if( ( (indexY == 7) || (indexY == 27) ) && ( (indexX == 4) || (indexX == 6) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) || (indexX == 23) || (indexX == 25) ) ) {	
						
						if(indexY == 7) {
						
							emplacements[4][indexY] = new Emplacement( 4, indexY );
							g.drawOval(455 ,375 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[6][indexY] = new Emplacement( 6, indexY );
							g.drawOval(485 ,375 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(515 ,375 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(545 ,375 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(335 ,375 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(365 ,375 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[23][indexY] = new Emplacement( 23, indexY );
							g.drawOval(665 ,375 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[25][indexY] = new Emplacement( 25, indexY );
							g.drawOval(635 ,375 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						}
						
						if(indexY == 27) {
							
							emplacements[4][indexY] = new Emplacement( 4, indexY );
							g.drawOval(460 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[6][indexY] = new Emplacement( 6, indexY );
							g.drawOval(500 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(540 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(580 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(300 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(340 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[23][indexY] = new Emplacement( 23, indexY );
							g.drawOval(700 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[25][indexY] = new Emplacement( 25, indexY );
							g.drawOval(740 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
						
					}
					
					//line 5 & 13
					
					if( ( (indexY == 9) || (indexY == 25) ) && ( (indexX == 3) || (indexX == 5) || (indexX == 7) || (indexX == 9) || (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) || (indexX == 19) || (indexX ==  21) || (indexX == 23) || (indexX  == 25) || (indexX == 27) ) ) {	
						
						if(indexY == 9) {
													
							emplacements[3][indexY] = new Emplacement( 3, indexY );
							g.drawOval(320 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[5][indexY] = new Emplacement( 5, indexY );
							g.drawOval(350 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
					
							emplacements[7][indexY] = new Emplacement( 7, indexY );
							g.drawOval(380 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[9][indexY] = new Emplacement( 9, indexY );
							g.drawOval(410 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[11][indexY] = new Emplacement( 11, indexY );
							g.drawOval(440 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(470 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY );
							g.drawOval(500 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(530 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[19][indexY] = new Emplacement( 19, indexY );
							g.drawOval(560 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[21][indexY] = new Emplacement( 21, indexY );
							g.drawOval(590 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[23][indexY] = new Emplacement( 23, indexY );
							g.drawOval(620 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[25][indexY] = new Emplacement( 25, indexY );
							g.drawOval(650 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[27][indexY] = new Emplacement( 27, indexY );
							g.drawOval(680 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
						
						if(indexY == 25) {
							
							emplacements[3][indexY] = new Emplacement( 3, indexY );
							g.drawOval(280 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[5][indexY] = new Emplacement( 5, indexY );
							g.drawOval(320 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
					
							emplacements[7][indexY] = new Emplacement( 7, indexY );
							g.drawOval(360 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[9][indexY] = new Emplacement( 9, indexY );
							g.drawOval(400 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[11][indexY] = new Emplacement( 11, indexY );
							g.drawOval(440 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(480 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY );
							g.drawOval(520 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(560 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[19][indexY] = new Emplacement( 19, indexY );
							g.drawOval(600 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[21][indexY] = new Emplacement( 21, indexY );
							g.drawOval(640 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[23][indexY] = new Emplacement( 23, indexY );
							g.drawOval(680 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[25][indexY] = new Emplacement( 25, indexY );
							g.drawOval(720 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[27][indexY] = new Emplacement( 27, indexY );
							g.drawOval(760 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						}
						
					}
					
					//line 6 & 12
					
					if( ( (indexY == 11) || (indexY == 23) ) && ( (indexX == 2) || (indexX == 4) || (indexX == 6) || (indexX == 8) || (indexX == 10) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) || (indexX == 20) || (indexX  == 22) || (indexX == 24) || (indexX == 26) || (indexX == 28) ) ) {	
						
						if(indexY == 11) {
						
							emplacements[2][indexY] = new Emplacement( 2, indexY );
							g.drawOval(305 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[4][indexY] = new Emplacement( 4, indexY );
							g.drawOval(335 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[6][indexY] = new Emplacement( 6, indexY );
							g.drawOval(365 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[8][indexY] = new Emplacement( 8, indexY );
							g.drawOval(395 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[10][indexY] = new Emplacement( 10, indexY );
							g.drawOval(425 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(455 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(485 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(515 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(545 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[20][indexY] = new Emplacement( 20, indexY );
							g.drawOval(575 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[22][indexY] = new Emplacement( 22, indexY );
							g.drawOval(605 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[24][indexY] = new Emplacement( 24, indexY );
							g.drawOval(635 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[26][indexY] = new Emplacement( 26, indexY );
							g.drawOval(665 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[28][indexY] = new Emplacement( 28, indexY );
							g.drawOval(695 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
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
							g.drawOval(290 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[3][indexY] = new Emplacement( 3, indexY );
							g.drawOval(320 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[5][indexY] = new Emplacement( 5, indexY );
							g.drawOval(350 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[7][indexY] = new Emplacement( 7, indexY );
							g.drawOval(380 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[9][indexY] = new Emplacement( 9, indexY );
							g.drawOval(410 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[11][indexY] = new Emplacement( 11, indexY );
							g.drawOval(440 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(470 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY );
							g.drawOval(500 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(530 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[19][indexY] = new Emplacement( 19, indexY );
							g.drawOval(560 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[21][indexY] = new Emplacement( 21, indexY );
							g.drawOval(590 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[23][indexY] = new Emplacement( 23, indexY );
							g.drawOval(620 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[25][indexY] = new Emplacement( 25, indexY );
							g.drawOval(650 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[27][indexY] = new Emplacement( 27, indexY );
							g.drawOval(680 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[29][indexY] = new Emplacement( 29, indexY );
							g.drawOval(710 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						}
						
						if(indexY == 21) {
						
							emplacements[1][indexY] = new Emplacement( 1, indexY );
							g.drawOval(240 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[3][indexY] = new Emplacement( 3, indexY );
							g.drawOval(280 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[5][indexY] = new Emplacement( 5, indexY );
							g.drawOval(320 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[7][indexY] = new Emplacement( 7, indexY );
							g.drawOval(360 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[9][indexY] = new Emplacement( 9, indexY );
							g.drawOval(400 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[11][indexY] = new Emplacement( 11, indexY );
							g.drawOval(440 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(480 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY );
							g.drawOval(520 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(560 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[19][indexY] = new Emplacement( 19, indexY );
							g.drawOval(600 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[21][indexY] = new Emplacement( 21, indexY );
							g.drawOval(640 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[23][indexY] = new Emplacement( 23, indexY );
							g.drawOval(680 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[25][indexY] = new Emplacement( 25, indexY );
							g.drawOval(720 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[27][indexY] = new Emplacement( 27, indexY );
							g.drawOval(760 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[29][indexY] = new Emplacement( 29, indexY );
							g.drawOval(800 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
					}
					
					//line 8 & 10
					
					if( ( (indexY == 15) || (indexY == 19) ) && ( (indexX == 6) || (indexX == 8) || (indexX == 10) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) || (indexX == 20) || (indexX == 22) || (indexX == 24) ) ) {
						
						if(indexY == 15) {
						
							emplacements[6][indexY] = new Emplacement( 6, indexY );
							g.drawOval(365 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[8][indexY] = new Emplacement( 8, indexY );
							g.drawOval(395 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[10][indexY] = new Emplacement( 10, indexY );
							g.drawOval(425 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(455 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(485 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(515 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(545 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[20][indexY] = new Emplacement( 20, indexY );
							g.drawOval(575 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[22][indexY] = new Emplacement( 22, indexY );
							g.drawOval(605 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[24][indexY] = new Emplacement( 24, indexY );
							g.drawOval(635 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						}
						
						if(indexY == 19) {
							
							emplacements[6][indexY] = new Emplacement( 6, indexY );
							g.drawOval(340 ,225 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[8][indexY] = new Emplacement( 8, indexY );
							g.drawOval(380 ,225 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[10][indexY] = new Emplacement( 10, indexY );
							g.drawOval(420 ,225 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(460 ,225 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(500 ,225 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(540 ,225 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(580 ,225 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[20][indexY] = new Emplacement( 20, indexY );
							g.drawOval(620 ,225 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[22][indexY] = new Emplacement( 22, indexY );
							g.drawOval(660 ,225 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[24][indexY] = new Emplacement( 24, indexY );
							g.drawOval(700 ,225 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
					}
					
					//line 9
					
					if( (indexY == 17) && ( (indexX == 7) || (indexX == 9) || (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) || (indexX == 19) || (indexX == 21) || (indexX == 23) ) ) {
						
						emplacements[7][indexY] = new Emplacement( 7, indexY );
						g.drawOval(380 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[9][indexY] = new Emplacement( 9, indexY );
						g.drawOval(410 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[11][indexY] = new Emplacement( 11, indexY );
						g.drawOval(440 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[13][indexY] = new Emplacement( 13, indexY );
						g.drawOval(470 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[15][indexY] = new Emplacement( 15, indexY );
						g.drawOval(500 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[17][indexY] = new Emplacement( 17, indexY );
						g.drawOval(530 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[19][indexY] = new Emplacement( 19, indexY );
						g.drawOval(560 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[21][indexY] = new Emplacement( 21, indexY );
						g.drawOval(590 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[23][indexY] = new Emplacement( 23, indexY );
						g.drawOval(620 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
					}
				}
			}
		}
		repaint();
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
		
		JList list = new JList();
		list.setBounds(6, 16, 192, 227);
		panel.add(list);
		
		btnPower2 = new JButton("Pouvoir 2");
		btnPower2.setIcon(new ImageIcon("power2.jpg"));
		btnPower2.setBounds(549, 652, 89, 96);
		add(btnPower2);
		
		btnPower1 = new JButton("Pouvoir 1");
		btnPower1.setIcon(new ImageIcon("power1.jpg"));
		btnPower1.setBounds(414, 652, 94, 96);
		add(btnPower1);
		
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
	
	public void initActions() throws InterruptedException {
		this.addKeyListener(new KeyResponse());
		
		progressBar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				labelProgressBarValue.setText(Integer.valueOf(progressBar.getValue()).toString());
			}
		});
		
		btnSimulateSpecialMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ( GameVariableRepository.getInstance().getPlayerTurn() == 0 ) {
					VariableRepository.getInstance().searchPlayer("Player 1").addPlayerMana(10);
					progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer("Player 1").getPlayerMana() );
				} else if ( GameVariableRepository.getInstance().getPlayerTurn() == 1 ) {
					VariableRepository.getInstance().searchPlayer("Player 2").addPlayerMana(10);
					progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer("Player 2").getPlayerMana() );
				} else {
					VariableRepository.getInstance().searchPlayer("Player 3").addPlayerMana(10);
					progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer("Player 3").getPlayerMana() );
				}
				
				GameVariableRepository.getInstance().incrementPlayerTurn();
				
				if ( GameVariableRepository.getInstance().getPlayerTurn() == 0 ) {
					// System.out.println("test 1");
					labelPlayerActualTurn.setText(VariableRepository.getInstance().searchPlayer("Player 1").getPlayerName());
				} else if ( GameVariableRepository.getInstance().getPlayerTurn() == 1 ) {
					// System.out.println("test 2");
					labelPlayerActualTurn.setText(VariableRepository.getInstance().searchPlayer("Player 2").getPlayerName());
				} else {
					// System.out.println("test 3");
					labelPlayerActualTurn.setText(VariableRepository.getInstance().searchPlayer("Player 3").getPlayerName());
				}
			}
		});
		
		btnSimulateClassicMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ( GameVariableRepository.getInstance().getPlayerTurn() == 0 ) {
					VariableRepository.getInstance().searchPlayer("Player 1").addPlayerMana(5);
					progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer("Player 1").getPlayerMana() );
				} else if ( GameVariableRepository.getInstance().getPlayerTurn() == 1 ) {
					VariableRepository.getInstance().searchPlayer("Player 2").addPlayerMana(5);
					progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer("Player 2").getPlayerMana() );
				} else {
					VariableRepository.getInstance().searchPlayer("Player 3").addPlayerMana(5);
					progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer("Player 3").getPlayerMana() );
				}
				
				GameVariableRepository.getInstance().incrementPlayerTurn();
				
				if ( GameVariableRepository.getInstance().getPlayerTurn() == 0 ) {
					// System.out.println("test 1");
					labelPlayerActualTurn.setText(VariableRepository.getInstance().searchPlayer("Player 1").getPlayerName());
				} else if ( GameVariableRepository.getInstance().getPlayerTurn() == 1 ) {
					// System.out.println("test 2");
					labelPlayerActualTurn.setText(VariableRepository.getInstance().searchPlayer("Player 2").getPlayerName());
				} else {
					// System.out.println("test 3");
					labelPlayerActualTurn.setText(VariableRepository.getInstance().searchPlayer("Player 3").getPlayerName());
				}
				/*
				if (  ) {
					
				}
				*/
			}
		});
		
		btnAskMoveCorrection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnPower1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ( GameVariableRepository.getInstance().getPlayerTurn() == 0 ) {
					VariableRepository.getInstance().searchPlayer("Player 1").addPlayerMana(-50);
					progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer("Player 1").getPlayerMana() );
				} else if ( GameVariableRepository.getInstance().getPlayerTurn() == 1 ) {
					VariableRepository.getInstance().searchPlayer("Player 2").addPlayerMana(-50);
					progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer("Player 2").getPlayerMana() );
				} else {
					VariableRepository.getInstance().searchPlayer("Player 3").addPlayerMana(-50);
					progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer("Player 3").getPlayerMana() );
				}
			}
		});
		
		btnPower2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ( GameVariableRepository.getInstance().getPlayerTurn() == 0 ) {
					VariableRepository.getInstance().searchPlayer("Player 1").addPlayerMana(-90);
					progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer("Player 1").getPlayerMana() );
				} else if ( GameVariableRepository.getInstance().getPlayerTurn() == 1 ) {
					VariableRepository.getInstance().searchPlayer("Player 2").addPlayerMana(-90);
					progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer("Player 2").getPlayerMana() );
				} else {
					VariableRepository.getInstance().searchPlayer("Player 3").addPlayerMana(-90);
					progressBar.setValue( ( int ) VariableRepository.getInstance().searchPlayer("Player 3").getPlayerMana() );
				}
			}
		});
		
	}
}



