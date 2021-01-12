package guiScreens;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class QuizTemplate implements ActionListener, MouseListener {

	public JPanel QuizPane;

	private String course = "INTERVALS";

	private String difficulty = "Beginner";
	private int lessonNumber = 1;

	private int currentPane = 1;
	private int totalPanes = 6;

	private String questionTitle = "Name the following melodic interval:";

	private JLabel lblTitle;
	private JLabel lblCourse;
	private JLabel lblDifficulty;
	private JLabel lblLesson;

	private JLabel chevron = new JLabel();

	private JLabel lblProgress;

	private JLabel quizImage;

	JButton answers[] = new JButton[4];
	JLabel qBoxL;

	private JLabel lblSkip;
	private JLabel lblNext;

	private static ImageIcon qBox = new ImageIcon("images/Question Box.png");
	private static ImageIcon ansBox = new ImageIcon("images/Answer Box.png");
	private static ImageIcon correct = new ImageIcon("images/Correct.png");
	private static ImageIcon incorrect = new ImageIcon("images/Incorrect.png");

	public void getLesson() {

	}

	public void saveLesson() {

	}

	public QuizTemplate() {
		QuizPane = new JPanel();
		QuizPane.setBounds(300, 0, 1140, 810);
		QuizPane.setBackground(Color.white);
		QuizPane.setLayout(null);
		Frame.frame.getContentPane().add(QuizPane);

		lblTitle = new JLabel(questionTitle);
		lblTitle.setBounds(65, 130, 995, 55);
		lblTitle.setFont(Fonts.TITLE2);
		lblTitle.setForeground(Colours.purp);
		QuizPane.add(lblTitle);

		lblCourse = new JLabel(course);
		lblCourse.setBounds(65, 25, 190, 30);
		lblCourse.setFont(Fonts.BODY);
		QuizPane.add(lblCourse);

		lblDifficulty = new JLabel(difficulty);
		lblDifficulty.setBounds(65, 65, 200, 40);
		lblDifficulty.setFont(Fonts.HEADING);
		QuizPane.add(lblDifficulty);

		// chevron.setIcon(new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Music
		// Theory App/images/chevron.png"));
		chevron.setIcon(new ImageIcon("images/chevron.png"));
		chevron.setBounds(215 + shiftX(), 69, 32, 32);
		QuizPane.add(chevron);

		lblLesson = new JLabel("Lesson" + lessonNumber);
		lblLesson.setBounds(255 + shiftX(), 65, 450, 40);
		lblLesson.setFont(Fonts.HEADING);
		QuizPane.add(lblLesson);

//		JButton temp = new JButton();
//		temp.setIcon(new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Music Theory App/images/Correct.png"));
//		temp.setBounds(65, 390, 220, 290);
//		QuizPane.add(temp);
//		
//		JButton temp2 = new JButton();
//		temp2.setIcon(new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Music Theory App/"
//				+ "images/Incorrect.png"));
//		temp2.setBounds(860, 390, 220, 290);
//		QuizPane.add(temp2);
		
		
		
		for (int i = 0; i < 4; i++) {
			answers[i] = new JButton();
			answers[i].setIcon(ansBox);
			answers[i].setBounds(65+i*265, 390, 220, 290);
			QuizPane.add(answers[i]);
		}
		
		qBoxL = new JLabel();
		qBoxL.setIcon(qBox);
		qBoxL.setBounds(165 +119*(currentPane-1), 187, 100, 148);
		QuizPane.add(qBoxL);
		
		

		lblProgress = new JLabel("Question " + currentPane + " of " + totalPanes);
		lblProgress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProgress.setBounds(795, 64, 280, 40);
		lblProgress.setFont(Fonts.HEADING);
		lblProgress.setForeground(Colours.purp);
		QuizPane.add(lblProgress);

		quizImage = new JLabel();
		quizImage.setVerticalAlignment(SwingConstants.TOP);
		quizImage.setIcon(new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Music Theory App/images/Melodic.png"));
		quizImage.setBounds(65, 185, 1020, 193);
		QuizPane.add(quizImage);

		lblSkip = new JLabel("Skip");
		lblSkip.setIcon(new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Music Theory App/images/Skip.png"));
		lblSkip.setIcon(new ImageIcon("images/Skip.png"));
		lblSkip.setBounds(253, 712, 195, 55);
		lblSkip.addMouseListener(this);
		QuizPane.add(lblSkip);

		lblNext = new JLabel("Next");
		lblNext.setIcon(new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Music Theory App/images/Next.png"));
		lblNext.setIcon(new ImageIcon("images/Next.png"));
		lblNext.setBounds(691, 712, 195, 55);
		lblNext.addMouseListener(this);
		QuizPane.add(lblNext);
		
		lblNext.setEnabled(false);

		QuizPane.repaint();
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

		if (press == lblSkip && currentPane == totalPanes) {
			System.out.println("Start Quiz");
//			LessonTempPane.setVisible(false);
		}

//		if (press == lblSkip && currentPane != 1)
//			currentPane--;
		if (press == lblSkip && currentPane != totalPanes)
			currentPane++;

//		if (currentPane == 1) {
//			lblSkip.setEnabled(false);
//		} else
//			lblSkip.setEnabled(true);
//		if (currentPane == totalPanes) {
//			lblNext.setIcon(new ImageIcon("images/Start Quiz.png"));
//		} else
//			lblNext.setIcon(new ImageIcon("images/Next.png"));

		qBoxL.setBounds(165 +119*(currentPane-1), 187, 100, 148);
		lblProgress.setText((currentPane + " of " + totalPanes));
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
