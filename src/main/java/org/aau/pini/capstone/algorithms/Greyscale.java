package org.aau.pini.capstone.algorithms;

import java.awt.*;

public class Greyscale extends ImageAlgorithm {
    @Override
    public int calculateRed(Color color) {
        return checkColorValueRange(color.getRed() + color.getGreen() + color.getBlue() * factor / 3);
    }

    @Override
    public int calculateGreen(Color color) {
        return checkColorValueRange(color.getRed() + color.getGreen() + color.getBlue() * factor / 3);
    }

    @Override
    public int calculateBlue(Color color) {
        return checkColorValueRange(color.getRed() + color.getGreen() + color.getBlue() * factor / 3);
    }
}
