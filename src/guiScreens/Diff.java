package guiScreens;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;

public class Diff implements MouseListener {

	private JFrame frame;
	JPanel sidePane;
	JLabel logo;
	JLabel lblHome;
	private JLabel lblProfile;
	private JLabel lblChallengeBank;
	private JLabel lblSettings;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Diff window = new Diff();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Diff() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1440, 810);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		sidePane = new JPanel();
		sidePane.setBounds(0, 0, 300, 810);
		sidePane.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(sidePane);
		sidePane.setLayout(null);

		logo = new JLabel(new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Music Theory App/images/Legato.png"));
		logo.setBounds(0, 0, 300, 100);
		sidePane.add(logo);

		lblHome = new JLabel("Home");
		lblHome.addMouseListener(this);
		lblHome.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		lblHome.setBounds(15, 110, 285, 50);
		sidePane.add(lblHome);

		lblProfile = new JLabel("Profile");
		lblProfile.addMouseListener(this);
		lblProfile.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		lblProfile.setBounds(15, 172, 285, 50);
		sidePane.add(lblProfile);

		lblChallengeBank = new JLabel("Challenge Bank");
		lblChallengeBank.addMouseListener(this);
		lblChallengeBank.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		lblChallengeBank.setBounds(15, 234, 285, 50);
		sidePane.add(lblChallengeBank);

		lblSettings = new JLabel("Settings");
		lblSettings.addMouseListener(this);
		lblSettings.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		lblSettings.setBounds(15, 296, 285, 50);
		sidePane.add(lblSettings);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(300, 0, 1140, 810);
		frame.getContentPane().add(panel);
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

		((JLabel) e.getSource()).setFont(new Font("Helvetica Neue", Font.BOLD, 20));

	}

	@Override
	public void mouseExited(MouseEvent e) {
	
		((JLabel) e.getSource()).setFont(new Font("Helvetica Neue", Font.PLAIN, 20));

	}
}
