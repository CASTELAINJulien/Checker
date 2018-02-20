package checker.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import checker.gui.Emplacement;



public class Board extends JPanel {

	private Emplacement[][] emplacements;
	
	private final int x=30;
	private final int y=34;
	
	private static final int IDEAL_WIDTH = 22;
	private static final int IDEAL_HEIGHT = 22;
	
	private static JPanel control = new JPanel();
	
	public void paint(Graphics g) {
		
		super.paint(g);
		
		
		emplacements = new Emplacement[x][y];
		
		g.setColor(Color.lightGray);

		
		for(int indexX = 0; indexX <= x; indexX++ ) {
			
			for(int indexY = 0; indexY <= y; indexY++ ) {
				
				if( indexY%2 != 0) {
					
					//line 1 & 17
				
					if( ( (indexY == 1) || (indexY == 33) ) && ( (indexX == 10) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) ) ) {
						
						if(indexY ==  1) {
						
							emplacements[11][indexY] = new Emplacement( 11, indexY );
							g.drawOval(390 ,400 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(420 ,400 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY );
							g.drawOval(450 ,400, IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(480 ,400 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[19][indexY] = new Emplacement( 19, indexY );
							g.drawOval(510 ,400 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						}
						
						if(indexY == 33) {
							
							emplacements[11][indexY] = new Emplacement( 11, indexY );
							g.drawOval(390 ,0 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(420 ,0 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
							emplacements[13][indexY] = new Emplacement( 15, indexY );
							g.drawOval(450 ,0 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
							emplacements[15][indexY] = new Emplacement( 17, indexY );
							g.drawOval(480 ,0 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
							emplacements[17][indexY] = new Emplacement( 19, indexY );
							g.drawOval(510 ,0 , IDEAL_WIDTH, IDEAL_HEIGHT);
						}
					}
					
					//line 2 & 16
				
					if( ( (indexY == 3) || (indexY == 31) ) && ( (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) ) ) {	
						
						if(indexY == 3) {
						
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(405 ,375 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(435 ,375 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(465 ,375 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(495 ,375 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
						
						if(indexY == 31) {
							
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(405 ,25 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(435 ,25 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(465 ,25 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(495 ,25 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
						
					}
					
					//line 3 & 15
				
					if( ( (indexY == 5) || (indexY == 29) ) && ( (indexX == 4) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 23) ) ) {	
						
						if(indexY == 5) {
						
							emplacements[5][indexY] = new Emplacement( 5, indexY );
							g.drawOval(450 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(420 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY  );
							g.drawOval(480 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(300 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[24][indexY] = new Emplacement( 24, indexY );
							g.drawOval(600 ,350 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						}
						
						if(indexY == 29) {
							
							emplacements[5][indexY] = new Emplacement( 5, indexY );
							g.drawOval(450 ,50 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(420 ,50 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY  );
							g.drawOval(480 ,50 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(300 ,50 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[24][indexY] = new Emplacement( 24, indexY );
							g.drawOval(600 ,50 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
					}
					
					//line 4 & 14
						
					if( ( (indexY == 7) || (indexY == 27) ) && ( (indexX == 4) || (indexX == 6) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) || (indexX == 23) || (indexX == 25) ) ) {	
						
						if(indexY == 7) {
						
							emplacements[4][indexY] = new Emplacement( 4, indexY );
							g.drawOval(405 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[6][indexY] = new Emplacement( 6, indexY );
							g.drawOval(435 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(465 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(495 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(285 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(315 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[23][indexY] = new Emplacement( 23, indexY );
							g.drawOval(615 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[25][indexY] = new Emplacement( 25, indexY );
							g.drawOval(585 ,325 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						}
						
						if(indexY == 27) {
							
							emplacements[4][indexY] = new Emplacement( 4, indexY );
							g.drawOval(405 ,75 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[6][indexY] = new Emplacement( 6, indexY );
							g.drawOval(435 ,75 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(465 ,75 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(495 ,75 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(285 ,75 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(315 ,75 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[23][indexY] = new Emplacement( 23, indexY );
							g.drawOval(615 ,75 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[25][indexY] = new Emplacement( 25, indexY );
							g.drawOval(585 ,75 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
						
					}
					
					//line 5 & 13
					
					if( ( (indexY == 9) || (indexY == 25) ) && ( (indexX == 3) || (indexX == 5) || (indexX == 7) || (indexX == 9) || (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) || (indexX == 19) || (indexX ==  21) || (indexX == 23) || (indexX  == 25) || (indexX == 27) ) ) {	
						
						if(indexY == 9) {
													
							emplacements[3][indexY] = new Emplacement( 3, indexY );
							g.drawOval(270 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[5][indexY] = new Emplacement( 5, indexY );
							g.drawOval(300 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
					
							emplacements[7][indexY] = new Emplacement( 7, indexY );
							g.drawOval(330 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[9][indexY] = new Emplacement( 9, indexY );
							g.drawOval(360 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[11][indexY] = new Emplacement( 11, indexY );
							g.drawOval(390 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(420 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY );
							g.drawOval(450 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(480 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[19][indexY] = new Emplacement( 19, indexY );
							g.drawOval(510 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[21][indexY] = new Emplacement( 21, indexY );
							g.drawOval(540 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[23][indexY] = new Emplacement( 23, indexY );
							g.drawOval(570 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[25][indexY] = new Emplacement( 25, indexY );
							g.drawOval(600 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[27][indexY] = new Emplacement( 27, indexY );
							g.drawOval(630 ,300 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
						
						if(indexY == 25) {
							
							emplacements[3][indexY] = new Emplacement( 3, indexY );
							g.drawOval(270 ,100 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[5][indexY] = new Emplacement( 5, indexY );
							g.drawOval(300 ,100 , IDEAL_WIDTH, IDEAL_HEIGHT);
					
							emplacements[7][indexY] = new Emplacement( 7, indexY );
							g.drawOval(330 ,100 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[9][indexY] = new Emplacement( 9, indexY );
							g.drawOval(360 ,100 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[11][indexY] = new Emplacement( 11, indexY );
							g.drawOval(390 ,100 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(420 ,100 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY );
							g.drawOval(450 ,100 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(480 ,100 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[19][indexY] = new Emplacement( 19, indexY );
							g.drawOval(510 ,100 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[21][indexY] = new Emplacement( 21, indexY );
							g.drawOval(540 ,100 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[23][indexY] = new Emplacement( 23, indexY );
							g.drawOval(570 ,100 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[25][indexY] = new Emplacement( 25, indexY );
							g.drawOval(600 ,100 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[27][indexY] = new Emplacement( 27, indexY );
							g.drawOval(630 ,100 , IDEAL_WIDTH, IDEAL_HEIGHT);
						}
						
					}
					
					//line 6 & 12
					
					if( ( (indexY == 11) || (indexY == 23) ) && ( (indexX == 2) || (indexX == 4) || (indexX == 6) || (indexX == 8) || (indexX == 10) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) || (indexX == 20) || (indexX  == 22) || (indexX == 24) || (indexX == 26) || (indexX == 28) ) ) {	
						
						if(indexY == 11) {
						
							emplacements[2][indexY] = new Emplacement( 2, indexY );
							g.drawOval(255 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[4][indexY] = new Emplacement( 4, indexY );
							g.drawOval(285 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[6][indexY] = new Emplacement( 6, indexY );
							g.drawOval(315 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[8][indexY] = new Emplacement( 8, indexY );
							g.drawOval(345 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[10][indexY] = new Emplacement( 10, indexY );
							g.drawOval(375 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(405 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(435 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(465 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(495 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[20][indexY] = new Emplacement( 20, indexY );
							g.drawOval(525 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[22][indexY] = new Emplacement( 22, indexY );
							g.drawOval(555 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[24][indexY] = new Emplacement( 24, indexY );
							g.drawOval(585 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[26][indexY] = new Emplacement( 26, indexY );
							g.drawOval(615 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[28][indexY] = new Emplacement( 28, indexY );
							g.drawOval(645 ,275 , IDEAL_WIDTH, IDEAL_HEIGHT);
						}
						
						if(indexY == 23) {
							
							emplacements[2][indexY] = new Emplacement( 2, indexY );
							g.drawOval(255 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[4][indexY] = new Emplacement( 4, indexY );
							g.drawOval(285 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[6][indexY] = new Emplacement( 6, indexY );
							g.drawOval(315 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[8][indexY] = new Emplacement( 8, indexY );
							g.drawOval(345 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[10][indexY] = new Emplacement( 10, indexY );
							g.drawOval(375 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(405 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(435 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(465 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(495 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[20][indexY] = new Emplacement( 20, indexY );
							g.drawOval(525 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[22][indexY] = new Emplacement( 22, indexY );
							g.drawOval(555 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[24][indexY] = new Emplacement( 24, indexY );
							g.drawOval(585 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[26][indexY] = new Emplacement( 26, indexY );
							g.drawOval(615 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[28][indexY] = new Emplacement( 28, indexY );
							g.drawOval(645 ,125 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
					}
					
					//line 7 & 11
					
					if( ( (indexY == 13) || (indexY == 21) ) && ( (indexX == 1) || (indexX == 3) || (indexX == 5) || (indexX == 7) || (indexX == 9) || (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) || (indexX == 19) || (indexX == 21) || (indexX == 23) || (indexX == 25) || (indexX == 27) || (indexX == 29) ) ) {	
						
						if(indexY == 13) {
						
							emplacements[1][indexY] = new Emplacement( 1, indexY );
							g.drawOval(240 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[3][indexY] = new Emplacement( 3, indexY );
							g.drawOval(270 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[5][indexY] = new Emplacement( 5, indexY );
							g.drawOval(300 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[7][indexY] = new Emplacement( 7, indexY );
							g.drawOval(330 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[9][indexY] = new Emplacement( 9, indexY );
							g.drawOval(360 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[11][indexY] = new Emplacement( 11, indexY );
							g.drawOval(390 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(420 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY );
							g.drawOval(450 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(480 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[19][indexY] = new Emplacement( 19, indexY );
							g.drawOval(510 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[21][indexY] = new Emplacement( 21, indexY );
							g.drawOval(540 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[23][indexY] = new Emplacement( 23, indexY );
							g.drawOval(570 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[25][indexY] = new Emplacement( 25, indexY );
							g.drawOval(600 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[27][indexY] = new Emplacement( 27, indexY );
							g.drawOval(630 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[29][indexY] = new Emplacement( 29, indexY );
							g.drawOval(660 ,250 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						}
						
						if(indexY == 21) {
						
							emplacements[1][indexY] = new Emplacement( 1, indexY );
							g.drawOval(240 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[3][indexY] = new Emplacement( 3, indexY );
							g.drawOval(270 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[5][indexY] = new Emplacement( 5, indexY );
							g.drawOval(300 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[7][indexY] = new Emplacement( 7, indexY );
							g.drawOval(330 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[9][indexY] = new Emplacement( 9, indexY );
							g.drawOval(360 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[11][indexY] = new Emplacement( 11, indexY );
							g.drawOval(390 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[13][indexY] = new Emplacement( 13, indexY );
							g.drawOval(420 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[15][indexY] = new Emplacement( 15, indexY );
							g.drawOval(450 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[17][indexY] = new Emplacement( 17, indexY );
							g.drawOval(480 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[19][indexY] = new Emplacement( 19, indexY );
							g.drawOval(510 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[21][indexY] = new Emplacement( 21, indexY );
							g.drawOval(540 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[23][indexY] = new Emplacement( 23, indexY );
							g.drawOval(570 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[25][indexY] = new Emplacement( 25, indexY );
							g.drawOval(600 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[27][indexY] = new Emplacement( 27, indexY );
							g.drawOval(630 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[29][indexY] = new Emplacement( 29, indexY );
							g.drawOval(660 ,150 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
					}
					
					//line 8 & 10
					
					if( ( (indexY == 15) || (indexY == 19) ) && ( (indexX == 6) || (indexX == 8) || (indexX == 10) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) || (indexX == 20) || (indexX == 22) || (indexX == 24) ) ) {
						
						if(indexY == 15) {
						
							emplacements[6][indexY] = new Emplacement( 6, indexY );
							g.drawOval(315 ,225 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[8][indexY] = new Emplacement( 8, indexY );
							g.drawOval(345 ,225 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[10][indexY] = new Emplacement( 10, indexY );
							g.drawOval(375 ,225 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(405 ,225 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(435 ,225 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(465 ,225 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(495 ,225 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[20][indexY] = new Emplacement( 20, indexY );
							g.drawOval(525 ,225 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[22][indexY] = new Emplacement( 22, indexY );
							g.drawOval(555 ,225 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[24][indexY] = new Emplacement( 24, indexY );
							g.drawOval(585 ,225 , IDEAL_WIDTH, IDEAL_HEIGHT);
						}
						
						if(indexY == 19) {
							
							emplacements[6][indexY] = new Emplacement( 6, indexY );
							g.drawOval(315 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[8][indexY] = new Emplacement( 8, indexY );
							g.drawOval(345 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[10][indexY] = new Emplacement( 10, indexY );
							g.drawOval(375 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[12][indexY] = new Emplacement( 12, indexY );
							g.drawOval(405 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[14][indexY] = new Emplacement( 14, indexY );
							g.drawOval(435 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[16][indexY] = new Emplacement( 16, indexY );
							g.drawOval(465 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[18][indexY] = new Emplacement( 18, indexY );
							g.drawOval(495 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[20][indexY] = new Emplacement( 20, indexY );
							g.drawOval(525 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[22][indexY] = new Emplacement( 22, indexY );
							g.drawOval(555 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
							emplacements[24][indexY] = new Emplacement( 24, indexY );
							g.drawOval(585 ,175 , IDEAL_WIDTH, IDEAL_HEIGHT);
							
						}
					}
					
					//line 9
					
					if( (indexY == 17) && ( (indexX == 7) || (indexX == 9) || (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) || (indexX == 19) || (indexX == 21) || (indexX == 23) ) ) {
						
						emplacements[7][indexY] = new Emplacement( 7, indexY );
						g.drawOval(330 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[9][indexY] = new Emplacement( 9, indexY );
						g.drawOval(360 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[11][indexY] = new Emplacement( 11, indexY );
						g.drawOval(390 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[13][indexY] = new Emplacement( 13, indexY );
						g.drawOval(420 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[15][indexY] = new Emplacement( 15, indexY );
						g.drawOval(450 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[17][indexY] = new Emplacement( 17, indexY );
						g.drawOval(480 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[19][indexY] = new Emplacement( 19, indexY );
						g.drawOval(510 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[21][indexY] = new Emplacement( 21, indexY );
						g.drawOval(540 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
						
						emplacements[23][indexY] = new Emplacement( 23, indexY );
						g.drawOval(570 ,200 , IDEAL_WIDTH, IDEAL_HEIGHT);
					}
				}
			}
		}
		repaint();
	}
	
	public Board() {
		

	}
}


