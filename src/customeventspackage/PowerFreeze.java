package customeventspackage;

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
		return 80;
	}
	public String getImage() {
		return "power_freeze.jpg";
	}
	public int getCost2() {
		return 80;
	}

}
