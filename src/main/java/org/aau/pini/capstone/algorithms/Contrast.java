package org.aau.pini.capstone.algorithms;

import java.awt.Color;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
class Contrast extends ImageAlgorithm {
    Contrast() {
        super.name = "Contrast";
        super.minimumFactor = -1;
        super.maximumFactor = 1;
    }
    @Override
    public int calculateRed(Color color) {
        return checkColorValueRange((factor + 1) * (color.getRed() - 128) + 128);
    }

    @Override
    public int calculateGreen(Color color) {
        return checkColorValueRange((factor + 1) * (color.getGreen() - 128) + 128);
    }

    @Override
    public int calculateBlue(Color color) {
        return checkColorValueRange((factor + 1) * (color.getBlue() - 128) + 128);
    }

}
