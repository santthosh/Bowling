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
		scorer.addThrow(pins);
	    adjustCurrentFrame(pins);
	}
	
	/**
	 * method that knows the logic of strike and spare and adjusts the current frame
	 * accordingly
	 * @param pins
	 */
	private void adjustCurrentFrame(int pins) {
	    if (firstThrowInFrame == true)
	    {
	      if (adjustFrameForStrike(pins) == false)
	        firstThrowInFrame = false;
	    }
	    else
	    {
	      firstThrowInFrame=true;
	      advanceFrame();
	    }
	 }

	  private boolean adjustFrameForStrike(int pins) {
	    if (pins == 10) {
	      advanceFrame();
	      return true;
	    }
	    return false;
	  }  

	  private void advanceFrame() {
	    currentFrame = Math.min(10, currentFrame + 1);
	  }
	
	/**
	 * There is a way to get the current frame
	 * First throw 1
	 * Second throw 1
	 * Third throw 2
	 * Fourth throw 2 so on..
	 */
	public int getCurrentFrame() {
		return currentFrame;
		//return 1 + (currentThrow - 1) /2; //Now with the concept of Strike I realize this is a very very bad idea!
	}
	
	/**
	 * Now its more cleaner
	 * @param frame
	 * @return
	 */
	public int getScoreForFrame(int frame) {
		return scorer.scoreForFrame(frame);
	}
	
	private int currentFrame = 0;
	private boolean firstThrowInFrame = true;
    private Scorer scorer = new Scorer();
}
