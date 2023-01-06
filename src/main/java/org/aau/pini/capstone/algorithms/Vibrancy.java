/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

package org.aau.pini.capstone.algorithms;

import java.awt.*;

public class Vibrancy extends ImageAlgorithm {
    Vibrancy() {
        this.name = "Vibrancy";
        this.minimumFactor = -1;
        this.maximumFactor = 1;
    }
    @Override
    public int calculateRed(Color color) {
        float r = color.getRed();
        if (color.getRed() > color.getBlue() || color.getRed() > color.getGreen()) {
            r = (factor + 1) * (color.getRed() - 128) + 128;
        }

        return checkColorValueRange(r);
    }

    @Override
    public int calculateGreen(Color color) {
        float g = color.getGreen();
        if (color.getGreen() > color.getRed() || color.getGreen() > color.getBlue()) {
            g = (factor + 1) * (color.getGreen() - 128) + 128;
        }

        return checkColorValueRange(g);
    }

    @Override
    public int calculateBlue(Color color) {
        float b = color.getBlue();
        if (color.getBlue() > color.getRed() || color.getBlue() > color.getGreen()) {
            b = (factor + 1) * (color.getBlue() - 128) + 128;
        }

        return checkColorValueRange(b);
    }
}
