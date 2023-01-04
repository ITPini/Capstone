package org.aau.pini.capstone.algorithms;

import java.awt.*;

public class ExposureV2 extends ImageAlgorithm{

    @Override
    public int calculateRed(Color color) {
        return checkColorValueRange(color.getRed() * (float) (Math.pow(2, factor)));
    }

    @Override
    public int calculateGreen(Color color) {
        return checkColorValueRange(color.getGreen() * (float) (Math.pow(2, factor)));
    }

    @Override
    public int calculateBlue(Color color) {
        return checkColorValueRange(color.getBlue() * (float) (Math.pow(2, factor)));
    }
}
