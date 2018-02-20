package checker.core;

public class GameVariableRepository {
	// Number of real player in the game
	private int realPlayerCount;
	// Varies from 0 to 2, each digits indicating a player. Will varies between the turns.
	private int playerTurn;
	
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
}
