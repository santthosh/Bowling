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
	
	/**
	 * Let add one throw with score 5 to the frame and see what happens?
	 * 
	 * Oops it won't even compile, we didn't think through the throw class isn't it?
	 * 
	 * We'll just 'throw away' the throw class and use basic data type int for that 
	 * 
	 * There are crazy developers right who will add 11 or MAX INT, 
	 * oops no one can score that high unless its Sachin Tendulkar himself - 
	 * BTW what does ST have to do with Bowling?! Shh!! Lets move on..
	 * 
	 * Here is another question, what if I do frame.add(10)? How does getScore 
	 * indicate that its a strike? or if I do frame.add(3) and frame.add(7), then getScore
	 * cannot just 'add' stuff, it has to calculate based on the next frame right, so frames
	 * will have to remember the links. Also what happens for the prev for the first frame?
	 * Magic number -1? 
	 * 
	 * Phew! I'm already sweating..Let me take a step back and see who is holding the frames?
	 * 
	 * Game object! Bingo!
	 * 
	 */
	public void testAddOneThrow() {
		Frame frame = new Frame();
		frame.add(5);
		assertEquals(5,frame.getScore());
	}
}
