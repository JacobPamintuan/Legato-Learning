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

	Quiz q = Initialize.testQuiz;

	public QuizTemplate() {

		initialize();
	}

	private int[] ansKey = q.getAnsKey();
	public boolean[] answeredCorrect = q.getAnsweredCorrect();

	public JPanel QuizPane;

	private String course = q.getCourse();

	private String difficulty = q.getDifficulty();
	private int quizNumber = q.getQuizNumber();

	private int currentPane = q.getCurrentPane();
	private int totalPanes = q.getTotalPanes();

	private String questionTitle = q.getQuestionTitle();

	private JLabel lblTitle;
	private JLabel lblCourse;
	private JLabel lblDifficulty;
	private JLabel lblLesson;
	private JLabel chevron = new JLabel();
	private JLabel lblProgress;
	private JLabel questionImage;
	
	private int[] numTries = q.getNumWrong();

	JButton[] btnAnswers = new JButton[4];
	JLabel[][] lblAnswers = new JLabel[4][2];
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

	public void resetQBox() {
		for (int i = 0; i < 4; i++) {
			btnAnswers[i].setIcon(ansBox);
		}
	}

	public void actionListenerQBox(boolean bool) {
		if (bool)
			for (int i = 0; i < 4; i++)
				btnAnswers[i].addActionListener(this);
		else
			for (int i = 0; i < 4; i++)

				btnAnswers[i].removeActionListener(this);

	}

	private void initialize() {
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

		lblLesson = new JLabel("Quiz " + quizNumber);
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
			btnAnswers[i] = new JButton(ansBox);
			// answers[i].setIcon(ansBox);
			btnAnswers[i].setBounds(65 + i * 265, 390, 220, 290);
			btnAnswers[i].addActionListener(this);

			lblAnswers[i][0] = new JLabel(); // Image
//			if(!(q.getAnswersImage()[currentPane-1][i]))
			
			lblAnswers[i][0].setIcon((q.getAnswersImage()[currentPane-1][i])); System.out.println("QT " + i +" "+q.getAnswersImage()[currentPane-1][i]);
			lblAnswers[i][0].setBounds((65 + i * 265), 390, 220, 190);
			lblAnswers[i][0].setHorizontalAlignment(SwingConstants.CENTER);

			lblAnswers[i][1] = new JLabel(); // Text
			lblAnswers[i][1].setText(q.getAnswersText()[currentPane - 1][i]);

			if (q.getAnswersImage()[currentPane-1][i]== null && q.getAnswersText()[i] != null) { // if no image and is text

				// Centers and sets text
				lblAnswers[i][1].setHorizontalAlignment(SwingConstants.CENTER);
				lblAnswers[i][1].setVerticalAlignment(SwingConstants.CENTER);
				lblAnswers[i][1].setFont(Fonts.TITLE2);
				lblAnswers[i][1].setBounds(65 + i * 265, 390, 220, 290);

			} else if (q.getAnswersImage()[currentPane-1][i] != null && q.getAnswersText()[currentPane-1][i] == (null)) { // if is image and no next
	
				// Centers image
				lblAnswers[i][0].setVerticalAlignment(SwingConstants.CENTER);
				lblAnswers[i][0].setBounds((65 + i * 265), 390, 220, 290);
				lblAnswers[i][0].setHorizontalAlignment(SwingConstants.CENTER);
				
			} else if (q.getAnswersImage()[currentPane-1][i] != null && q.getAnswersText()[i] != null) { // if is image and is text
				// Formats image on top half
				lblAnswers[i][0].setBounds((65 + i * 265), 390, 220, 190);
				lblAnswers[i][0].setHorizontalAlignment(SwingConstants.CENTER);
				
				// Formats text on bottom half
				lblAnswers[i][1].setHorizontalAlignment(SwingConstants.CENTER);
				lblAnswers[i][1].setFont(Fonts.SUBHEADING);
				lblAnswers[i][1].setBounds(65 + i * 265, 580, 220, 100);
			}

			QuizPane.add(lblAnswers[i][0]);
			QuizPane.add(lblAnswers[i][1]);
			QuizPane.add(btnAnswers[i]);
		}

		qBoxL = new JLabel();
		qBoxL.setIcon(qBox);
		qBoxL.setBounds(165 + 119 * (currentPane - 1), 187, 100, 148);
		QuizPane.add(qBoxL);

		lblProgress = new JLabel("Question " + currentPane + " of " + totalPanes);
		lblProgress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProgress.setBounds(795, 64, 280, 40);
		lblProgress.setFont(Fonts.HEADING);
		lblProgress.setForeground(Colours.purp);
		QuizPane.add(lblProgress);

		questionImage = new JLabel();
		questionImage.setVerticalAlignment(SwingConstants.TOP);
		questionImage
				.setIcon(new ImageIcon("/Users/jacobpamintuan/Desktop/ICS4U1/Music Theory App/images/Melodic.png"));
		questionImage.setBounds(65, 185, 1020, 193);
		QuizPane.add(questionImage);

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
			// System.out.println("Start Quiz");
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

		if (lblNext.isEnabled() && press == lblNext && currentPane != totalPanes) {
			currentPane++;
			lblNext.setEnabled(false);
			lblSkip.setEnabled(true);
			actionListenerQBox(true);
		}

		for (int i = 0; i < 4; i++)
			lblAnswers[i][1].setText(q.getAnswersText()[currentPane - 1][i]);

		qBoxL.setBounds(165 + 119 * (currentPane - 1), 187, 100, 148);
		lblProgress.setText((currentPane + " of " + totalPanes));

		resetQBox();

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
		JButton btn = ((JButton) e.getSource());
		btnAnswers[ansKey[currentPane - 1]].setIcon(correct);
		if (btn == btnAnswers[ansKey[currentPane - 1]]) {
			System.out.println("Correct");
			answeredCorrect[currentPane - 1] = true;
		} else {
			btn.setIcon(incorrect);
			System.out.println("Incorrect");
			numTries[currentPane-1]++;
		}

		for(int i=0;i<6;i++)System.out.print(numTries[i]+", ");
		System.out.println();
		
		actionListenerQBox(false);

		lblNext.setEnabled(true);
		lblSkip.setEnabled(false);

	}

}
