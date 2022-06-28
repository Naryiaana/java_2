package lesson2;

import lesson1.part1.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static final String RESOURCES_LIB = "src/main/resources/lib/";

    public static void main(String[] args) {
        /*testException(3);
        testException(0);

        divideNum("50");
        divideNum("e95");
        divideNum("0");*/

      //  System.out.println(testFinally(30, 0));
       // System.out.println(testFinally(3, 0));

       // testScanner();

       // loadConfig();

        /*try {
            readFile("test_data", "txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("КАТАСТРОФА!");
            System.exit(1);
        }

        try {
            readFile("poems", "txt");
        } catch (FileNotFoundException e) {
            System.out.println("Не получилось и ладно");
        }

        System.out.println("END");*/

        danceAnimals();
    }

    private static void testException(int num) {
       // System.out.println(5 / num);
     /*   RuntimeException e = new RuntimeException("Что-то сломалось. ОЙ");
        throw e;*/

       /* if (num == 0) {
            throw new IllegalArgumentException("Аргумент не подходит: " + num);
        }

        System.out.println(5 / num);*/

      // int a = Integer.parseInt(null);


    }

    private static void divideNum(String numStr) {
        int num;
        try {
             num = Integer.parseInt(numStr);
             if (num == 0) {
                 throw new ArithmeticException("Строка содержит число нуль. Так быть не должно!");
             }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            num = 1;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            //logger.warn(e.getMessage);
            //logger.warn(e);
            num = -1;

            try {
                Thread.sleep(-1000);
            } catch (InterruptedException | IllegalArgumentException ex) {
                ex.printStackTrace();
                num = 100;

            }

        }

        System.out.println(100 / num);
    }

    private static int testFinally(int a, int b) {
        try {
            System.out.println("TRY");
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("CATCH");
            e.printStackTrace();
            return 0;
        } finally { //finally всегда исполняется ВСЕГДА!!! НЕ ВАЖНО ТРАЙ КЭТЧ И ТД
            System.out.println("FINALLY");
            return -1;
        }

    }

    private static void testScanner() {
       /* Scanner scanner = null;

        try {
            scanner = new Scanner(System.in);
            int a = scanner.nextInt();
           // scanner.close();
        } catch (InputMismatchException e) {
           e.printStackTrace();
        } finally {
            scanner.close();
        }*/

        try(Scanner scanner = new Scanner(System.in)) {
            int a = scanner.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }


        System.out.println("END");
    }

    private static void loadConfig() {
        File file = new File(RESOURCES_LIB + "test_data.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Не удалось загрузить конфигурации");
            System.exit(1);
        }

        System.out.println(scanner.nextLine());
    }

    private static void readFile(String filename, String extFile) throws FileNotFoundException {
        File file = new File(RESOURCES_LIB + filename + "." + extFile);
        Scanner scanner = new Scanner(file);

        System.out.println(scanner.nextLine());
    }

    private static void danceAnimals() {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Wolf wolf = new Wolf();
        Duck duck = new Duck("Зигзаг");
        Duck duck2 = new Duck("Дональд Дак");
        Cat cat2 = new Cat();

        Animal[] animals = {dog, wolf, cat, duck, cat2, duck2};

        for (int i = 0; i < animals.length ; i++) {
            Animal animal = animals[i];

            //System.out.println(animal.getClass().getName().split("\\.")[2]);
            System.out.println(animal.getClass().getSimpleName() + " проходит фейс-контроль");

            try {
                if (animal instanceof Duck d) {
                    //throw new DuckFoundException(d.getName() + " попыталась проникнуть на вечеринку");
                    throw new DuckFoundException(i, d.getName());
                }
            } catch (DuckFoundException e) {
                e.printStackTrace();
                System.out.println("Произошел инцидент! Незаконное проникновение участника под номером " + (i + 1));
            }
        }
    }

}
