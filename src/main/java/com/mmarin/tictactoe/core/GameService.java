package com.mmarin.tictactoe.core;

/**
 * 
 * This class communicates with {@link Game} class. 
 * Trough this class every move is performed and info retrieved.
 * 
 * @author mmarin
 *
 */
public interface GameService {
	
	/**
	 * 
	 * Create new game;
	 * 
	 * @param player1 player1
	 * @param player2 player2
	 * @return
	 */
	public Game createGame(String player1,
						   String player2);
	
	/**
	 * 
	 * Player move.
	 * 
	 * @param gameId gameId
	 * @param row row
	 * @param column column
	 * @return {@link Game}
	 */
	public Game move(Long gameId,
					 int row,
					 int column);
	
	/**
	 * 
	 * Game status.
	 * 
	 * @param gameId gameId
	 * @return {@link Game}
	 */
	public Game status(Long gameId);
	
	/**
	 * 
	 * Player data.
	 * 
	 * @param username username
	 * @return {@link PlayerData}
	 */
	public PlayerData stats(String username);
	
	
}
