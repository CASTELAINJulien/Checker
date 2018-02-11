package checker.data;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

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
		case "JComboBox":
			return new JComboBox();
		default:
			return null;
		}
	}
	
	public static Player createPlayer(String name, boolean isAi) {
		return new Player(name, isAi);
		
	}
	
	public static Component createTextContainingComponent (String type, String text) {
		switch (type) {
		case "JButton":
			return new JButton(text);
		case "JLabel":
			return new JLabel(text);
		default:
			return null;
		}
	}
	
	
}
