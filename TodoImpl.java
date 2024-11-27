import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TodoImpl implements Todo {
    Map<String, LocalDate> todos = new HashMap<>();

    @Override
    public void add(String title, LocalDate date) {
        if (todos.containsKey(title)) {
            throw new IllegalArgumentException("이미 존재하는 할 일입니다. 추가할 수 없습니다.");
        }
        todos.put(title, date);
    }

    @Override
    public void printAll() {
        System.out.println(todos.keySet());
    }

    @Override
    public void modify(String title, String newTitle) {
        if (todos.containsKey(title)) {
            todos.put(newTitle, todos.remove(title));
        }
    }

    @Override
    public void modify(String title, LocalDate newDate) {
        if (todos.containsKey(title)) {
            todos.replace(title, todos.get(title), newDate);
        }
    }

    @Override
    public void delete(String title) {
        todos.remove(title);
    }

    @Override
    public void save() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("todos.txt"));
        bufferedWriter.write(todos.toString());
        bufferedWriter.close();
    }

    @Override
    public void load() {

    }

    @Override
    public String toString() {
        return todos + "";
    }
}
