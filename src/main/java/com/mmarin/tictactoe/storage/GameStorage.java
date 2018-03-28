package com.mmarin.tictactoe.storage;

import java.util.HashMap;
import java.util.Map;

import com.mmarin.tictactoe.core.Game;

/**
 * 
 * Storage for logging games.
 * 
 * @author mmarin
 *
 */
public class GameStorage {

	private static final Map<Long, Game> GAMEMAP = new HashMap<Long, Game>();
	
	public synchronized static void put(Game game) {
		
		Game temp = GAMEMAP.get(game.getGameId());
		
		if (temp == null) {
			
			GAMEMAP.put(game.getGameId(), game);
			
		}
		
	}
	
	public static Game get(Long gameId) {
		
		return GAMEMAP.get(gameId);
		
	}
	
}
