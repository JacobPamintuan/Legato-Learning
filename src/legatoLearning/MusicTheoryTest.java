package legatoLearning;

import javax.swing.ImageIcon;

public class MusicTheoryTest {

	public static void main(String[] args) {

		Frame frame = new Frame();
		frame.frame.setVisible(true);
		
		try {
			new LoadUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		new LoginGUI();
		
		try {
			new Initialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
