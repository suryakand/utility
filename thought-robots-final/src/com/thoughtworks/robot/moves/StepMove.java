package com.thoughtworks.robot.moves;

import java.util.Collection;

import com.thoughtworks.robot.BaseRobot;
import com.thoughtworks.robot.Robot;
import com.thoughtworks.robot.direcctions.Direction;
import com.thoughtworks.robot.exception.InvalidLocationString;
import com.thoughtworks.robot.exception.RobotOverlapException;
import com.thoughtworks.robot.locations.Coordinate;
import com.thoughtworks.robot.locations.Location;
import com.thoughtworks.robot.space.Plateau;

/**
 * This class represents a forward STEP ("M") {@link Move} on {@link Plateau}.
 * 
 * @author sshinde
 *
 * @see Move 
 */

public class StepMove extends Move {
	public static final String MOVE_CODE = "M";

	public StepMove() {
		super(MOVE_CODE);
	}

	/**
	 * This method perform a {@link StepMove} on a {@link Robot} passed as an argument.
	 * 
	 * @param robot A {@link Robot} on which a {@link StepMove} should be performed.
	 */
	@Override
	public void move(Robot robot) {
		robot.getCurrentLocation().getCurrentDirection().updateCoordinates(robot);
	}

	/**
	 * 
	 * This method should be called before <code>move(Robot robot)</code> to check whether {@link Robot} can be moved 
	 * to next {@link Location} or not? {@link LeftMove} and {@link RightMove} classes are simply returning 
	 * <code>true</code> from <code>canMove()</code> method because in those moves (left & right) 
	 * {@link Coordinate} of {@link Robot} will not change. For example usage see {@link BaseRobot}
	 * 
	 * @param allRobots all {@link Robot}(s) under a Robot controlling system/space.
	 * @param robot
	 * @return <code>boolean</code> Whether {@link Robot} can be moved to next {@link Location} or not?
	 * @throws InvalidLocationString 
	 * 
	 * @see LeftMove
	 * @see RightMove
	 * @see StepMove
	 */
	@Override
	public boolean canMove(Collection<Robot> allRobots, Robot robot) {

		Location currentLocation = robot.getCurrentLocation();
		Robot tempRobot = new BaseRobot(null, null, null, robot.getPlateau());
		Coordinate coordinate = new Coordinate();
		coordinate.setX(currentLocation.getXyzCordinate().getX());
		coordinate.setY(currentLocation.getXyzCordinate().getY());
		Direction direction = robot.getLocationParser().getDirectionFactory().getDirection(
				currentLocation.getCurrentDirection().getDirectionCode());

		Location location = new Location(coordinate, direction);
		tempRobot.setCurrentLocation(location);

		move(tempRobot);

		Location finalLocation = tempRobot.getCurrentLocation();

		if(!robot.getPlateau().isAllowRobotOverlap()) {
			for(Robot robotOnPlateua : allRobots) {
				tempRobot.setRobotId(robotOnPlateua.getRobotId());
				if(robotOnPlateua.getCurrentLocation().equals(finalLocation) && robot.getRobotId() == robotOnPlateua.getRobotId()) {
					throw new RobotOverlapException(String.format("Robot(%s) is overlapping with another robot %s", robot.toString(), robotOnPlateua.toString()));
				} else {
					continue;
				}
			}
		}

		return true;
	}
}
