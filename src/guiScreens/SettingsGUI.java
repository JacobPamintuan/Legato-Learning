package guiScreens;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingsGUI {

	JPanel settingsPane;

	public SettingsGUI() {
		settingsPane = new JPanel();
		settingsPane.setBounds(300, 0, 1140, 810);
		settingsPane.setBackground(Color.white);
		settingsPane.setLayout(null);
		Frame.frame.getContentPane().add(settingsPane);

		JLabel lbl = new JLabel("settings"
				+ "");
		lbl.setBounds(300, 300, 300, 300);
		settingsPane.add(lbl);

		settingsPane.repaint();
	}

}
