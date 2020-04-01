package edu.sjsu.cmpe202.kyp.memento;

import java.util.ArrayList;
import java.util.List;

import edu.sjsu.cmpe202.kyp.Question;
import edu.sjsu.cmpe202.kyp.builder.QuestionsScreenBuilder;

public class Memento {
	private List<Question> easy = new ArrayList<>();
	private List<Question> medium = new ArrayList<>();
	private List<Question> hard = new ArrayList<>();

	private int easyCount;
	private int mediumCount;
	private int hardCount;

	private String state;

	public Memento() {
//		if (difficultyLevel.equalsIgnoreCase("easy")) {
//			easy = qsb;
//			easyCount = count;
//		} else if (difficultyLevel.equalsIgnoreCase("medium")) {
//			medium = qsb;
//			mediumCount = count;
//
//		} else if (difficultyLevel.equalsIgnoreCase("hard")) {
//			hard = qsb;
//			hardCount = count;
//
//		}
	}

	public void mementoSave(List<Question> qsb, String difficultyLevel, int count) {
		if (difficultyLevel.equalsIgnoreCase("easy")) {
			easy = qsb;
			easyCount = count;
		} else if (difficultyLevel.equalsIgnoreCase("medium")) {
			medium = qsb;
			mediumCount = count;

		} else if (difficultyLevel.equalsIgnoreCase("hard")) {
			hard = qsb;
			hardCount = count;

		}
	}

	public List<Question> getState(String difficultyLevel) {

		if (difficultyLevel.equalsIgnoreCase("EASY")) {
			return easy;
		} else if (difficultyLevel.equalsIgnoreCase("MEDIUM")) {
			return medium;
		} else if (difficultyLevel.equalsIgnoreCase("HARD")) {
			return hard;
		}
		return null;
	}

	public int getStateCount(String difficultyLevel) {

		if (difficultyLevel.equalsIgnoreCase("easy")) {
			return easyCount;
		} else if (difficultyLevel.equalsIgnoreCase("medium")) {
			return mediumCount;
		} else if (difficultyLevel.equalsIgnoreCase("hard")) {
			return hardCount;
		}
		return 0;
	}

}
