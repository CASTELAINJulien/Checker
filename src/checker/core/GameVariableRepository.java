package checker.core;

/**
 * Singleton-class used to store the variables or constant used during a game session.
 * @author Amaury SIHARATH
 *
 */
public class GameVariableRepository {
	// Number of real player in the game
	/**
	 * Number of real Players ( human players ) in the game session.
	 */
	private int realPlayerCount;
	// Varies from 0 to 2, each digits indicating a player. Will varies between the turns.
	
	/**
	 * Int-class variable that increment at each turn, and varies from 0 to 2 :
	 * - 0 indicates the turn of Player 1
	 * - 1 indicates the turn of Player 2
	 * - 2 indicates the turn of Player 3
	 */
	private int playerTurn;
	
	/**
	 * Int-class variable represent the basic income of mana after doing a classic move. The amount is about 5 unit out of 100.
	 */
	private int manaIncomeAfterClassicMove = 5;
	
	/**
	 * Int-class variable represent the basic income of mana after doing a special move. The amount is about 10 unit out of 100.
	 */
	private int manaIncomeAfterSpecialMove = 10;
	
	/**
	 * Int-class variable represent the basic amount of mana removed after using a power. The amount is about 50 unit out of 100.
	 * It is a temporary value.
	 */
	private int manaTemporaryCost1 = 50;
	
	/**
	 * Int-class variable represent the basic amount of mana removed after using a power. The amount is about 10 unit out of 100.
	 * It is a temporary value.
	 */
	private int manaTemporaryCost2 = 70;
	
	/**
	 * Default constructor of the singleton-class GameVariableRepository. The constructor is set as private so only one instance is instantiated in the program. Set the playerTurn attribute to 0.
	 */
	private GameVariableRepository() {
		this.playerTurn = 0;
	}
	
	/**
	 * The instance attribute is actually the self-scoped object/class.
	 */
	static GameVariableRepository instance = new GameVariableRepository();
	
	/**
	 * The default constructor of the GameVariableRepository Singleton. The constructor is set as private so only one instance is instantiated in the program.
	 */
	public static GameVariableRepository getInstance() {
		return instance;
	}
	
	/**
	 * A method that increment the playerTurn attribute each time it is called, and reset it back to 3 if it reach the value of 3.
	 * @return Returns an int that indicates who's turn it is to make a move.
	 */
	public int incrementPlayerTurn() {
		this.playerTurn++;
		if ( playerTurn >= 3 ) {
			this.playerTurn = 0;
		}
		
		return this.playerTurn;
	}
	
	/**
	 * A method that returns the playerTurn attribute value.
	 * @return Returns the playerTurn attribute value.
	 */
	public int getPlayerTurn() {
		return this.playerTurn;
	}
}
