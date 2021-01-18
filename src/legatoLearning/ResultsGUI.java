package legatoLearning;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.*;

public class ResultsGUI implements ActionListener {

	JPanel resultsPane;

	public static boolean isIntervals;
	public static boolean isCourse2;

	JButton advanced;

//	int[] scores = new int[10];

	JLabel[] courseArr = new JLabel[10];
	JLabel[] lessonArr = new JLabel[10];
	JLabel[] quizArr = new JLabel[10];
	JLabel[] scoreArr = new JLabel[10];
	JLabel[] smiley = new JLabel[10];
	JLabel table;

	JButton scoreFilter;

	public int currentFilter = 0;

	public ResultsGUI() {
		resultsPane = new JPanel();
		resultsPane.setBounds(300, 0, 1140, 810);
		resultsPane.setBackground(Color.white);
		resultsPane.setLayout(null);
		Frame.frame.getContentPane().add(resultsPane);

		JLabel title = new JLabel("Quiz Results");
		title.setBounds(70, 37, 250, 50);
		title.setForeground(Colours.purp);
		title.setFont(Fonts.TITLE1);
		resultsPane.add(title);

		JLabel description = new JLabel(
				"<html>View your results to track your progress.<br>Restart your quizzes to get new first-try scores.<html>");
		description.setBounds(70, 79, 550, 85);
		description.setFont(Fonts.SUBHEADING1);
		resultsPane.add(description);

		scoreFilter = new JButton();
		scoreFilter.setIcon(new ImageIcon("images/chevUp.jpg"));
		scoreFilter.addActionListener(this);
		scoreFilter.setBounds(1035, 191, 23, 23);
		resultsPane.add(scoreFilter);

		for (int i = 0; i < 10; i++) {
			int space = 52;
			int shiftY = i * space;
			courseArr[i] = new JLabel();// ("Intermediate");
			courseArr[i].setBounds(97, 231 + shiftY, 125, 43);
			courseArr[i].setFont(Fonts.BODY);
			courseArr[i].setVerticalAlignment(SwingConstants.CENTER);
			resultsPane.add(courseArr[i]);

			lessonArr[i] = new JLabel();// ("1 - Perfect & Major Intervals");
			lessonArr[i].setBounds(257, 231 + shiftY, 280, 43);
			lessonArr[i].setFont(Fonts.BODY);
			resultsPane.add(lessonArr[i]);

			quizArr[i] = new JLabel();// ("3 - Perfect and Major Intervals");
			quizArr[i].setBounds(547, 231 + shiftY, 275, 43);
			quizArr[i].setFont(Fonts.BODY);
			resultsPane.add(quizArr[i]);

			scoreArr[i] = new JLabel();// ("6/6 (100%)");
			scoreArr[i].setBounds(857, 231 + shiftY, 143, 43);
			scoreArr[i].setFont(Fonts.BODY);
			resultsPane.add(scoreArr[i]);

			smiley[i] = new JLabel();
			smiley[i].setIcon(new ImageIcon("emojis/hearts.png"));
			smiley[i].setBounds(997, 238 + shiftY, 30, 30);
			resultsPane.add(smiley[i]);

		}

		updateChart(0);

		table = new JLabel();
		table.setIcon(new ImageIcon("images/Table.png"));
		table.setBounds(70, 176, 1000, 571);
		resultsPane.add(table);

		resultsPane.repaint();
	}

	public ImageIcon calculateSmiley(double score) {
		ImageIcon smiley = null;

		score *= 100;

		if (score >= 85 && score <= 100)
			smiley = new ImageIcon("emojis/sunglasses.png");
		else if (score >= 70 && score < 85)
			smiley = new ImageIcon("emojis/hearts.png");
		else if (score >= 50 && score < 70)
			smiley = new ImageIcon("emojis/smile.png");
		else if (score >= 0 && score < 50)
			smiley = new ImageIcon("emojis/puzzled.png");
		else
			smiley = null;
		return smiley;
	}

	public void updateChart(int num) {
		Quiz[] clone = Initialize.quizArr.clone();
		currentFilter = num;
		if (num == 0)
			Arrays.sort(clone, new LowToHigh());
		else if (num == 1)
			Arrays.sort(clone, new HighToLow());

		for (int i = 0; i < 10; i++) {

			// arr[i].setText(String.format("%s, %d, %.10f", clone[i].getDifficulty(),
			// clone[i].getQuizNumber(), clone[i].getScore()));

			courseArr[i].setText(clone[i].getDifficulty());
			lessonArr[i].setText(clone[i].getLessonName());
			quizArr[i].setText(String.format("%d - %s", clone[i].getQuizNumber(), clone[i].getQuizName()));
			scoreArr[i].setText(clone[i].getStringScore());
			smiley[i].setIcon(calculateSmiley(clone[i].getPercentageScore()));

//			courseArr[i].setText(String.format("%s, \t%d, %s", clone[i].getDifficulty(), clone[i].getQuizNumber(),
//					clone[i].getStringScore()));

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == scoreFilter) {
			if (currentFilter == 0) {
				currentFilter = 1;
				scoreFilter.setIcon(new ImageIcon("images/chevDown.jpg"));
			} else {
				currentFilter = 0;
				scoreFilter.setIcon(new ImageIcon("images/chevUp.jpg"));
			}
			updateChart(currentFilter);
		}

		resultsPane.repaint();

	}

}

class LowToHigh implements Comparator<Quiz> {
	public int compare(Quiz a, Quiz b) {
		return Double.compare(a.getPercentageScore(), b.getPercentageScore());
	}
}

class HighToLow implements Comparator<Quiz> {
	public int compare(Quiz a, Quiz b) {
		if (b.getPercentageScore() != 101) // If there is a valid score
			return Double.compare(b.getPercentageScore(), a.getPercentageScore());
		return Double.compare(a.getPercentageScore(), b.getPercentageScore()); // If  in
	}
}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == advanced) {
//			Quiz[] clone = Initialize.quizArr.clone();
//			Arrays.sort(clone, new quizComparator());
//			for (Quiz e1 : clone) {
//
//				System.out.printf("%s, %d, %d/%d\n", e1.getDifficulty(), e1.getQuizNumber(),
//						(e1.getTotalPanes() * (int) (1 - e1.getPercentageScore())), e1.getTotalPanes());
//			}
//
//			for (int i = 0; i < 10; i++) {
//
//				// arr[i].setText(String.format("%s, %d, %.10f", clone[i].getDifficulty(),
//				// clone[i].getQuizNumber(), clone[i].getScore()));
//
//				courseArr[i].setText(clone[i].getDifficulty());
//				lessonArr[i].setText(clone[i].getLessonName());
//				quizArr[i].setText(String.format("%d - %s", clone[i].getQuizNumber(), clone[i].getQuizName()));
//				scoreArr[i].setText(clone[i].getStringScore());
//
////				courseArr[i].setText(String.format("%s, \t%d, %s", clone[i].getDifficulty(), clone[i].getQuizNumber(),
////						clone[i].getStringScore()));
//			}
//
//		}
//
//	}
//}

//package legatoLearning;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.util.Arrays;
//import java.util.Comparator;
//
//import javax.swing.*;
//
//public class ChallengeBankGUI implements ActionListener {
//
//	JPanel challengePane;
//
//	public static boolean isIntervals;
//	public static boolean isCourse2;
//
//	JButton advanced;
//
////	int[] scores = new int[10];
//
//	JLabel[] arr = new JLabel[10];
//
//	public ChallengeBankGUI() {
//		challengePane = new JPanel();
//		challengePane.setBounds(300, 0, 1140, 810);
//		challengePane.setBackground(Color.white);
//		challengePane.setLayout(null);
//		Frame.frame.getContentPane().add(challengePane);
//
//		advanced = new JButton("Start advanced quiz");
//		advanced.setBounds(600, 0, 200, 200);
//		advanced.addActionListener(this);
//		challengePane.add(advanced);
//
//		for (int i = 0; i < 10; i++) {
//			arr[i] = new JLabel();
//			arr[i].setBounds(0, 0 + i * 50, 600, 100);
//			arr[i].setFont(Fonts.SUBHEADING2);
//			challengePane.add(arr[i]);
//		}
//
//		challengePane.repaint();
//	}
//
//	private void createBeginner(int q) {
//		Quiz q1 = null;
//		System.out.println("alksdfj");
//
//		boolean[] correct = null;
//
//		if (Initialize.quizArr[q].isCompleted()) {
//			System.out.println("asdf");
//			q1 = Initialize.quizArr[q];
//
//			correct = new boolean[q1.getAnsKey().length];
//			int numWrong = 0;
//			for (int i = 0; i < q1.getTotalPanes(); i++) {
//				if (q1.getNumWrong()[i] > 0) {
//					numWrong++;
//					correct[i] = false;
//				}
//
//				else
//					correct[i] = true;
//
//			}
//
//			int firstWrong = 0;
//			for (int i = 0; i < q1.getTotalPanes(); i++) {
//				if (!correct[i]) {
//					firstWrong = i + 1;
//					break;
//				}
//			}
//
//			q1.setAnsweredCorrect(correct);
//			q1.setCurrentPane(firstWrong);
//
//		}
//
//		for (int i = 0; i < 5; i++)
//			System.out.println(q1.getNumWrong()[i]);
//		for (int i = 0; i < 5; i++)
//			System.out.println(correct[i]);
//		for (int i = 0; i < 5; i++)
//			System.out.println(q1.getAnsweredCorrect()[i]);
//
//		new QuizTemplate(q1);
//
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == advanced) {
//			Quiz[] clone = Initialize.quizArr.clone();
//			Arrays.sort(clone, new quizComparator());
//			for (Quiz e1 : clone) {
//
//				System.out.printf("%s, %d, %d/%d\n", e1.getDifficulty(), e1.getQuizNumber(),
//						(e1.getTotalPanes() * (int) (1 - e1.getPercentageScore())), e1.getTotalPanes());
//			}
//
//			for (int i = 0; i < 10; i++) {
//
//				// arr[i].setText(String.format("%s, %d, %.10f", clone[i].getDifficulty(),
//				// clone[i].getQuizNumber(), clone[i].getScore()));
//
//				arr[i].setText(String.format("%s, \t%d, %s", clone[i].getDifficulty(), clone[i].getQuizNumber(),
//						clone[i].getStringScore()));
//			}
//
//		}
//
//	}
//}
//
//class quizComparator implements Comparator<Quiz> {
//	public int compare(Quiz a, Quiz b) {
//		System.out.println(a.getPercentageScore());
//		return Double.compare(a.getPercentageScore(), b.getPercentageScore());
//	}
//}
