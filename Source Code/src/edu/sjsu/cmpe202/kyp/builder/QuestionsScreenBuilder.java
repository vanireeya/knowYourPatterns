package edu.sjsu.cmpe202.kyp.builder;

import java.awt.Button;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import edu.sjsu.cmpe202.kyp.Question;
import edu.sjsu.cmpe202.kyp.Observer.IObserver;
import edu.sjsu.cmpe202.kyp.Observer.Scores;
import edu.sjsu.cmpe202.kyp.memento.Caretaker;
import edu.sjsu.cmpe202.kyp.memento.Originator;
import edu.sjsu.cmpe202.kyp.state.FourImage;
import edu.sjsu.cmpe202.kyp.state.IImageState;
import edu.sjsu.cmpe202.kyp.state.IImageStateManager;
import edu.sjsu.cmpe202.kyp.state.NoImage;
import edu.sjsu.cmpe202.kyp.state.OneImage;
import edu.sjsu.cmpe202.kyp.state.ThreeImage;
import edu.sjsu.cmpe202.kyp.state.TwoImage;
import edu.sjsu.cmpe202.kyp.strategy.DifficultyLevel;
import edu.sjsu.cmpe202.kyp.strategy.GameStrategy;
import edu.sjsu.cmpe202.kyp.strategy.GameStrategyFactory;
import edu.sjsu.cmpe202.kyp.strategy.impl.AbstractGameStrategy;

public class QuestionsScreenBuilder extends AbstractGameScreenBuilder implements IObserver, IImageStateManager {

	public int count, imageCounter;
	private ButtonGroup btngrp;
	String question;
	JRadioButton rdbtnOption;
	JRadioButton rdbtnOption_1;
	JRadioButton rdbtnOption_2;
	JRadioButton rdbtnOption_3;
	JLabel imageLabel;
	JPanel panel;
	Image image2;

	JLabel lblQuestions;
	JLabel lblScore;
	private List<Question> model = new ArrayList<>();
	private GameStrategy currentStrategy;
	private GameStrategyFactory gameStrategyFactory = new GameStrategyFactory();

	private IImageState currentState;
	private NoImage noImage;
	private OneImage oneImage;
	private TwoImage twoImage;
	private ThreeImage threeImage;
	private FourImage fourImage;
	Scores score;
	QuestionsScreenBuilder sb;

	Originator originator;
	Caretaker caretaker;

	public QuestionsScreenBuilder(DifficultyLevel difficultyType, Scores sc, Caretaker ct, Originator og) {
		originator = og;
		score = sc;
		caretaker = ct;
		imageCounter = -1;

		currentStrategy = gameStrategyFactory.getStrategy(difficultyType);
		originator.setState(currentStrategy.getQuestios(), difficultyType.toString(), 0);

		if (originator.restoreState(caretaker.getMemento()) != null
				&& originator.restoreState(caretaker.getMemento()).size() > 0) {
			this.model = originator.restoreState(caretaker.getMemento());
			count = originator.restoreCount(caretaker.getMemento());
		} else {
			this.model = currentStrategy.getQuestios();
			count = 0;
		}

		currentStrategy.registerObserver(score);
		score.registerObserver(this);

		noImage = new NoImage(this);
		oneImage = new OneImage(this);
		twoImage = new TwoImage(this);
		threeImage = new ThreeImage(this);
		fourImage = new FourImage(this);
		currentState = noImage;

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

		panel = new JPanel();
		panel.setBounds(200, 105, 512, 303);
		Image image = null;
		try {
			image = ImageIO.read(new File("src/resources/Starter_img.jpg")).getScaledInstance(panel.getWidth(),
					panel.getHeight(), Image.SCALE_SMOOTH);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// ImageIcon imageIcon = new ImageIcon(image);
		imageLabel = new JLabel(new ImageIcon(image));
		panel.add(imageLabel);
		contentPane.add(panel);

		lblScore = new JLabel("Score: 55");

		lblScore.setForeground(SystemColor.windowBorder);
		lblScore.setFont(new Font("Calibri", Font.PLAIN, 21));
		lblScore.setBounds(24, 76, 130, 45);

		contentPane.add(lblScore);

		lblQuestions = new JLabel();
		lblQuestions.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblQuestions.setBounds(56, 442, 803, 58);
		lblQuestions.setText("<html>" + "Question: " + " " + "</html>");
		contentPane.add(lblQuestions);

		btngrp = new ButtonGroup();

		rdbtnOption = new JRadioButton("");
		rdbtnOption.setBounds(213, 507, 260, 23);
		rdbtnOption.setActionCommand("option 1");
		contentPane.add(rdbtnOption);

		rdbtnOption_1 = new JRadioButton("");
		rdbtnOption_1.setBounds(213, 533, 260, 23);
		rdbtnOption_1.setActionCommand("option 2");
		contentPane.add(rdbtnOption_1);

		rdbtnOption_2 = new JRadioButton("");
		rdbtnOption_2.setBounds(213, 559, 260, 23);
		rdbtnOption_2.setActionCommand("option 3");

		contentPane.add(rdbtnOption_2);

		rdbtnOption_3 = new JRadioButton("");
		rdbtnOption_3.setBounds(213, 585, 260, 23);
		rdbtnOption_3.setActionCommand("option 4");

		contentPane.add(rdbtnOption_3);

		btngrp.add(rdbtnOption);
		btngrp.add(rdbtnOption_1);
		btngrp.add(rdbtnOption_2);
		btngrp.add(rdbtnOption_3);

		Button button = new Button("Hints");
		button.setForeground(SystemColor.windowBorder);
		button.setFont(new Font("Calibri", Font.PLAIN, 21));
		button.setBackground(SystemColor.activeCaption);
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				currentState.clickedHint();
				imageCounter++;
				try {
					setImage();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button.setBounds(750, 401, 89, 35);
		contentPane.add(button);

//		JButton button_1 = new JButton("Next");
//		button_1.setForeground(SystemColor.windowBorder);
//		button_1.setFont(new Font("Calibri", Font.PLAIN, 21));
//		button_1.setBackground(SystemColor.activeCaption);
//		button_1.setBounds(743, 615, 96, 35);
//		button_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				String radioValue = getRadioValue();
//				if (!radioValue.equals("")) {
//					model.get(getCount()).setChoosenAnswer(radioValue);
//					currentStrategy.calculateScore(isCorrectAnswer(), currentState.getImageOpenedCount());
//					setCount();
//					originator.setState(model, ((AbstractGameStrategy) currentStrategy).getDifficultyLevel().toString(),
//							count);
//					imageCounter = -1;
//					if (getCount() < 5) {
//
//						try {
//							setScreen();
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					} else {
//						screen.dispose();
//						JFrame fp = new FinalScreenBuilder(model, (Scores) score, caretaker, originator,
//								((AbstractGameStrategy) currentStrategy).getDifficultyLevel().toString()).buildScreen();
//						fp.setVisible(true);
//					}
//
//				}
//
//			}
//
//		});
//		button_1.setBounds(522, 559, 70, 22);
//		contentPane.add(button_1);

		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.setForeground(SystemColor.windowBorder);
		btnNewButton_1.setFont(new Font("Calibri", Font.PLAIN, 21));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setBounds(743, 615, 96, 35);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String radioValue = getRadioValue();
				if (!radioValue.equals("")) {
					model.get(getCount()).setChoosenAnswer(radioValue);
					currentStrategy.calculateScore(isCorrectAnswer(), currentState.getImageOpenedCount());
					setCount();
					originator.setState(model, ((AbstractGameStrategy) currentStrategy).getDifficultyLevel().toString(),
							count);
					imageCounter = -1;
					if (getCount() < 5) {

						try {
							setScreen();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						screen.dispose();
						JFrame fp = new FinalScreenBuilder(model, (Scores) score, caretaker, originator,
								((AbstractGameStrategy) currentStrategy).getDifficultyLevel().toString()).buildScreen();
						fp.setVisible(true);
					}

				}

			}

		
		});
		contentPane.add(btnNewButton_1);

		
		
		
		
		JButton btnNewButton = new JButton("Home ");
		btnNewButton.setForeground(SystemColor.windowBorder);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 21));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(743, 92, 96, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				caretaker.addMemento(originator.save());
				screen.dispose();
				JFrame frame = new HomeScreenBuilder(score, caretaker, originator).buildScreen();
				frame.setVisible(true);
			}
		});

		try {
			setScreen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private boolean isCorrectAnswer() {
		return model.get(getCount()).getChoosenAnswer().equals(model.get(getCount()).getAnswer());
	}

	private void setScreen() throws IOException {
		currentState = noImage;
		String question = model.get(count).getQuestion();
		lblQuestions.setText("<html>" + "Question: " + (count + 1) + " " + question + "</html>");

		btngrp.clearSelection();
		rdbtnOption.setText(model.get(count).getOptions()[0]);
		rdbtnOption_1.setText(model.get(count).getOptions()[1]);
		rdbtnOption_2.setText(model.get(count).getOptions()[2]);
		rdbtnOption_3.setText(model.get(count).getOptions()[3]);

		lblScore.setText("Score: " + ((Scores) score).getCurrentScore());

		setImage();
	}

	public void setImage() throws IOException {
		if (imageCounter >= 0 && imageCounter < 4) {
			image2 = ImageIO.read(new File("src/resources/" + model.get(count).getImages()[imageCounter]))
					.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
			imageLabel.setIcon(new ImageIcon(image2));
		} else if (imageCounter == -1) {
			image2 = ImageIO.read(new File("src/resources/Starter_img.jpg")).getScaledInstance(panel.getWidth(),
					panel.getHeight(), Image.SCALE_SMOOTH);
			imageLabel.setIcon(new ImageIcon(image2));
		}
	}

	public void setCount() {
		if (count < 5) {
			count++;
		}
	}

	public int getCount() {
		return count;
	}

	public String getRadioValue() {
		if (rdbtnOption.isSelected()) {
			return rdbtnOption.getText();
		} else if (rdbtnOption_1.isSelected()) {
			return rdbtnOption_1.getText();
		} else if (rdbtnOption_2.isSelected()) {
			return rdbtnOption_2.getText();
		} else if (rdbtnOption_3.isSelected()) {
			return rdbtnOption_3.getText();
		} else {
			return "";
		}

	}

	@Override
	protected void buildScore() {

	}

	@Override
	public void updatedScore(int score1) {
		lblScore.setText("Score: " + ((Scores) score).getCurrentScore());

	}

	@Override
	public void setStateNoImage() {
		currentState = noImage;

	}

	@Override
	public void setStateOneImage() {
		currentState = oneImage;

	}

	@Override
	public void setStateTwoImage() {
		currentState = twoImage;

	}

	@Override
	public void setStateThreeImage() {
		currentState = threeImage;

	}

	@Override
	public void setStateFourImage() {
		currentState = fourImage;

	}

}
