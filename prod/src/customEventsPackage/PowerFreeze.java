package customEventsPackage;
import java.awt.Color;

import checker.core.VariableRepository;
import checker.data.Piece;

public class PowerFreeze extends Power {
	public PowerFreeze() {
	}
	public String getName() {
		return "Freeze";
	}
	public static String getDescription() {
		return "Stuck one of your opponent's piece for one round";
	}
	public  String getDescription2() {
		return "Stuck one of your opponent's piece for one round";
	}
	public static int getCost() {
		return 50;
	}
	public String getImage() {
		return "power_freeze.jpg";
	}
	public int getCost2() {
		return 50;
	}
	
	public void effect(Piece pieceFrozen) {
		//is implement directly in the Board class
	}
	public static void effectUndo(Piece pieceFrozen) {
		String playerName=pieceFrozen.getOwnersName();
		if(playerName=="Player 1") {
			pieceFrozen.setColor(Color.red);
		}
		else if(playerName=="Player 2") {
			pieceFrozen.setColor(Color.yellow);
		}
		else if(playerName=="Player 3") {
			pieceFrozen.setColor(Color.green);
		}	
	}
	
	public static boolean testFreeze(String player) {
		if( VariableRepository.getInstance().searchPlayer(player).getPowerActivated()!=9) {
    		if(VariableRepository.getInstance().searchPlayer(player).getPower(VariableRepository.getInstance().searchPlayer(player).getPowerActivated()).getName()=="Freeze") {
    			return true;
    		}
		}
		return false;	
	}
	
	
}
