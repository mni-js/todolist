package src;

import java.io.IOException;
import java.util.Map;

public interface Todo {
    void add(TodoItem item);
    void displayTodos();
    void modifyTitle(String title, String newTitle);
    void modifyDate(String title, String newDate);
    void delete(String title);
    void save() throws IOException;
    void load() throws IOException;
}
