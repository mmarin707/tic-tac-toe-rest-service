package com.mmarin.tictactoe.core;

import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.Theories;

import com.mmarin.tictactoe.exception.InvalidMoveException;

/**
 * 
 * @author mmarin
 *
 */
public class Game {
	
	public final static int MAX_MOVES = 9;
	
	private final long gameId;
	private final Player player1;
	private final Player player2;
	private final Board board;
	private final List<Move> moves;
	private int moveNumber;
	private Player currentPlayer;
	private GameStatus gameStatus;
	
	public Game(Player player1, Player player2) {

		this.gameId = GameCounter.getNewGameId();
		this.player1 = player1;
		this.player2 = player2;
		
		this.board = new Board();
		
		moves = new ArrayList<Move>();
		
		moveNumber = 0;
		
		//player 1 plays first, must be X
		currentPlayer = player1;
		
		gameStatus = GameStatus.PLAYING;
	}
	
	/**
	 * 
	 * This method performs move on the board for {@link Game#getCurrentPlayer()}.
	 * 
	 * Every move is evaluated, if move is invalid {@link InvalidMoveException} is thrown.
	 * 
	 * After each move game status is evaluated and updated. Every move is stored in moves list
	 * {@link Game#getMoves()}.
	 * 
	 * @param row row
	 * @param column column
	 */
	public void move(int row, int column) {

		//current player je onaj koji igra
		Cell cell = new Cell(currentPlayer.getMarkType(), 
						     row, 
						     column);
		
		if (!MoveEvaluator.evaluateMove(board, cell)) {
			
			throw new InvalidMoveException("Invalid move: " + cell.toString());
			
		}
		
		board.setCell(cell);
		
		moves.add(new Move(++moveNumber, 
						   currentPlayer, 
						   cell));
		
		updateStatus();
		
	}
	
	/**
	 * If player has won change status to GameStatus.FINISHED,
	 * if it is draw change status to GameStatus.DRAW
	 */
	private void updateStatus() {
		
		if (MoveEvaluator.hasWon(board, currentPlayer.getMarkType())) {
			
			gameStatus = GameStatus.FINISHED;

		}
		else if (MAX_MOVES == moveNumber) {
			
			gameStatus = GameStatus.DRAW;
		
		} else {
			
			currentPlayer = getAwaitPlayer();
			
		}
		
	}
	
	/**
	 * 
	 * @return {@link Player} player which waits for its turn.
	 */
	public Player getAwaitPlayer() {
		
		return player1 != currentPlayer ? player1 : player2;
		
	}
	
	/**
	 * 
	 * @return gameId
	 */
	public long getGameId() {
		return gameId;
	}
	
	/**
	 * Number of moves preformed.
	 * 
	 * @return moveNumber
	 */
	public int getMoveNumber() {
		return moveNumber;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	/**
	 * 
	 * Current player whose turn is to play.
	 * If {@link Game#getGameStatus()} is {@link GameStatus#FINISHED} the current player
	 * 
	 * 
	 * @param currentPlayer currentPlayer
	 */
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
	/**
	 * 
	 * Player 1. Always moves first and its {@link MarkType#X}.
	 * 
	 * @return player1
	 */
	public Player getPlayer1() {
		return player1;
	}

	/**
	 *  Player 2. Always moves second and its {@link MarkType#O}.
	 * 
	 * @return player 2
	 */
	public Player getPlayer2() {
		return player2;
	}
	
	/**
	 * 
	 * @return game board
	 */
	public Board getBoard() {
		return board;
	}
	
	/**
	 * 
	 * @return list of {@link Move}s performed on {@link Theories} game.
	 */
	public List<Move> getMoves() {
		return moves;
	}
	
	/**
	 * 
	 * @return game status.
	 */
	public GameStatus getGameStatus() {
		return gameStatus;
	}
	
	
}
