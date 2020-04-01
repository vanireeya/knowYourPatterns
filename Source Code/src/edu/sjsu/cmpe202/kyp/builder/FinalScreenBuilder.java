package edu.sjsu.cmpe202.kyp.builder;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.sjsu.cmpe202.kyp.Question;
import edu.sjsu.cmpe202.kyp.Observer.Scores;
import edu.sjsu.cmpe202.kyp.decorator.GreenColorDecorator;
import edu.sjsu.cmpe202.kyp.decorator.IColorDecorator;
import edu.sjsu.cmpe202.kyp.decorator.RedColorDecorator;
import edu.sjsu.cmpe202.kyp.memento.Caretaker;
import edu.sjsu.cmpe202.kyp.memento.Originator;
import edu.sjsu.cmpe202.kyp.strategy.DifficultyLevel;
import edu.sjsu.cmpe202.kyp.strategy.GameStrategy;
import edu.sjsu.cmpe202.kyp.strategy.impl.AbstractGameStrategy;

public class FinalScreenBuilder extends AbstractGameScreenBuilder {

	protected List<Question> model = new ArrayList<>();

	private IColorDecorator wrapper = null;
	private String currentStrategy;
	Scores scores;
	Caretaker caretaker;
	Originator originator;

	public FinalScreenBuilder(List<Question> model2, Scores sc, Caretaker ct, Originator og,String currentStrategy) {
		this.model = model2;
		scores = sc;
		caretaker = ct;
		originator = og;
		this.currentStrategy = currentStrategy;
	}

	@Override
	protected void buildBorder() {
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setBounds(100, 100, 930, 700);
		screen.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
	}

	@Override
	protected void buildContent() {
		JLabel lblYourScoreIs = new JLabel("Your score is ");
		lblYourScoreIs.setForeground(SystemColor.windowBorder);
		lblYourScoreIs.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblYourScoreIs.setBounds(364, 99, 136, 37);
		contentPane.add(lblYourScoreIs);

		JLabel lblNewLabel = new JLabel(Integer.toString(scores.getCurrentScore()));
		lblNewLabel.setForeground(SystemColor.windowBorder);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(501, 100, 101, 37);
		contentPane.add(lblNewLabel);

		JLabel lblSummary = new JLabel("Summary");
		lblSummary.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblSummary.setBounds(20, 107, 88, 29);
//		contentPane.add(lblSummary);

		JButton btnNewButton = new JButton("Home");
		btnNewButton.setForeground(SystemColor.windowBorder);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 21));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(796, 99, 108, 34);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				originator.setState(null, currentStrategy,0);
				caretaker.addMemento( originator.save() );
				screen.dispose();
				JFrame frame = new HomeScreenBuilder((Scores) scores, caretaker, originator).buildScreen();
				frame.setVisible(true);
			}
		});

		iterateComponent();

	}

	private void iterateComponent() {
		int pad = 100;
		for (int i = 0; i < 5; i++) {
			JLabel lblQuestions = new JLabel(
					"<html>" + "Question:  " + (i + 1) + " " + model.get(i).getQuestion() + "</html>");
			lblQuestions.setBounds(20, 147 + i * pad, 884, 29);
			contentPane.add(lblQuestions);

			JLabel lblCorrectAnswer = new JLabel("Correct Answer: " + model.get(i).getAnswer());
			lblCorrectAnswer.setBounds(20, 173 + i * pad, 884, 29);
			contentPane.add(lblCorrectAnswer);

			JLabel lblYourAnswer = new JLabel("Your Answer: " + model.get(i).getChoosenAnswer());
			lblYourAnswer.setBounds(20, 202 + i * pad, 884, 22);
			contentPane.add(lblYourAnswer);
 
			if (model.get(i).getAnswer().equals(model.get(i).getChoosenAnswer())) {
				wrapper = new GreenColorDecorator();
				String decoratedString = wrapper.setColor(model.get(i).getChoosenAnswer());
				lblYourAnswer.setText(decoratedString);
			} else {
				wrapper = new RedColorDecorator();
				String decoratedString = wrapper.setColor(model.get(i).getChoosenAnswer());
				lblYourAnswer.setText(decoratedString);
			}
		}

	}

	@Override
	protected void buildScore() {
		// TODO Auto-generated method stub

	}
}
