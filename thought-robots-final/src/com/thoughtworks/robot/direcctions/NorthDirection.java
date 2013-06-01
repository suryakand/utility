package com.thoughtworks.robot.direcctions;

import com.thoughtworks.robot.Robot;
import com.thoughtworks.robot.exception.OutOfPlateuaException;
import com.thoughtworks.robot.locations.Coordinate;

/**
 * This class represents NORTH direction, with default <code>directionCode = "N"</code> and <code>order = 2</code>.
 * If you want to change the <code>directionCode</code> and <code>order</code> of this class then use the getter and 
 * setter methods setDirectionCode() and setOrder().
 * 
 * @author sshinde
 *
 */
public class NorthDirection extends Direction {
	public static final String DIRECTION_CODE = "N";
	public static final int DEFAULT_DIRECTION_ORDER = 2;
	
	public NorthDirection() {
		super(DIRECTION_CODE, DEFAULT_DIRECTION_ORDER);
	}

	@Override
	public void updateCoordinates(Robot robot) {
		Coordinate currentCoordinate = robot.getCurrentLocation().getXyzCordinate();
		Coordinate maxCoordinate = robot.getPlateau().getMaxCoordinateLimit();

		if((currentCoordinate.getY() + 1) <= maxCoordinate.getY())
			currentCoordinate.setY(currentCoordinate.getY() + 1);
		else {
			throw new OutOfPlateuaException(String.format("Can not move robot beyond %s ", maxCoordinate.toString()));
		}
	}

}
