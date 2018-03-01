package checker.core;

import java.util.HashMap;
import java.util.Map;

import checker.data.Player;
/**
 * @author      Amaury SIHARATH amaury.siharath@gmail.com
 * @version     1.0
 * @since       1.0
 * A singleton-class that is able to keep different kinds of objects inside an HashMap.
 */
public class VariableRepository {
	/**
	 * Collection-type variable, HashMap<String, Object> object, store different classes of objects
	 * A String-class object is used as a Key, which purpose is to serve as an ID or a Name.
	 * Any object, that is the value itself.
	 */
	private Map<String,Object> variables = new HashMap<String, Object>();

	/**
	 * The default constructor of the VariableRepository Singleton. The constructor is set as private so only one instance is instantiated in the program.
	 * @param No parameters is needed.
	 * @return Returns nothing
	 */
	private VariableRepository() {

	}

	/**
	 * The instance attribute is actually the self-scoped object/class.
	 */
	private static VariableRepository instance = new VariableRepository();
	
	/**
	 * A method that able us to get the singleton from anywhere if called.
	 * @return Returns the object instance, the "variables" HashMap.
	 */
	public static VariableRepository getInstance() {
		return instance;
	}

	/**
	 * A method that add a Player-class object inside the HashMap.
	 * The Player shall be instantiated BEFORE being actually cast inside the HashMap.
	 * @param Name The String-class object that shall act as the key.
	 * @param playerToRegister the Player-class object that shall act as the value.
	 */
	public void registerPlayer(String Name, Player playerToRegister) {
		variables.put(Name, playerToRegister);
	}

	/**
	 * A method that able us to get back a Player-class object inside the HashMap
	 * @param Name A String-class object that is used as a keyWord for the query.
	 * @return Return a Player-class object that possess the right key compared to the Name Parameter.
	 */
	public Player searchPlayer(String Name) {
		return (Player) variables.get(Name);
	}
}
