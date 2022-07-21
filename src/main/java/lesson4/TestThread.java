package lesson4;

public class TestThread {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        t.setName("New game");
        t.setPriority(10); //1(самый маленький приоритет) -> 10 (самый макс), по дефолту - 5
    //    t.setDaemon(true); //фоновые потоки-демоны, всякие обновления, завершится, если завершим само приложение. НО мы не можем делать демоном уже работающий поток, надо до создания указывать это свойство
        System.out.println(t);
    }
}
