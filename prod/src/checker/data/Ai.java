package checker.data;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ListIterator;
import java.util.Random;

import checker.core.BoardUpdater;
import checker.core.GameVariableRepository;
import checker.core.VariableRepository;
import checker.panels.Board;
import customEventsPackage.Power;
import customEventsPackage.PowerControl;
import customEventsPackage.PowerFreeze;
import customEventsPackage.PowerJump;
import customEventsPackage.PowerTeleport;
import customEventsPackage.PowerTwoMoves;

public class Ai {

	public Emplacement randomMove(Emplacement randomEmplacement) {
		
		// Random random = new Random();			
		// int randomIndex = random.nextInt(GameVariableRepository.getInstance().getEmplacementsArrayList().size());
		 
		Emplacement randomEmplacementToGo=null;//=GameVariableRepository.getInstance().getEmplacementsArrayList().get(randomIndex);
		boolean aMoveIsPossible=false;
		 
		 //on parcourt pour vérifier si au moins un emplacement peut recevoir le pion selectionner
		for(int i=0;i<GameVariableRepository.getInstance().getEmplacementsArrayList().size();i++) {
			if(GameVariableRepository.getInstance().getEmplacementsArrayList().get(i).ifIsEligibleForMove()==true && GameVariableRepository.getInstance().getEmplacementsArrayList().get(i)!=randomEmplacement && GameVariableRepository.getInstance().getEmplacementsArrayList().get(i).getIsOccupied()==false) {
				aMoveIsPossible=true;
				System.out.println("solution trouvée");
			}
		}
		
		if(aMoveIsPossible==true) {
			System.out.println("mouv possible");
			Random random = new Random();			
			int randomIndex = random.nextInt(GameVariableRepository.getInstance().getEmplacementsArrayList().size());
			randomEmplacementToGo=GameVariableRepository.getInstance().getEmplacementsArrayList().get(randomIndex);
			
			
			//ENLEVER LE COMMENTAIRE DANS LE WHILE POUR IA "FOLLE"
			while (randomEmplacementToGo.ifIsEligibleForMove() != true  /*&& randomEmplacementToGo.getIsOccupied()!=false*/ ) {		 			
				randomIndex = random.nextInt(GameVariableRepository.getInstance().getEmplacementsArrayList().size());
				randomEmplacementToGo=GameVariableRepository.getInstance().getEmplacementsArrayList().get(randomIndex);
			}
		}
		
		
		
		//si aucun saut possible avec le pion selectionné
		else  {
			System.out.println("chercher un autre pion eligible");
			return randomSelection();
		}
		
        System.out.println("random selection to go OKKKKK");

		return randomEmplacementToGo;
	}
	
	
	
	public Emplacement randomSelection() {
			boolean isOnEmplacementTemp = false;//curseur sur empla
			boolean isOccupiedTemp = false;//piece sur empla
			boolean aPieceIsSelectedTemp = GameVariableRepository.getInstance().getAPieceIsSelected();

			ListIterator<Emplacement> iter = GameVariableRepository.getInstance().getEmplacementsArrayList().listIterator();
			if (GameVariableRepository.getInstance().getIsUpdating() == true ) {
				//return;
			}
			 Random random = new Random();			
	        int randomIndex = random.nextInt(GameVariableRepository.getInstance().getEmplacementsArrayList().size());
	        Emplacement randomEmplacement=GameVariableRepository.getInstance().getEmplacementsArrayList().get(randomIndex);

		
	        	Piece currentPiece = randomEmplacement.getOccupyingPiece();
		       
		       isOccupiedTemp = randomEmplacement.getIsOccupied();          
		      
		        while ( isOccupiedTemp == false || currentPiece == null  || currentPiece.getIsClickeable() == false ) {
		        	randomIndex = random.nextInt(GameVariableRepository.getInstance().getEmplacementsArrayList().size());
			        randomEmplacement=GameVariableRepository.getInstance().getEmplacementsArrayList().get(randomIndex);

			    	 currentPiece = randomEmplacement.getOccupyingPiece();  
				     isOccupiedTemp = randomEmplacement.getIsOccupied();  
				     
		        }
		       
		        GameVariableRepository.getInstance().setPreviousTurnEmplacementsArrayList( GameVariableRepository.getInstance().getEmplacementsArrayList() );
		        Piece pieceToBeSelected = randomEmplacement.getOccupyingPiece();    	
		        BoardUpdater.getInstance().updatePieceSelectionState(pieceToBeSelected, randomEmplacement);		
				System.out.println("random selection pion ok");
				 Emplacement emplacementToGo=randomMove(randomEmplacement);
		       
		        return emplacementToGo;
		        } 

		        
	//}
	




}




