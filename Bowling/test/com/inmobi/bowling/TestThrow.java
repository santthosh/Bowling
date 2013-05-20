package com.inmobi.bowling;

import junit.framework.TestCase;

public class TestThrow extends TestCase {
	
	/**
	 * What should be the behavior of the throw object?
	 * It holds the number of pins knocked by the player.
	 *  
	 * But isn't throw just an action?
	 * Can we focus on an object? -- OK what does that mean?
	 * 
	 * Throw just has getters and setters, doesn't have any behavior, thats what it means.
	 * 
	 * So what do we do now? Can we go higher up the dependency chain to figure it out?
	 * @param name
	 */
	public TestThrow(String name) {
		super(name);
	}
}
