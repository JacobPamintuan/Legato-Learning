package legatoLearning;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Lesson {

	// Fields
	private String course;

	private String difficulty;
	private int lessonNumber;
	private String title;

	private int currentPane;
	private int totalPanes;

	private boolean completed;
	private String lessonName;

	private String data;

	// Constructor
	public Lesson(String line) {
		this.data = line;
		loadData(line);
	}

	// Load data to object
	private void loadData(String line) {
		
		//Format:
		//course;difficulty;title;lesson number;current pane;total panes;boolean complete;lesson name
		
		String[] str = line.trim().split(";");

		String course = str[0];
		String difficulty = str[1];
		String title = str[2];

		int lessonNumber = Integer.parseInt(str[3]);
		int currentPane = Integer.parseInt(str[4]);
		int totalPanes = Integer.parseInt(str[5]);

		boolean completed = Boolean.parseBoolean(str[6]);

		String lessonName = str[7];

		this.course = course;
		this.difficulty = difficulty;
		this.lessonNumber = lessonNumber;
		this.title = title;
		this.currentPane = currentPane;
		this.totalPanes = totalPanes;
		this.completed = completed;
		this.setLessonName(lessonName);
	}

	// Save data to file
	public void saveLesson() {
		
		try {
			
			BufferedWriter pr = new BufferedWriter(new FileWriter(Initialize.lessonSaveData, false));
			
			for (int i = 0; i < Initialize.lessonArr.length; i++) {
				pr.write(Initialize.lessonArr[i].saveData());
				pr.newLine();

			}
			
			pr.close();
		
		} catch (IOException e) {
		
			e.printStackTrace();
		
		}
	}

	// Format and return string to be saved
	public String saveData() {
		
		String[] str = data.trim().split(";");
		String line = "";
		
		str[6] = String.valueOf(this.completed);

		for (int i = 0; i < str.length; i++)
			line += str[i] + ";";
		
		line = line.substring(0, line.length() - 1);

		return line;
	}

	// Delete data from lesson save file
	public void DELETE_ALL_LESSONS() {
		try {
			
			BufferedWriter pr = new BufferedWriter(new FileWriter(Initialize.lessonSaveData, false));
			
			pr.write("");
			pr.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}

	}
	
	// Getters and Setters

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

	public int getLessonNumber() {
		return lessonNumber;
	}

	public void setLessonNumber(int lessonNumber) {
		this.lessonNumber = lessonNumber;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

}
