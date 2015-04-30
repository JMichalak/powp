package edu.iis.powp.factory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import edu.iis.powp.command.ComplexCommand;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.SetPositionCommand;

public class CommandFactoryTest {

	@Test
	public void testAddCommand_addedCommandShouldBeAdded() {
		
		final String KEY = "test";
		CommandManager manager = new CommandManager();
		CommandFactory factory = manager.getFactory();
		IPlotterCommand command = new SetPositionCommand(0, 0);
		CommandBuilder builder = manager.newCommand(command);
		factory.addCommand(KEY, builder.build(), CommandType.circle);
		assertThat(factory.commandsSet.containsKey(KEY), is(true));
		
	}

	@Test
	public void testGetCommand() {
		
		final String KEY = "test";
		CommandManager manager = new CommandManager();
		CommandFactory factory = manager.getFactory();
		ComplexCommand command = mock(ComplexCommand.class);
		factory.addCommand(KEY, command, CommandType.circle);
		assertThat(command, is(factory.getCommand(KEY)));
		
	}

}
