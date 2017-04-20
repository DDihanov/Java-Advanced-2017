package io.models;

import io.interfaces.Writer;

public class WriterImpl implements Writer {
    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }
}
