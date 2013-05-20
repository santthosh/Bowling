package com.inmobi.bowling.test;

import com.inmobi.bowling.Frame;

import junit.framework.TestCase;

public class TestFrame extends TestCase {
	
	/**
	 * A frame might provide its score, the player's score at the current instance, 
	 * number of pins in each throw, whether it was a strike or spare
	 * 
	 * @param name
	 */
	public TestFrame(String name) {
		super(name);
	}
	
	/**
	 * Let me write a basic test case for initial/pre condition, 
	 * i.e. when no throws have happened yet
	 */
	public void testScoreNoThrows() {
		Frame frame = new Frame();
		assertEquals(0,frame.getScore());
	}
}