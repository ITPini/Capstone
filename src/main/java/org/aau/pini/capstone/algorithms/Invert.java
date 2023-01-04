package org.aau.pini.capstone.algorithms;

import java.awt.*;

public class Invert extends ImageAlgorithm {
    @Override
    public int calculateRed(Color color) {
        return checkColorValueRange((255 * factor) - color.getRed());
    }

    @Override
    public int calculateGreen(Color color) {
        return checkColorValueRange((255 * factor) - color.getGreen());
    }

    @Override
    public int calculateBlue(Color color) {
        return checkColorValueRange((255 * factor) - color.getBlue());
    }

}