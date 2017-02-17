import IO.CommandInterpreter;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = "";

        while(!"exit".equals(input = sc.nextLine())){
            try {
                CommandInterpreter.interpretCommand(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
