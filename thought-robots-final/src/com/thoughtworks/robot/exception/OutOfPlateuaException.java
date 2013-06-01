package com.thoughtworks.robot.exception;

import com.thoughtworks.robot.locations.Coordinate;
import com.thoughtworks.robot.space.BasePlateau;
import com.thoughtworks.robot.space.Plateau;

/**
 * This exception will be used to notify an exception situation when <code>Robot</code> will try to go beyond the 
 * MAX/MIN(0, 0) limit of <code>Plateau</code>.
 *  
 * Right now we are not handling special cases here but we can enhance this Exception class further based in need.
 * 
 * @see Plateau
 * @see BasePlateau
 * @see Coordinate
 * 
 * @author sshinde
 *
 */
@SuppressWarnings("serial")
public class OutOfPlateuaException extends RuntimeException {

	public OutOfPlateuaException(String message) {
		super(message);
	}

}
