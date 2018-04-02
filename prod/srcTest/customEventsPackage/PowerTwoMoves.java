package customEventsPackage;

import checker.core.GameVariableRepository;
import checker.core.VariableRepository;
import checker.data.Piece;
//cost 80
public class PowerTwoMoves extends Power{
	public PowerTwoMoves() {
		
	}
	public String getName() {
		return "Two moves";
	}
	public static String getDescription() {
		return "Play twice in a round";
	}
	public String getDescription2() {
		return "Play twice in a round";
	}
	public static int getCost() {
		return 5;
	}
	public String getImage() {
		return "power_twomoves.jpg";
	}
	public int getCost2() {
		return 5;
	}
	public void effect(Piece currentPiece) {	
		GameVariableRepository.getInstance().decrementPlayerTurnForPower();
	}
	public static boolean testTwoMoves(String player) {
		if( VariableRepository.getInstance().searchPlayer(player).getPowerActivated()!=9) {//un pouvoir est activé
    		if(VariableRepository.getInstance().searchPlayer(player).getPower(VariableRepository.getInstance().searchPlayer(player).getPowerActivated()).getName()=="Two moves") {
    			return true;
    		}
    	}
		return false;
	}
}
