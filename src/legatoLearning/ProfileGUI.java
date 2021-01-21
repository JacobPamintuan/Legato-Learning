package legatoLearning;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class ProfileGUI implements ActionListener, ItemListener {

	JPanel profilePane;

	JLabel profileImage;

	private JTextField firstName;
	private JTextField lastName;

	private JPasswordField oldPassword;
	private JPasswordField newPassword;
	private JPasswordField confirmPassword;

	JCheckBox chckbxShowPasswordOLD;
	JCheckBox chckbxShowPasswordNEW;

	public JLabel errorOrSuccess;

	private JButton save;
	private JButton RESET;

	public ProfileGUI() {

		profilePane = new JPanel();
		profilePane.setBounds(300, 0, 1140, 810);
		profilePane.setBackground(Color.white);
		profilePane.setLayout(null);
		Frame.frame.getContentPane().add(profilePane);

		JLabel lbl = new JLabel("Profile");
		lbl.setFont(Fonts.TITLE2);
		lbl.setBounds(64, 29, 247, 54);
		lbl.setForeground(Colours.purp);
		profilePane.add(lbl);

		// Textfields
		firstName = new JTextField();
		firstName.setBounds(99, 258, 230, 45);
		firstName.setFont(Fonts.BODY);
		profilePane.add(firstName);

		lastName = new JTextField();
		lastName.setBounds(365, 257, 230, 45);
		lastName.setFont(Fonts.BODY);
		profilePane.add(lastName);

		oldPassword = new JPasswordField();
		oldPassword.setBounds(99, 360, 491, 39);
		oldPassword.setFont(Fonts.BODY);
		profilePane.add(oldPassword);
		oldPassword.setColumns(10);

		chckbxShowPasswordOLD = new JCheckBox("Show password");
		chckbxShowPasswordOLD.setBounds(99, 400, 165, 23);
		chckbxShowPasswordOLD.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		chckbxShowPasswordOLD.addItemListener(this);
		profilePane.add(chckbxShowPasswordOLD);

		// Password Fields
		newPassword = new JPasswordField();
		newPassword.setBounds(99, 455, 230, 39);
		newPassword.setFont(Fonts.BODY);
		profilePane.add(newPassword);

		confirmPassword = new JPasswordField();
		confirmPassword.setBounds(365, 455, 230, 39);
		confirmPassword.setFont(Fonts.BODY);
		profilePane.add(confirmPassword);

		chckbxShowPasswordNEW = new JCheckBox("Show password");
		chckbxShowPasswordNEW.setBounds(99, 499, 165, 23);
		chckbxShowPasswordNEW.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		chckbxShowPasswordNEW.addItemListener(this);
		profilePane.add(chckbxShowPasswordNEW);

		errorOrSuccess = new JLabel();
		errorOrSuccess.setBounds(365, 539, 230, 32);
		errorOrSuccess.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		errorOrSuccess.setForeground(Colours.purp);
		profilePane.add(errorOrSuccess);

		profileImage = new JLabel();
//		profileImage
//				.setIcon(new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Music Theory App/images/Profile 1.png")); // DELETE
		profileImage.setIcon(new ImageIcon("images/Profile 1.png"));
		profileImage.setVerticalAlignment(SwingConstants.TOP);
		profileImage.setBounds(58, 142, 580, 662);
		profilePane.add(profileImage);

		save = new JButton("Save");
		save.setBounds(99, 534, 165, 45);
		save.addActionListener(this);
		profilePane.add(save);

		RESET = new JButton("reset");
		RESET.setBounds(99, 704, 165, 45);
		RESET.addActionListener(this);
		profilePane.add(RESET);

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
		System.out.print("ACTION:");
		JButton b = (JButton) e.getSource();

		if (b == RESET) {
			System.out.println(" reset");

			if (popupWarning() == JOptionPane.YES_OPTION) {

				popupProceed();

				Initialize.lessonArr[0].DELETE_ALL_LESSONS();
				Initialize.quizArr[0].DELETE_ALL_QUIZZES();

				System.exit(0);

			}
		} else if (b == save) {
			System.out.println(" save" + "");

			// If all fields are empty
			if (firstName.getText().isEmpty() && lastName.getText().isEmpty() && oldPassword.getText().isEmpty()
					&& newPassword.getText().isEmpty() && confirmPassword.getText().isEmpty())
				errorOrSuccess.setText("<html>Fill out at least one field to edit profile<html>");

			else {

				// If any password fields are not empty (if all are empty, do nothing)
				if (!(oldPassword.getText().isEmpty() && newPassword.getText().isEmpty()
						&& confirmPassword.getText().isEmpty())) {

					System.out.println("ASDF");
					// At least one password field is empty
					if (oldPassword.getText().isEmpty() || newPassword.getText().isEmpty()
							|| confirmPassword.getText().isEmpty()) {

						errorOrSuccess.setText("<html>To change password, fill out all password fields<html>");
						return;

						// Old password incorrect
					} else if (!oldPassword.getText().equals(Initialize.user.getPassword()))

						errorOrSuccess.setText("Password incorrect");

					// Old password correct
					else if (oldPassword.getText().equals(Initialize.user.getPassword())) {

						// Check if passwords match
						if (!checkPasswords())
							errorOrSuccess.setText("New passwords do not match");
						else
							Initialize.user.setPassword(newPassword.getText());
					}

				}
				
				if (!firstName.getText().isEmpty())
					Initialize.user.setFirstName(firstName.getText());

				if (!lastName.getText().isEmpty())
					Initialize.user.setLastName(lastName.getText());

				try {
					LoadUsers.userChange(Initialize.user.getUsername());
					errorOrSuccess.setText("Profile updated");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			Initialize.home.newName();
			
			firstName.setText("");
			lastName.setText("");
			oldPassword.setText("");
			newPassword.setText("");
			confirmPassword.setText("");

			}
		}

	}

	// Determine if passwords match
	private boolean checkPasswords() {
		return newPassword.getText().equals(confirmPassword.getText());
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getItem().equals(chckbxShowPasswordOLD)) { // Old password

			if (e.getStateChange() == ItemEvent.SELECTED) // Checkbox clicked/selected
				// Show passwords (plain text)
				oldPassword.setEchoChar((char) 0);

			else
				// Hide passwords
				oldPassword.setEchoChar('●');

		} else { // New Password

			if (e.getStateChange() == ItemEvent.SELECTED) { // Checkbox clicked
				// Show passwords (plain text)
				newPassword.setEchoChar((char) 0);
				confirmPassword.setEchoChar((char) 0);

			} else {
				// Hide passwords
				newPassword.setEchoChar('●');
				confirmPassword.setEchoChar('●');
			}
		}

	}
}
