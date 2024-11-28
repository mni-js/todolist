package src;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class TodoService {
    private final Todo todoImpl = new TodoImpl();
    private final Scanner scanner = new Scanner(System.in);

    public void addTodo() {
        while (true) {
            try {
                System.out.print("제목을 입력해주세요(exit: 종료): ");
                String title = scanner.nextLine();
                if (title.equals("exit")) {
                    break;
                }

                System.out.print("날짜를 입력해주세요: ");
                String date = scanner.nextLine();

                DateValidater.validate(date);
                TodoItem item = new TodoItem(title, date);
                todoImpl.add(item);
            } catch (RuntimeException e) {
                System.out.println("다시 입력해주세요.");
            }
        }
    }

    public void displayTodo() {
        todoImpl.displayTodos();
    }

    public void modify() {
        while (true) {
            try {
                System.out.print("변경할 원래 제목을 입력하세요: ");
                String title = scanner.nextLine();

                System.out.print("속성을 입력하세요: ");
                String property = scanner.nextLine();

                System.out.print("새로운 값을 입력하세요: ");
                String newValue = scanner.nextLine();

                todoImpl.modify(title, property, newValue);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("날짜를 제대로 입력해주세요.");
            } catch (RuntimeException e) {
                System.out.println("다시 입력해주세요.");
            }
        }
    }

    public void delete() {
        while (true) {
            try {
                System.out.print("삭제하려는 제목을 입력해주세요(exit: 종료): ");
                String title = scanner.nextLine();

                if (title.equals("exit")) {
                    break;
                }

                todoImpl.delete(title);
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void save() throws IOException {
        todoImpl.save();
    }

    public void load() throws IOException{
        todoImpl.load();
    }

}
