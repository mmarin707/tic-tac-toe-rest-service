package com.mmarin.tictactoe.core;

/**
 * 
 * Class that represents board cell.
 * 
 * @author mmarin
 *
 */
public class Cell {

	private MarkType markType;
	private final int row;
	private final int column;
	
	public Cell(MarkType markType, int row, int column) {
		
		this.markType = markType;
		this.row = row;
		this.column = column;
	
	}
	
	public MarkType getMarkType() {
		return markType;
	}
	
	public void setMarkType(MarkType markType) {
		this.markType = markType;
	}

	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
}
