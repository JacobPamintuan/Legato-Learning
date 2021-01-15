package guiScreens;

public class Lesson {

	private String course;

	private String difficulty;
	private int lessonNumber;
	private String title;

	private int currentPane;
	private int totalPanes;

	private boolean completed;

	public Lesson(String line) {
		loadData(line);
	}

	private void loadData(String line) {
		String[] str = line.trim().split(";");

		String course = str[0];
		String difficulty = str[1];
		String title = str[2];

		int lessonNumber = Integer.parseInt(str[3]);
		int currentPane = Integer.parseInt(str[4]);
		int totalPanes = Integer.parseInt(str[5]);

		boolean completed = Boolean.parseBoolean(str[6]);

		this.course = course;
		this.difficulty = difficulty;
		this.lessonNumber = lessonNumber;
		this.title=title;
		this.currentPane = currentPane;
		this.totalPanes = totalPanes;
		this.completed = completed;
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

}
