package checker.core;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import checker.panels.Emplacement;
import checker.panels.PanelsContainer;

public class CheckerBuilder {
	

	public CheckerBuilder() {
		// panelsContainer = (PanelsContainer) PanelsContainer.getInstance();
	}
	
	public void initializeEmplacements() {
		
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement(11,1));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 13, 1 ));	
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 15, 1 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 17, 1 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 19, 1 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 11, 33 ));		
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 13, 33 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 15, 33 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 17, 33 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 19, 33 ));

	//line 2 & 16

		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 12, 3 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 14, 3 ));
		GameVariableRepository.getInstance().setEmplacementTable( new Emplacement( 16, 3 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 18, 3 ));

		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 12, 31 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 14, 31 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 16, 31 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 18, 31 ));	

	//line 3 & 15

		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 5, 5 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 13, 5 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 15, 5 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 17, 5 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 24, 5 ));

		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 5, 29 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 13, 29 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 15, 29 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 17, 29 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 24, 29 ));

	//line 4 & 14
	
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 4, 7 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 6, 7 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 12, 7 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 14, 7 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 16, 7 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 18, 7 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 23, 7 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 25, 7 ));

		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 4, 27 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 6, 27 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 12, 27 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 14, 27 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 16, 27 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 18, 27 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 23, 27 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 25, 27 ));

	//line 5 & 13
	
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 3, 9 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 5, 9 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 7, 9 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 9, 9 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 11, 9 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 13, 9 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 15, 9 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 17, 9 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 19, 9 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 21, 9 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 23, 9 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 25, 9 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 27, 9 ));	

		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 3, 25 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 5, 25 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 7, 25 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 9, 25 ));	
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 11, 25 ));	
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 13, 25 ));	
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 15, 25 ));	
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 17, 25 ));	
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 19, 25 ));	
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 21, 25 ));	
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 23, 25 ));	
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 25, 25 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 27, 25 ));

	//line 6 & 12

		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 2, 11 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 4, 11 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 6, 11 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 8, 11 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 10, 11 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 12, 11 ));	
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 14, 11 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 16, 11 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 18, 11 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 20, 11 ));	
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 22, 11 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 24, 11 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 26, 11 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 28, 11 ));

		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 2, 23 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 4, 23 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 6, 23 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 8, 23 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 10, 23 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 12, 23 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 14, 23 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 16, 23 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 18, 23 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 20, 23 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 22, 23 ));	
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 24, 23 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 26, 23 ));	
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 28, 23 ));

	//line 7 & 11

		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 1, 13 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 3, 13 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 5, 13 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 7, 13 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 9, 13 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 11, 13 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 13, 13 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 15, 13 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 17, 13 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 19, 13 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 21, 13 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 23, 13 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 25, 13 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 27, 13 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 29, 13 ));

		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 1, 21 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 3, 21 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 5, 21 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 7, 21 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 9, 21 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 11, 21 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 13, 21 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 15, 21 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 17, 21 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 19, 21 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 21, 21 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 23, 21 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 25, 21 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 27, 21 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 29, 21 ));

	//line 8 & 10

		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 6, 15 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 8, 15 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 10, 15 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 12, 15 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 14, 15 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 16, 15 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 18, 15 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 20, 15 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 22, 15 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 24, 15 ));

		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 6, 19 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 8, 19 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 10, 19 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 12, 19 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 14, 19 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 16, 19 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 18, 19 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 20, 19 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 22, 19 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 24, 19 ));	
		
	//line 9

		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 7, 17 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 9, 17 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 11, 17 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 13, 17 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 15, 17 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 17, 17 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 19, 17 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 21, 17 ));
		GameVariableRepository.getInstance().setEmplacementTable(new Emplacement( 23, 17 ));	
	}
	
	public void initalizeArrayList() {
		
		
		
	}
}
