package org.aau.pini.capstone.algorithms;

import java.awt.Color;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
class Greyscale extends ImageAlgorithm {
    Greyscale() {
        super.name = "Greyscale";
        super.minimumFactor = -1;
        super.maximumFactor = 1;
    }
    @Override
    public int calculateRed(Color color) {
        return checkColorValueRange((color.getRed() + color.getGreen() * factor + color.getBlue() * factor) / (2 * factor + 1));
    }

    @Override
    public int calculateGreen(Color color) {
        return checkColorValueRange((color.getRed() * factor + color.getGreen() + color.getBlue() * factor) / (2 * factor + 1));
    }

    @Override
    public int calculateBlue(Color color) {
        return checkColorValueRange((color.getRed() * factor + color.getGreen() * factor + color.getBlue()) / (2 * factor + 1));
    }
}
