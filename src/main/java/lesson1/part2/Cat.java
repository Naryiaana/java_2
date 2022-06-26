package lesson1.part2;

public class Cat {
    private Color color;

    static class A {}
    class B{}

    public Cat(Color color) {
        this.color = color;
    }

    private void foo(int a, int b) { //bar baz метод-локальные классы
        class Calculate {
            public int plus(int a, int b) {
                return a + b;
            }
            public int subtract(int a, int b) {
                return a - b;
            }
        }
        Calculate calculate = new Calculate();
        System.out.println(calculate.plus(a,b));
        System.out.println(calculate.subtract(a,b));
    }

    @Override
    public String toString() {
        return String.format("У кота цвет %s(%s)", color.getRussianColor(), color.getEnglishColor());
    }
}
