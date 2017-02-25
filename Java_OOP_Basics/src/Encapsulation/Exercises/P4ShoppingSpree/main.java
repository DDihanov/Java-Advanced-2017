package Encapsulation.Exercises.P4ShoppingSpree;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Person> people = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();

        try {
            addPeople(sc, people);

            addProducts(sc, products);

            String command;
            while (!"END".equals(command = sc.nextLine())) {
                String personName = command.split("\\s+")[0];
                String product = command.split("\\s+")[1];

                for (Person person :
                        people) {
                    if (person.getName().equals(personName)) {
                        person.addProduct(products.stream().filter(p -> p.getName().equals(product)).findFirst().get());
                    }
                }
            }

            people.stream().forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void addProducts(Scanner sc, ArrayList<Product> products) {
        String[] productInfo = sc.nextLine().split(";");
        for (int i = 0; i < productInfo.length; i++) {
                String name = productInfo[i].split("=")[0];
                int cost = Integer.parseInt(productInfo[i].split("=")[1]);
                Product product = new Product(name, cost);
                products.add(product);
        }
    }

    private static void addPeople(Scanner sc, ArrayList<Person> people) {
        String[] peopleInfo = sc.nextLine().split(";");
        for (int i = 0; i < peopleInfo.length; i++) {
                String name = peopleInfo[i].split("=")[0];
                int money = Integer.parseInt(peopleInfo[i].split("=")[1]);
                Person person = new Person(name, money);
                people.add(person);
        }
    }
}
