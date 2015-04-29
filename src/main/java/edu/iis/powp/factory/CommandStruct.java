package edu.iis.powp.factory;

import java.io.Serializable;

import edu.iis.powp.command.IPlotterCommand;

public class CommandStruct implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5521547335076137963L;
	private IPlotterCommand command;
	private CommandType type;
	
	public IPlotterCommand getCommand() {
		return command;
	}


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
