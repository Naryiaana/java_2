package lesson2;

import java.util.Random;

public class TestRandomString {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
           /* int num;
            do {
                num = random.nextInt(65,123);
            } while (num >= 91 && num <= 96);
            sb.append((char) num);*/

            int num = random.nextInt(65,90);
            String letter = String.valueOf((char) num);
            sb.append(random.nextBoolean() ? letter : letter.toLowerCase());
        }

        System.out.println(sb);
    }
}
