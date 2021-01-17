package legatoLearning;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;

public class Quiz {

	private int[] numWrong;
	private int[] ansKey;
	private boolean[] answeredCorrect;

	private String course;

	private String difficulty;
	private int quizNumber = 1;

	private int currentPane = 1;
	private int totalPanes = 6;

	private String questionTitle;

	private ImageIcon questionImage;
	private ImageIcon[][] answersImage;
	private String[][] answersText;

	private boolean completed;

	private String data;


	public Quiz(String line) {
		/*
		 * super(course, difficulty);
		 * 
		 * this.course = course; this.difficulty = difficulty; this.questionTitle =
		 * questionTitle; this.quizNumber = quizNumber; this.currentPane = currentPane;
		 * this.totalPanes = totalPanes; this.ansKey = ansKey; this.answeredCorrect =
		 * answeredCorrect; this.numWrong = numWrong; this.questionImage =
		 * questionImage; this.answersImage = answersImage; this.answersText =
		 * answersText;
		 */
		// System.out.println("Constructor:" +line);
		this.data = line;
		loadData(line);
	}

	// static Quiz[] QUIZZES = new String[2];

	private void loadData(String line) {
		// BufferedReader br = new BufferedReader(new java.io.FileReader(new
		// File("Files/Data.txt")));

		/*
		 * for (int i = 0; i < 2; i++) { QUIZZES[i] = br.readLine(); }
		 */

		// System.out.println("Load data: "+line);
		String[] str = line.trim().split(";");

		// for (int i = 0; i < str.length; i++)
		// System.out.println(str[i]);

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

		String[] ansImages = str[10].split(":");
		ImageIcon[][] answersImage = new ImageIcon[totalPanes][4];

		String[] answers = str[11].split(":");
		String[][] answersText = new String[totalPanes][4];

		boolean completed = Boolean.parseBoolean(str[12]);

		for (int i = 0; i < totalPanes; i++) {
			// System.out.println(answers[i]);//
		}

		for (int i = 0; i < totalPanes; i++) {
			String[] tempText = answers[i].trim().split(",");
			String[] tempImage = ansImages[i].trim().split(",");
			for (int j = 0; j < 4; j++) {
				if (tempText[j].equalsIgnoreCase("null"))
					answersText[i][j] = null;
				else {
					answersText[i][j] = tempText[j];
				}
				if (tempImage[j].equalsIgnoreCase("null")) {
					answersImage[i][j] = null;
					// System.out.println("NULL IMAGE");
				}

				else {
					answersImage[i][j] = new ImageIcon(tempImage[j]);// Temp[j]);
					// System.out.println("Valiud IMAGE " + tempImage[j]);
				}
			}

		}

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
		this.completed = completed;

		// System.out.println("COMPLETED??? " + this.completed);
		// return new Quiz(course, diff, q, lessonNum, currPane, numQ, ansKey, correct,
		// numWrong, qImage, ansArr, ansText);
	}

	public String saveData(int curr) {

		// Currentpane - 4, answeredCorrect[] - 7,numWrong[] - 8,

		String[] str = data.trim().split(";");
		String line = "";

		str[4] = String.valueOf(curr);

		boolean complete = false;
		String ans = "";
		for (int i = 0; i < ansKey.length; i++) {
			if(answeredCorrect[i]) complete=true;
			ans += (answeredCorrect[i]) + ",";
		}

		str[7] = ans.substring(0, ans.length() - 1);

		String wrong = "";
		for (int i = 0; i < ansKey.length; i++)
			wrong += String.valueOf(numWrong[i]) + ",";

		str[8] = wrong.substring(0, wrong.length() - 1);

		System.out.println("\n" + data);
		System.out.println(str[4]);
		System.out.println(str[7]);
		System.out.println(str[8]);

		str[12] = String.valueOf(complete);

		for (int i = 0; i < str.length; i++)
			line += str[i] + ";";
		line = line.substring(0, line.length() - 1);
		System.out.println(line);

		return line;

	}

	public void saveQuiz() {

		try {
			BufferedWriter pr = new BufferedWriter(new FileWriter(new File("Files/Test"), false));
			for (int i = 0; i < Initialize.quizArr.length; i++) {
				pr.write(Initialize.quizArr[i].saveData(Initialize.quizArr[i].getCurrentPane()));
				pr.newLine();

			}
			pr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
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
