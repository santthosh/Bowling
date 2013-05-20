package com.inmobi.bowling.test;

import com.inmobi.bowling.Game;

import junit.framework.TestCase;

public class TestGame extends TestCase {
	public TestGame(String name) {
		super(name);
	}
	
	/**
	 * Let me write a basic test case for initial/pre condition, 
	 * i.e. when no throws have happened yet
	 */
	public void testScoreNoThrows() {
		Game game = new Game();
		assertEquals(0,game.getScore());
	}
	
	/**
	 * I've moved the entire structure into Game now!
	 */
	public void testOneThrow() {
		Game game = new Game();
		game.add(5);
		assertEquals(5,game.getScore());
	}
	
	/**
	 * Let me test 2 throws
	 */
	public void testTwoThrowsNoMarks() {
		Game game = new Game();
		game.add(5);
		game.add(4);
		assertEquals(9,game.getScore());
	}
	
	/**
	 * Let me also try 4 throws without any strike or spare
	 * 
	 * Ooops I need to remember the score history as well i.e. what was the score at that 
	 * frame
	 */
	public void testFourThrowsNoMarks() {
		Game game = new Game();
		game.add(5);
		game.add(4);
		game.add(7);
		game.add(2);
		assertEquals(18,game.getScore());
		assertEquals(9,game.getScoreForFrame(1));
		assertEquals(18,game.getScoreForFrame(2));
	}
}
