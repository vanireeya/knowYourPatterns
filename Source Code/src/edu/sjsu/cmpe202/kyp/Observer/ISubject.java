package edu.sjsu.cmpe202.kyp.Observer;

public interface ISubject {
	public void registerObserver(IObserver obj);

	public void notifyObserver();
}
