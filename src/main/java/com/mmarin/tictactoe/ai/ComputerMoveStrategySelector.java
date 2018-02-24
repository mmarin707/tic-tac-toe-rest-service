package com.mmarin.tictactoe.ai;

import java.util.List;
import java.util.Random;

import com.mmarin.tictactoe.core.PlayerData;

/**
 * 
 * Selector for selecting computers strategy.
 * 
 * @author mmarin
 *
 */
public class ComputerMoveStrategySelector implements IComputerMoveStrategySelector {

	@Override
	public IComputerMoveStrategy select(PlayerData opponent) {
		
		for (IComputerMoveStrategy strategy : iComputerMoveStrategies) {
			
			if (strategy.matches(opponent)) {
				
				return strategy;
				
			}
			
		}
		
		Random random = new Random();
		
		return iComputerMoveStrategies.get(random.nextInt(iComputerMoveStrategies.size()));
		
	}

	//strategy list
	private List<IComputerMoveStrategy> iComputerMoveStrategies;

	/**
	 * 
	 * @param iComputerMoveStrategies IOC
	 */
	public void setiComputerMoveStrategies(List<IComputerMoveStrategy> iComputerMoveStrategies) {
		this.iComputerMoveStrategies = iComputerMoveStrategies;
	}
	
}
