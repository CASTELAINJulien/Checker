package customEventsPackage;

import checker.data.Piece;

public abstract class Power {
	
	private double manaCost;
	private String powerDescription;
	public Power() {		
	}
	public abstract String getDescription2();
	public abstract String getImage();
	public abstract String getName();
	public abstract int getCost2();
	public abstract void effect(Piece currentPiece);
	//public abstract void effectUndo(Piece currentPiece);

}