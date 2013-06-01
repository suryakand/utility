package com.thoughtworks.robot.moves;

import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.robot.Robot;
import com.thoughtworks.robot.exception.InvalidMoveCodeException;
import com.thoughtworks.robot.space.Plateau;

/**
 * A factory class for supported {@link Move} on a {@link Plateau} for a {@link Robot}.
 * If there is need to support new type of {@link Move} then, we can add it to movesFactory using getter/setter.  
 * 
 * @author sshinde
 *
 * @see Move
 * @see LeftMove
 * @see RightMove
 * @see StepMove
 * @see MoveFactory
 * 
 */
public class BaseMoveFactory implements MoveFactory {

	private Map<String, Move> movesFactory = new HashMap<String, Move>();

	public BaseMoveFactory() {
		getMovesFactory().put(LeftMove.MOVE_CODE, new LeftMove());
		getMovesFactory().put(RightMove.MOVE_CODE, new RightMove());
		getMovesFactory().put(StepMove.MOVE_CODE, new StepMove());
	}

	/**
	 * Return {@link Move} Object from moveFactory based on input string code (L, R or M)
	 * 
	 * @param moveCode A string value which represents {@link Move}
	 * @return {@link Move} Move Object from moveFactory based on input string code (L, R or M)
	 * 
	 * @throws InvalidMoveCodeException
	 * @see Move
	 * @see LeftMove
	 * @see RightMove
	 * @see StepMove
	 */
	public Move getMove(String moveCode) {
		if(getMovesFactory().containsKey(moveCode))
			return getMovesFactory().get(moveCode);

		throw new InvalidMoveCodeException(String.format("Invalid Move code %s: ", moveCode));
	}

	public Map<String, Move> getMovesFactory() {
		return movesFactory;
	}

	public void setMovesFactory(Map<String, Move> movesFactory) {
		this.movesFactory = movesFactory;
	}

}
