package com.thoughtworks.robot.moves;

/**
 * A {@link MoveFactory} is supposed to have  all supported {@link Move}(s) so that other piece(s) of program can fetch
 * appropriate moves ({@link LeftMove}, {@link RightMove} or {@link StepMove} or more can be added) based on 
 * <code>moveCode</code> (e.g. L,M or R). For example implementation please refer {@link BaseMoveFactory}.
 * 
 * @author sshinde
 *
 * @see BaseMoveFactory
 */
public interface MoveFactory {
	/**
	 * Return an instance of {@link Move} based on the <code>moveCode</code>
	 * 
	 * @param moveCode String code which represents a move (L, M or R) 
	 * @return {@link Move} an instance of {@link Move} based on the <code>moveCode</code>
	 */
	public Move getMove(String moveCode);
}
