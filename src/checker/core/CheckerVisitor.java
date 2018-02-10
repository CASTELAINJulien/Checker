package checker.core;

import java.awt.Component;
import javax.swing.JPanel;

import checker.data.Player;
import checker.panels.CheckerBoardPanel;

public interface CheckerVisitor<T> {
	T visit(JPanel node);

	// T visit(Piece node);

	T visit(Component node);
	
	T visit(Player node);
	
	T visit(CheckerBoardPanel node);
}
