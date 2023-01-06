/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

package org.aau.pini.capstone.algorithms;

import java.awt.*;

public class Contrast extends ImageAlgorithm {
    Contrast() {
        this.name = "Contrast";
        this.minimumFactor = -1;
        this.maximumFactor = 1;
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
