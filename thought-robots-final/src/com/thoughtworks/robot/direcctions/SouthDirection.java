package com.thoughtworks.robot.direcctions;

import com.thoughtworks.robot.Robot;
import com.thoughtworks.robot.exception.OutOfPlateuaException;
import com.thoughtworks.robot.locations.Coordinate;

/**
 * This class represents SOUTH direction, with default <code>directionCode = "S"</code> and <code>order = 0</code>.
 * If you want to change the <code>directionCode</code> and <code>order</code> of this class then use the getter and 
 * setter methods setDirectionCode() and setOrder().
 * 
 * @author sshinde
 *
 */
public class SouthDirection extends Direction {
	public static final String DIRECTION_CODE = "S";
	public static final int DEFAULT_DIRECTION_ORDER = 0;
	
	public SouthDirection() {
		super(DIRECTION_CODE, DEFAULT_DIRECTION_ORDER);
	}

	@Override
	public void updateCoordinates(Robot robot) {
		Coordinate currentCoordinate = robot.getCurrentLocation().getXyzCordinate();
		Coordinate maxCoordinate = robot.getPlateau().getMaxCoordinateLimit();

		if((currentCoordinate.getY() - 1) >= 0)
			currentCoordinate.setY(currentCoordinate.getY() - 1);
		else {
			throw new OutOfPlateuaException(String.format("Can not move robot beyond %s ", maxCoordinate.toString()));
		}
		
	}

}
