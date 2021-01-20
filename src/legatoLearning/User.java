package legatoLearning;

import java.io.File;

public class User {

	private String username;
	private String password;
	private String name;

	private File lessonSave;
	private File quizSave;
	
	public User(String line) {
		String str[] = line.split(";");
		
		username = str[0];
		password = str[1];
		name = str[2];
		quizSave = new File(str[3]);
		lessonSave = new File(str[4]);
	}

	public User(String username, String password, String fName, File lessonSave, File quizSave) {
		this.username = username;
		this.password = password;
		this.name = fName;
		this.lessonSave = lessonSave;
		this.quizSave = quizSave;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String fName) {
		this.name = fName;
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
		return "User [username=" + username + ", password=" + password + ", fName=" + name + "]";
	}

}
