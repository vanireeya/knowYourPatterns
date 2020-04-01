package edu.sjsu.cmpe202.kyp.memento;

import java.util.ArrayList;

public class Caretaker {
	private Memento mementos;
//	private boolean easyFlag;
//	private boolean mediumFlag;
//	private boolean hardFlag;

	public Caretaker() {
		mementos = new Memento();
	}

	public void addMemento(Memento m) {
		mementos = m;
	}

	public Memento getMemento() {
		return mementos;
	}

//	public boolean isEasyFlag() {
//		return easyFlag;
//	}
//
//	public void setEasyFlag(boolean easyFlag) {
//		this.easyFlag = easyFlag;
//	}
//
//	public boolean isMediumFlag() {
//		return mediumFlag;
//	}
//
//	public void setMediumFlag(boolean mediumFlag) {
//		this.mediumFlag = mediumFlag;
//	}
//
//	public boolean isHardFlag() {
//		return hardFlag;
//	}
//
//	public void setHardFlag(boolean hardFlag) {
//		this.hardFlag = hardFlag;
//	}

}
