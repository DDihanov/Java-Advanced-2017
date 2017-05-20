package hell.io;

import hell.interfaces.OutputWriter;

/**
 * Created by Austin on 23/04/2017.
 */
public class OutputWriterImpl implements OutputWriter {
    public OutputWriterImpl() {
    }

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void writeLine(String format, Object... params) {
        String output = String.format(format, params);
        System.out.println(output);
    }
}
