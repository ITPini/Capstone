package org.aau.pini.capstone.algorithms;

import java.awt.Color;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
public class Colorizer extends ImageAlgorithm {
    public Colorizer() {
        super.name = "Colorizer";
        super.minimumFactor = 0;
        super.maximumFactor = 1;
    }

    @Override
    public int calculateRed(Color color) {
        if (color.getRed() >= color.getGreen() && color.getRed() >= color.getBlue()){
            return (int) (MAX_RGB_VALUE * factor);
        } else {
            return MIN_RGB_VALUE;
        }
    }

    @Override
    public int calculateGreen(Color color) {
        if (color.getGreen() >= color.getRed() && color.getGreen() >= color.getBlue()){
            return (int) (MAX_RGB_VALUE * factor);
        } else {
            return MIN_RGB_VALUE;
        }
    }

    @Override
    public int calculateBlue(Color color) {
        if (color.getBlue() >= color.getRed() && color.getBlue() >= color.getGreen()){
            return (int) (MAX_RGB_VALUE * factor);
        } else {
            return MIN_RGB_VALUE;
        }
    }
}
