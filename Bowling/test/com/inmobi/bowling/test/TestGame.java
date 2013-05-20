package com.inmobi.bowling.test;

import com.inmobi.bowling.Game;

import junit.framework.TestCase;

public class TestGame extends TestCase {
	public TestGame(String name) {
		super(name);
	}
	
	private Game game;
	
	public void setUp() {
		game = new Game();
	}
	
	/**
	 * Let me write a basic test case for initial/pre condition, 
	 * i.e. when no throws have happened yet
	 */
	public void testScoreNoThrows() {
		assertEquals(0,game.getScore());
	}
	
	/**
	 * I've moved the entire structure into Game now!
	 */
	public void testOneThrow() {
		game.add(5);
		assertEquals(5,game.getScore());
	}
	
	/**
	 * Let me test 2 throws
	 */
	public void testTwoThrowsNoMarks() {
		game.add(5);
		game.add(4);
		assertEquals(9,game.getScore());
		assertEquals(1,game.getCurrentFrame());
	}
	
	/**
	 * Let me also try 4 throws without any strike or spare
	 * 
	 * Ooops I need to remember the score history as well i.e. what was the score at that 
	 * frame
	 */
	public void testFourThrowsNoMarks() {
		game.add(5);
		game.add(4);
		game.add(7);
		game.add(2);
		assertEquals(18,game.getScore());
		assertEquals(9,game.getScoreForFrame(1));
		assertEquals(18,game.getScoreForFrame(2));
		assertEquals(2,game.getCurrentFrame());
	}
	
	/**
	 * Let me test a spare
	 */
	public void testSimpleFrameAfterSpare() {
		game.add(3);
		game.add(7); // Thats a spare
		game.add(3);
		game.add(2);
		assertEquals(13,game.getScoreForFrame(1));
		assertEquals(18,game.getScoreForFrame(2));
		assertEquals(18,game.getScore()); // Let me also double check if the score is coming correct
		assertEquals(2,game.getCurrentFrame());
	}
	
	/**
	 * Let me test a strike
	 * 
	 * Oh! No, there is no concept for strike, we need to adjust for that
	 */
	public void testSimpleStrike() {
		game.add(10);
		game.add(6);
		game.add(3);
		assertEquals(19,game.getScoreForFrame(1));
		assertEquals(28,game.getScoreForFrame(2)); // Stupid of me
		assertEquals(28,game.getScore());
		assertEquals(2,game.getCurrentFrame()); // Stupid of me, the current frame is 2
	}
}
