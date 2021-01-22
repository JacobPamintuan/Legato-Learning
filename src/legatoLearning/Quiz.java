package legatoLearning;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.ImageIcon;

public class Quiz {

	// Fields
	public int[] numWrong;
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

	private double score;
	private String lessonName;
	private String quizName;

	// Constructor
	public Quiz(String line) {

		this.data = line;
		loadData(line);

	}

	// Initialize Quiz object
	private void loadData(String line) {

		// Format
		// course;difficulty;question title;quiz number;current pane;total panes;
		// [answer, key, array,];[completed, boolean, array];
		// [num, wrong, array];
		// question image;[answer,images: array];[answer,text:array];
		// boolean completed;quiz name;lesson name

		// Fields separated by ";"
		// 1-D arrays separated by "," -> ;0,0,0,0;
		// 2-D arrays organized by "," and ";",
		// -> ;a,a,a,a:b,b,b,b:c,c,c,c;

		String[] str = line.trim().split(";");

		String course = str[0];
		String difficulty = str[1];
		String questionTitle = str[2];

		// Parse String to Integer
		int quizNumber = Integer.parseInt(str[3]);
		int currentPane = Integer.parseInt(str[4]);
		int totalPanes = Integer.parseInt(str[5]);

		// Split str[x] into another 1-D
		String[] ans = str[6].trim().split(",");
		int[] ansKey = new int[totalPanes];

		String[] bool = str[7].trim().split(",");
		boolean[] answeredCorrect = new boolean[totalPanes];

		String[] wrong = str[8].trim().split(",");
		int[] numWrong = new int[totalPanes];

		// Parse String values to boolean and integer
		for (int i = 0; i < totalPanes; i++) {
			ansKey[i] = Integer.parseInt(ans[i]);
			answeredCorrect[i] = Boolean.parseBoolean(bool[i]);
			numWrong[i] = Integer.parseInt(wrong[i]);
		}

		ImageIcon questionImage = new ImageIcon(str[9]);

		// Split str[x] further into a 1-D array
		String[] ansImages = str[10].split(":");
		ImageIcon[][] answersImage = new ImageIcon[totalPanes][4];

		String[] answers = str[11].split(":");
		String[][] answersText = new String[totalPanes][4];

		// Convert 1-D array to 2-D

		for (int i = 0; i < totalPanes; i++) {

			String[] tempText = answers[i].trim().split(",");
			String[] tempImage = ansImages[i].trim().split(",");

			// Initialize 2-D array
			for (int j = 0; j < 4; j++) {

				// Text
				if (tempText[j].equalsIgnoreCase("null"))
					answersText[i][j] = null;

				else
					answersText[i][j] = tempText[j];

				// Images
				if (tempImage[j].equalsIgnoreCase("null"))
					answersImage[i][j] = null;

				else
					answersImage[i][j] = new ImageIcon(tempImage[j]);

			}

		}

		// Parse String to boolean
		boolean completed = Boolean.parseBoolean(str[12]);

		String quizName = str[14];
		String lessonName = str[13];

		// Initialize Object fields
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
		this.score = getPercentageScore();
		this.setQuizName(quizName);
		this.setLessonName(lessonName);

	}

	// Return data line to save
	public String saveData(int curr) {

		// Get old data line
		String[] str = data.trim().split(";");
		String line = "";

		// Overwrite certain parts of data line
		str[4] = String.valueOf(curr); // current Pane, int -> String

		boolean complete = false;

		// Turn answeredCorrect array to string
		String ans = "";
		for (int i = 0; i < ansKey.length; i++) {

			if (answeredCorrect[i])
				complete = true;

			ans += (answeredCorrect[i]) + ",";

		}

		// Remove "," at very end of answeredCorrect
		str[7] = ans.substring(0, ans.length() - 1);

		// Turn numWrong array into string
		String wrong = "";

		for (int i = 0; i < ansKey.length; i++)
			wrong += String.valueOf(numWrong[i]) + ",";

		// Remove "," at very end of wrong
		str[8] = wrong.substring(0, wrong.length() - 1);

		// Boolean -> String
		str[12] = String.valueOf(complete);

		// Build line, seperate values with ";"
		for (int i = 0; i < str.length; i++)
			line += str[i] + ";";

		// Remove ";" at very end of line
		line = line.substring(0, line.length() - 1);

		return line;

	}

	// Save quiz data to file
	public void saveQuiz() {

		// Overwrite save file with new data
		try {
			BufferedWriter pr = new BufferedWriter(new FileWriter(Initialize.quizSaveData, false));

			for (int i = 0; i < Initialize.quizArr.length; i++) {

				// Call save data to get String line
				pr.write(Initialize.quizArr[i].saveData(Initialize.quizArr[i].getCurrentPane()));
				pr.newLine();

			}

			pr.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	// Delete all data by overwrting the file with ""
	public void DELETE_ALL_QUIZZES() {

		try {

			BufferedWriter pr = new BufferedWriter(new FileWriter(Initialize.quizSaveData, false));

			pr.write("");
			pr.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	// Returns score as a double -> 0.xx
	public double getPercentageScore() {
		return calcScore();
	}

	// Return score in String format -> x/y (xx.x%)
	public String getStringScore() {
		if (!completed)
			return "--";
		int anumWrong = 0;
		for (int i = 0; i < totalPanes; i++) {
			if (numWrong[i] > 0) {
				anumWrong++;
			}
		}

		return (totalPanes - anumWrong + "/" + totalPanes + " (" + String.format("%.1f", calcScore() * 100) + "%)");
	}

	// Helper method - calculates score in decimal
	private double calcScore() {
		if (!completed)
			return 101; // Return an impossible score
		int anumWrong = 0;
		for (int i = 0; i < totalPanes; i++) {
			if (numWrong[i] > 0) {
				anumWrong++;
			}
		}

		return ((totalPanes - anumWrong) / (double) totalPanes);
	}

	// Getters and setters

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

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	@Override
	public String toString() {
		return "Quiz [numWrong=" + Arrays.toString(numWrong) + ", ansKey=" + Arrays.toString(ansKey)
				+ ", answeredCorrect=" + Arrays.toString(answeredCorrect) + ", course=" + course + ", difficulty="
				+ difficulty + ", quizNumber=" + quizNumber + ", currentPane=" + currentPane + ", totalPanes="
				+ totalPanes + ", questionTitle=" + questionTitle + ", questionImage=" + questionImage
				+ ", answersImage=" + Arrays.toString(answersImage) + ", answersText=" + Arrays.toString(answersText)
				+ ", completed=" + completed + ", data=" + data + ", score=" + score + "]";
	}

}
