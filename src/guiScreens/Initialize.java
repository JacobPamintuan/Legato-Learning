package guiScreens;

public class Initialize {
	
	public static SidebarGUI sidebar;
	public static HomeGUI home;
	public static ChallengeBankGUI challengeBank;

	public Initialize() {
		sidebar = new SidebarGUI();
		
		home = new HomeGUI();
		home.homePane.setVisible(false);
		
		challengeBank = new ChallengeBankGUI();
		
	}

}
