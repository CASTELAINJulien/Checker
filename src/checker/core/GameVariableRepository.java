package checker.core;

import java.util.ArrayList;

import checker.data.Emplacement;
import checker.data.Piece;
import checker.gui.BoardParameter;

public class GameVariableRepository {
	// Number of real player in the game
	private int realPlayerCount;
	// Varies from 0 to 2, each digits indicating a player. Will varies between the turns.
	private int playerTurn;
	
	private ArrayList<Emplacement> emplacementsList;
	private Emplacement[][] emplacements;
	private ArrayList<Emplacement> firstStartingAreaEmplacements;
	private ArrayList<Emplacement> secondStartingAreaEmplacements;
	private ArrayList<Emplacement> thirdStartingAreaEmplacements;
	private ArrayList<Piece> firstPlayerPieces;
	private ArrayList<Piece> secondPlayerPieces;
	private ArrayList<Piece> thirdPlayerPieces;
	private ArrayList<Emplacement> fieldAreaEmplacements;
	private Piece selectedPiece;
	private Emplacement emplacementToBeEmptied;
	private boolean aPieceIsSelected;
	private int indexOfEmplacementToBeEmptied;
	
	private GameVariableRepository() {
		this.emplacements = new Emplacement[BoardParameter.doubleArrayRowCellsNumber][BoardParameter.doubleArrayColumnCellNumber];
		this.emplacementsList = new ArrayList<Emplacement>();
		this.playerTurn = 0;
		this.firstStartingAreaEmplacements = new ArrayList<Emplacement>();
		this.secondStartingAreaEmplacements = new ArrayList<Emplacement>();
		this.thirdStartingAreaEmplacements = new ArrayList<Emplacement>();
		this.firstPlayerPieces = new ArrayList<Piece>();
		this.secondPlayerPieces = new ArrayList<Piece>();
		this.thirdPlayerPieces = new ArrayList<Piece>();
		this.fieldAreaEmplacements = new ArrayList<Emplacement>();
		this.selectedPiece = null;
		this.emplacementToBeEmptied = null;
		this.indexOfEmplacementToBeEmptied = 0;
	}
	
	static GameVariableRepository instance = new GameVariableRepository();
	
	public static GameVariableRepository getInstance() {
		return instance;
	}
	
	public int incrementPlayerTurn() {
		this.playerTurn++;
		if ( playerTurn >= 3 ) {
			this.playerTurn = 0;
		}
		
		return this.playerTurn;
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
		return emplacementsList;
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
}
