package edu.iis.powp.factory;

import edu.iis.powp.command.IPlotterCommand;

/**
 * CommandManager offers interface for creating and adding commands.
 * @author Grupa 6
 * @see ComplexCommand, IPlotterCommand, CommandFactory
 */
public class CommandManager {

	private CommandFactory commandFactory;

	public CommandManager() {
		commandFactory = CommandFactory.getInstance();
	}
	
	/**
	 * Return reference to CommandFactory instance.
	 * @return Reference to CommandFactory instance.
	 */
	public CommandFactory getFactory() {
		return commandFactory;
	}
	
	/**
	 * Start building new ComplexCommand.
	 * @param IPlotterCommand
	 */
	public CommandBuilder newCommand(IPlotterCommand command) {
		CommandBuilder builder = new CommandBuilder();
		builder.addCommand(command);
		return builder;
	}

}
