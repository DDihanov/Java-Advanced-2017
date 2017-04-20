package SOLID_principles.p01_logger.io.console;

import SOLID_principles.p01_logger.io.interfaces.Writer;

public class WriterImpl implements Writer {
    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }
}
