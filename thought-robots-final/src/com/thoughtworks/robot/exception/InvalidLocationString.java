package com.thoughtworks.robot.exception;

import com.thoughtworks.robot.locations.BaseLocationParser;
import com.thoughtworks.robot.locations.LocationParser;


/**
 * This exception will be used to notify an Exception situation where program/code has received an invalid location string.
 * A location string is a combination of XY (or Z in future) coordinates and direction code (e.g. 1 1 E). A location string
 * passed as a command to <code>Robot</code> will be parsed by a regular expression based parser.
 * 
 * Right now we are not handling special cases here but we can enhance this Exception class further based in need.
 * 
 * @see LocationParser
 * @see BaseLocationParser
 * 
 * @author sshinde
 *
 */
@SuppressWarnings("serial")
public class InvalidLocationString extends RuntimeException {

	public InvalidLocationString(String errorMessage) {
		super(errorMessage);
	}
	
}
