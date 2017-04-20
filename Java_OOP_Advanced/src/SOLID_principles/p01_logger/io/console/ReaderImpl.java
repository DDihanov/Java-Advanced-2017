package SOLID_principles.p01_logger.io.console;

import SOLID_principles.p01_logger.io.interfaces.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderImpl implements Reader {
    private BufferedReader bufferedReader;

    public ReaderImpl() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() throws IOException {
        return bufferedReader.readLine();
    }
}
