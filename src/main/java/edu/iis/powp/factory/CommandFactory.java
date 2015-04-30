package edu.iis.powp.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.iis.powp.command.IPlotterCommand;

/**
 * CommandFactory controls CommandFactory instance, stores all commands, allowing add, save and load them from file. 
 * @author Grupa 6
 * @see CommandManager, CommandBuilder, ComplexCommand, IPlotterCommand
 */
public class CommandFactory {

	private static CommandFactory instance = new CommandFactory();
	
	/**
	 * 
	 */
	protected Map<String, CommandStruct> commandsSet;

	private CommandFactory() {
		commandsSet = new HashMap<>();
	}
	

	/**
	 * Allows to add new command.
	 * @param key
	 * @param command
	 * @param type
	 */
	public void addCommand(String key, IPlotterCommand command, CommandType type) {
		commandsSet.put(key, new CommandStruct(command, type));
	}

	/**
	 * Return Command with the given key.
	 * @param String
	 * @throws CloneNotSupportedException 
	 */
	public IPlotterCommand getCommand(String key){
		IPlotterCommand command = null;
		try {
			command = commandsSet.get(key).clone().getCommand();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return command;
	}

	/**
	 * Return list off all suitable commands.
	 * @return List off all suitable commands.
	 * @param CommandType
	 */
	public List<IPlotterCommand> getCommands(CommandType type) {
		List<IPlotterCommand> commands = new ArrayList<>();
		commandsSet.forEach((k, v) -> {
			if (v.getType().equals(type))
				try {
					commands.add(v.clone().getCommand());
				} catch (Exception e) {
					e.printStackTrace();
				}
		});
		return commands;
	}

	/**
	 * Load commands from file.
	 * @param String
	 */
	@SuppressWarnings("unchecked")
	public Map<String, CommandStruct> importCommands(String filePath) {
		
		Map<String, CommandStruct> commands = null;
		try (ObjectInputStream input = new ObjectInputStream( new FileInputStream(filePath) )) {
			commands = (Map<String, CommandStruct>) input.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return commands;
		
	}

	/**
	 * Saves commands to file.
	 * @param String
	 */
	public void exportCommands(String filePath) {
		try (ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream(filePath) )) {
			output.writeObject(commandsSet);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Return reference to CommandFactory instance.
	 * @return Reference to CommandFactory instance.
	 */
	public static CommandFactory getInstance() {
		return instance;
	}

}
