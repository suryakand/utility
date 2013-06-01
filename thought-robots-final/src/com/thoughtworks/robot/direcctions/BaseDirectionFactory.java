package com.thoughtworks.robot.direcctions;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.thoughtworks.robot.exception.InvalidDirectionCodeException;

/**
 * This class represents a factory class for directions which will be used by other application scope objects to get the direction(s).
 * This factory class maintains Map of directions as:
 * key = integer order value of <code>Direction</code>. 
 * value -> an object extended from base <code>Direction</code> class.
 * 
 * @author sshinde
 */

public class BaseDirectionFactory implements DirectionFactory {
	private SortedMap<Integer, Direction> directions = new TreeMap<Integer, Direction>();

	public BaseDirectionFactory() {
		getDirections().put(EastDirection.DEFAULT_DIRECTION_ORDER, new EastDirection());
		getDirections().put(WestDirection.DEFAULT_DIRECTION_ORDER, new WestDirection());
		getDirections().put(NorthDirection.DEFAULT_DIRECTION_ORDER, new NorthDirection());
		getDirections().put(SouthDirection.DEFAULT_DIRECTION_ORDER, new SouthDirection());
	}

	/**
	 * This method returns an Instance of <code>Direction</code> Object from directions <code>Map</code>(factory) based 
	 * on the string code passed as an argument.
	 * Example: If we pass "E" as an argument to this method it'll return an <code>EastDirection</code> Object.
	 * @param directionStringCode  String value/code for a direction to be retrieved from factory;
	 */
	public Direction getDirection(String directionStringCode) {
		for(Entry<Integer, Direction> direction : getDirections().entrySet()) {
			if(direction.getValue().getDirectionCode().equals(directionStringCode))
				return direction.getValue();
		}

		throw new InvalidDirectionCodeException(String.format("Invalid Direction code %s: ", directionStringCode));
	}

	/**
	 * Returns the factory <code>Map</code> (of <code>Direction</code>) which contains (Key, Value) 
	 * pair of direction codes and Direction instances. If you want to add more direction codes based 
	 * on your need then you can extend the Direction class and can add instance of newly created Direction
	 * class in this factory Map so that it'll be available across the application.
	 */
	public SortedMap<Integer, Direction> getDirections() {
		return directions;
	}

	/**
	 * <b>NOTE:</b> Please use this method carefully in rare cases when you actually want to create altogether a 
	 * new Map of Direction's factory objects.</br></br>
	 * If you want to replace current Map of Direction factory object and want to use your own then create a Map 
	 * somewhere outside and pass it as an argument to this method.
	 * 
	 * @param directions <code>SortedMap</code> of directions which contains (Key, Value) pair direction codes 
	 * and <code>Direction</code> instances.
	 */
	public void setDirections(SortedMap<Integer, Direction> directions) {
		this.directions = directions;
	}

}
