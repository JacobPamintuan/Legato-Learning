package legatoLearning;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/*
 * Lesson GUI template class
 * Template for all lessons
 * Initializes fields through lesson object
 * Accessible from Interval Course page
 */

public class LessonTemplate implements MouseListener {

	// Fields
	Lesson l;

	// Data fields

	private String course;

	private String difficulty;
	private int lessonNumber;
	private String lessonName;

	public int currentPane;
	private int totalPanes;

	private String title;

	private boolean completed;

	// GUI fields
	public JPanel LessonTempPane;
	private JLabel lblTitle;
	private JLabel lblCourse;
	private JLabel lblDifficulty;
	private JLabel lblLesson;

	private JLabel chevron;

	private JLabel lblProgress;

	private JLabel lessonImage;

	private JLabel lblPrevious;
	private JLabel lblNext;

	public LessonTemplate(int num) {
		
		this.l = Initialize.lessonArr[num];
		
		initializeObject();
		initializeGUI();
	
	}

	// Initialize object/data fields
	private void initializeObject() {
		
		course = l.getCourse();
		difficulty = l.getDifficulty();
		lessonNumber = l.getLessonNumber();
		title = l.getTitle();
		currentPane = l.getCurrentPane();
		totalPanes = l.getTotalPanes();
		setCompleted(l.isCompleted());
		lessonName = l.getLessonName();

	}

	// Initialize GUI fields
	private void initializeGUI() {

		// JPanel Setup

		LessonTempPane = new JPanel();
		LessonTempPane.setBounds(300, 0, 1140, 810);
		LessonTempPane.setBackground(Color.white);
		LessonTempPane.setLayout(null);
		Frame.frame.getContentPane().add(LessonTempPane);

		// Permanent JLabels

		lblTitle = new JLabel(title);
		lblTitle.setBounds(65, 130, 995, 55);
		lblTitle.setFont(Fonts.TITLE2);
		lblTitle.setForeground(Colours.purple);
		LessonTempPane.add(lblTitle);

		lblCourse = new JLabel("<html><u>" + course + "<u><html>");
		lblCourse.addMouseListener(this);
		lblCourse.setBounds(65, 25, 190, 30);
		lblCourse.setFont(Fonts.BREADCRUMBS);
		LessonTempPane.add(lblCourse);

		lblDifficulty = new JLabel(difficulty);
		lblDifficulty.setBounds(65, 65, 200, 40);
		lblDifficulty.setFont(Fonts.HEADING);
		LessonTempPane.add(lblDifficulty);

		chevron = new JLabel();
		chevron.setIcon(new ImageIcon("images/chevron.png"));
		chevron.setBounds(215 + shiftX(), 69, 32, 32);
		LessonTempPane.add(chevron);

		lblLesson = new JLabel("Lesson " + lessonNumber + " - " + lessonName);
		lblLesson.setBounds(255 + shiftX(), 65, 600, 40);
		lblLesson.setFont(Fonts.HEADING);
		LessonTempPane.add(lblLesson);

	
		// Changes depending on which pane
		lblProgress = new JLabel(currentPane + " of " + totalPanes);
		lblProgress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProgress.setBounds(860, 64, 140, 40);
		lblProgress.setFont(Fonts.HEADING);
		lblProgress.setForeground(Colours.purple);
		LessonTempPane.add(lblProgress);

		lessonImage = new JLabel();
		lessonImage.setVerticalAlignment(SwingConstants.TOP);

		lessonImage.setIcon(new ImageIcon("images/" + difficulty + " " + lessonNumber + " " + currentPane + ".png"));
		lessonImage.setBounds(65, 200, 1020, 490);
		LessonTempPane.add(lessonImage);

		// Traversal "Buttons" - JLabels with mouselisteners
		lblPrevious = new JLabel("Previous");
		lblPrevious.setIcon(new ImageIcon("images/Previous.png"));
		lblPrevious.setBounds(253, 712, 195, 55);
		lblPrevious.addMouseListener(this);
		LessonTempPane.add(lblPrevious);

		lblPrevious.setEnabled(false);

		lblNext = new JLabel("Next");
		lblNext.setIcon(new ImageIcon("images/Next.png"));
		lblNext.setBounds(691, 712, 195, 55);
		lblNext.addMouseListener(this);
		LessonTempPane.add(lblNext);

		LessonTempPane.repaint();
	}

	// Shifts chevron and lesson name a certain amount depending on difficulty
	// Different difficulties take up a different amount of space on JLabel
	private int shiftX() {

		if (difficulty.equals("Beginner"))
			return 0;

		else if (difficulty.equals("Advanced"))
			return 10;

		else if (difficulty.equals("Intermediate"))
			return 50;

		return -1;
	}
	
	// Determine if lesson is completed
	public boolean isCompleted() {
		return completed;
	}

	// Set lesson to completed
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	// Event handlers
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		JLabel press = (JLabel) e.getSource();

		// Back to course page
		if (press == lblCourse) {

			LessonTempPane.setVisible(false);
			Initialize.iCourse.iCoursePane.setVisible(true);

			return;
		}

		// Lesson complete
		if (press == lblNext && currentPane == totalPanes) {

			currentPane = 0;

			l.setCompleted(true);
			l.saveLesson();

			LessonTempPane.setVisible(false);

			Initialize.iCourse.enableQuizzes();
			Initialize.iCourse.iCoursePane.setVisible(true);

		}

		// Going back and forward throughout lesson
		if (press == lblPrevious && currentPane != 1)
			currentPane--;
		else if (press == lblNext && currentPane != totalPanes)
			currentPane++;
		
		// Disable "previous" if on first pane
		if (currentPane == 1)
			lblPrevious.setEnabled(false);
		else
			lblPrevious.setEnabled(true);

		// Switch "Next" 'button' to "Back to Course" when lesson is complete
		if (currentPane == totalPanes)
			lblNext.setIcon(new ImageIcon("images/BackToCourse.png"));
		else
			lblNext.setIcon(new ImageIcon("images/Next.png"));
		
		// Update lesson progress
		lblProgress.setText((currentPane + " of " + totalPanes));
		
		// Update lesson image
		lessonImage.setIcon(new ImageIcon("images/" + difficulty + " " + lessonNumber + " " + currentPane + ".png"));
		
	}
	
	// Event handlers

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	
		JLabel lbl = (JLabel) e.getSource();

		// Exit hover state - Cursor and color change
		lbl.setForeground(Colours.purple);
		lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));

	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		JLabel lbl = (JLabel) e.getSource();

		// Exit hover state - Cursor and color change
		lbl.setForeground(Color.BLACK);
		lbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

}
