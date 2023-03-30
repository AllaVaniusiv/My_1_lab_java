package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LaserPrinter extends Printer {
    private int tonerPagesCount;
    private int printedPagesCount;

    @Override
    public int getRemainingPagesCount() {
        return tonerPagesCount - printedPagesCount;
    }

    @Override
    public void print(int pagesCount) {
        if (tonerPagesCount >= pagesCount) {
            tonerPagesCount -= pagesCount;
            printedPagesCount += pagesCount;
            System.out.println("Printing" + pagesCount + "pages...");
        } else {
            System.out.println("Not enough toner to print" + pagesCount + "pages...");
        }
    }
}