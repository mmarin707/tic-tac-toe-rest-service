package com.mmarin.tictactoe.ai;

import com.mmarin.tictactoe.core.Board;
import com.mmarin.tictactoe.core.Cell;
import com.mmarin.tictactoe.core.MarkType;

/**
 * Source: https://www.ntu.edu.sg/home/ehchua/programming/java/JavaGame_TicTacToe_AI.html
 * 
 * 
 * Abstract superclass for all AI players with different strategies.
 * To construct an AI player:
 * 1. Construct an instance (of its subclass) with the game Board
 * 2. Call setSeed() to set the computer's seed
 * 3. Call move() which returns the next move in an int[2] array of {row, col}.
 *
 * The implementation subclasses need to override abstract method move().
 * They shall not modify Cell[][], i.e., no side effect expected.
 * Assume that next move is available, i.e., not game-over yet.
 */
public abstract class AIPlayer {
	
   protected int ROWS = Board.NUMROWS;  // number of rows
   protected int COLS = Board.NUMCOLUMN;  // number of columns
 
   protected Cell[][] cells; // the board's ROWS-by-COLS array of Cells
   protected MarkType mySeed;    // computer's seed
   protected MarkType oppSeed;   // opponent's seed
 
   /** Constructor with reference to game board */
   public AIPlayer(Board board) {
      cells = board.getCells();
   }
 
   /** Set/change the seed used by computer and opponent */
   public void setSeed(MarkType markType) {
      this.mySeed = markType;
      oppSeed = (mySeed == MarkType.X) ? MarkType.O : MarkType.X;
   }
 
   /** Abstract method to get next move. Return int[2] of {row, col} */
   abstract int[] move();  // to be implemented by subclasses
   
}