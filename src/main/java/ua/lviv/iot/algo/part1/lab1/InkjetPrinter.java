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

    public final void printImage(final String[] colors, final int[] amounts) {
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
    public final int getRemainingPagesCount() {
        int remainingCyanPages = (int) Math.floor(cyanInkLevel
                / REQUIRED_COLOUR_PER_PAGE);
        int remainingMagentaPages = (int) Math.floor(magentaInkLevel
                / REQUIRED_COLOUR_PER_PAGE);
        int remainingYellowPages = (int) Math.floor(yellowInkLevel
                / REQUIRED_COLOUR_PER_PAGE);
        int remainingBlackPages = (int) Math.floor(blackInkLevel
                / REQUIRED_COLOUR_PER_PAGE);
        return Math.min(Math.min(remainingCyanPages, remainingMagentaPages),
                Math.min(remainingYellowPages, remainingBlackPages));
    }

    public String getHeaders() {
        return super.getHeaders() + ", cyanInkType,cyanInkLevel,magentaInkType,magentaInkLevel,yellowInkType ,yellowInkLevel,blackInkType,blackInkLevel";
    }

    public String toCSV() {
        return super.toCSV() + "," + cyanInkType + "," + cyanInkLevel + "," + magentaInkType + "," + magentaInkLevel + "," + yellowInkType + "," + yellowInkLevel + "," + blackInkType + "," + blackInkLevel;

    }
}


