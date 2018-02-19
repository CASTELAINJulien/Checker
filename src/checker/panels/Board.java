package checker.panels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import checker.core.VariableRepository;
import checker.panels.Emplacement;
import javax.swing.JProgressBar;
import javax.swing.JDesktopPane;
import javax.swing.border.TitledBorder;



public class Board extends JPanel {

	private Emplacement[][] emplacements;
	
	private final int x=30;
	private final int y=34;
	
	private static final int IDEAL_WIDTH=22;
	private static final int IDEAL_HEIGHT=22;
	
	private static JPanel control = new JPanel();
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JProgressBar progressBar;
	JPanel playersInternalPanel;
	JDesktopPane desktopPane;
	Box verticalBox;
	Box horizontalBox;
	Box horizontalBox_1 ;
	JLabel secondPlayerName;
	JLabel firstPlayerName;
	Box horizontalBox_2;
	JLabel thirdPlayerName;
	
	public void paint(Graphics g) {
		
		super.paint(g);
		this.modifyPlayerNamesGUI();
		
		emplacements = new Emplacement[x][y];
		
		g.setColor(Color.lightGray);

		
		for(int indexX = 0; indexX <= x; indexX++ ) {
			
			for(int indexY = 0; indexY <= y; indexY++ ) {
				
				if( indexY%2 != 0) {
				
					if( ( (indexY == 1) || (indexY == 33) ) && ( (indexX == 10) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) ) ) {
						
						emplacements[11][indexY] = new Emplacement( 11, indexY );
						g.drawOval(11 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[13][indexY] = new Emplacement( 13, indexY );
						g.drawOval(13 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[15][indexY] = new Emplacement( 15, indexY );
						g.drawOval(15 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[17][indexY] = new Emplacement( 17, indexY );
						g.drawOval(17 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[19][indexY] = new Emplacement( 19, indexY );
						g.drawOval(19 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
					}
				
					if( ( (indexY == 3) || (indexY == 31) ) && ( (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) ) ) {	
						
						emplacements[12][indexY] = new Emplacement( 12, indexY );
						g.drawOval(12 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[14][indexY] = new Emplacement( 14, indexY );
						g.drawOval(14 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[16][indexY] = new Emplacement( 16, indexY );
						g.drawOval(16 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[18][indexY] = new Emplacement( 18, indexY );
						g.drawOval(18 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
					}
				
					if( ( (indexY == 5) || (indexY == 29) ) && ( (indexX == 4) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 23) ) ) {	
						
						emplacements[5][indexY] = new Emplacement( 5, indexY );
						g.drawOval(5 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[13][indexY] = new Emplacement( 13, indexY );
						g.drawOval(13 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[15][indexY] = new Emplacement( 15, indexY  );
						g.drawOval(13 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[17][indexY] = new Emplacement( 17, indexY );
						g.drawOval(17 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[24][indexY] = new Emplacement( 24, indexY );
						g.drawOval(24 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
					}
						
					if( ( (indexY == 7) || (indexY == 27) ) && ( (indexX == 4) || (indexX == 6) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) || (indexX == 23) || (indexX == 25) ) ) {	
						
						emplacements[4][indexY] = new Emplacement( 4, indexY );
						g.drawOval(4 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[6][indexY] = new Emplacement( 6, indexY );
						g.drawOval(6 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[12][indexY] = new Emplacement( 12, indexY );
						g.drawOval(12 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[14][indexY] = new Emplacement( 14, indexY );
						g.drawOval(14 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[16][indexY] = new Emplacement( 16, indexY );
						g.drawOval(16 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[18][indexY] = new Emplacement( 18, indexY );
						g.drawOval(18 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[23][indexY] = new Emplacement( 23, indexY );
						g.drawOval(23 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[25][indexY] = new Emplacement( 25, indexY );
						g.drawOval(25 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
					}
					
					if( ( (indexY == 9) || (indexY == 25) ) && ( (indexX == 3) || (indexX == 5) || (indexX == 7) || (indexX == 9) || (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) || (indexX == 19) || (indexX ==  21) || (indexX == 23) || (indexX  == 25) || (indexX == 27) ) ) {	
						
						emplacements[3][indexY] = new Emplacement( 3, indexY );
						g.drawOval(3 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[5][indexY] = new Emplacement( 5, indexY );
						g.drawOval(5 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[7][indexY] = new Emplacement( 7, indexY );
						g.drawOval(7 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[9][indexY] = new Emplacement( 9, indexY );
						g.drawOval(9 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[11][indexY] = new Emplacement( 11, indexY );
						g.drawOval(11 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[13][indexY] = new Emplacement( 13, indexY );
						g.drawOval(13 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[15][indexY] = new Emplacement( 15, indexY );
						g.drawOval(15 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[17][indexY] = new Emplacement( 17, indexY );
						g.drawOval(17 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[19][indexY] = new Emplacement( 19, indexY );
						g.drawOval(19 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[21][indexY] = new Emplacement( 21, indexY );
						g.drawOval(21 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[23][indexY] = new Emplacement( 23, indexY );
						g.drawOval(23 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[25][indexY] = new Emplacement( 25, indexY );
						g.drawOval(25 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[27][indexY] = new Emplacement( 27, indexY );
						g.drawOval(27 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
					}
					
					if( ( (indexY == 11) || (indexY == 23) ) && ( (indexX == 2) || (indexX == 4) || (indexX == 6) || (indexX == 8) || (indexX == 10) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) || (indexX == 20) || (indexX  == 22) || (indexX == 24) || (indexX == 26) || (indexX == 28) ) ) {	
						
						emplacements[2][indexY] = new Emplacement( 2, indexY );
						g.drawOval(2 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[4][indexY] = new Emplacement( 4, indexY );
						g.drawOval(4 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[6][indexY] = new Emplacement( 6, indexY );
						g.drawOval(6 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[8][indexY] = new Emplacement( 8, indexY );
						g.drawOval(8 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[10][indexY] = new Emplacement( 10, indexY );
						g.drawOval(10 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[12][indexY] = new Emplacement( 12, indexY );
						g.drawOval(12 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[14][indexY] = new Emplacement( 14, indexY );
						g.drawOval(14 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[16][indexY] = new Emplacement( 16, indexY );
						g.drawOval(16 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[18][indexY] = new Emplacement( 18, indexY );
						g.drawOval(18 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[20][indexY] = new Emplacement( 20, indexY );
						g.drawOval(20 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[22][indexY] = new Emplacement( 22, indexY );
						g.drawOval(22 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[24][indexY] = new Emplacement( 24, indexY );
						g.drawOval(24 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[26][indexY] = new Emplacement( 26, indexY );
						g.drawOval(26 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[28][indexY] = new Emplacement( 28, indexY );
						g.drawOval(28 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
					}
					
					if( ( (indexY == 13) || (indexY == 21) ) && ( (indexX == 1) || (indexX == 3) || (indexX == 5) || (indexX == 7) || (indexX == 9) || (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) || (indexX == 19) || (indexX == 21) || (indexX == 23) || (indexX == 25) || (indexX == 27) || (indexX == 29) ) ) {	
						
						emplacements[1][indexY] = new Emplacement( 1, indexY );
						g.drawOval(1 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[3][indexY] = new Emplacement( 3, indexY );
						g.drawOval(3 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[5][indexY] = new Emplacement( 5, indexY );
						g.drawOval(5 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[7][indexY] = new Emplacement( 7, indexY );
						g.drawOval(7 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[9][indexY] = new Emplacement( 9, indexY );
						g.drawOval(9 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[11][indexY] = new Emplacement( 11, indexY );
						g.drawOval(11 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[13][indexY] = new Emplacement( 13, indexY );
						g.drawOval(13 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[15][indexY] = new Emplacement( 15, indexY );
						g.drawOval(15 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[17][indexY] = new Emplacement( 17, indexY );
						g.drawOval(17 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[19][indexY] = new Emplacement( 19, indexY );
						g.drawOval(19 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[21][indexY] = new Emplacement( 21, indexY );
						g.drawOval(21 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[23][indexY] = new Emplacement( 23, indexY );
						g.drawOval(23 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[25][indexY] = new Emplacement( 25, indexY );
						g.drawOval(25 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[27][indexY] = new Emplacement( 27, indexY );
						g.drawOval(27 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[29][indexY] = new Emplacement( 29, indexY );
						g.drawOval(29 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
					}
					
					if( ( (indexY == 15) || (indexY == 19) ) && ( (indexX == 6) || (indexX == 8) || (indexX == 10) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) || (indexX == 20) || (indexX == 22) || (indexX == 24) ) ) {
						
						emplacements[6][indexY] = new Emplacement( 6, indexY );
						g.drawOval(6 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[8][indexY] = new Emplacement( 8, indexY );
						g.drawOval(8 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[10][indexY] = new Emplacement( 10, indexY );
						g.drawOval(10 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[12][indexY] = new Emplacement( 12, indexY );
						g.drawOval(12 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[14][indexY] = new Emplacement( 14, indexY );
						g.drawOval(14 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[16][indexY] = new Emplacement( 16, indexY );
						g.drawOval(16 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[18][indexY] = new Emplacement( 18, indexY );
						g.drawOval(18 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[20][indexY] = new Emplacement( 20, indexY );
						g.drawOval(20 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[22][indexY] = new Emplacement( 22, indexY );
						g.drawOval(22 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[24][indexY] = new Emplacement( 24, indexY );
						g.drawOval(24 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
					}
					
					if( (indexY == 17) && ( (indexX == 7) || (indexX == 9) || (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) || (indexX == 19) || (indexX == 21) || (indexX == 23) ) ) {
						
						emplacements[7][indexY] = new Emplacement( 7, indexY );
						g.drawOval(7 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[9][indexY] = new Emplacement( 9, indexY );
						g.drawOval(9 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[11][indexY] = new Emplacement( 11, indexY );
						g.drawOval(11 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[13][indexY] = new Emplacement( 13, indexY );
						g.drawOval(13 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[15][indexY] = new Emplacement( 15, indexY );
						g.drawOval(15 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[17][indexY] = new Emplacement( 17, indexY );
						g.drawOval(17 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[19][indexY] = new Emplacement( 19, indexY );
						g.drawOval(19 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[21][indexY] = new Emplacement( 21, indexY );
						g.drawOval(21 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[23][indexY] = new Emplacement( 23, indexY );
						g.drawOval(23 ,indexY , IDEAL_WIDTH, IDEAL_HEIGHT);
					}
				}
			}
		}
		repaint();
	}
	
	public Board() {
		super();
		setLayout(null);
		
		initLayout();
	}
	
	public void modifyPlayerNamesGUI() {
		this.firstPlayerName.setText(VariableRepository.getInstance().searchPlayer("Player 1").getPlayerName());
		this.secondPlayerName.setText(VariableRepository.getInstance().searchPlayer("Player 2").getPlayerName());
		this.thirdPlayerName.setText(VariableRepository.getInstance().searchPlayer("Player 3").getPlayerName());
	}
	
	public void initLayout () {
		progressBar = new JProgressBar();
		progressBar.setBackground(Color.CYAN);
		progressBar.setBounds(331, 447, 300, 39);
		add(progressBar);
		
		playersInternalPanel = new JPanel();
		playersInternalPanel.setBorder(new TitledBorder(null, "Players", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		playersInternalPanel.setBounds(704, 134, 138, 123);
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
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		horizontalBox_2.add(textField_2);
		textField_2.setColumns(10);
	}
}



