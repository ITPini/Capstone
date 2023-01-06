/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

package org.aau.pini.capstone.algorithms;

import java.awt.*;

public class GreyscaleAveraging extends ImageAlgorithm {
    GreyscaleAveraging() {
        this.name = "Greyscale Averaging";
        this.minimumFactor = 0;
        this.maximumFactor = 1;
    }
    @Override
    public int calculateRed(Color color) {
        return checkColorValueRange(((color.getRed() + color.getGreen() + color.getBlue()) * factor) / 3);
    }

    @Override
    public int calculateGreen(Color color) {
        return checkColorValueRange(((color.getRed() + color.getGreen() + color.getBlue()) * factor) / 3);
    }

    @Override
    public int calculateBlue(Color color) {
        return checkColorValueRange(((color.getRed() + color.getGreen() + color.getBlue()) * factor) / 3);
    }
}
