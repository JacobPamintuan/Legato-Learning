package guiScreens;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class QuizTemplate implements ActionListener, MouseListener {
//	Quiz q;// = Initialize.quizArr[2];
	Quiz q;

	public QuizTemplate() {
		initializeGUI();

	}

	public QuizTemplate(int num) {
		Quiz quiz = Initialize.quizArr[num];
		q = quiz;
		initializeObject();
		initializeGUI();
	}

	private void initializeObject() {
		course = q.getCourse();

		difficulty = q.getDifficulty();
		quizNumber = q.getQuizNumber();

		currentPane = q.getCurrentPane();
		totalPanes = q.getTotalPanes();

		questionTitle = q.getQuestionTitle();
		qImage = q.getQuestionImage();

		numTries = q.getNumWrong();
		ansKey = q.getAnsKey();
		answeredCorrect = q.getAnsweredCorrect();
	}

	private int[] ansKey;// = q.getAnsKey();
	public boolean[] answeredCorrect;// = q.getAnsweredCorrect();

	private String course;// = q.getCourse();

	private String difficulty;// = q.getDifficulty();
	private int quizNumber;// = q.getQuizNumber();

	private int currentPane;// = q.getCurrentPane();
	private int totalPanes;// = q.getTotalPanes();

	private String questionTitle;// = q.getQuestionTitle();
	private ImageIcon qImage;// = q.getQuestionImage();

	private int[] numTries;// = q.getNumWrong();

	public JPanel QuizPane;
	private JLabel lblTitle;
	private JLabel lblCourse;
	private JLabel lblDifficulty;
	private JLabel lblLesson;
	private JLabel chevron = new JLabel();
	private JLabel lblProgress;
	private JLabel lblQuestionImage;

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

	private void initializeGUI() {
		QuizPane = new JPanel();
		QuizPane.setBounds(300, 0, 1140, 810);
		QuizPane.setBackground(Color.white);
		QuizPane.setLayout(null);
		Frame.frame.getContentPane().add(QuizPane);

		lblTitle = new JLabel(questionTitle);
		lblTitle.setBounds(65, 130, 995, 55);
		lblTitle.setFont(Fonts.TITLE1);
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

			lblAnswers[i][0].setIcon((q.getAnswersImage()[currentPane - 1][i]));
			System.out.println("QT " + i + " " + q.getAnswersImage()[currentPane - 1][i]);
			lblAnswers[i][0].setBounds((65 + i * 265), 390, 220, 190);
			lblAnswers[i][0].setHorizontalAlignment(SwingConstants.CENTER);

			lblAnswers[i][1] = new JLabel(); // Text
			lblAnswers[i][1].setText(q.getAnswersText()[currentPane - 1][i]);

			if (q.getAnswersImage()[currentPane - 1][i] == null && q.getAnswersText()[i] != null) { // if no image and
																									// is text

				// Centers and sets text
				lblAnswers[i][1].setHorizontalAlignment(SwingConstants.CENTER);
				lblAnswers[i][1].setVerticalAlignment(SwingConstants.CENTER);
				lblAnswers[i][1].setFont(Fonts.TITLE2);
				lblAnswers[i][1].setBounds(65 + i * 265, 390, 220, 290);

			} else if (q.getAnswersImage()[currentPane - 1][i] != null
					&& q.getAnswersText()[currentPane - 1][i] == (null)) { // if is image and no next

				// Centers image
				lblAnswers[i][0].setVerticalAlignment(SwingConstants.CENTER);
				lblAnswers[i][0].setBounds((65 + i * 265), 390, 220, 290);
				lblAnswers[i][0].setHorizontalAlignment(SwingConstants.CENTER);

			} else if (q.getAnswersImage()[currentPane - 1][i] != null && q.getAnswersText()[i] != null) { // if is
																											// image and
																											// is text
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

		lblQuestionImage = new JLabel();
		lblQuestionImage.setVerticalAlignment(SwingConstants.TOP);
		lblQuestionImage.setIcon(qImage);
		lblQuestionImage.setBounds(65, 185, 1020, 193);
		QuizPane.add(lblQuestionImage);

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

		boolean skipEn = lblSkip.isEnabled();
		boolean nextEn = lblNext.isEnabled();

		boolean last = false;
		boolean fin = false;

		if (answeredCorrect[totalPanes - 1])
			last = true;

		int curr = currentPane;

//		if (press == lblSkip && currentPane != 1)
//			currentPane--;
//		if (lblSkip.isEnabled() && press == lblSkip && currentPane != totalPanes) {
//			currentPane++;
//			while (answeredCorrect[currentPane - 1]) {
//				if (currentPane != totalPanes)
//					currentPane++;
//				else
//					break;
//			}
//		}
//		
//		if (lblNext.isEnabled() && press == lblNext && currentPane != totalPanes) {
//			currentPane++;
//			while (answeredCorrect[currentPane - 1]) {
//				if (currentPane != totalPanes)
//					currentPane++;
//				else
//					break;
//			}
//
//			lblNext.setEnabled(false);
//			lblSkip.setEnabled(true);
//			actionListenerQBox(true);
//		}

		if (((nextEn && press == lblNext) || (skipEn && press == lblSkip)) && currentPane != totalPanes) {
			currentPane++;
			while (answeredCorrect[currentPane - 1]) {
				if (currentPane != totalPanes)
					currentPane++;
				else
					break;
			}

			if (press == lblNext) {
				lblNext.setEnabled(false);
				lblSkip.setEnabled(true);
				actionListenerQBox(true);
			}
		}

//		System.out.println("\nQuestion " + currentPane + "\n");
//		if (((nextEn && press == lblNext) || (skipEn && press == lblSkip)) && currentPane == totalPanes||curr==totalPanes) {// &&
		// answeredCorrect[totalPanes
		// - 1]) {

		if (curr == totalPanes && ((nextEn && press == lblNext) || (skipEn && press == lblSkip)) || last) {
//			boolean bool = true;

			System.out.println("\nCALLED\n");
			int num = -1;
			for (int i = 0; i < totalPanes; i++) {
				if (answeredCorrect[i] == false) {
//					bool = false;
					num = i;
					break;
				}
			}

			System.out.println("num: " + num);
			if (num != -1) {
				currentPane = num + 1;
				actionListenerQBox(true);
				System.out.println("\nQuestion " + currentPane + " incorrect\n");
			} else if (last || num == -1) {
				System.out.println("Final:");
				displayTries();
//fin=true;		

				lblQuestionImage.setIcon(new ImageIcon("images/TEST.png"));

				actionListenerQBox(false);
			}

		}

//		System.out.println("\nQuestion " + currentPane + "\n");
		for (int i = 0; i < 4; i++) {
			lblAnswers[i][1].setText(q.getAnswersText()[currentPane - 1][i]);
			lblAnswers[i][0].setIcon(q.getAnswersImage()[currentPane - 1][i]);
		}

		qBoxL.setBounds(165 + 119 * (currentPane - 1), 187, 100, 148);
		lblProgress.setText(("Question " + currentPane + " of " + totalPanes));

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
			numTries[currentPane - 1]++;
		}

		displayTries();

		actionListenerQBox(false);

		lblNext.setEnabled(true);
		lblSkip.setEnabled(false);

	}

	private void displayTries() {
		for (int i = 0; i < totalPanes; i++)
			System.out.print(numTries[i] + ", ");
		System.out.println();
		for (int i = 0; i < totalPanes; i++)
			System.out.print(answeredCorrect[i] + ", ");
		System.out.println();
	}

}