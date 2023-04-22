package ua.lviv.iot.algo.part1.lab1.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab1.modules.InkjetPrinter;
import ua.lviv.iot.algo.part1.lab1.modules.LaserPrinter;
import ua.lviv.iot.algo.part1.lab1.modules.PhotoPrinter;
import ua.lviv.iot.algo.part1.lab1.modules.TreeDPrinter;

import static org.junit.jupiter.api.Assertions.*;

class PrinterManagerTest {
    private PrinterManager printerManager;

    @BeforeEach
    void setUp() {
        printerManager = new PrinterManager();
        printerManager.addPrinter(new InkjetPrinter("cyan", 9, "magenta", 8, "yellow", 3, "black", 5));
        printerManager.addPrinter(new InkjetPrinter("cyan", 6, "magenta", 7, "yellow", 2, "black", 1));
        printerManager.addPrinter(new LaserPrinter(15, 19));
        printerManager.addPrinter(new LaserPrinter(13, 4));
        printerManager.addPrinter(new PhotoPrinter("laser", 12, true, 20));
        printerManager.addPrinter(new PhotoPrinter("laser", 11, false, 17));
        printerManager.addPrinter(new TreeDPrinter("scaner", 18, false));
        printerManager.addPrinter(new TreeDPrinter("laser", 14, true));
    }


    @Test
    void testFindPrinterWithType() {
        var laserPrinters = printerManager.findPrinterWithType("laser");
        assertEquals(5, laserPrinters.size());
        var inkjetPrinters = printerManager.findPrinterWithType("inkjet");
        assertEquals(8, inkjetPrinters.size());
        var photoPrinters = printerManager.findPrinterWithType("photo");
        assertEquals(8, photoPrinters.size());
        var treeDPrinters = printerManager.findPrinterWithType("3d");
        assertEquals(8, treeDPrinters.size());
    }

    @Test
    void testFindPrinterWithMoreInkLevelThan() {
        PrinterManager printerManager = new PrinterManager();
        InkjetPrinter inkjetPrinter1 = new InkjetPrinter("cyan", 9, "magenta", 8, "yellow", 3, "black", 5);
        InkjetPrinter inkjetPrinter2 = new InkjetPrinter("cyan", 6, "magenta", 7, "yellow", 2, "black", 1);
        LaserPrinter laserPrinter = new LaserPrinter(15, 6);
        printerManager.addPrinter(inkjetPrinter1);
        printerManager.addPrinter(inkjetPrinter2);
        printerManager.addPrinter(laserPrinter);
        assertEquals(2, printerManager.findPrinterWithMoreInkLevelThan(2).size());
        assertFalse(printerManager.findPrinterWithMoreInkLevelThan(2).contains(inkjetPrinter1));
        assertFalse(printerManager.findPrinterWithMoreInkLevelThan(2).contains(inkjetPrinter2));
        assertEquals(2, printerManager.findPrinterWithMoreInkLevelThan(10).size());
        assertFalse(printerManager.findPrinterWithMoreInkLevelThan(10).contains(laserPrinter));
    }
}
