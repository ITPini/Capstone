package org.aau.pini.capstone.algorithms;

import java.awt.Color;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
class Brightness extends ImageAlgorithm {
    Brightness() {
        super.name = "Exposure";
        super.minimumFactor = -1;
        super.maximumFactor = 1;
    }
    @Override
    public int calculateRed(Color color) {
        return checkColorValueRange(color.getRed() * (factor + 1));
    }

    @Override
    public int calculateGreen(Color color) {
        return checkColorValueRange(color.getGreen() * (factor + 1));
    }

    @Override
    public int calculateBlue(Color color) {
        return checkColorValueRange(color.getBlue() * (factor + 1));
    }
}
