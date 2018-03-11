package application;

public class StateEngine {
	private static StateMachine runningStateMachine;
	
	private StateEngine(){
		runningStateMachine = getInstance();
	}
	
	public static StateMachine getInstance(){
		if( runningStateMachine == null ){
			new StateEngine();
		}
		
		return runningStateMachine;   
	}   
}
