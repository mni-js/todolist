package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidater {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static boolean validate(String str) throws DateTimeParseException {
        LocalDate.parse(str, FORMATTER);
        return true;
    }
}
