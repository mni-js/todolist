package src;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Todo todo = new TodoImpl();
        TodoItem item1 = new TodoItem("안녕1", "2023-08-23");
        TodoItem item2 = new TodoItem("안녕2", "2021-08-23");
        TodoItem item3 = new TodoItem("안녕3", "2019-06-05");
        todo.add(item1);
        todo.add(item2);
        todo.add(item3);

        todo.displayTodos();

        todo.modifyTitle("안녕1", "저녁먹기");
        System.out.println(todo);

        todo.modifyDate("안녕2", "2022-11-11");
        System.out.println(todo);

        todo.delete("안녕2");
        System.out.println(todo);

        todo.save();

        Todo newTodos = new TodoImpl();
        newTodos.load();
        System.out.println("newTodos = " + newTodos);
    }
}
