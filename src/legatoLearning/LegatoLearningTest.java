package legatoLearning;

/*
 * Name: Jacob Pamintuan
 * 
 * Date: Friday, January 22nd, 2021
 * 
 * Course Code: ICS4U1-01; Mr. Fernandes
 * 
 * Title: Legato Learning
 * 
 * Description:
 * 
 * Features:
 * 		- Hover states
 * 		-  
 * 
 * Major Skills:
 * 		- 
 * 
 * Areas of Concern
 * 		- Only runs on Apple Macbooks
 * 		- Screen size of at least 1440x810
 * 		- Wait at least 2 seconds after home screen pops up 
 * 				to allow the program to load
 * 
 */

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
