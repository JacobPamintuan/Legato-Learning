package legatoLearning;

import javax.swing.JFrame;

/*
 * Initialize Frame
 */

public class Frame {

	public static JFrame frame;

	public static final int FRAME_WIDTH = 1440;
	public static final int FRAME_HEIGHT = 820;

	public Frame() {

		frame = new JFrame("Legato Learning");
		frame.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
	}

}
