package customEventsPackage;

public class PowerJump extends Power {
	public PowerJump() {
		
	}
	public String getName() {
		return "Jump";
	}
	public static String getDescription() {
		return "Jump over two pieces at once";
	}
	public String getDescription2() {
		return "Jump over two pieces at once";
	}
	public static int getCost() {
		return 70;
	}
	public  String getImage() {
		return "power_jump.png";
	}
	public int getCost2() {
		return 70;
	}

}