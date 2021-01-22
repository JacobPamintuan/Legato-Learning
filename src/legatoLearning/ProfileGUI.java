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
	
	// Fields

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

	// Initialize GUI
	public ProfileGUI() {

		// JPanel setup
		profilePane = new JPanel();
		profilePane.setBounds(300, 0, 1140, 810);
		profilePane.setBackground(Color.white);
		profilePane.setLayout(null);
		Frame.frame.getContentPane().add(profilePane);

		JLabel lbl = new JLabel("Profile");
		lbl.setFont(Fonts.TITLE2);
		lbl.setBounds(64, 29, 247, 54);
		lbl.setForeground(Colours.purple);
		profilePane.add(lbl);

		// Textfields
		firstName = new JTextField();
		firstName.setText(Initialize.user.getFirstName());
		firstName.setBounds(99, 258, 230, 45);
		firstName.setFont(Fonts.BODY);
		profilePane.add(firstName);

		lastName = new JTextField();
		lastName.setText(Initialize.user.getLastName());
		lastName.setBounds(365, 257, 230, 45);
		lastName.setFont(Fonts.BODY);
		profilePane.add(lastName);

		// PasswordFields and checkboxes
		
		// PasswordField
		oldPassword = new JPasswordField();
		oldPassword.setBounds(99, 360, 491, 39);
		oldPassword.setFont(Fonts.BODY);
		profilePane.add(oldPassword);
		oldPassword.setColumns(10);

		// Checkbox - Shows/hides old password ONLY
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

		// Checkbox - shows/hides BOTH new and confirm password
		chckbxShowPasswordNEW = new JCheckBox("Show password");
		chckbxShowPasswordNEW.setBounds(99, 499, 165, 23);
		chckbxShowPasswordNEW.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		chckbxShowPasswordNEW.addItemListener(this);
		profilePane.add(chckbxShowPasswordNEW);

		
		// Error - JLabel
		errorOrSuccess = new JLabel();
		errorOrSuccess.setBounds(365, 539, 230, 32);
		errorOrSuccess.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		errorOrSuccess.setForeground(Colours.purple);
		profilePane.add(errorOrSuccess);


		// JLabel bg image
		profileImage = new JLabel();
		profileImage.setIcon(new ImageIcon("images/Profile 1.png"));
		profileImage.setVerticalAlignment(SwingConstants.TOP);
		profileImage.setBounds(58, 142, 580, 662);
		profilePane.add(profileImage);

		// Save button (behind image)
		save = new JButton("Save");
		save.setBounds(99, 534, 165, 45);
		save.addActionListener(this);
		profilePane.add(save);

		// RESET button (behind image)
		RESET = new JButton("reset");
		RESET.setBounds(99, 704, 165, 45);
		RESET.addActionListener(this);
		profilePane.add(RESET);

		profilePane.repaint();

	}

	// Helper methods
	
	// Reset warning
	private int popupWarning() {

		Object[] ob = { "RESET", "CANCEL" };

		return JOptionPane.showOptionDialog(profilePane, "ARE YOU SURE YOU WANT TO RESET ALL PROGRESS?",
				"RESET ALL DATA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
				new ImageIcon("images/Legato Learning.png"), ob, null);

	}

	// Reset message - logout
	private void popupProceed() {

		JOptionPane.showMessageDialog(profilePane, "Please log out to reset all progress");

	}
	

	// Determine if passwords match
	private boolean checkPasswords() {
		return newPassword.getText().equals(confirmPassword.getText());
	}
	
	// Event Handlers

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();

		if (b == RESET) {

			// If user chooses to reset on popup
			if (popupWarning() == JOptionPane.YES_OPTION) { 

				// Display confirmation - logout
				popupProceed();

				// Delete data
				Initialize.lessonArr[0].DELETE_ALL_LESSONS();
				Initialize.quizArr[0].DELETE_ALL_QUIZZES();

				// Back to login page
				Initialize.login.loginPane.setVisible(true);
				Initialize.sidebar.sidePane.setVisible(false);
				Initialize.sidebar.setInvisible();
				
			}
		} else if (b == save) {

			// If all fields are empty  - Appropriate error message
			if (firstName.getText().isEmpty() && lastName.getText().isEmpty() && oldPassword.getText().isEmpty()
					&& newPassword.getText().isEmpty() && confirmPassword.getText().isEmpty())
				
				errorOrSuccess.setText("<html>Fill out at least one field to edit profile<html>");

		
			else {

				// If any password fields are not empty (if all password fields empty, do nothing)
				if (!(oldPassword.getText().isEmpty() && newPassword.getText().isEmpty()
						&& confirmPassword.getText().isEmpty())) {

					// At least one password field is empty - Appropriate error message
					if (oldPassword.getText().isEmpty() || newPassword.getText().isEmpty()
							|| confirmPassword.getText().isEmpty()) {

						errorOrSuccess.setText("<html>To change password, fill out all password fields<html>");
						return;

						// Old password incorrect  - Appropriate error message
					} else if (!oldPassword.getText().equals(Initialize.user.getPassword()))

						errorOrSuccess.setText("Password incorrect");

					// Old password correct
					else if (oldPassword.getText().equals(Initialize.user.getPassword())) {

						// Check if passwords match - Appropriate error message
						if (!checkPasswords())
							errorOrSuccess.setText("New passwords do not match");
						else
							Initialize.user.setPassword(newPassword.getText());
					}

				}
				
				// User changing first name
				if (!firstName.getText().isEmpty())
					Initialize.user.setFirstName(firstName.getText());

				// User changing last name
				if (!lastName.getText().isEmpty())
					Initialize.user.setLastName(lastName.getText());

				// Update user within Initialize
				// Update users file
				// Success message
				try {
				
					LoadUsers.userChange(Initialize.user.getUsername());
					
					errorOrSuccess.setText("Profile updated");
				
				} catch (IOException e1) {
				
					e1.printStackTrace();
					
				}
			
			// Change name on home screen
			Initialize.home.newName();
			
			// Set new names
			firstName.setText(Initialize.user.getFirstName());
			lastName.setText(Initialize.user.getLastName());

			// Remove text from password fields
			oldPassword.setText("");
			newPassword.setText("");
			confirmPassword.setText("");

			}
		}

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
