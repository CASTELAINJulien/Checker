

package checker.core;

import checker.data.ClassFactory;
import checker.data.Emplacement;
import checker.gui.BoardParameter;

public class CheckerBuilder {
	private static CheckerBuilder instance = new CheckerBuilder();

	public CheckerBuilder() {
		// panelsContainer = (PanelsContainer) PanelsContainer.getInstance();
	}
	
	public static CheckerBuilder getInstance() {
		return instance;
	}
	
	// TODO - Voir ce qui ne vas pas pour le warning
	@SuppressWarnings("unchecked")
	public void initializeEmplacements() {
		/*
		for(int indexX = 0; indexX <= BoardParameter.doubleArrayRowCellsNumber; indexX++ ) {
			
			for(int indexY = 0; indexY <= BoardParameter.doubleArrayColumnCellNumber; indexY++ ) {
				
				if( indexY%2 != 0) {
					
					//line 1 & 17
				
					if( ( (indexY == 1) || (indexY == 33) ) && ( (indexX == 10) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) ) ) {
						
						if(indexY ==  1) {
							
							GameVariableRepository.getInstance().getEmplacementTable()[11][indexY] = ClassFactory.createEmplacement( 11, indexY, 1 );	
							GameVariableRepository.getInstance().getEmplacementTable()[13][indexY] = ClassFactory.createEmplacement( 13, indexY, 1  );	
							GameVariableRepository.getInstance().getEmplacementTable()[15][indexY] = ClassFactory.createEmplacement( 15, indexY, 1  );	
							GameVariableRepository.getInstance().getEmplacementTable()[17][indexY] = ClassFactory.createEmplacement( 17, indexY, 1  );	
							GameVariableRepository.getInstance().getEmplacementTable()[19][indexY] = ClassFactory.createEmplacement( 19, indexY, 1  );
						}
						
						if(indexY == 33) {
							
							GameVariableRepository.getInstance().getEmplacementTable()[11][indexY] = ClassFactory.createEmplacement( 11, indexY, 2 );		
							GameVariableRepository.getInstance().getEmplacementTable()[13][indexY] = ClassFactory.createEmplacement( 13, indexY, 2 );		
							GameVariableRepository.getInstance().getEmplacementTable()[13][indexY] = ClassFactory.createEmplacement( 15, indexY, 2 );		
							GameVariableRepository.getInstance().getEmplacementTable()[15][indexY] = ClassFactory.createEmplacement( 17, indexY, 2 );		
							GameVariableRepository.getInstance().getEmplacementTable()[17][indexY] = ClassFactory.createEmplacement( 19, indexY, 2 );
							
						}
					}
					
					//line 2 & 16
				
					if( ( (indexY == 3) || (indexY == 31) ) && ( (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) ) ) {	
						
						if(indexY == 3) {
						
							GameVariableRepository.getInstance().getEmplacementTable()[12][indexY] = ClassFactory.createEmplacement( 12, indexY, 1 );	
							GameVariableRepository.getInstance().getEmplacementTable()[14][indexY] = ClassFactory.createEmplacement( 14, indexY, 1 );	
							GameVariableRepository.getInstance().getEmplacementTable()[16][indexY] = ClassFactory.createEmplacement( 16, indexY, 1 );	
							GameVariableRepository.getInstance().getEmplacementTable()[18][indexY] = ClassFactory.createEmplacement( 18, indexY, 1 );
							
							
						}
						
						if(indexY == 31) {
							
							GameVariableRepository.getInstance().getEmplacementTable()[12][indexY] = ClassFactory.createEmplacement( 12, indexY, 2 );	
							GameVariableRepository.getInstance().getEmplacementTable()[14][indexY] = ClassFactory.createEmplacement( 14, indexY, 2 );	
							GameVariableRepository.getInstance().getEmplacementTable()[16][indexY] = ClassFactory.createEmplacement( 16, indexY, 2 );	
							GameVariableRepository.getInstance().getEmplacementTable()[18][indexY] = ClassFactory.createEmplacement( 18, indexY, 2 );
							
							
						}
						
					}
					
					//line 3 & 15
				
					if( ( (indexY == 5) || (indexY == 29) ) && ( (indexX == 4) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 23) ) ) {	
						
						if(indexY == 5) {
						
							GameVariableRepository.getInstance().getEmplacementTable()[5][indexY] = ClassFactory.createEmplacement( 5, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[13][indexY] = ClassFactory.createEmplacement( 13, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[15][indexY] = ClassFactory.createEmplacement( 15, indexY,1);	
							GameVariableRepository.getInstance().getEmplacementTable()[17][indexY] = ClassFactory.createEmplacement( 17, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[24][indexY] = ClassFactory.createEmplacement( 24, indexY);
							
						
						}
						
						if(indexY == 29) {
							
							GameVariableRepository.getInstance().getEmplacementTable()[5][indexY] = ClassFactory.createEmplacement( 5, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[13][indexY] = ClassFactory.createEmplacement( 13, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[15][indexY] = ClassFactory.createEmplacement( 15, indexY,2);	
							GameVariableRepository.getInstance().getEmplacementTable()[17][indexY] = ClassFactory.createEmplacement( 17, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[24][indexY] = ClassFactory.createEmplacement( 24, indexY);					
						}
					}
					
					//line 4 & 14
						
					if( ( (indexY == 7) || (indexY == 27) ) && ( (indexX == 4) || (indexX == 6) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) || (indexX == 23) || (indexX == 25) ) ) {	
						
						if(indexY == 7) {
						
							GameVariableRepository.getInstance().getEmplacementTable()[4][indexY] = ClassFactory.createEmplacement( 4, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[6][indexY] = ClassFactory.createEmplacement( 6, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[12][indexY] = ClassFactory.createEmplacement( 12, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[14][indexY] = ClassFactory.createEmplacement( 14, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[16][indexY] = ClassFactory.createEmplacement( 16, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[18][indexY] = ClassFactory.createEmplacement( 18, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[23][indexY] = ClassFactory.createEmplacement( 23, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[25][indexY] = ClassFactory.createEmplacement( 25, indexY);
						}
						
						if(indexY == 27) {
							
							GameVariableRepository.getInstance().getEmplacementTable()[4][indexY] = ClassFactory.createEmplacement( 4, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[6][indexY] = ClassFactory.createEmplacement( 6, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[12][indexY] = ClassFactory.createEmplacement( 12, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[14][indexY] = ClassFactory.createEmplacement( 14, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[16][indexY] = ClassFactory.createEmplacement( 16, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[18][indexY] = ClassFactory.createEmplacement( 18, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[23][indexY] = ClassFactory.createEmplacement( 23, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[25][indexY] = ClassFactory.createEmplacement( 25, indexY );
						}			
					}
					
					//line 5 & 13
					
					if( ( (indexY == 9) || (indexY == 25) ) && ( (indexX == 3) || (indexX == 5) || (indexX == 7) || (indexX == 9) || (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) || (indexX == 19) || (indexX ==  21) || (indexX == 23) || (indexX  == 25) || (indexX == 27) ) ) {	
						
						if(indexY == 9) {	
							GameVariableRepository.getInstance().getEmplacementTable()[3][indexY] = ClassFactory.createEmplacement( 3, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[5][indexY] = ClassFactory.createEmplacement( 5, indexY );
							GameVariableRepository.getInstance().getEmplacementTable()[7][indexY] = ClassFactory.createEmplacement( 7, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[9][indexY] = ClassFactory.createEmplacement( 9, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[11][indexY] = ClassFactory.createEmplacement( 11, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[13][indexY] = ClassFactory.createEmplacement( 13, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[15][indexY] = ClassFactory.createEmplacement( 15, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[17][indexY] = ClassFactory.createEmplacement( 17, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[19][indexY] = ClassFactory.createEmplacement( 19, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[21][indexY] = ClassFactory.createEmplacement( 21, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[23][indexY] = ClassFactory.createEmplacement( 23, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[25][indexY] = ClassFactory.createEmplacement( 25, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[27][indexY] = ClassFactory.createEmplacement( 27, indexY );	
						}
						
						if(indexY == 25) {
							
							GameVariableRepository.getInstance().getEmplacementTable()[3][indexY] = ClassFactory.createEmplacement( 3, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[5][indexY] = ClassFactory.createEmplacement( 5, indexY );
							GameVariableRepository.getInstance().getEmplacementTable()[7][indexY] = ClassFactory.createEmplacement( 7, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[9][indexY] = ClassFactory.createEmplacement( 9, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[11][indexY] = ClassFactory.createEmplacement( 11, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[13][indexY] = ClassFactory.createEmplacement( 13, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[15][indexY] = ClassFactory.createEmplacement( 15, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[17][indexY] = ClassFactory.createEmplacement( 17, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[19][indexY] = ClassFactory.createEmplacement( 19, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[21][indexY] = ClassFactory.createEmplacement( 21, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[23][indexY] = ClassFactory.createEmplacement( 23, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[25][indexY] = ClassFactory.createEmplacement( 25, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[27][indexY] = ClassFactory.createEmplacement( 27, indexY );
							
						}
						
					}
					
					//line 6 & 12
					
					if( ( (indexY == 11) || (indexY == 23) ) && ( (indexX == 2) || (indexX == 4) || (indexX == 6) || (indexX == 8) || (indexX == 10) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) || (indexX == 20) || (indexX  == 22) || (indexX == 24) || (indexX == 26) || (indexX == 28) ) ) {	
						
						if(indexY == 11) {
						
							GameVariableRepository.getInstance().getEmplacementTable()[2][indexY] = ClassFactory.createEmplacement( 2, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[4][indexY] = ClassFactory.createEmplacement( 4, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[6][indexY] = ClassFactory.createEmplacement( 6, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[8][indexY] = ClassFactory.createEmplacement( 8, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[10][indexY] = ClassFactory.createEmplacement( 10, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[12][indexY] = ClassFactory.createEmplacement( 12, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[14][indexY] = ClassFactory.createEmplacement( 14, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[16][indexY] = ClassFactory.createEmplacement( 16, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[18][indexY] = ClassFactory.createEmplacement( 18, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[20][indexY] = ClassFactory.createEmplacement( 20, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[22][indexY] = ClassFactory.createEmplacement( 22, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[24][indexY] = ClassFactory.createEmplacement( 24, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[26][indexY] = ClassFactory.createEmplacement( 26, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[28][indexY] = ClassFactory.createEmplacement( 28, indexY );
							
						}
						
						if(indexY == 23) {
							
							GameVariableRepository.getInstance().getEmplacementTable()[2][indexY] = ClassFactory.createEmplacement( 2, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[4][indexY] = ClassFactory.createEmplacement( 4, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[6][indexY] = ClassFactory.createEmplacement( 6, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[8][indexY] = ClassFactory.createEmplacement( 8, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[10][indexY] = ClassFactory.createEmplacement( 10, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[12][indexY] = ClassFactory.createEmplacement( 12, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[14][indexY] = ClassFactory.createEmplacement( 14, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[16][indexY] = ClassFactory.createEmplacement( 16, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[18][indexY] = ClassFactory.createEmplacement( 18, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[20][indexY] = ClassFactory.createEmplacement( 20, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[22][indexY] = ClassFactory.createEmplacement( 22, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[24][indexY] = ClassFactory.createEmplacement( 24, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[26][indexY] = ClassFactory.createEmplacement( 26, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[28][indexY] = ClassFactory.createEmplacement( 28, indexY );
							
							
						}
					}
					
					//line 7 & 11
					
					if( ( (indexY == 13) || (indexY == 21) ) && ( (indexX == 1) || (indexX == 3) || (indexX == 5) || (indexX == 7) || (indexX == 9) || (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) || (indexX == 19) || (indexX == 21) || (indexX == 23) || (indexX == 25) || (indexX == 27) || (indexX == 29) ) ) {	
						
						if(indexY == 13) {
						
							GameVariableRepository.getInstance().getEmplacementTable()[1][indexY] = ClassFactory.createEmplacement( 1, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[3][indexY] = ClassFactory.createEmplacement( 3, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[5][indexY] = ClassFactory.createEmplacement( 5, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[7][indexY] = ClassFactory.createEmplacement( 7, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[9][indexY] = ClassFactory.createEmplacement( 9, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[11][indexY] = ClassFactory.createEmplacement( 11, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[13][indexY] = ClassFactory.createEmplacement( 13, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[15][indexY] = ClassFactory.createEmplacement( 15, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[17][indexY] = ClassFactory.createEmplacement( 17, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[19][indexY] = ClassFactory.createEmplacement( 19, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[21][indexY] = ClassFactory.createEmplacement( 21, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[23][indexY] = ClassFactory.createEmplacement( 23, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[25][indexY] = ClassFactory.createEmplacement( 25, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[27][indexY] = ClassFactory.createEmplacement( 27, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[29][indexY] = ClassFactory.createEmplacement( 29, indexY );
							
						
						}
						
						if(indexY == 21) {
						
							GameVariableRepository.getInstance().getEmplacementTable()[1][indexY] = ClassFactory.createEmplacement( 1, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[3][indexY] = ClassFactory.createEmplacement( 3, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[5][indexY] = ClassFactory.createEmplacement( 5, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[7][indexY] = ClassFactory.createEmplacement( 7, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[9][indexY] = ClassFactory.createEmplacement( 9, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[11][indexY] = ClassFactory.createEmplacement( 11, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[13][indexY] = ClassFactory.createEmplacement( 13, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[15][indexY] = ClassFactory.createEmplacement( 15, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[17][indexY] = ClassFactory.createEmplacement( 17, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[19][indexY] = ClassFactory.createEmplacement( 19, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[21][indexY] = ClassFactory.createEmplacement( 21, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[23][indexY] = ClassFactory.createEmplacement( 23, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[25][indexY] = ClassFactory.createEmplacement( 25, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[27][indexY] = ClassFactory.createEmplacement( 27, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[29][indexY] = ClassFactory.createEmplacement( 29, indexY );
							
							
						}
					}
					
					//line 8 & 10
					
					if( ( (indexY == 15) || (indexY == 19) ) && ( (indexX == 6) || (indexX == 8) || (indexX == 10) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) || (indexX == 20) || (indexX == 22) || (indexX == 24) ) ) {
						
						if(indexY == 15) {
						
							GameVariableRepository.getInstance().getEmplacementTable()[6][indexY] = ClassFactory.createEmplacement( 6, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[8][indexY] = ClassFactory.createEmplacement( 8, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[10][indexY] = ClassFactory.createEmplacement( 10, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[12][indexY] = ClassFactory.createEmplacement( 12, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[14][indexY] = ClassFactory.createEmplacement( 14, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[16][indexY] = ClassFactory.createEmplacement( 16, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[18][indexY] = ClassFactory.createEmplacement( 18, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[20][indexY] = ClassFactory.createEmplacement( 20, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[22][indexY] = ClassFactory.createEmplacement( 22, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[24][indexY] = ClassFactory.createEmplacement( 24, indexY );
							
						}
						
						if(indexY == 19) {
							
							GameVariableRepository.getInstance().getEmplacementTable()[6][indexY] = ClassFactory.createEmplacement( 6, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[8][indexY] = ClassFactory.createEmplacement( 8, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[10][indexY] = ClassFactory.createEmplacement( 10, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[12][indexY] = ClassFactory.createEmplacement( 12, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[14][indexY] = ClassFactory.createEmplacement( 14, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[16][indexY] = ClassFactory.createEmplacement( 16, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[18][indexY] = ClassFactory.createEmplacement( 18, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[20][indexY] = ClassFactory.createEmplacement( 20, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[22][indexY] = ClassFactory.createEmplacement( 22, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[24][indexY] = ClassFactory.createEmplacement( 24, indexY );
							
							
						}
					}
					
					//line 9
					
					if( (indexY == 17) && ( (indexX == 7) || (indexX == 9) || (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) || (indexX == 19) || (indexX == 21) || (indexX == 23) ) ) {
						
						GameVariableRepository.getInstance().getEmplacementTable()[7][indexY] = ClassFactory.createEmplacement( 7, indexY );
						GameVariableRepository.getInstance().getEmplacementTable()[9][indexY] = ClassFactory.createEmplacement( 9, indexY );
						GameVariableRepository.getInstance().getEmplacementTable()[11][indexY] = ClassFactory.createEmplacement( 11, indexY );
						GameVariableRepository.getInstance().getEmplacementTable()[13][indexY] = ClassFactory.createEmplacement( 13, indexY );
						GameVariableRepository.getInstance().getEmplacementTable()[15][indexY] = ClassFactory.createEmplacement( 15, indexY );
						GameVariableRepository.getInstance().getEmplacementTable()[17][indexY] = ClassFactory.createEmplacement( 17, indexY );
						GameVariableRepository.getInstance().getEmplacementTable()[19][indexY] = ClassFactory.createEmplacement( 19, indexY );
						GameVariableRepository.getInstance().getEmplacementTable()[21][indexY] = ClassFactory.createEmplacement( 21, indexY );
						GameVariableRepository.getInstance().getEmplacementTable()[23][indexY] = ClassFactory.createEmplacement( 23, indexY );
						
					}
				}
			}
		}
		*/
  		GameVariableRepository.getInstance().getEmplacementTable()[11][1] = ClassFactory.createEmplacement(11,1, 4);
		GameVariableRepository.getInstance().getEmplacementTable()[13][1] = ClassFactory.createEmplacement( 13, 1, 4);	
		GameVariableRepository.getInstance().getEmplacementTable()[15][1] = ClassFactory.createEmplacement( 15, 1, 4);
		GameVariableRepository.getInstance().getEmplacementTable()[17][1] = ClassFactory.createEmplacement( 17, 1, 4);
		GameVariableRepository.getInstance().getEmplacementTable()[19][1] = ClassFactory.createEmplacement( 19, 1, 4);
		GameVariableRepository.getInstance().getEmplacementTable()[11][33] = ClassFactory.createEmplacement( 11, 33, 1);		
		GameVariableRepository.getInstance().getEmplacementTable()[13][33] = ClassFactory.createEmplacement( 13, 33, 1);
		GameVariableRepository.getInstance().getEmplacementTable()[15][33] = ClassFactory.createEmplacement( 15, 33, 1);
		GameVariableRepository.getInstance().getEmplacementTable()[17][33] = ClassFactory.createEmplacement( 17, 33, 1);
		GameVariableRepository.getInstance().getEmplacementTable()[19][33] = ClassFactory.createEmplacement( 19, 33, 1);

	//line 2 & 16

		GameVariableRepository.getInstance().getEmplacementTable()[12][3] = ClassFactory.createEmplacement( 12, 3, 4);
		GameVariableRepository.getInstance().getEmplacementTable()[14][3] = ClassFactory.createEmplacement( 14, 3, 4);
		GameVariableRepository.getInstance().getEmplacementTable()[16][3] = ClassFactory.createEmplacement( 16, 3, 4);
		GameVariableRepository.getInstance().getEmplacementTable()[18][3] = ClassFactory.createEmplacement( 18, 3, 4);

		GameVariableRepository.getInstance().getEmplacementTable()[12][31] = ClassFactory.createEmplacement( 12, 31, 1);
		GameVariableRepository.getInstance().getEmplacementTable()[14][31] = ClassFactory.createEmplacement( 14, 31, 1);
		GameVariableRepository.getInstance().getEmplacementTable()[16][31] = ClassFactory.createEmplacement( 16, 31, 1);
		GameVariableRepository.getInstance().getEmplacementTable()[18][31] = ClassFactory.createEmplacement( 18, 31, 1);	

	//line 3 & 15

		GameVariableRepository.getInstance().getEmplacementTable()[5][5] = ClassFactory.createEmplacement( 5, 5, 2);
		GameVariableRepository.getInstance().getEmplacementTable()[13][5] = ClassFactory.createEmplacement( 13, 5 );
		GameVariableRepository.getInstance().getEmplacementTable()[15][5] = ClassFactory.createEmplacement( 15, 5, 4);
		GameVariableRepository.getInstance().getEmplacementTable()[17][5] = ClassFactory.createEmplacement( 17, 5 );
		GameVariableRepository.getInstance().getEmplacementTable()[25][5] = ClassFactory.createEmplacement( 25, 5, 3);

		GameVariableRepository.getInstance().getEmplacementTable()[5][29] = ClassFactory.createEmplacement( 5, 29, 6);
		GameVariableRepository.getInstance().getEmplacementTable()[13][29] = ClassFactory.createEmplacement( 13, 29 );
		GameVariableRepository.getInstance().getEmplacementTable()[15][29] = ClassFactory.createEmplacement( 15, 29, 1);
		GameVariableRepository.getInstance().getEmplacementTable()[17][29] = ClassFactory.createEmplacement( 17, 29 );
		GameVariableRepository.getInstance().getEmplacementTable()[25][29] = ClassFactory.createEmplacement( 25, 29, 5);

	//line 4 & 14
	
		GameVariableRepository.getInstance().getEmplacementTable()[4][7] = ClassFactory.createEmplacement( 4, 7, 2);
		GameVariableRepository.getInstance().getEmplacementTable()[6][7] = ClassFactory.createEmplacement( 6, 7, 2);
		GameVariableRepository.getInstance().getEmplacementTable()[12][7] = ClassFactory.createEmplacement( 12, 7 );
		GameVariableRepository.getInstance().getEmplacementTable()[14][7] = ClassFactory.createEmplacement( 14, 7 );
		GameVariableRepository.getInstance().getEmplacementTable()[16][7] = ClassFactory.createEmplacement( 16, 7 );
		GameVariableRepository.getInstance().getEmplacementTable()[18][7] = ClassFactory.createEmplacement( 18, 7 );
		GameVariableRepository.getInstance().getEmplacementTable()[24][7] = ClassFactory.createEmplacement( 24, 7, 3);
		GameVariableRepository.getInstance().getEmplacementTable()[26][7] = ClassFactory.createEmplacement( 26, 7, 3);

		GameVariableRepository.getInstance().getEmplacementTable()[4][27] = ClassFactory.createEmplacement( 4, 27, 6);
		GameVariableRepository.getInstance().getEmplacementTable()[6][27] = ClassFactory.createEmplacement( 6, 27, 6);
		GameVariableRepository.getInstance().getEmplacementTable()[12][27] = ClassFactory.createEmplacement( 12, 27 );
		GameVariableRepository.getInstance().getEmplacementTable()[14][27] = ClassFactory.createEmplacement( 14, 27 );
		GameVariableRepository.getInstance().getEmplacementTable()[16][27] = ClassFactory.createEmplacement( 16, 27 );
		GameVariableRepository.getInstance().getEmplacementTable()[18][27] = ClassFactory.createEmplacement( 18, 27 );
		GameVariableRepository.getInstance().getEmplacementTable()[24][27] = ClassFactory.createEmplacement( 24, 27, 5);
		GameVariableRepository.getInstance().getEmplacementTable()[26][27] = ClassFactory.createEmplacement( 26, 27, 5);

	//line 5 & 13
	
		GameVariableRepository.getInstance().getEmplacementTable()[3][9] = ClassFactory.createEmplacement( 3, 9, 2);
		GameVariableRepository.getInstance().getEmplacementTable()[5][9] = ClassFactory.createEmplacement( 5, 9, 2);
		GameVariableRepository.getInstance().getEmplacementTable()[7][9] = ClassFactory.createEmplacement( 7, 9 );
		GameVariableRepository.getInstance().getEmplacementTable()[9][9] = ClassFactory.createEmplacement( 9, 9 );
		GameVariableRepository.getInstance().getEmplacementTable()[11][9] = ClassFactory.createEmplacement( 11, 9 );
		GameVariableRepository.getInstance().getEmplacementTable()[13][9] = ClassFactory.createEmplacement( 13, 9 );
		GameVariableRepository.getInstance().getEmplacementTable()[15][9] = ClassFactory.createEmplacement( 15, 9 );
		GameVariableRepository.getInstance().getEmplacementTable()[17][9] = ClassFactory.createEmplacement( 17, 9 );
		GameVariableRepository.getInstance().getEmplacementTable()[19][9] = ClassFactory.createEmplacement( 19, 9 );
		GameVariableRepository.getInstance().getEmplacementTable()[21][9] = ClassFactory.createEmplacement( 21, 9 );
		GameVariableRepository.getInstance().getEmplacementTable()[23][9] = ClassFactory.createEmplacement( 23, 9 );
		GameVariableRepository.getInstance().getEmplacementTable()[25][9] = ClassFactory.createEmplacement( 25, 9, 3);
		GameVariableRepository.getInstance().getEmplacementTable()[27][9] = ClassFactory.createEmplacement( 27, 9, 3);	

		GameVariableRepository.getInstance().getEmplacementTable()[3][25] = ClassFactory.createEmplacement( 3, 25, 6);
		GameVariableRepository.getInstance().getEmplacementTable()[5][25] = ClassFactory.createEmplacement( 5, 25, 6);
		GameVariableRepository.getInstance().getEmplacementTable()[7][25] = ClassFactory.createEmplacement( 7, 25 );
		GameVariableRepository.getInstance().getEmplacementTable()[9][25] = ClassFactory.createEmplacement( 9, 25 );	
		GameVariableRepository.getInstance().getEmplacementTable()[11][25] = ClassFactory.createEmplacement( 11, 25 );	
		GameVariableRepository.getInstance().getEmplacementTable()[13][25] = ClassFactory.createEmplacement( 13, 25 );	
		GameVariableRepository.getInstance().getEmplacementTable()[15][25] = ClassFactory.createEmplacement( 15, 25 );	
		GameVariableRepository.getInstance().getEmplacementTable()[17][25] = ClassFactory.createEmplacement( 17, 25 );	
		GameVariableRepository.getInstance().getEmplacementTable()[19][25] = ClassFactory.createEmplacement( 19, 25 );	
		GameVariableRepository.getInstance().getEmplacementTable()[21][25] = ClassFactory.createEmplacement( 21, 25 );	
		GameVariableRepository.getInstance().getEmplacementTable()[23][25] = ClassFactory.createEmplacement( 23, 25 );	
		GameVariableRepository.getInstance().getEmplacementTable()[25][25] = ClassFactory.createEmplacement( 25, 25, 5);
		GameVariableRepository.getInstance().getEmplacementTable()[27][25] = ClassFactory.createEmplacement( 27, 25, 5);

	//line 6 & 12

		GameVariableRepository.getInstance().getEmplacementTable()[2][11] = ClassFactory.createEmplacement( 2, 11, 2);
		GameVariableRepository.getInstance().getEmplacementTable()[4][11] = ClassFactory.createEmplacement( 4, 11, 2);
		GameVariableRepository.getInstance().getEmplacementTable()[6][11] = ClassFactory.createEmplacement( 6, 11, 2);
		GameVariableRepository.getInstance().getEmplacementTable()[8][11] = ClassFactory.createEmplacement( 8, 11 );
		GameVariableRepository.getInstance().getEmplacementTable()[10][11] = ClassFactory.createEmplacement( 10, 11 );
		GameVariableRepository.getInstance().getEmplacementTable()[12][11] = ClassFactory.createEmplacement( 12, 11 );	
		GameVariableRepository.getInstance().getEmplacementTable()[14][11] = ClassFactory.createEmplacement( 14, 11 );
		GameVariableRepository.getInstance().getEmplacementTable()[16][11] = ClassFactory.createEmplacement( 16, 11 );
		GameVariableRepository.getInstance().getEmplacementTable()[18][11] = ClassFactory.createEmplacement( 18, 11 );
		GameVariableRepository.getInstance().getEmplacementTable()[20][11] = ClassFactory.createEmplacement( 20, 11 );	
		GameVariableRepository.getInstance().getEmplacementTable()[22][11] = ClassFactory.createEmplacement( 22, 11 );
		GameVariableRepository.getInstance().getEmplacementTable()[24][11] = ClassFactory.createEmplacement( 24, 11, 3);
		GameVariableRepository.getInstance().getEmplacementTable()[26][11] = ClassFactory.createEmplacement( 26, 11, 3);
		GameVariableRepository.getInstance().getEmplacementTable()[28][11] = ClassFactory.createEmplacement( 28, 11, 3);

		GameVariableRepository.getInstance().getEmplacementTable()[2][23] = ClassFactory.createEmplacement( 2, 23, 6);
		GameVariableRepository.getInstance().getEmplacementTable()[4][23] = ClassFactory.createEmplacement( 4, 23, 6);
		GameVariableRepository.getInstance().getEmplacementTable()[6][23] = ClassFactory.createEmplacement( 6, 23, 6);
		GameVariableRepository.getInstance().getEmplacementTable()[8][23] = ClassFactory.createEmplacement( 8, 23 );
		GameVariableRepository.getInstance().getEmplacementTable()[10][23] = ClassFactory.createEmplacement( 10, 23 );
		GameVariableRepository.getInstance().getEmplacementTable()[12][23] = ClassFactory.createEmplacement( 12, 23 );
		GameVariableRepository.getInstance().getEmplacementTable()[14][23] = ClassFactory.createEmplacement( 14, 23 );
		GameVariableRepository.getInstance().getEmplacementTable()[16][23] = ClassFactory.createEmplacement( 16, 23 );
		GameVariableRepository.getInstance().getEmplacementTable()[18][23] = ClassFactory.createEmplacement( 18, 23 );
		GameVariableRepository.getInstance().getEmplacementTable()[20][23] = ClassFactory.createEmplacement( 20, 23 );
		GameVariableRepository.getInstance().getEmplacementTable()[22][23] = ClassFactory.createEmplacement( 22, 23 );	
		GameVariableRepository.getInstance().getEmplacementTable()[24][23] = ClassFactory.createEmplacement( 24, 23, 5);
		GameVariableRepository.getInstance().getEmplacementTable()[26][23] = ClassFactory.createEmplacement( 26, 23, 5);	
		GameVariableRepository.getInstance().getEmplacementTable()[28][23] = ClassFactory.createEmplacement( 28, 23, 5);

	//line 7 & 11

		GameVariableRepository.getInstance().getEmplacementTable()[1][13] = ClassFactory.createEmplacement( 1, 13, 2);
		GameVariableRepository.getInstance().getEmplacementTable()[3][13] = ClassFactory.createEmplacement( 3, 13, 2);
		GameVariableRepository.getInstance().getEmplacementTable()[5][13] = ClassFactory.createEmplacement( 5, 13 );
		GameVariableRepository.getInstance().getEmplacementTable()[7][13] = ClassFactory.createEmplacement( 7, 13 );
		GameVariableRepository.getInstance().getEmplacementTable()[9][13] = ClassFactory.createEmplacement( 9, 13 );
		GameVariableRepository.getInstance().getEmplacementTable()[11][13] = ClassFactory.createEmplacement( 11, 13 );
		GameVariableRepository.getInstance().getEmplacementTable()[13][13] = ClassFactory.createEmplacement( 13, 13 );
		GameVariableRepository.getInstance().getEmplacementTable()[15][13] = ClassFactory.createEmplacement( 15, 13 );
		GameVariableRepository.getInstance().getEmplacementTable()[17][13] = ClassFactory.createEmplacement( 17, 13 );
		GameVariableRepository.getInstance().getEmplacementTable()[19][13] = ClassFactory.createEmplacement( 19, 13 );
		GameVariableRepository.getInstance().getEmplacementTable()[21][13] = ClassFactory.createEmplacement( 21, 13 );
		GameVariableRepository.getInstance().getEmplacementTable()[23][13] = ClassFactory.createEmplacement( 23, 13 );
		GameVariableRepository.getInstance().getEmplacementTable()[25][13] = ClassFactory.createEmplacement( 25, 13 );
		GameVariableRepository.getInstance().getEmplacementTable()[27][13] = ClassFactory.createEmplacement( 27, 13, 3);
		GameVariableRepository.getInstance().getEmplacementTable()[29][13] = ClassFactory.createEmplacement( 29, 13, 3);

		GameVariableRepository.getInstance().getEmplacementTable()[1][21] = ClassFactory.createEmplacement( 1, 21, 6);
		GameVariableRepository.getInstance().getEmplacementTable()[3][21] = ClassFactory.createEmplacement( 3, 21, 6);
		GameVariableRepository.getInstance().getEmplacementTable()[5][21] = ClassFactory.createEmplacement( 5, 21 );
		GameVariableRepository.getInstance().getEmplacementTable()[7][21] = ClassFactory.createEmplacement( 7, 21 );
		GameVariableRepository.getInstance().getEmplacementTable()[9][21] = ClassFactory.createEmplacement( 9, 21 );
		GameVariableRepository.getInstance().getEmplacementTable()[11][21] = ClassFactory.createEmplacement( 11, 21 );
		GameVariableRepository.getInstance().getEmplacementTable()[13][21] = ClassFactory.createEmplacement( 13, 21 );
		GameVariableRepository.getInstance().getEmplacementTable()[15][21] = ClassFactory.createEmplacement( 15, 21 );
		GameVariableRepository.getInstance().getEmplacementTable()[17][21] = ClassFactory.createEmplacement( 17, 21 );
		GameVariableRepository.getInstance().getEmplacementTable()[19][21] = ClassFactory.createEmplacement( 19, 21 );
		GameVariableRepository.getInstance().getEmplacementTable()[21][21] = ClassFactory.createEmplacement( 21, 21 );
		GameVariableRepository.getInstance().getEmplacementTable()[23][21] = ClassFactory.createEmplacement( 23, 21 );
		GameVariableRepository.getInstance().getEmplacementTable()[25][21] = ClassFactory.createEmplacement( 25, 21 );
		GameVariableRepository.getInstance().getEmplacementTable()[27][21] = ClassFactory.createEmplacement( 27, 21, 5);
		GameVariableRepository.getInstance().getEmplacementTable()[29][21] = ClassFactory.createEmplacement( 29, 21, 5);

	//line 8 & 10

		GameVariableRepository.getInstance().getEmplacementTable()[6][15] = ClassFactory.createEmplacement( 6, 15 );
		GameVariableRepository.getInstance().getEmplacementTable()[8][15] = ClassFactory.createEmplacement( 8, 15 );
		GameVariableRepository.getInstance().getEmplacementTable()[10][15] = ClassFactory.createEmplacement( 10, 15 );
		GameVariableRepository.getInstance().getEmplacementTable()[12][15] = ClassFactory.createEmplacement( 12, 15 );
		GameVariableRepository.getInstance().getEmplacementTable()[14][15] = ClassFactory.createEmplacement( 14, 15 );
		GameVariableRepository.getInstance().getEmplacementTable()[16][15] = ClassFactory.createEmplacement( 16, 15 );
		GameVariableRepository.getInstance().getEmplacementTable()[18][15] = ClassFactory.createEmplacement( 18, 15 );
		GameVariableRepository.getInstance().getEmplacementTable()[20][15] = ClassFactory.createEmplacement( 20, 15 );
		GameVariableRepository.getInstance().getEmplacementTable()[22][15] = ClassFactory.createEmplacement( 22, 15 );
		GameVariableRepository.getInstance().getEmplacementTable()[24][15] = ClassFactory.createEmplacement( 24, 15 );

		GameVariableRepository.getInstance().getEmplacementTable()[6][19] = ClassFactory.createEmplacement( 6, 19 );
		GameVariableRepository.getInstance().getEmplacementTable()[8][19] = ClassFactory.createEmplacement( 8, 19 );
		GameVariableRepository.getInstance().getEmplacementTable()[10][19] = ClassFactory.createEmplacement( 10, 19 );
		GameVariableRepository.getInstance().getEmplacementTable()[12][19] = ClassFactory.createEmplacement( 12, 19 );
		GameVariableRepository.getInstance().getEmplacementTable()[14][19] = ClassFactory.createEmplacement( 14, 19 );
		GameVariableRepository.getInstance().getEmplacementTable()[16][19] = ClassFactory.createEmplacement( 16, 19 );
		GameVariableRepository.getInstance().getEmplacementTable()[18][19] = ClassFactory.createEmplacement( 18, 19 );
		GameVariableRepository.getInstance().getEmplacementTable()[20][19] = ClassFactory.createEmplacement( 20, 19 );
		GameVariableRepository.getInstance().getEmplacementTable()[22][19] = ClassFactory.createEmplacement( 22, 19 );
		GameVariableRepository.getInstance().getEmplacementTable()[24][19] = ClassFactory.createEmplacement( 24, 19 );	
		
	//line 9

		GameVariableRepository.getInstance().getEmplacementTable()[7][17] = ClassFactory.createEmplacement( 7, 17 );
		GameVariableRepository.getInstance().getEmplacementTable()[9][17] = ClassFactory.createEmplacement( 9, 17 );
		GameVariableRepository.getInstance().getEmplacementTable()[11][17] = ClassFactory.createEmplacement( 11, 17 );
		GameVariableRepository.getInstance().getEmplacementTable()[13][17] = ClassFactory.createEmplacement( 13, 17 );
		GameVariableRepository.getInstance().getEmplacementTable()[15][17] = ClassFactory.createEmplacement( 15, 17 );
		GameVariableRepository.getInstance().getEmplacementTable()[17][17] = ClassFactory.createEmplacement( 17, 17 );
		GameVariableRepository.getInstance().getEmplacementTable()[19][17] = ClassFactory.createEmplacement( 19, 17 );
		GameVariableRepository.getInstance().getEmplacementTable()[21][17] = ClassFactory.createEmplacement( 21, 17 );
		GameVariableRepository.getInstance().getEmplacementTable()[23][17] = ClassFactory.createEmplacement( 23, 17 ); 
		}
	
	public void initalizeArrayList() {
		
		
		
	}
}
