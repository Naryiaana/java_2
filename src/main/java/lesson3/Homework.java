package lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class Homework {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, "Hello", "Hello", "HELLO", "World", "Dear", "World", "Hi", "My", "Name", "Is", "Nariana", "What", "Time", "My", "Love", "Is", "George", "Not", "Found", "Love", "LOVE", "GEORGE", "George", "Nariana", "NARIANA");

        System.out.println(arrayList.stream().distinct().collect(Collectors.toList()));
        System.out.println(arrayList.stream().distinct().count());
    }

    private static void task2() {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Ivanova", "911");
        phonebook.add("Ivanova", "6705493");
        phonebook.add("Petrov", "1234567");
        phonebook.add("Ponomareva", "9112505");
        phonebook.add("Ponomareva", "819112505");
        phonebook.add("Sidorov", "15161718");
        phonebook.add("Davidson", "967911");

        Set<String> allSurnames = phonebook.getAllSurnames();
        for (String surname : allSurnames) {
            Set<String> phones = phonebook.get(surname);
            System.out.printf("%s: %s%n", surname, phones);

        }
    }
}
