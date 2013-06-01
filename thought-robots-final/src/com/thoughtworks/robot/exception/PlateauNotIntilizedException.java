/**
 * 
 */
package com.thoughtworks.robot.exception;

/**
 * @author sshinde
 *
 */
@SuppressWarnings("serial")
public class PlateauNotIntilizedException extends RuntimeException {

	/**
	 * @param string
	 */
	public PlateauNotIntilizedException(String message) {
		super(message);
	}

}
