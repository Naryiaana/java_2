package lesson1.homework;

import java.util.concurrent.ThreadLocalRandom;

public class Cat extends Felis implements Participant{
    private int maxRunningDistance;
    private int maxJumpingDistance;

    public Cat(int maxRunningDistance, int maxJumpingDistance) {
        this.maxRunningDistance = maxRunningDistance;
        this.maxJumpingDistance = maxJumpingDistance;
    }

    @Override
    public void run(Obstacle treadmill, Obstacle wall) {
        int catRuns = ThreadLocalRandom.current().nextInt(0, maxRunningDistance) + 1;
        if(catRuns >= treadmill.getDistance()) {
            System.out.printf("Кошка преодолела препятствие, пробежав на дорожке %d метров и продолжает состязание%n", catRuns);
            jump(wall);
        } else {
            System.out.printf("Кошка не смогла преодолеть препятствие, пробежав %d из нужных %d метров и выбывает из состязания%n", catRuns, treadmill.getDistance());
        }
    }

    @Override
    public void jump(Obstacle wall) {
        int catJumps = ThreadLocalRandom.current().nextInt(0, maxJumpingDistance) + 1;
        if(catJumps >= wall.getDistance()) {
            System.out.printf("Кошка преодолела препятствие, прыгнув %d метров через стену длиною в %d метров. Поздравляем кошку, она прошла состязание!%n", catJumps, wall.getDistance());
        } else {
            System.out.printf("Кошка не смогла преодолеть препятствие, прыгнув %d метров из нужных %d метров, таким образом кошка выбывает из состязания%n", catJumps, wall.getDistance());
        }

    }

}
