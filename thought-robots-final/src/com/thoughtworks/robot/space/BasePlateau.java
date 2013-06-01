package com.thoughtworks.robot.space;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.thoughtworks.robot.Robot;
import com.thoughtworks.robot.locations.Coordinate;

/**
 * Base implementation of {@link Plateau}. This class implements <code>getRobotsByPlateau()</code> and 
 * <code>isRobotOverLapping()</code> methods of {@link PlateauManager}
 * 
 * @author sshinde
 *
 * @see BasePlateau
 */
public class BasePlateau extends Plateau {

	public BasePlateau(Coordinate maxCoordinateLimit,  boolean allowRobotOverlap) {
		super(maxCoordinateLimit, allowRobotOverlap);
	}

	/**
	 * Method which takes {@link Collection} of all {@link Robot}(s) as an argument and return only those {@link Robot}(s)
	 * which are planted on this/current {@link Plateau}.
	 * 
	 * @param robots {@link Collection} of all robots (from all {@link Plateau}(s))
	 * @return {@link List} List of {@link Robot} which are planted on current {@link Plateau}
	 * 
	 * @see Plateau
	 * @see PlateauManager
	 */
	public List<Robot> getRobotsByPlateau(Collection<Robot> robots) {
		List<Robot> robotsByPlatue = new ArrayList<Robot>();

		for(Robot robot : robots) {
			if(robot.getPlateau().equals(this)) {
				robotsByPlatue.add(robot);
			}
		}

		return robotsByPlatue;
	}

	/**
	 * This method checks whether <code>robot</code> is overlapping with other {@link Robot}(s) on same {@link Plateau}.
	 * This validation will only be performed when <code>allowRobotOverlap = false</code>.
	 * 
	 * @param robots List of all {@link Robot}(s)
	 * @param robot {@link Robot} for which overlap validation needs to be performed
	 * 
	 * @see Plateau
	 * @see PlateauManager
	 */
	public boolean isRobotOverLapping(List<Robot> robots, Robot robot) {
		if(robot != null && robots.size() > 0) {
			for(Robot robotOnPlateau : robots) {
				return robotOnPlateau.equals(robot);
			}
		}

		return false;
	}


}
