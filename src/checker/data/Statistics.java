package checker.data;

public class Statistics {
	private int totalNumberOfMove=0;
	private int numberSpecialMove=0;
	private int numberSimpleMove=0;
	private int numberPowerUsed=0;
	private int score=0;
	
	public int getTotalNumberOfMove() {
		return totalNumberOfMove;
	}
	public void addTotalNumberOfMove() {
		totalNumberOfMove++;
	}
	
	public int getSpecialMove() {
		return numberSpecialMove;
	}
	public void addSpecialMove() {
		numberSpecialMove++;
	}
	
	public int getSimpleMove() {
		return numberSimpleMove;
	}
	public void addSimpleMove() {
		numberSimpleMove++;
	}
	
	public int getPowerUsed() {
		return numberPowerUsed;
	}
	public void addPowerUsed() {
		numberPowerUsed++;
	}
	
	public int getScore() {
		return score;
	}
	public void addScore() {
		score++;
	}

	public int ratioSimpleMove() {
		return (numberSimpleMove/totalNumberOfMove)*100;
	}
	public int ratioSpecialMove() {
		return (numberSpecialMove/totalNumberOfMove)*100;
	}


}
