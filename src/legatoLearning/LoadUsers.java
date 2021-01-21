package legatoLearning;

import java.io.*;
import java.util.*;

public class LoadUsers {

	// Fields

	// Arraylists for each quality of a user
	public static ArrayList<String> users = new ArrayList<String>();
	public static ArrayList<String> passwords = new ArrayList<String>();
	public static ArrayList<String> firstNames = new ArrayList<String>();
	public static ArrayList<String> lastNames = new ArrayList<String>();
	public static ArrayList<String> quizSave = new ArrayList<String>();
	public static ArrayList<String> lessonSave = new ArrayList<String>();

	// User storage
	public static File USERFILE = new File("Files/Users");

	// Constructor
	public LoadUsers() throws Exception {
		loadUsers();
	}

	// Helper method - loads user values into arraylists
	private void loadUsers() throws IOException {
		BufferedReader br = new BufferedReader(new java.io.FileReader(new File("Files/Users")));

		// Formatted -> username;password;first name;last name;quiz save file;lesson save file
		String line;
		
		while ((line = br.readLine()) != null) {
			String str[] = line.split(";");
			users.add(str[0]);
			passwords.add(str[1]);
			firstNames.add(str[2]);
			lastNames.add(str[3]);
			quizSave.add(str[4]);
			lessonSave.add(str[5]);

		}

		br.close();

	}

	// New user - save to User file
	public static String addUser(String username, String password, String firstName, String lastName)
			throws IOException {
		users.add(username);
		passwords.add(password);
		firstNames.add(firstName);
		lastNames.add(lastName);
		BufferedWriter pr = new BufferedWriter(new FileWriter(USERFILE, true));

		// Formatted -> username;password;first name;last name;quiz save file;lesson save file
		String line = String.format("%s;%s;%s;%s;Files/QuizSave_%s;Files/LessonSave_%s\n", username, password,
				firstName, lastName, username, username);

		pr.write(line);
		pr.close();

		return line;
	}

	// Existing user - load data from user file
	public static String loginSuccessful(String username) {
		
		// Location of user within text file
		int i = users.indexOf(username);
		
		// Formatted -> username;password;first name;last name;quiz save file;lesson save file
		String line = String.format("%s;%s;%s;%s;Files/QuizSave_%s;Files/LessonSave_%s\n", username, passwords.get(i),
				firstNames.get(i), lastNames.get(i), username, username);
		return line;
	}

//	public static int getUserIndex(String username) {
//		return users.indexOf(username);
//	}

	// Check if user exists 
	public static boolean checkUsername(String username) {
		if (users.contains(username))
			return true;
		return false;
	}

	// Check if password matches user
	public static boolean checkPassword(String username, String pass) {
		if (users.contains(username.toLowerCase())) {
			int i = users.indexOf(username);
			if (pass.equals(passwords.get(i)))
				return true;
		}
		return false;
	}

}
