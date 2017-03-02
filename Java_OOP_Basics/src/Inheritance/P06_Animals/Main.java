package Inheritance.P06_Animals;

import Inheritance.P06_Animals.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (!"Beast!".equals(input = sc.readLine())) {
            String animalType = input.trim();
            String[] info = sc.readLine().split("\\s+");
            String gender = "";

            try {
                if (info.length < 3) {
                    if(!animalType.toLowerCase().equals("tomcat") && !animalType.toLowerCase().equals("kitten") || info.length<2){
                        throw new IllegalArgumentException("Invalid input!");
                    }
                }else{
                    gender = info[2];
                }
                String name = info[0];
                int age = Integer.parseInt(info[1]);


                switch (animalType.toLowerCase()) {
                    case "cat":
                        Cat cat = new Cat(name, age, gender);
                        System.out.print(cat.toString());
                        break;
                    case "dog":
                        Dog dog = new Dog(name, age, gender);
                        System.out.print(dog.toString());
                        break;
                    case "frog":
                        Frog frog = new Frog(name, age, gender);
                        System.out.print(frog.toString());
                        break;
                    case "kitten":
                        Cat kitten = new Kitten(name, age, "Female");
                        System.out.print(kitten.toString());
                        break;
                    case "tomcat":
                        Cat tomcat = new Tomcat(name, age, "Male");
                        System.out.print(tomcat.toString());
                        break;
                    case"animal":
                        Animal animal = new Animal(name, age, gender);
                        System.out.println(animal.toString());
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid input!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
