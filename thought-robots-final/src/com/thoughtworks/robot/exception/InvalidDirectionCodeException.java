package com.thoughtworks.robot.exception;

/**
 * This exception will be used to notify an Exception situation where program/code have got an invalid <code>Direction</code>.
 * Right now we are not handling special cases here but we can enhance this Exception class further based in need.
 * @author sshinde
 *
 */
@SuppressWarnings("serial")
public class InvalidDirectionCodeException extends RuntimeException{

	public InvalidDirectionCodeException(String message) {
		super(message);
	}
}
