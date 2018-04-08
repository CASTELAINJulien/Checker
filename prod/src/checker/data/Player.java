package checker.data;

import java.awt.Color;
import java.util.ArrayList;

import customEventsPackage.Power;

public class Player {
	private String playerName;
	private double playerScore;
	private double playerMana;
	private ArrayList<Power> alPowers=new ArrayList<Power>();
	private boolean round;
	private boolean isAI;
	private int powerActivated=9; //9 is the default value=no power activated	
	private Statistics stats=new Statistics();
	private boolean isBeginner=false;
	private Color color;
	
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
		this.playerMana = playerManaParam;
	}
	
	public void addPlayerMana(double playerManaParam) {
		if ( (this.playerMana+playerManaParam < 100) && (this.playerMana+playerManaParam >= 0) ) {
			this.playerMana += playerManaParam;
		} else if ( this.playerMana+playerManaParam < 0 ) {
			this.playerMana = 0;
		} else {
			this.playerMana += (100-this.playerMana);
		}
	}

	public  void addPower(Power power) {
		alPowers.add(power);
	}
	public Power getPower(int i) {
		return alPowers.get(i);
	}
	
	public int taille() {
		return alPowers.size();
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
	public int getPowerActivated() {
		return powerActivated;
	}
	public void setPowerActivated(int powerNumber) {
		powerActivated=powerNumber;
	}
	public Statistics getStats() {
		return stats;
	}
	public void setIsBeginner(boolean isBeginner) {
		this.isBeginner=isBeginner;
	}
	public boolean getIsBeginner() {
		return this.isBeginner;
	}
	public void setColor(Color color) {
		this.color=color;
	}
	public Color getColor() {
		return this.color;
	}
	
}