package edu.sjsu.cmpe202.kyp.decorator;

public class RedColorDecorator implements IColorDecorator {


	@Override
	public String setColor(String selectedAnswer) {
		String decoratedString = "<html><font color='red'>Your Answer : " + selectedAnswer + "</font></html>";
		return decoratedString;
	}

}