package checker.gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import checker.core.CheckerBuilder;
import checker.panels.CheckerBoardPanel;
import checker.panels.LaunchGameScreenPanel;
import checker.panels.MainScreenPanel;
import checker.panels.PanelsContainer;

public class GraphicalChecker extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1101006957083345550L;
	private PanelsContainer panelsContainer;
	private MainScreenPanel mainScreenPanel;
	private LaunchGameScreenPanel launchGameScreenPanel;
	private CheckerBoardPanel checkerBoardPanel;

	public GraphicalChecker() throws IllegalArgumentException {
		super("Checker");
		// CheckerBuilder builder = new CheckerBuilder();
		panelsContainer = PanelsContainer.getInstance();
		mainScreenPanel = new MainScreenPanel();
		launchGameScreenPanel = new LaunchGameScreenPanel();
		checkerBoardPanel = new CheckerBoardPanel("test", this);
		
		panelsContainer.addPanel(mainScreenPanel);
		panelsContainer.addPanel(launchGameScreenPanel);
		panelsContainer.addPanel(checkerBoardPanel);
		
		// panelsContainer.getCards();
		// panelsContainer.getCardLayout().next(panelsContainer);
		// System.out.println(panelsContainer.getCards().length);

		initLayout();
		
	}

	private void initLayout() {
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		
		getContentPane().add(panelsContainer);
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}

	public static void main(String[] args) {
		try {
			new GraphicalChecker();
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}

}
