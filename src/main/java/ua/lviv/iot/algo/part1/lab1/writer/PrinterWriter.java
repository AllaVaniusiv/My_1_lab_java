package ua.lviv.iot.algo.part1.lab1.writer;

import ua.lviv.iot.algo.part1.lab1.modules.Printer;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrinterWriter {
    public static final String FILE_TO_WRITE = "printers.csv";
    public static final String SORTED_FILE_NAME = "printers_sorted.csv";

    public final void writeToFile(final List<Printer> printers)
            throws IOException {
        File csvOutputFile = new File(FILE_TO_WRITE);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            if (printers.isEmpty()) {
                System.out.println("Список принтерів порожній!");
                return;
            }
            printers.stream()
                    .map(Printer::toCSV)
                    .forEach(pw::println);
        } catch (IOException e) {
            System.out.println("Помилка" + e.getMessage());
        }
        System.out.println("Дані успішно записані у файл");
    }

    public final void sortedWriteToFile(final List<Printer> printers)
            throws IOException {
        Collections.sort(
                printers,
                Comparator.comparing(p -> p.getClass().getName())
        );


        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(SORTED_FILE_NAME))) {
            for (Printer printer : printers) {
                writer.write(printer.toString());
                writer.newLine();
            }
        }
    }

}
