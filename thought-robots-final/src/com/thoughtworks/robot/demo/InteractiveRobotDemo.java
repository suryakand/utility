package com.thoughtworks.robot.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.thoughtworks.robot.BaseRobot;
import com.thoughtworks.robot.Robot;
import com.thoughtworks.robot.direcctions.BaseDirectionFactory;
import com.thoughtworks.robot.exception.InvalidLocationString;
import com.thoughtworks.robot.locations.BaseLocationParser;
import com.thoughtworks.robot.locations.LocationParser;
import com.thoughtworks.robot.moves.BaseMoveFactory;
import com.thoughtworks.robot.moves.BaseMoveParser;
import com.thoughtworks.robot.moves.MoveParser;
import com.thoughtworks.robot.space.BasePlateau;
import com.thoughtworks.robot.space.Plateau;
/**
 * A demo class which tries to cover all features for {@link Robot} application.
 * Bare with me becuase this particular class is little messy :-(
 * @author sshinde
 *
 */
public class InteractiveRobotDemo {
	public static Plateau plateau = null;
	public static Map<String, Robot> robots = new HashMap<String, Robot>();
	public static Scanner consoleScanner = new Scanner(System.in);
	public static MoveParser moveParser = new BaseMoveParser(new BaseMoveFactory());
	public static LocationParser locationParser = new BaseLocationParser(new BaseDirectionFactory());

	public static void main(String[] args) {
		Robot robot = null;

		printOptions();
		plateau = createNewPlateau();

		while(true) {
			try {
				System.out.print("Enter Command:");
				InteractiveOptions option = Enum.valueOf(InteractiveOptions.class, consoleScanner.nextLine().toUpperCase());
				switch(option){
				case NR :
					createNewRobot();
					break;
				case SR :
					robot = selectNewRobot();
					break;
				case MR ://LMLMLMLMM
					moveRobot(robot);
					break;
				case RR :
					resetRobotLocation(robot); // 0 0 E
					break;
				case HELP : 
					printOptions();
					break;
				case Q : 
					System.exit(0);
				default : 
					System.out.println("Enter Command or help:");
				}
			} catch (Exception ex) {
				System.out.print("Error occured ! Try again. ");
				ex.printStackTrace();
			}
		}
	}

	public static Plateau createNewPlateau() {
		Plateau plateau = null;
		try {
			System.out.print("(CREATE NEW PLATEUA) Enter Max Coordinate Limit for Plateau:");
			String maxCoordinateLimit = consoleScanner.nextLine();
			System.out.print("Allow two robots at same coordinate (Y/N)?:");
			boolean allowOverlap = consoleScanner.nextLine().equalsIgnoreCase("Y") ? true : false;
			plateau = new BasePlateau(locationParser.parseCoordinates(maxCoordinateLimit), allowOverlap);
		} catch (InvalidLocationString invalidLocationExp) {
			invalidLocationExp.getMessage();
		}
		return plateau;
	}

	public static void createNewRobot() {
		Robot robot = null;
		try {
			String robotId = String.valueOf(robots.size() + 1);
			System.out.print(String.format("Enter start location for new robot (auto generated id=%s):", robotId));
			String locationString = consoleScanner.nextLine();
			robot = new BaseRobot(locationString, moveParser, locationParser, plateau);
			robot.setRobotId(robotId);
			robots.put(robotId, robot);
		} catch (InvalidLocationString invalidLocationExp) {
			invalidLocationExp.getMessage();
		}
	}

	public static Robot selectNewRobot() {
		showPlateuaSummary();
		System.out.print(String.format("Enter robot Id:"));
		String robotId = consoleScanner.nextLine();
		return robots.get(robotId);
	}

	public static void moveRobot(Robot robot) {
		if(robot != null) {
			System.out.print("Enter moves command string:");
			String moveString = consoleScanner.nextLine();
			robot.moveRobot(robot.getPlateau().getRobotsByPlateau(robots.values()), moveString);
			System.out.println(String.format("Robot (%s) is Moved to %s", robot.getRobotId(), robot.getCurrentLocation()));
		} else {
			if(robots.size() <= 0)
				showPlateuaSummary();
			else {
				System.out.println("No Robot selected, please select one!");
				moveRobot(selectNewRobot());
			}
		}
	}

	public static void resetRobotLocation(Robot robot) {
		if(robot != null) {
			System.out.println(String.format("Robot ID (%s) is located at %s", robot.getRobotId(), robot.getCurrentLocation()));
			System.out.println(String.format("Do you want to reset robot (%s) location (Y/N)?", robot.getRobotId()));
			boolean shouldReset = consoleScanner.nextLine().equalsIgnoreCase("Y") ? true : false;
			if(shouldReset){
				robot.resetRobotLocation();
			}
		} else {
			resetRobotLocation(selectNewRobot());
		}
	}

	public static void showPlateuaSummary() {
		if(robots.size() > 0) {
			System.out.println(String.format("Total robots on plateua:", robots.size()));
			for(Robot robot : robots.values()) {
				System.out.println(String.format("Robot (%s) : %s", robot.getRobotId(), robot.getCurrentLocation().toString()));
			}
		} else {
			System.out.println("Plateau don't have any Robot !");
		}
	}

	public static void printOptions() {
		System.out.println("========= COMMANDS =========");
		for(InteractiveOptions options : InteractiveOptions.values()) {
			System.out.println(String.format("(%s) - %s", options.name(), options.getOptionDescription()) );
		}
	}

}
