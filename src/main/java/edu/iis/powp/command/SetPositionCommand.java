package edu.iis.powp.command;

import java.io.Serializable;

import edu.iis.client.plottermagic.IPlotter;

/**
 * Implementation of IPlotterCommand for setPosition command functionality.
 */
public class SetPositionCommand implements IPlotterCommand, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5068118221740786515L;
	private int posX, posY;
	
	public SetPositionCommand(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
	}

	@Override
	public void execute(IPlotter plotter) {
		plotter.setPosition(posX, posY);
	}
	
	public SetPositionCommand clone(){
		
		try {
			return (SetPositionCommand) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}
