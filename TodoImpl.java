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

    }

    @Override
    public void modify(String title, String newTitle) {

    }

    @Override
    public void modify(String title, LocalDate newDate) {

    }

    @Override
    public void save() {

    }

    @Override
    public void load() {

    }

    @Override
    public String toString() {
        return "TodoImpl{" +
                "todos=" + todos +
                '}';
    }
}
