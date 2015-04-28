package edu.iis.powp.factory;

import java.util.ArrayList;
import java.util.List;

import edu.iis.powp.command.*;

public class CommandBuilder {

	/**
	 * 
	 * @param IPlotterCommand
	 */
	private List<IPlotterCommand> commands;
	
	public CommandBuilder() {
		commands = new ArrayList<>();
	}
	
	public CommandBuilder addCommand(IPlotterCommand command) {
		commands.add(command);
		return this;
	}

	public ComplexCommand build() {
		return new ComplexCommand(commands);
	}

}
