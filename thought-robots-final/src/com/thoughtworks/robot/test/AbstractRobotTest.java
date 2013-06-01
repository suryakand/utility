/**
 * 
 */
package com.thoughtworks.robot.test;

import junit.framework.TestCase;

import com.thoughtworks.robot.Robot;
import com.thoughtworks.robot.direcctions.BaseDirectionFactory;
import com.thoughtworks.robot.direcctions.Direction;
import com.thoughtworks.robot.locations.BaseLocationParser;
import com.thoughtworks.robot.locations.Coordinate;
import com.thoughtworks.robot.locations.Location;
import com.thoughtworks.robot.locations.LocationParser;
import com.thoughtworks.robot.moves.BaseMoveFactory;
import com.thoughtworks.robot.moves.BaseMoveParser;
import com.thoughtworks.robot.moves.MoveParser;
import com.thoughtworks.robot.space.BasePlateau;
import com.thoughtworks.robot.space.Plateau;

/**
 * @author sshinde
 *
 */
public class AbstractRobotTest extends TestCase {
	private String plateauLimit = "5 5"; //Default Limit for testing
	private Plateau plateau;
	private Robot robot;
	private MoveParser moveParser;
	private LocationParser locationParser;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		moveParser = new BaseMoveParser(new BaseMoveFactory());
		locationParser = new BaseLocationParser(new BaseDirectionFactory());
		plateau = new BasePlateau(getLocationParser().parseCoordinates(getPlateauLimit()), false);
	}

	protected String formatLocationString(Location location) {
		Coordinate finalCoordinate = location.getXyzCordinate();
		Direction finalDirection = location.getCurrentDirection();
		return String.format("%s %s %s", finalCoordinate.getX(), finalCoordinate.getY(), finalDirection.getDirectionCode());
	}

	public String getPlateauLimit() {
		return plateauLimit;
	}
	public void setPlateauLimit(String plateauLimit) {
		this.plateauLimit = plateauLimit;
	}
	public Plateau getPlateau() {
		return plateau;
	}
	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}
	public Robot getRobot() {
		return robot;
	}
	public void setRobot(Robot robot) {
		this.robot = robot;
	}
	public MoveParser getMoveParser() {
		return moveParser;
	}
	public void setMoveParser(MoveParser moveParser) {
		this.moveParser = moveParser;
	}
	public LocationParser getLocationParser() {
		return locationParser;
	}
	public void setLocationParser(LocationParser locationParser) {
		this.locationParser = locationParser;
	}

}
