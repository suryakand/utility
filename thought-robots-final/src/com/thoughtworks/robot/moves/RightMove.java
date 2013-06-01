package com.thoughtworks.robot.moves;

import java.util.Collection;

import com.thoughtworks.robot.Robot;
import com.thoughtworks.robot.direcctions.Direction;
import com.thoughtworks.robot.direcctions.DirectionFactory;
import com.thoughtworks.robot.space.Plateau;

/**
 * This class represents a RIGHT ("R") {@link Move} on {@link Plateau}.
 * @author sshinde
 *
 */
public class RightMove extends Move {
	public static final String MOVE_CODE = "R";

	public RightMove() {
		super(MOVE_CODE);
	}

	/**
	 * This method perform a {@link RightMove} on a {@link Robot} passed as an argument.
	 * 
	 * @param robot A {@link Robot} on which a {@link RightMove} should be performed.
	 */
	@Override
	public void move(Robot robot) {
		Direction currentDirection = robot.getCurrentLocation().getCurrentDirection();
		DirectionFactory directionFactory = robot.getLocationParser().getDirectionFactory();
		robot.getCurrentLocation().setCurrentDirection(currentDirection.getRightDirection(directionFactory));
	}

	@Override
	public boolean canMove(Collection<Robot> allRobots, Robot robot) {
		return true;
	}
}
