package edu.sjsu.cmpe202.kyp.data;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import edu.sjsu.cmpe202.kyp.Model;
import edu.sjsu.cmpe202.kyp.Question;

public class DataLoaderImpl implements DataLoader {
	ArrayList<String> tempArray = new ArrayList<>();
	ArrayList<Question> questions = new ArrayList<>();
	@Override
	public List<Question> loadData(String difficultyLevel) {
		return getQuestionSet(difficultyLevel.toLowerCase());
		
	}

	public Iterator getObject(String keyType) {
		try {

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("src/resources/QuizQuestions.json"));

			JSONObject jsonObject = (JSONObject) obj;
			Map type = ((Map) jsonObject.get("type"));
			Iterator<Map.Entry> itr1 = type.entrySet().iterator();

			while (itr1.hasNext()) {
				Map.Entry pair = itr1.next();
				if (pair.getKey().equals(keyType)) {

					JSONArray ja = (JSONArray) pair.getValue();
					Iterator itr2 = ja.iterator();

					return itr2;

				}
//				else if (pair.getKey().equals(keyType)) {
//					JSONArray ja = (JSONArray) pair.getValue();
//					Iterator itr2 = ja.iterator();
//
//					return itr2;
//				} else {
//					JSONArray ja = (JSONArray) pair.getValue();
//					Iterator itr2 = ja.iterator();
//
//					return itr2;
//				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Question> getQuestionSet(String difficultyType) {
		Iterator itr2 = getObject(difficultyType);
		while (itr2.hasNext()) {
			int i = 0;
			Question m1 = new Question();
			Iterator<Map.Entry> itr1 = ((Map) itr2.next()).entrySet().iterator();
			while (itr1.hasNext()) {
				Map.Entry pair1 = itr1.next();
				if (pair1.getKey().equals("question")) {
					m1.setQuestion(pair1.getValue().toString());
				} else if (pair1.getKey().equals("answer")) {
					m1.setAnswer(pair1.getValue().toString());
				} else if (pair1.getKey().equals("options")) {
					JSONArray ja1 = (JSONArray) pair1.getValue();
					tempArray.clear();
					for (int j = 0; j < ja1.size(); j++) {
						tempArray.add(ja1.get(j).toString());
					}
					m1.setOptions(tempArray.toArray(new String[0]));
				} else if (pair1.getKey().equals("images")) {
					JSONArray ja1 = (JSONArray) pair1.getValue();
					tempArray.clear();
					for (int j = 0; j < ja1.size(); j++) {
						tempArray.add(ja1.get(j).toString());
					}
					m1.setImages(tempArray.toArray(new String[0]));
				}
			}
			questions.add(m1);
			i++;
		}

		return questions;
	}

	

}
