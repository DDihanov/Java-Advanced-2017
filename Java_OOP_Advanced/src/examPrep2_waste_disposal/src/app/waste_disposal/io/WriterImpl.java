package app.waste_disposal.io;

import app.waste_disposal.io.interfaces.Writer;

public class WriterImpl implements Writer {
    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
