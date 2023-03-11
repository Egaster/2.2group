package lab2.Task11;

import java.time.LocalDate;

import static java.time.DayOfWeek.*;
import static java.time.DayOfWeek.of;
import static java.time.LocalDate.of;
import static java.lang.System.out;

public class Cal {
    public static void print() {
        printNamesOfWeekDays();
        LocalDate dateNow = of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), 1);
        printDaysOfMonth(dateNow);
    }

    private static void printDaysOfMonth(LocalDate date) {
        int dayValue = date.getDayOfWeek().getValue();
        for (int i = 0; i < dayValue; i++) {
            out.print("     ");
        }
        while (date.getMonthValue() == LocalDate.now().getMonthValue()) {
            if (date.getDayOfWeek() == SUNDAY) {
                out.println();
            }
            out.printf("%5d", date.getDayOfMonth());
            date = date.plusDays(1);
        }
    }

    private static void printNamesOfWeekDays() {
        for (int i = 0; i < 7; i++) {
            out.printf("%5s", of((i + 6) % 7 + 1).toString().substring(0, 3));
        }
        out.println();
    }
}
