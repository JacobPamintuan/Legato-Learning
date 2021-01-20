package legatoLearning;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUpGUI implements ActionListener {

	public JPanel signUpPane;

	private JLabel fName, lblUser, lblPass;
	private JLabel error;
	private JTextField tName, username;
	private JPasswordField password, confirmPassword;

	JButton login, signUp;

	public SignUpGUI() {
		signUpPane = new JPanel();
		signUpPane.setBounds(0, 0, 1440, 810);
		signUpPane.setBackground(Color.white);
		signUpPane.setLayout(null);
		Frame.frame.getContentPane().add(signUpPane);

		tName = new JTextField("tFName");
		tName.setBounds(100, 370, 100, 20);
		signUpPane.add(tName);

		username = new JTextField("Username");
		username.setBounds(100, 400, 100, 20);
		signUpPane.add(username);

		password = new JPasswordField("Password");
		password.setBounds(100, 430, 100, 20);
		signUpPane.add(password);

		login = new JButton("Login instead");
		login.setBounds(160, 460, 40, 20);
		login.addActionListener(this);
		signUpPane.add(login);

		signUp = new JButton("Sign Up");
		signUp.setBounds(100, 460, 40, 20);
		signUp.addActionListener(this);
		signUpPane.add(signUp);

		error = new JLabel("");
		error.setBounds(100, 510, 400, 20);
		signUpPane.add(error);

		JLabel loginp = new JLabel("SignUp screen");
		loginp.setBounds(500, 200, 500, 500);
		signUpPane.add(loginp);

		signUpPane.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login) {
			Initialize.login.loginPane.setVisible(true);
			signUpPane.setVisible(false);
			System.out.println("Login");
		} else if (e.getSource() == signUp) {
			if (tName.getText().isEmpty() || username.getText().isEmpty() || password.getText().isEmpty()) {
				// || confirmPassword.getText().isEmpty()) {
				error.setText("Empty Fields");
			} else {
				if (!LoadUsers.checkUsername(username.getText().toLowerCase())) {
					try {
						Initialize.user = new User(LoadUsers.addUser(username.getText().toLowerCase(),
								password.getText(), tName.getText()));

						Initialize.user.getQuizSave().createNewFile();
						Initialize.user.getLessonSave().createNewFile();
						
						Initialize.initializeFiles();
						Initialize.initializeGUIS();
						
						System.out.println("Sign up successful");
						
						signUpPane.setVisible(false);

					} catch (Exception e1) {
					}
				} else
					error.setText("user already exists");

			}
		}

	}

}
