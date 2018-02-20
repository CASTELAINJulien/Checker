package checker.gui;

import java.awt.Color;
import java.awt.Component;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;

import checker.core.CheckerBuilder;
import checker.core.VariableRepository;
import checker.data.ClassFactory;
import checker.panels.Board;
import checker.panels.CheckerBoardPanel;
import checker.panels.LaunchGameScreenPanel;
import checker.panels.MainScreenPanel;
import checker.panels.OptionsScreenPanel;
import checker.panels.PanelsContainer;

public class GraphicalChecker extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1101006957083345550L;
	private PanelsContainer panelsContainer;
	private MainScreenPanel mainScreenPanel;
	private LaunchGameScreenPanel launchGameScreenPanel;
	// private CheckerBoardPanel checkerBoardPanel;
	private Board checkerBoardPanel;
	private OptionsScreenPanel optionsScreenPanel;

	public GraphicalChecker() throws IllegalArgumentException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException {
		super("Checker");
		// CheckerBuilder builder = new CheckerBuilder();
		try {
			panelsContainer = (PanelsContainer) ClassFactory.createPanel("PanelsContainer");
			mainScreenPanel = (MainScreenPanel) ClassFactory.createPanel("MainScreenPanel");
			launchGameScreenPanel = (LaunchGameScreenPanel) ClassFactory.createPanel("LaunchGameScreenPanel");
			checkerBoardPanel = (Board) ClassFactory.createPanel("BoardPanel");
			optionsScreenPanel = (OptionsScreenPanel) ClassFactory.createPanel("OptionsScreenPanel");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		panelsContainer.addPanel(mainScreenPanel);
		panelsContainer.addPanel(launchGameScreenPanel);
		panelsContainer.addPanel(checkerBoardPanel);
		panelsContainer.addPanel(optionsScreenPanel);
		
		VariableRepository.getInstance();
		
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
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
