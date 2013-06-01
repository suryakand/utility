package com.thoughtworks.robot.moves;

import java.util.Collection;

import com.thoughtworks.robot.Robot;
import com.thoughtworks.robot.locations.Location;
import com.thoughtworks.robot.space.Plateau;

/**
 * Base class that represents the Movement to be performed on {@link Plateau}.
 * @author sshinde
 *
 * @see LeftMove
 * @see RightMove
 * @see StepMove
 */

public abstract class Move {
	private String moveCode; //L, R or M

	/**
	 * Purpose of this constructor with a <code>MoveCode</code> is to restrict the users to create only valid 
	 * <code>Move</code> objects.
	 * 
	 * @param moveCode
	 */
	public Move(String moveCode) {
		this.moveCode = moveCode;
	}

	public String getMoveCode() {
		return moveCode;
	}

	public void setMoveCode(String moveCode) {
		this.moveCode = moveCode;
	}

	/**
	 * This method that must be implemented by individual Move classes for moving {@link Robot}.
	 * 
	 * @param robot A {@link Robot} which needs to be moved on {@link Plateau}.
	 */
	public abstract void move(Robot robot);

	/**
	 * This method must be implemented by all other Move classes which are extending from this class. This method should
	 * be called before <code>move(Robot robot)</code> to check whether {@link Robot} can be moved to next {@link Location} or not? For
	 * example implementation please refer {@link StepMove}.
	 * 
	 * @param allRobots all {@link Robot}(s) under a Robot controlling system/space.
	 * @param robot
	 * @return <code>boolean</code> Whether {@link Robot} can be moved to next {@link Location} or not?
	 * 
	 * @see LeftMove
	 * @see RightMove
	 * @see StepMove
	 */
	public abstract boolean canMove(Collection<Robot> allRobots, Robot robot);

}
