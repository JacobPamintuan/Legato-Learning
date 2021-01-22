package legatoLearning;

public class LegatoLearningTest {

	public static void main(String[] args) {

		// Initialize frame
		Frame frame = new Frame();
		frame.frame.setVisible(true);

		try {
			// Initialize / Load Users
			new LoadUsers(); 
			
			// Run application
			new Initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
