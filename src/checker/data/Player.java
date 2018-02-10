package checker.data;

import java.util.ArrayList;
import java.util.HashMap;

import customEventsPackage.Power;

public class Player {
	private String playerName;
	private double playerScore;
	private double playerMana;
	private ArrayList<Power> powers=new ArrayList<Power>();
	//pb with int
	//private HashMap<int ,Piece> pieces = new HashMap<int, Piece>();
	private boolean round;
	private boolean isAI;
	
	public Player() {
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

	public void setPlayerMana(double playerMana) {
		this.playerMana = playerMana;
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

	public boolean isAI() {
		return isAI;
	}

	public void setAI(boolean isAI) {
		this.isAI = isAI;
	}
	
	
}
