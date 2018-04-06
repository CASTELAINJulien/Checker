package checker.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import checker.data.Emplacement;
import checker.data.Piece;
import checker.data.Player;
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
    	GameVariableRepository.getInstance().setAPieceIsSelected(true);
        GameVariableRepository.getInstance().setIndexOfEmplacementToBeEmptied(GameVariableRepository.getInstance().getEmplacementsArrayList().indexOf(currentEmplacement));
	}
	
	public void updatePieceDeselectionState () {
        GameVariableRepository.getInstance().setAPieceIsSelected(false);
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
            g.fillOval((int) (currentEmplacement.getPositionX()*BoardParameter.interEmplacementSpaces + BoardParameter.boardStartingPoint) ,currentEmplacement.getPositionY()*BoardParameter.interEmplacementSpaces,BoardParameter.pieceRadius,BoardParameter.pieceRadius);
            g.drawOval((int) (currentEmplacement.getPositionX()*BoardParameter.interEmplacementSpaces + BoardParameter.boardStartingPoint) ,currentEmplacement.getPositionY()*BoardParameter.interEmplacementSpaces,BoardParameter.pieceRadius,BoardParameter.pieceRadius);            
        }
	}
	
	public void drawCheckerBoardVictoryEmplacements ( Graphics g ) {
		// Set up the checker board at first
		for (ListIterator<Emplacement> iter = GameVariableRepository.getInstance().getFirstVictoryAreaEmplacements().listIterator(); iter.hasNext(); ) {
            Emplacement currentEmplacement = iter.next();
            g.setColor(currentEmplacement.getColor());
            g.fillOval((int) (currentEmplacement.getPositionX()*BoardParameter.interEmplacementSpaces + BoardParameter.boardStartingPoint) ,currentEmplacement.getPositionY()*BoardParameter.interEmplacementSpaces,BoardParameter.pieceRadius,BoardParameter.pieceRadius);
            g.drawOval((int) (currentEmplacement.getPositionX()*BoardParameter.interEmplacementSpaces + BoardParameter.boardStartingPoint) ,currentEmplacement.getPositionY()*BoardParameter.interEmplacementSpaces,BoardParameter.pieceRadius,BoardParameter.pieceRadius);            
        }
		
		for (ListIterator<Emplacement> iter = GameVariableRepository.getInstance().getSecondVictoryAreaEmplacements().listIterator(); iter.hasNext(); ) {
            Emplacement currentEmplacement = iter.next();
            g.setColor(currentEmplacement.getColor());
            g.fillOval((int) (currentEmplacement.getPositionX()*BoardParameter.interEmplacementSpaces + BoardParameter.boardStartingPoint) ,currentEmplacement.getPositionY()*BoardParameter.interEmplacementSpaces,BoardParameter.pieceRadius,BoardParameter.pieceRadius);
            g.drawOval((int) (currentEmplacement.getPositionX()*BoardParameter.interEmplacementSpaces + BoardParameter.boardStartingPoint) ,currentEmplacement.getPositionY()*BoardParameter.interEmplacementSpaces,BoardParameter.pieceRadius,BoardParameter.pieceRadius);            
        }
		
		for (ListIterator<Emplacement> iter = GameVariableRepository.getInstance().getThirdVictoryAreaEmplacements().listIterator(); iter.hasNext(); ) {
            Emplacement currentEmplacement = iter.next();
            g.setColor(currentEmplacement.getColor());
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
		}
	}
	
	public void animateAvailableEmplacement ( Graphics g ) {
		Player currentPlayer=VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName());
		if ( GameVariableRepository.getInstance().getAPieceIsSelected() == true && currentPlayer.getIsBeginner()==true) {
			ListIterator<Emplacement> iter2 = GameVariableRepository.getInstance().getEmplacementsArrayList().listIterator();
			while (iter2.hasNext()) {
				Emplacement currentEmplacement = iter2.next();
				if(currentEmplacement.getIsOccupied()==false && currentEmplacement.ifIsEligibleForMove()==true) {
					g.setColor(Color.WHITE);
					g.fillOval(currentEmplacement.getPositionX() * BoardParameter.interEmplacementSpaces + BoardParameter.boardStartingPoint, currentEmplacement.getPositionY()*BoardParameter.interEmplacementSpaces, BoardParameter.pieceRadius, BoardParameter.pieceRadius);	
				}
				//if teleport power is activated
				//TODO need to be improved
				else if(currentPlayer.getPowerActivated()!=9 && currentPlayer.getPower(currentPlayer.getPowerActivated()).getName()=="Teleport") {
					if(currentEmplacement.getIsOccupied()==false) {			
						g.setColor(Color.WHITE);
						g.fillOval(currentEmplacement.getPositionX() * BoardParameter.interEmplacementSpaces + BoardParameter.boardStartingPoint, currentEmplacement.getPositionY()*BoardParameter.interEmplacementSpaces, BoardParameter.pieceRadius, BoardParameter.pieceRadius);	
					}
				}
				//if jump power is activated
				else if(currentPlayer.getPowerActivated()!=9 && currentEmplacement.getIsOccupied()==false && currentPlayer.getPower(currentPlayer.getPowerActivated()).getName()=="Jump") {
					if( currentEmplacement.ifIsEligibleForJump()==true) {
						g.setColor(Color.WHITE);
						g.fillOval(currentEmplacement.getPositionX() * BoardParameter.interEmplacementSpaces + BoardParameter.boardStartingPoint, currentEmplacement.getPositionY()*BoardParameter.interEmplacementSpaces, BoardParameter.pieceRadius, BoardParameter.pieceRadius);	
					
					}
				}
			}
		}	
	}
	
	public void updatePlayerPowerButtons(JButton btnPower1,JButton btnPower2,JLabel labelPlayerActualTurn) {
		
		Player playerToUpdate = VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName());
		
		if((playerToUpdate.getPlayerMana()>=playerToUpdate.getPower(0).getCost2())&& (VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPowerActivated()==9)){
			btnPower1.setBorder(BorderFactory.createLineBorder(Color.green, 4));
			btnPower1.setEnabled(true);	
		} else {
			btnPower1.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			btnPower1.setEnabled(false);
		}
		
		if((playerToUpdate.getPlayerMana()>=playerToUpdate.getPower(1).getCost2())&& (VariableRepository.getInstance().searchPlayer(GameVariableRepository.getInstance().getActualPlayerName()).getPowerActivated()==9)){
			btnPower2.setBorder(BorderFactory.createLineBorder(Color.green, 4));
			btnPower2.setEnabled(true);
		} else {				
			btnPower2.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			btnPower2.setEnabled(false);
		}
		
		btnPower1.setToolTipText("<html><center>"+playerToUpdate.getPower(0).getName()+
				" power:<br>"+playerToUpdate.getPower(0).getDescription2()+
				"<br>cost:"+playerToUpdate.getPower(0).getCost2()+"</center></html>");
		btnPower2.setToolTipText("<html><center>"+playerToUpdate.getPower(1).getName()+
				" power:<br>"+playerToUpdate.getPower(1).getDescription2()+
				"<br>cost:"+playerToUpdate.getPower(1).getCost2()+"</center></html>");
			
		btnPower1.setIcon(new ImageIcon(playerToUpdate.getPower(0).getImage()));
		btnPower2.setIcon(new ImageIcon(playerToUpdate.getPower(1).getImage()));
	}
}