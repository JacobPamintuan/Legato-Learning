package legatoLearning;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.Font;

public class SignUpGUI implements ActionListener, ItemListener {

	// Fields

	public JPanel signUpPane;

	private JLabel error;

	private JTextField firstName;
	private JTextField lastName;
	private JTextField username;

	private JPasswordField password;
	private JPasswordField confirmPassword;

	private JCheckBox chckbxShowPassword;

	private JButton login;
	private JButton signUp;

	// Constructor, no parameters
	public SignUpGUI() {
		initialize();
	}

	// Initialize GUI
	private void initialize() {
		signUpPane = new JPanel(); // JPanel setup
		signUpPane.setBounds(0, 0, 1440, 810);
		signUpPane.setBackground(Colours.vDarkBlue);
		signUpPane.setLayout(null);
		Frame.frame.getContentPane().add(signUpPane);

		// Textfields
		firstName = new JTextField();
		firstName.setBounds(480, 269, 217, 32);
		firstName.setBackground(Colours.vDarkBlue);
		firstName.setForeground(Color.WHITE);
		firstName.setCaretColor(Color.WHITE);
		firstName.setFont(Fonts.BODY);
		firstName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		signUpPane.add(firstName);

		lastName = new JTextField();
		lastName.setBounds(744, 269, 212, 32);
		lastName.setBackground(Colours.vDarkBlue);
		lastName.setForeground(Color.WHITE);
		lastName.setCaretColor(Color.WHITE);
		lastName.setFont(Fonts.BODY);
		lastName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		signUpPane.add(lastName);

		username = new JTextField();
		username.setBounds(480, 364, 476, 32);
		username.setBackground(Colours.vDarkBlue);
		username.setForeground(Color.WHITE);
		username.setCaretColor(Color.WHITE);
		username.setFont(Fonts.BODY);
		username.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		signUpPane.add(username);

		// Password Fields
		password = new JPasswordField();
		password.setBounds(480, 459, 217, 32);
		password.setBackground(Colours.vDarkBlue);
		password.setForeground(Color.WHITE);
		password.setCaretColor(Color.WHITE);
		password.setFont(Fonts.BODY);
		password.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		signUpPane.add(password);

		confirmPassword = new JPasswordField();
		confirmPassword.setBounds(744, 459, 217, 32);
		confirmPassword.setBackground(Colours.vDarkBlue);
		confirmPassword.setForeground(Color.WHITE);
		confirmPassword.setCaretColor(Color.WHITE);
		confirmPassword.setFont(Fonts.BODY);
		confirmPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		signUpPane.add(confirmPassword);

		// Checkbox - Show/hide passwords
		chckbxShowPassword = new JCheckBox("Show Password");
		chckbxShowPassword.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		chckbxShowPassword.setForeground(Color.WHITE);
		chckbxShowPassword.addItemListener(this);
		chckbxShowPassword.setBounds(470, 501, 264, 23);
		signUpPane.add(chckbxShowPassword);

		// Error - JLabel
		error = new JLabel("");
		error.setBounds(470, 530, 499, 52);
		error.setHorizontalAlignment(SwingConstants.CENTER);
		error.setVerticalAlignment(SwingConstants.CENTER);
		error.setFont(Fonts.BODY);
		error.setForeground(Color.white);
		signUpPane.add(error);

		// Main image - within JLabel
		JLabel signUpImage = new JLabel();
		signUpImage.setIcon(new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Music Theory App/images/SignupScreen.png"));
//		signUpImage.setIcon(new ImageIcon("images/SignupScreen.png"));
		signUpImage.setBounds(0, 0, 1440, 810);
		signUpPane.add(signUpImage);

		// Buttons ("invisible" - behind image)
		signUp = new JButton("Sign Up");
		signUp.setBounds(532, 582, 375, 46);
		signUp.addActionListener(this);
		signUpPane.add(signUp);

		login = new JButton("Login instead");
		login.setBounds(532, 691, 375, 46);
		login.addActionListener(this);
		signUpPane.add(login);

		signUpPane.repaint();
	}
	
	// Helper method - returns boolean, whether or not the password and confirm
	// password are the same
	private boolean checkPasswords() {
		return password.getText().equals(confirmPassword.getText());
	}

	// Event Handlers
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login) { // Switch to login screen
			
			// Make text/password fields blank
			firstName.setText("");
			lastName.setText("");
			username.setText("");
			password.setText("");
			confirmPassword.setText("");
			error.setText("");

			Initialize.login.loginPane.setVisible(true);
			signUpPane.setVisible(false);

		} else if (e.getSource() == signUp) { // Sign-up attempt

			// Check if any fields are empty - display appropriate error message
			if (firstName.getText().isEmpty() || lastName.getText().isEmpty() || username.getText().isEmpty()
					|| password.getText().isEmpty() || confirmPassword.getText().isEmpty()) {
				error.setText("Please complete all fields");

			} else {

				// If username taken and passwords do not match
				if (LoadUsers.checkUsername(username.getText().toLowerCase()) && !checkPasswords())
					error.setText("Username already taken. Passwords do not match");

				// If only username taken
				else if (LoadUsers.checkUsername(username.getText().toLowerCase()))
					error.setText("Username already taken");

				// If only passwords do not match
				else if (!checkPasswords())
					error.setText("Passwords do not match");

				else { // Username valid, passwords match
					try {
						// Initialize the user
						Initialize.user = new User(LoadUsers.addUser(username.getText().toLowerCase(),
								password.getText(), firstName.getText(), lastName.getText()));

						// Create new save files (for each user)
						Initialize.user.getQuizSave().createNewFile();
						Initialize.user.getLessonSave().createNewFile();

						// Initialize files and GUI for rest of program
						Initialize.initializeFiles();
						Initialize.initializeGUIS();

						error.setText("Sign up successful"); // Display success

						signUpPane.setVisible(false); // Hide current pane

					} catch (Exception e1) {
					}
				}
			}
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) { // Checkbox clicked
			// Show passwords (plain text)
			password.setEchoChar((char) 0);
			confirmPassword.setEchoChar((char) 0);
		} else {
			// Hide passwords
			password.setEchoChar('●');
			confirmPassword.setEchoChar('●');
		}

	}

}
