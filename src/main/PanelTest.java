package main;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.*;


public class PanelTest implements ActionListener {
	
	
	public static JPanel testPanel;

	private static final int WIDTH = 1920;
	private static final int HEIGHT = 2080;
	
	private static JButton back = new JButton("Back");

	public PanelTest() {
		testPanel = new JPanel();
		testPanel.setBounds(0, 0, WIDTH, HEIGHT);
		testPanel.setLayout(null);
		Welcome.frame.getContentPane().add(testPanel);
		
		back.setBounds(300, 300, 200, 300);
		back.addActionListener(this);
		testPanel.add(back);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			System.out.println("Nahyeet");
			//testPanel.setVisible(false);
			Welcome.welcomePanel.setVisible(true);
		}
		
	}
	

}
