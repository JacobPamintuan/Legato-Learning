package guiScreens;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.*;

public class Welcome extends JFrame implements ActionListener{

	public static JFrame frame;
	public static JPanel welcomePanel;

	private static final int WIDTH = 1920;
	private static final int HEIGHT = 2080;
	
	JLabel test=new JLabel();
	JButton button=new JButton();
	private JButton resetButton = new JButton();

	public Welcome() {
		frame = new JFrame("Music Theory");
		frame.setBounds(0, 0, WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		welcomePanel = new JPanel();
		welcomePanel.setBounds(0, 0, WIDTH, HEIGHT);
		welcomePanel.setLayout(null);
		frame.getContentPane().add(welcomePanel);
		
		test.setText("asdf");
		test.setBounds(0, 0, 60, 20);
		welcomePanel.add(test);
		
		button.setText("Next");
		button.setBounds(80,23,60,35);
		button.addActionListener(this);
		welcomePanel.add(button);
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			System.out.println("YEET");
			welcomePanel.setVisible(false);
			new PanelTest();
		}
		
	}

}
