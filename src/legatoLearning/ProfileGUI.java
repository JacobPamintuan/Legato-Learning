package legatoLearning;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ProfileGUI implements ActionListener{

	JPanel profilePane;

	private JTextField firstName;
	private JTextField lastName;

	private JPasswordField password;
	private JPasswordField confirmPassword;
	
	private JButton save;
	private JButton RESET;

	public ProfileGUI() {
		profilePane = new JPanel();
		profilePane.setBounds(300, 0, 1140, 810);
		profilePane.setBackground(Color.white);
		profilePane.setLayout(null);
		Frame.frame.getContentPane().add(profilePane);

		// Textfields
		firstName = new JTextField();
		firstName.setBounds(107, 257, 230, 45);
//		firstName.setBackground(Colours.vDarkBlue);
//		firstName.setForeground(Color.WHITE);
		firstName.setFont(Fonts.BODY);
		profilePane.add(firstName);

		lastName = new JTextField();
		lastName.setBounds(370, 257, 230, 45);
//		lastName.setBackground(Colours.vDarkBlue);
//		lastName.setForeground(Color.WHITE);
		lastName.setFont(Fonts.BODY);
		profilePane.add(lastName);

		// Password Fields
		password = new JPasswordField();
		password.setBounds(107, 352, 230, 45);
//		password.setBackground(Colours.vDarkBlue);
//		password.setForeground(Color.WHITE);
		password.setFont(Fonts.BODY);
		profilePane.add(password);

		confirmPassword = new JPasswordField();
		confirmPassword.setBounds(370, 352, 230, 45);
//		confirmPassword.setBackground(Colours.vDarkBlue);
//		confirmPassword.setForeground(Color.WHITE);
		confirmPassword.setFont(Fonts.BODY);
		profilePane.add(confirmPassword);
		
		save = new JButton("Save");
		save.setBounds(107, 412, 165, 45);
		profilePane.add(save);
		
		RESET = new JButton("reset");
		RESET.setBounds(107, 581, 165, 45);
		RESET.addActionListener(this);
		profilePane.add(RESET);

		JLabel lbl = new JLabel("Profile");
		lbl.setFont(Fonts.TITLE2);
		lbl.setBounds(64, 29, 247, 54);
		lbl.setForeground(Colours.purp);
		profilePane.add(lbl);

		JLabel profileImage = new JLabel();
		profileImage.setIcon(new ImageIcon("images/Profile 1.png"));
		profileImage.setVerticalAlignment(SwingConstants.TOP);
		profileImage.setBounds(66, 142, 580, 525);
		profilePane.add(profileImage);

		profilePane.repaint();
	}
	
	private int popupWarning() {
		Object[] ob = { "RESET", "CANCEL" };

		return JOptionPane.showOptionDialog(profilePane, "ARE YOU SURE YOU WANT TO RESET ALL PROGRESS?",
				"RESET ALL DATA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
				new ImageIcon("images/Legato Learning.png"), ob, null);

	}

	private void popupProceed() {
		JOptionPane.showMessageDialog(profilePane, "Please restart the program");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		
		if(b==RESET)
			if (popupWarning() == JOptionPane.YES_OPTION) {
				popupProceed();
				Initialize.lessonArr[0].DELETE_ALL_LESSONS();
				Initialize.quizArr[0].DELETE_ALL_QUIZZES();
				System.exit(0);
			}
	}

}
