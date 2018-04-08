package checker.data;

import java.util.ListIterator;
import java.util.Random;

import checker.core.BoardUpdater;
import checker.core.GameVariableRepository;

public class Ai {

	public Emplacement randomMove(Emplacement randomEmplacement) {
		 
		Emplacement randomEmplacementToGo=null;
		boolean aMoveIsPossible=false;
		int i = 0;
		 //check if an emplacement can receive the selected piece
		while ( i < GameVariableRepository.getInstance().getEmplacementsArrayList().size() && aMoveIsPossible == false ) {
			if(GameVariableRepository.getInstance().getEmplacementsArrayList().get(i).ifIsEligibleForMove()==true && GameVariableRepository.getInstance().getEmplacementsArrayList().get(i)!=randomEmplacement && GameVariableRepository.getInstance().getEmplacementsArrayList().get(i).getIsOccupied()==false) {
				aMoveIsPossible=true;
				aMoveIsPossible = true;
			}
			i++;
		}
		if(aMoveIsPossible==true) {
			Random random = new Random();			
			int randomIndex = random.nextInt(GameVariableRepository.getInstance().getEmplacementsArrayList().size());
			randomEmplacementToGo=GameVariableRepository.getInstance().getEmplacementsArrayList().get(randomIndex);
			
			while (randomEmplacementToGo.ifIsEligibleForMove() != true || randomEmplacementToGo.getIsOccupied()!=false ) {		 			
				randomIndex = random.nextInt(GameVariableRepository.getInstance().getEmplacementsArrayList().size());
				randomEmplacementToGo=GameVariableRepository.getInstance().getEmplacementsArrayList().get(randomIndex);
			}
		}

		//if impossible to move with the current piece, search an other piece
		else  {
			return randomSelection();
		}		
		return randomEmplacementToGo;
	}
	
	public Emplacement randomSelection() {
		boolean isOnEmplacementTemp = false;
		boolean isOccupiedTemp = false;
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
		Emplacement emplacementToGo=randomMove(randomEmplacement);
		   
		return emplacementToGo;
	} 
}