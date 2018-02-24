package com.mmarin.tictactoe.storage;

import java.util.HashMap;
import java.util.Map;

import com.mmarin.tictactoe.core.Player;
import com.mmarin.tictactoe.core.PlayerData;

/**
 * 
 * Storage for storing player data.
 * 
 * @author mmarin
 *
 */
public class PlayerDataStorage {

	private static final Map<String, PlayerData> PLAYERDATAMAP = new HashMap<String, PlayerData>();
	
	static {
		
		PlayerData computer = new PlayerData(Player.COMPUTER);
		
		PLAYERDATAMAP.put(Player.COMPUTER, computer);
		
	}
	
	
	public static void put(String username) {
		
		PlayerData playerData = new PlayerData(username);
		
		PlayerData temp = PLAYERDATAMAP.get(username);
		
		if (temp == null) {
			
			PLAYERDATAMAP.put(username, playerData);
			
		}
		
	}
	
	public static PlayerData get(String username) {
		
		return PLAYERDATAMAP.get(username);
		
	}
	
}
