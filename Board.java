package checker;

public class Board {

	private Emplacement[][] emplacements;
	
	private final int x=29;
	private final int y=33;
	
	public Board() {
		
		emplacements = new Emplacement[x][y];
		
		for(int indexX = 0; indexX <= x; indexX++ ) {
			
			for(int indexY = 0; indexY <= y; indexY++ ) {
				
				if( indexY%2 != 0) {
				
					if( ( (indexY == 1) || (indexY == 33) ) && ( (indexX == 10) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) ) ) {
						emplacements[11][indexY] = new Emplacement( 11, indexY );
						emplacements[13][indexY] = new Emplacement( 13, indexY );
						emplacements[15][indexY] = new Emplacement( 15, indexY );
						emplacements[17][indexY] = new Emplacement( 17, indexY );
						emplacements[19][indexY] = new Emplacement( 19, indexY );
					}
				
					if( ( (indexY == 3) || (indexY == 31) ) && ( (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) ) ) {	
						emplacements[12][indexY] = new Emplacement( 12, indexY );
						emplacements[14][indexY] = new Emplacement( 14, indexY );
						emplacements[16][indexY] = new Emplacement( 16, indexY );
						emplacements[18][indexY] = new Emplacement( 18, indexY );
					}
				
					if( ( (indexY == 5) || (indexY == 29) ) && ( (indexX == 4) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 23) ) ) {	
						emplacements[5][indexY] = new Emplacement( 5, indexY );
						emplacements[13][indexY] = new Emplacement( 13, indexY );
						emplacements[15][indexY] = new Emplacement( 15, indexY  );
						emplacements[17][indexY] = new Emplacement( 17, indexY );
						emplacements[24][indexY] = new Emplacement( 24, indexY );
					}
						
					if( ( (indexY == 7) || (indexY == 27) ) && ( (indexX == 4) || (indexX == 6) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) || (indexX == 23) || (indexX == 25) ) ) {	
						emplacements[4][indexY] = new Emplacement( 4, indexY );
						emplacements[6][indexY] = new Emplacement( 6, indexY );
						emplacements[12][indexY] = new Emplacement( 12, indexY );
						emplacements[14][indexY] = new Emplacement( 14, indexY );
						emplacements[16][indexY] = new Emplacement( 16, indexY );
						emplacements[18][indexY] = new Emplacement( 18, indexY );
						emplacements[23][indexY] = new Emplacement( 23, indexY );
						emplacements[25][indexY] = new Emplacement( 25, indexY );
					}
					
					if( ( (indexY == 9) || (indexY == 25) ) && ( (indexX == 3) || (indexX == 5) || (indexX == 7) || (indexX == 9) || (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) || (indexX == 19) || (indexX ==  21) || (indexX == 23) || (indexX  == 25) || (indexX == 27) ) ) {	
						emplacements[3][indexY] = new Emplacement( 3, indexY );
						emplacements[5][indexY] = new Emplacement( 5, indexY );
						emplacements[7][indexY] = new Emplacement( 7, indexY );
						emplacements[9][indexY] = new Emplacement( 9, indexY );
						emplacements[11][indexY] = new Emplacement( 11, indexY );
						emplacements[13][indexY] = new Emplacement( 13, indexY );
						emplacements[15][indexY] = new Emplacement( 15, indexY );
						emplacements[17][indexY] = new Emplacement( 17, indexY );
						emplacements[19][indexY] = new Emplacement( 19, indexY );
						emplacements[21][indexY] = new Emplacement( 21, indexY );
						emplacements[23][indexY] = new Emplacement( 23, indexY );
						emplacements[25][indexY] = new Emplacement( 25, indexY );
						emplacements[27][indexY] = new Emplacement( 27, indexY );
					}
					
					if( ( (indexY == 11) || (indexY == 23) ) && ( (indexX == 2) || (indexX == 4) || (indexX == 6) || (indexX == 8) || (indexX == 10) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) || (indexX == 20) || (indexX  == 22) || (indexX == 24) || (indexX == 26) || (indexX == 28) ) ) {	
						emplacements[2][indexY] = new Emplacement( 2, indexY );
						emplacements[4][indexY] = new Emplacement( 4, indexY );
						emplacements[6][indexY] = new Emplacement( 6, indexY );
						emplacements[8][indexY] = new Emplacement( 8, indexY );
						emplacements[10][indexY] = new Emplacement( 10, indexY );
						emplacements[12][indexY] = new Emplacement( 12, indexY );
						emplacements[14][indexY] = new Emplacement( 14, indexY );
						emplacements[16][indexY] = new Emplacement( 16, indexY );
						emplacements[18][indexY] = new Emplacement( 18, indexY );
						emplacements[20][indexY] = new Emplacement( 20, indexY );
						emplacements[22][indexY] = new Emplacement( 22, indexY );
						emplacements[24][indexY] = new Emplacement( 24, indexY );
						emplacements[26][indexY] = new Emplacement( 26, indexY );
						emplacements[28][indexY] = new Emplacement( 28, indexY );
					}
					
					if( ( (indexY == 13) || (indexY == 21) ) && ( (indexX == 1) || (indexX == 3) || (indexX == 5) || (indexX == 7) || (indexX == 9) || (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) || (indexX == 19) || (indexX == 21) || (indexX == 23) || (indexX == 25) || (indexX == 27) || (indexX == 29) ) ) {	
						emplacements[1][indexY] = new Emplacement( 1, indexY );
						emplacements[3][indexY] = new Emplacement( 3, indexY );
						emplacements[5][indexY] = new Emplacement( 5, indexY );
						emplacements[7][indexY] = new Emplacement( 7, indexY );
						emplacements[9][indexY] = new Emplacement( 9, indexY );
						emplacements[11][indexY] = new Emplacement( 11, indexY );
						emplacements[13][indexY] = new Emplacement( 13, indexY );
						emplacements[15][indexY] = new Emplacement( 15, indexY );
						emplacements[17][indexY] = new Emplacement( 17, indexY );
						emplacements[19][indexY] = new Emplacement( 19, indexY );
						emplacements[21][indexY] = new Emplacement( 21, indexY );
						emplacements[23][indexY] = new Emplacement( 23, indexY );
						emplacements[25][indexY] = new Emplacement( 25, indexY );
						emplacements[27][indexY] = new Emplacement( 27, indexY );
						emplacements[29][indexY] = new Emplacement( 29, indexY );
					}
					
					if( ( (indexY == 15) || (indexY == 19) ) && ( (indexX == 6) || (indexX == 8) || (indexX == 10) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) || (indexX == 20) || (indexX == 22) || (indexX == 24) ) ) {
						emplacements[6][indexY] = new Emplacement( 6, indexY );
						emplacements[8][indexY] = new Emplacement( 8, indexY );
						emplacements[10][indexY] = new Emplacement( 10, indexY );
						emplacements[12][indexY] = new Emplacement( 12, indexY );
						emplacements[14][indexY] = new Emplacement( 14, indexY );
						emplacements[16][indexY] = new Emplacement( 16, indexY );
						emplacements[18][indexY] = new Emplacement( 18, indexY );
						emplacements[20][indexY] = new Emplacement( 20, indexY );
						emplacements[22][indexY] = new Emplacement( 22, indexY );
						emplacements[24][indexY] = new Emplacement( 24, indexY );
					}
					
					if( (indexY == 17) && ( (indexX == 7) || (indexX == 9) || (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) || (indexX == 19) || (indexX == 21) || (indexX == 23) ) ) {
						emplacements[7][indexY] = new Emplacement( 7, indexY );
						emplacements[9][indexY] = new Emplacement( 9, indexY );
						emplacements[11][indexY] = new Emplacement( 11, indexY );
						emplacements[13][indexY] = new Emplacement( 13, indexY );
						emplacements[15][indexY] = new Emplacement( 15, indexY );
						emplacements[17][indexY] = new Emplacement( 17, indexY );
						emplacements[19][indexY] = new Emplacement( 19, indexY );
						emplacements[21][indexY] = new Emplacement( 21, indexY );
						emplacements[23][indexY] = new Emplacement( 23, indexY );
					}
					
				}
			}
		}
	}
}


