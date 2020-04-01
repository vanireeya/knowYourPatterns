package edu.sjsu.cmpe202.kyp.strategy;

import edu.sjsu.cmpe202.kyp.Observer.Scores;
import edu.sjsu.cmpe202.kyp.strategy.impl.Easy;
import edu.sjsu.cmpe202.kyp.strategy.impl.Hard;
import edu.sjsu.cmpe202.kyp.strategy.impl.Medium;

public class GameStrategyFactory {


	
	public GameStrategy getStrategy(DifficultyLevel level) {
		GameStrategy gameStrategy = null;
		if (DifficultyLevel.EASY.equals(level)) {
			return new Easy();
		} else if (DifficultyLevel.MEDIUM.equals(level)) {
			return new Medium();
		} else if (DifficultyLevel.HARD.equals(level)) {
			return new Hard();
		}
		if(gameStrategy==null){
			throw new IllegalArgumentException(level.toString());
		}
		return null;
		
	}

}
