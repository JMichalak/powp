package edu.iis.powp.factory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.client.plottermagic.preset.FiguresJoe;
import edu.iis.powp.adapter.LineAdapterPlotterDriver;
import edu.iis.powp.app.Application;
import edu.iis.powp.app.ApplicationWithDrawer;
import edu.iis.powp.app.Context;
import edu.iis.powp.app.DriverManager;
import edu.iis.powp.command.ComplexCommand;
import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.iis.powp.gui.event.predefine.SelectTestFigureOptionListener;
import edu.kis.powp.drawer.panel.DrawPanelController;
import edu.kis.powp.drawer.shape.line.BasicLine;

public class TestFactory {

	public static void main(String[] args) {

		ApplicationWithDrawer.configureApplication();
		Context context = Application.getComponent(Context.class);
        setupDrivers(context);
        setupPresetTests(context);
        
		DrawPanelController controller = new DrawPanelController();
        controller.setVisible(true);
        
	}
	
	/**
     * Sets plotter simulators
     * 
     * @param context Application context.
     */
    private static void setupDrivers(Context context) {
        
        IPlotter plotter = new LineAdapterPlotterDriver(new BasicLine(), "basic");
        context.addDriver("Line Simulator", plotter);
        Application.getComponent(DriverManager.class).setCurrentPlotter(plotter);
        context.updateDriverInfo();
        
        plotter = LineAdapterPlotterDriver.getSpecialLineAdapter();
        context.addDriver("Special line Simulator", plotter);
    }
    
	/**
	 * Setup test in context.
	 * 
	 * @param context Application context.
	 */
	private static void setupPresetTests(Context context) {

		CommandManager manager = new CommandManager();
		CommandFactory factory = manager.getFactory();
		
		context.addTest("Test 1", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				IPlotterCommand firstComand = new SetPositionCommand(0, 0);
				IPlotterCommand secondCommmand = new DrawToCommand(100, 200);
				CommandBuilder builder = manager.newCommand(firstComand);
				builder.addCommand(secondCommmand);
				ComplexCommand firstComplex = builder.build();
				factory.addCommand("test", firstComplex, CommandType.circle);
				factory.getCommand("test").execute(Application.getComponent(DriverManager.class).getCurrentPlotter());
			}
			
		});	        

		context.addTest("Znaczek", new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	IPlotterCommand firstComand = new SetPositionCommand(0, 0);
				
				CommandBuilder builder = manager.newCommand(firstComand);
				builder.addCommand(new DrawToCommand(100, 0));
				builder.addCommand(new DrawToCommand(0,60));
				builder.addCommand(new DrawToCommand(50,-40));
				builder.addCommand(new DrawToCommand(100,60));
				builder.addCommand(new DrawToCommand(0,0));
				ComplexCommand firstComplex = builder.build();
				factory.addCommand("znaczek", firstComplex, CommandType.circle);
				factory.getCommand("znaczek").execute(Application.getComponent(DriverManager.class).getCurrentPlotter());
		    }
		});
		
		
		
		context.addTest("Test 2", new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	IPlotterCommand firstComand = new SetPositionCommand(0, 0);
				IPlotterCommand secondCommmand = new DrawToCommand(-100, -200);
				CommandBuilder builder = manager.newCommand(firstComand);
				builder.addCommand(secondCommmand);
				ComplexCommand firstComplex = builder.build();
				factory.addCommand("test", firstComplex, CommandType.circle);
				factory.getCommand("test").execute(Application.getComponent(DriverManager.class).getCurrentPlotter());
		    }
		});
	}

}
