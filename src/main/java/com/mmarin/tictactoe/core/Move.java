package com.mmarin.tictactoe.core;

/**
 * 
 * Class represents log for one move.
 * 
 * @author mmarin
 *
 */
public class Move {

	private final int moveNum;
	private final Player player;
	private final Cell cell;
	
	
	public Move(int moveNum, Player player, Cell cell) {

		this.moveNum = moveNum;
		this.player = player;
		this.cell = cell;
	}

	public int getMoveNum() {
		return moveNum;
	}

	public Player getPlayer() {
		return player;
	}

	public Cell getCell() {
		return cell;
	}
	
}
