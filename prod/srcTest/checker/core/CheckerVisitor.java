package checker.core;

import java.awt.Component;
import javax.swing.JPanel;

import checker.data.Emplacement;
import checker.data.Player;
import checker.panels.Board;

public interface CheckerVisitor<T> {
	T visit(JPanel node);

	// T visit(Piece node);

	T visit(Component node);
	
	T visit(Player node);
	
	T visit(Board node);
	
	T visit(Emplacement node);
}
