package org.aau.pini.capstone.algorithms;

import java.awt.Color;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
class GreyscaleAveraging extends ImageAlgorithm {
    GreyscaleAveraging() {
        super.name = "Greyscale Averaging";
        super.minimumFactor = 0;
        super.maximumFactor = 1;
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
