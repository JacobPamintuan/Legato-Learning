package main;

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
import javax.swing.UIManager;

public class Diff implements MouseListener {

	private JFrame frame;
	JPanel sidePane;
	JLabel logo;
	JLabel lblHome;
	private JLabel lblProfile;
	private JLabel lblChallengeBank;
	private JLabel lblSettings;

	private JLabel isClicked;

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
		// sidePane.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(sidePane);
		sidePane.setLayout(null);

		logo = new JLabel(new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Music Theory App/images/Legato.png"));
		logo.setBounds(0, 0, 300, 100);
		sidePane.add(logo);

		lblHome = new JLabel("  Home");
		lblHome.setBackground(Color.red);
		lblHome.setOpaque(true);
		lblHome.addMouseListener(this);
		lblHome.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		lblHome.setBounds(0, 110, 300, 50);
		sidePane.add(lblHome);

		lblProfile = new JLabel("  Profile");
		lblProfile.setBackground(Color.red);
		lblProfile.setOpaque(true);
		lblProfile.addMouseListener(this);
		lblProfile.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		lblProfile.setBounds(0, 172, 300, 50);
		sidePane.add(lblProfile);

		lblChallengeBank = new JLabel("  Challenge Bank");
		lblChallengeBank.setBackground(Color.red);
		lblChallengeBank.setOpaque(true);
		lblChallengeBank.addMouseListener(this);
		lblChallengeBank.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		lblChallengeBank.setBounds(0, 234, 300, 50);
		sidePane.add(lblChallengeBank);

		lblSettings = new JLabel("  Settings");
		lblSettings.setBackground(Color.red);
		lblSettings.setOpaque(true);
		lblSettings.addMouseListener(this);
		lblSettings.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		lblSettings.setBounds(0, 296, 300, 50);
		sidePane.add(lblSettings);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(300, 0, 1140, 810);
		frame.getContentPane().add(panel);
	}

	private void setAll() {
		lblHome.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		lblProfile.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		lblChallengeBank.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		lblSettings.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		
		lblHome.setBackground(Color.red);
		lblProfile.setBackground(Color.red);
		lblChallengeBank.setBackground(Color.red);
		lblSettings.setBackground(Color.red);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {

		// if(e.getSource()==lblHome)

//		System.out.println(((JLabel) e.getSource()).getText());
		
		setAll();
		
		((JLabel) e.getSource()).setBackground(Color.white);
		((JLabel) e.getSource()).setFont(new Font("Helvetica Neue", Font.PLAIN, 20));

		isClicked = (JLabel) e.getSource();
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		if (e.getSource() != isClicked) {
			((JLabel) e.getSource()).setFont(new Font("Helvetica Neue", Font.BOLD, 20));
			((JLabel) e.getSource()).setBackground(Color.yellow);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {

		if (e.getSource() != isClicked) {
			((JLabel) e.getSource()).setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
			((JLabel) e.getSource()).setBackground(Color.red);
//			
//			((JLabel) e.getSource()).setBackground(Color.white);
//			((JLabel) e.getSource()).setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		}

	}
}
