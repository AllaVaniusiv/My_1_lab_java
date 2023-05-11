package ua.lviv.iot.algo.part1.lab1.writer;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import ua.lviv.iot.algo.part1.lab1.modules.*;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PrinterWriterTest {
    public static final String FILE_TO_WRITE = "printers.csv";
    public static final String SORTED_FILE = "sorted.csv";
    private final File sortedFile = new File(SORTED_FILE);
    private final File actualFile = new File(FILE_TO_WRITE);
    private final File expectedFile = new File("expected.csv");

    private static List<Printer> printers;

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(FILE_TO_WRITE));
    }

    @Test
    public void writeToFileSuccess() throws IOException {
        PrinterWriter printerWriter = new PrinterWriter();
        List<Printer> printers = new ArrayList<>();
        printers.add(new InkjetPrinter("cyan",
                9, "magenta",
                8, "yellow", 3,
                "black", 5));
        printers.add(new InkjetPrinter("cyan",
                6, "magenta",
                7, "yellow", 2,
                "black", 1));
        printers.add(new LaserPrinter(15,
                19));
        printers.add(new LaserPrinter(13,
                4));
        printers.add(new PhotoPrinter("laser", 12,
                true, 20));
        printers.add(new PhotoPrinter("laser", 11,
                false, 17));
        printers.add(new TreeDPrinter("scanner",
                18, false));
        printers.add(new TreeDPrinter("laser", 14,
                true));

        printerWriter.writeToFile(printers);

        assertTrue(Files.exists(actualFile.toPath()));
        assertEquals(Files.readAllLines(expectedFile.toPath()),
                Files.readAllLines(actualFile.toPath()));

    }

    @Test
    public void testWriteToFileEmptyList() throws IOException {
        PrinterWriter printerWriter = new PrinterWriter();
        List<Printer> printers = new ArrayList<>();

        printerWriter.writeToFile(printers);

        File file = new File(FILE_TO_WRITE);
        assertTrue(file.exists());
    }

    @Test
    public void testFileToWrite() throws IOException {
        FileWriter writer = new FileWriter(FILE_TO_WRITE);
        writer.write("printers");
        writer.close();
        writeToFileSuccess();
    }

    @Test
    public void SortedWritesToFileSuccess() throws IOException {
        PrinterWriter printerWriter = new PrinterWriter();
        List<Printer> printers = new ArrayList<>();
        printers.add(new InkjetPrinter("cyan",
                9, "magenta",
                8, "yellow", 3,
                "black", 5));
        printers.add(new InkjetPrinter("cyan",
                6, "magenta",
                7, "yellow", 2,
                "black", 1));
        printers.add(new LaserPrinter(15,
                19));
        printers.add(new LaserPrinter(13,
                4));
        printers.add(new PhotoPrinter("laser", 12,
                true, 20));
        printers.add(new PhotoPrinter("laser", 11,
                false, 17));
        printers.add(new TreeDPrinter("scanner",
                18, false));
        printers.add(new TreeDPrinter("laser", 14,
                true));


        File csvFile = new File(SORTED_FILE);


        printerWriter.sortedWriteToFile(printers);

        Assertions.assertTrue(csvFile.exists());
        Assertions.assertTrue(csvFile.isFile());
        assertEquals(0, Files.mismatch(actualFile.toPath(), sortedFile.toPath()));
    }

    private int countLines(File file) throws IOException {
        try (var reader = new java.io.BufferedReader(new java.io.FileReader(file))) {
            int lines = 0;
            while (reader.readLine() != null) lines++;
            return lines;
        }
    }

}
