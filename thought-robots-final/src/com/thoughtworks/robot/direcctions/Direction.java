package com.thoughtworks.robot.direcctions;

import com.thoughtworks.robot.Robot;

/**
 * This class is a base class for all <code>Direction</code> classes. Each direction is treated as separate class 
 * and this class provides basic skeleton for new <code>Direction</code> classes. Each Direction should have a 
 * <code><b>code</b></code> and <code><b>order</b></code>. A code is nothing but a simple String value which represents
 * a direction and order is a numeric value which represents cyclic place/order of particular direction.
 * </br></br>
 * <b>Example:</b> Let's say we have 4 directions (EAST, WEST, NORTH and SOUTH) and if we arrange them in cyclic order 
 * they will be arranged as EAST->NORTH->WEST->SOUTH->EAST. We can not sort them by name (direction code) that's we
 * need an integer order value to put a particular direction at right place in cyclic order. In future, let's say we 
 * want to add new direction (between NOTH and EAST as NORTHEAST) so, we'll assign an integer value/order to NORTHEAST 
 * so that it lies between NORTH and EAST's order value.
 *  
 * @author sshinde
 *
 */
public abstract class Direction {
	private String directionCode;
	private int order;

	/**
	 * Public constructor which puts a restriction so that user can not initilizes a <code>Direction</code> without 
	 * <code>directionCode</code> and <code>order</code> value.
	 * 
	 * @param directionCode A string representation of a direction
	 * @param order A integer value which represents order of direction
	 * 
	 * @see EastDirection
	 * @see WestDirection
	 * @see NorthDirection
	 * @see SouthDirection
	 */
	public Direction(String directionCode, int order) {
		this.directionCode = directionCode;
		this.order = order;
	}

	/**
	 * This method returns an string value/code of a particular <code>Direction</code>
	 * @return int order of Direction
	 * 
	 * @see Direction
	 */
	public String getDirectionCode() {
		return directionCode;
	}

	public void setDirectionCode(String directionCode) {
		this.directionCode = directionCode;
	}

	/**
	 * This method returns an integer value/order of a particular <code>Direction</code>
	 * @return int order of Direction
	 * 
	 * @see Direction
	 */
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	/**
	 * Method which will be implemented by all direction classes extended from this class. The implementation should 
	 * update X,Y or Z coordinate values based on the directional movement of <code>Robot</code>
	 * @param robot A robot instance who's coordinates needs to be updated.
	 * 
	 * @see EastDirection
	 * @see WestDirection
	 * @see NorthDirection
	 * @see SouthDirection
	 */
	public abstract void updateCoordinates(Robot robot);

	/**
	 * Return a Left direction from <code>directionFactory</code> based on <code>order</code> value of Direction 
	 * instance variable on/from which this method has been called.
	 * 
	 * @param directionFactory <code>DirectionFactory</code> which holds ordered directions.
	 * @return <code>Direction</code> 
	 * 
	 * @see BaseDirectionFactory
	 * @see Direction
	 */
	public Direction getLeftDirection(DirectionFactory directionFactory) {
		return directionFactory.getDirections().get(
				getOrder() + 1 > directionFactory.getDirections().size() - 1 ? 0 : getOrder() + 1);
	}

	/**
	 * Return a Right direction from <code>directionFactory</code> based on <code>order</code> value of Direction 
	 * instance variable on/from which this method has been called.
	 * 
	 * @param directionFactory <code>DirectionFactory</code> which holds ordered directions.
	 * @return <code>Direction</code> Left direction from factory.
	 * 
	 * @see BaseDirectionFactory
	 * @see Direction
	 */
	public Direction getRightDirection(DirectionFactory directionFactory) {
		return directionFactory.getDirections().get(
				getOrder() - 1 < 0 ? directionFactory.getDirections().size() -1 : getOrder() - 1);
	}

	/**
	 * Overridden method which compares two <code>Direction</code>(S) and returns <code>true/false</code>. Two directions
	 * are treated as same when they have same <code>Direction.directionCode</code> and <code>Direction.order</code>.
	 * 
	 * If you there is need, users can override this method again based on need.
	 * 
	 * @param object another <code>Direction</code> object.
	 * @return <code>boolean</code> true/false
	 * 
	 * @see BaseDirectionFactory
	 * @see Direction
	 */
	public boolean equals(Object object) {
		if(object != null && object instanceof Direction) {
			Direction direction = (Direction)object;
			if(direction.getDirectionCode().equals(getDirectionCode()) && direction.getOrder() == getOrder()) {
				return true;
			}
		}

		return false;
	}

}
