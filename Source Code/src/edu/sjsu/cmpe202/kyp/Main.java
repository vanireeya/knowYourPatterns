package edu.sjsu.cmpe202.kyp;

import java.awt.EventQueue;

import javax.swing.JFrame;

import edu.sjsu.cmpe202.kyp.Observer.IObserver;
import edu.sjsu.cmpe202.kyp.Observer.Scores;
import edu.sjsu.cmpe202.kyp.builder.HomeScreenBuilder;
import edu.sjsu.cmpe202.kyp.memento.Caretaker;
import edu.sjsu.cmpe202.kyp.memento.Originator;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final IObserver score = (IObserver) new Scores();
					final Caretaker caretaker = new Caretaker();
					final Originator originator = new Originator();
					JFrame frame = new HomeScreenBuilder((Scores) score, caretaker, originator).buildScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
