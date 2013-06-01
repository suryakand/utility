package com.thoughtworks.robot.direcctions;

import com.thoughtworks.robot.Robot;
import com.thoughtworks.robot.exception.OutOfPlateuaException;
import com.thoughtworks.robot.locations.Coordinate;

/**
 * This class represents EAST direction, with default <code>directionCode = "E"</code> and <code>order = 1</code>.
 * If you want to change the <code>directionCode</code> and <code>order</code> of this class then use the getter and 
 * setter methods setDirectionCode() and setOrder().
 * 
 * @author sshinde
 *
 */
public class EastDirection extends Direction {
	public static final String DIRECTION_CODE = "E";
	public static final Integer DEFAULT_DIRECTION_ORDER = 1;

	public EastDirection() {
		super(DIRECTION_CODE, DEFAULT_DIRECTION_ORDER);
	}

	@Override
	public void updateCoordinates(Robot robot) {
		Coordinate currentCoordinate = robot.getCurrentLocation().getXyzCordinate();
		Coordinate maxCoordinate = robot.getPlateau().getMaxCoordinateLimit();

		if((currentCoordinate.getX() + 1) <= maxCoordinate.getX())
			currentCoordinate.setX(currentCoordinate.getX() + 1);
		else {
			throw new OutOfPlateuaException(String.format("Can not move robot beyond %s ", maxCoordinate.toString()));
		}
	}

}
