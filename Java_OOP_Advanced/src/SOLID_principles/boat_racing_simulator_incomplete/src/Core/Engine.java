package Core;

import contracts.ICommandHandler;
import contracts.Runnable;
import io.interfaces.Reader;
import io.interfaces.Writer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable{
    private ICommandHandler commandHandler;
    private Reader reader;
    private Writer writer;

    public Engine(ICommandHandler commandHandler, Reader reader, Writer writer)
    {
        this.commandHandler = commandHandler;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() throws IOException {
        while (true)
        {
            String line = this.reader.readLine();
            String name = "";
            List<String> parameters = new ArrayList<>();

            if (line.equals("End")) {
                break;
            }

            List<String> tokens = Arrays.asList(line.split("\\\\"));
            name = tokens.get(0);
            parameters = tokens.stream().skip(1).collect(Collectors.toList());

            try
            {
                String commandResult = this.commandHandler.executeCommand(name, parameters);
                this.writer.writeLine(commandResult);
            }
            catch (Exception ex)
            {
                this.writer.writeLine(ex.getMessage());
            }
        }
    }
}
