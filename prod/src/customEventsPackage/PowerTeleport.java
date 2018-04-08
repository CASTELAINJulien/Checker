package customEventsPackage;

import checker.core.VariableRepository;
import checker.data.Piece;

public class PowerTeleport extends Power{
	public PowerTeleport() {
	}
	public String getName() {
		return "Teleport";
	}
	public static String getDescription() {
		return "Teleport one of your piece wherever you want";
	}
	public  String getDescription2() {
		return "Teleport one of your piece wherever you want";
	}
	public static int getCost() {
		return 100;
	}
	public String getImage() {
		return "power_teleport.png";
	}
	public int getCost2() {
		return 100;
	}
	public void effect(Piece currentPiece) {
	}
	public static boolean testTeleport(String player) {
		if( VariableRepository.getInstance().searchPlayer(player).getPowerActivated()!=9) {
    		if(VariableRepository.getInstance().searchPlayer(player).getPower(VariableRepository.getInstance().searchPlayer(player).getPowerActivated()).getName()=="Teleport") {
    			return true;
    		}
		}
		return false;	
	}
}