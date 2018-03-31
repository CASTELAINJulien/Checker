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
import checker.panels.LaunchGameScreenPanel;
import checker.panels.MainScreenPanel;
import checker.panels.OptionsScreenPanel;
import checker.panels.PanelsContainer;

/**
 * The main purpose of this class is to follow the "Simple Factory" Design Pattern, as to reunite ALL instanciation inside the methods of the class.
 * @author Amaury SIHARATH
 *
 */
public class ClassFactory {
	
	/**
	 * A method that instantiate graphical components that contains no text.
	 * @param type A String-class parameter that indicates which class of object of the Swing API we need to instantiate. Possible values are :
	 * <ul>
	 * <li> JSeparator </li>
	 * <li> VerticalBox </li>
	 * <li> HorizontalBox </li>
	 * <li> JTextField </li>
	 * <li> JTextArea </li>
	 * <li> JComboBox </li>
	 * <li> JSlider </li>
	 * </ul>
	 * @return Returns a graphical component from the Swing Library. Refers to the parameter list to see possible returned values.
	 */
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
	
	/**
	 * A method that instantiate a Player-class Object.
	 * @param name Parameters which is the will-be name of the Player.
	 * @param isAi Parameters which indicates if the Player will be AI-controlled or not.
	 * @return Returns a Player-lass object.
	 */
	public static Player createPlayer(String name, boolean isAi) {
		return new Player(name, isAi);
		
	}
	
	/**
	 * A method that instantiate all the differents JPanel used in the program. It should be noted that all these JPanels will be stored inside "PanelsContainer", a CardLayout, a JPanel containing all of these.
	 * @param panelName A String-class object that indicates which JPanel we want to instantiate. Possible values are :
	 * <ul>
	 * <li> MainScreenPanel </li>
	 * <li> LaunchGameScreenPanel </li>
	 * <li> OptionsScreenPanel </li>
	 * <li> PanelsContainer </li>
	 * <li> BoardPanel </li>
	 * </ul>
	 * @return Returns a JPanel-Inherited object.
	 * @throws IOException Throws an IOException when files for the sound are not found.
	 * @throws InterruptedException Throws an InterruptedException when there is a thread problem.
	 * @throws LineUnavailableException Throws an LineUnavailableException when there is a problem when opening a clip with Java Sound API, more precisely with the ClipPlayer class
	 * @throws UnsupportedAudioFileException Throws an UnsupportedAudioFileException when the file extension for the sound is different than a .wav. Only .wav files are supported by Java Sound API.
	 */
	public static JPanel createPanel(String panelName) throws IOException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException {
		switch (panelName) {
		case "MainScreenPanel":
			return new MainScreenPanel();
		case "LaunchGameScreenPanel":
			return new LaunchGameScreenPanel();
		case "OptionsScreenPanel":
			return new OptionsScreenPanel();
		case "PanelsContainer":
			return PanelsContainer.getInstance();
		case "BoardPanel":
			return new Board();
		default:
			return null;
		}
	}
	
	/**
	 * A method that instantiate graphical components that contains text, such as buttons, labels, checkboxes ...
	 * @param type A String-class parameter that indicates which class of object of the Swing API we need to instantiate. Possible values are :
	 * <ul>
	 * <li> JButton </li>
	 * <li> JLabel </li>
	 * <li> JCheckBox </li>
	 * </ul>
	 * @param text A String-class parameter that indicates the text content of the graphical component.
	 * @return Return 
	 */
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