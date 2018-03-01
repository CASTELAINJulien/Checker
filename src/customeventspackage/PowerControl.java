package customeventspackage;

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
		return 90;
	}
	public String getImage() {
		return "power_control.jpg";
	}
	public int getCost2() {
		return 90;
	}
}