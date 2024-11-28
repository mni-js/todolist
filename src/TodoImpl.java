package src;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TodoImpl implements Todo {
    private Map<String, TodoItem> todos;

    public TodoImpl(Map<String, TodoItem> todos) {
        this.todos = todos;
    }

    public TodoImpl() {
        todos = new HashMap<>();
    }

    @Override
    public void add(TodoItem item) {
        String title = item.getTitle();
        if (todos.containsKey(title)) {
            throw new IllegalArgumentException("이미 존재하는 할 일입니다. 추가할 수 없습니다.");
        }
        todos.put(title, item);
    }

    @Override
    public void displayTodos() {
        System.out.println(todos.keySet());
    }

    @Override
    public void modifyTitle(String title, String newTitle) {
        if (!todos.containsKey(title)) {
            throw new IllegalArgumentException("없는 제목입니다. 다시 입력해주세요.");
        }
        todos.put(newTitle, todos.remove(title));
    }

    @Override
    public void modifyDate(String title, String newDate) {
        if (!todos.containsKey(title)) {
            throw new IllegalArgumentException("없는 제목입니다. 다시 입력해주세요.");
        }
        todos.replace(title, todos.get(title), new TodoItem(title, newDate));
    }

    @Override
    public void delete(String title) {
        if (!todos.containsKey(title)) {
            throw new IllegalArgumentException("없는 제목입니다. 다시 입력해주세요.");
        }
        todos.remove(title);
    }

    @Override
    public void save() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.writeValue(new File("todos.json"), todos);
    }

    public void load() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        todos = objectMapper.readValue(new File("todos.json"), objectMapper.getTypeFactory().constructMapType(Map.class, String.class, TodoItem.class));
    }

    @Override
    public String toString() {
        return "TodoImpl{" +
                "todos=" + todos +
                '}';
    }
}