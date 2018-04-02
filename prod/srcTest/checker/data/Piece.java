package checker.data;

import java.awt.Color;

public class Piece {
	
	private int xPosition;
	private int yPosition;
	private boolean isClickable;
	private boolean isSelected;
	private Color color;
	private String ownersName;
	
	public Piece(int xParameter, int yParameter, Color colorParameter, String ownersNameParameter) {
		this.xPosition = xParameter;
		this.yPosition = yParameter;
		this.isClickable = false;
		this.isSelected = false;
		this.color = colorParameter;
		this.ownersName = ownersNameParameter;
	}
	
	public boolean getIsSelected () {
		return this.isClickable;
	}
	
	public void setIsSelected( boolean isClickeableParameter ) {
		this.isClickable = isClickeableParameter;
	}
	public boolean getIsClickeable () {
		return this.isClickable;
	}
	
	public void setIsClickeable ( boolean isClickeableParameter ) {
		this.isClickable = isClickeableParameter;
	}
	
	public String getOwnersName() {
		return this.ownersName;
	}
	
	public void setOwnersName( String ownerNameParameter ) {
		this.ownersName = ownerNameParameter;
	}
	
	public int getXPosition() {
		return xPosition;
	}
	
	public int getYPosition() {
		return yPosition;
	}
	
	public void setXPosition(int position) {
		this.xPosition = position;
	}
	
	public void setYPosition(int position) {
		this.yPosition = position;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
