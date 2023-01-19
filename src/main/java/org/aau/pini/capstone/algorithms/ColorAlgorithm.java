package org.aau.pini.capstone.algorithms;

import java.awt.Color;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
interface ColorAlgorithm {
    int MAX_RGB_VALUE = 255;
    int MIN_RGB_VALUE = 0;
    /**
     * Calculates the red value of the new color.
     * @param color - The color to be modified
     * @return - The modified color as an integer
     */
    default int calculateRed(Color color){
        return color.getRed();
    }

    /**
     * Calculates the green value of the new color.
     * @param color - The color to be modified
     * @return - The modified color as an integer
     */
    default int calculateGreen(Color color){
        return color.getGreen();
    }

    /**
     * Calculates the blue value of the new color.
     * @param color - The color to be modified
     * @return - The modified color as an integer
     */
    default int calculateBlue(Color color){
        return color.getBlue();
    }
}
