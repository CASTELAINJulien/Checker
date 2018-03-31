package checker.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import checker.core.CheckerBuilder;
import checker.core.GameVariableRepository;
import checker.core.VariableRepository;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EndGame extends JPanel {

private static final long serialVersionUID = 1L;
private JButton btnReplay;
private JButton btnQuit;
private JButton btnMainMenu;

private JLabel lblPlayer1;
private JLabel lblPlayer2;
private JLabel lblPlayer3;

private JLabel nbSimpleMoveP1;
private JLabel nbSimpleMoveP2;
private JLabel nbSimpleMoveP3;

private JLabel nbSpecialMoveP1;
private JLabel nbSpecialMoveP2;
private JLabel nbSpecialMoveP3;

private JLabel nbPowerActivatedP1;
private JLabel nbPowerActivatedP2;
private JLabel nbPowerActivatedP3;

private JLabel nbTotalMoveP1;
private JLabel nbTotalMoveP2;
private JLabel nbTotalMoveP3;

private JLabel rankP1;
private JLabel rankP2;
private JLabel rankP3;

	public EndGame() {
		super();
		//GameVariableRepository.getInstance().scoreCalculator();

		initLayout();
		initAction();
	}
	private void initLayout() {
		setLayout(null);
		
		JLabel lblGameOver = new JLabel("Game Over");
		lblGameOver.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblGameOver.setBounds(418, 22, 335, 76);
		add(lblGameOver);
		
		btnReplay = new JButton("Replay");
		btnReplay.setBounds(360, 522, 114, 23);
		add(btnReplay);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(474, 522, 114, 23);
		add(btnMainMenu);
		
		btnQuit = new JButton("Quit");
		btnQuit.setBounds(584, 522, 114, 23);
		add(btnQuit);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(350, 112, 2, 340);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(681, 112, 2, 340);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		add(separator_2);
		
		
		lblPlayer1 = new JLabel("Player 1:");
		lblPlayer1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPlayer1.setBounds(81, 121, 162, 50);
		add(lblPlayer1);
		
		nbTotalMoveP1 = new JLabel();
		nbTotalMoveP1.setBounds(61, 170, 280, 14);
		add(nbTotalMoveP1);
		
		nbSimpleMoveP1 = new JLabel();
		nbSimpleMoveP1.setBounds(61, 190, 280, 14);
		add(nbSimpleMoveP1);
		
		nbSpecialMoveP1 = new JLabel();
		nbSpecialMoveP1.setBounds(61, 215, 280, 14);
		add(nbSpecialMoveP1);
		
		nbPowerActivatedP1 = new JLabel();
		nbPowerActivatedP1.setBounds(61, 235, 280, 14);
		add(nbPowerActivatedP1);
			
		//a completer
		rankP1 = new JLabel();
		rankP1.setBounds(61, 255, 115, 14);
		add(rankP1);
				
		
		lblPlayer2 = new JLabel("Player 2:");
		lblPlayer2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPlayer2.setBounds(410, 121, 168, 50);
		add(lblPlayer2);
		
		nbTotalMoveP2 = new JLabel();
		nbTotalMoveP2.setBounds(390, 170, 280, 14);
		add(nbTotalMoveP2);
		
		nbSimpleMoveP2 = new JLabel();
		nbSimpleMoveP2.setBounds(390, 190, 280, 14);
		add(nbSimpleMoveP2);
		
		nbSpecialMoveP2 = new JLabel();
		nbSpecialMoveP2.setBounds(390, 215, 280, 14);
		add(nbSpecialMoveP2);
		
		nbPowerActivatedP2 = new JLabel();
		nbPowerActivatedP2.setBounds(390, 235, 280, 14);
		add(nbPowerActivatedP2);
		
	
		rankP2 = new JLabel();
		rankP2.setBounds(390, 255, 115, 14);
		add(rankP2);
		
			
		lblPlayer3 = new JLabel("Player 3:");
		lblPlayer3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPlayer3.setBounds(730, 121, 192, 50);
		add(lblPlayer3);
		
		nbTotalMoveP3 = new JLabel();
		nbTotalMoveP3.setBounds(710, 170, 280, 14);
		add(nbTotalMoveP3);
		
		nbSimpleMoveP3 = new JLabel();
		nbSimpleMoveP3.setBounds(710, 190, 280, 14);
		add(nbSimpleMoveP3);
		
		nbSpecialMoveP3 = new JLabel();
		nbSpecialMoveP3.setBounds(710, 215, 280, 14);
		add(nbSpecialMoveP3);
		
		nbPowerActivatedP3 = new JLabel();
		nbPowerActivatedP3.setBounds(710, 235, 280, 14);
		add(nbPowerActivatedP3);
			
		rankP3 = new JLabel();
		rankP3.setBounds(710, 255, 200, 14);
		add(rankP3);			
	}
	
	public void initAction() {
		btnQuit.addActionListener(new QuitAction());
		btnReplay.addActionListener(new ReplayAction());
		btnMainMenu.addActionListener(new MainMenuAction());
	}
	
	private class QuitAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	private class MainMenuAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			VariableRepository.getInstance().searchPlayer("Player 1").getStats().reset();
			VariableRepository.getInstance().searchPlayer("Player 2").getStats().reset();
			VariableRepository.getInstance().searchPlayer("Player 3").getStats().reset();
			PanelsContainer.getInstance().getCardLayout().first(PanelsContainer.getInstance());
		}
	}
	private class ReplayAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			//TODO reinitialisé board
			//CheckerBuilder.getInstance().initializeEmplacements();
			VariableRepository.getInstance().searchPlayer("Player 1").getStats().reset();
			VariableRepository.getInstance().searchPlayer("Player 2").getStats().reset();
			VariableRepository.getInstance().searchPlayer("Player 3").getStats().reset();
			PanelsContainer.getInstance().getCardLayout().previous(PanelsContainer.getInstance());
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(GameVariableRepository.getInstance().getGameStarted()==true) {
			nbSimpleMoveP1.setText("Number of simple moves: "+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 1").getStats().getSimpleMove())+" ("+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 1").getStats().ratioSimpleMove())+"%)");
			nbSpecialMoveP1.setText("Number of special moves: "+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 1").getStats().getSpecialMove())+" ("+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 1").getStats().ratioSpecialMove())+"%)");			
			nbPowerActivatedP1.setText("Number of power activated: "+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 1").getStats().getPowerUsed()));
			nbTotalMoveP1.setText("Number of moves: "+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 1").getStats().getTotalNumberOfMove()));
			//scoreP1.setText("score: "+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 1").getStats().getScore()));
			rankP1.setText("Rank: "+(VariableRepository.getInstance().searchPlayer("Player 1").getStats().getRank()));
			lblPlayer1.setText(VariableRepository.getInstance().searchPlayer("Player 1").getPlayerName());
			

			
			nbSimpleMoveP2.setText("Number of simple moves: "+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 2").getStats().getSimpleMove())+" ("+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 2").getStats().ratioSimpleMove())+"%)");
			nbSpecialMoveP2.setText("Number of special moves: "+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 2").getStats().getSpecialMove())+" ("+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 2").getStats().ratioSpecialMove())+"%)");
			nbPowerActivatedP2.setText("Number of power activated: "+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 2").getStats().getPowerUsed()));
			nbTotalMoveP2.setText("Number of moves: "+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 2").getStats().getTotalNumberOfMove()));
			//scoreP2.setText("score: "+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 2").getStats().getScore()));
			rankP2.setText("Rank: "+(VariableRepository.getInstance().searchPlayer("Player 2").getStats().getRank()));
			lblPlayer2.setText(VariableRepository.getInstance().searchPlayer("Player 2").getPlayerName());

			
			nbSimpleMoveP3.setText("Number of simple moves: "+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 3").getStats().getSimpleMove())+" ("+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 3").getStats().ratioSimpleMove())+"%)");
			nbSpecialMoveP3.setText("Number of special moves: "+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 3").getStats().getSpecialMove())+" ("+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 3").getStats().ratioSpecialMove())+"%)");
			nbPowerActivatedP3.setText("Number of power activated: "+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 3").getStats().getPowerUsed()));
			nbTotalMoveP3.setText("Number of moves: "+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 3").getStats().getTotalNumberOfMove()));
			//scoreP3.setText("score: "+String.valueOf(VariableRepository.getInstance().searchPlayer("Player 3").getStats().getScore()));
			rankP3.setText("Rank: "+(VariableRepository.getInstance().searchPlayer("Player 3").getStats().getRank()));
			lblPlayer3.setText(VariableRepository.getInstance().searchPlayer("Player 3").getPlayerName());

		}
		repaint();	
	}
}
