package com.mmarin.tictactoe.ai;

import com.mmarin.tictactoe.core.Board;
import com.mmarin.tictactoe.core.Cell;
import com.mmarin.tictactoe.core.MarkType;
import com.mmarin.tictactoe.core.PlayerData;

/**
 * 
 * This class implements strong computer strategy.
 * 
 * @author mmarin
 *
 */
public class StrongComputerMoveStrategy implements IComputerMoveStrategy {

	@Override
	public boolean matches(PlayerData opponent) {
		
		return PERCENT_90.compareTo(opponent.getWinPercentage()) <= 0;
	}

	@Override
	public Cell move(Board board, MarkType markType) {
			
		AIPlayerMinimax player = new AIPlayerMinimax(board);
		player.setSeed(markType);
		
		int[] move = player.move();
		
		return new Cell(markType, move[0], move[1]);
		
	}
	
		
}
