package checker.core;

import java.util.ArrayList;

import checker.panels.Emplacement;

public class GameVariableRepository {
	// Number of real player in the game
	private int realPlayerCount;
	// Varies from 0 to 2, each digits indicating a player. Will varies between the turns.
	private int playerTurn;
	
	private ArrayList<Emplacement> emplacementsList;
	private Emplacement[][] emplacements;
	
	private GameVariableRepository() {
		this.playerTurn = 0;
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
	
	public int getPlayerTurn() {
		return this.playerTurn;
	}
	
	public ArrayList getEmplacementsArrayList() {
		return emplacementsList;
	}
	
	public void setEmplacementTable(Emplacement emplacement) {
		this.emplacements[emplacement.getPositionX()][emplacement.getPositionY()]=emplacement;
	}
	public Emplacement[][] getEmplacementTable(){
		return emplacements;
	}
}
