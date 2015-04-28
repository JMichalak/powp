package edu.iis.powp.command;

import java.io.Serializable;
import java.util.List;

import edu.iis.client.plottermagic.IPlotter;

public class ComplexCommand implements IPlotterCommand, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<IPlotterCommand> commands;

	public ComplexCommand(List<IPlotterCommand> commands) {
		this.commands = commands;
	}
	
	@Override
	public void execute(IPlotter plotter) {
		for (IPlotterCommand command: commands)
			command.execute(plotter);
	}

}
