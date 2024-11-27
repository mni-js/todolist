import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
            String stringValue = keyValuePair[1];
            LocalDate value = LocalDate.parse(stringValue, DateTimeFormatter.ISO_LOCAL_DATE);
            todos.put(key, value);
        }
    }

    @Override
    public String toString() {
        return todos + "";
    }
}
