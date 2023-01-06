/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

package org.aau.pini.capstone.algorithms;

import java.awt.*;

public class Exposure extends ImageAlgorithm {
    Exposure() {
        this.name = "Exposure";
        this.minimumFactor = -1;
        this.maximumFactor = 1;
    }
    @Override
    public int calculateRed(Color color) {
        return checkColorValueRange(color.getRed() * (factor + 1));
    }

    @Override
    public int calculateGreen(Color color) {
        return checkColorValueRange(color.getGreen() * (factor + 1));
    }

    @Override
    public int calculateBlue(Color color) {
        return checkColorValueRange(color.getBlue() * (factor + 1));
    }
}
