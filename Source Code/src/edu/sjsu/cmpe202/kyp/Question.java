package edu.sjsu.cmpe202.kyp;

public class Question {

	String question,answer,choosenAnswer;
	String[] options= new String[4];
	String[] images = new String[4];
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	public String[] getImages() {
		return images;
	}
	public void setImages(String[] images) {
		this.images = images;
	}
	public String getChoosenAnswer() {
		return choosenAnswer;
	}
	public void setChoosenAnswer(String choosenAnswer) {
		this.choosenAnswer = choosenAnswer;
	}	

}
