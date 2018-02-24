package com.mmarin.tictactoe.core;

/**
 * 
 * Player involved in game.
 * 
 * @author mmarin
 *
 */
public class Player {
	
	public static final String COMPUTER = "computer";
	
	
	private final String username;
	private final MarkType markType;
	
	public Player(String username, MarkType markType) {

		this.username = username;
		this.markType = markType;
		
	}

	public String getUsername() {
		return username;
	}

	public MarkType getMarkType() {
		return markType;
	}

}
