package com.mmarin.tictactoe.core;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Class for getting new game id.
 * 
 * @author mmarin
 *
 */
public class GameCounter {

	private static final AtomicLong COUNTER;
	
	static {
		
		COUNTER = new AtomicLong();
	
	}
	
	/**
	 * 
	 * @return new game id
	 */
	public static long getNewGameId() {
		return COUNTER.incrementAndGet();
	}
	
}
