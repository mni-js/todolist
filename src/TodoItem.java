package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TodoItem {
    private String title;
    private LocalDate deadLine;

    public TodoItem(String title, String deadLineStr) {
        DateValidater.validate(deadLineStr);

        this.title = title;
        this.deadLine = LocalDate.parse(deadLineStr, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TodoItem todoItem = (TodoItem) o;
        return Objects.equals(title, todoItem.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "title='" + title + '\'' +
                ", deadLine=" + deadLine +
                '}';
    }
}
