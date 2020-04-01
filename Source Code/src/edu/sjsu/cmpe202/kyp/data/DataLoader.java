package edu.sjsu.cmpe202.kyp.data;

import java.util.List;

import edu.sjsu.cmpe202.kyp.Question;

public interface DataLoader {

	List<Question> loadData(String difficultyLevel);

}
