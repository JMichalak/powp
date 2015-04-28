package edu.iis.powp.factory;

import edu.iis.powp.command.IPlotterCommand;

public class CommandManager {

	private CommandFactory commandFactory;

	public CommandManager() {
		commandFactory = CommandFactory.getInstance();
	}
	
	public CommandFactory getFactory() {
		return commandFactory;
	}
	
	/**
	 * 
	 * @param IPlotterCommand
	 */
	public CommandBuilder newCommand(IPlotterCommand command) {
		CommandBuilder builder = new CommandBuilder();
		builder.addCommand(command);
		return builder;
	}

}
