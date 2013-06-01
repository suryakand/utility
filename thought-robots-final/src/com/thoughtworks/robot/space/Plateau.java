package com.thoughtworks.robot.space;

import com.thoughtworks.robot.Robot;
import com.thoughtworks.robot.locations.Coordinate;
import com.thoughtworks.robot.locations.Location;

/**
 * An area where {@link Robot}(s) can be move. Each {@link Plateau} should be configured with two basic configurations</br>
 * (1) <code>maxCoordinateLimit</code>: This restricts {@link Robot}(s) not to got out of bound.</br>
 * (2) <code>allowRobotOverlap</code>: This tells whether two {@link Robot}(s) can be placed on same {@link Location} or not?
 * 
 * @author sshinde
 *
 * @see BasePlateau
 */
public abstract class Plateau implements PlateauManager {
	private String plateuaId;
	private Coordinate maxCoordinateLimit;
	private boolean allowRobotOverlap = false;

	/**
	 * This constructor puts restriction so that whenever a {@link Plateau} is created it should be configured with two basic configurations</br>
	 * (1) <code>maxCoordinateLimit</code>: This restricts {@link Robot}(s) not to got out of bound.</br>
	 * (2) <code>allowRobotOverlap</code>: This tells whether two {@link Robot}(s) can be placed on same {@link Location} or not?
	 * 
	 * @see BasePlateau
	 */
	public Plateau(Coordinate maxCoordinateLimit,  boolean allowRobotOverlap) {
		this.maxCoordinateLimit = maxCoordinateLimit;
		this.allowRobotOverlap = allowRobotOverlap;
	}


	public String getPlateuaId() {
		return plateuaId;
	}

	public void setPlateuaId(String plateuaId) {
		this.plateuaId = plateuaId;
	}

	public Coordinate getMaxCoordinateLimit() {
		return maxCoordinateLimit;
	}

	public void setMaxCoordinateLimit(Coordinate maxCoordinateLimit) {
		this.maxCoordinateLimit = maxCoordinateLimit;
	}

	public boolean isAllowRobotOverlap() {
		return allowRobotOverlap;
	}

	public void setAllowRobotOverlap(boolean allowRobotOverlap) {
		this.allowRobotOverlap = allowRobotOverlap;
	}

	public boolean equals(Object otherPlateua) {
		if(otherPlateua != null && otherPlateua instanceof Plateau) {
			Plateau plateau = (Plateau) otherPlateua;
			return (plateau.getPlateuaId() == getPlateuaId());
		}
		return false;
	}

	public String toString() {
		return String.format("PLATEUA", getPlateuaId() != null ? getPlateuaId() : "<NOT SET>");
	}
}
