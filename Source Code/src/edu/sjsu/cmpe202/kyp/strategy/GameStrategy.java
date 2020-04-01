package edu.sjsu.cmpe202.kyp.strategy;

import java.util.List;

import edu.sjsu.cmpe202.kyp.Question;
import edu.sjsu.cmpe202.kyp.Observer.ISubject;
import edu.sjsu.cmpe202.kyp.Observer.Scores;

public interface GameStrategy extends ISubject{

	List<Question> getQuestios();

	void calculateScore(boolean correctAnswer, int ImagesOpened);

//	void registerObserver(Scores score);
	
}
