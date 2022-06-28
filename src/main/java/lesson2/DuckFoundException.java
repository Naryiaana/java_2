package lesson2;

public class DuckFoundException extends Exception{
    public DuckFoundException(int index, String name) {
        super(String.format("Утка %s под номером %s попыталась прорваться на вечеринку", name, index + 1));
    }
}
