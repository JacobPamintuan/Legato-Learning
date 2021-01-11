package guiScreens;

public class Initialize {

	public static SidebarGUI sidebar;
	public static HomeGUI home;
	public static ChallengeBankGUI challengeBank;
	public static ProfileGUI profile;
	public static SettingsGUI settings;
	
	public static LessonTemplate lesson;

	public Initialize() {
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
	}

}
