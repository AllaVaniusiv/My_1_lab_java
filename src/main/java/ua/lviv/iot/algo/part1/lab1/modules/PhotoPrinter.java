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
public class PhotoPrinter extends Printer {
    private String type;
    private int resolution;
    private boolean isColor;
    private double inkLevel;

    public final int printPhoto(final String photoFileName) {
        System.out.println("Printing photo " + photoFileName + " on " + type
                + " with resolution " + resolution + "dpi"
                + (isColor ? " in color" : " in black and white") + "...");
        return 0;
    }

    public final int calibrate() {
        System.out.println("Calibrating " + type + "...");
        return 0;
    }

    @Override
    public final int getRemainingPagesCount() {
        return 0;
    }

    public final String getHeaders() {
        return super.getHeaders() + ", type , resolution , isColor , inkLevel";
    }

    public final String toCSV() {
        return super.toCSV() + "," + type + "," + resolution + "," + isColor
                + "," + inkLevel;

    }
}
