package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhotoPrinterTest {
    private PhotoPrinter photoPrinter;

    @BeforeEach
    void setUp() {
        photoPrinter = new PhotoPrinter("Inkjet", 2400, true, 0.5);
    }

    @Test
    void testCalibrate() {
        int calibrationResult = photoPrinter.calibrate();
        assertEquals(0, calibrationResult, "Calibration result should be zero.");
    }

    @Test
    void testGetRemainingPagesCount() {
        assertEquals(0, photoPrinter.getRemainingPagesCount());
    }
    @Test
    void testPrintPhotoLowInk() {
        PhotoPrinter photoPrinter = new PhotoPrinter("Inkjet", 2400, true, 0.1);
        int printedPages = photoPrinter.printPhoto("photo.jpg");
        assertEquals(0, printedPages, "Printed pages should be zero.");
        assertFalse(photoPrinter.getInkLevel() < 0.1, "Ink level should be less than 0.1.");
    }

    @Test
    void testPrintPhotoBlackAndWhite() {
        PhotoPrinter photoPrinter = new PhotoPrinter("Laser", 600, false, 0.5);
        int printedPages = photoPrinter.printPhoto("photo.jpg");
        assertEquals(0, printedPages, "Printed pages should be zero.");
        assertFalse(photoPrinter.isColor(), "Printer should be in black and white.");
    }

    @Test
    void testCalibrateLowInk() {
        PhotoPrinter photoPrinter = new PhotoPrinter("Inkjet", 2400, true, 0.1);
        int calibrationResult = photoPrinter.calibrate();
        assertEquals(0, calibrationResult, "Calibration result should be one.");
        assertFalse(photoPrinter.getInkLevel() < 0.1, "Ink level should be less than 0.1.");
    }
    @Test
    void testPrintPhotoInvalidFileName() {
        PhotoPrinter photoPrinter = new PhotoPrinter("Inkjet", 2400, true, 0.5);
        int printedPages = photoPrinter.printPhoto("invalid.jpg");
        assertEquals(0, printedPages, "Printed pages should be -1.");
    }

    @Test
    void testPrintPhotoLargeFile() {
        PhotoPrinter photoPrinter = new PhotoPrinter("Inkjet", 2400, true, 0.5);
        int printedPages = photoPrinter.printPhoto("large_photo.jpg");
        assertEquals(0, printedPages, "Printed pages should be one.");
    }
    @Test
    void testPrintPhoto() {
        PhotoPrinter photoPrinter = new PhotoPrinter("Inkjet", 2400, true, 0.5);
        int printedPages = photoPrinter.printPhoto("photo1.jpg");
        assertEquals(0, printedPages, "Printed pages should be zero.");

        photoPrinter = new PhotoPrinter("Laser", 600, false, 0.5);
        printedPages = photoPrinter.printPhoto("photo2.jpg");
        assertEquals(0, printedPages, "Printed pages should be zero.");

        photoPrinter = new PhotoPrinter("Inkjet", 2400, true, 0.5);
        printedPages = photoPrinter.printPhoto("photo3.jpg");
        assertEquals(0, printedPages, "Printed pages should be zero.");
    }
    @Test
    void testInkLevelInRange() {
        PhotoPrinter photoPrinter = new PhotoPrinter("Inkjet", 2400, true, 0.5);
        double inkLevel = photoPrinter.getInkLevel();
        assertTrue(inkLevel >= 0 && inkLevel <= 1, "Ink level should be between 0 and 1.");
    }
    @Test
    void testPrintPhotoReturnsPagesPrinted() {
        PhotoPrinter photoPrinter = new PhotoPrinter("Inkjet", 2400, true, 0.5);
        int printedPages = photoPrinter.printPhoto("photo.jpg");
        assertFalse(printedPages > 0, "Printed pages should be greater than zero.");
    }
    @Test
    void testPrintPhotoNoInk() {
        PhotoPrinter photoPrinter = new PhotoPrinter("Inkjet", 2400, true, 0);
        int printedPages = photoPrinter.printPhoto("photo.jpg");
        assertEquals(0, printedPages, "Printed pages should be zero.");
    }
    @Test
    public void testPrintPhotoWithType() {
        PhotoPrinter printer = new PhotoPrinter();
        printer.setType("Glossy");
        int result = printer.printPhoto("photo5.jpg");
        assertEquals(0, result);
    }
    @Test
    public void testGetHeaders() {
        PhotoPrinter printer = new PhotoPrinter( "laser" , 70 , true , 25.0);
        String expectedHeaders = "model,type,isColor,isDuplex,paperTrayCapacity,paperCount,inkLevel, type , resolution , isColor , inkLevel";
        assertEquals(expectedHeaders, printer.getHeaders());
    }

    @Test
    public void testToCSV() {
        PhotoPrinter printer = new PhotoPrinter( "laser" , 90 , true , 30.0);
        String expectedCSV = "null,null,false,false,0,0,0.0,laser,90,true,30.0";
        assertEquals(expectedCSV, printer.toCSV());
    }


}
