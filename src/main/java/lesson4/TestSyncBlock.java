package lesson4;

import lesson1.homework.Obstacle;

import java.util.Date;

public class TestSyncBlock {

    public static final int STEPS = 10;
    public static final int DELAY = 500;
    private static final Object o = Math.class; //new Date(); монитор любого класса

    public static void main(String[] args) {
        TestSyncBlock tsb1 = new TestSyncBlock();
        TestSyncBlock tsb2 = new TestSyncBlock();

        new Thread(() -> tsb1.methodA(), "A").start();
        new Thread(() -> tsb1.methodB(), "B").start();
    }

    private void methodA() {
        synchronized (o) {
            System.out.println("Start A");
            for (int i = 0; i < STEPS; i++) {
                System.out.print(Thread.currentThread().getName() + " : " + i + " ");
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println();
            System.out.println("End A");
        }
    }

    private void methodB() {
        synchronized (o) {
            System.out.println("Start B");
            for (int i = 0; i < STEPS; i++) {
                System.out.print(Thread.currentThread().getName() + " : " + i + " ");
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println();
            System.out.println("End B");
        }
    }
}
