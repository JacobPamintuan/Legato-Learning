package guiScreens;

import javax.swing.ImageIcon;

public class Initialize {

	public static SidebarGUI sidebar;
	public static HomeGUI home;
	public static ChallengeBankGUI challengeBank;
	public static ProfileGUI profile;
	public static SettingsGUI settings;

	public static LessonTemplate lesson;
	public static QuizTemplate quiz;

	public static LessonPlan intervals;
	public static Data info;
	public static Quiz testQuiz;

	public Initialize() throws Exception {

		try {
			info = new Data();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		testQuiz = info.loadData();

		sidebar = new SidebarGUI();

		home = new HomeGUI();
		home.homePane.setVisible(false);

		challengeBank = new ChallengeBankGUI();
		challengeBank.challengePane.setVisible(false);

		profile = new ProfileGUI();
		profile.profilePane.setVisible(false);

		settings = new SettingsGUI();
		settings.settingsPane.setVisible(false);

		lesson = new LessonTemplate();
		lesson.LessonTempPane.setVisible(false);

		int[] ansKey = { 0, 1, 0, 3, 2, 1 };
		boolean[] bool = { false, false, false, false, false, false };
		int[] numWrong = { 0, 0, 0, 0, 0, 0 };

		ImageIcon TEST = new ImageIcon("images/TEST.png");
		String[][] image = { null, null, null, null, null, null };
		String[][] ans = { { "5th", "UNISON", "8th", "3rd" }, { "4rth", "2nd", "3rd", "6th" },
				{ "8th", "6th", "3rd", "2nd" }, { "6th", "4rth", "7th", "UNISON" }, { "UNISON", "6th", "3rd", "8th" },
				{ "4th", "5th", "3rd", "2nd" } };

//		intervals = new Quiz("INTERVALS", "Beginner", "Name the following melodic interval:", 1, 1, 6, ansKey, bool,numWrong,       				new ImageIcon("images/Melodic.png"), image, ans);

		quiz = new QuizTemplate();
	}

}
