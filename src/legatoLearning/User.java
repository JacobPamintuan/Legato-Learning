package legatoLearning;

import java.io.File;

public class User {

	// Fields

	private String username;
	private String password;
	private String firstName;
	private String lastName;

	private File lessonSave;
	private File quizSave;

	// Constructor - String parameter
	public User(String line) {

		// Formatted -> username;password;first name;last name;quiz save file;lesson
		// save file
		String str[] = line.split(";");

		username = str[0];
		password = str[1];
		firstName = str[2];
		lastName = str[3];
		quizSave = new File(str[4]);
		lessonSave = new File(str[5]);
	}

	// Constructor - parameters for all fields
	public User(String username, String password, String firstName, String lastName, File lessonSave, File quizSave) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lessonSave = lessonSave;
		this.quizSave = quizSave;
	}

	// Getters and Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String fName) {
		this.firstName = fName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public File getLessonSave() {
		return lessonSave;
	}

	public void setLessonSave(File lessonSave) {
		this.lessonSave = lessonSave;
	}

	public File getQuizSave() {
		return quizSave;
	}

	public void setQuizSave(File quizSave) {
		this.quizSave = quizSave;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", fName=" + firstName + "]";
	}

}
