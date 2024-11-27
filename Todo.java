import java.time.LocalDate;

public interface Todo {
    void add(String title, LocalDate date);
    void printAll();
    void modify(String title, String newTitle);
    void modify(String title, LocalDate newDate);
    void delete(String title);
    void save();
    void load();
}
