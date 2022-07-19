package lesson3;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
     //   testArrayList();
    //    testLinkedList();
//        testSet();
        testMap();
    }

    private static void testArrayList() {
        ArrayList<ArrayList<String>> arrayListDeep = new ArrayList<>(); // не исп-ся двумерные трехмерные коллекции
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add(0,"X");
        arrayList.add(1,"Y");

        arrayList.remove("C"); //удаляет первую C
        arrayList.remove(1);

       /* for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i) + "!");
        }
        не лучший вариант, лучше снизу, где s заменяет i
        */

    /*    for (String s : arrayList) {
            s += "HELLO!"; //исходные данные не изменились, только лишь переменная s
            System.out.println(s + "!!");
        }

        ListIterator<String> iterator = arrayList.listIterator(); //мы не можем создать экземпляр, потому что все запривачено, мы можем только через специальный метод получить итератор
        //при помощи итератора мы можем перебирать ту структуру данных, из которой мы ее вытащили
        while (iterator.hasNext()) { //пока есть следующий элемент, который можно перебирать, мы будем перебирать
            String s = iterator.next(); //в промежуточную переменную из итератора получаем следующий элемент
            System.out.println(s + "!!!"); //редко используется вручную данный итератор, с которым можно идти и назад через previous
        }

       // arrayList.clear();

        arrayList.forEach(s -> System.out.println(s + "!!!!"));
        arrayList.forEach(System.out::println); //если s приходит и без изменений отправляется в другой метод, то можно воспользоваться указателем на метод, но выводятся просто все строки на экран
        arrayList.forEach(s -> {
            s += "!";
            System.out.println(s + "!!!!"); //вот многострочное тело, но все та же самая лямбда
        });

        arrayList.trimToSize(); //подогнать capacity под size*/

        Object[] objects = arrayList.toArray(); // по умолчанию возвращается массив с типом object
        String[] strings = arrayList.toArray(arrayList.toArray(new String[0])); //перегруженный метод с принятием какого-то экземпляра массива

        Collections.addAll(arrayList, "Aaa", "D", "B", "R", "Dd", "ddd", "Bbbb"); //если нужно быстренько создать коллекцию
        Collections.shuffle(arrayList); //перемешивает
       // Collections.sort(arrayList); //по умолчанию сортируется по методу compareTo
     //   Collections.sort(arrayList, (s1, s2) -> s1.length() - s2.length()); //возвращает целое число, если положительное s1 больше если отр s2 больше если 0 то равны друг другу
        Collections.sort(arrayList, Comparator.comparingInt(String::length)); //ссылка на метод через класс экземпляра
        Collections.reverse(arrayList); //переворачивает
        Collections.rotate(arrayList,1); //сдвиг вправо на 1, если -1, то влево на 1
     //   System.out.println(Collections.binarySearch()); не сработает/выполнится как следует так как был реверс и ротейт, работает отсортированном массиве
        System.out.println(Collections.replaceAll(arrayList, "D","!"));

        System.out.println(arrayList);

      //  List<Integer> integers = List.of(1, 2, 3, 4, 5); неизменяемая иммутабельная коллекция
        List<Integer> integers = new ArrayList<>(); //мутабельная коллекция
        Collections.addAll(integers, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15);
        System.out.println(integers.get(1)); //обращается по индексу, не по значению
        System.out.println(integers.stream().filter(e -> e % 2 == 0).collect(Collectors.toList())); //отдается новая коллекция с новыми значениями
        System.out.println(integers.stream().filter(e -> e % 2 == 0).count()); //терминальный метод каунт, подсчитываем количество
        System.out.println(integers.stream()
                .filter(e -> e % 2 == 0) //когда методов много то разделяем так
                .map(n -> {
                n += 10;
                String str = "Четное число из прошлой коллекции: " + n;
                return str;
        }).collect(Collectors.toList())); //map - метод, который позволяет менять приходящий аргумент на любой тип данных и что угодно с ним модифицировать

        LinkedList<Integer> list = new LinkedList<>(integers); //автоматически перегонит из линкдлист в эррэйлист
    }

    private static void testLinkedList() {
        //ЛЛ получает реализацию тогда когда изменение и работа с элементами происходит в самом начале и конце
        //ЭЛ когда все работает в конце массива, но реальные практические тесты показывает что ЭЛ всегда будет эффективнее, потому что работа с массивами намного быстрее и легковеснее, чем работа с множеством экземпляров внутреннего класса
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    private static void testSet() {
        //самое главное - нет дубликатов, но очень энергозатратное, в крайнем случае, только когда нужно элементы всегда были отсортированы
       // Set<Integer> set = new HashSet<>(); //в хэшсете не гарантируем порядок внутри, все хаотично
      //  Set<Integer> set = new LinkedHashSet<>(); //тут числа выводятся в порядке вхождения
        Set<Integer> set = new TreeSet<>(); //отсортиваровка в момент вхождения каждого нового элемента
        Collections.addAll(set,1,2,3,4,5,6,7,8,9,2,1,2,3,4,5,6,3,4,5,6,7,8,9,10,32,12,1,2,3,4,5); //понадобится когда в конечном выходе у нас множество отличающихся друг от друга уникальных значений, но нужно иметь только уникальные возвраты в конечном счете
        System.out.println(set);
    }

    private static void testMap() {
        Map<String, String> map = new HashMap<>(400);
//        Map<String, String> map = new LinkedHashMap<>(400); //будет в порядке в каком мы все вписали
//        Map<String, String> map = new TreeMap<>(); //значение нельзя указывать потому что изначально будет сбалансированное дерево, просто начинается от 0 элементов, будет отсортировано по первой букве по лингво-синтаксическому анализу
        map.put("Russia", "Moscow"); //внесли ключ и значение
        map.put("Russia", "Yakutsk"); //так перезаписывается значение ключа, двух ключей быть не может
        map.put("France", "Paris");
        map.put("Germany", "Berlin");
        map.put("Norway", "Oslo");

        //просто обычное множество Set это та эе самая хэштаблица, но у которой нет значений, только ключи
       /* for (String key : map.keySet()) {
            System.out.printf("Key: %s \t\t value: %s%n", key, map.get(key));
        }*/

        //можно сделать иначе, обратившись к специальному объекту entry. Entry - это специальный экземпляр, в котором хранятся и ключ, и значение. Это внутренний экземпляр нашей мэпы
        /*for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("Key: %s \t\t value: %s%n", entry.getKey(), entry.getValue());
        }*/

        map.forEach((key, value) -> System.out.printf("Key: %s \t\t value: %s%n", key, value)); //метод for-each по тому же самому принципу, он принимает в себя специальный функциональный интерфейс

        System.out.println(map);
    }
}

