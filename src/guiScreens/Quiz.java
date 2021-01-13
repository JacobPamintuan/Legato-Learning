package guiScreens;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Quiz extends LessonPlan {

	public Quiz(String course, String difficulty, String questionTitle, int quizNumber, int currentPane, int totalPanes,
			int[] ansKey, boolean[] answeredCorrect, int[]numWrong,ImageIcon questionImage, ImageIcon[][] answersImage,
			String[][] answersText) {
		super(course, difficulty);

		this.course = course;
		this.difficulty = difficulty;
		this.questionTitle = questionTitle;
		this.quizNumber = quizNumber;
		this.currentPane = currentPane;
		this.totalPanes = totalPanes;
		this.ansKey = ansKey;
		this.answeredCorrect = answeredCorrect;
		this.numWrong=numWrong;
		this.questionImage = questionImage;
		this.answersImage = answersImage;
		this.answersText = answersText;

	}

	private int[] numWrong;
	private int[] ansKey;
	private boolean[] answeredCorrect;

	public JPanel QuizPane;

	private String course;

	private String difficulty ;
	private int quizNumber = 1;

	private int currentPane = 1;
	private int totalPanes = 6;

	private String questionTitle;

	private ImageIcon questionImage;
	private ImageIcon[][] answersImage;
	private String[][] answersText;

	JButton[] btnAnswers = new JButton[4];
	JLabel[][] lblAnswers = new JLabel[4][2];
	JLabel qBoxL;

	public boolean[] getAnsweredCorrect() {
		return answeredCorrect;
	}

	public void setAnsweredCorrect(boolean[] answeredCorrect) {
		this.answeredCorrect = answeredCorrect;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public int getQuizNumber() {
		return quizNumber;
	}

	public void setQuizNumber(int quizNumber) {
		this.quizNumber = quizNumber;
	}

	public int getCurrentPane() {
		return currentPane;
	}

	public void setCurrentPane(int currentPane) {
		this.currentPane = currentPane;
	}

	public int getTotalPanes() {
		return totalPanes;
	}

	public void setTotalPanes(int totalPanes) {
		this.totalPanes = totalPanes;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public ImageIcon getQuestionImage() {
		return questionImage;
	}

	public void setQuestionImage(ImageIcon questionImage) {
		this.questionImage = questionImage;
	}

	public ImageIcon[][] getAnswersImage() {
		return answersImage;
	}

	public void setAnswersImage(ImageIcon[][] answersImage) {
		this.answersImage = answersImage;
	}

	public String[][] getAnswersText() {
		return answersText;
	}

	public void setAnswersText(String[][] answersText) {
		this.answersText = answersText;
	}

	public int[] getAnsKey() {
		return ansKey;
	}

	public void setAnsKey(int[] ansKey) {
		this.ansKey = ansKey;
	}

	public int[] getNumWrong() {
		return numWrong;
	}

	public void setNumWrong(int[] numWrong) {
		this.numWrong = numWrong;
	}

}
