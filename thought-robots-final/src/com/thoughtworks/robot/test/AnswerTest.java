package com.thoughtworks.robot.test;

import java.util.ArrayList;

import com.thoughtworks.robot.BaseRobot;
import com.thoughtworks.robot.Robot;

/**
 * Test class that performs basic test about various input command Strings.
 * @author sshinde
 *
 */
public class AnswerTest extends AbstractRobotTest {

	public void testFirstInput() throws Exception {
		String startLocationString = "1 2 N";
		String stringCommand = "LMLMLMLMM";
		setRobot(new BaseRobot(startLocationString, getMoveParser(), getLocationParser(), getPlateau()));
		getRobot().moveRobot(new ArrayList<Robot>(), stringCommand);
		assertEquals("1 3 N", formatLocationString(getRobot().getCurrentLocation()));
	}

	public void testSecondInput() throws Exception {
		String startLocationString = "3 3 E";
		String stringCommand = "MMRMMRMRRM";
		setRobot(new BaseRobot(startLocationString, getMoveParser(), getLocationParser(), getPlateau()));
		getRobot().moveRobot(new ArrayList<Robot>(), stringCommand);
		assertEquals("5 1 E", formatLocationString(getRobot().getCurrentLocation()));
	}

}
