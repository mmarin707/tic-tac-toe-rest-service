package com.mmarin.tictactoe.core;

/**
 * 
 * Class that represents game board;
 * 
 * @author mmarin
 *
 */
public class Board {

	public static final int NUMROWS = 3;
	public static final int NUMCOLUMN = 3;
	
	private final Cell[][] cells;
	
	public Board() {
		
		cells = new Cell[NUMROWS][NUMCOLUMN];
		
		init();
	}
	
	/**
	 * Initialize all cells to {@link MarkType.__}
	 */
	public void init() {
		
		for (int row = 0; row < Board.NUMROWS; row++) {
			
			for (int col = 0; col < Board.NUMCOLUMN; col++) {
				
				cells[row][col] = new Cell(MarkType.__, row, col);
						
			}
			
		}
		
	}
	
	/**
	 * Retrieve board cells.
	 * 
	 * @return Cell[][] 
	 */
	public Cell[][] getCells() {
		return cells;
	}	

	/**
	 * 
	 * Retrive curent cell value.
	 * 
	 * @param row row
	 * @param column column
	 * @return {@link Cell}
	 */
	public Cell getCell(int row, int column) {
		
		return cells[row][column];
		
	}
	
	/**
	 * 
	 * This methods represents move. Cell is added to board.
	 * 
	 * @param cell cell
	 */
	public void setCell(Cell cell) {
		this.cells[cell.getRow()][cell.getColumn()] = cell;
	}
	
	
}
