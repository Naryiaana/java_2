package lesson1.part1;

public class Duck extends Animal implements Flying, Runner, Jumper{
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
