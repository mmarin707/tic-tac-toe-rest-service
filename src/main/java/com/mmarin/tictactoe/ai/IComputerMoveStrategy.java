package com.mmarin.tictactoe.ai;

import java.math.BigDecimal;

import com.mmarin.tictactoe.core.Board;
import com.mmarin.tictactoe.core.Cell;
import com.mmarin.tictactoe.core.MarkType;
import com.mmarin.tictactoe.core.PlayerData;

/**
 * 
 * Interface for certain strategy. Strategies are selected by players win percentage.
 * 
 * @author mmarin
 *
 */
public interface IComputerMoveStrategy {
	
	public static final BigDecimal PERCENT_30 = BigDecimal.valueOf(30);
	public static final BigDecimal PERCENT_90 = BigDecimal.valueOf(90);
	
	/**
	 * Match strategy.
	 * 
	 * @param opponent opponent
	 * @return true if matche, false otherwise
	 */
	public boolean matches(PlayerData opponent);
	
	/**
	 * 
	 * Evaluate and generate best move.
	 * 
	 * @param board board
	 * @return {@link Cell}
	 */
	public Cell move(Board board,
					 MarkType markType);
	

	
}
