package app.waste_disposal.io;

import app.waste_disposal.io.interfaces.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderImpl implements Reader {
    private BufferedReader bufferedReader;

    public ReaderImpl() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String read() throws IOException {
        return bufferedReader.readLine();
    }
}
