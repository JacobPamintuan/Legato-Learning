package guiScreens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class HomeGUI implements ActionListener {// , MouseListener {

	JPanel homePane;

	String name = "asdf";

	private JLabel lblTitle;
	private JLabel lblCourses;

	private JLabel lblIntervalImg;
//	private JLabel lblIntervalRect;
	private JButton lblIntervalRect;
	private JLabel lblIntervalTitle;
	private JLabel lblIntervalDescription;

	private JLabel lblCourse2Img;
//	private JLabel lblCourse2Rect;
	private JButton lblCourse2Rect;
	private JLabel lblCourse2Title;
	private JLabel lblCourse2Description;

	
	private static ImageIcon purpRect = new ImageIcon("images/Home Rectangle.png");

//	private static Font TITLE = new Font("Helvetica Neue", Font.BOLD, 36);
//	private static Font HEADING = new Font("Helvetica Neue", Font.BOLD, 30);
//	private static Font SUBHEADING = new Font("Helvetica Neue", Font.BOLD, 24);
//	private static Font BODY = new Font("Helvetica Neue", Font.PLAIN, 18);

	public HomeGUI() {
		homePane = new JPanel();
		homePane.setBounds(300, 0, 1240, 810);
		homePane.setBackground(Color.white);
		homePane.setLayout(null);
		Frame.frame.getContentPane().add(homePane);

		lblTitle = new JLabel("<html><div style='text-align: center;'><html>Welcome " + name
				+ ", what would <br>you like to learn today?</div><html>");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(295, 30, 550, 100);
		lblTitle.setFont(Fonts.TITLE1);
		lblTitle.setForeground(Colours.purp);
		homePane.add(lblTitle);

		lblCourses = new JLabel("Courses");
		lblCourses.setBounds(75, 147, 143, 38);
		lblCourses.setFont(Fonts.HEADING);
		homePane.add(lblCourses);

		lblIntervalImg = new JLabel("Interval Icon");// Interval Icon.png"));
		lblIntervalImg.setBounds(76, 211, 340, 250);
		lblIntervalImg.setIcon(new ImageIcon("images/Interval Icon.png")); // INTERVAL IMAGE
		homePane.add(lblIntervalImg);

		lblIntervalTitle = new JLabel("Intervals");
		lblIntervalTitle.setBounds(462, 235, 216, 40);
		lblIntervalTitle.setFont(Fonts.SUBHEADING);
		homePane.add(lblIntervalTitle);

		lblIntervalDescription = new JLabel("Description");
		lblIntervalDescription.setVerticalAlignment(SwingConstants.TOP);
		lblIntervalDescription.setBounds(462, 285, 500, 100);
		lblIntervalDescription.setFont(Fonts.BODY);
		homePane.add(lblIntervalDescription);

		lblIntervalRect = new JButton(purpRect);
		lblIntervalRect.setBounds(75, 210, 992, 252);// (73, 208, 992,252)
		lblIntervalRect.addActionListener(this);
		homePane.add(lblIntervalRect);

		///////////////////////////////////

		lblCourse2Img = new JLabel("Course2 Icon");// Course2 Icon.png"));
		lblCourse2Img.setBounds(76, 491, 340, 250);
		lblCourse2Img.setIcon(new ImageIcon("images/Course 2 Icon.png")); // Course2 IMAGE
		homePane.add(lblCourse2Img);

		lblCourse2Title = new JLabel("Course2");
		lblCourse2Title.setBounds(462, 515, 216, 40);
		lblCourse2Title.setFont(Fonts.SUBHEADING);
		homePane.add(lblCourse2Title);

		lblCourse2Description = new JLabel("Description");
		lblCourse2Description.setVerticalAlignment(SwingConstants.TOP);
		lblCourse2Description.setBounds(462, 565, 500, 100);
		lblCourse2Description.setFont(Fonts.BODY);
		homePane.add(lblCourse2Description);

		lblCourse2Rect = new JButton(purpRect);
		lblCourse2Rect.setBounds(75, 490, 992, 252);// (73, 488, 992,252)
		lblCourse2Rect.addActionListener(this);
		homePane.add(lblCourse2Rect);

		homePane.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == lblIntervalRect) {
			System.out.println("Interval Button");
		} else if (e.getSource() == lblCourse2Rect) {
			System.out.println("Course 2 Button");
		}
	}

//	@Override
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}

}
