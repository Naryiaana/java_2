package lesson3;

import java.util.Set;

public interface SettingNumber {
    void add(String surname, String phoneNumber);

    Set<String> get(String surname);

    Set<String> getAllSurnames();
}
