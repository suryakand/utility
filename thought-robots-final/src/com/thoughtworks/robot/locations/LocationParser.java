package com.thoughtworks.robot.locations;

import com.thoughtworks.robot.Robot;
import com.thoughtworks.robot.direcctions.Direction;
import com.thoughtworks.robot.direcctions.DirectionFactory;
import com.thoughtworks.robot.exception.InvalidLocationString;

/**
 * Location parser interface which must be implemented by all location parser classes which will perform location 
 * string parsing.
 * 
 * </br></br>
 * <b>Example usage:</b> Let's say you have introduced a new Location code B (Back) other than existing (L, M, R) 
 * and you don't want to use {@link BaseLocationParser}, rather you want to write you own parser then you can 
 * write a new parser by implementing this interface and pass it as argument to {@link Robot}.
 * 
 * @author sshinde
 * 
 * @see LocationParser
 * @see Location
 * @see Coordinate
 * @see Direction
 *
 */
public interface LocationParser {
	public Location parseLocation(String locationString) throws InvalidLocationString;
	public Coordinate parseCoordinates(String locationString) throws InvalidLocationString;
	public Direction parseDirection(String locationString) throws InvalidLocationString;
	public DirectionFactory getDirectionFactory();
}
