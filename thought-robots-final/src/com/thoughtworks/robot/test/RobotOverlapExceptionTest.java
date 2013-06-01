/**
 * 
 */
package com.thoughtworks.robot.test;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.robot.BaseRobot;
import com.thoughtworks.robot.Robot;
import com.thoughtworks.robot.exception.RobotOverlapException;


/**
 * @author sshinde
 *
 */
public class RobotOverlapExceptionTest extends AbstractRobotTest {

	public void testRobotOverlapWhenNotAllowed() {
		try {
			getPlateau().setAllowRobotOverlap(false);
			List<Robot> robots = new ArrayList<Robot>();
			Robot robot1 = new BaseRobot("0 0 E", getMoveParser(), getLocationParser(), getPlateau());
			Robot robot2 = new BaseRobot("1 0 E", getMoveParser(), getLocationParser(), getPlateau());
			robots.add(robot1);
			robots.add(robot2);
			robot1.moveRobot(robots, "M"); // this will try to move Robot 1 to 1 0 E
			fail("RobotOverlapException is expected when overlap is not allowed on Plateau !");
		} catch (RuntimeException exception) {
			assertSame(exception.getClass(), RobotOverlapException.class);
		} 
	}

	public void testRobotOverlapWhenAllowed() {
		try {
			getPlateau().setAllowRobotOverlap(true);
			List<Robot> robots = new ArrayList<Robot>();
			Robot robot1 = new BaseRobot("0 0 E", getMoveParser(), getLocationParser(), getPlateau());
			Robot robot2 = new BaseRobot("1 0 E", getMoveParser(), getLocationParser(), getPlateau());
			robots.add(robot1);
			robots.add(robot2);
			robot1.moveRobot(robots, "M"); // this will try to move Robot 1 to 1 0 E
		} catch (RuntimeException exception) {
			fail("RobotOverlapException is not expected when overlap is allowed on Plateau !");
		}
	}
}
