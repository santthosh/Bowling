package com.inmobi.bowling;

public class Game {
	/**
	 * Get current score for the game,
	 * @return
	 */
	public int getScore() {
		return currentScore;
	}
	
	/**
	 * @param pins
	 */
	public void add(int pins) {
		currentScore += pins;
	}
	
	private int currentScore = 0;
}
