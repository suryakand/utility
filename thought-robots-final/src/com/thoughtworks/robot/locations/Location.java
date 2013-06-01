package com.thoughtworks.robot.locations;

import com.thoughtworks.robot.Robot;
import com.thoughtworks.robot.direcctions.Direction;
import com.thoughtworks.robot.space.Plateau;

/**
 * Represents a unique place with {@link Coordinate} and {@link Direction} in space.
 * @author sshinde
 *
 * @see Coordinate
 * @see Robot
 * @see Plateau
 *
 */
public class Location {
	private Coordinate xyzCordinate = new Coordinate(); //current X, Y Position of robot
	private Direction currentDirection; //current facing of robot

	public Location(Coordinate xyzCordinate, Direction currentDirection) {
		this.xyzCordinate = xyzCordinate;
		this.currentDirection = currentDirection;
	}

	/**
	 * Return {@link Coordinate} of current location of {@link Robot}
	 * 
	 * @return {@link Coordinate} of current location of {@link Robot}
	 */
	public Coordinate getXyzCordinate() {
		return xyzCordinate;
	}
	public void setXyzCordinate(Coordinate xyzCordinate) {
		this.xyzCordinate = xyzCordinate;
	}
	
	/**
	 * Return {@link Direction} of current {@link Location} of {@link Robot}
	 * 
	 * @return {@link Direction} of current {@link Location} of {@link Robot}
	 */
	public Direction getCurrentDirection() {
		return currentDirection;
	}
	public void setCurrentDirection(Direction currentDirection) {
		this.currentDirection = currentDirection;
	}

	public String toString() {
		return String.format("LOCATION: %d, %d, %s", getXyzCordinate().getX(), 
				getXyzCordinate().getY(), getCurrentDirection().getDirectionCode());
	}

	public boolean equals(Object location) {
		if(location != null && location instanceof Location) {
			Location newLocation = (Location)location;
			if(newLocation.getXyzCordinate().equals(getXyzCordinate()) 
					&& newLocation.getCurrentDirection().equals(getCurrentDirection())) {
				return true;
			}
		}
		return false;
	}

}
