package customEventsPackage;

import checker.core.VariableRepository;
import checker.data.Piece;

public class PowerJump extends Power {
	public PowerJump() {	
	}
	public String getName() {
		return "Jump";
	}
	public static String getDescription() {
		return "Do a longer jump";
	}
	public String getDescription2() {
		return "Do a longer jump";
	}
	public static int getCost() {
		return 40;
	}
	public  String getImage() {
		return "power_jump.png";
	}
	public int getCost2() {
		return 40;
	}
	public void effect(Piece currentPiece) {
	}
	public static boolean testJump(String player) {
		if( VariableRepository.getInstance().searchPlayer(player).getPowerActivated()!=9) {
    		if(VariableRepository.getInstance().searchPlayer(player).getPower(VariableRepository.getInstance().searchPlayer(player).getPowerActivated()).getName()=="Jump") {
    			return true;
    		}
		}
		return false;	
	}
}