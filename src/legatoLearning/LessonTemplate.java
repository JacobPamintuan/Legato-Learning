package legatoLearning;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class LessonTemplate implements ActionListener, MouseListener {

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

	private JLabel chevron = new JLabel();

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
		LessonTempPane = new JPanel();
		LessonTempPane.setBounds(300, 0, 1140, 810);
		LessonTempPane.setBackground(Color.white);
		LessonTempPane.setLayout(null);
		Frame.frame.getContentPane().add(LessonTempPane);

		lblTitle = new JLabel(title);
		lblTitle.setBounds(65, 130, 995, 55);
		lblTitle.setFont(Fonts.TITLE2);
		lblTitle.setForeground(Colours.purp);
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

		chevron.setIcon(new ImageIcon("images/chevron.png"));
		chevron.setBounds(215 + shiftX(), 69, 32, 32);
		LessonTempPane.add(chevron);

		lblLesson = new JLabel("Lesson " + lessonNumber + " - " + lessonName);
		lblLesson.setBounds(255 + shiftX(), 65, 600, 40);
		lblLesson.setFont(Fonts.HEADING);
		LessonTempPane.add(lblLesson);

		lblProgress = new JLabel(currentPane + " of " + totalPanes);
		lblProgress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProgress.setBounds(860, 64, 140, 40);
		lblProgress.setFont(Fonts.HEADING);
		lblProgress.setForeground(Colours.purp);
		LessonTempPane.add(lblProgress);

		lessonImage = new JLabel();
		lessonImage.setVerticalAlignment(SwingConstants.TOP);

		lessonImage.setIcon(new ImageIcon("images/" + difficulty + " " + lessonNumber + " " + currentPane + ".png"));
		lessonImage.setBounds(65, 200, 1020, 490);
		LessonTempPane.add(lessonImage);

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

	// Shifts cheveron and lesson name a certain amount depedning on difficulty
	// Different difficulties take up a different amount of space on JLabel
	private int shiftX() {
		int xShift = 0;
		if (difficulty.equals("Beginner"))
			xShift = 0;
		else if (difficulty.equals("Advanced"))
			xShift = 10;
		else if (difficulty.equals("Intermediate"))
			xShift = 50;
		return xShift;
	}

	// Event handlers
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		JLabel press = (JLabel) e.getSource();

		if (press == lblCourse) {
			LessonTempPane.setVisible(false);
			Initialize.iCourse.iCoursePane.setVisible(true);
			return;
		}

		if (press == lblNext && currentPane == totalPanes) {
			currentPane = 0;
			l.setCompleted(true);
			LessonTempPane.setVisible(false);
			l.saveLesson();
			Initialize.iCourse.enableQuizzes();
			// Initialize.home.homePane.setVisible(true);
			Initialize.iCourse.iCoursePane.setVisible(true);
//			Initialize.sidebar.lblHome.setIcon(new ImageIcon("images/Home Light.png"));
		}

		if (press == lblPrevious && currentPane != 1)
			currentPane--;
		else if (press == lblNext && currentPane != totalPanes)
			currentPane++;

		if (currentPane == 1) {
			lblPrevious.setEnabled(false);
		} else
			lblPrevious.setEnabled(true);
		if (currentPane == totalPanes) {
			lblNext.setIcon(new ImageIcon("images/BackToCourse.png"));
		} else
			lblNext.setIcon(new ImageIcon("images/Next.png"));

		lblProgress.setText((currentPane + " of " + totalPanes));
		lessonImage.setIcon(new ImageIcon("images/" + difficulty + " " + lessonNumber + " " + currentPane + ".png"));
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JLabel lbl = (JLabel) e.getSource();

		lbl.setForeground(Colours.purp);

	}

	@Override
	public void mouseExited(MouseEvent e) {
		JLabel lbl = (JLabel) e.getSource();

		lbl.setForeground(Color.BLACK);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

}
