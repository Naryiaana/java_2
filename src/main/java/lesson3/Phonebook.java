package lesson3;

import java.util.*;

public class Phonebook implements SettingNumber{

    private final Map<String, Set<String>> phonesBySurname;

    public Phonebook() {
        phonesBySurname = new TreeMap<>();
    }

    @Override
    public void add(String surname, String phoneNumber) {
        Set<String> phones = getPhones(surname);
        phones.add(phoneNumber);
    }

    private Set<String> getPhones(String surname) {
        Set<String> phones = phonesBySurname.getOrDefault(surname, new HashSet<>());
        if (phones.isEmpty()) {
            phonesBySurname.put(surname, phones);
        }

        return phones;

    }

    public Set<String> get(String surname) {
        return getPhones(surname);
    }

    public Set<String> getAllSurnames() {
        return phonesBySurname.keySet();
    }
}
