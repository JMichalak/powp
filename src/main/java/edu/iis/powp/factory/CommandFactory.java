package edu.iis.powp.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.iis.powp.command.*;

public class CommandFactory {

	private static CommandFactory instance = new CommandFactory();
	
	private Map<String, CommandStruct> commandsSet;

	private CommandFactory() {
		commandsSet = new HashMap<>();
	}
	
	/**
	 * 
	 * @param String
	 * @param IPlotterCommand
	 * @param CommandType
	 */
	public void addCommand(String key, IPlotterCommand command, CommandType type) {
		commandsSet.put(key, new CommandStruct(command, type));
	}

	/**
	 * 
	 * @param String
	 */
	public IPlotterCommand getCommand(String key) {
		return commandsSet.get(key).getCommand();
	}

	/**
	 * 
	 * @param CommandType
	 */
	public List<IPlotterCommand> getCommands(CommandType type) {
		List<IPlotterCommand> commands = new ArrayList<>();
		commandsSet.forEach((k, v) -> {
			if (v.getType().equals(type))
				commands.add(v.getCommand());
		});
		return commands;
	}

	/**
	 * 
	 * @param String
	 */
	public Map<String, CommandStruct> importCommands(int String) {
		// TODO - implement CommandFactory.importCommands
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param String
	 */
	public void export(int String) {
		// TODO - implement CommandFactory.export
		throw new UnsupportedOperationException();
	}

	public static CommandFactory getInstance() {
		return instance;
	}

}
