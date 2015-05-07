package edu.iis.powp.command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.iis.client.plottermagic.IPlotter;

/**
 * ComplexCommand subtype of IPlotterCommand, contains one or more basic commands.
 * @author Grupa 6
 * @see CommandBuilder, IPlotterCommand
 */
public class ComplexCommand implements ICompoundCommand, IPlotterCommand, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6696376212824058299L;
	private List<IPlotterCommand> commands;

	public ComplexCommand(List<IPlotterCommand> commands) {
		this.commands = commands;
	}
	
	@Override
	public void execute(IPlotter plotter) {
		for (IPlotterCommand command: commands)
			command.execute(plotter);
	}

	public ComplexCommand clone() {
		
		List<IPlotterCommand> commands = new ArrayList<>();
		this.commands.forEach((v)->{
			commands.add(v.clone());
		});
		return new ComplexCommand(commands);
		
	}

	@Override
	public Iterator<IPlotterCommand> iterator() {
		return commands.iterator();
	}
	
}
