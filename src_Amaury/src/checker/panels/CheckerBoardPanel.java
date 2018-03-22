
package checker.panels;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import customEventsPackage.CustomEvent;
import application.State;
import application.StateMachine;
import checker.core.VariableRepository;
import checker.gui.Dessiner;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.JTextField;

/**
 * Main GUI class for chronometer.
 * 
 * @author toulain.timoth√©@u-cergy.fr
 **/
public class CheckerBoardPanel extends JPanel implements CustomEvent {
	
	private static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(800, 800);
	private static final Dimension IDEAL_DASHBOARD_DIMENSION = new Dimension(800, 800);
	private static final long serialVersionUID = 1L;
	Point point[] = new Point[117];
	Point yellowPoint[] = new Point[10];
	Point blackPoint[] = new Point[10];
	Point redPoint[] = new Point[10];
	Point bluePoint[] = new Point[10];
	private static JPanel control = new JPanel();
	private Dessiner draw = new Dessiner();
	JFrame applicationFrame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	// Solution temporaire pour rÈcupÈrer le panel
	
	public CheckerBoardPanel(String title,JFrame frame) {
		super();
		setLayout(null);
		
		JInternalFrame internalFrame = new JInternalFrame("Players");
		internalFrame.setBounds(282, 51, 158, 104);
		add(internalFrame);
		internalFrame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Box verticalBox = Box.createVerticalBox();
		internalFrame.getContentPane().add(verticalBox);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		JLabel lblNewLabel = new JLabel( VariableRepository.getInstance().searchPlayer("Player 1").getPlayerName() );
		horizontalBox.add(lblNewLabel);
		
		textField = new JTextField();
		horizontalBox.add(textField);
		textField.setColumns(10);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		JLabel lblNewLabel_1 = new JLabel( VariableRepository.getInstance().searchPlayer("Player 2").getPlayerName() );
		horizontalBox_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		horizontalBox_1.add(textField_1);
		textField_1.setColumns(10);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		JLabel lblNewLabel_2 = new JLabel( VariableRepository.getInstance().searchPlayer("Player 3").getPlayerName() );
		horizontalBox_2.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		horizontalBox_2.add(textField_2);
		textField_2.setColumns(10);
		internalFrame.setVisible(true);
	}
	
	private void init( JFrame frame) {
		creerCase();

		Container contentPane = frame.getRootPane();
		contentPane.setLayout(new BorderLayout());

		control.setLayout(new FlowLayout(FlowLayout.CENTER));
		contentPane.add(BorderLayout.NORTH, control);
		draw.setPreferredSize(IDEAL_DASHBOARD_DIMENSION);
		contentPane.add(BorderLayout.SOUTH, draw);
		/*
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		*/
		// setVisible(true);
		setPreferredSize(IDEAL_MAIN_DIMENSION);
	}


    public void stateChanged(JFrame frame) {
		
		System.out.println("Init de la Fenetre de jeu");
		StateMachine.changeState(State.gameSessionState);
        this.init(frame);
        System.out.println("Fenetre de jeu crÈÈe");
    }
	
	public void gameScreenDisable(Boolean changeState) {
		if ( changeState == true ) {
			control.setVisible(false);
		} else {
			control.setVisible(true);
		}
	}
	
	private void creerCase() {
		// TODO - Essayer de cr√©er une collection qui contient des donn√©es comme les couleurs de chaque point et leur position ( √©ventuellement leur futur propri√©taire ), pour ensuite appeler une fonction qui parcourt cette collection et cr√©er chaque point
		yellowPoint[0]= new Point(590,600);
		yellowPoint[1]= new Point(620,600);
		yellowPoint[2]= new Point(650,600);
		yellowPoint[3]= new Point(680,600);
		yellowPoint[4]= new Point(710,600);
		//ligne2
		yellowPoint[5]= new Point(605,575);
		yellowPoint[6]= new Point(635,575);
		yellowPoint[7]= new Point(665,575);
		yellowPoint[8]= new Point(695,575);
		//ligne3
		yellowPoint[9]= new Point(650,550);
		point[0]= new Point(620,550);
		point[1]= new Point(680,550);
		blackPoint[4]=new Point(500,550);
		redPoint[0]=new Point(800,550);
		//ligne 4
		point[2]= new Point(605,525);
		point[3]= new Point(635,525);
		point[4]= new Point(665,525);
		point[5]= new Point(695,525);
		blackPoint[3]=new Point(485,525);
		blackPoint[8]=new Point(515,525);
		redPoint[5]=new Point(785,525);
		redPoint[1]=new Point(815,525);
		//ligne 5
		blackPoint[2]= new Point(470,500);
		blackPoint[7]= new Point(500,500);
		point[6]= new Point(530,500);
		point[7]= new Point(560,500);
		point[8]= new Point(590,500);
		point[9]= new Point(620,500);
		point[10]= new Point(650,500);
		point[11]= new Point(680,500);
		point[12]= new Point(710,500);
		point[13]= new Point(740,500);
		point[14]= new Point(770,500);
		redPoint[6]= new Point(800,500);
		redPoint[2]= new Point(830,500);
		//ligne 6
		blackPoint[1]= new Point(455,475);
		blackPoint[6]= new Point(485,475);
		blackPoint[9]= new Point(515,475);
		point[15]= new Point(545,475);
		point[16]= new Point(575,475);
		point[17]= new Point(605,475);
		point[18]= new Point(635,475);
		point[19]= new Point(665,475);
		point[20]= new Point(695,475);
		point[21]= new Point(725,475);
		point[22]= new Point(755,475);
		redPoint[9]= new Point(785,475);
		redPoint[7]= new Point(815,475);
		redPoint[3]= new Point(845,475);
		//ligne 7
		blackPoint[0]=new Point(440,450);
		blackPoint[5]=new Point(470,450);
		point[23]=new Point(500,450);
		point[24]=new Point(530,450);
		point[25]=new Point(560,450);
		point[26]=new Point(590,450);
		point[27]=new Point(620,450);
		point[28]=new Point(650,450);
		point[29]=new Point(680,450);
		point[30]=new Point(710,450);
		point[31]=new Point(740,450);
		point[32]=new Point(770,450);
		point[33]=new Point(800,450);
		redPoint[8]=new Point(860,450);
		redPoint[4]=new Point(830,450);
		//ligne8
		point[34]=new Point(515,425);
		point[35]=new Point(545,425);
		point[36]=new Point(575,425);
		point[37]=new Point(605,425);
		point[38]=new Point(635,425);
		point[39]=new Point(665,425);
		point[40]=new Point(695,425);
		point[41]=new Point(725,425);
		point[42]=new Point(755,425);
		point[43]=new Point(785,425);
		//ligne9
		point[44]=new Point(530,400);
		point[45]=new Point(560,400);
		point[46]=new Point(590,400);
		point[47]=new Point(620,400);
		point[48]=new Point(650,400);
		point[49]=new Point(680,400);
		point[50]=new Point(710,400);
		point[51]=new Point(740,400);
		point[52]=new Point(770,400);
		//ligne10
		point[53]=new Point(515,375);
		point[54]=new Point(545,375);
		point[55]=new Point(575,375);
		point[56]=new Point(605,375);
		point[57]=new Point(635,375);
		point[58]=new Point(665,375);
		point[59]=new Point(695,375);
		point[60]=new Point(725,375);
		point[61]=new Point(755,375);
		point[62]=new Point(785,375);
		//ligne11
		point[63]=new Point(440,350);
		point[64]=new Point(470,350);
		point[65]=new Point(500,350);
		point[66]=new Point(530,350);
		point[67]=new Point(560,350);
		point[68]=new Point(590,350);
		point[69]=new Point(620,350);
		point[70]=new Point(650,350);
		point[71]=new Point(680,350);
		point[72]=new Point(710,350);
		point[73]=new Point(740,350);
		point[74]=new Point(770,350);
		point[75]=new Point(800,350);
		point[76]=new Point(830,350);
		point[77]=new Point(860, 350);
		//ligne12
		point[78]= new Point(455, 325);
		point[79]= new Point(485, 325);
		point[80]= new Point(515, 325);
		point[81]= new Point(545, 325);
		point[82]= new Point(575, 325);
		point[83]= new Point(605, 325);
		point[84]= new Point(635, 325);
		point[85]= new Point(665, 325);
		point[86]= new Point(695, 325);
		point[87]= new Point(725, 325);
		point[88]= new Point(755, 325);
		point[89]= new Point(785, 325);
		point[90]= new Point(815, 325);
		point[91]= new Point(845, 325);
		//ligne13
		point[92]= new Point(470, 300);
		point[93]= new Point(500, 300);
		point[94]= new Point(530, 300);
		point[95]= new Point(560, 300);
		point[96]= new Point(590, 300);
		point[97]= new Point(620, 300);
		point[98]= new Point(650, 300);
		point[99]= new Point(680, 300);
		point[100]= new Point(710, 300);
		point[101]= new Point(740, 300);
		point[102]= new Point(770, 300);
		point[103]= new Point(800, 300);
		point[104]= new Point(830, 300);
		//ligne14
		point[105]= new Point(605, 275);
		point[106]= new Point(635, 275);
		point[107]= new Point(665, 275);
		point[108]= new Point(695, 275);
		point[109]=new Point(485, 275);
		point[110]=new Point(515, 275);
		point[111]=new Point(815, 275);
		point[112]=new Point(785, 275);
		//ligne15
		bluePoint[9]= new Point(650, 250);
		point[113]= new Point(620, 250);
		point[114]= new Point(680, 250);
		point[115]=new Point(500, 250);
		point[116]=new Point(800, 250);
		//ligne16
		bluePoint[5]= new Point(605, 225);
		bluePoint[6]= new Point(635, 225);
		bluePoint[7]= new Point(665, 225);
		bluePoint[8]= new Point(695, 225);
		//ligne17
		bluePoint[0]= new Point(590, 200);
		bluePoint[1]= new Point(620, 200);
		bluePoint[2]= new Point(650, 200);
		bluePoint[3]= new Point(680, 200);
		bluePoint[4]= new Point(710, 200);
		
		for(int i=0;i<point.length;i++) {
			if(i<bluePoint.length) {
				draw.addBlackArrayList(blackPoint[i]);
				draw.addRedArrayList(redPoint[i]);	
				draw.addYellowArrayList(yellowPoint[i]);	
				draw.addBlueArrayList(bluePoint[i]);	
			}
			draw.addArrayList(point[i]);
		}
	}
}
