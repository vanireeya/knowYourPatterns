package edu.sjsu.cmpe202.kyp.strategy.impl;

import java.util.ArrayList;

import edu.sjsu.cmpe202.kyp.Observer.IObserver;
import edu.sjsu.cmpe202.kyp.Observer.ISubject;
import edu.sjsu.cmpe202.kyp.Observer.Scores;
import edu.sjsu.cmpe202.kyp.strategy.DifficultyLevel;

public class Hard extends AbstractGameStrategy {
	int score;
	ArrayList<IObserver> observers = new ArrayList<>();

	public void calculateScore(boolean answer, int imagesOpened) {
		if (answer == true) {
			// int index = getImageCardOpened();
			// score.calculatePoints(10 + 4 - index);
			score = 10+4-imagesOpened;
		} else {
			score = -5;
			// score.calculatePoints(-5);
		}
		notifyObserver();
	}

	@Override
	public DifficultyLevel getDifficultyLevel() {
		return DifficultyLevel.HARD;
	}

	@Override
	public void registerObserver(IObserver obj) {
		observers.add(obj);
	}

	@Override
	public void notifyObserver() {
		for (int i = 0; i < observers.size(); i++) {
			IObserver observer = observers.get(i);
			observer.updatedScore(score);
		}

	}

}
