package checker.data;

import java.awt.Color;

import checker.core.GameVariableRepository;
import checker.core.VariableRepository;
import checker.gui.BoardParameter;

public class Emplacement {

	private int positionX;
	private int positionY;
	private int XOnCanvas;
	private int YOnCanvas;
	private int radius;
	private Piece occupyingPiece;
	private boolean isOccupied;
	
	public Emplacement(int positionX, int positionY, int startingAreaIndex) {
		this.positionX = positionX;
		this.positionY = positionY;
		XOnCanvas = positionX * BoardParameter.interEmplacementSpaces + BoardParameter.boardStartingPoint;
		YOnCanvas = positionY * BoardParameter.interEmplacementSpaces;
		occupyingPiece = null;
		this.isOccupied = false;
		this.radius = 22;
		
		Piece currentPiece = null;
		// Mettre un parametre startingAreaIndex par défaut ?
		if ( startingAreaIndex == 1 ) {
			GameVariableRepository.getInstance().getFirstStartingAreaEmplacements().add(this);
			currentPiece = new Piece(this.positionX, this.positionY, Color.red, "Player 1");
			GameVariableRepository.getInstance().getFirstPlayerPieces().add(currentPiece);
		} else if ( startingAreaIndex == 2 ) {
			GameVariableRepository.getInstance().getSecondStartingAreaEmplacements().add(this);
			currentPiece = new Piece(this.positionX, this.positionY, Color.yellow, "Player 2");
			//System.out.println(currentPiece);
			GameVariableRepository.getInstance().getSecondPlayerPieces().add(currentPiece);
		} else if ( startingAreaIndex == 3 ) {
			GameVariableRepository.getInstance().getThirdStartingAreaEmplacements().add(this);
			currentPiece = new Piece(this.positionX, this.positionY, Color.green, "Player 3");
			GameVariableRepository.getInstance().getThirdPlayerPieces().add(currentPiece);
		}
		
		this.isOccupied = true;
		this.occupyingPiece = currentPiece;
		GameVariableRepository.getInstance().getEmplacementsArrayList().add(this);
	}
	
	public Emplacement(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
		XOnCanvas = positionX * BoardParameter.interEmplacementSpaces + BoardParameter.boardStartingPoint;
		YOnCanvas = positionY * BoardParameter.interEmplacementSpaces;
		occupyingPiece = null;
		this.isOccupied = false;
		this.radius = 22;
		
		GameVariableRepository.getInstance().getFieldAreaEmplacements().add(this);
		
		GameVariableRepository.getInstance().getEmplacementsArrayList().add(this);
	}
	
	public boolean ifIsEligibleForMove() {
		Piece currentPiece = GameVariableRepository.getInstance().getSelectedPiece();
		
		boolean isEligibleForMove = false;
		//Coordinates for the horizontal moves
		int leftAndRightY = currentPiece.getYPosition();
		int leftEmplacementX = currentPiece.getXPosition() - 2;
		int rightEmplacementX = currentPiece.getXPosition() + 2;
		
		//Coordinates for the diagonales moves
		int leftDiagonalEmplacementX = currentPiece.getXPosition() - 1;
		int rightDiagonalEmplacementX = currentPiece.getXPosition() + 1;
		int upperDiagonalEmplacementsY = currentPiece.getYPosition() + 2;
		int lowerDiagonalEmplacementsY = currentPiece.getYPosition() - 2;
		
		// Conditions for horizontal moves
		if ( this.positionY == leftAndRightY && ( this.positionX == leftEmplacementX || this.positionX == rightEmplacementX )  ) {
			isEligibleForMove = true;
		} else if ( this.positionY == upperDiagonalEmplacementsY && ( this.positionX == leftDiagonalEmplacementX || this.positionX == rightDiagonalEmplacementX ) ) {
			isEligibleForMove = true;
		} else if ( this.positionY == lowerDiagonalEmplacementsY && ( this.positionX == leftDiagonalEmplacementX || this.positionX == rightDiagonalEmplacementX ) ) {
			isEligibleForMove = true;
		}
		
		return isEligibleForMove;
	}
	
	public boolean getIsOccupied() {
		return this.isOccupied;
	}
	
	public boolean isCursorOnEmplacement(int x, int y) {
		boolean isOnEmplacement = false;
		// System.out.println("Souris x = " + x + " " + "y = " + y + "\n");
		// System.out.println("Emplacement x = " + this.positionX + " " + "y = " + this.positionX + "\n");
		// float distanceBetweenCursorAndEmplacement = Math.abs((float) Math.sqrt(Math.pow(this.XOnCanvas-x, 2) + Math.pow(this.YOnCanvas-y, 2))) ;
		float distanceBetweenCursorAndEmplacement = (float) (Math.pow(this.XOnCanvas-x, 2) + Math.pow(this.YOnCanvas-y, 2));
		// System.out.println(distanceBetweenCursorAndEmplacement);
		/*
		if ( distanceBetweenCursorAndEmplacement > 0 && distanceBetweenCursorAndEmplacement < this.radius ) {
			isOnEmplacement = true;
			System.out.println("teeeeeeeeeeeest");
		}
		*/
		if ( distanceBetweenCursorAndEmplacement < (BoardParameter.pieceRadius + 1) * (BoardParameter.pieceRadius + 1) ) {
			isOnEmplacement = true;
			// System.out.println("teeeeeeeeeeeest");
		}
		/*
		if (  ) {
			
		}
		*/
		return isOnEmplacement;

	}
	
	public void setIsOccupied(boolean isOccupiedParam) {
		this.isOccupied= isOccupiedParam;
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
	
	public Piece getOccupyingPiece() {
		return this.occupyingPiece;
	}
	
	public void setOccupyingPiece( Piece occupingPieceParameter ) {
		this.occupyingPiece = occupingPieceParameter;
	}
	
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	public String toString () {
		StringBuffer sb = new StringBuffer();
		sb.append("=================\n");
		sb.append("\t" + "X : " + this.positionX + "\n");
		sb.append("\t" + "Y : " + this.positionY + "\n");
		sb.append("\t" + " Is occupied : " + this.isOccupied + "\n"); 
		sb.append("\t" + " Occupying piece : " + this.occupyingPiece);
		return sb.toString();
	}
}
