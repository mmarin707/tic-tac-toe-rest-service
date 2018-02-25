package com.mmarin.tictactoe.ai;

import com.mmarin.tictactoe.core.Board;
import com.mmarin.tictactoe.core.Cell;
import com.mmarin.tictactoe.core.MarkType;
import com.mmarin.tictactoe.core.PlayerData;

/**
 * 
 * This class implements weak computer strategy. 
 * 
 * @author mmarin
 *
 */
public class WeakComputerMoveStrategy implements IComputerMoveStrategy {

	private int[][] preferredMoves = {{1, 1}, {0, 0}, {0, 2}, {2, 0}, {2, 2},
			 						  {0, 1}, {1, 0}, {1, 2}, {2, 1}};
	
	
	@Override
	public boolean matches(PlayerData opponent) {
		
		return PERCENT_30.compareTo(opponent.getWinPercentage()) >= 0;
		
	}

	@Override
	public Cell move(Board board, MarkType markType) {
		
		for (int[] move : preferredMoves) {
			
			if(MarkType.__.equals(board.getCell(move[0], move[1]).getMarkType())) {
				
				return new Cell(markType, 
							    move[0], 
							    move[1]);
			}
			
		}
		
		return null;
		
	}
	
}
