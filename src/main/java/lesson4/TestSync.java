package lesson4;

public class TestSync {

    public static final int STEPS = 100000;
    public static  int DELAY = 500;
    public static  int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        TestSync testSync = new TestSync();
        TestSync testSync2 = new TestSync(); //будут разные мониторы, поэтому будут не синхронизированы

        var t1 = new Thread(() -> testSync.incCounter());
        var t2 = new Thread(() -> testSync.deCounter());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(TestSync.counter);
    }

    public synchronized void incCounter() {
        for (int i = 0; i < STEPS; i++) {
            counter++;
        }
    }

    public synchronized void deCounter() {
        for (int i = 0; i < STEPS; i++) {
            counter--;
        }
    }
}
