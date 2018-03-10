package customEventsPackage;


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
		return 80;
	}
	public String getImage() {
		return "power_twomoves.jpg";
	}
	public int getCost2() {
		return 80;
	}
}
