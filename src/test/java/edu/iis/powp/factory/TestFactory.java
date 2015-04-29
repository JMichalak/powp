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
		// TODO Auto-generated method stub
		ApplicationWithDrawer.configureApplication();
		Context context = Application.getComponent(Context.class);
		
		IPlotter plotter = new LineAdapterPlotterDriver(new BasicLine(), "basic");
        context.addDriver("Our simulation", plotter);
        Application.getComponent(DriverManager.class).setCurrentPlotter(plotter);
        context.updateDriverInfo();
		
		CommandManager manager = new CommandManager();
		CommandFactory factory = manager.getFactory();
		IPlotterCommand firstComand = new SetPositionCommand(0, 0);
		IPlotterCommand secondCommmand = new DrawToCommand(100, 200);
		CommandBuilder builder = manager.newCommand(firstComand);
		builder.addCommand(secondCommmand);
		ComplexCommand firstComplex = builder.build();
		factory.addCommand("test", firstComplex, CommandType.circle);
		
		context.addTest("Test", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				factory.getCommand("test").execute(Application.getComponent(DriverManager.class).getCurrentPlotter());
			}
		});
		
		DrawPanelController controller = new DrawPanelController();
        controller.setVisible(true);
        
	}

}
