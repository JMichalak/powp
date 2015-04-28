package edu.iis.powp.factory;

import edu.iis.powp.command.*;

public class CommandFactory {

	private Map<String, CommandStruct> commandsSet;

	/**
	 * 
	 * @param String
	 * @param IPlotterCommand
	 * @param CommandType
	 */
	public void addCommand(int String, int IPlotterCommand, int CommandType) {
		// TODO - implement CommandFactory.addCommand
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param String
	 */
	public IPlotterCommand getCommand(int String) {
		// TODO - implement CommandFactory.getCommand
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param CommandType
	 */
	public List<IPlotterCommand> getCommands(int CommandType) {
		// TODO - implement CommandFactory.getCommands
		throw new UnsupportedOperationException();
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

	public CommandFactory getInstance() {
		// TODO - implement CommandFactory.getInstance
		throw new UnsupportedOperationException();
	}

}