package legatoLearning;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProfileGUI {
	
	JPanel profilePane;

	public ProfileGUI() {
		profilePane = new JPanel();
		profilePane.setBounds(300, 0, 1140, 810);
		profilePane.setBackground(Color.white);
		profilePane.setLayout(null);
		Frame.frame.getContentPane().add(profilePane);
		
		JLabel lbl = new JLabel("Profile");
		lbl.setBounds(300, 300, 300, 300);
		profilePane.add(lbl);
		
		profilePane.repaint();
	}

}
