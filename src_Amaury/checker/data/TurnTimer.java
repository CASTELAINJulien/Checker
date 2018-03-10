package checker.data;

import checker.core.GameVariableRepository;

public class TurnTimer {
	private int timeValue;
	
	private TurnTimer() {
		this.timeValue = 30;
	}
	
	static TurnTimer instance = new TurnTimer();
	
	public static TurnTimer getInstance() {
		return instance;
	}
	
	public void decrement() {
		this.timeValue--;
	}
	
	public void restartTimer( ) {
		this.timeValue = 30;
	}
	
	public int getTimeValue( ) {
		return this.timeValue;
	}
}
