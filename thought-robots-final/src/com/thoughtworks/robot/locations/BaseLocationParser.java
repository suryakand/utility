package com.thoughtworks.robot.locations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.thoughtworks.robot.direcctions.Direction;
import com.thoughtworks.robot.direcctions.DirectionFactory;
import com.thoughtworks.robot.exception.InvalidLocationString;

/**
 * Base {@link LocationParser} parser which parses the passed location string using regular expression. 
 * If you want to parse locations using different regular expression then use the setter methods for 
 * <code>coordinatePattern</code> and <code>directionPattern</code>
 * @author sshinde
 * 
 * @see LocationParser
 * @see Location
 * @see Coordinate
 * @see Direction
 *
 */
public class BaseLocationParser implements LocationParser {
	// These patterns can be a configurable properties if used in a full fledged application along with a good framework (e.g Spring)
	private String coordinatePattern = "\\d+";
	private String directionPattern = "[E,W,N,S]+";
	private DirectionFactory directionFactory;

	public BaseLocationParser(DirectionFactory directionFactory) {
		this.directionFactory = directionFactory;
	}
	
	/**
	 * This method parses the input location string an creates a {@link Location} instance. Internally this method
	 * calls <code>parseCoordinates()</code> and <code>parseDirection()</code> methods for creating {@link Coordinate} 
	 * and {@link Direction} instances. If you want to use this {@link BaseLocationParser} as base class but want 
	 * to parse only {@link Coordinate}(s) in different way than override the parseCoordinates() method in new class.
	 * 
	 * @param locationString A string value which represents location (e.g. 1 1 E)
	 * @return parsed {@link Location} value for input string 
	 */
	public Location parseLocation(String locationString) throws InvalidLocationString {
		Location parsedLocation = null;
		if(locationString != null) {
			parsedLocation = new Location(parseCoordinates(locationString), parseDirection(locationString));
		} else {
			throw new InvalidLocationString(String.format("Invalid location string argument (%s)", locationString));
		}

		return parsedLocation;
	}

	/**
	 * This method will return the {@link Coordinate} for passed <code>locationString</code>. This method is internally
	 * called by parseLocation(). Users can override this method to have their own {@link Coordinate} parsing logic.
	 * 
	 * @param locationString A string value which represents location (e.g. 1 1 E) 
	 * @return {@link Coordinate}
	 */
	public Coordinate parseCoordinates(String locationString) throws InvalidLocationString {
		Matcher coordinatesMatcher = Pattern.compile(getCoordinatePattern()).matcher(locationString);

		//Parse coordinates
		Coordinate xyCoordinate = new Coordinate();
		if(coordinatesMatcher.find())
			xyCoordinate.setX(Integer.parseInt(coordinatesMatcher.group()));
		else
			throw new InvalidLocationString("Invalid X Coordinate");
		if(coordinatesMatcher.find())
			xyCoordinate.setY(Integer.parseInt(coordinatesMatcher.group()));
		else
			throw new InvalidLocationString("Invalid Y Coordinate");

		return xyCoordinate;
	}

	/**
	 * This method will return the {@link Direction} for passed <code>locationString</code>. This method is internally
	 * called by parseLocation(). Users can override this method to have their own {@link Direction} parsing logic.
	 * 
	 * @param locationString A string value which represents location (e.g. 1 1 E) 
	 * @return {@link Direction}
	 */
	public Direction parseDirection(String locationString) throws InvalidLocationString {
		Matcher directionMatcher = Pattern.compile(getDirectionPattern()).matcher(locationString);
		//Parse direction
		if(directionMatcher.find() && getDirectionFactory() != null) {
			return getDirectionFactory().getDirection(directionMatcher.group());
		}
		
		throw new InvalidLocationString("Invalid Direction");
	}

	public String getCoordinatePattern() {
		return coordinatePattern;
	}

	public void setCoordinatePattern(String coordinatePattern) {
		this.coordinatePattern = coordinatePattern;
	}

	public String getDirectionPattern() {
		return directionPattern;
	}

	public void setDirectionPattern(String directionPattern) {
		this.directionPattern = directionPattern;
	}

	public DirectionFactory getDirectionFactory() {
		return directionFactory;
	}

	public void setDirectionFactory(DirectionFactory directionFactory) {
		this.directionFactory = directionFactory;
	}

}
