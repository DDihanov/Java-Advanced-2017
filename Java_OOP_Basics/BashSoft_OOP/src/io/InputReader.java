package io;

import staticData.SessionData;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputReader {
    private CommandInterpreter interpreter;

    public InputReader(CommandInterpreter interpreter) {
        this.interpreter = interpreter;
    }

    private final String END_COMMAND = "quit";

    public void readCommands() throws Exception {
        OutputWriter.writeMessage(String.format("%s > ", SessionData.currentPath));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();

        while (!input.equals(this.END_COMMAND)) {
            this.interpreter.interpretCommand(input);
            OutputWriter.writeMessage(String.format("%s > ", SessionData.currentPath));

            input = reader.readLine().trim();
        }

        for (Thread thread : SessionData.threadPool) {
            thread.join();
        }
    }
}