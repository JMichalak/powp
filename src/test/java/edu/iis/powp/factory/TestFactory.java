package edu.iis.powp.factory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.adapter.LineAdapterPlotterDriver;
import edu.iis.powp.app.Application;
import edu.iis.powp.app.ApplicationWithDrawer;
import edu.iis.powp.app.Context;
import edu.iis.powp.app.DriverManager;
import edu.iis.powp.command.ComplexCommand;
import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.kis.powp.drawer.panel.DrawPanelController;
import edu.kis.powp.drawer.shape.line.BasicLine;

public class TestFactory {

	public static void main(String[] args) {

		ApplicationWithDrawer.configureApplication();
		Context context = Application.getComponent(Context.class);
        setupDrivers(context);
        createPresetCommands();
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
    
    private static void createPresetCommands() {
    	
    	CommandManager manager = new CommandManager();
		CommandFactory factory = manager.getFactory();
    	
		//Test 1
    	IPlotterCommand firstComand = new SetPositionCommand(0, 0);
		IPlotterCommand secondCommmand = new DrawToCommand(100, 100);
		CommandBuilder builder = manager.newCommand(firstComand);
		builder.addCommand(secondCommmand);
		ComplexCommand firstComplex = builder.build();
		factory.addCommand("test1", firstComplex, CommandType.circle);
    	
		//Znaczek
		firstComand = new SetPositionCommand(0, 0);
		
		builder = manager.newCommand(firstComand);
		builder.addCommand(new DrawToCommand(100, 0));
		builder.addCommand(new DrawToCommand(100, 0));
		builder.addCommand(new DrawToCommand(0,60));
		builder.addCommand(new DrawToCommand(50,-40));
		builder.addCommand(new DrawToCommand(100,60));
		builder.addCommand(new DrawToCommand(0,0));
		firstComplex = builder.build();
		factory.addCommand("znaczek", firstComplex, CommandType.circle);
		
		//Test 2
		firstComand = new SetPositionCommand(0, 0);
		secondCommmand = new DrawToCommand(100, 0);
		builder = manager.newCommand(firstComand);
		builder.addCommand(secondCommmand);
		firstComplex = builder.build();
		factory.addCommand("test2", firstComplex, CommandType.circle);
		
		//Kolko
		firstComand = new SetPositionCommand(0, 0);
		builder = manager.newCommand(firstComand);
		for (int i = 0; i<3600; ++i) {
			builder.addCommand(new SetPositionCommand(
					(int)(Math.round(Math.sin(i*0.1)*199)),
					(int)(Math.round(Math.cos(i*0.1)*199))
					));
			builder.addCommand(new DrawToCommand(
					(int)(Math.round(Math.sin(i*0.1)*200)),
					(int)(Math.round(Math.cos(i*0.1)*200))
					));
		}
		ComplexCommand command = builder.build();
		factory.addCommand("kolko", command, CommandType.circle);
		
		//SinModify
		final int roz = 1000;
		firstComand = new SetPositionCommand(-1000, 0);
		builder = manager.newCommand(firstComand);
		
		for(int i=-1000;i<1000;i+=10)
		{
			builder.addCommand(new DrawToCommand(i,(int)(Math.sin(i)*roz/i)));
			builder.addCommand(new SetPositionCommand(i,(int)(Math.sin(i)*roz/i)));
		}
		
		firstComplex = builder.build();
		factory.addCommand("SinModify", firstComplex, CommandType.circle);
		
		//Tangens
		firstComand = new SetPositionCommand(-1000, 0);
		builder = manager.newCommand(firstComand);
		
		for(int i=-1000*roz;i<1000*roz;i+=10)
		{
			builder.addCommand(new DrawToCommand(i,(int)(Math.tan(i)*100)));
			builder.addCommand(new SetPositionCommand(i,(int)(Math.tan(i)*100)));
		}
		
		firstComplex = builder.build();
		factory.addCommand("Tangens", firstComplex, CommandType.circle);
		
		//Sinus
		firstComand = new SetPositionCommand(-1000, 0);
		builder = manager.newCommand(firstComand);
		
		for(int i=-1000;i<1000;i+=20)
		{
			builder.addCommand(new DrawToCommand(i,(int)(Math.sin(i)*100)));
			builder.addCommand(new SetPositionCommand(i,(int)(Math.sin(i)*100)));
		}
		
		firstComplex = builder.build();
		factory.addCommand("Sinus", firstComplex, CommandType.circle);
		
	}
    
	/**
	 * Setup test in context.
	 * 
	 * @param context Application context.
	 */
	private static void setupPresetTests(Context context) {

		CommandManager manager = new CommandManager();
		CommandFactory factory = manager.getFactory();

		final String COMMANDS_FILE_PATH = "commands";
		
		context.addComponentMenuElement(DrawPanelController.class, "Save", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				factory.exportCommands(COMMANDS_FILE_PATH);
			}
		}, false);
		context.addComponentMenuElement(DrawPanelController.class, "Load", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				factory.commandsSet.putAll( factory.importCommands(COMMANDS_FILE_PATH) );
				factory.commandsSet.forEach((k, v)->{
					context.addTest(k, new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							v.getCommand().execute(Application.getComponent(DriverManager.class).getCurrentPlotter());
						}
					});
				});
			}
		}, false);
		
		context.addTest("Test 1", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				factory.getCommand("test1").execute(Application.getComponent(DriverManager.class).getCurrentPlotter());
			}
			
		});	        

		context.addTest("Znaczek", new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
				factory.getCommand("znaczek").execute(Application.getComponent(DriverManager.class).getCurrentPlotter());
		    }
		});
		

		context.addTest("Test 2", new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
				factory.getCommand("test2").execute(Application.getComponent(DriverManager.class).getCurrentPlotter());
		    }
		});
		
		context.addTest("Kolko", new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
				factory.getCommand("kolko").execute(Application.getComponent(DriverManager.class).getCurrentPlotter());
		    }
		});
		
		final int roz = 1000;
		
		context.addTest("SinModify", new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
				factory.getCommand("SinModify").execute(Application.getComponent(DriverManager.class).getCurrentPlotter());
		    }
		});
		
		context.addTest("Tangens", new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
				factory.getCommand("Tangens").execute(Application.getComponent(DriverManager.class).getCurrentPlotter());
		    }
		});
		
		context.addTest("Sinus", new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
				factory.getCommand("Sinus").execute(Application.getComponent(DriverManager.class).getCurrentPlotter());
		    }
		});
		
		
	}

}
