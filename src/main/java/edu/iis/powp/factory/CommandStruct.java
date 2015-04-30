package edu.iis.powp.factory;

import java.io.Serializable;

import edu.iis.powp.command.IPlotterCommand;

/**
 * 
 * CommandStruct contains complete information about command.
 * @author Grupa 6
 * @see CommandType
 *
 */
public class CommandStruct implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5521547335076137963L;
	
	/**
	 * Exact command.
	 */
	private IPlotterCommand command;
	
	/**
	 * Type of the command.
	 */
	private CommandType type;
	
	
	/**
	 * @return Exact part of the command.
	 */
	public IPlotterCommand getCommand() {
		return command;
	}


	/**
	 * Returns type of the command.
	 * @return Type of the command.
	 */
	public CommandType getType() {
		return type;
	}
	
	public CommandStruct(IPlotterCommand command, CommandType type) {
		super();
		this.command = command;
		this.type = type;
	}

	@Override
	public CommandStruct clone() throws CloneNotSupportedException {
		return (CommandStruct) super.clone();
	}
	
}
