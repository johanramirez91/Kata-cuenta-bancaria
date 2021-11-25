package cuentabancaria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatData {

    public LocalDate format(String date) {
        date = date.replace('/', '-');
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
