package com.mmarin.tictactoe.core;

/**
 * 
 * Class for evaluating moves and reporting game status after move.
 * 
 * @author mmarin
 *
 */
public class MoveEvaluator {
	
	
	/**
	 * 
	 * @param cell cell
	 * @param markType markType
	 * @return true if move is valid, false otherwise
	 */
	public static boolean evaluateMove(Board board,
					            	   Cell cell) {
		
		if (cell.getRow() < 0 
				||
				cell.getRow() >= Board.NUMROWS
				||
				cell.getColumn() < 0
				||
				cell.getColumn() >= Board.NUMROWS) {
			
			return false;
			
		}
		
		Cell temp = board.getCell(cell.getRow(), cell.getColumn());

		return MarkType.__.equals(temp.getMarkType()) ? true : false;
	}
	
	/**
	 * 
	 * Evaluate do we have a winner.
	 * 
	 * @param board board
	 * @param markType markType
	 * @return true if mark has won the game.
	 */
	public static boolean hasWon(Board board,
							     MarkType markType) {
		
		
		
		return (markType.equals(board.getCell(0, 0).getMarkType()) &&
			    markType.equals(board.getCell(1, 0).getMarkType()) &&
				markType.equals(board.getCell(2, 0).getMarkType()))
			    ||
			   (markType.equals(board.getCell(0, 1).getMarkType()) &&
			    markType.equals(board.getCell(1, 1).getMarkType()) &&
				markType.equals(board.getCell(2, 1).getMarkType()))
			    ||
			   (markType.equals(board.getCell(0, 2).getMarkType()) &&
			    markType.equals(board.getCell(1, 2).getMarkType()) &&
				markType.equals(board.getCell(2, 2).getMarkType()))			
			    ||
			   (markType.equals(board.getCell(0, 0).getMarkType()) &&
			    markType.equals(board.getCell(0, 1).getMarkType()) &&
				markType.equals(board.getCell(0, 2).getMarkType()))
			    ||
			   (markType.equals(board.getCell(1, 0).getMarkType()) &&
			    markType.equals(board.getCell(1, 1).getMarkType()) &&
				markType.equals(board.getCell(1, 2).getMarkType()))
			    ||
			   (markType.equals(board.getCell(2, 0).getMarkType()) &&
			    markType.equals(board.getCell(2, 1).getMarkType()) &&
				markType.equals(board.getCell(2, 2).getMarkType()))
			    ||
			   (markType.equals(board.getCell(0, 0).getMarkType()) &&
			    markType.equals(board.getCell(1, 1).getMarkType()) &&
				markType.equals(board.getCell(2, 2).getMarkType()))
			    ||
			   (markType.equals(board.getCell(0, 2).getMarkType()) &&
			    markType.equals(board.getCell(1, 1).getMarkType()) &&
				markType.equals(board.getCell(2, 0).getMarkType()))
			   ? true : false;
		
		
	}
	
	
}
