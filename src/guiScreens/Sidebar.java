package guiScreens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sidebar implements MouseListener {

	JPanel sidePane;
	JLabel logo;
	JLabel lblHome;
	private JLabel lblProfile;
	private JLabel lblChallengeBank;
	private JLabel lblSettings;

	private final Font BOLD = new Font("Helvetica Neue", Font.BOLD, 20);
	private final Font PLAIN = new Font("Helvetica Neue", Font.PLAIN, 20);
	
	
	public Sidebar() {
		sidePane = new JPanel();
		sidePane.setBounds(0, 0, 300, 810);
		sidePane.setBackground(Color.LIGHT_GRAY);
		sidePane.setLayout(null);
		Frame.frame.getContentPane().add(sidePane);

		logo = new JLabel(new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Music Theory App/images/Legato.png"));
		logo.setBounds(0, 0, 300, 100);
		sidePane.add(logo);

		lblHome = new JLabel("Home");
		lblHome.addMouseListener(this);
		lblHome.setFont(PLAIN);
		lblHome.setBounds(15, 110, 285, 50);
		sidePane.add(lblHome);

		lblProfile = new JLabel("Profile");
		lblProfile.addMouseListener(this);
		lblProfile.setFont(PLAIN);
		lblProfile.setBounds(15, 172, 285, 50);
		sidePane.add(lblProfile);

		lblChallengeBank = new JLabel("Challenge Bank");
		lblChallengeBank.addMouseListener(this);
		lblChallengeBank.setFont(PLAIN);
		lblChallengeBank.setBounds(15, 234, 285, 50);
		sidePane.add(lblChallengeBank);

		lblSettings = new JLabel("Settings");
		lblSettings.addMouseListener(this);
		lblSettings.setFont(PLAIN);
		lblSettings.setBounds(15, 296, 285, 50);
		sidePane.add(lblSettings);

		sidePane.repaint();

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		System.out.println(((JLabel) e.getSource()).getText());
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		((JLabel) e.getSource()).setFont(BOLD);

	}

	@Override
	public void mouseExited(MouseEvent e) {

		((JLabel) e.getSource()).setFont(PLAIN);

	}

}
