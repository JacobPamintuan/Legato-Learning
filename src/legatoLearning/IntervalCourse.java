package legatoLearning;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntervalCourse implements MouseListener, ActionListener {

	// Fields

	public JPanel iCoursePane;

	private JLabel HOME;
	private JLabel chevron;
	private JLabel COURSES;
	private JLabel INTERVALS;

	private JLabel beginner, intermediate, advanced;

	private JButton beginnerL, advancedL;
	private JButton[] intermediateL;

	private JButton[] beginnerQ, advancedQ;
	private JButton[][] intermediateQ;

	private ImageIcon check = new ImageIcon("IntCourse/check.png");

	JLabel bLCheck = new JLabel();
	JLabel aLCheck = new JLabel();
	JLabel[] iLChecks = new JLabel[2];

	JLabel[] bQChecks = new JLabel[3];
	JLabel[] aQChecks = new JLabel[2];

	JLabel[] iL1QChecks = new JLabel[3];
	JLabel[] iL2QChecks = new JLabel[2];

	public QuizTemplate current;

	public IntervalCourse() {
		// Panel setup
		iCoursePane = new JPanel();
		iCoursePane.setBounds(300, 0, 1240, 810);
		iCoursePane.setBackground(Color.white);
		iCoursePane.setLayout(null);
		Frame.frame.getContentPane().add(iCoursePane);

		// Create checkmarks
		checks();

		// Title JLabels
		HOME = new JLabel("<html><u>Home<u><html>");
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
		INTERVALS.setForeground(Colours.purple);

		// Difficulty Labels
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

		// Lessons and Quizzes, JButtons and purple rectangle images

		// Purple rectangle around Beginner
		JLabel bRect = new JLabel();
		bRect.setIcon(new ImageIcon("IntCourse/BeginnerRect.png"));
		bRect.setBounds(11, 130, 366, 281);
		iCoursePane.add(bRect);

		// Beginner Lesson
		beginnerL = new JButton(new ImageIcon("IntCourse/BL1.png"));
		beginnerL.setBounds(21, 180, 345, 42);
		beginnerL.addActionListener(this);
		iCoursePane.add(beginnerL);

		// Beginner quizzes
		beginnerQ = new JButton[3];

		for (int i = 0; i < beginnerQ.length; i++) {

			beginnerQ[i] = new JButton(new ImageIcon("IntCourse/BQ" + (i + 1) + ".png"));
			beginnerQ[i].setBounds(21, 236 + 55 * i, 345, 42);
			beginnerQ[i].addActionListener(this);
			iCoursePane.add(beginnerQ[i]);
			beginnerQ[i].setEnabled(false);

		}

		// Purple rectangle around Intermediate
		JLabel IRect = new JLabel();
		IRect.setIcon(new ImageIcon("IntCourse/IntermediateRect.png"));
		IRect.setBounds(387, 130, 366, 451);
		iCoursePane.add(IRect);

		// Intermediate lessons
		intermediateL = new JButton[2];

		for (int i = 0; i < intermediateL.length; i++) {

			intermediateL[i] = new JButton(new ImageIcon("IntCourse/IL" + (i + 1) + ".png"));
			intermediateL[i].setBounds(397, 180 + i * 225, 345, 42);
			intermediateL[i].addActionListener(this);
			iCoursePane.add(intermediateL[i]);

		}

		// Intermediate Lesson 1 Quizzes
		intermediateQ = new JButton[2][3];

		for (int i = 0; i < 3; i++) {

			intermediateQ[0][i] = new JButton(new ImageIcon("IntCourse/IQ1" + (i + 1) + ".png"));
			intermediateQ[0][i].setBounds(397, 236 + 55 * i, 345, 42);
			intermediateQ[0][i].addActionListener(this);
			iCoursePane.add(intermediateQ[0][i]);
			intermediateQ[0][i].setEnabled(false);
			
		}

		// Intermediate Lesson 2 Quizzes
		for (int i = 0; i < 2; i++) {

			intermediateQ[1][i] = new JButton(new ImageIcon("IntCourse/IQ2" + (i + 1) + ".png"));
			intermediateQ[1][i].setBounds(397, 461 + 55 * i, 345, 42);
			intermediateQ[1][i].addActionListener(this);
			iCoursePane.add(intermediateQ[1][i]);
			intermediateQ[1][i].setEnabled(false);
			
		}

		// Purple Rectangle around Advanced
		JLabel ARect = new JLabel();
		ARect.setIcon(new ImageIcon("IntCourse/AdvancedRect.png"));
		ARect.setBounds(762, 130, 366, 226);
		iCoursePane.add(ARect);

		// Advanced Lesson
		advancedL = new JButton(new ImageIcon("IntCourse/AL1.png"));
		advancedL.setBounds(773, 180, 345, 42);
		advancedL.addActionListener(this);
		iCoursePane.add(advancedL);

		// Advanced Quizzes
		advancedQ = new JButton[2];
		
		for (int i = 0; i < advancedQ.length; i++) {
			
			advancedQ[i] = new JButton(new ImageIcon("IntCourse/AQ" + (i + 1) + ".png"));
			advancedQ[i].setBounds(773, 235 + 55 * i, 345, 42);
			advancedQ[i].addActionListener(this);
			iCoursePane.add(advancedQ[i]);
			advancedQ[i].setEnabled(false);
			
		}

		// Label Packing
		iCoursePane.add(HOME);
		iCoursePane.add(COURSES);
		iCoursePane.add(chevron);
		iCoursePane.add(INTERVALS);

		iCoursePane.add(beginner);
		iCoursePane.add(intermediate);
		iCoursePane.add(advanced);

		// Update GUI based on user progress
		enableQuizzes();
		quizCompleted();

		iCoursePane.repaint();

	}

	// Create checkmarks beside each lesson/quiz
	// Set to invisible
	private void checks() {

		// Beginner Lesson
		bLCheck.setIcon(check);
		bLCheck.setBounds(346, 182, 15, 15);
		iCoursePane.add(bLCheck);
		bLCheck.setVisible(false);

		// Beginner Quizzes
		for (int i = 0; i < 3; i++) {
			
			bQChecks[i] = new JLabel();
			bQChecks[i].setIcon(check);
			bQChecks[i].setBounds(346, 238 + i * 57, 15, 15);
			iCoursePane.add(bQChecks[i]);
			bQChecks[i].setVisible(false);
	
		}

		// Intermediate Lessons
		for (int i = 0; i < 2; i++) {
		
			iLChecks[i] = new JLabel();
			iLChecks[i].setIcon(check);
			iLChecks[i].setBounds(722, 182 + i * 225, 15, 15);
			iCoursePane.add(iLChecks[i]);
			iLChecks[i].setVisible(false);
			
		}

		// Intermediate Lesson 1 Quizzes
		for (int i = 0; i < 3; i++) {
		
			iL1QChecks[i] = new JLabel();
			iL1QChecks[i].setIcon(check);
			iL1QChecks[i].setBounds(722, 238 + i * 57, 15, 15);
			iCoursePane.add(iL1QChecks[i]);
			iL1QChecks[i].setVisible(false);
	
		}

		// Intermediate Lesson 2 Quizzes
		for (int i = 0; i < 2; i++) {
		
			iL2QChecks[i] = new JLabel();
			iL2QChecks[i].setIcon(check);
			iL2QChecks[i].setBounds(722, 463 + i * 57, 15, 15);
			iCoursePane.add(iL2QChecks[i]);
			iL2QChecks[i].setVisible(false);
	
		}

		// Advanced Lesson
		aLCheck.setIcon(check);
		aLCheck.setBounds(1098, 182, 15, 15);
		iCoursePane.add(aLCheck);
		aLCheck.setVisible(false);

		// Advanced Quizzes
		for (int i = 0; i < 2; i++) {
		
			aQChecks[i] = new JLabel();
			aQChecks[i].setIcon(check);
			aQChecks[i].setBounds(1098, 238 + i * 57, 15, 15);
			iCoursePane.add(aQChecks[i]);
			aQChecks[i].setVisible(false);
		
		}

	}

	// Check if each quiz is completed
	// Set checkmark beside quiz to visible
	public void quizCompleted() {

		// Beginner quizzes
		for (int i = 0; i < 3; i++) {

			if (Initialize.quizArr[i].isCompleted())
				bQChecks[i].setVisible(true);
			
		}

		// Intermediate Lesson 1 quizzes
		for (int i = 3; i <= 5; i++) {
			
			if (Initialize.quizArr[i].isCompleted())
				iL1QChecks[i - 3].setVisible(true);
		}

		// Intermediate Lesson 2 quizzes
		for (int i = 6; i <= 7; i++) {

			if (Initialize.quizArr[i].isCompleted())
				iL2QChecks[i - 6].setVisible(true);

		}

		// Advanced quizzes
		for (int i = 8; i <= 9; i++) {
			
			if (Initialize.quizArr[i].isCompleted())
				aQChecks[i - 8].setVisible(true);
	
		}
	

	}

	// Enables quizzes if/when respective lesson is completed
	public void enableQuizzes() {

		// Beginner Lesson 1
		if (Initialize.lessonArr[0].isCompleted()) {
			
			bLCheck.setVisible(true);
			
			for (int i = 0; i < 3; i++)
				beginnerQ[i].setEnabled(true);
		
		}

		// Intermediate Lesson 1
		if (Initialize.lessonArr[1].isCompleted()) {
		
			iLChecks[0].setVisible(true);
		
			for (int i = 0; i < 3; i++)
				intermediateQ[0][i].setEnabled(true);
	
		}

		// Intermediate Lesson 2
		if (Initialize.lessonArr[2].isCompleted()) {
		
			iLChecks[1].setVisible(true);
		
			for (int i = 0; i < 2; i++)
				intermediateQ[1][i].setEnabled(true);
	
		}

		// Advanced Lesson 1
		if (Initialize.lessonArr[3].isCompleted()) {
			
			aLCheck.setVisible(true);
			
			for (int i = 0; i < advancedQ.length; i++)
				advancedQ[i].setEnabled(true);
		
		}

	}

	// // Display popup if course complete (all quizzes complete)
	public void courseComplete() {

		int numCompleted=0;
		
		for(int i=0;i<Initialize.quizArr.length;i++) 
		
			if(Initialize.quizArr[i].isCompleted())
				numCompleted++;
		
		
		if (numCompleted == 10) {
		
			String message = "CONGRATULATIONS!!! YOU HAVE COMPLETED THE INTERVALS COURSE";
			
			new JOptionPane();
			
			JOptionPane.showMessageDialog(iCoursePane, message);
	
		}
	}

	// Event Handlers
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		JLabel lbl = (JLabel) e.getSource();

		// Send user back to home page
		if (lbl == HOME) {
			iCoursePane.setVisible(false);
		
			Initialize.home.homePane.setVisible(true);
			Initialize.sidebar.lblHome.setIcon(new ImageIcon("images/Home Light.png"));
	
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JLabel lbl = (JLabel) e.getSource();

		// Enter hover state - color change, cursor change
		lbl.setForeground(Colours.purple);
		lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));

	}

	@Override
	public void mouseExited(MouseEvent e) {
		JLabel lbl = (JLabel) e.getSource();

		// Exit hover state - color change, cursor change
		lbl.setForeground(Color.BLACK);
		lbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();

		// Initialize array of all Quiz objects
		// Used if user is redoing a quiz
		Quiz[] quizOG = new Quiz[10]; // Default quiz array
		
		try {
			BufferedReader br = new BufferedReader(new java.io.FileReader(Initialize.quizDataOG)); // Default text file

			for (int i = 0; i < quizOG.length; i++) {

				String line = br.readLine();
				quizOG[i] = new Quiz(line);

			}

			br.close();

		} catch (Exception e1) {

			e1.printStackTrace();

		}

		// Beginner lesson 1
		if (btn == beginnerL) {

			Initialize.lessonGUI[0].LessonTempPane.setVisible(true);
		
			iCoursePane.setVisible(false);
			
			return;

		}

		// Beginner Quizzes
		for (int i = 0; i < beginnerQ.length; i++)

			if (btn == beginnerQ[i]) {

				if (Initialize.quizArr[i].isCompleted()) {
				
					Initialize.quizArr[i] = quizOG[i]; // Use values from Default
					current = new QuizTemplate(Initialize.quizArr[i]);

				} else

					Initialize.quizGUI[i].QuizPane.setVisible(true);

				iCoursePane.setVisible(false);
				
				return;

			}

		// Intermediate Lessons
		for (int i = 0; i < intermediateL.length; i++)

			if (btn == intermediateL[i]) {

				Initialize.lessonGUI[i + 1].LessonTempPane.setVisible(true);
				iCoursePane.setVisible(false);
				
				return;

			}

		// Intermediate Lesson 1 Quizzes
		for (int i = 0; i < 3; i++)

			if (btn == intermediateQ[0][i]) {

				if (Initialize.quizArr[i + 3].isCompleted()) {
				
					Initialize.quizArr[i + 3] = quizOG[i + 3]; // Use values from Default
					current = new QuizTemplate(Initialize.quizArr[i + 3]);

				} else

					Initialize.quizGUI[i + 3].QuizPane.setVisible(true);

				iCoursePane.setVisible(false);
				
				return;
			}

		// Intermediate Lesson 2 Quizzes
		for (int i = 0; i < 2; i++)

			if (btn == intermediateQ[1][i]) {

				if (Initialize.quizArr[i + 6].isCompleted()) {

					Initialize.quizArr[i + 6] = quizOG[i + 6]; // Use values from Default
					current = new QuizTemplate(Initialize.quizArr[i + 6]);

				} else

					Initialize.quizGUI[i + 6].QuizPane.setVisible(true);

				iCoursePane.setVisible(false);
				System.out.println("int" + i);
				
				return;
		
			}
		// Advanced Lesson 1
		if (btn == advancedL) {

			Initialize.lessonGUI[3].LessonTempPane.setVisible(true);
			iCoursePane.setVisible(false);
			
			return;

		}

		// Advanced Quizzes
		for (int i = 0; i < advancedQ.length; i++)

			if (btn == advancedQ[i]) {

				if (Initialize.quizArr[i + 8].isCompleted()) {

					Initialize.quizArr[i + 8] = quizOG[i + 8]; // Use values from Default
					current = new QuizTemplate(Initialize.quizArr[i + 8]);

				} else

					Initialize.quizGUI[i + 8].QuizPane.setVisible(true);

				iCoursePane.setVisible(false);
				return;

			}

	}

}
