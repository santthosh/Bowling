package com.inmobi.bowling;

public class Game {
	/**
	 * Get current score for the game,
	 * @return
	 */
	public int getScore() {
		return getScoreForFrame(getCurrentFrame());
		// But look here this one fails? because for the first throw getScoreForFrame(0) will be called
	}
	
	/**
	 * @param pins
	 */
	public void add(int pins) {
		gameThrows[currentThrow++] = pins;
		currentScore += pins; // This is where the problem is 
	}
	
	/**
	 * There is a way to get the current frame
	 * First throw 1
	 * Second throw 1
	 * Third throw 2
	 * Fourth throw 2 so on..
	 */
	public int getCurrentFrame() {
		return 1 + (currentThrow - 1) /2;
	}
	
	/**
	 * Go down the frames, and for each pair of throws, accumulate the scores and return that
	 * 
	 * But is Game the right place to put this method? Why or why not?
	 * 
	 * Why not? It violates Single Responsibility Principle
	 * @param frame
	 * @return
	 */
	public int getScoreForFrame(int frame) {
		int score = 0;
		
		for(int ball=0,currentFrame = 0;currentFrame < frame;currentFrame++) {
			int firstThrow = gameThrows[ball++];
			int secondThrow = gameThrows[ball++];
			int frameScore = firstThrow + secondThrow;
			
			//I did add a logic to check for the frameScore == 10 i.e. Spare
			if(frameScore == 10) {
				score += frameScore + gameThrows[ball];
			} else {
				score += frameScore;
			}
		}
		return score;
	}
	
	private int currentScore = 0;
	private int[] gameThrows = new int[21]; //Ugly magic number.. maximum number of throws is 21	
	private int currentThrow = 0;
}
