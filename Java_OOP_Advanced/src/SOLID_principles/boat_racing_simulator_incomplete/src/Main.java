import Core.CommandHandler;
import Core.Engine;
import contracts.ICommandHandler;
import io.interfaces.Reader;
import io.interfaces.Writer;
import io.models.ReaderImpl;
import io.models.WriterImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ReaderImpl();
        Writer writer = new WriterImpl();
        ICommandHandler iCommandHandler = new CommandHandler();
        Engine engine = new Engine(iCommandHandler, reader, writer);

        try {
            engine.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
