package checker.panels;

public class Emplacement {

	private int positionX;
	private int positionY;
	private int radius;
	private boolean isEmpty;
	
	public Emplacement(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.isEmpty = false;
		this.radius = 22;
	}
	
	public boolean getIsEmpty() {
		return this.isEmpty;
	}
	/*
	public boolean isCursorOnEmplacement(int x, int y) {
		boolean isOnEmplacement = false;
		
		float distanceBetweenCursorAndEmplacement = Math.abs((float) Math.sqrt(Math.pow(this.positionX-x, 2) + Math.pow(this.positionY-y, 2))) ;
		if ( distanceBetweenCursorAndEmplacement > 0 && distanceBetweenCursorAndEmplacement < 22 ) {
			isOnEmplacement = true;
		}
		
		return isOnEmplacement;

	}
	*/
	
	public boolean isCursorOnEmplacement(int x, int y) {
		boolean isOnEmplacement = false;
		
		float distanceBetweenCursorAndEmplacement = Math.abs((float) Math.sqrt(Math.pow(this.positionX-x, 2) + Math.pow(this.positionY-y, 2))) ;
		if ( distanceBetweenCursorAndEmplacement > 0 && distanceBetweenCursorAndEmplacement < 22 ) {
			isOnEmplacement = true;
		}
		
		return isOnEmplacement;

	}
	
	public void setIsEmpty(boolean isEmptyParam) {
		this.isEmpty = isEmptyParam;
	}
	
	public int getPositionX() {
		return positionX;
	}
	
	public int getPositionY() {
		return positionY;
	}
	
	public int getRadius() {
		return positionY;
	}
	
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
}
