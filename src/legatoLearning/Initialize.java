package legatoLearning;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Initialize {

	// Fields
	
	public static User user;

	public static SidebarGUI sidebar;
	public static HomeGUI home;
	public static ResultsGUI results;
	public static ProfileGUI profile;
	public static SettingsGUI settings;
	public static LoginGUI login;
	public static SignUpGUI signUp;

	public static LessonTemplate[] lessonGUI;
	public static QuizTemplate[] quizGUI;

	public static Quiz[] quizArr;
	public static Quiz[] quizOG;
	public static String[] QuizData;
	public static Lesson[] lessonArr;

	public static IntervalCourse iCourse;

	public static File quizDataOG = new File("Files/QuizOG");
	public static File quizSaveData;// = new File("Files/QuizSave");

	public static File lessonDataOG = new File("Files/LessonOG");
	public static File lessonSaveData;// = new File("Files/LessonSave");

	public Initialize() throws Exception {
		
		login = new LoginGUI();
		
		signUp = new SignUpGUI();
		signUp.signUpPane.setVisible(false);
		
	}
	
	public static void initializeGUIS() {
		sidebar = new SidebarGUI();

		iCourse = new IntervalCourse();
		iCourse.iCoursePane.setVisible(false);

		home = new HomeGUI();

		results = new ResultsGUI();
		results.resultsPane.setVisible(false);

		profile = new ProfileGUI();
		profile.profilePane.setVisible(false);

		settings = new SettingsGUI();
		settings.settingsPane.setVisible(false);

	}
	
	public static void initializeFiles() throws IOException {
		
		quizSaveData = user.getQuizSave();
		lessonSaveData = user.getLessonSave();
		
		
		quizArr = new Quiz[10]; // Regular Quiz Array - saved values

		BufferedReader br;
		if (quizSaveData.length() == 0) // If save file is empty - first time user/never completed any quizzes
			br = new BufferedReader(new java.io.FileReader(quizDataOG)); // Use default text file
		else
			br = new BufferedReader(new java.io.FileReader(quizSaveData)); // Read from save file

		for (int i = 0; i < quizArr.length; i++) {
			String line = br.readLine();
			quizArr[i] = new Quiz(line);
			System.out.printf("Quiz %d: %s\n", i, line);

		}
		br.close();

		quizOG = new Quiz[10]; // Default quiz array
		br = new BufferedReader(new java.io.FileReader(quizDataOG)); // Default text file
		for (int i = 0; i < quizOG.length; i++) {
			String line = br.readLine();
			quizOG[i] = new Quiz(line);
		}
		br.close();

		lessonArr = new Lesson[4];
		if (lessonSaveData.length() == 0) // If save file is empty - first time user/never completed any lessons
			br = new BufferedReader(new java.io.FileReader(lessonDataOG)); // Use default text file
		else
			br = new BufferedReader(new java.io.FileReader(lessonSaveData)); // Read from save file
		for (int i = 0; i < lessonArr.length; i++) {
			String line = br.readLine();
			lessonArr[i] = new Lesson(line);
			System.out.printf("Lesson %d: %s\n", i, line);
		}
		br.close();
		
		// Load all quizzes and lessons and set visible false
		quizGUI = new QuizTemplate[quizArr.length]; // QuizTemplate array
		for (int i = 0; i < quizArr.length; i++) {
			quizGUI[i] = new QuizTemplate(i);
			quizGUI[i].QuizPane.setVisible(false);
		}

		lessonGUI = new LessonTemplate[lessonArr.length]; // LessonTemplate array
		for (int i = 0; i < lessonArr.length; i++) {
			lessonGUI[i] = new LessonTemplate(i);
			lessonGUI[i].LessonTempPane.setVisible(false);
		}
	}

}