package edu.sjsu.cmpe202.kyp.memento;

import java.util.ArrayList;
import java.util.List;

import edu.sjsu.cmpe202.kyp.Question;

public class Originator {
	// private String state;

	Memento memento;

	public Originator() {
		memento = new Memento();
	}

	int count;
	private List<Question> state = new ArrayList<>();

	String difficulty;

	/*
	 * lots of memory consumptive private data that is not necessary to define
	 * the state and should thus not be saved. Hence the small memento object.
	 *
	 */

	public void setState(List<Question> state, String difficulty, int count) {
		System.out.println("Originator: Setting state to " + state);
		this.state = state;
		this.difficulty = difficulty;
		this.count = count;
	}

	public Memento save() {
		System.out.println("Originator: Saving to Memento.");

		memento.mementoSave(state, difficulty, count);
		return memento;
	}

	public List<Question> restoreState(Memento m) {
		state = m.getState(difficulty);
		return state;
	}

	public int restoreCount(Memento m) {
		count = m.getStateCount(difficulty);
		return count;
	}

}
