package com.thoughtworks.robot.exception;

import com.thoughtworks.robot.Robot;
import com.thoughtworks.robot.locations.Coordinate;
import com.thoughtworks.robot.space.BasePlateau;
import com.thoughtworks.robot.space.Plateau;

/**
 * A Plateau can allow/disallow two {@link Robot} to share same coordinate and this can be controlled by an instance variable 
 * <code>allowRobotOverlap</code> in {@link Plateau}.This exception will be used to notify an exception situation 
 * when a <code>Robot</code> will try to occupy a coordinate which is already occupied by another Robot on same Plateau 
 * and Plateau does not allow sharing of same coordinates by two Robots. 
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
public class RobotOverlapException extends RuntimeException{
	
	public RobotOverlapException(String message) {
		super(message);
	}
}
