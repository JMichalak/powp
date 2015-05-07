package edu.iis.powp.command;

import java.io.Serializable;

import edu.iis.client.plottermagic.IPlotter;

/**
 * Implementation of IPlotterCommand for drawTo command functionality.
 */
public class DrawToCommand implements IPlotterCommand, Serializable {

	private static final long serialVersionUID = -5367268041510251262L;
	private int posX, posY;
	
	public DrawToCommand(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
	}

	@Override
	public void execute(IPlotter plotter) {
		plotter.drawTo(posX, posY);
	}

	public DrawToCommand clone() {
		
		try {
			return (DrawToCommand) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}
