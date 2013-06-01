package com.thoughtworks.robot.exception;

import com.thoughtworks.robot.moves.BaseMoveFactory;
import com.thoughtworks.robot.moves.BaseMoveParser;
import com.thoughtworks.robot.moves.MoveParser;

/**
 * This exception will be used to notify an exception situation where program/code has received an invalid 
 * Move code.
 * 
 * Right now we are not handling special cases here but we can enhance this Exception class further based in need.
 * 
 * @see BaseMoveFactory
 * @see MoveParser
 * @see BaseMoveParser
 * 
 * @author sshinde
 *
 */
@SuppressWarnings("serial")
public class InvalidMoveCodeException extends RuntimeException {

	public InvalidMoveCodeException(String errorMessage) {
		super(errorMessage);
	}

}
