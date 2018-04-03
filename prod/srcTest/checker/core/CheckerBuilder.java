

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
		for(int indexX = 0; indexX <= BoardParameter.doubleArrayRowCellsNumber; indexX++ ) {
			
			for(int indexY = 0; indexY <= BoardParameter.doubleArrayColumnCellNumber; indexY++ ) {
				
				if( indexY%2 != 0) {
					
					//line 1 & 17
				
					if( ( (indexY == 1) || (indexY == 33) ) && ( (indexX == 10) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) ) ) {
						
						if(indexY ==  1) {
							// Zone d'arrivée 1
							GameVariableRepository.getInstance().getEmplacementTable()[11][indexY] = ClassFactory.createEmplacement( 11, indexY, 4);	
							GameVariableRepository.getInstance().getEmplacementTable()[13][indexY] = ClassFactory.createEmplacement( 13, indexY, 4 );	
							GameVariableRepository.getInstance().getEmplacementTable()[15][indexY] = ClassFactory.createEmplacement( 15, indexY, 4 );	
							GameVariableRepository.getInstance().getEmplacementTable()[17][indexY] = ClassFactory.createEmplacement( 17, indexY, 4 );	
							GameVariableRepository.getInstance().getEmplacementTable()[19][indexY] = ClassFactory.createEmplacement( 19, indexY, 4 );
						}
						
						if(indexY == 33) {
							
							GameVariableRepository.getInstance().getEmplacementTable()[11][indexY] = ClassFactory.createEmplacement( 11, indexY, 1 );		
							GameVariableRepository.getInstance().getEmplacementTable()[13][indexY] = ClassFactory.createEmplacement( 13, indexY, 1 );		
							GameVariableRepository.getInstance().getEmplacementTable()[15][indexY] = ClassFactory.createEmplacement( 15, indexY, 1 );
		
							GameVariableRepository.getInstance().getEmplacementTable()[17][indexY] = ClassFactory.createEmplacement( 17, indexY, 1 );
		
							GameVariableRepository.getInstance().getEmplacementTable()[19][indexY] = ClassFactory.createEmplacement( 19, indexY, 1 );

							
						}
					}
					
					//line 2 & 16
				
					if( ( (indexY == 3) || (indexY == 31) ) && ( (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) ) ) {		
						if(indexY == 3) {		
							// Zone d'arrivée 1 ligne 2
							GameVariableRepository.getInstance().getEmplacementTable()[12][indexY] = ClassFactory.createEmplacement( 12, indexY, 4);
										
							GameVariableRepository.getInstance().getEmplacementTable()[14][indexY] = ClassFactory.createEmplacement( 14, indexY, 4);
							
							GameVariableRepository.getInstance().getEmplacementTable()[16][indexY] = ClassFactory.createEmplacement( 16, indexY, 4);
										
							GameVariableRepository.getInstance().getEmplacementTable()[18][indexY] = ClassFactory.createEmplacement( 18, indexY, 4);
						}
						
						if(indexY == 31) {							
							GameVariableRepository.getInstance().getEmplacementTable()[12][indexY] = ClassFactory.createEmplacement( 12, indexY, 1);	
							GameVariableRepository.getInstance().getEmplacementTable()[14][indexY] = ClassFactory.createEmplacement( 14, indexY, 1 );	
							GameVariableRepository.getInstance().getEmplacementTable()[16][indexY] = ClassFactory.createEmplacement( 16, indexY, 1 );

							GameVariableRepository.getInstance().getEmplacementTable()[18][indexY] = ClassFactory.createEmplacement( 18, indexY, 1 );							
						}
						
					}
					
					//line 3 & 15
				
					if( ( (indexY == 5) || (indexY == 29) ) && ( (indexX == 4) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 23) ) ) {	
						
						if(indexY == 5) {						
							GameVariableRepository.getInstance().getEmplacementTable()[5][indexY] = ClassFactory.createEmplacement( 5, indexY, 2 );
							// Zone d'arrivée 1 dernier pion						
							GameVariableRepository.getInstance().getEmplacementTable()[13][indexY] = ClassFactory.createEmplacement( 13, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[15][indexY] = ClassFactory.createEmplacement( 15, indexY, 4);	
							GameVariableRepository.getInstance().getEmplacementTable()[17][indexY] = ClassFactory.createEmplacement( 17, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[25][indexY] = ClassFactory.createEmplacement( 25, indexY, 3);

						}
						
						if(indexY == 29) {							
							// Zone d'arrivée 2 ligne 5
							GameVariableRepository.getInstance().getEmplacementTable()[5][indexY] = ClassFactory.createEmplacement( 5, indexY, 6 );	
							GameVariableRepository.getInstance().getEmplacementTable()[13][indexY] = ClassFactory.createEmplacement( 13, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[15][indexY] = ClassFactory.createEmplacement( 15, indexY, 1);	
							GameVariableRepository.getInstance().getEmplacementTable()[17][indexY] = ClassFactory.createEmplacement( 17, indexY);
							// Zone d'arrivée 3 ligne 5
							GameVariableRepository.getInstance().getEmplacementTable()[24][indexY] = ClassFactory.createEmplacement( 24, indexY, 5 );					
						}
					}
					
					//line 4 & 14
					if( ( (indexY == 7) || (indexY == 27) ) && ( (indexX == 4) || (indexX == 6) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) || (indexX == 23) || (indexX == 25) ) ) {	
						if(indexY == 7) {						
							GameVariableRepository.getInstance().getEmplacementTable()[4][indexY] = ClassFactory.createEmplacement( 4, indexY, 2);	
							GameVariableRepository.getInstance().getEmplacementTable()[6][indexY] = ClassFactory.createEmplacement( 6, indexY, 2);	
							GameVariableRepository.getInstance().getEmplacementTable()[12][indexY] = ClassFactory.createEmplacement( 12, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[14][indexY] = ClassFactory.createEmplacement( 14, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[16][indexY] = ClassFactory.createEmplacement( 16, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[18][indexY] = ClassFactory.createEmplacement( 18, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[24][indexY] = ClassFactory.createEmplacement( 24, indexY, 3);	
							GameVariableRepository.getInstance().getEmplacementTable()[26][indexY] = ClassFactory.createEmplacement( 26, indexY, 3);
						}
						
						if(indexY == 27) {							
							// Zone d'arrivée 3 ligne 2
							GameVariableRepository.getInstance().getEmplacementTable()[4][indexY] = ClassFactory.createEmplacement( 4, indexY, 6 );
							// Zone d'arrivée 3 ligne 2						
							GameVariableRepository.getInstance().getEmplacementTable()[6][indexY] = ClassFactory.createEmplacement( 6, indexY, 6 );	
							GameVariableRepository.getInstance().getEmplacementTable()[12][indexY] = ClassFactory.createEmplacement( 12, indexY);	
							GameVariableRepository.getInstance().getEmplacementTable()[14][indexY] = ClassFactory.createEmplacement( 14, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[16][indexY] = ClassFactory.createEmplacement( 16, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[18][indexY] = ClassFactory.createEmplacement( 18, indexY );
							// Zone d'arrivée 2 ligne 4
							GameVariableRepository.getInstance().getEmplacementTable()[23][indexY] = ClassFactory.createEmplacement( 23, indexY, 5 );
							// Zone d'arrivée 2 ligne 4						
							GameVariableRepository.getInstance().getEmplacementTable()[25][indexY] = ClassFactory.createEmplacement( 25, indexY, 5 );
						}			
					}
					
					//line 5 & 13
					if( ( (indexY == 9) || (indexY == 25) ) && ( (indexX == 3) || (indexX == 5) || (indexX == 7) || (indexX == 9) || (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) || (indexX == 19) || (indexX ==  21) || (indexX == 23) || (indexX  == 25) || (indexX == 27) ) ) {	
						if(indexY == 9) 	
							GameVariableRepository.getInstance().getEmplacementTable()[3][indexY] = ClassFactory.createEmplacement( 3, indexY, 2 );	
							GameVariableRepository.getInstance().getEmplacementTable()[5][indexY] = ClassFactory.createEmplacement( 5, indexY, 2 );
							GameVariableRepository.getInstance().getEmplacementTable()[7][indexY] = ClassFactory.createEmplacement( 7, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[9][indexY] = ClassFactory.createEmplacement( 9, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[11][indexY] = ClassFactory.createEmplacement( 11, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[13][indexY] = ClassFactory.createEmplacement( 13, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[15][indexY] = ClassFactory.createEmplacement( 15, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[17][indexY] = ClassFactory.createEmplacement( 17, indexY );
							GameVariableRepository.getInstance().getEmplacementTable()[19][indexY] = ClassFactory.createEmplacement( 19, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[21][indexY] = ClassFactory.createEmplacement( 21, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[23][indexY] = ClassFactory.createEmplacement( 23, indexY );	
							GameVariableRepository.getInstance().getEmplacementTable()[25][indexY] = ClassFactory.createEmplacement( 25, indexY, 3 );	
							GameVariableRepository.getInstance().getEmplacementTable()[27][indexY] = ClassFactory.createEmplacement( 27, indexY, 3);	
						}
						
						if(indexY == 25) {
							// Zone d'arrivée 2 ligne 3
							GameVariableRepository.getInstance().getEmplacementTable()[3][indexY] = ClassFactory.createEmplacement( 3, indexY, 6 );

							// Zone d'arrivée 2 ligne 3					
							GameVariableRepository.getInstance().getEmplacementTable()[5][indexY] = ClassFactory.createEmplacement( 5, indexY, 6 );

							GameVariableRepository.getInstance().getEmplacementTable()[7][indexY] = ClassFactory.createEmplacement( 7, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[9][indexY] = ClassFactory.createEmplacement( 9, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[11][indexY] = ClassFactory.createEmplacement( 11, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[13][indexY] = ClassFactory.createEmplacement( 13, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[15][indexY] = ClassFactory.createEmplacement( 15, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[17][indexY] = ClassFactory.createEmplacement( 17, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[19][indexY] = ClassFactory.createEmplacement( 19, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[21][indexY] = ClassFactory.createEmplacement( 21, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[23][indexY] = ClassFactory.createEmplacement( 23, indexY );

							// Zone d'arrivée 3 ligne 4						
							GameVariableRepository.getInstance().getEmplacementTable()[25][indexY] = ClassFactory.createEmplacement( 25, indexY, 5 );

							// Zone d'arrivée 3 ligne 4						
							GameVariableRepository.getInstance().getEmplacementTable()[27][indexY] = ClassFactory.createEmplacement( 27, indexY, 5 );

							
						}
						
					}
					
					//line 6 & 12
					
					if( ( (indexY == 11) || (indexY == 23) ) && ( (indexX == 2) || (indexX == 4) || (indexX == 6) || (indexX == 8)|| (indexX == 10) || (indexX == 12) || (indexX == 14) || (indexX == 16) || (indexX == 18) || (indexX == 20) || (indexX  == 22) || (indexX == 24) || (indexX == 26) || (indexX == 28) ) ) {	
						
						if(indexY == 11) {
							
							GameVariableRepository.getInstance().getEmplacementTable()[2][indexY] = ClassFactory.createEmplacement( 2, indexY, 2 );

							
							GameVariableRepository.getInstance().getEmplacementTable()[4][indexY] = ClassFactory.createEmplacement( 4, indexY, 2 );

							
							GameVariableRepository.getInstance().getEmplacementTable()[6][indexY] = ClassFactory.createEmplacement( 6, indexY, 2 );
	
							GameVariableRepository.getInstance().getEmplacementTable()[8][indexY] = ClassFactory.createEmplacement( 8, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[10][indexY] = ClassFactory.createEmplacement( 10, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[12][indexY] = ClassFactory.createEmplacement( 12, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[14][indexY] = ClassFactory.createEmplacement( 14, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[16][indexY] = ClassFactory.createEmplacement( 16, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[18][indexY] = ClassFactory.createEmplacement( 18, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[20][indexY] = ClassFactory.createEmplacement( 20, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[22][indexY] = ClassFactory.createEmplacement( 22, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[24][indexY] = ClassFactory.createEmplacement( 24, indexY, 3 );
	
							GameVariableRepository.getInstance().getEmplacementTable()[26][indexY] = ClassFactory.createEmplacement( 26, indexY, 3 );
	
							GameVariableRepository.getInstance().getEmplacementTable()[28][indexY] = ClassFactory.createEmplacement( 28, indexY, 3 );

							
						}
						
						if(indexY == 23) {
							
							GameVariableRepository.getInstance().getEmplacementTable()[2][indexY] = ClassFactory.createEmplacement( 2, indexY, 6  );
	
							GameVariableRepository.getInstance().getEmplacementTable()[4][indexY] = ClassFactory.createEmplacement( 4, indexY, 6  );
	
							GameVariableRepository.getInstance().getEmplacementTable()[6][indexY] = ClassFactory.createEmplacement( 6, indexY, 6  );
	
							GameVariableRepository.getInstance().getEmplacementTable()[8][indexY] = ClassFactory.createEmplacement( 8, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[10][indexY] = ClassFactory.createEmplacement( 10, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[12][indexY] = ClassFactory.createEmplacement( 12, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[14][indexY] = ClassFactory.createEmplacement( 14, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[16][indexY] = ClassFactory.createEmplacement( 16, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[18][indexY] = ClassFactory.createEmplacement( 18, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[20][indexY] = ClassFactory.createEmplacement( 20, indexY );
	
							GameVariableRepository.getInstance().getEmplacementTable()[22][indexY] = ClassFactory.createEmplacement( 22, indexY );

							// Zone d'arrivée 3 ligne 2						
							GameVariableRepository.getInstance().getEmplacementTable()[24][indexY] = ClassFactory.createEmplacement( 24, indexY, 5 );

							// Zone d'arrivée 3 ligne 2						
							GameVariableRepository.getInstance().getEmplacementTable()[26][indexY] = ClassFactory.createEmplacement( 26, indexY, 5 );

							// Zone d'arrivée 3 ligne 2						
							GameVariableRepository.getInstance().getEmplacementTable()[28][indexY] = ClassFactory.createEmplacement( 28, indexY, 5 );

							
							
						}
					}
					
					//line 7 & 11
					
					if( ( (indexY == 13) || (indexY == 21) ) && ( (indexX == 1) || (indexX == 3) || (indexX == 5) || (indexX == 7) || (indexX == 9) || (indexX == 11) || (indexX == 13) || (indexX == 15) || (indexX == 17) || (indexX == 19) || (indexX == 21) || (indexX == 23) || (indexX == 25) || (indexX == 27) || (indexX == 29) ) ) {	
						
						if(indexY == 13) {
							
							GameVariableRepository.getInstance().getEmplacementTable()[1][indexY] = ClassFactory.createEmplacement( 1, indexY, 2 );

								
							GameVariableRepository.getInstance().getEmplacementTable()[3][indexY] = ClassFactory.createEmplacement( 3, indexY, 2 );
	
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
	
							GameVariableRepository.getInstance().getEmplacementTable()[27][indexY] = ClassFactory.createEmplacement( 27, indexY, 3 );
	
							GameVariableRepository.getInstance().getEmplacementTable()[29][indexY] = ClassFactory.createEmplacement( 29, indexY, 3 );

							
						
						}
						
						if(indexY == 21) {
							// Zone d'arrivée 2 ligne 1
							GameVariableRepository.getInstance().getEmplacementTable()[1][indexY] = ClassFactory.createEmplacement( 1, indexY, 6 );

							// Zone d'arrivée 2 ligne 1						
							GameVariableRepository.getInstance().getEmplacementTable()[3][indexY] = ClassFactory.createEmplacement( 3, indexY, 6 );
	
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

							// Zone d'arrivée 3 ligne 1						
							GameVariableRepository.getInstance().getEmplacementTable()[27][indexY] = ClassFactory.createEmplacement( 27, indexY, 5 );

							// Zone d'arrivée 3 ligne 1						
							GameVariableRepository.getInstance().getEmplacementTable()[29][indexY] = ClassFactory.createEmplacement( 29, indexY, 5 );

							
							
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
	
	public void initalizeArrayList() {
		
		
		
	}
}
