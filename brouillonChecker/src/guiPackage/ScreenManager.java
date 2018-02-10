package guiPackage;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScreenManager extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel cardsContainer;
	private CardLayout cardLayout;
	
	private ScreenManager () {
		cardLayout = new CardLayout();
		cardsContainer = new JPanel(cardLayout);
	}
	
	public static JPanel getInstance(){
		if( cardsContainer == null ){
			new ScreenManager();
		}
		return cardsContainer;   
	}
	
	public CardLayout getCardLayout() {
		return cardLayout;
	}
	
	public static void init(JFrame frame) {
		Container contentPane = frame.getRootPane();
		contentPane.setLayout(new BorderLayout());
		cardsContainer.setBackground(Color.WHITE);
	}
}
