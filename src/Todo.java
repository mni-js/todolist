package src;

import java.io.IOException;

public interface Todo {
    void add(TodoItem item);
    void displayTodos();
    void modify(String title, String property, String newValue);
    void delete(String title);
    void save() throws IOException;
    void load() throws IOException;
}
