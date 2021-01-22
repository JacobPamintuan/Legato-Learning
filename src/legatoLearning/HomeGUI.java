package legatoLearning;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HomeGUI implements ActionListener {

	// Fields

	JPanel homePane;

	String name;

	private JLabel lblTitle;
	private JLabel lblCourses;
	private JLabel instructions;

	private JLabel lblIntervalImg;
	private JButton lblIntervalRect;
	private JLabel lblIntervalTitle;
	private JLabel lblIntervalDescription;

	private static ImageIcon purpRect = new ImageIcon("images/Home Rectangle.png");


	// Initialize GUI
	public HomeGUI() {

		name = Initialize.user.getFirstName();

		// JPanel Setup
		homePane = new JPanel();
		homePane.setBounds(300, 0, 1240, 810);
		homePane.setBackground(Color.white);
		homePane.setLayout(null);
		Frame.frame.getContentPane().add(homePane);

		// Welcome message
		lblTitle = new JLabel("<html><div style='text-align: center;'><html>Welcome " + name
				+ ", what would you like to learn today?</div><html>");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(269, 30, 602, 100);
		lblTitle.setFont(Fonts.TITLE1);
		lblTitle.setForeground(Colours.purple);
		homePane.add(lblTitle);

		// "Courses" JLabel
		lblCourses = new JLabel("Courses");
		lblCourses.setBounds(75, 147, 143, 38);
		lblCourses.setFont(Fonts.HEADING);
		homePane.add(lblCourses);

		
		// Instructions for navigation througout courses
		instructions = new JLabel();
		instructions.setIcon(new ImageIcon("images/Instructions.png"));
		instructions.setBounds(76,193,882,78);
		homePane.add(instructions);


		// Interval cousrse
		lblIntervalTitle = new JLabel("Intervals");
		lblIntervalTitle.setBounds(462, 323, 216, 40);
		lblIntervalTitle.setFont(Fonts.SUBHEADING1);
		homePane.add(lblIntervalTitle);

		lblIntervalDescription = new JLabel(
				"<html>In music theory, an interval is the difference in pitch between two sounds. "
						+ "<br><br>Complete this course to learn about and practice different types of intervals. <html>");
		lblIntervalDescription.setVerticalAlignment(SwingConstants.TOP);
		lblIntervalDescription.setBounds(462, 373, 500, 150);
		lblIntervalDescription.setFont(Fonts.BODY);
		homePane.add(lblIntervalDescription);

		lblIntervalImg = new JLabel("Interval Icon");// Interval Icon.png"));
		lblIntervalImg.setBounds(76, 299, 340, 250);
		lblIntervalImg.setIcon(new ImageIcon("images/Interval Icon.png")); // INTERVAL IMAGE
		homePane.add(lblIntervalImg);

		// Purple rectangle  surrounding info
		JLabel purp = new JLabel(purpRect);
		purp.setBounds(75, 298, 992, 252);
		homePane.add(purp);
		
		// Button behind image and JLables
		lblIntervalRect = new JButton();
		lblIntervalRect.setBounds(75, 298, 992, 252);
		lblIntervalRect.addActionListener(this);
		homePane.add(lblIntervalRect);
		
		homePane.repaint();

	}

	// Set name within welcome message
	public void newName() {
		
		name = Initialize.user.getFirstName();
		 
		lblTitle.setText(("<html><div style='text-align: center;'><html>Welcome " + name
				+ ", what would you like to learn today?</div><html>"));
		
		homePane.repaint();
		
	}

	// Event handler
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// When "Intervals" is clicked
		Initialize.sidebar.setDark(); // Set all side bar items to dark
		Initialize.iCourse.iCoursePane.setVisible(true); // Display new pane
		Initialize.sidebar.isClicked = null; // Allows hover states to work for all
		Initialize.home.homePane.setVisible(false); // Hide current pane
	}

}
