package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidater {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static boolean validate(String str) {
        try {
            LocalDate.parse(str, FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("날짜를 'yyyy-MM-dd' 형식으로 입력해주세요.");
        }
    }
}
