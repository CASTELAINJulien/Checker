package customEventsPackage;

import checker.core.VariableRepository;
import checker.data.Piece;

public class PowerControl extends Power {
	public PowerControl(){
	}
	public String getName() {
		return "Control";
	}
	public static String getDescription() {
		return "Control one of your opponent's piece instead of your for one round";
	}
	public  String getDescription2() {
		return "Control one of your opponent's piece instead of your for one round";
	}
	public static int getCost() {
		return 5;
	}
	public String getImage() {
		return "power_control.jpg";
	}
	public int getCost2() {
		return 5;
	}
	public void effect(Piece currentPiece) {
		 currentPiece.setIsClickeable(true);
	}
	public static boolean testControl(String player) {
		if( VariableRepository.getInstance().searchPlayer(player).getPowerActivated()!=9) {
    		if(VariableRepository.getInstance().searchPlayer(player).getPower(VariableRepository.getInstance().searchPlayer(player).getPowerActivated()).getName()=="Control") {
    			return true;
    		}
		}
		return false;
	}
}