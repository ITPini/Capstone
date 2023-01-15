/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

package org.aau.pini.capstone.algorithms;

import java.awt.*;
// TODO: Change to no modifier
public interface ColorAlgorithm {
    /**
     * Calculates the red value of the new color.
     * @param color - The color to be modified
     * @return - The modified color as an integer
     */
    int calculateRed(Color color);

    /**
     * Calculates the green value of the new color.
     * @param color - The color to be modified
     * @return - The modified color as an integer
     */
    int calculateGreen(Color color);

    /**
     * Calculates the blue value of the new color.
     * @param color - The color to be modified
     * @return - The modified color as an integer
     */
    int calculateBlue(Color color);
}
