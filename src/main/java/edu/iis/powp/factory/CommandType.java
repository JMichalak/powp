package edu.iis.powp.factory;

import java.io.Serializable;


/**
 * 
 * Types of commands that can be used.
 * <li>{@link #square}</li>
 * <li>{@link #circle}</li>
 * <li>{@link #triangle}</li>
 * <li>{@link #line}</li>
 * @author Grupa 6
 *		
 */
public enum CommandType implements Serializable {
	
	/**
	 * Type for squares.
	 */
	square,
	
	
	/**
	 * Type for circles.
	 */
	circle,
	
	
	/**
	 * Type for triangles.
	 */
	triangle,
	
	
	/**
	 * Type for lines.
	 */
	line
	
}
