package checker.data;

import java.awt.Component;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import checker.panels.Board;
import checker.panels.CheckerBoardPanel;
import checker.panels.LaunchGameScreenPanel;
import checker.panels.MainScreenPanel;
import checker.panels.OptionsScreenPanel;
import checker.panels.PanelsContainer;

public class ClassFactory {
	public static Object createNoTextContainingComponent (String type) {
		switch (type) {
		case "JSeparator":
			return new JSeparator();
		case "VerticalBox":
			return Box.createVerticalBox();
		case "HorizontalBox":
			return Box.createHorizontalBox();
		case "JTextField":
			return new JTextField();
		case "JTextArea":
			return new JTextArea();
		case "JComboBox":
			return new JComboBox();
		case "JSlider":
			return new JSlider(0,100,50);
		default:
			return null;
		}
	}
	
	public static Player createPlayer(String name, boolean isAi) {
		return new Player(name, isAi);
		
	}
	
	public static JPanel createPanel(String panelName) throws IOException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException {
		switch (panelName) {
		case "MainScreenPanel":
			return new MainScreenPanel();
		case "LaunchGameScreenPanel":
			return new LaunchGameScreenPanel();
		case "OptionsScreenPanel":
			return new OptionsScreenPanel();
		case "CheckerBoardPanel":
			return new CheckerBoardPanel(panelName, null);
		case "PanelsContainer":
			return PanelsContainer.getInstance();
		case "BoardPanel":
			return new Board();
		default:
			return null;
		}
	}
	
	public static Component createTextContainingComponent (String type, String text) {
		switch (type) {
		case "JButton":
			return new JButton(text);
		case "JLabel":
			return new JLabel(text);
		case "JCheckBox":
			return new JCheckBox(text);
		default:
			return null;
		}
	}
	
	
}
