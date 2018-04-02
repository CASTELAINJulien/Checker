
package checker.panels;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import checker.data.ClassFactory;
import checker.data.ClipPlayer;

import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class OptionsScreenPanel extends JPanel {
	private Box verticalBox;
	private JLabel optionsTitleLabel;
	private JLabel soundMainVolumeLabel; 
	private JLabel soundMusicVolumeLabel; 
	private JSlider soundMainVolumeSlider;
	private JTextArea soundMainVolumeTextArea;
	private JSlider soundMusicVolumeSlider;
	private JTextArea soundMusicVolumeTextArea;
	private JCheckBox muteSoundCheckBox;
	private Box horizontalBox;
	private JButton previousButton;
	private JButton okButton;
	private JButton rulesButton;
	private Box horizontalBox_1;
	private Box horizontalBox_2;
	/**
	 * Create the panel.
	 */
	public OptionsScreenPanel() {
		initLayout();
		initActions();
	}
	
	public void initLayout() {
		verticalBox = Box.createVerticalBox();
		add(verticalBox);
		
		optionsTitleLabel = (JLabel) ClassFactory.createTextContainingComponent("JLabel", "Options");
		optionsTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 41));
		verticalBox.add(optionsTitleLabel);
		
		soundMainVolumeLabel = (JLabel) ClassFactory.createTextContainingComponent("JLabel", "Main Volume");
		verticalBox.add(soundMainVolumeLabel);
		
		horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		soundMainVolumeSlider = (JSlider) ClassFactory.createNoTextContainingComponent("JSlider");
		horizontalBox_1.add(soundMainVolumeSlider);
		
		soundMainVolumeTextArea = (JTextArea) ClassFactory.createNoTextContainingComponent("JTextArea");
		soundMainVolumeTextArea.setText(Integer.valueOf(soundMainVolumeSlider.getValue()).toString());
		horizontalBox_1.add(soundMainVolumeTextArea);
		
		soundMusicVolumeLabel = (JLabel) ClassFactory.createTextContainingComponent("JLabel", "Music Volume");
		verticalBox.add(soundMusicVolumeLabel);
		
		horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		soundMusicVolumeSlider = (JSlider) ClassFactory.createNoTextContainingComponent("JSlider");
		horizontalBox_2.add(soundMusicVolumeSlider);
		
		soundMusicVolumeTextArea = (JTextArea) ClassFactory.createNoTextContainingComponent("JTextArea");
		soundMusicVolumeTextArea.setText(Integer.valueOf(soundMusicVolumeSlider.getValue()).toString());
		horizontalBox_2.add(soundMusicVolumeTextArea);
		
		muteSoundCheckBox = (JCheckBox) ClassFactory.createTextContainingComponent("JCheckBox", "Mute");
		verticalBox.add(muteSoundCheckBox);
		
		horizontalBox = (Box) ClassFactory.createNoTextContainingComponent("HorizontalBox");
		verticalBox.add(horizontalBox);
		
		previousButton = (JButton) ClassFactory.createTextContainingComponent("JButton", "Previous");
		horizontalBox.add(previousButton);
		
		okButton = (JButton) ClassFactory.createTextContainingComponent("JButton", "OK");
		horizontalBox.add(okButton);
		
		rulesButton = (JButton) ClassFactory.createTextContainingComponent("JButton","Rules");
		horizontalBox.add(rulesButton);
	}
	
	public void initActions () {
		soundMainVolumeSlider.addChangeListener(new MainVolumeSliderValueListener());
		soundMusicVolumeSlider.addChangeListener(new MusicVolumeSliderValueListener());
		muteSoundCheckBox.addActionListener(new CheckBoxValueListener());
		okButton.addActionListener(new okAction());
		previousButton.addActionListener(new PreviousAction());
		rulesButton.addActionListener(new rulesAction());
	}
	
	private class rulesAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			PanelsContainer.getInstance().getCardLayout().last(PanelsContainer.getInstance());
		}
	}
	
	private class okAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			PanelsContainer.getInstance().getCardLayout().first(PanelsContainer.getInstance());
		}
	}
	
	private class PreviousAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			PanelsContainer.getInstance().getCardLayout().first(PanelsContainer.getInstance());
		}
	}
	
	private class MainVolumeSliderValueListener implements ChangeListener {
	    public void stateChanged(ChangeEvent e) {
	        if (soundMainVolumeSlider.getValueIsAdjusting()) {
	        	soundMainVolumeTextArea.setText(Integer.valueOf(soundMainVolumeSlider.getValue()).toString());
	        }    
	    }
	}
	
	private class MusicVolumeSliderValueListener implements ChangeListener {
	    public void stateChanged(ChangeEvent e) {
	        if (soundMusicVolumeSlider.getValueIsAdjusting()) {
	        	ClipPlayer.changeVolumeClip(soundMusicVolumeSlider.getValue());
	        	soundMusicVolumeTextArea.setText(Integer.valueOf(soundMusicVolumeSlider.getValue()).toString());
	        }    
	    }
	}
	
	private class CheckBoxValueListener implements ActionListener {
		
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		    if (muteSoundCheckBox.isSelected()) {
	        	soundMainVolumeTextArea.setEnabled(false);
	        	soundMainVolumeSlider.setEnabled(false);
	        	
	        	soundMusicVolumeTextArea.setEnabled(false);
	        	soundMusicVolumeSlider.setEnabled(false);
	        } else {
	        	soundMainVolumeTextArea.setEnabled(true);
	        	soundMainVolumeSlider.setEnabled(true);
	        	
	        	soundMusicVolumeTextArea.setEnabled(true);
	        	soundMusicVolumeSlider.setEnabled(true);
	        }
		}
	}

}
