package com.mmarin.tictactoe.ai;

import com.mmarin.tictactoe.core.PlayerData;

/**
 * Interface for selecing computer strategy.
 * 
 * @author mmarin
 *
 */
public interface IComputerMoveStrategySelector {
	
	/**
	 *  
	 *  Method for selecting best strategy according to opponents win percentage.
	 *  
	 * @param opponent opponent
	 * @return {@link IComputerMoveStrategy}
	 */
	public IComputerMoveStrategy select(PlayerData opponent);
}
