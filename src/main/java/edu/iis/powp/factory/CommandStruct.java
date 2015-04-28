package edu.iis.powp.factory;

import edu.iis.powp.command.IPlotterCommand;

public class CommandStruct implements Cloneable {

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
