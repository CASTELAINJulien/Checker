package checker.core;

import java.awt.Component;

import javax.swing.JPanel;

import checker.data.Player;
import checker.panels.CheckerBoardPanel;

public class PanelsVisitor implements CheckerVisitor<Void> {
	
	public Component[] getPanelComponents( JPanel panel ) {
		return panel.getComponents();
	}
	
	@Override
	public Void visit(JPanel node) {
		return null;
	}

	// T visit(Piece node);
	@Override
	public Void visit(Component node) {
		return null;
	}
	
	@Override
	public Void visit(Player node) {
		return null;
	}
	
	@Override
	public Void visit(CheckerBoardPanel node) {
		return null;
	}
}
