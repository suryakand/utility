package com.thoughtworks.robot.moves;

import java.util.List;

import com.thoughtworks.robot.space.Plateau;

/**
 * Interface that must be implemented by custom Move parsers which we want to user for parsing move command/string.
 * For example implementation please refer {@link BaseMoveParser}
 * 
 * @author sshinde
 * 
 * @see Move
 * @see BaseMoveParser
 */
public interface MoveParser {
	/**
	 * Must be implememnted by custom Move parsers. This method parses the input <code>movementString</code> (e.g. LMRMLR) 
	 * and returns a {@link List} of {@link Move} instances based on move code (L, R or M)
	 * 
	 * @param movementString A string/command which instructs robot how to move on a {@link Plateau}. 
	 * @return <code>List</code> list of moves (one for each move code L, M, R)
	 * 
	 * @see Move
	 * @see LeftMove
	 * @see RightMove
	 * @see StepMove
	 */
	public List<Move> parserMovements(String movementString);
}
