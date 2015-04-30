package edu.iis.powp.factory;

import java.util.ArrayList;
import java.util.List;

import edu.iis.powp.command.*;

/**
 * CommandBuilder offer complete functionality of building new ComplexCommand, like creating new command, adding components to it, and building Complex command.
 * @author Grupa 6
 * @see ComplexCommand, IPlotterCommand
 *
 */
public class CommandBuilder {

	private List<IPlotterCommand> commands;
	
	public CommandBuilder() {
		commands = new ArrayList<>();
	}
	
	
	/**
	 * Adds new component.
	 * @param command
	 * @return
	 */
	public CommandBuilder addCommand(IPlotterCommand command) {
		commands.add(command);
		return this;
	}

	/**
	 * Returns new ComplexCommand from components added.
	 * @return New ComplexCommand from components.
	 */
	public ComplexCommand build() {
		return new ComplexCommand(commands);
	}

}
