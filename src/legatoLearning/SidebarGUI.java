package legatoLearning;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SidebarGUI implements MouseListener {

	JPanel sidePane;
	JLabel logo;
	public JLabel lblHome;
	private JLabel lblProfile;
	private JLabel lblChallengeBank;
	private JLabel lblSettings;

	private JLabel isClicked;

	private JLabel temp;
	private String imgName;

//	private final Font BOLD = new Font("Helvetica Neue", Font.BOLD, 20);
//	private final Font PLAIN = new Font("Helvetica Neue", Font.PLAIN, 20);

	public SidebarGUI() {
		sidePane = new JPanel();
		sidePane.setBounds(0, 0, 300, 810);
		sidePane.setBackground(Colours.vDarkBlue);
		sidePane.setLayout(null);
		Frame.frame.getContentPane().add(sidePane);

		logo = new JLabel();
		logo.setIcon(new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Music Theory App/images/Legato Learning.png"));
//		logo = new JLabel(new ImageIcon("images/Legato Learning.png"));
		logo.addMouseListener(this);
		logo.setBounds(21, 21, 252, 82);
		sidePane.add(logo);

		lblHome = new JLabel("Home");
		// lblHome.setIcon(new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Music
		// Theory App/images/Home Dark.png"));
		lblHome.setIcon(new ImageIcon("images/Home Light.png")); //asdf asdf
		isClicked = lblHome;
		lblHome.addMouseListener(this);
//		lblHome.setFont(PLAIN);
		lblHome.setBounds(0, 120, 300, 54);
		sidePane.add(lblHome);

		lblProfile = new JLabel("Profile");
		lblProfile.setIcon(
				new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Music Theory App/images/Profile Dark.png"));
//		lblProfile.setIcon(new ImageIcon("images/Profile Dark.png"));
		lblProfile.addMouseListener(this);
//		lblProfile.setFont(PLAIN);
		lblProfile.setBounds(0, 174, 300, 54);
		sidePane.add(lblProfile);

		lblChallengeBank = new JLabel("Challenge Bank");
		lblChallengeBank.setIcon(
				new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Music Theory App/images/Challenge Bank Dark.png"));
//		lblChallengeBank.setIcon(new ImageIcon("images/Challenge Bank Dark.png"));
		lblChallengeBank.addMouseListener(this);
//		lblChallengeBank.setFont(PLAIN);
		lblChallengeBank.setBounds(0, 228, 300, 54);
		sidePane.add(lblChallengeBank);

		lblSettings = new JLabel("Settings");
		lblSettings.setIcon(
				new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Music Theory App/images/Settings Dark.png"));
//		lblSettings.setIcon(new ImageIcon("images/Settings Dark.png"));
		lblSettings.addMouseListener(this);
//		lblSettings.setFont(PLAIN);
		lblSettings.setBounds(0, 282, 300, 54);
		sidePane.add(lblSettings);

//		lblHome.setBackground(Color.red);
//		lblProfile.setBackground(Color.red);
//		lblChallengeBank.setBackground(Color.red);
//		lblSettings.setBackground(Color.red);

		sidePane.repaint();

	}

	public void setDark() {

		lblHome.setIcon(new ImageIcon("images/Home Dark.png"));
		lblProfile.setIcon(new ImageIcon("images/Profile Dark.png"));
		lblChallengeBank.setIcon(new ImageIcon("images/Challenge Bank Dark.png"));
		lblSettings.setIcon(new ImageIcon("images/Settings Dark.png"));

	}

	private void setInvisible() {
		Initialize.home.homePane.setVisible(false);
		Initialize.profile.profilePane.setVisible(false);
		Initialize.challengeBank.challengePane.setVisible(false);
		Initialize.settings.settingsPane.setVisible(false);
		
		
		for (int i = 0; i < Initialize.quizArr.length; i++) {
			Initialize.quizGUI[i].QuizPane.setVisible(false);
		}
		
		for (int i = 0; i < Initialize.lessonArr.length; i++) {
			Initialize.	lessonGUI[i].LessonTempPane.setVisible(false);
		}
		
		Initialize.iCourse.iCoursePane.setVisible(false);
		
		
//		Initialize.quiz.QuizPane.setVisible(false);
		//System.gc();

	}

	@Override
	public void mouseClicked(MouseEvent e) { // MouseListener makes JLabel act as a button
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		temp = (JLabel) e.getSource(); // Downcasting MouseEvent e to JLabel

		if (temp == logo)
			temp = lblHome;
		//if (isClicked != temp) {
			setDark(); // Sets all sidebar items to dark

			imgName = temp.getText();

			temp.setIcon(new ImageIcon("images/" + imgName + " Light.png"));

			setInvisible();
			if (temp == lblHome) {

				Initialize.home.homePane.setVisible(true);


			} else if (temp == lblProfile) {
				Initialize.profile.profilePane.setVisible(true);
			} else if (temp == lblChallengeBank) {

				Initialize.challengeBank.challengePane.setVisible(true);

			} else if (temp == lblSettings) {
				Initialize.settings.settingsPane.setVisible(true);

			}
			isClicked = temp;
		//}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		temp = (JLabel) e.getSource();
		if (temp != logo) {
			imgName = temp.getText();

			if (temp != isClicked) {
				temp.setIcon(new ImageIcon("images/" + imgName + " Light.png"));
			}
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {

		temp = (JLabel) e.getSource();
		if (temp != logo) {
			imgName = temp.getText();

			if (temp != isClicked) {

				temp.setIcon(new ImageIcon("images/" + imgName + " Dark.png"));

			}
		}

	}

}
