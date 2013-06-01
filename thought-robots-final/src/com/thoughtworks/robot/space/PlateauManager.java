package com.thoughtworks.robot.space;

import java.util.Collection;
import java.util.List;

import com.thoughtworks.robot.Robot;

/**
 * A basic dummy {@link Plateau} manager.</br>
 * NOTE: Need to implement it completely
 * 
 * @author sshinde
 */

public interface PlateauManager {
	public String getPlateuaId();
	public List<Robot> getRobotsByPlateau(Collection<Robot> robots);
	
	/**
	 * Must be implemented by other classes. This method checks whether <code>robot</code> is overlapping with other 
	 * {@link Robot}(s) on same {@link Plateau}. This validation will only be performed when 
	 * <code>allowRobotOverlap = false</code>.
	 * 
	 * @param robots List of all {@link Robot}(s)
	 * @param robot {@link Robot} for which overlap validation needs to be performed
	 * 
	 * @see Plateau
	 * @see BasePlateau
	 */
	public boolean isRobotOverLapping(List<Robot> robots, Robot robot);
}
