package checker.core;

import java.awt.Component;

import javax.swing.JPanel;

import checker.data.Emplacement;
import checker.data.Player;
import checker.panels.Board;

public class PanelsVisitor implements CheckerVisitor<Void> {
	
	public Component[] getPanelComponents( JPanel panel ) {
		return panel.getComponents();
	}
	
	
	public Void visit(JPanel node) {
		return null;
	}

	// T visit(Piece node);
	
	public Void visit(Component node) {
		return null;
	}
	
	
	public Void visit(Player node) {
		return null;
	}


	public Void visit(Board node) {
		// TODO Auto-generated method stub
		return null;
	}

	public Void visit(Emplacement node) {
		// TODO Auto-generated method stub
		return null;
	}
}