package com.inmobi.bowling;

public class Frame {
	/**
	 * Get current score for the frame,
	 * 
	 * But this is now a stupid function that does nothing?!
	 * @return
	 */
	public int getScore() {
		return currentScore;
	}
	
	/**
	 * Do we create a throw class? Does it even make sense?
	 * 
	 * No, we don't need a throw class, its just an action that has the score for that
	 * instance, why can't we just use an integer here
	 * 
	 * Lets also implement it
	 * @param pins
	 */
	public void add(int pins) {
		currentScore += pins;
	}
	
	private int currentScore = 0;
}
