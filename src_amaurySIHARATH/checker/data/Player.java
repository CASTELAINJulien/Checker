package checker.data;

import java.util.ArrayList;
import java.util.HashMap;

import customeventspackage.Power;

public class Player {
	private String playerName;
	private double playerScore;
	private double playerMana;
	private ArrayList<Power> powers=new ArrayList<Power>();
	//pb with int
	//private HashMap<int ,Piece> pieces = new HashMap<int, Piece>();
	private boolean round;
	private boolean isAI;
	
	public Player(String nameParameter, boolean isAIParameter) {
		this.playerName = nameParameter;
		this.isAI = isAIParameter;
		this.playerMana = 0;
		this.playerScore = 0;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public double getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(double playerScore) {
		this.playerScore = playerScore;
	}

	public double getPlayerMana() {
		return playerMana;
	}

	public void setPlayerMana(double playerManaParam) {
		this.playerMana = playerMana;
	}
	
	public void addPlayerMana(double playerManaParam) {
		if ( (this.playerMana+playerManaParam < 100) && (this.playerMana+playerManaParam > 0) ) {
			this.playerMana += playerManaParam;
		} else if ( this.playerMana+playerManaParam < 0 ) {
			System.out.println("pouvoir");
			this.playerMana = 0;
		} else {
			System.out.println("test\n");
			this.playerMana += (100-this.playerMana);
			System.out.println(this.playerMana);
		}
	}

	public ArrayList<Power> getPowers() {
		return powers;
	}

	public void setPowers(ArrayList<Power> powers) {
		this.powers = powers;
	}

	public boolean isRound() {
		return round;
	}

	public void setRound(boolean round) {
		this.round = round;
	}

	public boolean getIsAI() {
		return isAI;
	}

	public void setAI(boolean isAI) {
		this.isAI = isAI;
	}
	
	
}
