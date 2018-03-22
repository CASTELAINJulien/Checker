package application;

public class StateMachine {
	
	private static State actualState;
	
	private StateMachine(){
		actualState = State.mainScreenState;
	}
	
	public static State getInstance(){
		if( actualState == null ){
			new StateMachine();
		}
		
		return actualState;   
	}
	
	public static void changeState( State wantedState ){
		actualState = wantedState;   
	}   
}
