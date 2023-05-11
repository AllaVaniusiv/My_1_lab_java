package ua.lviv.iot.algo.part1.lab1.modules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {

    private Printer printer;

    @BeforeEach
    void setUp() {
        printer = new LaserPrinter(250, 50);
    }

    @Test
    void print_shouldPrintPages_whenEnoughPaperInTray() {
        printer.loadPaper(50);
        printer.print(20);
        assertEquals(160, printer.getRemainingPagesCount());
    }

    @Test
    void print_shouldNotPrintPages_whenNotEnoughPaperInTray() {
        printer.print(10);
        assertEquals(180, printer.getRemainingPagesCount());
    }

    @Test
    void loadPaper_shouldIncreasePaperCount() {
        printer.loadPaper(50);
        assertEquals(200, printer.getRemainingPagesCount());
    }

    @Test
    void loadPaper_shouldNotExceedPaperTrayCapacity() {
        printer.loadPaper(300);
        assertEquals(200, printer.getRemainingPagesCount());
    }


    @Test
    public void testPrintNotEnoughPaper() {
        printer.print(60);
        assertEquals(80, printer.getRemainingPagesCount());
    }
    @Test
    public void testLoadPaperOverCapacity() {
        printer.loadPaper(70);
        assertEquals(200, printer.getRemainingPagesCount());
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
    public void testGetRemainingPagesCount() {
        assertEquals(200, printer.getRemainingPagesCount());
        printer.print(50);
        assertEquals(100, printer.getRemainingPagesCount());
    }
    @Test
    void loadPaper_shouldNotExceedPaperTrayCapacity_whenLoadedMoreThanCapacity() {
        printer.loadPaper(300);
        assertEquals(200, printer.getRemainingPagesCount());
    }

    @Test
    void getRemainingPagesCount_shouldReturnCorrectValue_whenNoPaperLoaded() {
        assertEquals(200, printer.getRemainingPagesCount());
    }

    @Test
    void getRemainingPagesCount_shouldReturnCorrectValue_whenSomePagesPrinted() {
        printer.loadPaper(100);
        printer.print(50);
        assertEquals(100, printer.getRemainingPagesCount());
    }

    @Test
    void getRemainingPagesCount_shouldReturnCorrectValue_whenTrayIsFull() {
        printer.loadPaper(200);
        assertEquals(200, printer.getRemainingPagesCount());
    }
    @Test
    void settersAndGetters_shouldWorkCorrectly() {
        printer.setModel("HP LaserJet");
        printer.setType("Laser");
        printer.setColor(true);
        printer.setDuplex(true);
        printer.setPaperTrayCapacity(500);
        printer.setPaperCount(300);
        printer.setInkLevel(0.5);
        assertEquals("HP LaserJet", printer.getModel());
        assertEquals("Laser", printer.getType());
        assertTrue(printer.isColor());
        assertTrue(printer.isDuplex());
        assertEquals(500, printer.getPaperTrayCapacity());
        assertEquals(300, printer.getPaperCount());
        assertEquals(0.5, printer.getInkLevel());
    }
    @Test
    void print_shouldNotPrint_whenPagesIsZero() {
        printer.loadPaper(50);
        printer.print(0);
        assertEquals(200, printer.getRemainingPagesCount());
    }

    @Test
    void print_shouldNotPrint_whenPagesIsNegative() {
        printer.loadPaper(50);
        printer.print(-5);
        assertEquals(210, printer.getRemainingPagesCount());
    }
   @Test
   public void testGetHeaders() {
       Printer printer = new LaserPrinter(100, 50);
       String expectedHeaders = "model,type,isColor,isDuplex,paperTrayCapacity,paperCount,inkLevel, tonerPagesCount , printedPagesCount";
       String actualHeaders = printer.getHeaders();
       assertEquals(expectedHeaders, actualHeaders);
   }

    @Test
    public void testToCSV() {
        Printer printer = new LaserPrinter(150, 55);
        String expectedCSV = "null,null,false,false,0,0,0.0,150,55";
        String actualCSV = printer.toCSV();
        assertEquals(expectedCSV, actualCSV);
    }

}
