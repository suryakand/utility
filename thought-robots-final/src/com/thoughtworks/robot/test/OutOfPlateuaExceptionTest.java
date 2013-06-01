/**
 * 
 */
package com.thoughtworks.robot.test;

import java.util.ArrayList;

import com.thoughtworks.robot.BaseRobot;
import com.thoughtworks.robot.Robot;
import com.thoughtworks.robot.exception.OutOfPlateuaException;

/**
 * @author sshinde
 *
 */
public class OutOfPlateuaExceptionTest extends AbstractRobotTest {

	public void testOutOfPlateuaExceptionWhenLimitExceeded() {
		try {
			String startLocationString = "4 4 E";
			String stringCommand = "MMMM";
			setRobot(new BaseRobot(startLocationString, getMoveParser(), getLocationParser(), getPlateau()));
			getRobot().moveRobot(new ArrayList<Robot>(), stringCommand);
			fail("OutOfPlateuaException is expected when robot moves out of Plateau.!");
		} catch (RuntimeException exception) {
			assertSame(exception.getClass(), OutOfPlateuaException.class);
		} 
	}
	
	public void testOutOfPlateuaExceptionWhenLimitNotExceeded() {
		try {
			String startLocationString = "4 4 E";
			String stringCommand = "M";
			setRobot(new BaseRobot(startLocationString, getMoveParser(), getLocationParser(), getPlateau()));
			getRobot().moveRobot(new ArrayList<Robot>(), stringCommand);
			assertEquals("5 4 E", formatLocationString(getRobot().getCurrentLocation()));
		} catch (RuntimeException exception) {
			fail("OutOfPlateuaException is not expected when robot does not moves out of Plateau.!");
		} 
	}
	
}
