package edu.iis.powp.command;

import edu.iis.client.plottermagic.IPlotter;

/**
 * PlotterCommand interface.
 */
public interface IPlotterCommand extends Cloneable {

    /**
     * Execute command on plotter.
     * 
     * @param plotter plotter.
     */
	public void execute(IPlotter plotter);

	public IPlotterCommand clone();

	//public IPlotterCommand clone();
	
	
}
