package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

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
    //   private static PhotoPrinter defaultPhotoPrinter = new PhotoPrinter();

    public void printPhoto(String photoFileName) {
        System.out.println("Printing photo " + photoFileName + " on " + type +
                " with resolution " + resolution + "dpi" +
                (isColor ? " in color" : " in black and white") + "...");
    }

    public void calibrate() {
        System.out.println("Calibrating " + type + "...");
    }

    @Override
    public int getRemainingPagesCount() {
        return 0;
    }
}



