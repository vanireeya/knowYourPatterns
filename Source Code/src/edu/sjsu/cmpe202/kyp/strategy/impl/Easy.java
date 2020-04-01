package edu.sjsu.cmpe202.kyp.strategy.impl;

import java.util.ArrayList;

import edu.sjsu.cmpe202.kyp.Observer.IObserver;
import edu.sjsu.cmpe202.kyp.Observer.Scores;
import edu.sjsu.cmpe202.kyp.strategy.DifficultyLevel;

public class Easy extends AbstractGameStrategy {
	int score;
	ArrayList<IObserver> observers = new ArrayList<>();

	@Override
	public DifficultyLevel getDifficultyLevel() {
		return DifficultyLevel.EASY;
	}

	public void calculateScore(boolean answer,int imagesOpened) {
		if (answer == true) {
			score = 10;
		} else {
			score = 0;
		}
		notifyObserver();
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
