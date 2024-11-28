package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoImpl implements Todo {
    Map<String, TodoItem> todos = new HashMap<>();

    @Override
    public void add(TodoItem item) {
        String title = item.getTitle();
        if (todos.containsKey(title)) {
            throw new IllegalArgumentException("이미 존재하는 할 일입니다. 추가할 수 없습니다.");
        }
        todos.put(title, item);
    }

    @Override
    public void printAll() {
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
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("todos.txt"));
        for (String s : todos.keySet()) {
            String savedLine = s + "=" + todos.get(s);
            bufferedWriter.write(savedLine);
            bufferedWriter.write("\n");
        }
        bufferedWriter.close();
    }

    @Override
    public void load() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("todos.txt"));
        String br;
        while ((br = bufferedReader.readLine()) != null) {
            String[] keyValuePair = br.split("=");
            String key = keyValuePair[0];
            String title = keyValuePair[2].split(",")[0];
            String date = keyValuePair[3].split("}")[0];
            TodoItem item = new TodoItem(title, date);

            todos.put(key, item);
        }
    }

    @Override
    public String toString() {
        return "TodoImpl{" +
                "todos=" + todos +
                '}';
    }
}