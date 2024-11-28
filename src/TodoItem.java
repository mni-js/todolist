package src;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TodoItem {
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadLine;

    public TodoItem(String title, String deadLineStr) {
        this.title = title;
        this.deadLine = LocalDate.parse(deadLineStr, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public TodoItem() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDeadLine(String deadLine) {
        DateValidater.validate(deadLine);
        this.deadLine = LocalDate.parse(deadLine, DateTimeFormatter.ISO_LOCAL_DATE);
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
