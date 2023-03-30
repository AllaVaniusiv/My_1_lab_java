package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class InkjetPrinter extends Printer {
    private String cyanInkType;
    private double cyanInkLevel;
    private String magentaInkType;
    private double magentaInkLevel;
    private String yellowInkType;
    private double yellowInkLevel;
    private String blackInkType;
    private double blackInkLevel;
    private static final int REQUIRED_COLOUR_PER_PAGE = 5;

    public void printImage(String[] colors, int[] amounts) {
        boolean hasEnoughInk = true;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i].equalsIgnoreCase("cyan")) {
                if (cyanInkLevel < amounts[i]) {
                    hasEnoughInk = false;
                    break;
                }
            } else if (colors[i].equalsIgnoreCase("magenta")) {
                if (magentaInkLevel < amounts[i]) {
                    hasEnoughInk = false;
                    break;
                }
            } else if (colors[i].equalsIgnoreCase("yellow")) {
                if (yellowInkLevel < amounts[i]) {
                    hasEnoughInk = false;
                    break;
                }
            } else if (colors[i].equalsIgnoreCase("black")) {
                if (blackInkLevel < amounts[i]) {
                    hasEnoughInk = false;
                    break;
                }
            }
        }
        if (hasEnoughInk) {
            for (int i = 0; i < colors.length; i++) {
                if (colors[i].equalsIgnoreCase("cyan")) {
                    cyanInkLevel -= amounts[i];
                } else if (colors[i].equalsIgnoreCase("magenta")) {
                    magentaInkLevel -= amounts[i];
                } else if (colors[i].equalsIgnoreCase("yellow")) {
                    yellowInkLevel -= amounts[i];
                } else if (colors[i].equalsIgnoreCase("black")) {
                    blackInkLevel -= amounts[i];
                }
            }
            System.out.println("Printing image...");
        } else {
            System.out.println("Not enough ink!");
        }
    }

    @Override
    public int getRemainingPagesCount() {
        int remainingCyanPages = (int) Math.floor(cyanInkLevel / REQUIRED_COLOUR_PER_PAGE);
        int remainingMagentaPages = (int) Math.floor(magentaInkLevel / REQUIRED_COLOUR_PER_PAGE);
        int remainingYellowPages = (int) Math.floor(yellowInkLevel / REQUIRED_COLOUR_PER_PAGE);
        int remainingBlackPages = (int) Math.floor(blackInkLevel / REQUIRED_COLOUR_PER_PAGE);
        return Math.min(Math.min(remainingCyanPages, remainingMagentaPages), Math.min(remainingYellowPages, remainingBlackPages));
    }
}
   /* @Override
    public int getRemainingPagesCount() {
        int remainingPages = 0;
        if (isColor) {
            remainingPages = Math.min(cyanLevel / REQUIRED_COLOUR_PER_PAGE, remainingPages);
            remainingPages = Math.min(magentaLevel / REQUIRED_COLOUR_PER_PAGE, remainingPages);
            remainingPages = Math.min(yellowLevel / REQUIRED_COLOUR_PER_PAGE, remainingPages);
        }
        remainingPages = Math.min(blackLevel / REQUIRED_COLOUR_PER_PAGE, remainingPages);
        return remainingPages;
    }
}*/

