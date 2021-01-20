package legatoLearning;

import java.io.*;
import java.util.*;

public class LoadUsers {

//	public static Map<String, String> users = new HashMap<String, String>();
	public static ArrayList<String> users = new ArrayList<String>();
	public static ArrayList<String> passwords = new ArrayList<String>();
	public static ArrayList<String> names = new ArrayList<String>();
	public static ArrayList<String> quizSave = new ArrayList<String>();
	public static ArrayList<String> lessonSave = new ArrayList<String>();

	public static File USERFILE = new File("Files/Users");

	public LoadUsers() throws Exception {
		loadUsers();
//		users.add("jpam03");
//		passwords.add("abc123");
	}

	private void loadUsers() throws IOException {
		BufferedReader br = new BufferedReader(new java.io.FileReader(new File("Files/Users")));

		String line;
		while ((line = br.readLine()) != null) {
			String str[] = line.split(";");
			users.add(str[0]);
			passwords.add(str[1]);
			names.add(str[2]);
			quizSave.add(str[3]);
			lessonSave.add(str[4]);

		}

		br.close();

	}

	public static void addUser(String username, String password, String name) throws IOException {
		users.add(username);
		passwords.add(password);
		names.add(name);
		BufferedWriter pr = new BufferedWriter(new FileWriter(USERFILE, true));
		//pr.newLine();
		pr.write(String.format("%s;%s;%s;Files/QuizSave_%s;Files/LessonSave_%s\n", username, password, name, username,
				username));
		pr.close();
	}

	public static int getUserIndex(String username) {
		return users.indexOf(username);
	}

	public static boolean checkUsername(String username) {
		if (users.contains(username))
			return true;
		return false;
	}

	public static boolean checkPassword(String username, String pass) {
		if (users.contains(username)) {
			int i = users.indexOf(username);
			if (pass.equals(passwords.get(i)))
				return true;
		}
		return false;
	}

	public void signUp() {

	}

	public void logIn() {

	}
}
