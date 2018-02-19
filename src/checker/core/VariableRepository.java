package checker.core;

import java.util.HashMap;
import java.util.Map;

import checker.data.Player;

public class VariableRepository {
	private Map<String,Object> variables = new HashMap<String, Object>();

	private VariableRepository() {

	}

	private static VariableRepository instance = new VariableRepository();

	public static VariableRepository getInstance() {
		return instance;
	}

	public void registerPlayer(String Name, Player playerToRegister) {
		variables.put(Name, playerToRegister);
	}

	public Player searchPlayer(String Name) {
		return (Player) variables.get(Name);
	}
}
