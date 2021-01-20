package legatoLearning;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SettingsGUI implements ActionListener {

	JPanel settingsPane;

	JOptionPane warning;
	JButton btnReset;

	public SettingsGUI() {
		settingsPane = new JPanel();
		settingsPane.setBounds(300, 0, 1140, 810);
		settingsPane.setBackground(Color.white);
		settingsPane.setLayout(null);
		Frame.frame.getContentPane().add(settingsPane);

		JLabel lbl = new JLabel("settings");
		lbl.setBounds(300, 300, 300, 300);
		settingsPane.add(lbl);

		btnReset = new JButton("RESET");
		btnReset.setBounds(244, 147, 117, 29);
		btnReset.addActionListener(this);
		settingsPane.add(btnReset);

		settingsPane.repaint();
	}

	private int popupWarning() {
		Object[] ob = { "RESET", "CANCEL" };

		return JOptionPane.showOptionDialog(settingsPane, "ARE YOU SURE YOU WANT TO RESET ALL PROGRESS?",
				"RESET ALL DATA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
				new ImageIcon("images/Legato Learning.png"), ob, null);

	}

	private void popupProceed() {
		JOptionPane.showMessageDialog(settingsPane, "Please restart the program");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReset)
			if (popupWarning() == JOptionPane.YES_OPTION) {
				popupProceed();
				Initialize.lessonArr[0].DELETE_ALL_LESSONS();
				Initialize.quizArr[0].DELETE_ALL_QUIZZES();
				System.exit(0);
			}

	}

}
