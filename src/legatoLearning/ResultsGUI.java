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

	JLabel[] courseArr = new JLabel[10];
	JLabel[] lessonArr = new JLabel[10];
	JLabel[] quizArr = new JLabel[10];
	JLabel[] scoreArr = new JLabel[10];
	JLabel[] smiley = new JLabel[10];
	JLabel table;

	JButton scoreFilter;

	JButton btnFilter;

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

		JLabel legend = new JLabel();
		legend.setIcon(new ImageIcon("images/ResultsLegend.png"));
		legend.setBounds(759, 14, 310, 150);
		resultsPane.add(legend);

		scoreFilter = new JButton();
		scoreFilter.setIcon(new ImageIcon("images/chevUp.jpg"));
		scoreFilter.addActionListener(this);
		scoreFilter.setBounds(1035, 191, 23, 23);
		resultsPane.add(scoreFilter);

		for (int i = 0; i < 10; i++) {
			int space = 52;
			int shiftY = i * space;
			courseArr[i] = new JLabel();
			courseArr[i].setBounds(97, 231 + shiftY, 125, 43);
			courseArr[i].setFont(Fonts.BODY);
			courseArr[i].setVerticalAlignment(SwingConstants.CENTER);
			resultsPane.add(courseArr[i]);

			lessonArr[i] = new JLabel();
			lessonArr[i].setBounds(257, 231 + shiftY, 280, 43);
			lessonArr[i].setFont(Fonts.BODY);
			resultsPane.add(lessonArr[i]);

			quizArr[i] = new JLabel();
			quizArr[i].setBounds(547, 231 + shiftY, 275, 43);
			quizArr[i].setFont(Fonts.BODY);
			resultsPane.add(quizArr[i]);

			scoreArr[i] = new JLabel();
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

		btnFilter = new JButton("Filter");
		btnFilter.setBounds(402, 37, 117, 29);
		btnFilter.addActionListener(this);
		resultsPane.add(btnFilter);

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
	
	public Color scoreColour(double score) {

		score *= 100;

		if (score >= 85 && score <= 100)
			return Colours.purp;
		else if (score >= 70 && score < 85)
			return Colours.green;
		else if (score >= 50 && score < 70)
			return Colours.orange;
		else if (score >= 0 && score < 50)
			return Colours.red;
		else
			return Color.BLACK;
		
	}

	public void updateChart(int num) {
		Quiz[] clone = Initialize.quizArr.clone();
		currentFilter = num;
		if (num == 0)
			Arrays.sort(clone, new LowToHigh());
		else if (num == 1)
			Arrays.sort(clone, new HighToLow());
		else
			; // No filter - Array not sorted by score, displays as original

		for (int i = 0; i < 10; i++) {

			courseArr[i].setText(clone[i].getDifficulty());
			lessonArr[i].setText(clone[i].getLessonName());

			if (clone[i].getDifficulty().equals("Intermediate") && clone[i].getQuizNumber() > 3)
				quizArr[i].setText(String.format("%d - %s", clone[i].getQuizNumber() - 3, clone[i].getQuizName()));
			else
				quizArr[i].setText(String.format("%d - %s", clone[i].getQuizNumber(), clone[i].getQuizName()));
			scoreArr[i].setText(clone[i].getStringScore());
			scoreArr[i].setForeground(scoreColour(clone[i].getPercentageScore()));
			smiley[i].setIcon(calculateSmiley(clone[i].getPercentageScore()));

		}

	}

	// Event Handelers
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFilter)
			currentFilter = -1;
		if (e.getSource() == scoreFilter) {
			if (currentFilter == 0) {
				currentFilter = 1;
				scoreFilter.setIcon(new ImageIcon("images/chevDown.jpg"));
			} else {
				currentFilter = 0;
				scoreFilter.setIcon(new ImageIcon("images/chevUp.jpg"));
			}

		}
		updateChart(currentFilter);
		resultsPane.repaint();

	}
}

// Comparators - sorts quiz results by score
class LowToHigh implements Comparator<Quiz> {
	public int compare(Quiz a, Quiz b) {
		return Double.compare(a.getPercentageScore(), b.getPercentageScore());
	}
}

class HighToLow implements Comparator<Quiz> {
	public int compare(Quiz a, Quiz b) {
		return Double.compare(b.getPercentageScore(), a.getPercentageScore());
	}
}
