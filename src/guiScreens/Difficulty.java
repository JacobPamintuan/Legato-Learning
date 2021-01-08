package guiScreens;

import javax.swing.*;

public class Difficulty extends JPanel {

	public JPanel difficultyPanel;

	public Difficulty() {
		difficultyPanel = new JPanel();
		difficultyPanel.setBounds(250, 100, 1190, 710);
		difficultyPanel.setLayout(null);
	//	Frame.frame.getContentPane().add(difficultyPanel);

		JLabel b = new JLabel("asdf");
		b.setBounds(0, 0, 1190, 710);
		difficultyPanel.add(b);
	}

}
