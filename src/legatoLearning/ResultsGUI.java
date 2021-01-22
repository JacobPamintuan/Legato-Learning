package legatoLearning;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.*;

/*
 * ResultsGUI
 * Displays results of quizzes and sorts them
 * User can choose to sort low to high, high to low, or in order of difficulty
 * 		- Allows user to see their strengths and weaknesses
 * Contains links to each corresponding lesson
 * Accessible through sidebar
 */

public class ResultsGUI implements ActionListener, MouseListener {

	// Fields

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

	JLabel difficultyFilter;

	public int currentFilter = 0;

	// Initialize GUI
	public ResultsGUI() {

		// JPanel setup
		resultsPane = new JPanel();
		resultsPane.setBounds(300, 0, 1140, 810);
		resultsPane.setBackground(Color.white);
		resultsPane.setLayout(null);
		Frame.frame.getContentPane().add(resultsPane);

		JLabel title = new JLabel("Quiz Results");
		title.setBounds(70, 37, 250, 50);
		title.setForeground(Colours.purple);
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

		// Filter button/JLabel+mouseListener
		scoreFilter = new JButton();
		scoreFilter.setIcon(new ImageIcon("images/chevUp.jpg"));
		scoreFilter.addActionListener(this);
		scoreFilter.setBounds(1035, 191, 23, 23);
		resultsPane.add(scoreFilter);

		difficultyFilter = new JLabel();
		difficultyFilter.setIcon(new ImageIcon("images/chevDown.png"));
		difficultyFilter.setBounds(189, 191, 23, 23);
		difficultyFilter.addMouseListener(this);
		resultsPane.add(difficultyFilter);

		// Initialize Table
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

		// Fill chart with data
		updateChart(0);

		// Table image behind data
		table = new JLabel();
		table.setIcon(new ImageIcon("images/Table.png"));
		table.setBounds(70, 176, 1000, 571);
		resultsPane.add(table);

		resultsPane.repaint();

	}

	// Calculates smiley face based on score
	public ImageIcon calculateSmiley(double score) {

		score *= 100;

		if (score >= 85 && score <= 100)
			return new ImageIcon("emojis/sunglasses.png");
		else if (score >= 70 && score < 85)
			return new ImageIcon("emojis/hearts.png");
		else if (score >= 50 && score < 70)
			return new ImageIcon("emojis/smile.png");
		else if (score >= 0 && score < 50)
			return new ImageIcon("emojis/puzzled.png");
		else
			return null;

	}

	// Calculates color based on score
	public Color scoreColour(double score) {

		score *= 100;

		if (score >= 85 && score <= 100)
			return Colours.purple;
		else if (score >= 70 && score < 85)
			return Colours.green;
		else if (score >= 50 && score < 70)
			return Colours.orange;
		else if (score >= 0 && score < 50)
			return Colours.red;
		else
			return Color.BLACK;

	}

	// Update chart based on filter
	public void updateChart(int num) {

		Quiz[] sorted = Initialize.quizArr.clone();

		currentFilter = num;

		// Use comparators to sort array
		if (num == 0)
			Arrays.sort(sorted, new LowToHigh());

		else if (num == 1)
			Arrays.sort(sorted, new HighToLow());

		else
			; // No filter - Array not sorted by score, displays as original

		// Display data in order based on filter
		for (int i = 0; i < 10; i++) {

			courseArr[i].setText(sorted[i].getDifficulty());

			// Clickable links to lessons
			lessonArr[i].setText("<html><u>" + sorted[i].getLessonName() + "<u><html>");
			lessonArr[i].addMouseListener(this);

			// If Intermediate lesson 2, subtract 3 from quizNumber
			if (sorted[i].getDifficulty().equals("Intermediate") && sorted[i].getQuizNumber() > 3)
				quizArr[i].setText(String.format("%d - %s", sorted[i].getQuizNumber() - 3, sorted[i].getQuizName()));

			else
				quizArr[i].setText(String.format("%d - %s", sorted[i].getQuizNumber(), sorted[i].getQuizName()));

			scoreArr[i].setText(sorted[i].getStringScore());
			scoreArr[i].setForeground(scoreColour(sorted[i].getPercentageScore()));

			smiley[i].setIcon(calculateSmiley(sorted[i].getPercentageScore()));

		}

	}

	// Event Handlers

	@Override
	public void actionPerformed(ActionEvent e) {

		// Update chart based on score filter
		if (e.getSource() == scoreFilter) {

			if (currentFilter == 0) {

				currentFilter = 1;
				scoreFilter.setIcon(new ImageIcon("images/chevDown.jpg"));

			} else {

				currentFilter = 0;
				scoreFilter.setIcon(new ImageIcon("images/chevUp.jpg"));

			}

			difficultyFilter.setEnabled(true);

		}

		updateChart(currentFilter);
		resultsPane.repaint();

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

		JLabel lbl = (JLabel) e.getSource();

		// Update chart with difficulty filter
		if (lbl == difficultyFilter) {

			difficultyFilter.setEnabled(false);

			currentFilter = -1;

			updateChart(currentFilter);

			resultsPane.repaint();

		}

		// Open lesson
		else {

			// Get name of lesson - between "<html><u>...<u><html>"
			String lesson = lbl.getText().substring(9, lbl.getText().length() - 9);

			// Open respective lesson
			if (lesson.equals("1 - Intro to Intervals")) {
				Initialize.lessonGUI[0].LessonTempPane.setVisible(true);
			}

			else if (lesson.equals("1 - Perfect & Major Intervals")) {
				Initialize.lessonGUI[1].LessonTempPane.setVisible(true);
			}

			else if (lesson.equals("2 - Minor Intervals" + "")) {
				Initialize.lessonGUI[2].LessonTempPane.setVisible(true);
			}

			else if (lesson.equals("1 - Augmented & Diminished")) {
				Initialize.lessonGUI[3].LessonTempPane.setVisible(true);

			}

			// Hide current pane
			resultsPane.setVisible(false);

			// Change sidebar
			Initialize.sidebar.setDark();
			Initialize.sidebar.isClicked = null;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		JLabel lbl = (JLabel) e.getSource();

		// Enter hover state - Color, cursor change
		lbl.setForeground(Colours.purple);
		lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));

	}

	@Override
	public void mouseExited(MouseEvent e) {

		JLabel lbl = (JLabel) e.getSource();

		// Exit hover state - Color, cursor change
		lbl.setForeground(Color.BLACK);
		lbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

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
