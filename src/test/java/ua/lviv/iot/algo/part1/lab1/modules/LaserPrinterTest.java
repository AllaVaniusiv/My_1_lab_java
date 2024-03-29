package ua.lviv.iot.algo.part1.lab1.modules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LaserPrinterTest {
    private LaserPrinter laserPrinter;

    @BeforeEach
    public void setUp() {
        laserPrinter = new LaserPrinter(100, 0);
    }

    @Test
    public void testGetRemainingPagesCount() {
        assertEquals(100, laserPrinter.getRemainingPagesCount());
        laserPrinter.print(50);
        assertEquals(0, laserPrinter.getRemainingPagesCount());
    }

    @Test
    public void testPrint_withEnoughToner() {
        LaserPrinter printer = new LaserPrinter(10, 0);
        printer.print(5);
        assertEquals(5, printer.getTonerPagesCount());
        assertEquals(5, printer.getPrintedPagesCount());
    }

    @Test
    public void testPrint_withNotEnoughToner() {
        LaserPrinter printer = new LaserPrinter(3, 0);
        printer.print(5);
        assertEquals(3, printer.getTonerPagesCount());
        assertEquals(0, printer.getPrintedPagesCount());
    }

    @Test
    public void testLoadPaper_withNotEnoughSpace() {
        laserPrinter.loadPaper(150);
        assertEquals(0, laserPrinter.getPaperCount());
    }
    @Test
    public void testLoadPaper_withEnoughSpace() {
        laserPrinter.loadPaper(50);
        assertEquals(0, laserPrinter.getPaperCount());
    }

    @Test
    public void testPrint_withZeroPagesCount() {
        LaserPrinter printer = new LaserPrinter(10, 0);
        printer.print(0);
        assertEquals(0, printer.getPrintedPagesCount());
        assertEquals(10, printer.getTonerPagesCount());
    }
    @Test
    public void testLoadToner_withValidToner_shouldLoadAll() {
        int initialToner = laserPrinter.getTonerPagesCount();
        int newToner = 0;
        int result = laserPrinter.loadPaper(newToner);
        assertEquals(0, result);
        assertEquals(initialToner + newToner, laserPrinter.getTonerPagesCount());
    }
    @Test
    public void testPrintNotEnoughPaper() {
        int originalPaperCount = laserPrinter.getPaperCount();
        int pagesToPrint = 20;
        laserPrinter.print(pagesToPrint);
        assertEquals(originalPaperCount, laserPrinter.getPaperCount());
    }
    @Test
    public void testPrint_withExactToner() {
        LaserPrinter printer = new LaserPrinter(5, 0);
        printer.print(5);
        assertEquals(0, printer.getTonerPagesCount());
        assertEquals(5, printer.getPrintedPagesCount());
    }
    @Test
    public void testLoadToner_withExcessiveToner() {
        int initialToner = laserPrinter.getTonerPagesCount();
        int newToner = Integer.MAX_VALUE;
        int result = laserPrinter.loadPaper(newToner);
        assertEquals(initialToner, laserPrinter.getTonerPagesCount());
        assertEquals(0, result);
    }
    @Test
    public void testGetHeaders() {
        LaserPrinter printer = new LaserPrinter( 200 , 70);
        String expectedHeaders = "model,type,isColor,isDuplex,paperTrayCapacity,paperCount,inkLevel, tonerPagesCount , printedPagesCount";
        assertEquals(expectedHeaders, printer.getHeaders());
    }

    @Test
    public void testToCSV() {
        LaserPrinter printer = new LaserPrinter( 100 , 50);
        String expectedCSV = "null,null,false,false,0,0,0.0,100,50";
        assertEquals(expectedCSV, printer.toCSV());
    }

}
