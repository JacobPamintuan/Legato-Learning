package legatoLearning;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginGUI implements ActionListener {

	public JPanel loginPane;

	private JLabel lblUser, lblPass;
	private JLabel error;
	private JTextField username;
	private JPasswordField password;

	private JButton signUP, login;

	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginPane = new JPanel();
		loginPane.setBounds(0, 0, 1440, 810);
		loginPane.setBackground(Color.white);
		loginPane.setLayout(null);
		Frame.frame.getContentPane().add(loginPane);

		username = new JTextField("Username");
		username.setBounds(100, 100, 100, 20);
		loginPane.add(username);

		password = new JPasswordField("Password");
		password.setBounds(100, 130, 100, 20);
		loginPane.add(password);

		login = new JButton("Login");
		login.setBounds(160, 160, 40, 20);
		login.addActionListener(this);
		loginPane.add(login);

		signUP = new JButton("Sign Up");
		signUP.setBounds(100, 160, 40, 20);
		signUP.addActionListener(this);
		loginPane.add(signUP);

		error = new JLabel("");
		error.setBounds(100, 210, 400, 20);
		loginPane.add(error);
		
		JLabel loginp = new JLabel("Login screen");
		loginp.setBounds(500, 200, 500, 500);
		loginPane.add(loginp);

		loginPane.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login) {
			if (username.getText().isEmpty() || password.getText().isEmpty())
				error.setText("Empty fields");//System.out.println("Empty fields");
			else if (LoadUsers.checkUsername(username.getText())) {
				if (LoadUsers.checkPassword(username.getText(), password.getText())) {
					error.setText("Login successful");//System.out.println("Login successful");
				} else
					error.setText("Password incorrect");//System.out.println("Password incorrect");
			} else
				error.setText("Username does not exist");//System.out.println("Username does not exist");
		} else if (e.getSource() == signUP) {
			Initialize.signUp.signUpPane.setVisible(true);
			loginPane.setVisible(false);
			System.out.println("Sign Up");
		}

	}

}
