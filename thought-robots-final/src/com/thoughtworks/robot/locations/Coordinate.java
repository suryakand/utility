package com.thoughtworks.robot.locations;

/**
 * A class which represents X, Y and Z values (state) of a {@link Location}
 * @author sshinde
 *
 */
public class Coordinate {
	private int x;
	private int y;
	private int z;

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}

	public boolean equals(Object coordinate) {
		if(coordinate instanceof Coordinate) {
			Coordinate newCoordinate = (Coordinate) coordinate;
			if(newCoordinate.getX() == getX() && newCoordinate.getY() == getY() && newCoordinate.getZ() == getZ()) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return String.format("COORDINATE: %d, %d, %d", getX(), getY(), getZ());
	}
}
