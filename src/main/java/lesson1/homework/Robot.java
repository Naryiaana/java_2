package lesson1.homework;

import java.util.concurrent.ThreadLocalRandom;

public class Robot extends Machine implements Participant{
    private int maxRunningDistance;
    private int maxJumpingDistance;

    public Robot(int maxRunningDistance, int maxJumpingDistance) {
        this.maxRunningDistance = maxRunningDistance;
        this.maxJumpingDistance = maxJumpingDistance;
    }

    @Override
    public void run(Obstacle treadmill, Obstacle wall) {
        int robotRuns = ThreadLocalRandom.current().nextInt(0, maxRunningDistance) + 1;
        if(robotRuns >= treadmill.getDistance()) {
            System.out.printf("Робот преодолел препятствие, пробежав на дорожке %d метров и продолжает состязание%n", robotRuns);
            jump(wall);
        } else {
            System.out.printf("Робот не смог преодолеть препятствие, пробежав %d из нужных %d метров и выбывает из состязания%n", robotRuns, treadmill.getDistance());
        }
    }

    @Override
    public void jump(Obstacle wall) {
        int robotJumps = ThreadLocalRandom.current().nextInt(0, maxJumpingDistance) + 1;
        if(robotJumps >= wall.getDistance()) {
            System.out.printf("Робот преодолел препятствие, прыгнув %d метров через стену длиною в %d метров. Поздравляем робота, он прошел состязание!%n", robotJumps, wall.getDistance());
        } else {
            System.out.printf("Робот не смог преодолеть препятствие, прыгнув %d метров из нужных %d метров, таким образом робот выбывает из состязания%n", robotJumps, wall.getDistance());
        }

    }
}
