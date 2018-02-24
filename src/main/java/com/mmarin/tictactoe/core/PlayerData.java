package com.mmarin.tictactoe.core;

import java.math.BigDecimal;

/**
 * Data about player.
 * 
 * 
 * @author mmarin
 *
 */
public class PlayerData {
	
	private final String username;
	private int wins;
	private int losses;
	private int draws;
	
	
	
	public PlayerData(String username) {
		
		this.username = username;
		this.wins = 0;
		this.losses = 0;
		this.draws = 0;
	
	}

	public int getWins() {
		return wins;
	}
	
	public void incrementWins() {
		this.wins++;
	}
	
	public int getLosses() {
		return losses;
	}
	
	public void incrementLosses() {
		this.losses++;
	}
	
	public int getDraws() {
		return draws;
	}
	
	public void incrementDraws() {
		this.draws++;;
	}

	public String getUsername() {
		return username;
	}

	public BigDecimal getWinPercentage() {
		
		BigDecimal totalGames = BigDecimal.valueOf(wins + losses);
		
		if (totalGames.compareTo(BigDecimal.ZERO) == 0) {
			
			return BigDecimal.ZERO;
			
		}
		
		return BigDecimal.valueOf(wins).divide(totalGames).multiply(BigDecimal.valueOf(100)).setScale(2);
		
	}
}
