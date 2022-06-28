package lesson1.homework;

public class Main {
    public static void main(String[] args) {

        Participant cat = new Cat(550,7);
        Participant human = new Human(500,5);
        Participant robot = new Robot(600,10);

        Obstacle wall = new Wall(5);
        Obstacle treadmill = new Treadmill(500);

        Participant[] participants = {cat, human, robot};
        Obstacle[] obstacles = {wall, treadmill};

        System.out.println("Начинаем состязание");

            for (Participant participant : participants) {
                participant.run(treadmill, wall);
            }


        System.out.println("Состязание окончено");
    }
}