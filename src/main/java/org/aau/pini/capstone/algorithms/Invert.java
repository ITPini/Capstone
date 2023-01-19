package org.aau.pini.capstone.algorithms;

import java.awt.Color;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
class Invert extends ImageAlgorithm {
    Invert() {
        super.name = "Invert";
        super.minimumFactor = 0;
        super.maximumFactor = 1;
    }
    @Override
    public int calculateRed(Color color) {
        return checkColorValueRange((MAX_RGB_VALUE * factor) - color.getRed());
    }

    @Override
    public int calculateGreen(Color color) {
        return checkColorValueRange((MAX_RGB_VALUE * factor) - color.getGreen());
    }

    @Override
    public int calculateBlue(Color color) {
        return checkColorValueRange((MAX_RGB_VALUE * factor) - color.getBlue());
    }

}