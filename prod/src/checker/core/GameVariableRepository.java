package checker.core;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

import checker.data.Emplacement;
import checker.data.Piece;
import checker.gui.BoardParameter;

public class GameVariableRepository {
	// Number of real player in the game
	private int realPlayerCount;
	// Varies from 0 to 2, each digits indicating a player. Will varies between the turns.
	private int playerTurn;
	private String actualPlayerName;
	private String previousPlayerName;

	private ArrayList<Emplacement> emplacementsList;
	private Emplacement[][] emplacements;
	private HashMap<int[],Emplacement> emplacementsHashMap;
	private ArrayList<Emplacement> firstStartingAreaEmplacements;
	private ArrayList<Emplacement> secondStartingAreaEmplacements;
	private ArrayList<Emplacement> thirdStartingAreaEmplacements;
	private ArrayList<Emplacement> firstVictoryAreaEmplacements;
	private ArrayList<Emplacement> secondVictoryAreaEmplacements;
	private ArrayList<Emplacement> thirdVictoryAreaEmplacements;
	private ArrayList<Piece> firstPlayerPieces;
	private ArrayList<Piece> secondPlayerPieces;
	private ArrayList<Piece> thirdPlayerPieces;
	private ArrayList<Emplacement> fieldAreaEmplacements;
	private Piece selectedPiece;
	private Emplacement emplacementToBeEmptied;
	private boolean aPieceIsSelected;
	private boolean gameStarted;
	private boolean isUpdating;
	private int indexOfEmplacementToBeEmptied;
	private int nbRound=0;
	
	// Everything that concerned the last turn state data
	private ArrayList<Emplacement> previousTurnEmplacementsList;
	
	private GameVariableRepository() {
		this.emplacements = new Emplacement[BoardParameter.doubleArrayRowCellsNumber][BoardParameter.doubleArrayColumnCellNumber];
		this.emplacementsList = new ArrayList<Emplacement>();
		this.playerTurn = 0;
		this.actualPlayerName = "Player 1";
		this.firstStartingAreaEmplacements = new ArrayList<Emplacement>();
		this.secondStartingAreaEmplacements = new ArrayList<Emplacement>();
		this.thirdStartingAreaEmplacements = new ArrayList<Emplacement>();
		this.firstVictoryAreaEmplacements = new ArrayList<Emplacement>();
		this.secondVictoryAreaEmplacements = new ArrayList<Emplacement>();
		this.thirdVictoryAreaEmplacements = new ArrayList<Emplacement>();
		this.firstPlayerPieces = new ArrayList<Piece>();
		this.secondPlayerPieces = new ArrayList<Piece>();
		this.thirdPlayerPieces = new ArrayList<Piece>();
		this.fieldAreaEmplacements = new ArrayList<Emplacement>();
		this.selectedPiece = null;
		this.emplacementToBeEmptied = null;
		this.indexOfEmplacementToBeEmptied = 0;
		this.gameStarted = false;
		this.isUpdating = false;
		this.nbRound=0;
		this.emplacementsHashMap = new HashMap<int[],Emplacement>();
	}
	
	static GameVariableRepository instance = new GameVariableRepository();
	
	public void resetGameVariableRepository () {
		getInstance().emplacements = new Emplacement[BoardParameter.doubleArrayRowCellsNumber][BoardParameter.doubleArrayColumnCellNumber];
		getInstance().emplacementsList = new ArrayList<Emplacement>();
		getInstance().playerTurn = 0;
		getInstance().actualPlayerName = "Player 1";
		getInstance().firstStartingAreaEmplacements = new ArrayList<Emplacement>();
		getInstance().secondStartingAreaEmplacements = new ArrayList<Emplacement>();
		getInstance().thirdStartingAreaEmplacements = new ArrayList<Emplacement>();
		getInstance().firstVictoryAreaEmplacements = new ArrayList<Emplacement>();
		getInstance().secondVictoryAreaEmplacements = new ArrayList<Emplacement>();
		getInstance().thirdVictoryAreaEmplacements = new ArrayList<Emplacement>();
		getInstance().firstPlayerPieces = new ArrayList<Piece>();
		getInstance().secondPlayerPieces = new ArrayList<Piece>();
		getInstance().thirdPlayerPieces = new ArrayList<Piece>();
		getInstance().fieldAreaEmplacements = new ArrayList<Emplacement>();
		getInstance().selectedPiece = null;
		getInstance().emplacementToBeEmptied = null;
		getInstance().indexOfEmplacementToBeEmptied = 0;
		getInstance().gameStarted = false;
		getInstance().isUpdating = false;
		getInstance().nbRound=0;
		getInstance().emplacementsHashMap = new HashMap<int[],Emplacement>();
	}
	
	public static GameVariableRepository getInstance() {
		return instance;
	}
	
	public int incrementPlayerTurn() {
		this.playerTurn++;
		
		if ( playerTurn >= 3 ) {
			this.playerTurn = 0;
			this.nbRound++;
		}
		
		updateActualPlayerName();
		return this.playerTurn;
	}
	public int decrementPlayerTurnForCorrection() {
		this.playerTurn--;
		updateActualPlayerName();
		return this.playerTurn;
	}
	public int decrementPlayerTurnForPower() {
		this.playerTurn--;
		return this.playerTurn;
	}
	
	public HashMap<int[],Emplacement> getEmplacementsHashMap() {
		return this.emplacementsHashMap;
	}
	
	public int isSetEmplacement( int x, int y ) {
		boolean isSetEmplacement = false;
		// int[] keyArray = {x,y};
		
		// Map<String, String> map = ...
		// Interesting link for comparing two arrays => https://www.geeksforgeeks.org/compare-two-arrays-java/
		/*
		Iterator<Entry<int[], Emplacement>> iterator = this.emplacementsHashMap.entrySet().iterator();
		while(iterator.hasNext() && isSetEmplacement == false ){
			Entry<int[], Emplacement> entry = iterator.next();
			
			if ( ( entry.getKey()[0] == x ) && ( entry.getKey()[1] == y ) ) {
				return isSetEmplacement = true;
			}
		}
		*/
		ListIterator<Emplacement> listIterator = this.emplacementsList.listIterator();
		while(listIterator.hasNext() && isSetEmplacement == false ){
			// Entry<int[], Emplacement> entry = iterator.next();
			Emplacement currentEmplacement = listIterator.next();
			if ( currentEmplacement.getPositionX() == x && currentEmplacement.getPositionY() == y ) {
				return this.emplacementsList.indexOf(currentEmplacement);
			}
		}
		return -1;
	}
	
	
	public boolean checkIfVictoryState() {
		boolean itIsAVictory = false;
		boolean firstAreaNotFilledCorrectly = false;
		boolean secondAreaNotFilledCorrectly = false;
		boolean thirdAreaNotFilledCorrectly = false;
		ListIterator<Emplacement> listIterator = this.firstVictoryAreaEmplacements.listIterator();
		Color colorToCompare = null;
		// int 
		while(listIterator.hasNext() && itIsAVictory == false && firstAreaNotFilledCorrectly == false){
			// Entry<int[], Emplacement> entry = iterator.next();
			Emplacement currentEmplacement = listIterator.next();
			if( this.firstVictoryAreaEmplacements.indexOf(currentEmplacement) == 0) {
				if ( currentEmplacement.getIsOccupied() == true ) {
					colorToCompare = currentEmplacement.getOccupyingPiece().getColor();
				} else {
					firstAreaNotFilledCorrectly = true;
				}
			}
			
			if ( currentEmplacement.getIsOccupied() == true ) {
				if ( currentEmplacement.getOccupyingPiece().getColor() != colorToCompare) {
					firstAreaNotFilledCorrectly = true;
				}
			} else {
				firstAreaNotFilledCorrectly = true;
			}
			
			if ( this.firstVictoryAreaEmplacements.indexOf(currentEmplacement) == 9 ) {
				return itIsAVictory = true;
			}
		}
		
		listIterator = this.secondVictoryAreaEmplacements.listIterator();
		while(listIterator.hasNext() && itIsAVictory == false && secondAreaNotFilledCorrectly ){
			// Entry<int[], Emplacement> entry = iterator.next();
			Emplacement currentEmplacement = listIterator.next();
			if( this.secondStartingAreaEmplacements.indexOf(currentEmplacement) == 0) {
				if ( currentEmplacement.getIsOccupied() == true ) {
					colorToCompare = currentEmplacement.getOccupyingPiece().getColor();
				} else {
					secondAreaNotFilledCorrectly = true;
				}
			}
			
			if ( currentEmplacement.getIsOccupied() == true ) {
				if ( currentEmplacement.getOccupyingPiece().getColor() != colorToCompare) {
					secondAreaNotFilledCorrectly = true;
				}
			} else {
				secondAreaNotFilledCorrectly = true;
			}
			
			if ( this.secondVictoryAreaEmplacements.indexOf(currentEmplacement) == 9 ) {
				return itIsAVictory = true;
			}
			
		}
		
		listIterator = this.thirdVictoryAreaEmplacements.listIterator();
		while(listIterator.hasNext() && itIsAVictory == false && thirdAreaNotFilledCorrectly == false){
			// Entry<int[], Emplacement> entry = iterator.next();
			Emplacement currentEmplacement = listIterator.next();
			if( this.thirdStartingAreaEmplacements.indexOf(currentEmplacement) == 0) {
				if ( currentEmplacement.getIsOccupied() == true ) {
					colorToCompare = currentEmplacement.getOccupyingPiece().getColor();
				} else {
					thirdAreaNotFilledCorrectly = true;
				}
			}
			
			if ( currentEmplacement.getIsOccupied() == true ) {
				if ( currentEmplacement.getOccupyingPiece().getColor() != colorToCompare) {
					thirdAreaNotFilledCorrectly = true;
				}
			} else {
				thirdAreaNotFilledCorrectly = true;
			}
			
			if ( this.thirdVictoryAreaEmplacements.indexOf(currentEmplacement) == 9 ) {
				return itIsAVictory = true;
			}
			
		}
		return itIsAVictory;
	}
	
	public int isonVictoryEmplacementThenUpdate( int x, int y, Piece piece ) {
		boolean isOnVictoryEmplacement = false;
		Emplacement toUpdate = null;
		// int[] keyArray = {x,y};
		
		// Map<String, String> map = ...
		// Interesting link for comparing two arrays => https://www.geeksforgeeks.org/compare-two-arrays-java/
		/*
		Iterator<Entry<int[], Emplacement>> iterator = this.emplacementsHashMap.entrySet().iterator();
		while(iterator.hasNext() && isSetEmplacement == false ){
			Entry<int[], Emplacement> entry = iterator.next();
			
			if ( ( entry.getKey()[0] == x ) && ( entry.getKey()[1] == y ) ) {
				return isSetEmplacement = true;
			}
		}
		*/
		ListIterator<Emplacement> listIterator = this.firstVictoryAreaEmplacements.listIterator();
		while(listIterator.hasNext() && isOnVictoryEmplacement == false ){
			// Entry<int[], Emplacement> entry = iterator.next();
			Emplacement currentEmplacement = listIterator.next();
			if ( currentEmplacement.getPositionX() == x && currentEmplacement.getPositionY() == y ) {
				this.firstVictoryAreaEmplacements.indexOf(currentEmplacement);
				toUpdate = currentEmplacement;
				toUpdate.setIsOccupied(true);
				toUpdate.setOccupyingPiece(piece);
				firstVictoryAreaEmplacements.set(this.firstVictoryAreaEmplacements.indexOf(currentEmplacement), toUpdate);
				return 0;
			}
		}
		
		listIterator = this.secondVictoryAreaEmplacements.listIterator();
		while(listIterator.hasNext() && isOnVictoryEmplacement == false ){
			// Entry<int[], Emplacement> entry = iterator.next();
			Emplacement currentEmplacement = listIterator.next();
			if ( currentEmplacement.getPositionX() == x && currentEmplacement.getPositionY() == y ) {
				this.secondVictoryAreaEmplacements.indexOf(currentEmplacement);
				toUpdate = currentEmplacement;
				toUpdate.setIsOccupied(true);
				toUpdate.setOccupyingPiece(piece);
				secondVictoryAreaEmplacements.set(this.secondVictoryAreaEmplacements.indexOf(currentEmplacement), toUpdate);
				return 0;
			}
		}
		
		listIterator = this.thirdVictoryAreaEmplacements.listIterator();
		while(listIterator.hasNext() && isOnVictoryEmplacement == false ){
			// Entry<int[], Emplacement> entry = iterator.next();
			Emplacement currentEmplacement = listIterator.next();
			if ( currentEmplacement.getPositionX() == x && currentEmplacement.getPositionY() == y ) {
				this.thirdVictoryAreaEmplacements.indexOf(currentEmplacement);
				toUpdate = currentEmplacement;
				toUpdate.setIsOccupied(true);
				toUpdate.setOccupyingPiece(piece);
				thirdVictoryAreaEmplacements.set(this.thirdVictoryAreaEmplacements.indexOf(currentEmplacement), toUpdate);
				return 0;
			}
		}
		return -1;
	}
	
	public void determineRank() {
		if(VariableRepository.getInstance().searchPlayer("Player 1").getStats().getRank()!=null) {
			if(VariableRepository.getInstance().searchPlayer("Player 2").getStats().getSpecialMove() < VariableRepository.getInstance().searchPlayer("Player 3").getStats().getSpecialMove()) {
				VariableRepository.getInstance().searchPlayer("Player 3").getStats().setRank("Second");
				VariableRepository.getInstance().searchPlayer("Player 2").getStats().setRank("Third");
			}
			else if(VariableRepository.getInstance().searchPlayer("Player 2").getStats().getSpecialMove() > VariableRepository.getInstance().searchPlayer("Player 3").getStats().getSpecialMove()){
				VariableRepository.getInstance().searchPlayer("Player 3").getStats().setRank("Third");
				VariableRepository.getInstance().searchPlayer("Player 2").getStats().setRank("Second");
			}
			//si egalite
			else {
				if(VariableRepository.getInstance().searchPlayer("Player 2").getStats().getPowerUsed()<VariableRepository.getInstance().searchPlayer("Player 3").getStats().getPowerUsed()) {
					VariableRepository.getInstance().searchPlayer("Player 2").getStats().setRank("Second");
					VariableRepository.getInstance().searchPlayer("Player 3").getStats().setRank("Third");
				}
				else if(VariableRepository.getInstance().searchPlayer("Player 3").getStats().getPowerUsed()<VariableRepository.getInstance().searchPlayer("Player 2").getStats().getPowerUsed()) {
					VariableRepository.getInstance().searchPlayer("Player 2").getStats().setRank("Third");
					VariableRepository.getInstance().searchPlayer("Player 3").getStats().setRank("Second");
				}
			}
		}
		
		else if(VariableRepository.getInstance().searchPlayer("Player 2").getStats().getRank()!=null) {
			if(VariableRepository.getInstance().searchPlayer("Player 1").getStats().getSpecialMove() < VariableRepository.getInstance().searchPlayer("Player 3").getStats().getSpecialMove()) {
				VariableRepository.getInstance().searchPlayer("Player 3").getStats().setRank("Second");
				VariableRepository.getInstance().searchPlayer("Player 1").getStats().setRank("Third");
			}
			else if(VariableRepository.getInstance().searchPlayer("Player 1").getStats().getSpecialMove() > VariableRepository.getInstance().searchPlayer("Player 3").getStats().getSpecialMove()){
				VariableRepository.getInstance().searchPlayer("Player 3").getStats().setRank("Third");
				VariableRepository.getInstance().searchPlayer("Player 1").getStats().setRank("Second");
			}
			//si egalit�
			else {
					if(VariableRepository.getInstance().searchPlayer("Player 1").getStats().getPowerUsed()<VariableRepository.getInstance().searchPlayer("Player 3").getStats().getPowerUsed()) {
						VariableRepository.getInstance().searchPlayer("Player 1").getStats().setRank("Second");
						VariableRepository.getInstance().searchPlayer("Player 3").getStats().setRank("Third");
					}
					else if(VariableRepository.getInstance().searchPlayer("Player 3").getStats().getPowerUsed()<VariableRepository.getInstance().searchPlayer("Player 1").getStats().getPowerUsed()) {
						VariableRepository.getInstance().searchPlayer("Player 1").getStats().setRank("Third");
						VariableRepository.getInstance().searchPlayer("Player 3").getStats().setRank("Second");
					}
					else {
						VariableRepository.getInstance().searchPlayer("Player 3").getStats().setRank("Second");
						VariableRepository.getInstance().searchPlayer("Player 1").getStats().setRank("Second");
					}
				}		
		}
		
		else if(VariableRepository.getInstance().searchPlayer("Player 3").getStats().getRank()!=null) {
			if(VariableRepository.getInstance().searchPlayer("Player 2").getStats().getSpecialMove() < VariableRepository.getInstance().searchPlayer("Player 1").getStats().getSpecialMove()) {
				VariableRepository.getInstance().searchPlayer("Player 1").getStats().setRank("Second");
				VariableRepository.getInstance().searchPlayer("Player 2").getStats().setRank("Third");
			}
			else if(VariableRepository.getInstance().searchPlayer("Player 2").getStats().getSpecialMove() > VariableRepository.getInstance().searchPlayer("Player 1").getStats().getSpecialMove()){
				VariableRepository.getInstance().searchPlayer("Player 1").getStats().setRank("Third");
				VariableRepository.getInstance().searchPlayer("Player 2").getStats().setRank("Second");
			}
			//si egalite
			else {
				if(VariableRepository.getInstance().searchPlayer("Player 2").getStats().getPowerUsed()<VariableRepository.getInstance().searchPlayer("Player 1").getStats().getPowerUsed()) {
					VariableRepository.getInstance().searchPlayer("Player 2").getStats().setRank("Second");
					VariableRepository.getInstance().searchPlayer("Player 1").getStats().setRank("Third");
				}
				else if(VariableRepository.getInstance().searchPlayer("Player 1").getStats().getPowerUsed()<VariableRepository.getInstance().searchPlayer("Player 2").getStats().getPowerUsed()) {
					VariableRepository.getInstance().searchPlayer("Player 2").getStats().setRank("Third");
					VariableRepository.getInstance().searchPlayer("Player 1").getStats().setRank("Second");
				}
				else {
				VariableRepository.getInstance().searchPlayer("Player 2").getStats().setRank("Second");
				VariableRepository.getInstance().searchPlayer("Player 1").getStats().setRank("Second");
				}
			}
		}
	}
	
	public String getActualPlayerName () {
		return this.actualPlayerName;
	}
	public String getPreviousPlayerName () {
		if ( this.playerTurn == 0 ) {
			this.previousPlayerName = "Player 3";
		} else if ( this.playerTurn == 1 ) {
			this.previousPlayerName = "Player 1";
		} else {
			this.previousPlayerName = "Player 2";
		}
		return this.previousPlayerName;
	}
	
	public void updateActualPlayerName() {
		if ( this.playerTurn == 0 ) {
			this.actualPlayerName = "Player 1";
		} else if ( this.playerTurn == 1 ) {
			this.actualPlayerName = "Player 2";
		} else {
			this.actualPlayerName = "Player 3";
		}
	}
	
	public boolean getIsUpdating() {
		return this.isUpdating;
	}
	
	public void disablePiecesAfterSpecialMove(Piece pieceMoved) {
		for (ListIterator<Emplacement> iter = GameVariableRepository.getInstance().getEmplacementsArrayList().listIterator(); iter.hasNext(); ) {
            Emplacement currentEmplacement = iter.next();
            Piece currentPiece = currentEmplacement.getOccupyingPiece();
            if ( currentPiece != null && currentPiece!=pieceMoved )  {
            	currentPiece.setIsClickeable(false);
            	System.out.println("disabled");
            }
            pieceMoved.setIsClickeable(true);
        }
	}
	
	public void updatePiecesState() {
		if ( this.playerTurn == 0 ) {
			for (ListIterator<Emplacement> iter = GameVariableRepository.getInstance().getEmplacementsArrayList().listIterator(); iter.hasNext(); ) {
	            Emplacement currentEmplacement = iter.next();
	            Piece currentPiece = currentEmplacement.getOccupyingPiece();
	            if ( currentPiece != null && currentPiece.getOwnersName() == "Player 1" ) {
	            	currentPiece.setIsClickeable(true);
	            } else if ( currentPiece != null )  {
	            	currentPiece.setIsClickeable(false);
	            }
	            
	        }
		} else if ( this.playerTurn == 1 ) {
			for (ListIterator<Emplacement> iter = GameVariableRepository.getInstance().getEmplacementsArrayList().listIterator(); iter.hasNext(); ) {
	            Emplacement currentEmplacement = iter.next();
	            Piece currentPiece = currentEmplacement.getOccupyingPiece();
	            if ( currentPiece != null && currentPiece.getOwnersName() == "Player 2" ) {
	            	currentPiece.setIsClickeable(true);
	            } else if ( currentPiece != null )  {
	            	currentPiece.setIsClickeable(false);
	            }
	            
	        }
		} else {
			for (ListIterator<Emplacement> iter = GameVariableRepository.getInstance().getEmplacementsArrayList().listIterator(); iter.hasNext(); ) {
	            Emplacement currentEmplacement = iter.next();
	            Piece currentPiece = currentEmplacement.getOccupyingPiece();
	            if ( currentPiece != null && currentPiece.getOwnersName() == "Player 3" ) {
	            	currentPiece.setIsClickeable(true);
	            } else if ( currentPiece != null )  {
	            	currentPiece.setIsClickeable(false);
	            }
	            
	        }
		}
	}
	
	public void setIsUpdating(boolean isUpdatingParameter) {
		this.isUpdating = isUpdatingParameter;
	}
	
	public boolean getGameStarted() {
		return this.gameStarted;
	}
	
	public void setGameStarted(boolean gameStartedParameter) {
		this.gameStarted = gameStartedParameter;
	}
	
	public int getIndexOfEmplacementToBeEmptied() {
		return this.indexOfEmplacementToBeEmptied;
	}
	
	public void setIndexOfEmplacementToBeEmptied( int indexOfEmplacementToBeEmptiedParameter ) {
		this.indexOfEmplacementToBeEmptied = indexOfEmplacementToBeEmptiedParameter;
	}
	
	public Emplacement getEmplacementToBeEmptied() {
		return this.emplacementToBeEmptied;
	}
	
	public void setEmplacementToBeEmptied(Emplacement emplacementToBeEmptiedParameter) {
		this.emplacementToBeEmptied = emplacementToBeEmptiedParameter;
	}
	
	public boolean getAPieceIsSelected() {
		return this.aPieceIsSelected;
	}
	
	public void setAPieceIsSelected(boolean aPieceIsSelectedParameter) {
		this.aPieceIsSelected = aPieceIsSelectedParameter;
	}
	
	public Piece getSelectedPiece() {
		return this.selectedPiece;
	}
	
	public void setSelectedPiece(Piece selectedPieceParameter) {
		this.selectedPiece = selectedPieceParameter;
	}
	
	public int getPlayerTurn() {
		return this.playerTurn;
	}
	
	public ArrayList<Emplacement> getEmplacementsArrayList() {
		return this.emplacementsList;
	}
	
	public void setEmplacementsArrayList( ArrayList<Emplacement> arrayListParameter) {
		this.emplacementsList = arrayListParameter;
	}
	
	public ArrayList<Emplacement> getPreviousTurnEmplacementsArrayList() {
		return this.previousTurnEmplacementsList;
	}
	
	public void setPreviousTurnEmplacementsArrayList( ArrayList<Emplacement> arrayListParameter) {
		this.previousTurnEmplacementsList = arrayListParameter;
	}
	
	public Emplacement setEmplacementsAttribute(int indice) {
		return this.emplacementsList.get(indice);
	}
	
	public ArrayList<Emplacement> getFirstStartingAreaEmplacements() {
		return this.firstStartingAreaEmplacements;
	}
	
	public ArrayList<Emplacement> getSecondStartingAreaEmplacements() {
		return this.secondStartingAreaEmplacements;
	}
	
	public ArrayList<Emplacement> getThirdStartingAreaEmplacements() {
		return this.thirdStartingAreaEmplacements;
	}
	
	public ArrayList<Emplacement> getFirstVictoryAreaEmplacements() {
		return this.firstVictoryAreaEmplacements;
	}
	
	public ArrayList<Emplacement> getSecondVictoryAreaEmplacements() {
		return this.secondVictoryAreaEmplacements;
	}
	
	public ArrayList<Emplacement> getThirdVictoryAreaEmplacements() {
		return this.thirdVictoryAreaEmplacements;
	}
	
	public ArrayList<Emplacement> getFieldAreaEmplacements() {
		return this.fieldAreaEmplacements;
	}
	
	public ArrayList<Piece> getFirstPlayerPieces() {
		return this.firstPlayerPieces;
	}
	
	public ArrayList<Piece> getSecondPlayerPieces() {
		return this.secondPlayerPieces;
	}
	
	public ArrayList<Piece> getThirdPlayerPieces() {
		return this.thirdPlayerPieces;
	}
	
	public void setEmplacementTable(Emplacement emplacement) {
		this.emplacements[emplacement.getPositionX()][emplacement.getPositionY()]=emplacement;
	}
	public Emplacement[][] getEmplacementTable(){
		return emplacements;
	}
	public int getNbRound() {
		return this.nbRound;
	}
	

}