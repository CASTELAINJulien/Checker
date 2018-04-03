
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
	private Color color;
	
	public Emplacement(int positionX, int positionY, int AreaIndex) {
		this.positionX = positionX;
		this.positionY = positionY;
		XOnCanvas = positionX * BoardParameter.interEmplacementSpaces + BoardParameter.boardStartingPoint;
		YOnCanvas = positionY * BoardParameter.interEmplacementSpaces;
		occupyingPiece = null;
		this.isOccupied = false;
		this.radius = 22;
		int[] keyCoordinates = {this.positionX, this.positionY};
		
		Piece currentPiece = null;
		// Mettre un parametre startingAreaIndex par défaut ?
		if ( AreaIndex == 1 ) {
			GameVariableRepository.getInstance().getFirstStartingAreaEmplacements().add(this);
			currentPiece = ClassFactory.createPiece(this.positionX, this.positionY, Color.red, "Player 1");
			this.isOccupied = true;
			this.occupyingPiece = currentPiece;
			GameVariableRepository.getInstance().getFirstPlayerPieces().add(currentPiece);
		} else if ( AreaIndex == 2 ) {
			GameVariableRepository.getInstance().getSecondStartingAreaEmplacements().add(this);
			currentPiece = ClassFactory.createPiece(this.positionX, this.positionY, Color.yellow, "Player 2");
			this.isOccupied = true;
			this.occupyingPiece = currentPiece;
			GameVariableRepository.getInstance().getSecondPlayerPieces().add(currentPiece);
		} else if ( AreaIndex == 3 ) {
			GameVariableRepository.getInstance().getThirdStartingAreaEmplacements().add(this);
			currentPiece = ClassFactory.createPiece(this.positionX, this.positionY, Color.green, "Player 3");
			this.isOccupied = true;
			this.occupyingPiece = currentPiece;
			GameVariableRepository.getInstance().getThirdPlayerPieces().add(currentPiece);
		} else if ( AreaIndex == 4 ) {
			this.color = Color.PINK;
			GameVariableRepository.getInstance().getFirstVictoryAreaEmplacements().add(this);
		} else if ( AreaIndex == 5 ) {
			this.color = Color.ORANGE.darker();
			GameVariableRepository.getInstance().getSecondVictoryAreaEmplacements().add(this);
		} else if ( AreaIndex == 6 ) {
			this.color = Color.CYAN;
			GameVariableRepository.getInstance().getThirdVictoryAreaEmplacements().add(this);
		}
		
		GameVariableRepository.getInstance().getEmplacementsArrayList().add(this);
		GameVariableRepository.getInstance().getEmplacementsHashMap().put(keyCoordinates,this);
	}
	
	public Emplacement(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
		XOnCanvas = positionX * BoardParameter.interEmplacementSpaces + BoardParameter.boardStartingPoint;
		YOnCanvas = positionY * BoardParameter.interEmplacementSpaces;
		occupyingPiece = null;
		this.isOccupied = false;
		this.radius = 22;
		
		int[] keyCoordinates = {this.positionX, this.positionY};
		
		GameVariableRepository.getInstance().getFieldAreaEmplacements().add(this);
		
		GameVariableRepository.getInstance().getEmplacementsArrayList().add(this);
		
		GameVariableRepository.getInstance().getEmplacementsHashMap().put(keyCoordinates,this);
	}
	
	public Color getColor() {
		return this.color;	
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
			// Conditions for diagonal upper moves
		} else if ( this.positionY == upperDiagonalEmplacementsY && ( this.positionX == leftDiagonalEmplacementX || this.positionX == rightDiagonalEmplacementX ) ) {
			isEligibleForMove = true;
			// Conditions for diagonal lower moves
		} else if ( this.positionY == lowerDiagonalEmplacementsY && ( this.positionX == leftDiagonalEmplacementX || this.positionX == rightDiagonalEmplacementX ) ) {
			isEligibleForMove = true;
		}

		//Coordinates for the horizontal moves
		int leftAndRightYForJump = currentPiece.getYPosition();
		int leftEmplacementXForJump = currentPiece.getXPosition() - 4;
		int rightEmplacementXForJump = currentPiece.getXPosition() + 4;
		
		//Coordinates for the diagonales moves
		int leftDiagonalEmplacementXForJump = currentPiece.getXPosition() - 2;
		int rightDiagonalEmplacementXForJump = currentPiece.getXPosition() + 2;
		int upperDiagonalEmplacementsYForJump = currentPiece.getYPosition() + 4;
		int lowerDiagonalEmplacementsYForJump = currentPiece.getYPosition() - 4;
		
		if ( this.positionY == leftAndRightYForJump && this.positionX == leftEmplacementXForJump ) {
			if ( GameVariableRepository.getInstance().isSetEmplacement(leftEmplacementX, leftAndRightY) != (-1) ) {
				if ( GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().isSetEmplacement(leftEmplacementX, leftAndRightY)).getIsOccupied() == true) {
					isEligibleForMove = true;
				}
			}
		} else if ( this.positionY == leftAndRightYForJump && this.positionX == rightEmplacementXForJump ) {
			if ( GameVariableRepository.getInstance().isSetEmplacement(rightEmplacementX, leftAndRightY) != (-1) ) {
				if ( GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().isSetEmplacement(rightEmplacementX, leftAndRightY)).getIsOccupied() == true) {
					isEligibleForMove = true;
				}
			}
		} else if ( this.positionY == upperDiagonalEmplacementsYForJump && this.positionX == leftDiagonalEmplacementXForJump ) {
			if ( GameVariableRepository.getInstance().isSetEmplacement(leftDiagonalEmplacementX, upperDiagonalEmplacementsY) != (-1) ) {
				if( GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().isSetEmplacement(leftDiagonalEmplacementX, upperDiagonalEmplacementsY)).getIsOccupied() == true) {
					isEligibleForMove = true;
				}
			}
		} else if ( this.positionY == upperDiagonalEmplacementsYForJump &&  this.positionX == rightDiagonalEmplacementXForJump ) {
			if ( GameVariableRepository.getInstance().isSetEmplacement(rightDiagonalEmplacementX, upperDiagonalEmplacementsY) != (-1) ) {
				if( GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().isSetEmplacement(rightDiagonalEmplacementX, upperDiagonalEmplacementsY)).getIsOccupied() == true) {
					isEligibleForMove = true;
				}
			}
		} else if ( this.positionY == lowerDiagonalEmplacementsYForJump && this.positionX == leftDiagonalEmplacementXForJump ) {
			if ( GameVariableRepository.getInstance().isSetEmplacement(leftDiagonalEmplacementX, lowerDiagonalEmplacementsY) != (-1) ) {
				if( GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().isSetEmplacement(leftDiagonalEmplacementX, lowerDiagonalEmplacementsY)).getIsOccupied() == true) {
					isEligibleForMove = true;
				}
			}
		} else if ( this.positionY == lowerDiagonalEmplacementsYForJump && this.positionX == rightDiagonalEmplacementXForJump ) {
			if ( GameVariableRepository.getInstance().isSetEmplacement(rightDiagonalEmplacementX, lowerDiagonalEmplacementsY) != (-1) ) {
				if( GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().isSetEmplacement(rightDiagonalEmplacementX, lowerDiagonalEmplacementsY)).getIsOccupied() == true) {
					isEligibleForMove = true;
				}
			}
		}
		return isEligibleForMove;
	}
	
	
public boolean isSpecialMove() {
	Piece currentPiece = GameVariableRepository.getInstance().getSelectedPiece();
	
	boolean isEligibleForMove = false;
	int leftAndRightY = currentPiece.getYPosition();
	int leftEmplacementX = currentPiece.getXPosition() - 2;
	int rightEmplacementX = currentPiece.getXPosition() + 2;
	
	//Coordinates for the diagonales moves
	int leftDiagonalEmplacementX = currentPiece.getXPosition() - 1;
	int rightDiagonalEmplacementX = currentPiece.getXPosition() + 1;
	int upperDiagonalEmplacementsY = currentPiece.getYPosition() + 2;
	int lowerDiagonalEmplacementsY = currentPiece.getYPosition() - 2;
	int leftAndRightYForJump = currentPiece.getYPosition();
	int leftEmplacementXForJump = currentPiece.getXPosition() - 4;
	int rightEmplacementXForJump = currentPiece.getXPosition() + 4;
	
	//Coordinates for the diagonales moves
	int leftDiagonalEmplacementXForJump = currentPiece.getXPosition() - 2;
	int rightDiagonalEmplacementXForJump = currentPiece.getXPosition() + 2;
	int upperDiagonalEmplacementsYForJump = currentPiece.getYPosition() + 4;
	int lowerDiagonalEmplacementsYForJump = currentPiece.getYPosition() - 4;
	
	if ( this.positionY == leftAndRightYForJump && this.positionX == leftEmplacementXForJump ) {
		if ( GameVariableRepository.getInstance().isSetEmplacement(leftEmplacementX, leftAndRightY) != (-1) ) {
			if ( GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().isSetEmplacement(leftEmplacementX, leftAndRightY)).getIsOccupied() == true) {
				isEligibleForMove = true;
			}
		}
	} else if ( this.positionY == leftAndRightYForJump && this.positionX == rightEmplacementXForJump ) {
		if ( GameVariableRepository.getInstance().isSetEmplacement(rightEmplacementX, leftAndRightY) != (-1) ) {
			if ( GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().isSetEmplacement(rightEmplacementX, leftAndRightY)).getIsOccupied() == true) {
				isEligibleForMove = true;
			}
		}
	} else if ( this.positionY == upperDiagonalEmplacementsYForJump && this.positionX == leftDiagonalEmplacementXForJump ) {
		if ( GameVariableRepository.getInstance().isSetEmplacement(leftDiagonalEmplacementX, upperDiagonalEmplacementsY) != (-1) ) {
			if( GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().isSetEmplacement(leftDiagonalEmplacementX, upperDiagonalEmplacementsY)).getIsOccupied() == true) {
				isEligibleForMove = true;
			}
		}
	} else if ( this.positionY == upperDiagonalEmplacementsYForJump &&  this.positionX == rightDiagonalEmplacementXForJump ) {
		if ( GameVariableRepository.getInstance().isSetEmplacement(rightDiagonalEmplacementX, upperDiagonalEmplacementsY) != (-1) ) {
			if( GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().isSetEmplacement(rightDiagonalEmplacementX, upperDiagonalEmplacementsY)).getIsOccupied() == true) {
				isEligibleForMove = true;
			}
		}
	} else if ( this.positionY == lowerDiagonalEmplacementsYForJump && this.positionX == leftDiagonalEmplacementXForJump ) {
		if ( GameVariableRepository.getInstance().isSetEmplacement(leftDiagonalEmplacementX, lowerDiagonalEmplacementsY) != (-1) ) {
			if( GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().isSetEmplacement(leftDiagonalEmplacementX, lowerDiagonalEmplacementsY)).getIsOccupied() == true) {
				isEligibleForMove = true;
			}
		}
	} else if ( this.positionY == lowerDiagonalEmplacementsYForJump && this.positionX == rightDiagonalEmplacementXForJump ) {
		if ( GameVariableRepository.getInstance().isSetEmplacement(rightDiagonalEmplacementX, lowerDiagonalEmplacementsY) != (-1) ) {
			if( GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().isSetEmplacement(rightDiagonalEmplacementX, lowerDiagonalEmplacementsY)).getIsOccupied() == true) {
				isEligibleForMove = true;
			}
		}
	}
	if(isEligibleForMove==true) {
		System.out.println("Movement still possible ?");
		return true;
	} else {
		return false;
	}
}
	
	
	public boolean ifIsEligibleForJump() {
		Piece currentPiece = GameVariableRepository.getInstance().getSelectedPiece();
		
		boolean isEligibleForJump = false;
		//Coordinates for the horizontal moves
		int leftAndRightY = currentPiece.getYPosition();
		int leftEmplacementX = currentPiece.getXPosition() - 4;
		int rightEmplacementX = currentPiece.getXPosition() + 4;
		
		//Coordinates for the diagonales moves
		int leftDiagonalEmplacementX = currentPiece.getXPosition() - 2;
		int rightDiagonalEmplacementX = currentPiece.getXPosition() + 2;
		int upperDiagonalEmplacementsY = currentPiece.getYPosition() + 4;
		int lowerDiagonalEmplacementsY = currentPiece.getYPosition() - 4;
		
		// Conditions for horizontal moves		
		if ( this.positionY == leftAndRightY && ( this.positionX == leftEmplacementX || this.positionX == rightEmplacementX )  ) {
			isEligibleForJump = true;
			// Conditions for diagonal upper moves
		} else if ( this.positionY == upperDiagonalEmplacementsY && ( this.positionX == leftDiagonalEmplacementX || this.positionX == rightDiagonalEmplacementX ) ) {
			isEligibleForJump = true;
			// Conditions for diagonal lower moves
		} else if ( this.positionY == lowerDiagonalEmplacementsY && ( this.positionX == leftDiagonalEmplacementX || this.positionX == rightDiagonalEmplacementX ) ) {
			isEligibleForJump = true;
		}

		//Coordinates for the horizontal moves
		int leftAndRightYForJump = currentPiece.getYPosition();
		int leftEmplacementXForJump = currentPiece.getXPosition() - 8;
		int rightEmplacementXForJump = currentPiece.getXPosition() + 8;
		
		//Coordinates for the diagonales moves
		int leftDiagonalEmplacementXForJump = currentPiece.getXPosition() - 4;
		int rightDiagonalEmplacementXForJump = currentPiece.getXPosition() + 4;
		int upperDiagonalEmplacementsYForJump = currentPiece.getYPosition() + 8;
		int lowerDiagonalEmplacementsYForJump = currentPiece.getYPosition() - 8;
		
		if ( this.positionY == leftAndRightYForJump && ( this.positionX == leftEmplacementXForJump || this.positionX == rightEmplacementXForJump ) ) {
			if ( GameVariableRepository.getInstance().isSetEmplacement(leftEmplacementX, leftAndRightY) != (-1) ) {
				if ( GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().isSetEmplacement(leftEmplacementX, leftAndRightY)).getIsOccupied() == true) {
					isEligibleForJump = true;
				}
			} else if ( GameVariableRepository.getInstance().isSetEmplacement(rightEmplacementX, leftAndRightY) != (-1) ) {
				if ( GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().isSetEmplacement(rightEmplacementX, leftAndRightY)).getIsOccupied() == true) {
					isEligibleForJump = true;
				}
			}
			// Conditions for diagonal upper moves
		} else if ( this.positionY == upperDiagonalEmplacementsYForJump && ( this.positionX == leftDiagonalEmplacementXForJump || this.positionX == rightDiagonalEmplacementXForJump ) ) {
			if ( GameVariableRepository.getInstance().isSetEmplacement(leftDiagonalEmplacementX, upperDiagonalEmplacementsY) != (-1) ) {
				if( GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().isSetEmplacement(leftDiagonalEmplacementX, upperDiagonalEmplacementsY)).getIsOccupied() == true) {
					isEligibleForJump = true;
				}
			} else if ( GameVariableRepository.getInstance().isSetEmplacement(rightDiagonalEmplacementX, upperDiagonalEmplacementsY) != (-1) ) {
				if( GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().isSetEmplacement(rightDiagonalEmplacementX, upperDiagonalEmplacementsY)).getIsOccupied() == true) {
					isEligibleForJump = true;
				}
			}
			// Conditions for diagonal lower moves
		} else if ( this.positionY == lowerDiagonalEmplacementsYForJump && ( this.positionX == leftDiagonalEmplacementXForJump || this.positionX == rightDiagonalEmplacementXForJump ) ) {
			if ( GameVariableRepository.getInstance().isSetEmplacement(leftDiagonalEmplacementX, lowerDiagonalEmplacementsY) != (-1) ) {
				if( GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().isSetEmplacement(leftDiagonalEmplacementX, lowerDiagonalEmplacementsY)).getIsOccupied() == true) {
					isEligibleForJump = true;
				}
			} else if ( GameVariableRepository.getInstance().isSetEmplacement(rightDiagonalEmplacementX, lowerDiagonalEmplacementsY) != (-1) ) {
				if( GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().isSetEmplacement(rightDiagonalEmplacementX, lowerDiagonalEmplacementsY)).getIsOccupied() == true) {
					isEligibleForJump = true;
				}
			}
		}
		return isEligibleForJump;
	}
	
	
	public boolean getIsOccupied() {
		return this.isOccupied;
	}
	
	public boolean isCursorOnEmplacement(int x, int y) {
		boolean isOnEmplacement = false;
		float distanceBetweenCursorAndEmplacement = (float) (Math.pow(this.XOnCanvas-x, 2) + Math.pow(this.YOnCanvas-y, 2));
		if ( x >= this.XOnCanvas && x <= this.XOnCanvas + 44 && y >= this.YOnCanvas && y <= this.YOnCanvas + 44   ) {
			isOnEmplacement = true;
		}
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
