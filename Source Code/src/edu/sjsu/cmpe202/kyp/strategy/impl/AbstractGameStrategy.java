package edu.sjsu.cmpe202.kyp.strategy.impl;

import java.util.List;

import edu.sjsu.cmpe202.kyp.Question;
import edu.sjsu.cmpe202.kyp.Observer.IObserver;
import edu.sjsu.cmpe202.kyp.Observer.ISubject;
import edu.sjsu.cmpe202.kyp.data.DataLoader;
import edu.sjsu.cmpe202.kyp.data.DataLoaderImpl;
import edu.sjsu.cmpe202.kyp.strategy.DifficultyLevel;
import edu.sjsu.cmpe202.kyp.strategy.GameStrategy;

public abstract class AbstractGameStrategy implements GameStrategy {

	private DataLoader dataLoader=new DataLoaderImpl() ;
		
		
	
	
	public List<Question> getQuestios(){
		return dataLoader.loadData(getDifficultyLevel().name());
	}

	public abstract DifficultyLevel getDifficultyLevel();
	
	
//	public void registerObserver(){
//		
//	}
}
