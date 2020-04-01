package edu.sjsu.cmpe202.kyp.decorator;

public class GreenColorDecorator implements IColorDecorator {
	
	
	@Override
	public String setColor(String selectedAnswer) {
		String decoratedString = "<html><font color='green'>Your Answer : " + selectedAnswer + "</font></html>";
		return decoratedString;
	}
}
