package org.aau.pini.capstone.algorithms;

import java.awt.Color;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
public class Shadow extends ImageAlgorithm {
    Shadow() {
        super.name = "Shadow";
        super.minimumFactor = 0;
        super.maximumFactor = 1;
    }

    @Override
    public int calculateRed(Color color) {
        float nonLinearFactor = ((255 - color.getRed()) / 255.0f) * factor + 1;
        if (color.getRed() < 50 && color.getGreen() < 50 && color.getBlue() < 50) {
            return checkColorValueRange((int) (color.getRed() * (nonLinearFactor)));
        } else {
            return color.getRed();
        }
    }

    @Override
    public int calculateGreen(Color color) {
        float nonLinearFactor = ((255 - color.getGreen()) / 255.0f) * factor + 1;
        if (color.getRed() < 50 && color.getGreen() < 50 && color.getBlue() < 50) {
            return checkColorValueRange((int) (color.getGreen() * (nonLinearFactor)));
        } else {
            return color.getGreen();
        }
    }


    @Override
    public int calculateBlue(Color color) {
        float nonLinearFactor = ((255 - color.getBlue()) / 255.0f) * factor + 1;
        if (color.getRed() < 50 && color.getGreen() < 50 && color.getBlue() < 50) {
            return checkColorValueRange((int) (color.getBlue() * (nonLinearFactor)));
        } else {
            return color.getBlue();
        }
    }
}
