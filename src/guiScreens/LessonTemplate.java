package guiScreens;

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

	Lesson l;

	public JPanel LessonTempPane;

	private String course;// ="INTERVALS";

	private String difficulty;// = "Beginner";
	private int lessonNumber;// = 1;

	public int currentPane;// = 1;
	private int totalPanes;// = 3;

	private String title;// = "What is an interval?";

	private boolean completed;

	private JLabel lblTitle;
	private JLabel lblCourse;
	private JLabel lblDifficulty;
	private JLabel lblLesson;

	private JLabel chevron = new JLabel();

	private JLabel lblProgress;

	private JLabel lessonImage;

	private JLabel lblPrevious;
	private JLabel lblNext;

	public void getLesson() {

	}

	public void saveLesson() {

	}

	public LessonTemplate(int num) {
//		Lesson lesson = Initialize.lessonArr[num];
//		l= lesson;
		this.l = Initialize.lessonArr[num];
		initializeObject();
		initializeGUI();
	}

	private void initializeObject() {
		course = l.getCourse();
		difficulty = l.getDifficulty();
		lessonNumber = l.getLessonNumber();
		title = l.getTitle();
		currentPane = l.getCurrentPane();
		totalPanes = l.getTotalPanes();
		completed = l.isCompleted();

	}

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

		lblCourse = new JLabel(course);
		lblCourse.addMouseListener(this);
		lblCourse.setBounds(65, 25, 190, 30);
		lblCourse.setFont(Fonts.BODY);
		LessonTempPane.add(lblCourse);

		lblDifficulty = new JLabel(difficulty);
		lblDifficulty.setBounds(65, 65, 200, 40);
		lblDifficulty.setFont(Fonts.HEADING);
		LessonTempPane.add(lblDifficulty);

		// chevron.setIcon(new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Music
		// Theory App/images/chevron.png"));
		chevron.setIcon(new ImageIcon("images/chevron.png"));
		chevron.setBounds(215 + shiftX(), 69, 32, 32);
		LessonTempPane.add(chevron);

		lblLesson = new JLabel("Lesson" + lessonNumber);
		lblLesson.setBounds(255 + shiftX(), 65, 450, 40);
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
		lblPrevious.setIcon(new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Music Theory App/images/Previous.png"));
		lblPrevious.setIcon(new ImageIcon("images/Previous.png"));
		lblPrevious.setBounds(253, 712, 195, 55);
		lblPrevious.addMouseListener(this);
		LessonTempPane.add(lblPrevious);

		lblPrevious.setEnabled(false);

		lblNext = new JLabel("Next");
		lblNext.setIcon(new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Music Theory App/images/Next.png"));
		lblNext.setIcon(new ImageIcon("images/Next.png"));
		lblNext.setBounds(691, 712, 195, 55);
		lblNext.addMouseListener(this);
		LessonTempPane.add(lblNext);

		LessonTempPane.repaint();
	}

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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
			//Initialize.home.homePane.setVisible(true);
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
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JLabel lbl = (JLabel) e.getSource();

		lbl.setText("<html><u>" + lbl.getText() + "<u><html>");


	}

	@Override
	public void mouseExited(MouseEvent e) {
		JLabel lbl = (JLabel) e.getSource();

		String noUnderline = lbl.getText().substring(9, lbl.getText().length() - 9);

		lbl.setText(noUnderline);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
