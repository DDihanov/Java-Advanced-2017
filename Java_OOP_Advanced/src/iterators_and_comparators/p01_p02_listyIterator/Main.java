package iterators_and_comparators.p01_p02_listyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        CommandInterpreter commandInterpreter = new CommandInterpreter(sc);

        try{
            commandInterpreter.interpetCommand();
        } catch(IllegalArgumentException e){
            System.out.print(e.getMessage());
        }
    }
}
