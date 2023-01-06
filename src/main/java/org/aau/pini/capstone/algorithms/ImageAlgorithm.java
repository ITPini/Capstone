/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

package org.aau.pini.capstone.algorithms;

import java.awt.*;

public abstract class ImageAlgorithm implements ColorAlgorithm {
    protected final int MAX_RGB_VALUE = 255;
    protected final int MIN_RGB_VALUE = 0;

    protected int minimumFactor, maximumFactor;
    protected float factor;
    protected String name;

    public ImageAlgorithm() {
    }

    @Override
    public int calculateRed(Color color) {
        return color.getRed();
    }

    @Override
    public int calculateGreen(Color color) {
        return color.getGreen();
    }

    @Override
    public int calculateBlue(Color color) {
        return color.getBlue();
    }

    /**
     * Checks if the color value is within the range of minimumFactor & maximumFactor
     * @param factor - The factor to be checked
     * @return - The factor if it is within the range, otherwise the closest value to minimumFactor or maximumFactor
     */
    private float checkFactorRange(float factor) {
        if (factor > maximumFactor) {
            return maximumFactor;
        } else if (factor < minimumFactor) {
            return minimumFactor;
        } else {
            return factor;
        }
    }

    /**
     * Checks if the color value is within the range of MIN_RGB_VALUE & MAX_RGB_VALUE
     * @param colorValue - The color value to check
     * @return - The color value if it is within the range, otherwise the closest value to MIN_RGB_VALUE or MAX_RGB_VALUE
     */
    protected final int checkColorValueRange(float colorValue) {
        if (colorValue > MAX_RGB_VALUE) {
            return MAX_RGB_VALUE;
        } else if (colorValue < MIN_RGB_VALUE) {
            return MIN_RGB_VALUE;
        } else {
            return (int) colorValue;
        }
    }

    /**
     * Sets the factor of the algorithm (modified mutator method)
     * Uses checkFactorRange to ensure that the factor is within the range of the algorithm.
     * This method should not
     * @param factor - The factor to be set.
     */
    public final void setFactor(float factor) {
        this.factor = checkFactorRange(factor);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public float getFactor() {
        return factor;
    }

    public void setMinimumFactor(int minimumFactor) {
        this.minimumFactor = minimumFactor;
    }

    public void setMaximumFactor(int maximumFactor) {
        this.maximumFactor = maximumFactor;
    }

    public int getMinimumFactor() {
        return minimumFactor;
    }

    public int getMaximumFactor() {
        return maximumFactor;
    }

    /**
     * Overrides the toString method of ListView class to display the name of the algorithm
     * @return - The name of the algorithm
     */
    @Override
    public String toString() {
        return name;
    }
}
