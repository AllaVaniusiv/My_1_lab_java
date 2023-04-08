package ua.lviv.iot.algo.part1.lab1;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class TreeDPrinter extends Printer {
    private String type; // тип принтера
    private int printingSpeed; // Швидкість друку
    private boolean isColorPrinter; // Чи є принтер кольоровим
    //  private static PhotoPrinter defaultPhotoPrinter = new PhotoPrinter();

    // Метод для запуску друку
    public int print() {
        System.out.println("Printing...");
        return 0 ;
    }

    // Метод для зміни швидкості друку
    public int setPrintingSpeed(int printingSpeed) {
        this.printingSpeed = printingSpeed;
        return printingSpeed;
    }

    @Override
    public int getRemainingPagesCount() {
        return 0;
    }
}

