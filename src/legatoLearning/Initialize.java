package legatoLearning;

import java.io.BufferedReader;
import java.io.File;
import java.util.Arrays;

public class Initialize {

	public static SidebarGUI sidebar;
	public static HomeGUI home;
	public static ResultsGUI results;
	public static ProfileGUI profile;
	public static SettingsGUI settings;

	public static LessonTemplate[] lessonGUI;
	public static QuizTemplate[] quizGUI;

	public static Quiz[] quizArr;
	public static Quiz[] quizOG;
	public static String[] QuizData;
	public static Lesson[] lessonArr;

	public static IntervalCourse iCourse;
	
	public static File quizDataOG = new File("Files/Quiz.txt");
	public static File quizSaveData = new File("Files/Test");

	public static File lessonDataOG = new File("Files/Lesson.txt");
	public static File lessonSaveData = new File("Files/Test2");
	
	public Initialize() throws Exception {

		quizArr = new Quiz[10]; // UPDATE

		
		BufferedReader br;
		if (quizSaveData.length() == 0)
			br = new BufferedReader(new java.io.FileReader(quizDataOG));
		else
			br = new BufferedReader(new java.io.FileReader(quizSaveData));

		for (int i = 0; i < quizArr.length; i++) {
			String line = br.readLine();
			quizArr[i] = new Quiz(line);
			System.out.printf("Quiz %d: %s\n", i, line);

		}
		br.close();

		quizOG = new Quiz[10];
		BufferedReader br2 = new BufferedReader(new java.io.FileReader(new File("Files/Quiz.txt")));
		for (int i = 0; i < quizOG.length; i++) {
			String line = br2.readLine();
			quizOG[i] = new Quiz(line);
//			System.out.printf("Quiz %d: %s\n", i, line);

		}
		br2.close();

		lessonArr = new Lesson[4]; // UPDATE
		
		
		
		if(lessonSaveData.length()==0)
			br = new BufferedReader(new java.io.FileReader(lessonDataOG));
		else br = new BufferedReader(new java.io.FileReader(lessonSaveData));
		for (int i = 0; i < lessonArr.length; i++) {
			String line = br.readLine();
			lessonArr[i] = new Lesson(line);
			System.out.printf("Lesson %d: %s\n", i, line);
		}
		br.close();

		sidebar = new SidebarGUI();

		home = new HomeGUI();
//		home.homePane.setVisible(false);

		results = new ResultsGUI();
		results.resultsPane.setVisible(false);

		profile = new ProfileGUI();
		profile.profilePane.setVisible(false);

		settings = new SettingsGUI();
		settings.settingsPane.setVisible(false);

		quizGUI = new QuizTemplate[quizArr.length];
		for (int i = 0; i < quizArr.length; i++) {
			quizGUI[i] = new QuizTemplate(i);
			quizGUI[i].QuizPane.setVisible(false);
		}

		lessonGUI = new LessonTemplate[lessonArr.length];
		for (int i = 0; i < lessonArr.length; i++) {
			lessonGUI[i] = new LessonTemplate(i);
			lessonGUI[i].LessonTempPane.setVisible(false);
		}

		iCourse = new IntervalCourse();
		iCourse.iCoursePane.setVisible(false);
	}

}