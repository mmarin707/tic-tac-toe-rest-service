package com.mmarin.tictactoe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * Custom exception for invalid move.
 * 
 * @author mmarin
 *
 */
@ResponseStatus(code = HttpStatus.PRECONDITION_FAILED, reason = "Invalid move")
public class InvalidMoveException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2841272719221918088L;

	public InvalidMoveException(String message) {
		super(message);
	}
	
}
