package com.thoughtworks.robot.direcctions;

import com.thoughtworks.robot.Robot;
import com.thoughtworks.robot.exception.OutOfPlateuaException;
import com.thoughtworks.robot.locations.Coordinate;

/**
 * This class represents WEST direction, with default <code>directionCode = "W"</code> and <code>order = 3</code>.
 * If you want to change the <code>directionCode</code> and <code>order</code> of this class then use the getter and 
 * setter methods setDirectionCode() and setOrder().
 * 
 * @author sshinde
 *
 */
public class WestDirection extends Direction {
	public static final String DIRECTION_CODE = "W";
	public static final int DEFAULT_DIRECTION_ORDER = 3;
	
	public WestDirection() {
		super(DIRECTION_CODE, DEFAULT_DIRECTION_ORDER);
	}

	@Override
	public void updateCoordinates(Robot robot) {
		Coordinate currentCoordinate = robot.getCurrentLocation().getXyzCordinate();
		Coordinate maxCoordinate = robot.getPlateau().getMaxCoordinateLimit();

		if((currentCoordinate.getX() - 1) >= 0)
			currentCoordinate.setX(currentCoordinate.getX() - 1);
		else {
			throw new OutOfPlateuaException(String.format("Can not move robot beyond %s ", maxCoordinate.toString()));
		}
	}

}
