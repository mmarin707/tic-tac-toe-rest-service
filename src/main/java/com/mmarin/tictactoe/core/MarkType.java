package com.mmarin.tictactoe.core;

/**
 * 
 * Enumerator for board marks.
 * 
 * @author mmarin
 *
 */
public enum MarkType {
	
	X,
	O,
	__;
	
	
	/**
	 * 
	 * if mark is X then O is returned, else X is returned.
	 * 
	 * @return opposite mark
	 */
	public MarkType getOpposite() {
	
		return this.ordinal() == X.ordinal() ? O : X;
	}
	
}
