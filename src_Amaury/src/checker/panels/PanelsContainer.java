package checker.panels;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JPanel;

public class PanelsContainer extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private CardLayout cardLayout = new CardLayout();
	
	private PanelsContainer (CardLayout layoutParameter) {
		super(layoutParameter );
	}
	
	private static PanelsContainer instance = new PanelsContainer(new CardLayout());
	
	public static PanelsContainer getInstance() {
		return instance;   
	}
	
	public void addPanel( Container panelToAdd ) {
		add(panelToAdd);  
	}
	
	public CardLayout getCardLayout() {
		return (CardLayout) this.getLayout();
	}
	
	public Component[] getCards() {
		return this.getComponents();
	}
}
