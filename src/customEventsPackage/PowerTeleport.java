package customEventsPackage;


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
}
