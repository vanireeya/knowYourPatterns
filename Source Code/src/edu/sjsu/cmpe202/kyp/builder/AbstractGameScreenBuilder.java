package edu.sjsu.cmpe202.kyp.builder;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public abstract class AbstractGameScreenBuilder {

	protected JFrame screen = new JFrame();
	protected JPanel contentPane = new JPanel();
	
	public AbstractGameScreenBuilder() {
		screen.setContentPane(contentPane);
	}
	
	protected abstract void buildBorder();
	
	protected void buildHeader(){
		JLabel lblKnowYourPatterns = new JLabel("Know Your Patterns");
		lblKnowYourPatterns.setForeground(SystemColor.activeCaption);
		lblKnowYourPatterns.setFont(new Font("Calibri", Font.BOLD, 60));
		lblKnowYourPatterns.setHorizontalAlignment(SwingConstants.CENTER);
		lblKnowYourPatterns.setBounds(10, 33, 894, 48);
		contentPane.add(lblKnowYourPatterns);
	}
	
	protected abstract void buildContent(); 

	public JFrame buildScreen(){
		buildBorder();
		buildHeader();
		buildContent();
		buildScore();
		return screen;
	}

	protected abstract void buildScore() ;
}
