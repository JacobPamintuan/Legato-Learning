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
 * 	- 
 *  -   
 * 
 * Major Skills:
 * 	- Object Oriented Programming
 * 	- Java Swing
 * 	- Java Graphical User interface
 * 	- ActionListener, MouseListener, ItemListener
 * 	- File reading and writing
 * 	- Use of Comparators
 *  - 
 * 
 * Areas of Concern
 * 		- Please run on an apple computer
 * 		- Screen size of at least 1440x820 (just barely fits on MacBook Pro 13-inch)
 * 		- Wait at least 2 seconds after home screen pops up 
 * 				to allow the program to load
 * 			- "Load complete" will appear in console
 * 
 * Credits:
 *  - All lessons and quizzes were taken/based off of the book:
 * 		Mark Sarnecki, M. S. (2021). The Complete Elementary Music Rudiments, 2nd Edition. Music One Select.
 * 
 */

/*
 * Main/Test Class
 * Launches application
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
