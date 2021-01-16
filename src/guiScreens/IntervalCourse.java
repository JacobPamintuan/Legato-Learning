package guiScreens;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntervalCourse implements MouseListener, ActionListener {

	public JPanel iCoursePane;

	private JLabel HOME;
	private JLabel chevron;
	private JLabel COURSES;
	private JLabel INTERVALS;

	private JLabel beginner, intermediate, advanced;

	private JButton beginnerL, advancedL;
	private JButton[] intermediateL;

	private JButton[] beginnerQ;
	private JButton[][] intermediateQ, advancedQ;

	public IntervalCourse() {
		iCoursePane = new JPanel();
		iCoursePane.setBounds(300, 0, 1240, 810);
		iCoursePane.setBackground(Color.white);
		iCoursePane.setLayout(null);
		Frame.frame.getContentPane().add(iCoursePane);

		HOME = new JLabel("Home");
		HOME.setBounds(65, 20, 91, 40);
		HOME.setFont(Fonts.BREADCRUMBS);
		HOME.setVerticalAlignment(SwingConstants.CENTER);
		HOME.addMouseListener(this);

		COURSES = new JLabel("Courses");
		COURSES.setBounds(159, 20, 133, 40);
		COURSES.setFont(Fonts.BREADCRUMBS);
		COURSES.setVerticalAlignment(SwingConstants.CENTER);

		chevron = new JLabel();
		chevron.setIcon(new ImageIcon("IntCourse/chevron2.png"));
		chevron.setBounds(127, 28, 23, 23);

		INTERVALS = new JLabel("Intervals");
		INTERVALS.setBounds(65, 62, 400, 54);
		INTERVALS.setFont(Fonts.TITLE2);
		INTERVALS.setForeground(Colours.purp);

		beginner = new JLabel("Beginner");
		beginner.setHorizontalAlignment(SwingConstants.CENTER);
		beginner.setBounds(96, 130, 196, 40);
		beginner.setFont(Fonts.SUBHEADING2);

		intermediate = new JLabel("Intermediate");
		intermediate.setHorizontalAlignment(SwingConstants.CENTER);
		intermediate.setBounds(478, 133, 196, 34);
		intermediate.setFont(Fonts.SUBHEADING2);

		advanced = new JLabel("Advanced");
		advanced.setHorizontalAlignment(SwingConstants.CENTER);
		advanced.setBounds(848, 130, 196, 40);
		advanced.setFont(Fonts.SUBHEADING2);

		beginnerL = new JButton(new ImageIcon("IntCourse/BL1.png"));
		beginnerL.setBounds(21, 180, 345, 42);
		beginnerL.addActionListener(this);
		iCoursePane.add(beginnerL);

		JLabel bRect = new JLabel();
		bRect.setIcon(new ImageIcon("IntCourse/BeginnerRect.png"));
		bRect.setBounds(11, 130, 366, 281);
		iCoursePane.add(bRect);

		beginnerQ = new JButton[3];
		for (int i = 0; i < beginnerQ.length; i++) {
			beginnerQ[i] = new JButton(new ImageIcon("IntCourse/BQ" + (i + 1) + ".png"));
			beginnerQ[i].setBounds(21, 236 + 55 * i, 345, 42);
			beginnerQ[i].addActionListener(this);
			iCoursePane.add(beginnerQ[i]);
			beginnerQ[i].setEnabled(false);
		}

		JLabel IRect = new JLabel();
		IRect.setIcon(new ImageIcon("IntCourse/IntermediateRect.png"));
		IRect.setBounds(387, 130, 366, 451);
		iCoursePane.add(IRect);

		intermediateL = new JButton[2];
		for (int i = 0; i < intermediateL.length; i++) {
			intermediateL[i] = new JButton(new ImageIcon("IntCourse/IL" + (i + 1) + ".png"));
			intermediateL[i].setBounds(397, 180 + i * 225, 345, 42);
			intermediateL[i].addActionListener(this);
			iCoursePane.add(intermediateL[i]);
		}

		intermediateQ = new JButton[2][3];
		for (int i = 0; i < 3; i++) {
			intermediateQ[0][i] = new JButton(new ImageIcon("IntCourse/IQ1" + (i + 1) + ".png"));
			intermediateQ[0][i].setBounds(397, 236 + 55 * i, 345, 42);
			intermediateQ[0][i].addActionListener(this);
			iCoursePane.add(intermediateQ[0][i]);
			intermediateQ[0][i].setEnabled(false);
		}

		for (int i = 0; i < 2; i++) {
			intermediateQ[1][i] = new JButton(new ImageIcon("IntCourse/IQ2" + (i + 1) + ".png"));
			intermediateQ[1][i].setBounds(397, 461 + 55 * i, 345, 42);
			intermediateQ[1][i].addActionListener(this);
			iCoursePane.add(intermediateQ[1][i]);
			intermediateQ[1][i].setEnabled(false);
		}

		advancedL = new JButton(new ImageIcon("IntCourse/AL1.png"));
		advancedL.setBounds(773, 180, 345, 42);
		advancedL.addActionListener(this);
		iCoursePane.add(advancedL);

		iCoursePane.add(HOME);
		iCoursePane.add(COURSES);
		iCoursePane.add(chevron);
		iCoursePane.add(INTERVALS);

		iCoursePane.add(beginner);
		iCoursePane.add(intermediate);
		iCoursePane.add(advanced);

//		iCoursePane.add(bLesson1);
//		iCoursePane.add(iLesson1);
//		iCoursePane.add(iLesson2);
//		iCoursePane.add(aLesson1);
//		iCoursePane.add(aLesson2);

		iCoursePane.repaint();

	}

	public void enableQuizzes() {
		if (Initialize.lessonArr[0].isCompleted())
			for (int i = 0; i < 3; i++)
				beginnerQ[i].setEnabled(true);

		if (Initialize.lessonArr[1].isCompleted())
			for (int i = 0; i < 3; i++)
				intermediateQ[0][i].setEnabled(true);

		if (Initialize.lessonArr[2].isCompleted())
			for (int i = 0; i < 2; i++)
				intermediateQ[1][i].setEnabled(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		JLabel lbl = (JLabel) e.getSource();

		if (lbl == HOME) {
			iCoursePane.setVisible(false);
			Initialize.home.homePane.setVisible(true);
			Initialize.sidebar.lblHome.setIcon(new ImageIcon("images/Home Light.png"));
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JLabel lbl = (JLabel) e.getSource();

		lbl.setText("<html><u>" + lbl.getText() + "<u><html>");

//		JLabel link = new JLabel("<html><u>Link to " + unis[0].getName() + "'s website<u><html>"); // JLabel - Link with

	}

	@Override
	public void mouseExited(MouseEvent e) {
		JLabel lbl = (JLabel) e.getSource();

		String noUnderline = lbl.getText().substring(9, lbl.getText().length() - 9);

		lbl.setText(noUnderline);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		System.out.println(btn.getName());

		if (btn == beginnerL) {
			Initialize.lessonGUI[0].LessonTempPane.setVisible(true);
			iCoursePane.setVisible(false);
			return;
		}

		if (btn == advancedL) {
			Initialize.lessonGUI[3].LessonTempPane.setVisible(true);
			iCoursePane.setVisible(false);
			return;
		}

		for (int i = 0; i < beginnerQ.length; i++)
			if (btn == beginnerQ[i]) {
				Initialize.quizGUI[i].QuizPane.setVisible(true);
				iCoursePane.setVisible(false);
				return;
			}

		for (int i = 0; i < intermediateL.length; i++)
			if (btn == intermediateL[i]) {
				Initialize.lessonGUI[i + 1].LessonTempPane.setVisible(true);
				iCoursePane.setVisible(false);
				return;
			}

		for (int i = 0; i < 3; i++)
			if (btn == intermediateQ[0][i]) {
				Initialize.quizGUI[i + 3].QuizPane.setVisible(true);
				iCoursePane.setVisible(false);
				System.out.println("int q" + i);
				return;
			}

		for (int i = 0; i < 2; i++)
			if (btn == intermediateQ[1][i]) {
				Initialize.quizGUI[i + 6].QuizPane.setVisible(true);
				iCoursePane.setVisible(false);
				System.out.println("int" + i);
				return;
			}
	}
}
