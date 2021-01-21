package legatoLearning;

public class MusicTheoryTest {

	public static void main(String[] args) {

		Frame frame = new Frame();
		frame.frame.setVisible(true);

		try {
			new LoadUsers();

			new Initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
