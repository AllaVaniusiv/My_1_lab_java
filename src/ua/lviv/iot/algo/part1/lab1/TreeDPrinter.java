package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TreeDPrinter extends Printer {
    private String type; // тип принтера
    private int printingSpeed; // Швидкість друку
    private boolean isColorPrinter; // Чи є принтер кольоровим
    //  private static PhotoPrinter defaultPhotoPrinter = new PhotoPrinter();

    // Метод для запуску друку
    public void print() {
        System.out.println("Printing...");
    }

    // Метод для зміни швидкості друку
    public void setPrintingSpeed(int printingSpeed) {
        this.printingSpeed = printingSpeed;
    }

    @Override
    public int getRemainingPagesCount() {
        return 0;
    }
}

