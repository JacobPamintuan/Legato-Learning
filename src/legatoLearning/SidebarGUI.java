package legatoLearning;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Sidebar GUI
 * Allows user to navigate through the GUI
 * Allows access to Home page, Results Page, and Profile page
 * Logout button on very bottom
 * Logo also acts as a link to home page
 * Loaded along side home page when user logs in / signs up
 * Is always visible after log in / sign up
 */

public class SidebarGUI implements MouseListener {

	// Fields

	JPanel sidePane;
	JLabel logo;
	public JLabel lblHome;
	private JLabel lblProfile;
	private JLabel lblResults;

	private JLabel lblLogout;
	private JLabel logoutIcon;

	public JLabel isClicked;

	private JLabel temp;
	private String imgName;

	// Initializing GUI
	public SidebarGUI() {
		sidePane = new JPanel();
		sidePane.setBounds(0, 0, 300, 810);
		sidePane.setBackground(Colours.vDarkBlue);
		sidePane.setLayout(null);
		Frame.frame.getContentPane().add(sidePane);

		logo = new JLabel();
		logo.setIcon(new ImageIcon("images/Legato Learning.png"));
		logo.addMouseListener(this);
		logo.setBounds(21, 21, 252, 82);
		sidePane.add(logo);

		lblHome = new JLabel("Home");
		lblHome.setIcon(new ImageIcon("images/Home Light.png"));
		isClicked = lblHome;
		lblHome.addMouseListener(this);
		lblHome.setBounds(0, 120, 300, 54);
		sidePane.add(lblHome);

		lblResults = new JLabel("Results");
		lblResults.setIcon(new ImageIcon("images/Results Dark.png"));
		lblResults.addMouseListener(this);
		lblResults.setBounds(0, 174, 300, 54);
		sidePane.add(lblResults);

		lblProfile = new JLabel("Profile");
		lblProfile.setIcon(new ImageIcon("images/Profile Dark.png"));
		lblProfile.addMouseListener(this);
		lblProfile.setBounds(0, 228, 300, 54);
		sidePane.add(lblProfile);

		lblLogout = new JLabel("Logout");
		lblLogout.addMouseListener(this);
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setFont(Fonts.BODY);
		lblLogout.setBounds(69, 745, 100, 32);
		sidePane.add(lblLogout);

		logoutIcon = new JLabel();
		logoutIcon.addMouseListener(this);
		logoutIcon.setIcon(new ImageIcon("images/Logout Icon.png"));
		logoutIcon.setBounds(21, 746, 42, 30);
		sidePane.add(logoutIcon);

		sidePane.repaint();

	}

	// Sets all side bar labels to dark mode
	public void setDark() {

		lblHome.setIcon(new ImageIcon("images/Home Dark.png"));
		lblProfile.setIcon(new ImageIcon("images/Profile Dark.png"));
		lblResults.setIcon(new ImageIcon("images/Results Dark.png"));

	}

	// Sets all JPanels in the program to invisible
	public void setInvisible() {
		Initialize.home.homePane.setVisible(false);
		Initialize.profile.profilePane.setVisible(false);
		Initialize.results.resultsPane.setVisible(false);

		// All original quiz panes
		for (int i = 0; i < Initialize.quizArr.length; i++) {
			Initialize.quizGUI[i].QuizPane.setVisible(false);
		}

		// If they are in the middle of a redo quiz
		// Try catch used to avoid Null Pointer Exception
		try {
			Initialize.iCourse.current.QuizPane.setVisible(false);
		} catch (Exception e) {
		}

		// All lesson panes
		for (int i = 0; i < Initialize.lessonArr.length; i++) {
			Initialize.lessonGUI[i].LessonTempPane.setVisible(false);
		}

		Initialize.iCourse.iCoursePane.setVisible(false);

	}

	// Event handlers

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) { // MouseListener makes JLabel act as a button
		temp = (JLabel) e.getSource(); // Downcasting MouseEvent e to JLabel

		if (temp == logo)
			temp = lblHome;

		setDark(); // Sets all sidebar items to dark

		imgName = temp.getText();

		if(temp!=lblLogout&&temp!=logoutIcon)
			temp.setIcon(new ImageIcon("images/" + imgName + " Light.png")); // Set pressed Label to light mode

		setInvisible(); // Set all other panels invisible

		// Sets specified panel visible
		if (temp == lblHome) {
			Initialize.home.homePane.setVisible(true);
		} else if (temp == lblProfile) {
			Initialize.profile.profilePane.setVisible(true);
			Initialize.profile.errorOrSuccess.setText("");
		} else if (temp == lblResults) {
			Initialize.results.resultsPane.setVisible(true);
		}
		
		else if(temp==lblLogout||temp==logoutIcon) {
			Initialize.login.loginPane.setVisible(true);
			sidePane.setVisible(false);
		}
			
			

		// Set isClicked to the current button
		// (So that it will not change color with mouseEntered/Exit)
		isClicked = temp;

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		// Hover state - when mouse enters the JLabel, change it to light mode
		temp = (JLabel) e.getSource();

		temp.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		if (temp == lblLogout || temp == logoutIcon) {
			lblLogout.setText("<html><u>Logout<u><html>");
			lblLogout.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
			
		} else if (temp != logo) {
			imgName = temp.getText();

			if (temp != isClicked) { // Unless the JLabel has already been clicked
				temp.setIcon(new ImageIcon("images/" + imgName + " Light.png"));
			}
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {

		// Hover state - when mouse exits JLabel, change it back to dark
		temp = (JLabel) e.getSource();

		temp.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

		if (temp == lblLogout || temp == logoutIcon) {
			lblLogout.setText("Logout");
			lblLogout.setFont(Fonts.BODY);
		} else if (temp != logo) {
			imgName = temp.getText();

			if (temp != isClicked) { // Unless the JLabel has already been clicked
				temp.setIcon(new ImageIcon("images/" + imgName + " Dark.png"));

			}
		}

	}

}
