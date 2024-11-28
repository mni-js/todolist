package src;

import java.io.IOException;
import java.time.LocalDate;

public interface Todo {
    void add(TodoItem item);
    void printAll();
    void modify(String title, String newTitle);
    void modify(String title, LocalDate newDate);
    void delete(String title);
    void save() throws IOException;
    void load() throws IOException;
}
