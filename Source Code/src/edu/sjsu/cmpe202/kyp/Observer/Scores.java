package edu.sjsu.cmpe202.kyp.Observer;

import java.util.ArrayList;
import java.util.List;

import edu.sjsu.cmpe202.kyp.Question;

public class Scores implements IObserver, ISubject {
	int finalScore;

	ArrayList<IObserver> observers = new ArrayList<>();

	public Scores() {
		finalScore = 0;
	}

	public int getCurrentScore() {
		return finalScore;
	}


	@Override
	public void updatedScore(int score) {
		finalScore = finalScore + score;
	}

	@Override
	public void registerObserver(IObserver obj) {
		observers.add(obj);
	}

	@Override
	public void notifyObserver() {
		for (int i = 0; i < observers.size(); i++) {
			IObserver observer = observers.get(i);
			 observer.updatedScore(finalScore);
		}

	}

}
