package generics.exercises.p07_p08_p09_custom_list;

import generics.exercises.p07_p08_p09_custom_list.models.ICustomListImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        ICustomListImpl<String> iCustomList = new ICustomListImpl<>();
        CommandInterpreter<String> commandInterpreter = new CommandInterpreter<>(iCustomList);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));


        String input;

        while (!"END".equals(input = sc.readLine())){
            commandInterpreter.interpretCommands(input.split("\\s+"));
        }
    }
}
