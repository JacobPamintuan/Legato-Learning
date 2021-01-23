package legatoLearning;

import java.awt.Color;
import java.awt.Cursor;
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

/*
 * Quiz GUI template class
 * Template GUI for all quizzes
 * Initializes JComponents through quiz object values
 * Keeps track of right and wrong answers
 * Updates Results screen once quiz complete
 * Displays correct answer
 * Accessible from Interval Course page
 */

public class QuizTemplate implements ActionListener, MouseListener {

	// Fields
	public Quiz q;

	// Data fields
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

	private int sumWrong;

	// GUI Fields
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


	// Constructor with quiz parameter
	// Initializes Quiz "q" object
	// Calls methods to initialize fields and create GUI
	public QuizTemplate(Quiz quiz) {
		
		this.q = quiz;
		
		initializeFields();
		initializeGUI();
		
	}

	// Constructor
	// int parameter - initializes specific quiz within quizArr
	// Initializes Quiz "q" object
	// Calls methods to initialize fields and create GUI
	public QuizTemplate(int num) {
		
		this.q = Initialize.quizArr[num];
		
		initializeFields();
		initializeGUI();
		
	}

	// Initializes data fields
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
	// Initialize GUI fields
	private void initializeGUI() {
		// JPanel setup
		QuizPane = new JPanel();
		QuizPane.setBounds(300, 0, 1140, 810);
		QuizPane.setBackground(Color.white);
		QuizPane.setLayout(null);
		Frame.frame.getContentPane().add(QuizPane);

		// Final JLabels
		lblTitle = new JLabel(questionTitle);
		lblTitle.setBounds(65, 130, 995, 55);
		lblTitle.setFont(Fonts.TITLE1);
		lblTitle.setForeground(Colours.purple);
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

		// Answer options
		for (int i = 0; i < 4; i++) {

			// Create answer button
			btnAnswers[i] = new JButton(ansBox);
			btnAnswers[i].setBounds(65 + i * 265, 390, 220, 290);
			btnAnswers[i].addActionListener(this);

			lblAnswers[i][0] = new JLabel(); // Image

			lblAnswers[i][0].setIcon((q.getAnswersImage()[currentPane - 1][i]));
			lblAnswers[i][0].setBounds((65 + i * 265), 390, 220, 190);
			lblAnswers[i][0].setHorizontalAlignment(SwingConstants.CENTER);

			lblAnswers[i][1] = new JLabel(); // Text
			lblAnswers[i][1].setText(q.getAnswersText()[currentPane - 1][i]);

			// if no image and is text
			if (q.getAnswersImage()[currentPane - 1][i] == null && q.getAnswersText()[i] != null) {
				// Centers and sets text
				lblAnswers[i][1].setHorizontalAlignment(SwingConstants.CENTER);
				lblAnswers[i][1].setVerticalAlignment(SwingConstants.CENTER);
				lblAnswers[i][1].setFont(Fonts.TITLE1);
				lblAnswers[i][1].setBounds(65 + i * 265, 390, 220, 290);

				
			} 
			
			// if is image and no text
			else if (q.getAnswersImage()[currentPane - 1][i] != null
					&& q.getAnswersText()[currentPane - 1][i] == (null)) {

				// Centers image
				lblAnswers[i][0].setVerticalAlignment(SwingConstants.CENTER);
				lblAnswers[i][0].setBounds((65 + i * 265), 390, 220, 290);
				lblAnswers[i][0].setHorizontalAlignment(SwingConstants.CENTER);

				
			} 
			
			// if is image and is text
			else if (q.getAnswersImage()[currentPane - 1][i] != null && q.getAnswersText()[i] != null) { 
				// Formats image on top half
				lblAnswers[i][0].setBounds((65 + i * 265), 390, 220, 190);
				lblAnswers[i][0].setHorizontalAlignment(SwingConstants.CENTER);

				// Formats text on bottom half
				lblAnswers[i][1].setHorizontalAlignment(SwingConstants.CENTER);
				lblAnswers[i][1].setFont(Fonts.SUBHEADING1);
				lblAnswers[i][1].setBounds(65 + i * 265, 580, 220, 100);
			}

			// Add to pane
			QuizPane.add(lblAnswers[i][0]);
			QuizPane.add(lblAnswers[i][1]);
			QuizPane.add(btnAnswers[i]);
		}

		// Current question box - highlights current question
		qBoxL = new JLabel();
		qBoxL.setIcon(qBox);
		qBoxL.setBounds(165 + 119 * (currentPane - 1), 187, 100, 148);
		QuizPane.add(qBoxL);

		// Progress of questions
		lblProgress = new JLabel("Question " + currentPane + " of " + totalPanes);
		lblProgress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProgress.setBounds(795, 64, 280, 40);
		lblProgress.setFont(Fonts.HEADING);
		lblProgress.setForeground(Colours.purple);
		QuizPane.add(lblProgress);

		// Question Image
		lblQuestionImage = new JLabel();
		lblQuestionImage.setVerticalAlignment(SwingConstants.TOP);
		lblQuestionImage.setIcon(qImage);
		lblQuestionImage.setBounds(65, 185, 1020, 193);
		QuizPane.add(lblQuestionImage);

		// Skip and next "Buttons" - JLabel with mouse listener
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

	// X-value in pixels to shift chevron and lesson name
	private int shiftX() {
		
		if (difficulty.equals("Beginner"))
			return 0;
		else if (difficulty.equals("Advanced"))
			return 10;
		else if (difficulty.equals("Intermediate"))
			return 50;
		
		return -1;
	}

	// Reset choices to all unselected
	private void resetQBox() {
		for (int i = 0; i < 4; i++) {
			btnAnswers[i].setIcon(ansBox);
		}
	}

	// Disable actionListener on specific question 
	// (Until user moves to next question)
	private void actionListenerQBox(boolean bool) {
		if (bool)
			for (int i = 0; i < 4; i++)
				btnAnswers[i].addActionListener(this);
		else
			for (int i = 0; i < 4; i++)

				btnAnswers[i].removeActionListener(this);

	}
	
	// Quiz results popup
	private int popup() {

		Object[] ob = { "Back to Course", "See results" };

		String message = "Congratulations! You have completed: \n" + course + "; " + difficulty + ", Quiz " + quizNumber
				+ ".\nOn your first try you got a score of " + q.getStringScore();

		return JOptionPane.showOptionDialog(QuizPane, message, "Quiz Complete!", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, ob, null);

	}

	
	// Event Handlers
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		JLabel press = (JLabel) e.getSource();

		// Go back to course
		if (press == lblCourse) {
			QuizPane.setVisible(false);
			Initialize.iCourse.iCoursePane.setVisible(true);
			return;
		}

		// Save state of 'buttons'
		boolean skipEn = lblSkip.isEnabled();
		boolean nextEn = lblNext.isEnabled();
		
		// Get current pane/question
		int curr = currentPane;

		// Last question boolean
		boolean last = false;

		// If last question is correct, set boolean true
		if (answeredCorrect[totalPanes - 1])
			last = true;

		if (press == lblNext) {
			lblNext.setEnabled(false);
			lblSkip.setEnabled(true);
			actionListenerQBox(true); // Enable choice buttons
		}

		
		if (((nextEn && press == lblNext) || (skipEn && press == lblSkip)) && currentPane != totalPanes) {
			currentPane++;
			while (answeredCorrect[currentPane - 1]) { // Skips over already correct questions
				if (currentPane != totalPanes)
					currentPane++;
				else
					break;
			}

		}

		// If on last question - check for incorrect questions
		if (curr == totalPanes && ((nextEn && press == lblNext) || (skipEn && press == lblSkip)) || last) {

			int num = -1;
			
			// Finds first incorrect question
			for (int i = 0; i < totalPanes; i++) {
				
				if (answeredCorrect[i] == false) {
					
					num = i;
					
					break;
				}
			}

			// Display first incorrect question
			if (num != -1) {
			
				currentPane = num + 1;
				
				actionListenerQBox(true);
			
			}
			
			// If the last question is correct, or there are no incorrect questions
			else if (last || num == -1) {
				
				completed = true;
				q.setCompleted(true);
				
				currentPane = 0;
				
				// Save quiz - file overwrite
				q.saveQuiz();

				// Sends quiz results to results pane
				Initialize.results.updateChart(Initialize.results.currentFilter);
				Initialize.iCourse.quizCompleted();

				// Check if all quizzes are complete
				Initialize.iCourse.courseComplete();

				// Popup - back to course page or see results
				if (popup() == JOptionPane.YES_OPTION)
					Initialize.iCourse.iCoursePane.setVisible(true);
				else
					Initialize.results.resultsPane.setVisible(true);

				// Hide quiz
				QuizPane.setVisible(false);

				// Disable buttons
				actionListenerQBox(false);
				
				return;// Do not run the rest:
			}

		}

		// Load next question
		for (int i = 0; i < 4; i++) {
			lblAnswers[i][1].setText(q.getAnswersText()[currentPane - 1][i]);
			lblAnswers[i][0].setIcon(q.getAnswersImage()[currentPane - 1][i]);
		}

		// Move question highlight box
		qBoxL.setBounds(165 + 119 * (currentPane - 1), 187, 100, 148);
		lblProgress.setText(("Question " + currentPane + " of " + totalPanes));

		// Set all buttons to unselected
		resetQBox();

	}
	
	// Event Handlers

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JLabel lbl = (JLabel) e.getSource();

		// Enter hover state - Color and cursor change
		lbl.setForeground(Colours.purple);
		lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));

	}

	@Override
	public void mouseExited(MouseEvent e) {
		JLabel lbl = (JLabel) e.getSource();

		// Exit hover state - Color and cursor change
		lbl.setForeground(Color.BLACK);
		lbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

	}

	// When choice is selected
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton btn = ((JButton) e.getSource());
		
		// Set the correct answer to "correct" icon - Turns green
		btnAnswers[ansKey[currentPane - 1]].setIcon(correct);
		
		// If answer is correct, set answerCorrect boolean to true
		if (btn == btnAnswers[ansKey[currentPane - 1]]) {
			
			answeredCorrect[currentPane - 1] = true;
			
		} else {
			
			// Answer is incorrect
			// Set button to "incorrect" icon - Turns red
			btn.setIcon(incorrect);
			numTries[currentPane - 1]++;
			
		}

		// Disable all buttons (ensure user cannot change their answer)
		actionListenerQBox(false);

		// Set 'Buttons' 
		lblNext.setEnabled(true);
		lblSkip.setEnabled(false);

	}

}
