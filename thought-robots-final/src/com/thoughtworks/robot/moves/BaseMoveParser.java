package com.thoughtworks.robot.moves;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.thoughtworks.robot.space.Plateau;

/**
 * Base class which implements {@link MoveParser}. This class parses the input move/command string and creates 
 * {@link Move} instances base on move code (L, R or M). This classes uses <code>movementStringPattern</code> for parsing
 * input move/command string. If a user want to parse the input move/command string in different way then, either they can
 * set a new move pattern (using setMovementStringPattern()) or can extend this class for more changes.
 * 
 * @author sshinde
 * 
 * @see MoveParser
 * @see Move
 * @see LeftMove
 * @see RightMove
 * @see StepMove
 *
 */
public class BaseMoveParser implements MoveParser {
	// This can be a configurable property if used in a full fledged application along with a good framework (e.g Spring)
	private String movementStringPattern = "[L,R,M]"; 
	private MoveFactory moveFactory;

	public BaseMoveParser(MoveFactory moveFactory) {
		this.moveFactory = moveFactory;
	}

	/**
	 * This method parses the input <code>movementString</code> (e.g. LMRMLR) and returns a {@link List} of {@link Move} 
	 * instances based on move code (L, R or M)
	 * 
	 * @param movementString A string/command which instructs robot how to move on a {@link Plateau}. 
	 * @return <code>List</code> list of moves (one for each move code L, M, R)
	 * 
	 * @see Move
	 * @see LeftMove
	 * @see RightMove
	 * @see StepMove
	 */
	public List<Move> parserMovements(String movementString) {
		List<Move> robotMoves = new ArrayList<Move>();
		Pattern moveCodePattern = Pattern.compile(getMovementStringPattern());
		Matcher moveCodeMatcher = moveCodePattern.matcher(movementString);

		while (moveCodeMatcher.find()) {
			robotMoves.add(getMoveFactory().getMove(moveCodeMatcher.group()));
		}

		return robotMoves;
	}

	public String getMovementStringPattern() {
		return movementStringPattern;
	}

	/**
	 * This method can be used to pass a custom regular expression pattern for matching/parsing the input
	 * <code>movementStringPattern</code> value.
	 * 
	 * @param movementStringPattern
	 */
	public void setMovementStringPattern(String movementStringPattern) {
		this.movementStringPattern = movementStringPattern;
	}

	public MoveFactory getMoveFactory() {
		return moveFactory;
	}

	public void setMoveFactory(MoveFactory moveFactory) {
		this.moveFactory = moveFactory;
	}
}
