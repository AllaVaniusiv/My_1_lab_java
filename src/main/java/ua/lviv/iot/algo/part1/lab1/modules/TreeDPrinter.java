package ua.lviv.iot.algo.part1.lab1.modules;

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
    private String type;
    private int printingSpeed;
    private boolean isColorPrinter;

    public final int print() {
        System.out.println("Printing...");
        return 0;
    }


    public final int setPrintingSpeed1(final int printingSpeed) {
        this.printingSpeed = printingSpeed;
        return printingSpeed;
    }

    @Override
    public final int getRemainingPagesCount() {
        return 0;
    }

    public final String getHeaders() {
        return super.getHeaders() + ",type,printingSpeed,isColorPrinter";
    }

    public final String toCSV() {
        return super.toCSV() + "," + type + "," + printingSpeed
                + "," + isColorPrinter;

    }
}
