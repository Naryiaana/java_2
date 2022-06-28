package lesson1.part1;

public class Duck extends Animal implements Flying, Runner, Jumper{

    private String name;

    public String getName() {
        return name;
    }

    public Duck() {
    }

    public Duck(String name) {
        this.name = name;
    }

    @Override
    public void fly() {
        System.out.println("Утка полетела");
    }

    @Override
    public void jump() {

    }

    @Override
    public void run() {

    }
}
