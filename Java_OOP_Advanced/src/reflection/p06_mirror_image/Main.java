package reflection.p06_mirror_image;

import reflection.p06_mirror_image.core.Command;
import reflection.p06_mirror_image.core.Engine;
import reflection.p06_mirror_image.core.interfaces.Executable;
import reflection.p06_mirror_image.io.ConsoleReader;
import reflection.p06_mirror_image.io.ConsoleWriter;
import reflection.p06_mirror_image.io.interfaces.Reader;
import reflection.p06_mirror_image.io.interfaces.Writer;
import reflection.p06_mirror_image.core.interfaces.Runnable;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Executable executable = new Command();

        Runnable runnable = new Engine(reader, writer,executable);
        try {
            runnable.run();
        } catch (IOException ex) {
            System.out.println((ex.getMessage()));
        }
    }
}
