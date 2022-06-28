package lesson1.homework;

import java.util.concurrent.ThreadLocalRandom;

public class Human extends Ape implements Participant{
    private int maxRunningDistance;
    private int maxJumpingDistance;

    public Human(int maxRunningDistance, int maxJumpingDistance) {
        this.maxRunningDistance = maxRunningDistance;
        this.maxJumpingDistance = maxJumpingDistance;
    }

    @Override
    public void run(Obstacle treadmill, Obstacle wall) {
        int humanRuns = ThreadLocalRandom.current().nextInt(0, maxRunningDistance) + 1;
        if(humanRuns >= treadmill.getDistance()) {
            System.out.printf("Человек преодолел препятствие, пробежав на дорожке %d метров и продолжает состязание%n", humanRuns);
            jump(wall);
        } else {
            System.out.printf("Человек не смог преодолеть препятствие, пробежав %d из нужных %d метров и выбывает из состязания%n", humanRuns, treadmill.getDistance());
        }
    }

    @Override
    public void jump(Obstacle wall) {
        int humanJumps = ThreadLocalRandom.current().nextInt(0, maxJumpingDistance) + 1;
        if(humanJumps >= wall.getDistance()) {
            System.out.printf("Человек преодолел препятствие, прыгнув %d метров через стену длиною в %d метров. Поздравляем человека, он прошел состязание!%n", humanJumps, wall.getDistance());
        } else {
            System.out.printf("Человек не смог преодолеть препятствие, прыгнув %d метров из нужных %d метров, таким образом человек выбывает из состязания%n", humanJumps, wall.getDistance());
        }

    }
}
