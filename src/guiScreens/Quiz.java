package guiScreens;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Quiz  {

	private int[] numWrong;
	private int[] ansKey;
	private boolean[] answeredCorrect;

	public JPanel QuizPane;

	private String course;

	private String difficulty;
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

	public Quiz(String line) {
		/*
    super(course, difficulty);

		this.course = course;
		this.difficulty = difficulty;
		this.questionTitle = questionTitle;
		this.quizNumber = quizNumber;
		this.currentPane = currentPane;
		this.totalPanes = totalPanes;
		this.ansKey = ansKey;
		this.answeredCorrect = answeredCorrect;
		this.numWrong = numWrong;
		this.questionImage = questionImage;
		this.answersImage = answersImage;
		this.answersText = answersText;
    */
	System.out.println("Constructor:" +line);
    loadData(line);
	}
	
	//static Quiz[] QUIZZES = new String[2];

	private void loadData(String line) {
		//BufferedReader br = new BufferedReader(new java.io.FileReader(new File("Files/Data.txt")));

/*
		for (int i = 0; i < 2; i++) {
			QUIZZES[i] = br.readLine();
		}
    */

		System.out.println("Load data: "+line);
		String[] str = line.trim().split(";");

		for (int i = 0; i < str.length; i++)
			System.out.println(str[i]);

		String course = str[0];
		String difficulty = str[1];
		String questionTitle = str[2];
		int quizNumber = Integer.parseInt(str[3]);
		int currentPane = Integer.parseInt(str[4]);
		int totalPanes = Integer.parseInt(str[5]);

		String[] ans = str[6].trim().split(",");
		int[] ansKey = new int[totalPanes];

		String[] bool = str[7].trim().split(",");
		boolean[] answeredCorrect = new boolean[totalPanes];

		String[] wrong = str[8].trim().split(",");
		int[] numWrong = new int[totalPanes];
		for (int i = 0; i < totalPanes; i++) {
			ansKey[i] = Integer.parseInt(ans[i]);
			answeredCorrect[i] = Boolean.parseBoolean(bool[i]);
			numWrong[i] = Integer.parseInt(wrong[i]);
		}

		ImageIcon questionImage = new ImageIcon(str[9]);

		String[] ansImages = str[10].trim().split(":");
		ImageIcon[][] answersImage = new ImageIcon[totalPanes][4];

		String[] answers = str[11].trim().split(":");
		String[][] answersText = new String[totalPanes][4];

		for (int i = 0; i < totalPanes; i++) {
			System.out.println(answers[i]);//
		}

		for (int i = 0; i < totalPanes; i++) {
			String[] temp = answers[i].trim().split(",");
			String[] Temp = ansImages[i].trim().split(",");
			for (int j = 0; j < 4; j++) {
				if(temp[j].equalsIgnoreCase("null"))
					answersText[i][j] =null;
				else {
					answersText[i][j] = temp[j];
				}
				if (Temp[j].equalsIgnoreCase("null")) {
					answersImage[i][j] = null;
					System.out.println("NULL IMAGE");
				}

				else {
					answersImage[i][j] = new ImageIcon(Temp[j]);// Temp[j]);
					System.out.println("Valiud IMAGE " + Temp[j]);
				}
			}

		}

		for (int i = 0; i < totalPanes; i++) {

			for (int j = 0; j < 4; j++) {
				System.out.println(answersText[i][j]);
				System.out.println(answersImage[i][j]);
			}

			System.out.println();
		}
		//br.close();
		this.course = course;
		this.difficulty = difficulty;
		this.questionTitle = questionTitle;
		this.quizNumber = quizNumber;
		this.currentPane = currentPane;
		this.totalPanes = totalPanes;
		this.ansKey = ansKey;
		this.answeredCorrect = answeredCorrect;
		this.numWrong = numWrong;
		this.questionImage = questionImage;
		this.answersImage = answersImage;
		this.answersText = answersText;
		//return new Quiz(course, diff, q, lessonNum, currPane, numQ, ansKey, correct, numWrong, qImage, ansArr, ansText);
	}

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



//package guiScreens;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.IOException;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//public class Quiz {
//
//	public Quiz(String course, String difficulty, String questionTitle, int quizNumber, int currentPane, int totalPanes,
//			int[] ansKey, boolean[] answeredCorrect, int[] numWrong, ImageIcon questionImage,
//			ImageIcon[][] answersImage, String[][] answersText) {
//		//super(course, difficulty);
//
//		this.course = course;
//		this.difficulty = difficulty;
//		this.questionTitle = questionTitle;
//		this.quizNumber = quizNumber;
//		this.currentPane = currentPane;
//		this.totalPanes = totalPanes;
//		this.ansKey = ansKey;
//		this.answeredCorrect = answeredCorrect;
//		this.numWrong = numWrong;
//		this.questionImage = questionImage;
//		this.answersImage = answersImage;
//		this.answersText = answersText;
//
//	}
//	
//	
//
//	private int[] numWrong;
//	private int[] ansKey;
//	private boolean[] answeredCorrect;
//
//	public JPanel QuizPane;
//
//	private String course;
//
//	private String difficulty;
//	private int quizNumber = 1;
//
//	private int currentPane = 1;
//	private int totalPanes = 6;
//
//	private String questionTitle;
//
//	private ImageIcon questionImage;
//	private ImageIcon[][] answersImage;
//	private String[][] answersText;
//
//	JButton[] btnAnswers = new JButton[4];
//	JLabel[][] lblAnswers = new JLabel[4][2];
//	JLabel qBoxL;
//
//	public boolean[] getAnsweredCorrect() {
//		return answeredCorrect;
//	}
//
//	public void setAnsweredCorrect(boolean[] answeredCorrect) {
//		this.answeredCorrect = answeredCorrect;
//	}
//
//	public String getCourse() {
//		return course;
//	}
//
//	public void setCourse(String course) {
//		this.course = course;
//	}
//
//	public String getDifficulty() {
//		return difficulty;
//	}
//
//	public void setDifficulty(String difficulty) {
//		this.difficulty = difficulty;
//	}
//
//	public int getQuizNumber() {
//		return quizNumber;
//	}
//
//	public void setQuizNumber(int quizNumber) {
//		this.quizNumber = quizNumber;
//	}
//
//	public int getCurrentPane() {
//		return currentPane;
//	}
//
//	public void setCurrentPane(int currentPane) {
//		this.currentPane = currentPane;
//	}
//
//	public int getTotalPanes() {
//		return totalPanes;
//	}
//
//	public void setTotalPanes(int totalPanes) {
//		this.totalPanes = totalPanes;
//	}
//
//	public String getQuestionTitle() {
//		return questionTitle;
//	}
//
//	public void setQuestionTitle(String questionTitle) {
//		this.questionTitle = questionTitle;
//	}
//
//	public ImageIcon getQuestionImage() {
//		return questionImage;
//	}
//
//	public void setQuestionImage(ImageIcon questionImage) {
//		this.questionImage = questionImage;
//	}
//
//	public ImageIcon[][] getAnswersImage() {
//		return answersImage;
//	}
//
//	public void setAnswersImage(ImageIcon[][] answersImage) {
//		this.answersImage = answersImage;
//	}
//
//	public String[][] getAnswersText() {
//		return answersText;
//	}
//
//	public void setAnswersText(String[][] answersText) {
//		this.answersText = answersText;
//	}
//
//	public int[] getAnsKey() {
//		return ansKey;
//	}
//
//	public void setAnsKey(int[] ansKey) {
//		this.ansKey = ansKey;
//	}
//
//	public int[] getNumWrong() {
//		return numWrong;
//	}
//
//	public void setNumWrong(int[] numWrong) {
//		this.numWrong = numWrong;
//	}
//
//}
