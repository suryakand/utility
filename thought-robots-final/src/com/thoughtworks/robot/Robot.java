package com.thoughtworks.robot;

import java.util.Collection;

import com.thoughtworks.robot.direcctions.Direction;
import com.thoughtworks.robot.exception.InvalidLocationString;
import com.thoughtworks.robot.exception.PlateauNotIntilizedException;
import com.thoughtworks.robot.locations.Coordinate;
import com.thoughtworks.robot.locations.Location;
import com.thoughtworks.robot.locations.LocationParser;
import com.thoughtworks.robot.moves.MoveParser;
import com.thoughtworks.robot.space.BasePlateau;
import com.thoughtworks.robot.space.Plateau;

/**
 * A Robot which represents an actual robot instance which can planted on {@link Plateau}. A robot always has 
 * a state (X,Y or Z values and direction) which is represented by {@link Location}.
 * @author sshinde
 *
 *@see BaseRobot
 *@see Location
 *@see Plateau
 *@see BasePlateau
 */
public abstract class Robot {
	private String robotId;
	private Plateau plateau;
	private MoveParser moveParser;
	private LocationParser locationParser;
	private Location currentLocation;

	/**
	 * Public constructor which creates a Robot instance. A robot can not be created without its current location,
	 * {@link MoveParser}, {@link LocationParser} and {@link Plateau}
	 * 
	 * @param startLocationString Location string (e.g. 1 1 E) for <code>Robot</code>.
	 * @param moveParser {@link MoveParser} which helps Robot to interpret the move commands (e.g. L, M , R)
	 * @param locationParser {@link LocationParser} which helps Robot to interpret location strings (1 1 E)
	 * @param plateau {@link Plateau} /area in which this robot should be planted.
	 * @throws InvalidLocationString
	 */
	public Robot(String startLocationString, MoveParser moveParser, 
			LocationParser locationParser, Plateau plateau) throws InvalidLocationString {
		if(plateau != null)
			this.plateau = plateau;
		else
			throw new PlateauNotIntilizedException("Plateau is not initilized");
		
		this.moveParser = moveParser;
		this.locationParser = locationParser;
		if(locationParser != null)
			this.currentLocation = locationParser.parseLocation(startLocationString);
	}

	/**
	 * This method returns ID for a <code>Robot</code>
	 * @return robotId
	 */
	public String getRobotId() {
		return robotId;
	}

	public void setRobotId(String robotId) {
		this.robotId = robotId;
	}

	/**
	 * Current {@link Plateau} in which robot is planted.
	 * @return {@link Plateau} in which robot is planted.
	 */
	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
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

	/**
	 * Return the current {@link Location} of Robot on {@link Plateau}
	 * 
	 * @return current {@link Location} of robot.
	 * 
	 * @see Coordinate
	 * @see Direction
	 */
	public Location getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

	/**
	 * A method which must be implemented by all other Robot classes ({@link BaseRobot}) to move a robot on {@link Plateau}.
	 * 
	 * @param otherRobots Other {@link Robot}(s) on same {@link Plateau}
	 * @param stringCommand command string for robot to move on {@link Plateau}
	 * 
	 * @see BaseRobot
	 */
	public abstract void moveRobot(Collection<Robot> otherRobots, String stringCommand);

	/**
	 * A method which must be implemented by all other Robot classes ({@link BaseRobot}) to tell how to reset 
	 * the state {@link Location} of Robot.
	 * 
	 * @see BaseRobot
	 */
	public abstract void resetRobotLocation();

	public boolean equals(Object robot) {
		if(robot != null && robot instanceof Robot) {
			Robot newRobot = (Robot) robot;
			Coordinate newRobotCoordinate = newRobot.getCurrentLocation() != null ?	newRobot.getCurrentLocation().getXyzCordinate() : new Coordinate();
			Coordinate currentRobotCoordinat = getCurrentLocation() != null ? getCurrentLocation().getXyzCordinate() : new Coordinate();
			if (newRobot.getRobotId() == getRobotId() 
					&& newRobot.getPlateau().getPlateuaId() == getPlateau().getPlateuaId()
					&& newRobotCoordinate.equals(currentRobotCoordinat)){
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return String.format("[ROBOT: %s, %s, %s]", getRobotId(), getCurrentLocation().toString(), getPlateau().toString());
	}
}
