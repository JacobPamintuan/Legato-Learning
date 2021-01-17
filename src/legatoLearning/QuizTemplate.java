package legatoLearning;

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
import javax.swing.JOptionPane;

public class QuizTemplate implements ActionListener, MouseListener {

	// Fields
	public Quiz q;

	private int[] ansKey;
	public boolean[] answeredCorrect;

	private String course;

	private String difficulty;
	private int quizNumber;

	private int currentPane;
	private int totalPanes;

	private String questionTitle;
	private ImageIcon qImage;

	private int[] numTries;

	private boolean completed;

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

	// Constructor
	// int parameter - initializes specific quiz within quizArr
	// Initializes Quiz "q" object
	// Calls methods to initialize fields and create GUI
	public QuizTemplate(int num) {
		this.q = Initialize.quizArr[num];
		initializeFields();
		initializeGUI();
	}

	// Initializes fields
	private void initializeFields() {
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

		completed = q.isCompleted();
	}

	// Create GUI
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

		lblCourse = new JLabel("<html><u>" + course + "<u><html>");
		lblCourse.addMouseListener(this);
		lblCourse.setBounds(65, 25, 190, 30);
		lblCourse.setFont(Fonts.BREADCRUMBS);
		QuizPane.add(lblCourse);

		lblDifficulty = new JLabel(difficulty);
		lblDifficulty.setBounds(65, 65, 200, 40);
		lblDifficulty.setFont(Fonts.HEADING);
		QuizPane.add(lblDifficulty);

		chevron.setIcon(new ImageIcon("images/chevron.png"));
		chevron.setBounds(215 + shiftX(), 69, 32, 32);
		QuizPane.add(chevron);

		lblLesson = new JLabel("Quiz " + quizNumber);
		lblLesson.setBounds(255 + shiftX(), 65, 450, 40);
		lblLesson.setFont(Fonts.HEADING);
		QuizPane.add(lblLesson);

		for (int i = 0; i < 4; i++) {
			btnAnswers[i] = new JButton(ansBox);
			btnAnswers[i].setBounds(65 + i * 265, 390, 220, 290);
			btnAnswers[i].addActionListener(this);

			lblAnswers[i][0] = new JLabel(); // Image

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
				lblAnswers[i][1].setFont(Fonts.TITLE1);
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
				lblAnswers[i][1].setFont(Fonts.SUBHEADING1);
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
		lblSkip.setIcon(new ImageIcon("images/Skip.png"));
		lblSkip.setBounds(253, 712, 195, 55);
		lblSkip.addMouseListener(this);
		QuizPane.add(lblSkip);

		lblNext = new JLabel("Next");
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

	private void resetQBox() {
		for (int i = 0; i < 4; i++) {
			btnAnswers[i].setIcon(ansBox);
		}
	}

	private void actionListenerQBox(boolean bool) {
		if (bool)
			for (int i = 0; i < 4; i++)
				btnAnswers[i].addActionListener(this);
		else
			for (int i = 0; i < 4; i++)

				btnAnswers[i].removeActionListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		JLabel press = (JLabel) e.getSource();

		if (press == lblCourse) {
			QuizPane.setVisible(false);
			Initialize.iCourse.iCoursePane.setVisible(true);
			return;
		}

		boolean skipEn = lblSkip.isEnabled();
		boolean nextEn = lblNext.isEnabled();

		boolean last = false;

		if (answeredCorrect[totalPanes - 1])
			last = true;

		int curr = currentPane;

		if (press == lblNext) {
			lblNext.setEnabled(false);
			lblSkip.setEnabled(true);
			actionListenerQBox(true);
		}

		if (((nextEn && press == lblNext) || (skipEn && press == lblSkip)) && currentPane != totalPanes) {
			currentPane++;
			while (answeredCorrect[currentPane - 1]) {
				if (currentPane != totalPanes)
					currentPane++;
				else
					break;
			}

		}

		if (curr == totalPanes && ((nextEn && press == lblNext) || (skipEn && press == lblSkip)) || last) {

			System.out.println("\nCALLED\n");
			int num = -1;
			for (int i = 0; i < totalPanes; i++) {
				if (answeredCorrect[i] == false) {
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
				completed = true;
				q.setCompleted(true);
				currentPane = 0;
				q.saveQuiz();

				Initialize.iCourse.quizCompleted();

				if (popup() == JOptionPane.YES_OPTION)
					QuizPane.setVisible(false);

				Initialize.iCourse.iCoursePane.setVisible(true);
				QuizPane.setVisible(false);

				actionListenerQBox(false);
				return;
			}

		}

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

	private int popup() {

		Object[] ob = { "Back to Course" };

		return JOptionPane.showOptionDialog(QuizPane,
				"Congratulations! You have completed " + course + "; " + difficulty + ", Quiz " + quizNumber,
				"Quiz Complete!", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("images/Legato Learning.png"), ob, null);

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