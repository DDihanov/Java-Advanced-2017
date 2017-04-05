package reflection.p03_04_05_barracks.contracts;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
