package lesson1.part2;

public class Main {
    public static void main(String[] args) {
       testEnum();
       testAnonClasses();
      // testInnerClasses();
    }

    private static void testEnum() {
        /*Cat cat1 = new Cat(ColorOld.BLACK);
        Cat cat2 = new Cat("Синий");*/
        Cat cat1 = new Cat(Color.BLACK);
        Cat cat2 = new Cat(Color.GREY);

        System.out.println(cat1);
        System.out.println(cat2);
    }

    private static void testAnonClasses() {
    //  SomeOneFileToImplement foo = new Foo();
    //    SomeOneFileToImplement bar = new Bar();
        SomeOneFileToImplement foo = new SomeOneFileToImplement() {
            @Override
            public void action() {
                System.out.println("Привет, мир!");
            }
        };

        SomeOneFileToImplement bar = () -> System.out.println("Привет, Якутск!");

        foo.action();
        bar.action();

        //передали функциональность
        test(foo);
        test(() -> System.out.println("Привет, это сообщение из лямбды!"));

        new Thread(() -> System.out.println("Новый поток начался!")).start(); //сюда вовнутрь нужно передавать функциональность, которую будет исполнять новый поток
    }

    //приняли функциональность
    private static void test(SomeOneFileToImplement o) {
        System.out.println("Действие");
        System.out.println("Действие");
        System.out.println("Действие");
        System.out.println("Действие");
        //приветствие
        o.action();
        System.out.println("Действие");
        System.out.println("Действие");
        System.out.println("Действие");
        System.out.println("Действие");
        System.out.println("=========");
    }
}
