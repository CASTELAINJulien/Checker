package checker.data;

public class Statistics {
	private int totalNumberOfMove=0;
	private int numberSpecialMove=0;
	private int numberSimpleMove=0;
	private int numberPowerUsed=0;
	private int score=0;
	private String rank=null;
	
	public int getTotalNumberOfMove() {
		return totalNumberOfMove;
	}
	public void addTotalNumberOfMove() {
		totalNumberOfMove++;
	}
	public void substractTotalNumberOfMove() {
		totalNumberOfMove--;
	}
	
	public int getSimpleMove() {
		return numberSimpleMove;
	}
	public void addSimpleMove() {
		numberSimpleMove++;
	}
	public void substractSimpleMove() {
		numberSimpleMove--;
	}
	public int getSpecialMove() {
		return numberSpecialMove;
	}
	public void addSpecialMove() {
		numberSpecialMove++;
	}
	public void substractSpecialMove() {
		numberSpecialMove--;
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
	public void addScore(int score) {
		this.score+=score;
	}
	public void setScore(int score) {
		this.score=score;
	}
	
	public void setRank(String rank) {
		this.rank=rank;
	}
	public String getRank() {
		return this.rank;
	}
	
	public float ratioSimpleMove() {
		return ((float)numberSimpleMove/(float)totalNumberOfMove)*100;
	}
	public float ratioSpecialMove() {
		return ((float)numberSpecialMove/(float)totalNumberOfMove)*100;
	}
	
	public void reset() {
		this.totalNumberOfMove=0;
		this.numberSpecialMove=0;
		this.numberSimpleMove=0;
		this.numberPowerUsed=0;
		this.score=0;
		this.rank=null;
	}


}
