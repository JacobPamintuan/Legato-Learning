package legatoLearning;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;

public class LoginGUI implements ActionListener, ItemListener {
	// Fields

	public JPanel loginPane;

	private JLabel error;
	private JTextField username;
	private JPasswordField password;

	private JCheckBox chckbxShowPassword;
	
	private JButton signUp;
	private JButton login;

	// Constructor - no parameters
	public LoginGUI() {
		initialize();
	}

	
	//Initialize the contents of the frame.
	private void initialize() {
		// JPanel setup
		loginPane = new JPanel();
		loginPane.setBounds(0, 0, 1440, 810);
		loginPane.setBackground(Colours.vDarkBlue);
		loginPane.setLayout(null);
		Frame.frame.getContentPane().add(loginPane);

		// Text field
		username = new JTextField();
		username.setBounds(841, 244, 354, 38);
		username.setBackground(Colours.vDarkBlue);
		username.setForeground(Color.WHITE);
		username.setCaretColor(Color.WHITE);
		username.setFont(Fonts.BODY);
		username.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		loginPane.add(username);

		// Password field
		password = new JPasswordField();
		password.setBounds(841, 356, 354, 38);
		password.setBackground(Colours.vDarkBlue);
		password.setForeground(Color.WHITE);
		password.setCaretColor(Color.WHITE);
		password.setFont(Fonts.BODY);
		password.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		loginPane.add(password);
		
		// Checkbox - Show/hide passwords
		chckbxShowPassword = new JCheckBox("Show Password");
		chckbxShowPassword.setForeground(Color.WHITE);
		chckbxShowPassword.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		chckbxShowPassword.setBounds(835, 400, 264, 23);
		chckbxShowPassword.addItemListener(this);
		loginPane.add(chckbxShowPassword);


		// JLabel - error message
		error = new JLabel("");
		error.setBounds(832, 425, 375, 38);
		error.setFont(Fonts.BODY);
		error.setForeground(Color.WHITE);
		error.setVerticalAlignment(SwingConstants.CENTER);
		error.setHorizontalAlignment(SwingConstants.CENTER);
		loginPane.add(error);

		// Main image - within JLabel
		JLabel loginImage = new JLabel();
		loginImage.setBounds(0, 0, 1440, 810);
		loginImage.setIcon(new ImageIcon("images/LoginScreen.png"));
		loginPane.add(loginImage);

		// JButtons
		login = new JButton();
		login.setBounds(832, 466, 375, 46);
		login.addActionListener(this);
		loginPane.add(login);

		signUp = new JButton();
		signUp.setBounds(832, 558, 375, 46);
		signUp.addActionListener(this);
		loginPane.add(signUp);

		loginPane.repaint();
	}
	
	// Event handlers
	@Override
	public void actionPerformed(ActionEvent e) {
		

		if (e.getSource() == login) { // Login attempt
			error.setText("");
			
			// Check for empty text fields and display appropriate message
			if (username.getText().isEmpty() || password.getText().isEmpty())
				error.setText("Empty fields");
			
			// Check if user exists
			else if (LoadUsers.checkUsername(username.getText().toLowerCase())) {
				
				// User exists - check if password matches
				if (LoadUsers.checkPassword(username.getText().toLowerCase(), password.getText())) {

					// Initialize user
					Initialize.user = new User(LoadUsers.loginSuccessful(username.getText().toLowerCase()));

					// Initialize save files associated with user
					try {
						Initialize.initializeFiles();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					// Remove text from text/password fields
					username.setText("");
					password.setText("");
					
					// Initialize program
					Initialize.initializeGUIS();
					loginPane.setVisible(false); // Hide current pane

				} else 
					error.setText("Password incorrect");
			
			} else // User nonexistent
				error.setText("Username does not exist");
			
		} else if (e.getSource() == signUp) { // Sign up instead

			// Remove text from text/password fields
			username.setText("");
			password.setText("");
			error.setText("");
			
			Initialize.signUp.signUpPane.setVisible(true);
			loginPane.setVisible(false);
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) // Checkbox clicked/selected
			// Show passwords (plain text)
			password.setEchoChar((char) 0);
		else
			// Hide passwords
			password.setEchoChar('●');

	}
	
}
