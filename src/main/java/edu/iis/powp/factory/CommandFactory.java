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
	 * @throws CloneNotSupportedException 
	 */
	public IPlotterCommand getCommand(String key){
		IPlotterCommand command = null;
		try {
			command = commandsSet.get(key).clone().getCommand();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return command;
	}

	/**
	 * 
	 * @param CommandType
	 */
	public List<IPlotterCommand> getCommands(CommandType type) {
		List<IPlotterCommand> commands = new ArrayList<>();
		commandsSet.forEach((k, v) -> {
			if (v.getType().equals(type))
				try {
					commands.add(v.clone().getCommand());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
