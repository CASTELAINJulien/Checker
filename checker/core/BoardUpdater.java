
package checker.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import checker.data.Emplacement;
import checker.data.Piece;
import checker.gui.BoardParameter;
import checker.panels.Board;

public class BoardUpdater {
	private BoardUpdater() {

	}

	/**
	 * The instance attribute is actually the self-scoped object/class.
	 */
	private static BoardUpdater instance = new BoardUpdater();
	
	/**
	 * A method that able us to get the singleton from anywhere if called.
	 * @return Returns the object instance, the "variables" HashMap.
	 */
	public static BoardUpdater getInstance() {
		return instance;
	}
	
	public void updatePieceSelectionState (Piece pieceToBeSelected, Emplacement currentEmplacement) {
    	GameVariableRepository.getInstance().setSelectedPiece(pieceToBeSelected);
    	GameVariableRepository.getInstance().setEmplacementToBeEmptied(currentEmplacement);
    	
    	// xTempValue = currentEmplacement.getPositionX();
        // yTempValue = currentEmplacement.getPositionY();
        
        // System.out.println(number.getPositionX());    // insert a number right before this
        GameVariableRepository.getInstance().setAPieceIsSelected(true);
        
        GameVariableRepository.getInstance().setIndexOfEmplacementToBeEmptied(GameVariableRepository.getInstance().getEmplacementsArrayList().indexOf(currentEmplacement));
	}
	
	public void updateAfterMovePieceState(Piece currentSelectedPiece, Emplacement currentEmplacement) {
    	GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().getEmplacementsArrayList().indexOf(currentEmplacement)).setIsOccupied(true);
    	GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().getEmplacementsArrayList().indexOf(currentEmplacement)).setOccupyingPiece(currentSelectedPiece);
    	
    	GameVariableRepository.getInstance().getEmplacementTable()[currentEmplacement.getPositionX()][currentEmplacement.getPositionY()].setIsOccupied(true);
    	GameVariableRepository.getInstance().getEmplacementTable()[currentEmplacement.getPositionX()][currentEmplacement.getPositionY()].setOccupyingPiece(currentSelectedPiece);
    	
    	Emplacement toUpdateAsEmpty = GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().getIndexOfEmplacementToBeEmptied());
    	GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().getIndexOfEmplacementToBeEmptied()).setIsOccupied(false);
    	GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().getIndexOfEmplacementToBeEmptied()).setOccupyingPiece(null);
    	
    	GameVariableRepository.getInstance().getEmplacementTable()[toUpdateAsEmpty.getPositionX()][toUpdateAsEmpty.getPositionY()].setIsOccupied(false);
    	GameVariableRepository.getInstance().getEmplacementTable()[toUpdateAsEmpty.getPositionX()][toUpdateAsEmpty.getPositionY()].setOccupyingPiece(null);
    	
    	GameVariableRepository.getInstance().setSelectedPiece(null);
    	GameVariableRepository.getInstance().setAPieceIsSelected(false);
			
		currentSelectedPiece.setXPosition(currentEmplacement.getPositionX());
		currentSelectedPiece.setYPosition(currentEmplacement.getPositionY());
	}
	
	public void drawCheckerBoardEmplacements ( Graphics g ) {
		// Set up the checker board at first
		for (ListIterator<Emplacement> iter = GameVariableRepository.getInstance().getEmplacementsArrayList().listIterator(); iter.hasNext(); ) {
            Emplacement currentEmplacement = iter.next();
            g.setColor(Color.BLACK);
            // System.out.println(number.getPositionX());    // insert a number right before this
            g.fillOval((int) (currentEmplacement.getPositionX()*BoardParameter.interEmplacementSpaces + BoardParameter.boardStartingPoint) ,currentEmplacement.getPositionY()*BoardParameter.interEmplacementSpaces,BoardParameter.pieceRadius,BoardParameter.pieceRadius);
            g.drawOval((int) (currentEmplacement.getPositionX()*BoardParameter.interEmplacementSpaces + BoardParameter.boardStartingPoint) ,currentEmplacement.getPositionY()*BoardParameter.interEmplacementSpaces,BoardParameter.pieceRadius,BoardParameter.pieceRadius);            
        }
	}
	
	public void drawPlayersPieces ( Graphics g ) {
		boolean gameHasStarted = GameVariableRepository.getInstance().getGameStarted();
		if ( gameHasStarted == true ) {
			for (ListIterator<Emplacement> iter2 = GameVariableRepository.getInstance().getEmplacementsArrayList().listIterator(); iter2.hasNext(); ) {
				//g.setColor(Color.red);
				Emplacement currentEmplacement = iter2.next();
				
				System.out.println(currentEmplacement.toString() + "\n");
				
				int radius = BoardParameter.pieceRadius;
				int x = currentEmplacement.getPositionX()*BoardParameter.interEmplacementSpaces + BoardParameter.boardStartingPoint;
				int y = currentEmplacement.getPositionY()*BoardParameter.interEmplacementSpaces;
	            if ( currentEmplacement.getIsOccupied() == true ) {
	            	Color color = currentEmplacement.getOccupyingPiece().getColor();
	            	g.setColor(color);
	            	g.fillOval(x,y,radius,radius);
	            } 
			}
		}
	}
	
	public void animateSelectedPiece ( Graphics g ) {
		if ( GameVariableRepository.getInstance().getAPieceIsSelected() == true ) {
			Emplacement toUpdate = GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().getIndexOfEmplacementToBeEmptied());
			g.setColor(Color.MAGENTA);
			g.fillOval(toUpdate.getPositionX() * BoardParameter.interEmplacementSpaces + BoardParameter.boardStartingPoint, toUpdate.getPositionY()*BoardParameter.interEmplacementSpaces, BoardParameter.pieceRadius, BoardParameter.pieceRadius);
			// justPlayed = false;
		} else {
			Emplacement toUpdate = GameVariableRepository.getInstance().getEmplacementsArrayList().get(GameVariableRepository.getInstance().getIndexOfEmplacementToBeEmptied());
			if ( toUpdate != null ) {
				g.setColor(Color.BLACK);
				g.fillOval(toUpdate.getPositionX() * BoardParameter.interEmplacementSpaces + BoardParameter.boardStartingPoint, toUpdate.getPositionY()*BoardParameter.interEmplacementSpaces, BoardParameter.pieceRadius, BoardParameter.pieceRadius);
			}
			
			GameVariableRepository.getInstance().setEmplacementToBeEmptied(null);
			// GameVariableRepository.getInstance().setIndexOfEmplacementToBeEmptied(0);
			// System.out.println(toUpdate.toString());
		}
	}
}
