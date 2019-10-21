package com.jv.OopsDesign.observer;

/**
 * Every watcher is supposed to implement this interface.
 * @author jeevi.natarajan
 *
 */
public interface Iwatch {
	public void update(String message);//For simplicity lets say the watcher just prints the message. 
}
