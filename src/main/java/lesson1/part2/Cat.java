package lesson1.part2;

import java.io.Serializable;

public class Cat {
    private Color color;
    private CatAttribute catAttribute;

    public static class StaticTestClassCat {}
    class B{}

    private class CatAttribute implements Serializable { //внутренний класс работает с экземплярами, класс статический работает с самим классом
        private String name;
        private int age;

        public CatAttribute(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return  "name='" + name + '\'' +
                    ", age=" + age;
        }
    }

    public Cat(Color color) {
        this(color, "", 0);
    }
    public Cat(Color color, String name, int age) {
        catAttribute = new CatAttribute(name, age);
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
        return String.format("У кота %s цвет %s(%s) и ему(ей) %s лет", catAttribute.getName(), color.getRussianColor(), color.getEnglishColor(), catAttribute.getAge());
    }
}
