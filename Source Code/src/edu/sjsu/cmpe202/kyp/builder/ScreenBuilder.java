package edu.sjsu.cmpe202.kyp.builder;

import javax.swing.JFrame;

public interface ScreenBuilder {

	void buildBorder();

	void buildHeader();

	void buildContent();

	void buildScore();

	JFrame getScreen();

}
