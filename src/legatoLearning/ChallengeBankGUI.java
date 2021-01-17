package legatoLearning;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class ChallengeBankGUI {

	JPanel challengePane;
	
	public static boolean isIntervals;
	public static boolean isCourse2;
	
	
	
	public ChallengeBankGUI() {
		challengePane = new JPanel();
		challengePane.setBounds(300, 0, 1140, 810);
		challengePane.setBackground(Color.white);
		challengePane.setLayout(null);
		Frame.frame.getContentPane().add(challengePane);
		
		JLabel lbl = new JLabel("Challenge bank");
		lbl.setBounds(300, 300, 300, 300);
		challengePane.add(lbl);
		
		challengePane.repaint();
	}

}
