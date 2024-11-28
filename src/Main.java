package src;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TodoService todoService = new TodoService();
        todoService.addTodo();

        todoService.displayTodo();

        todoService.delete();
        todoService.modify();

        todoService.save();

        todoService.load();
        todoService.displayTodo();
    }
}
