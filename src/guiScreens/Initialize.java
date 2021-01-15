package guiScreens;

import java.io.BufferedReader;
import java.io.File;

import javax.swing.ImageIcon;

public class Initialize {

	public static SidebarGUI sidebar;
	public static HomeGUI home;
	public static ChallengeBankGUI challengeBank;
	public static ProfileGUI profile;
	public static SettingsGUI settings;

	public static LessonTemplate lesson;
	public static QuizTemplate quiz;

	// public static LessonPlan intervals;
	public static Data info;
	public static Quiz[] quizArr;
	public static Lesson[] lessonArr;

	public Initialize() throws Exception {

		try {
			info = new Data();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		quizArr = new Quiz[6]; // UPDATE
		BufferedReader br = new BufferedReader(new java.io.FileReader(new File("Files/Quiz.txt")));
		for(int i=0;i<quizArr.length;i++) {
			String line = br.readLine();
			quizArr[i] = new Quiz(line);
			System.out.printf("Quiz %d: %s\n",i,line);
			
		}
		br.close();
		
		
		
		lessonArr = new Lesson[2]; // UPDATE
		br = new BufferedReader(new java.io.FileReader(new File("Files/Lesson.txt")));
		for(int i=0;i<lessonArr.length;i++) {
			String line = br.readLine();
			lessonArr[i]=new Lesson(line);
			System.out.printf("Lesson %d: %s\n",i,line);
		}
		
		
		
		sidebar = new SidebarGUI();

		home = new HomeGUI();
		home.homePane.setVisible(false);

		challengeBank = new ChallengeBankGUI();
		challengeBank.challengePane.setVisible(false);

		profile = new ProfileGUI();
		profile.profilePane.setVisible(false);

		settings = new SettingsGUI();
		settings.settingsPane.setVisible(false);

//		lesson = new LessonTemplate();
//		lesson.LessonTempPane.setVisible(false);

//		int[] ansKey = { 0, 1, 0, 3, 2, 1 };
//		boolean[] bool = { false, false, false, false, false, false };
//		int[] numWrong = { 0, 0, 0, 0, 0, 0 };
//
//		ImageIcon TEST = new ImageIcon("images/TEST.png");
//		String[][] image = { null, null, null, null, null, null };
//		String[][] ans = { { "5th", "UNISON", "8th", "3rd" }, { "4rth", "2nd", "3rd", "6th" },
//				{ "8th", "6th", "3rd", "2nd" }, { "6th", "4rth", "7th", "UNISON" }, { "UNISON", "6th", "3rd", "8th" },
//				{ "4th", "5th", "3rd", "2nd" } };

//		intervals = new Quiz("INTERVALS", "Beginner", "Name the following melodic interval:", 1, 1, 6, ansKey, bool,numWrong, new ImageIcon("images/Melodic.png"), image, ans);

		quiz = new QuizTemplate(5);
//		quiz.QuizPane.setVisible(false);
		
		lesson = new LessonTemplate(1);
		lesson.LessonTempPane.setVisible(false);
	}
	
	

}