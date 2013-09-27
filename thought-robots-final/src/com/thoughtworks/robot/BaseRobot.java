package com.thoughtworks.robot;

import java.util.Collection;
import java.util.List;

import com.thoughtworks.robot.direcctions.EastDirection;
import com.thoughtworks.robot.exception.InvalidLocationString;
import com.thoughtworks.robot.locations.LocationParser;
import com.thoughtworks.robot.moves.Move;
import com.thoughtworks.robot.moves.MoveParser;
import com.thoughtworks.robot.space.Plateau;

/**
 * Base implementation of {@link Robot} class.
 * @author sshinde
 *
 */
public class BaseRobot extends Robot { 

	public BaseRobot(String startLocationString, MoveParser moveParser,
			LocationParser locationParser, Plateau plateau) throws InvalidLocationString {
		super(startLocationString, moveParser, locationParser, plateau);
	}

	@Override
	public void moveRobot(Collection<Robot> otherRobots, String stringCommand) {
		List<Move> moves = getMoveParser().parserMovements(stringCommand);
		for(Move move : moves) {
			if(move.canMove(otherRobots, this)) {
				move.move(this);
			}
		}
	}

	@Override
	public void resetRobotLocation() {
		getCurrentLocation().getXyzCordinate().setX(0);
		getCurrentLocation().getXyzCordinate().setY(0);
		getCurrentLocation().getCurrentDirection().setDirectionCode(EastDirection.DIRECTION_CODE);
		getCurrentLocation().getCurrentDirection().setOrder(EastDirection.DEFAULT_DIRECTION_ORDER);
	}

}
