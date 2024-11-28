package src;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException {
        Todo todo = new TodoImpl();
        TodoItem item = new TodoItem("안녕", "2023-08-23");
        todo.add(item);
        System.out.println(todo);
        TodoItem item2 = new TodoItem("안녕", "2021-08-23");
        todo.add(item2);
        System.out.println(item2);


//        todo.add("운동하기", LocalDate.of(2024, 12, 11));
//        todo.add("운동하기2", LocalDate.of(2014, 12, 11));
//        System.out.println(todo);
//        todo.printAll();
//
//        todo.modify("운동하기2", "저녁먹기");
//        System.out.println("todo = " + todo);
//
//        todo.modify("운동하기", LocalDate.of(2025, 1, 5));
//        System.out.println("todo = " + todo);

//        todo.delete("운동하기");
//        System.out.println(todo);

//        todo.save();

//        todo.load();
//        System.out.println(todo);
    }
}
