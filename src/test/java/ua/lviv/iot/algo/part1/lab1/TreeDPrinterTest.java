package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeDPrinterTest {
    private TreeDPrinter printer;

    @BeforeEach
    void setUp() {
        printer = new TreeDPrinter("laser", 250,true);
    }

   @Test
   public void testPrint() {
       assertEquals(0, printer.print());
   }

  @Test
    void testSetPrintingSpeed() {
        printer.setPrintingSpeed1(10);
        assertEquals(10, printer.getPrintingSpeed());
    }
@Test
public void testSetPrintingSpeed1() {
    TreeDPrinter printer = new TreeDPrinter();

    // Тест 1: перевіряємо, що швидкість друку встановлена коректно
    printer.setPrintingSpeed1(10);
    assertEquals(10, printer.getPrintingSpeed());

    // Тест 2: перевіряємо, що швидкість друку можна встановити в нуль
    printer.setPrintingSpeed1(0);
    assertEquals(0, printer.getPrintingSpeed());
    // Тест 3: перевіряємо, що швидкість друку можна встановити в від'ємне число
    printer.setPrintingSpeed1(-5);
    assertEquals(-5, printer.getPrintingSpeed());

    // Тест 4: перевіряємо, що швидкість друку можна змінити після встановлення
    printer.setPrintingSpeed1(30);
    assertEquals(30, printer.getPrintingSpeed());

    // Тест 5: перевіряємо, що метод не повертає значення
    int result = printer.setPrintingSpeed1(15);
    assertEquals(15, result);
}


    @Test
    void testGetRemainingPagesCount() {
        assertEquals(0, printer.getRemainingPagesCount());
    }
    @Test
    void testPrintBlackAndWhite() {
        printer.setColorPrinter(false);
        assertEquals(0, printer.print());
    }

    @Test
    void testPrintColor() {
        assertEquals(false, printer.isColor());
    }

    @Test
    void testGetPrintingSpeedInPagesPerMinute() {
        assertEquals(250, printer.getPrintingSpeed());
    }
    @Test
    public void testGetHeaders() {
        TreeDPrinter printer = new TreeDPrinter( "inkjet" ,150,true);
        String expectedHeaders = "model,type,isColor,isDuplex,paperTrayCapacity,paperCount,inkLevel,type,printingSpeed,isColorPrinter";
        assertEquals(expectedHeaders, printer.getHeaders());
    }

    @Test
    public void testToCSV() {
        TreeDPrinter printer = new TreeDPrinter( "inkjet" , 200 , true);
        String expectedCSV = "null,null,false,false,0,0,0.0,inkjet,200,true";
        assertEquals(expectedCSV, printer.toCSV());
    }

}
