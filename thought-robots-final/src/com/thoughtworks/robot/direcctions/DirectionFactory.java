package com.thoughtworks.robot.direcctions;

import java.util.SortedMap;

/**
 * Factory interface which can/must be used to implement a new <code>DirectionFactory</code>.
 * 
 * @see BaseDirectionFactory
 * 
 * @author sshinde
 *
 */
public interface DirectionFactory {
	public Direction getDirection(String directionStringCode);
	public SortedMap<Integer, Direction> getDirections();
}
